package data_fixtures;

import java.util.Random;
import java.util.UUID;

public class ValuePatterns {
  
  public static int getUniqueNumber() {
    return new Random().nextInt(999_999_999);
  }
  
  public static String getUniqueText() {
    return UUID.randomUUID().toString();
  }

}
