package org.gof.examples.factorymethod.gof;

public class JsonDocumentFactory implements DocumentFactory {
    @Override
    public Document create(String name) {
        return new JsonDocument(name);
    }
}
