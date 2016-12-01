package data_fixtures;

import java.util.Random;

public class ValuePatterns {
  
  public static int getUniqueNumber() {
    return new Random().nextInt(999_999_999);
  }
  
  public static String getUniqueNumberAsString() {
    return String.valueOf(getUniqueNumber());
  }

}
