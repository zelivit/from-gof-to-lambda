package org.gof.examples.factorymethod.gof;

public class TemplateMethodClient {
    public static void main(String[] args) {
        DocumentFactory factory = new JsonDocumentFactory();
        Document document = factory.create("USER");
        document.addField("name", "Test");
        document.addField("surname", "TestTest");
        System.out.println(document);
    }
}
