package com.HuffmanBianma;


import java.util.*;

/**
 * 赫夫曼编码
 */
public class HuffmanCode {
    public static void main(String[] args) {
        String str = "can you can a can as a can canner can a can.";
        byte[] bytes = str.getBytes();
        //进行赫夫曼编码过后的数组。就是对其进行压缩。
        byte[] b = huffmanZip(bytes);
        //使用赫夫曼编码进行解码。
        byte[] decoding = decode(huffCodes, b);
        System.out.println(Arrays.toString(bytes));
        System.out.println(Arrays.toString(decoding));
        System.out.println(new String(decoding));
    }

    /**
     * 使用赫夫曼编码进行解码。
     * @param huffCodes
     * @param bytes
     * @return
     */
    private static byte[] decode(Map<Byte, String> huffCodes, byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();
        //把byte数组转换成一个二进制的字符串
        for (int i = 0; i < bytes.length;i++) {
            byte b = bytes[i];
            //是不是最后一个
            boolean flag = (i == bytes.length - 1);
            //不是最后一个要进行补齐。
            stringBuilder.append(byteToBitStr(!flag, b));
        }
        //把字符串按照指定的赫夫曼编码进行解码
        //把赫夫曼编码的键值对进行调换。
        Map<String, Byte> map = new HashMap<>();
        for (Map.Entry<Byte, String> entry : huffCodes.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }
        //创建一个集合，用于存byte
        List<Byte> list = new ArrayList<>();
        //处理字符串
        for (int i = 0; i < stringBuilder.length();) {
            int count=1;
            boolean flag =true;
            Byte b=null;
            //截取出一个byte.因为要循环截取
            while (flag) {
                String key = stringBuilder.substring(i, i + count);
                b = map.get(key);
                if (b == null) {
                    count++;
                }else {
                    flag=false;
                }
            }
            list.add(b);
            i+=count;
        }
        //把集合转为数组
        byte[] b = new byte[list.size()];
        for (int i=0;i<b.length;i++){
            b[i] = list.get(i);
        }
        return b;
    }

    private static String byteToBitStr(boolean flag,byte b){
        int temp=b;
        if(flag){
            //按位或一下256.因为256转换成二进制是1 0000 0000  拿1进行或的话。后面就是8个0.这样不足8位的就可以用0补齐了。
            temp |=256;
        }
        String string = Integer.toBinaryString(temp);
        if(flag){
            return string.substring(string.length()-8);
        }
        return string;
    }
    /**
     * 进行赫夫曼编码压缩的方法
     * @param bytes
     * @return
     */
    private static byte[] huffmanZip(byte[] bytes) {
        //先统计每一个byte出现的次数，并放入到一个集合中。
        List<Node> nodeList = getNodes(bytes);
        //创建一颗赫夫曼树。
        Node tree = createHuffmanTree(nodeList);
        //创建一个赫夫曼编码表。
        Map<Byte, String> huffCodes = getCodes(tree);
        //编码。
        byte[] b = zip(bytes, huffCodes);
        return b;
    }

    /**
     *  进行赫夫曼编码
     * @param bytes
     * @param huffCodes
     * @return
     */
    private static byte[] zip(byte[] bytes, Map<Byte, String> huffCodes) {
        StringBuilder sb = new StringBuilder();
        //把需要压缩的byte数组处理成一个二进制的字符串。
        for (byte b : bytes) {
            sb.append(huffCodes.get(b));
        }
        //定义长度
        int len;
        if (sb.length() % 8 == 0) {
            len=sb.length()/8;
        }else {
            len=sb.length()/8+1;
        }
        //用于存储压缩后的byte
        byte[] bytes1 = new byte[len];
        //记录新byte的位置
        int index = 0;
        for(int i=0;i<sb.length();i+=8){
            String substring;
            if(i+8>sb.length()){
                substring = sb.substring(i);
            }else {
                substring = sb.substring(i,i+8);
            }
            byte byt=(byte) Integer.parseInt(substring, 2);
            bytes1[index] = byt;
            index++;
        }
        return bytes1;
    }

    //用于存储临时路径。
    static StringBuilder sb = new StringBuilder();
    //用于存储赫夫曼编码
    static Map<Byte, String> huffCodes = new HashMap<>();


    /**
     * 根据赫夫曼树得到赫夫曼编码。
     * @param tree
     * @return
     */
    private static Map<Byte, String> getCodes(Node tree) {
        if (tree == null) {
            return null;
        }
        getCodes(tree.left, "0", sb);
        getCodes(tree.right, "1", sb);
        return huffCodes;
    }

    private static void getCodes(Node node, String code, StringBuilder sb) {
        StringBuilder stringBuilder = new StringBuilder(sb);
        stringBuilder.append(code);
        if (node.data == null) {
            getCodes(node.left, "0", stringBuilder);
            getCodes(node.right, "1", stringBuilder);
        } else {
            huffCodes.put(node.data, stringBuilder.toString());
        }
    }

    /**
     * 创建赫夫曼树。
     *
     * @param nodeList
     * @return
     */
    private static Node createHuffmanTree(List<Node> nodeList) {
        while (nodeList.size() > 1) {
            //排序。
            Collections.sort(nodeList);
            //取出最小的两个节点。
            Node left = nodeList.get(nodeList.size() - 1);
            Node right = nodeList.get(nodeList.size() - 2);
            //创建一个新的二叉树。
            Node node = new Node(null, left.weight + right.weight);
            //把这两个左右节点赋值给新的二叉树的左右节点。
            node.left = left;
            node.right = right;
            //删除这两个左右节点。
            nodeList.remove(left);
            nodeList.remove(right);
            //放在集合中。
            nodeList.add(node);
        }
        return nodeList.get(0);
    }

    /**
     * 把bytes转换成list集合。并统计每一个字符出现的次数。
     *
     * @param bytes
     * @return
     */
    private static List<Node> getNodes(byte[] bytes) {
        List<Node> nodes = new ArrayList<>();
        Map<Byte, Integer> counts = new HashMap<>();
        for (byte b : bytes) {
            Integer integer = counts.get(b);
            if (integer == null) {
                counts.put(b, 1);
            } else {
                counts.put(b, integer + 1);
            }
        }
        //map中键就是node对象的字符。值就是权值。出现的次数
        for (Map.Entry<Byte, Integer> me : counts.entrySet()) {
            nodes.add(new Node(me.getKey(), me.getValue()));
        }
        return nodes;
    }
}
