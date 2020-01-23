package edu.duke.ece651.classbuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class ClassBuilder {
  private JSONObject jsonObj;
  private int classNum;
  
  public ClassBuilder( String jsonStr ) throws JSONException {
    this.jsonObj = new JSONObject(jsonStr);
  }

  
  public ClassBuilder( InputStream input ) throws JSONException, IOException{
    this.jsonObj = new JSONObject(new JSONTokener(input));
  }

  int getClassNum() {
    return this.classNum;
  }
  
  public Collection<String> getClassNames() {
    JSONArray classArr = this.jsonObj.getJSONArray("classes");
    this.classNum = classArr.length();
    ArrayList<String> classNames = new ArrayList<String>();
    for ( int i = 0; i < this.classNum; i++ ) {
      JSONObject obj = classArr.getJSONObject(i);
      classNames.add(obj.getString("name"));
    }
    return classNames;
  }
  /*
  public String getSourceCode( String className) {
  }

  public void createAllClasses ( String basePath) {
  }
  */

  
}
