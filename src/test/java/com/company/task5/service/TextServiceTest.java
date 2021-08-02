/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.task5.service;

import com.company.task5.chain_of_responsibility_parser.AbstractParser;
import com.company.task5.chain_of_responsibility_parser.TextParserFactory;
import com.company.task5.entity.ComponentType;
import com.company.task5.entity.TextComponent;
import com.company.task5.entity.TextComposite;
import com.company.task5.exception.CompositeException;
import com.company.task5.reader.DataReader;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TextServiceTest {

    private static final String RELATIVE_FILE_PATH = "data/text.txt";
    ClassLoader classLoader = TextServiceTest.class.getClassLoader();
    URL resource = classLoader.getResource(RELATIVE_FILE_PATH);
    String absolutePath = new File(resource.getFile()).getAbsolutePath();
    DataReader reader = new DataReader();
    String text = reader.readFromFile(absolutePath);

    TextComposite structure = new TextComposite(ComponentType.TEXT);

    AbstractParser parser = TextParserFactory.createParser();

    public TextServiceTest() throws CompositeException {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @Before
    public void setUp() {
        parser.parse(structure, text);
    }

    @Test
    public void testSortParagraphsBySentenceAmount() {
        System.out.println("sortParagraphsBySentenceAmount");
        TextService instance = new TextService();
        List<TextComponent> expResult = null;
        List<TextComponent> result = instance.sortParagraphsBySentenceAmount(structure);
        assertEquals(expResult, result);
        // fail("The test case is a prototype.");
    }

    @Test
    public void testFindSentencesWithLongestWord() throws Exception {
        System.out.println("findSentencesWithLongestWord");
        // TextComponent text = null;
        TextService instance = new TextService();
        List<TextComponent> expResult = null;
        List<TextComponent> result = instance.findSentencesWithLongestWord(structure);
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
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

    @Test
    public void sortParagraphsBySentenceAmount() {
    }

    @Test
    public void findSentencesWithLongestWord() {
    }

    @Test
    public void removeSentencesWithLessNumber() {
    }

    @Test
    public void findIdenticalWords() {
    }

    @Test
    public void countVowelsAndConsonants() {
    }
}
