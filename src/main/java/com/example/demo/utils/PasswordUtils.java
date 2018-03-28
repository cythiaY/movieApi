package com.example.demo.utils;


import java.security.NoSuchAlgorithmException;

public class PasswordUtils {

    public static String getStudentPassword(String password) {
        return convertMD5(convertMD5(password));
    }

    public static String convertMD5(String inStr){

        char[] a = inStr.toCharArray();
        for (int i = 0; i < a.length; i++){
            a[i] = (char) (a[i] ^ 't');
        }
        String s = new String(a);
        return s;

    }

    public static void main(String[] args) throws NoSuchAlgorithmException {

        String s = "0708227";
        System.out.println("原始：" + s);
//        System.out.println("MD5后：" + string2MD5(s));
        System.out.println("加密的：" + convertMD5(s));
        System.out.println("解密的：" + convertMD5(convertMD5(s)));
    }
}
