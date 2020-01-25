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
    farr.put(fobj);

    cobj.put("fields", farr);

    classGen cg = new classGen(cobj);
    assertEquals("public class first_class {\nString first_field;\n}", cg.getClassCode());
  }

}
