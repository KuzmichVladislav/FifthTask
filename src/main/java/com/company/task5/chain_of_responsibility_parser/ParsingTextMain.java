package com.company.task5.chain_of_responsibility_parser;

import com.company.task5.entity.ComponentType;
import com.company.task5.entity.TextComposite;
import com.company.task5.reader.DataReader;
import com.company.task5.service.TextService;

import java.io.File;
import java.net.URL;

public class ParsingTextMain {

    private static final String RELATIVE_FILE_PATH = "data/text.txt";

    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = ParsingTextMain.class.getClassLoader();
        URL resource = classLoader.getResource(RELATIVE_FILE_PATH);
        assert resource != null;
        String absolutePath = new File(resource.getFile()).getAbsolutePath();
        DataReader reader = new DataReader();
        String text = reader.readFromFile(absolutePath);

        TextComposite structure = new TextComposite(ComponentType.TEXT);

        AbstractParser parser = TextParserFactory.createParser();
        parser.parse(structure, text);

        System.out.println(structure);
        //for (int i = 0; i < structure.getChildren().size(); i++) {
        //  System.out.println(structure.getChildren().get(i).getComponentType());
        //System.out.println(structure.getChildren().get(i));
        // }
        //System.out.println(structure.values().length);
        // System.out.println(structure.getChildren());
        //System.out.println(structure.getChildren());
        //System.out.println(structure.getComponentType());
        //System.out.println(structure.count());
        //System.out.println(structure.getChildren());
        TextService ts = new TextService();
        // System.out.println(ts.sortParagraphsBySentenceAmount(structure));
        //  System.out.println(ts.findSentencesWithLongestWord(structure));
        //System.out.println(ts.removeSentencesWithLessNumber(structure, 30));
        //System.out.println(structure);
        //System.out.println(ts.findIdenticalWords(structure));
        //System.out.println(ts.countVowelsAndConsonants(structure.getChildren().get(3)));
//System.out.println(structure.getChildren().get(3));
    }
}
