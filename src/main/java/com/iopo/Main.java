package com.iopo;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Path thePath = Paths.get("resources/checkPalindromes.txt");
        Path palindromes = Paths.get("resources/palindromes.txt");
        Path notPalindromes = Paths.get("resources/NOTpalindromes.txt");

        com.iopo.Palindrome palindrome = new com.iopo.Palindrome();
        List<String> palindromeList = palindrome.readFromFile(thePath);
        palindrome.writeToFile(palindromeList, palindromes, notPalindromes);

//        if (myTrue() && !myFalse()) {
//            System.out.println(myTrue());
//            System.out.println(myFalse());
//        }
//
//        if (myTrue() && myFalse()) {
//            System.out.println(myTrue());
//            System.out.println(myFalse());
//        }
//
//        if (!myTrue() && !myFalse()) {
//            System.out.println(myTrue());
//            System.out.println(myFalse());
//        }
//
//        if (!myTrue() && myFalse()) {
//            System.out.println(myTrue());
//            System.out.println(myFalse());
//        }

        //if (!myTrue() && myFalse()) {myTrue(); myFalse();}

        //if (!myTrue() && !myFalse()) {myTrue(); myFalse();}


    }

    public static boolean myTrue() {

        String str = "Execute True RETURN";
        //System.out.println(str);
        return true;

    }

    public static boolean myFalse() {

        String str = "Execute False RETURN";
        //System.out.println(str);
        return false;

    }
}
