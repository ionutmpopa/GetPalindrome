package com.iopo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

public class Palindrome<T extends Integer> {


    public List<String> readFromFile(Path thePath) {

        List<String> myPalindromeList = new LinkedList<>();
        String line;
        Charset charset = StandardCharsets.UTF_8;
        try (BufferedReader reader = Files.newBufferedReader(thePath, charset)) {
            while ((line = reader.readLine()) != null) {
                myPalindromeList.add(line);
            }
            return myPalindromeList;
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
            return null;
        }
    }

    public boolean isPalindrome(String str) {

        try {

            if ((str.isEmpty()) || (str.matches(" *"))) {
                return false;
            }

            String trimString = str.replaceAll("[^A-Za-z]", "");
            char[] strToCharArray = trimString.toCharArray();
            char[] reverseStrToChar = new char[strToCharArray.length];
            int j = strToCharArray.length;

            for (int i = 0; i < strToCharArray.length; i++) {
                reverseStrToChar[j - 1] = strToCharArray[i];
                j--;
            }
            String reverseString = String.valueOf(reverseStrToChar);
            return trimString.equalsIgnoreCase(reverseString);
        } catch (NullPointerException e) {
            return false;
        }
    }

    public void sumUpElementsOfEqualLists(List<Integer> list1, List<Integer> list2, List<Integer> targetList) {

        int sum;
        int remainder = 0;
        for (int i = list1.size() - 1; i >= 0; i--) {
            if (list2.size() >= i) {
                if ((list1.size() == 1) && (list2.size() == 1)) {
                    sum = list1.get(i) + list2.get(i);
                } else {
                    sum = list1.get(i) + list2.get(i) + remainder;
                    remainder = sum / 10;
                    sum = sum % 10;
                }
                targetList.add(0, sum);

            } else {
                targetList.add(0, list1.get(i));
            }
        }
    }

    public void sumUpElementsOfUnequalLists(List<Integer> smallerList, List<Integer> biggerList, List<Integer> targetList) {

        int sum;
        int remainder = 0;
        int addRemainder;
        final int diff = biggerList.size() - smallerList.size();

        for (int i = biggerList.size() - 1; i >= 0; i--) {
            if ((i - diff) >= 0) {
                sum = smallerList.get(i - diff) + biggerList.get(i) + remainder;
                remainder = sum / 10;
                sum = sum % 10;
                targetList.add(0, sum);
            } else if (remainder > 0) {
                addRemainder = biggerList.get(i) + remainder;
                remainder = addRemainder / 10;
                addRemainder = addRemainder % 10;
                targetList.add(0, addRemainder);
            } else {
                targetList.add(0, biggerList.get(i));
            }
        }
    }

    public int findMaximumNumber(int number) {

        Integer n;
        Integer[] intArr = new Integer[String.valueOf(number).length()];

        int counter = 0;
        while (number != 0) {

            n = number % 10;
            intArr[counter] = n;
            number = number / 10;
            counter++;
        }
        orderArray(intArr);
        return intArr[0];
    }


    public <T extends Comparable<T>> T[] orderArray(T[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i].compareTo(arr[j]) < 0) {
                    T temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public void writeToFile(List<String> list, Path isPalindromeFile, Path isNotPalindromeFile) {

        Charset charset = StandardCharsets.UTF_8;
        try (BufferedWriter writerPal = Files.newBufferedWriter(isPalindromeFile, charset);
             BufferedWriter writerNotPal = Files.newBufferedWriter(isNotPalindromeFile, charset)) {
            int counter = 0;
            for (String line : list) {
                if (isPalindrome(line)) {
                    writerPal.write((counter + 1) + ". " + line + "\n");
                    System.out.println((counter + 1) + ". " + line + "--> A palindrome!");
                    counter++;
                } else {
                    writerNotPal.write((counter + 1) + ". " + line + "\n");
                    System.out.println((counter + 1) + ". " + line + "--> Not a palindrome!");
                    counter++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}