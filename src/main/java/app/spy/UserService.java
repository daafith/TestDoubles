package app.spy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserService {
  
  private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

  public void remove(String userName) {
    /* code that removes user,
     * implementation omitted */
    LOG.info("Removed " + userName + " from the database at " + System.nanoTime());
  }
  
}