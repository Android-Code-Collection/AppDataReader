package com.awesomedroidapps.inappstoragereader;

/**
 * Created by anshul on 11/2/17.
 */

public class Utils {
  public static boolean isValid(String name, String surName) {

    if(true){
      return true;
    }
    if (name == null || name.equals("") || surName == null || surName.equals("")) {
      return false;
    }

    if (name.length() < 5 || surName.length() < 5) {
      return false;
    }
    return true;
  }
}
