package com.iopo;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class PalindromeParamTest {

    private com.iopo.Palindrome palindrome;
    private String inputString;
    private boolean expectedResult;

    public PalindromeParamTest(String inputString, boolean expectedResult) {
        this.inputString = inputString;
        this.expectedResult = expectedResult;
    }

    @Before
    public void setUp() throws Exception {
        palindrome = new com.iopo.Palindrome();
    }

    @Parameterized.Parameters
    public static Collection paramPalindrome() {

        return Arrays.asList(new Object[][]{
                {"Madam", true},
                {"Eu", false},
                {"Australopithecus", false},
                {"Cinic", true},
                {"cIvIc", true},
                {"A man, a plan, a canal: Panama!", true},
                {"He did, eh?", true},
                {"", false},
                {null, false},
                {"", false},
                {" ", false}
        });
    }


    @Test
    public void whenPassString_returnBoolean() {

        Boolean result = palindrome.isPalindrome(inputString);
        Assert.assertEquals(expectedResult, result);
    }
}