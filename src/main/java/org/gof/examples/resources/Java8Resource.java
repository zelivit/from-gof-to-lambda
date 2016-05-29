package org.gof.examples.resources;

import java.util.function.Consumer;

public class Java8Resource {
  //we want to clean up the object quite deterministically as soon as we're done with it.
  //Java 7 ARM is a step closer to this, but still requires programmers to remember to use
  //the try format.
  //Using EAM pattern the Java 8 compiler can gently force the programmer to naturally use it without having
  //to remember.
  
  private Java8Resource() { System.out.println("Instance created"); }
  
  public void op1() { System.out.println("op1 called...."); }
  public void op2() { System.out.println("op2 called..."); }
  
  private void close() { System.out.println("do any cleanup here..."); }
  
  public static void use(Consumer<Java8Resource> consume) {
    Java8Resource resource = new Java8Resource();
    try {
      consume.accept(resource);
    } finally {
      resource.close();
    }
  }
}
