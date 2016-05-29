package org.gof.examples.resources;

/**
 * Created by ZVS on 29.05.2016.
 */
public class Main {
    public static void main(String[] args){
        //java 7 style
        try (Java7Resource resource7 = new Java7Resource()) {
            resource7.op1();
            resource7.op2();
        }
        //Java 8 style
        Java8Resource.use(resource -> {
            resource.op1();
            resource.op2();
        });
    }
}
