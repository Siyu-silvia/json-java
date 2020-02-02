package edu.duke.ece651.classbuilder;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class methodGenTest {
  @Test
  public void test_getGet() {
    methodGen mg = new methodGen("test", "String", false);
    System.out.println(mg.getMethods());
    //assertEquals("public String getTest() { return this.test; }\n",mg.getGet());
  }

}
