package org.gof.examples.builder;

public class SingletonClient {
    public static void main(String[] args) {
        Cluster cluster = Cluster.runtimeBuilder()
                .addContactPoints("localhost").withPort(3165)
                .withRetryAttempts(3)
                .withoutMetrics().build();

        cluster = Cluster.storingBuilder()
                .addContactPoints("localhost").withPort(3165)
                .withRetryAttempts(3)
                .withoutMetrics().build();

        ///////////////////////////////
        Cluster lambdaCluster = Cluster.lambdaBuilder(builder ->
                builder.addContactPoints("localhost")
                        .withPort(3165)
                        .withRetryAttempts(3)
                        .withoutMetrics()
        );
    }
}