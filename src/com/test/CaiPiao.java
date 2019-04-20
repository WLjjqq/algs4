package com.test;

import java.util.ArrayList;
import java.util.List;

public class CaiPiao {
    public static void main(String[] args) {

        int str[]={57,17,69,45,1012,23,711,27,14,34,712,25,311,45,910,48,56,12,710,38,69,25,89,110,512,24,1011,46,56,812};
        List<Integer> list = new ArrayList<Integer>();
        for (int i=0; i<str.length; i++) {
            if(!list.contains(str[i])) {
                list.add(str[i]);
            }
        }
        System.out.println("去除重复后的list集合"+list);

    }
}
