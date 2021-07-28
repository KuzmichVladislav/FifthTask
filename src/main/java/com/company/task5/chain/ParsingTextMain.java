package com.company.task5.chain;

import com.company.task5.entity.ComponentType;
import com.company.task5.entity.TextComposite;
import com.company.task5.service.TextService;

public class ParsingTextMain {
    public static void main(String[] args) throws Exception {
        String text = "\tIt has survived - not only (five) centuries, but also the leap into electronic " +
                "typesetting, remaining essentially unchanged. It was popularised in the “Динамо” (Рига) " +
                "with the release of Letraset sheets.toString() containing Lorem Ipsum passages, and " +
                "more recently with desktop publishing software like Aldus PageMaker Faclon9 " +
                "including versions of Lorem Ipsum!" +
                "\tIt is a long a != b established fact that a reader will be distracted by the readable " +
                "content of a page when looking at its layout. The point of using Ipsum is that it has a " +
                "more-or-less normal distribution ob.toString(a?b:c), as opposed to using (Content here), " +
                "content here's, making it look like readable English?" +
                "\tBye бандерлоги. " +
                "\tIt is a established fact that a reader will be of a page when looking at its layout...";
        TextComposite structure = new TextComposite(ComponentType.TEXT);
        //ParagraphParser parser = new ParagraphParser();

        AbstractParser parser = TextParserFactory.createParser();
        parser.parse(structure, text);
      //  System.out.println(structure.;
        //System.out.println(structure.values().length);
       // System.out.println(structure.getChildren());
        //System.out.println(structure.getChildren());
        //System.out.println(structure.getComponentType());
        //System.out.println(structure.count());
        //System.out.println(structure.getChildren());

        TextService ts = new TextService();
        System.out.println(ts.findSentencesWithLongestWord(structure));
       //System.out.println(structure);

    }
}
