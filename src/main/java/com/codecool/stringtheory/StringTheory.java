package com.codecool.stringtheory;

import java.util.Collections;
import java.util.LinkedList;

public class StringTheory {

    private static boolean isPalindrome(String str){
        String str1 = str.toLowerCase().replaceAll("[^A-Za-z]",""); // Make all letters lowercase, replace every non-letter characters with nothing
        char[] letters =str1.toCharArray();
        char[] lettersInverse=new char[letters.length];
        for (int i = letters.length-1, k=0; i >= 0 ; i--) {
            lettersInverse[k]=letters[i];
            k++;
        }
        for (int i = 0; i<letters.length; i++){
            if(letters[i]!=lettersInverse[i]){
                return false;
            }
        }
        return true;
    }

    private static boolean isIsogram(String str) {
        char[] letters = str.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            for (int j = i+1; j < letters.length; j++) {
                if (letters[i]==letters[j]){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isPangram(String str) {
        String str1 = str.toLowerCase().replaceAll("[^A-Za-z]","");
        char[] letters = str1.toCharArray();
        char[] allLettes = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        for (char letter : allLettes){
            for (int i = 0; i < letters.length; i++) {
                if(letter==letters[i]){
                    break;
                }
                if (i==letters.length-1){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isAnagram(String str1, String str2) {
        String str1Transform = str1.toLowerCase().replaceAll("[^A-Za-z]","");
        String str2Transform = str2.toLowerCase().replaceAll("[^A-Za-z]","");

        char[] str1CharArray = str1Transform.toCharArray();
        char[] str2CharArray = str2Transform.toCharArray();

        LinkedList<Character> str1List = new LinkedList<>();
        LinkedList<Character> str2List = new LinkedList<>();

        for(char letter : str1CharArray){
            str1List.add(letter);
        }
        for(char letter : str2CharArray){
            str2List.add(letter);
        }

        Collections.sort(str1List);
        Collections.sort(str2List);

        if(str1List.size()!=str2List.size()){
            return false;
        }else {
            for (int i =0; i<str1List.size(); i++){
                if(str1List.get(i)!=str2List.get(i)){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isBlanagram(String str1, String str2) {

        String str1Transform = str1.toLowerCase().replaceAll("[^A-Za-z]","");
        String str2Transform = str2.toLowerCase().replaceAll("[^A-Za-z]","");

        char[] str1CharArray = str1Transform.toCharArray();
        char[] str2CharArray = str2Transform.toCharArray();

        LinkedList<Character> str1List = new LinkedList<>();
        LinkedList<Character> str2List = new LinkedList<>();

        for(char letter : str1CharArray){
            str1List.add(letter);
        }
        for(char letter : str2CharArray){
            str2List.add(letter);
        }

        Collections.sort(str1List);
        Collections.sort(str2List);

        if(str1List.size()!=str2List.size()){
            return false;
        }else {
            for (int i =0; i<str1List.size(); i++){
                for (int j = 0; j < str2List.size() ; j++) {
                    if(str1List.get(i)==str2List.get(j)){
                        str1List.remove(i);
                        str2List.remove(j);
                        i=0;
                        j=0;
                    }

                }
            }
        }

        return str1List.size() == str2List.size();
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("Mr. Owl ate my metal worm")); // True
        System.out.println(isPalindrome("Eva, can I see bees in a cave?")); // True
        System.out.println(isIsogram("uncopyrightables")); // True
        System.out.println(isPangram("The quick brown fox jumps over the lazy dog")); // True
        System.out.println(isAnagram("Justin Timberlake", "I'm a jerk but listen")); // True
        System.out.println(isBlanagram("Justin Timberlake", "I'm a berk but listen")); // True
    }
}
