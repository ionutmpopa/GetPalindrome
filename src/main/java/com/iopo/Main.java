package com.iopo;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Path thePath = Paths.get("resources/checkPalindromes.txt");
        Path palindromes = Paths.get("resources/palindromes.txt");
        Path notPalindromes = Paths.get("resources/NOTpalindromes.txt");
        Palindrome palindrome = new Palindrome();

        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        List<Integer> c = new ArrayList<>();

//        a.add(1);
//        a.add(1);
        a.add(9);
        a.add(1);


//        b.add(1);
//        b.add(1);
        b.add(1);
        b.add(9);

        if (a.size() == b.size()) {
            palindrome.sumUpElementsOfEqualLists(a, b, c);
        } else if (a.size() < b.size()) {
            palindrome.sumUpElementsOfUnequalLists(a, b, c);
        } else {
            palindrome.sumUpElementsOfUnequalLists(b, a, c);
        }

        for (Integer myInt : c) {
            System.out.print(myInt);
        }


//        Palindrome palindrome = new Palindrome();
//        List<String> palindromeList = palindrome.readFromFile(thePath);
//        palindrome.writeToFile(palindromeList, palindromes, notPalindromes);
    }
}
