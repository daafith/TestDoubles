package data_fixtures;

import java.util.UUID;

public class TestLiteralUtil {
  
  public static String getUniqueText() {
    return UUID.randomUUID().toString();
  }

}
