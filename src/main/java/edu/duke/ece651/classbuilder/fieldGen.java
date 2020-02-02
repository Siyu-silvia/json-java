package edu.duke.ece651.classbuilder;

import org.json.JSONObject;

public class fieldGen {
  private String name;
  private String type;
  private String default_val;
  private int arrDim;
  private Boolean hasDft;

  public fieldGen ( JSONObject fieldObj) {
    name = fieldObj.getString("name");
    Object T = fieldObj.get("type");
    arrDim = 0;
    if (T instanceof JSONObject) {
      arrDim = getDimention((JSONObject) T);
      setType();
    } else {
      type = (String) T;
    }
    //default_val = fieldObj.optString("default");
    if ( fieldObj.has("default") ) {
       default_val = fieldObj.getString("default");
       hasDft = true;
     }
     else {
       default_val = "";
       hasDft = false;
     }

  }

  private int getDimention(JSONObject listObj ) {
    int d = 1;
    Object T = listObj.get("e");
    while ( T instanceof JSONObject) {
      JSONObject tmp = (JSONObject) T;
      // System.out.println("tmp: " + tmp.toString());
      T = tmp.get("e");
      //System.out.println("T: " + T.toString());
      d++;
    }
    type = (String) T;
    //System.out.println(type);
    return d;
  }

  private void setType() {
    int d = arrDim;
    type = "Collection<" + type + ">";
    while ( d > 1 ) {
      type = "Collection<" + type + ">";
      d--;
    } 
  }

  public Boolean hasDefault() {
    return hasDft;
  }

  //get field and type
  public String getField() {
     return "private " + type + " " + name + ";\n";
  }

  public String getFieldName() {
    return name;
  }

  public String getType() {
    return type;
  }

  public int getArrDim() {
    return arrDim;
  }
  
  public String getDefault() {
    return default_val;
  }

  public Boolean isArr() {
    return arrDim > 0;
  }
}
