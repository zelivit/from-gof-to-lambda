package org.gof.examples.adapter.canonical;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.Arrays.asList;

public class AdapterClient {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        AtomicInteger counter = new AtomicInteger();
        asList("af", "bdf", "c").stream()
                .map(s -> new CharCounterTask(s, counter))
                .forEach(new ExecutorConsumerAdaptor(executor));

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.SECONDS);
        System.out.println("Total count: " + counter.get());
    }
}
