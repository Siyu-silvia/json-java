package edu.duke.ece651.classbuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class ClassBuilder {
  //private JSONObject jsonObj;
  private int classNum;
  private HashMap<String, String> classCode;
    
  public ClassBuilder( String jsonStr ) throws JSONException {
    //this.jsonObj = new JSONObject(jsonStr);
    buildClass(new JSONObject(jsonStr));
  }

  
  public ClassBuilder( InputStream input ) throws JSONException, IOException{
    //this.jsonObj = 
    buildClass( new JSONObject(new JSONTokener(input)) );
  }

  int getClassNum() {
    return this.classNum;
  }

  private void buildClass( JSONObject jsonObj ) throws JSONException {
    classCode = new HashMap<String, String>();
    JSONArray classArr = jsonObj.getJSONArray("classes");
    int classNum = classArr.length();
    for ( int i = 0; i < classNum; i++ ) {
      // for each class object, create a object and get class + code
      JSONObject classObj = classArr.getJSONObject(i);
      String name = classObj.getString("name");
      classGen cg = new classGen(classObj);
      System.out.println(name);
      System.out.println(cg.getClassCode());
      classCode.put(name, cg.getClassCode());
    }
  }
  
  public Collection<String> getClassNames() {
    /*
    JSONArray classArr = this.jsonObj.getJSONArray("classes");
    this.classNum = classArr.length();
    ArrayList<String> classNames = new ArrayList<String>();
    for ( int i = 0; i < this.classNum; i++ ) {
      JSONObject obj = classArr.getJSONObject(i);
      classNames.add(obj.getString("name"));
    }
    return classNames;
    */
    return classCode.keySet();
  }
  
  public String getSourceCode( String className) {
    return classCode.get(className);
  }

  /*
  public void createAllClasses ( String basePath) {
    
  }
  */
  
}
