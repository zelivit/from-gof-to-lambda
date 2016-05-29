package org.gof.examples.factorymethod.gof;

public interface Document {
    String getName();

    void addField(String name, String value);

    String toString();
}
