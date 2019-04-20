package com.BinarySortTree;

public class BinarySortTree {
    //根节点
    Node root;
    /**
     * 向二叉排序树中添加节点
     */
    public void add(Node node) {
        //如果是一颗空树，就添加到根节点
        if (root == null) {
            root = node;
        }
            else {
                root.add(node);
            }
    }
    /**
     * 中序遍历
     */
    public void midShow(){
        if (root != null) {
            root.midShow(root);
        }
    }

    /**
     * 查找
     * @param value
     */
    public Node search(int value) {
        //如果这是一颗空树，直接返回null
        if (root == null) {
            return null;
        } else {
            //不为空，去上子树上进行查询
           return root.search(value);
        }
    }

    /**
     * 删除一个节点。有三种情况。
     * 1）：删除叶子节点。直接删除。就是父节点指向null
     * 2）：删除只有一个叶子的子树。把那个节点删除掉。然后叶子节点代替它。
     * 3）：删除两个叶子的子树。删除这个节点的右子树的左节点。如果左节点还有右节点的话。就把这个右节点替换成右子树的左节点。
     * @param value
     */
    public void delete(int value) {
        if (root == null) {
            return;
        } else {
            //找到这个节点
            Node node = root.search(value);
            if (node == null) {
                return;
            }
            //找到这个节点的父节点
            Node parent = root.searchParent(value);
            //如果是叶子节点。父节点直接就赋值为null就删除掉了。
            if (node.left == null && node.right == null) {
                if (parent.left.value == value) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
                //有两个叶子节点
            } else if (node.left != null && node.right != null) {
                //删除右子树中最小的节点,所以传入的是这个节点的右节点。
                int min = deleteMin(node.right);
                //替换目标
                node.value=min;
                //只剩下只有一个叶子节点
            } else {
                //如果是左子节点
                if (node.left != null) {
                        if (parent.left.value == value) {
                            parent.left = node.left;
                        } else {
                            parent.right = node.left;
                        }
            }
            //如果是右子节点
                if (node.right != null) {
                    if (parent.left.value == value) {
                        parent.left = node.right;
                    } else {
                        parent.right = node.right;
                    }
                }
                }  } }

    /**
     * 找到这个节点的右子树的左子节点的右子节点。然后把它的值给返回出来。以便于放到右子树的左子节点。
     * @param node
     * @return
     */
    private int deleteMin(Node node) {
        Node target = node;
        //递归向后面找最小的左子节点
        while (target.left != null) {
            target=target.left;
        }
        //删除最小的这个节点
        delete(target.value);
        //因为假如右子树的最小左子节点还有一个右节点。删除后就把它替换成左子节点了。所以返回的是这个左子节点的右节点。
        return target.value;
    }

    /**
     * 查找这个这个节点的父节点。
     * @param value
     * @return
     */
    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }


    public static void main(String[] args) {
        int[] arr = {8, 4, 11,6, 9, 1,14,10};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i : arr) {
            binarySortTree.add(new Node(i));
        }
        binarySortTree.midShow();
        System.out.println("----------");
        Node search = binarySortTree.search(11);
        System.out.println(search);
        Node search1 = binarySortTree.search(22);
        System.out.println(search1);
        Node node = binarySortTree.searchParent(14);
        System.out.println(node);
        System.out.println("---------");
        binarySortTree.delete(8);
        binarySortTree.midShow();
        int height = binarySortTree.root.height();
        System.out.println(height);
    }
}
