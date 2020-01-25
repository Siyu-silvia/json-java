package edu.duke.ece651.classbuilder;

import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

public class fieldGenTest {
  @Test
  public void test_getMethods() {
    JSONObject fobj = new JSONObject();
    fobj.put("name", "first_field");
    fobj.put("type", "String");
    fieldGen fg = new fieldGen(fobj);
    assertEquals("String first_field;\n", fg.getField());
    assertEquals("String", fg.getType());
    assertEquals(false, fg.hasDefault());
  }

}
