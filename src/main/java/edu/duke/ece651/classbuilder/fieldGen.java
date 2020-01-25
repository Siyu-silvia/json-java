package edu.duke.ece651.classbuilder;

import org.json.JSONObject;

public class fieldGen {
  private String name;
  private String type;
  private String default_val;
  private Boolean hasDft;

  public fieldGen ( JSONObject fieldObj) {
    name = fieldObj.getString("name");
    type = fieldObj.getString("type");
    if ( fieldObj.has("default") ) {
      default_val = fieldObj.getString("default");
      hasDft = true;
    }
    else {
      default_val = "";
      hasDft = false;
    }

  }

  public Boolean hasDefault() {
    return hasDft;
  }

  public String getField() {
    return type + " " + name + ";\n";
  }

  public String getType() {
    return type;
  }
}
