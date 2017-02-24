package com.leetcode;

/**
 * Created by liubo16 on 2017/2/24.
 */
public class DetectCapital {

    private String AAA = "AAA";
    private String Aaa = "Aaa";
    private String aaa = "aaa";

    public static void main(String[] args) {
        System.out.println(detectCapitalUse("leeTCode"));
    }

    private static boolean detectCapitalUse(String word) {
        char ch1 = word.charAt(0);
        char ch2 = word.charAt(1);

        String temp = "";
        if (ch1 >= 'A' && ch1 <= 'Z') {
            temp += "A";
        } else {
            temp += "a";
        }

        if (ch2 >= 'A' && ch2 <= 'Z') {
            temp += "A";
        } else {
            temp += "a";
        }
        if ("Aa".equals(temp) || "aa".equals(temp)) {
            temp += checkOther(word.substring(2), "a");
        } else {
            temp += checkOther(word.substring(2), "A");
        }
        System.out.println("==================="+temp);
        return "AAA".equals(temp) || "Aaa".equals(temp) || "aaa".equals(temp);

    }

    private static String checkOther(String word, String target) {
        String temp = "";
        if (word.length()==0) {
            return temp;
        }
        char w = word.charAt(0);
        System.out.println("-----------w "+w);
        if (w >= 'A' && w <= 'Z') {
            temp = "A";
        } else {
            temp = "a";
        }
        System.out.println("temp = "+temp +" target = "+target);
        if (!temp.equals(target)) {
          return "";
        }
        String str = checkOther(word.substring(1), target);
        System.out.println("=========str "+str);
        return temp;

    }
}
