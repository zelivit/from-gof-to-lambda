package org.gof.examples.resources;

import java.io.Closeable;

/**
 * Created by ZVS on 08.05.2016.
 */
public class Java7Resource implements Closeable {
    public Java7Resource() { System.out.println("Instance created"); }

    public void op1() { System.out.println("op1 called...."); }
    public void op2() { System.out.println("op2 called..."); }

    @Override
    public void close() {
        System.out.println("do any cleanup here...");
    }
}
