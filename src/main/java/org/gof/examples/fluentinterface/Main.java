package org.gof.examples.fluentinterface;

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
