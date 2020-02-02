package edu.duke.ece651.classbuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

public class ClassBuiilderTest {
  //private JSONObject csobj;
  /*
  ClassBuiilderTest() {
    csobj = new JSONObject();
    
    JSONObject cobj = new JSONObject();
    cobj.put("name", "first_class");
    
    JSONArray farr = new JSONArray();
    JSONObject fobj = new JSONObject();
    fobj.put("name", "first_field");
    fobj.put("type", "String");
    farr.put(fobj);
    
    cobj.put("fields", farr);

    JSONArray classes = new JSONArray();
    classes.put(cobj);
    csobj.put("classes", classes);

  }
    
  @Test
  public void test_inputString() { 
    //String jsonStr = csobj.toString();
    //System.out.print(jsonStr);
    String jsonStr = "{\"classes\":[{\"name\":\"first_class\",\"fields\":[{\"name\":\"first_field\",\"type\":\"String\"}]}]}";
    ClassBuilder cb = new ClassBuilder(jsonStr);
    assertEquals (1, cb.getClassNames().size() );
    assertEquals(true,cb.getClassNames().contains("first_class"));
    assertEquals("public class first_class {\nString first_field;\n}", cb.getSourceCode("first_class"));
  }
  */
  @Test
  public void test_inputStream() {
    //File file = new File("simple.json");
    ClassLoader classLoader = getClass().getClassLoader();
    try {
      InputStream in = classLoader.getResourceAsStream("array.json");
      ClassBuilder cb = new ClassBuilder(in);
      assertEquals (1, cb.getClassNames().size() );
      assertEquals(true,cb.getClassNames().contains("matrix3d"));
      //assertEquals(true,cb.getClassNames().contains(Courses"));
      //assertEquals(true,cb.getClassNames().contains(Courses"));
      //assertEquals(true,cb.getClassNames().contains(Courses"));
      System.out.println(cb.getSourceCode("TEST"));
    }
    catch ( FileNotFoundException e) {
      System.out.println("file not find");
    }
    catch ( Exception e ) {
      System.out.println("other exception");
    }
  }

}
