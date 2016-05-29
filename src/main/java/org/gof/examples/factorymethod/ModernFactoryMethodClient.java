package org.gof.examples.factorymethod;

import org.gof.examples.factorymethod.gof.Document;
import org.gof.examples.factorymethod.gof.DocumentFactory;
import org.gof.examples.factorymethod.gof.JsonDocument;

import java.util.function.Function;


public class ModernFactoryMethodClient {
    public static void main(String[] args) {
        DocumentFactory factory = JsonDocument::new;
        printUserDetails(factory.create("USER"));

        Function<String, Document> plainFactory = JsonDocument::new;
        printUserDetails(plainFactory.apply("USER"));
    }

    private static void printUserDetails(Document document) {
        document.addField("name", "Test");
        document.addField("surname", "TEST");
        System.out.println(document);
    }
}
