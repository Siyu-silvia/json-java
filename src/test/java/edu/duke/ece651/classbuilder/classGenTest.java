package edu.duke.ece651.classbuilder;

import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

public class classGenTest {
  @Test
  public void test_getClassCode() {
    JSONObject cobj = new JSONObject();
    cobj.put("name", "first_class");

    JSONArray farr = new JSONArray();
    JSONObject fobj = new JSONObject();
    fobj.put("name", "first_field");
    fobj.put("type", "String");
    fobj.put("default", "fff");
    farr.put(fobj);

    cobj.put("fields", farr);

    classGen cg = new classGen(cobj);
    // assertEquals("public class first_class {\nString first_field\n;\n}", cg.getClassCode());
    System.out.print(cg.getAllFields());
    assertEquals("private String first_field;\n", cg.getAllFields());
    //assertEquals("first_class(){first_field = fff;}\n", cg.getConstructor());
  }

}
