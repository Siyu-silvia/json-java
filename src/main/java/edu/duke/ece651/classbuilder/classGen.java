package edu.duke.ece651.classbuilder;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

public class classGen {
  private String name;
  private HashMap<String,fieldGen> fields;
  //private HashMap<String, String> fieldMap;
  private HashMap<String, methodGen> methods;
  private String constructor;
  
  public classGen( JSONObject classObj) {
    name = classObj.getString("name");
    //initFieldMap();
    createFieldsMethods(classObj.getJSONArray("fields"));
    constructor = initConstructor();
    //createConstructors();
    //if ( classObj.has("constructors") ){
    //  addConstructors(classObj.getJSONArray("constructors"));
    //}
    //createMethod();
  }
  
  // for each field object, create object to get field
  private void createFieldsMethods( JSONArray fieldArr) {
    int fieldNum = fieldArr.length();
    fields = new HashMap<String,fieldGen>();
    methods = new HashMap<String, methodGen>();
    for ( int i = 0; i < fieldNum; i++ ) {
      JSONObject fieldObj = fieldArr.getJSONObject(i);
      fieldGen fg = new fieldGen(fieldObj);
      fields.put(fg.getFieldName(),fg);
      methods.put(fg.getFieldName(),new methodGen(fg.getFieldName(),fg.getType(), fg.isArr()) );
    }
  }

    
  private String initConstructor() {
    Boolean hasArr = false;
    String cstr = "public " + name + "(){\n";
    for ( fieldGen field : fields.values() ) {
      if ( field.getArrDim() > 0 ) {
        hasArr = true;
        cstr += field.getFieldName() + " = new " + field.getType() + "();\n";
      }
    }
    cstr += "}\n";
    if ( hasArr) {
      return cstr;
    }
    return "";
  }

  
  
  /*

  private void initFieldMap() {
    fieldMap = new HashMap<String, String>();
    fieldMap.put("int", "0");
    fieldMap.put("long", "0");
    fieldMap.put("float", "0.0");
    fieldMap.put("double", "0.0");
    fieldMap.put("char", "''");
    fieldMap.put("short", "0");
    fieldMap.put("byte", "0");
    fieldMap.put("boolean", "false");
    fieldMap.put("String", "\"\"");
    fieldMap.put("ArrayList", "null");
  }
  
  
  private void createConstructors() {
    constructors = name + "(){";
    //create default with default value;
     for ( fieldGen field : fields.values() ) {
      //String fieldType = fields.get(fieldName).getType();
       if ( field.hasDefault() ) {
         constructors += field.getFieldName() + " = " + field.getDefault() + ";";
       }
      }
      constructors += "}\n";
  }
  
  private void addConstructors( JSONArray consArr ) {
    for ( int i = 0; i < consArr.length(); i++ ) {
      // build constructor according to JSON
      String fieldName = (String)consArr.get(i);
      String fieldType = fields.get(fieldName).getType();
      if ( fieldType == "ArrayList" ) {
        System.out.println("can not construct array in constructors");
      }
      String conStr = name + "(" + fieldType + " value){\n" + fieldName + " = value;\n}\n";
      constructors += conStr;
    }
  }
  
  */
  
  public String getAllFields() {
    String fieldStr = "";
    for ( fieldGen field : fields.values() ) {
      fieldStr += field.getField();
    }
    return fieldStr;
  }

  public String getAllMethods() {
    String methodStr = "";
    for ( methodGen method : methods.values() ) {
      methodStr += method.getMethods();
    }
    return methodStr;
  }

  public String getConstructor() {
    return constructor;
  }
  
  public String getClassCode() {
    String classStr = "public class " + name + " {\n"
      + getAllFields() + "\n"
      + getConstructor() + "\n"
      + getAllMethods() + "\n}";
    return classStr;
  }


  private JSONObject toJSONhelper(int id) {
    JSONObject jobj = new JSONObject();
    jobj.put("id", id);
    jobj.put("type", this.getType());
    JSONObject fobj = new JSONObject();
    for ( fieldGen field : fields.values()) {
      
    }
    return jobj;
  }
  
  public JSONObject toJSON() {
    return toJSONhelper(this.hashCode());
  }
  

  
}
