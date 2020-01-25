package edu.duke.ece651.classbuilder;

import org.json.JSONArray;
import org.json.JSONObject;

public class classGen {
  private String name;
  private String fields;
  private String constructors;
  private String methods;
  
  public classGen( JSONObject classObj) {
    name = classObj.getString("name");
    createFields(classObj.getJSONArray("fields"));
    //createConstructors();
    //createMethod();
  }

  // for each field object, create object to get field
  private void createFields( JSONArray fieldArr) {
    int fieldNum = fieldArr.length();
    fields = "";
    for ( int i = 0; i < fieldNum; i++ ) {
      JSONObject fieldObj = fieldArr.getJSONObject(i);
      fieldGen fg = new fieldGen(fieldObj);
      fields += fg.getField();
    }
  }
  
  public String getClassCode() {
    String classStr = "public class " + name + " {\n"
        + fields + "}";
      //+ constructors + "\n"
      //+ methods + "\n}";
    return classStr;
  }
  
}
