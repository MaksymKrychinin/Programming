package com.piv.blackjack;

import static java.lang.Math.pow;

public class Main {
    public static void main(String[] args) {
        try {
            String s = "-CAFE";
            System.out.println(Translator.hexStringToInt(s));
            s = "The user with the nickname koala757677 this month wrote 3 times " +
                    "more comments than the user with the nickname croco181dile920 4 months ago";
            System.out.println(CaseChanger.toLowerCase(s));

            int i = 511;
            s = "The user with the nickname koala757677 this month wrote 3 times " +
                    "more comments than the user with the nickname croco181dile920 4 months ago";
            System.out.println(Translator.intTo8String(i));
            System.out.println(CaseChanger.toUpperCase(s));
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

class Translator {
    static int hexStringToInt(String s) {
        int isMinus=0;
        if(!s.matches("-?[\\dABCDEF]*")){
            throw new IllegalArgumentException("Не правельный аргумент");
        }
        if (s.matches("-[\\dABCDEF]*")){
            s=s.substring(1);
            isMinus++;
        }

        char[] symbolArray = s.toCharArray();
        char[] reversedSymbolArray = new char[symbolArray.length];
        for (int i = symbolArray.length - 1, k = 0; k < symbolArray.length; i--, k++) {
            reversedSymbolArray[k] = symbolArray[i];
        }
        char[] symbolEquals = {1, 2, 3, 4, 5, 6, 7, 8, 9, 'A', 'B', 'C', 'D', 'E', 'F'};
        int sum = 0;
        for (int i = 0; i < reversedSymbolArray.length; i++) {//i - розряд
            int index = 0;
            for (int j = 0; j < symbolEquals.length; j++, index++) {
                if (reversedSymbolArray[i] == symbolEquals[j]) {
                    break;
                }
            }
            index++;
            sum += index * pow(16, i);
        }
        if (isMinus==1){
            sum*=-1;
        }
        return sum;
    }

    static String intTo8String(int toTranslate) {
        StringBuilder sb = new StringBuilder();
        while (toTranslate >= 1) {
            sb.append(toTranslate % 8);
            toTranslate /= 8;
        }
        sb.reverse();
        return sb.toString();
    }
}

class CaseChanger {
    static String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        String[] words = s.split("\s*(\s|,|!|\\.)\s*");

        for (int i = 0; i < words.length; i++) {
            boolean a = true;
            for (char c : words[i].toCharArray()) {
                if (Character.isDigit(c)) {
                    a = false;
                }
            }
            if (a) {
                words[i] = words[i].toLowerCase();
            }
        }
        for (String i : words) {
            sb.append(i + " ");
        }
        return sb.toString();
    }

    static String toUpperCase(String s) {
        if (s == null) {
            throw new NullPointerException();
        }
        StringBuilder sb = new StringBuilder();
        String[] words = s.split(" ");

        for (int i = 0; i < words.length; i++) {
            boolean a = true;
            for (char c : words[i].toCharArray()) {
                if (Character.isDigit(c)) {
                    a = false;
                }
            }
            if (a) {
                words[i] = words[i].toUpperCase();
            }
        }
        for (String i : words) {
            sb.append(i + " ");
        }
        return sb.toString();
    }
}
