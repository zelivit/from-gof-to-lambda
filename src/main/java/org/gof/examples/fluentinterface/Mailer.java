package org.gof.examples.fluentinterface;

import java.util.function.Consumer;

public class Mailer {
    public Mailer from(String addr) {
        System.out.println("from");
        return this;
    }

    public Mailer to(String addr) {
        System.out.println("to");
        return this;
    }

    public Mailer subject(String subjectLine) {
        System.out.println("subject");
        return this;
    }

    public Mailer body(String message) {
        System.out.println("body");
        return this;
    }

    public void send() {
        System.out.println("sending...");
    }

    public static void send(Consumer<Mailer> block) {
        Mailer mailer = new Mailer();
        block.accept(mailer);
        System.out.println("sending...");
    }
}