package org.gof.examples.factorymethod.gof;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class JsonDocument implements Document {
    private final String name;
    private final Map<String, String> fields = new LinkedHashMap<>();

    public JsonDocument(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addField(String name, String value) {
        fields.put(name, value);
    }

    @Override
    public String toString() {
        return fields.entrySet().stream()
                .map(e -> e.getKey() + ": " + e.getValue())
                .collect(Collectors.joining(",\n", "{\n", "\n}"));
    }
}
