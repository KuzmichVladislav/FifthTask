/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.task5.service;

import com.company.task5.entity.TextComponent;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kon
 */
public class TextServiceTest {
    
    public TextServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testSortParagraphsBySentenceAmount() {
        System.out.println("sortParagraphsBySentenceAmount");
        TextComponent text = null;
        TextService instance = new TextService();
        List<TextComponent> expResult = null;
        List<TextComponent> result = instance.sortParagraphsBySentenceAmount(text);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testFindSentencesWithLongestWord() throws Exception {
        System.out.println("findSentencesWithLongestWord");
        TextComponent text = null;
        TextService instance = new TextService();
        List<TextComponent> expResult = null;
        List<TextComponent> result = instance.findSentencesWithLongestWord(text);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRemoveSentencesWithLessNumber() {
        System.out.println("removeSentencesWithLessNumber");
        TextComponent text = null;
        int wordСount = 0;
        TextService instance = new TextService();
        List<TextComponent> expResult = null;
        List<TextComponent> result = instance.removeSentencesWithLessNumber(text, wordСount);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testFindIdenticalWords() {
        System.out.println("findIdenticalWords");
        TextComponent text = null;
        TextService instance = new TextService();
        Map<String, Integer> expResult = null;
        Map<String, Integer> result = instance.findIdenticalWords(text);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCountVowelsAndConsonants() {
        System.out.println("countVowelsAndConsonants");
        TextComponent sentence = null;
        TextService instance = new TextService();
        String expResult = "";
        String result = instance.countVowelsAndConsonants(sentence);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
