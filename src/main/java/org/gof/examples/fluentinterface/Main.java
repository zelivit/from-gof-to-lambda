package org.gof.examples.fluentinterface;

import jdk.nashorn.internal.runtime.options.Option;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {

    public static void main( String[] args ) {
        //old style
        Mailer oldMailer = new Mailer()
                .from("test@example.com")
                .to("example@test.com")
                .subject("Your code sucks")
                .body("...");
        oldMailer.send();

        //functional style
        Mailer.send(newMailer -> {
            newMailer.from("test@example.com")
                    .to("example@test.com")
                    .subject("Your code sucks")
                    .body("...");
        });
    }
}
