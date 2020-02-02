package edu.duke.ece651.classbuilder;


public class methodGen {
  private String name;
  private String upperName;
  private String type;
  private Boolean isArr;

  public methodGen(String n, String t, Boolean arr) {
    name = n;
    type = t;
    isArr = arr;
    //get multidimentional type
    upperName = name.substring(0,1).toUpperCase() + name.substring(1); 
  }

  private String getGet() {
    return "public " + type + " get" + upperName
      + "() { return this." + name + "; }\n";
  }

  private String getSet() {
    return "public void set" + upperName + "( " + type
      + " value ) { this." + name + " = value; }\n";
  }

  private String getArrGet() {
    return "public " + type + " get" + upperName + "( int index ) { return this."
        + name + ".get(index); }\n";
  }

  private String getArrAdd() {
    return "public void add" + upperName + "( " + type + " value ) { this."
        + name + ".add(value); }\n";
  }

  private String getArrNum() {
    return "public int num" +  upperName + "() { return this."
        + name + ".size(); }\n";
  }

  private String getArrSet() {
    return "public void set" + upperName + "( int index, " + type + " value ) { this." +
        name + ".set(index,value); }\n";
  }

  public String getMethods() {
    if ( isArr ) {
      return getArrGet() + getArrNum() + getArrAdd() + getArrSet();
    }
    return getGet() + getSet();
  }
  
}
