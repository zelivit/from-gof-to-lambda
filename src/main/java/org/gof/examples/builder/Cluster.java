package org.gof.examples.builder;

import java.util.function.Consumer;

public class Cluster {
    private String[] hosts;
    private int port;
    private int retryAttempts;
    private boolean metricsEnabled;

    public static StoringBuilder storingBuilder() {
        return new StoringBuilder();
    }

    public static RuntimeBuilder runtimeBuilder() {
        return new RuntimeBuilder();
    }

    public Cluster(String[] hosts, int port) {
        this.hosts = hosts;
        this.port = port;
    }

    public Cluster() {
    }

    public void setHosts(String... hosts) {
        this.hosts = hosts;
    }

    public String[] getHosts() {
        return hosts;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getPort() {
        return port;
    }

    public void setRetryAttempts(int retryAttempts) {
        this.retryAttempts = retryAttempts;
    }

    public int getRetryAttempts() {
        return retryAttempts;
    }

    public void setMetricsEnabled(boolean metricsEnabled) {
        this.metricsEnabled = metricsEnabled;
    }

    public boolean isMetricsEnabled() {
        return metricsEnabled;
    }

    public static class RuntimeBuilder {
        private Cluster cluster = new Cluster();

        public RuntimeBuilder addContactPoints(String... hosts) {
            if (hosts == null || hosts.length == 0) {
                throw new IllegalArgumentException("Hosts must be set!");
            }
            cluster.setHosts(hosts);
            return this;
        }

        public RuntimeBuilder withPort(int port) {
            cluster.setPort(port);
            return this;
        }

        public RuntimeBuilder withRetryAttempts(int retryAttempts) {
            cluster.setRetryAttempts(retryAttempts);
            return this;
        }

        public RuntimeBuilder withoutMetrics() {
            cluster.setMetricsEnabled(false);
            return this;
        }

        public Cluster build() {
            return cluster;
        }


    }
    public static Cluster lambdaBuilder(Consumer<RuntimeBuilder> block){
        RuntimeBuilder builder = new RuntimeBuilder();
        block.accept(builder);
        return builder.build();
    }

    public static class StoringBuilder {
        private String[] hosts;
        private int port;
        private int retryAttempts;
        private boolean metricsEnabled;

        public StoringBuilder addContactPoints(String... hosts) {
            if (hosts == null || hosts.length == 0) {
                throw new IllegalArgumentException("Hosts must be set!");
            }
            this.hosts = hosts;
            return this;
        }

        public StoringBuilder withPort(int port) {
            this.port = port;
            return this;
        }

        public StoringBuilder withRetryAttempts(int retryAttempts) {
            this.retryAttempts = retryAttempts;
            return this;
        }

        public StoringBuilder withoutMetrics() {
            this.metricsEnabled = false;
            return this;
        }

        public Cluster build() {
            Cluster cluster = new Cluster(hosts, port);
            cluster.setMetricsEnabled(metricsEnabled);
            cluster.setRetryAttempts(retryAttempts);
            return cluster;
        }
    }
}