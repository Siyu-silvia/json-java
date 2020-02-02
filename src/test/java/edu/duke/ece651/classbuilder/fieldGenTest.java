package edu.duke.ece651.classbuilder;

import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

public class fieldGenTest {
  /*
  @Test
  public void test_getMethods() {
    JSONObject fobj = new JSONObject();
    fobj.put("name", "first_field");
    fobj.put("type", "String");
    fobj.put("default", "fff");
    fieldGen fg = new fieldGen(fobj);
    assertEquals("private String first_field;\n", fg.getField());
    assertEquals("first_field", fg.getFieldName());
    assertEquals("String", fg.getType());
    assertEquals(true, fg.hasDefault());
    assertEquals("fff", fg.getDefault());
  }
  */
  @Test
  public void test_getType() {
    JSONObject fobj = new JSONObject();
    JSONObject tobj = new JSONObject();
    fobj.put("name", "array");
    //int d = 2;
    tobj.put("e","int");
    //for (int i = 0; i < d - 1; i++) {
    //  tobj.put("e",tobj);
    //}
    JSONObject ttobj = new JSONObject();
    ttobj.put("e", tobj);
    fobj.put("type",ttobj);
    System.out.println("in test gettype(): " + fobj.toString());
    fieldGen fg = new fieldGen(fobj);
    System.out.println(fg.getType());
    assertEquals("Collection<Collection<int>>", fg.getType());
    assertEquals(2,fg.getArrDim());
    assertEquals(true, fg.isArr());
  }

}
