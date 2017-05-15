package spy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

import app.spy.UserService;

@RunWith(PowerMockRunner.class)
@PrepareForTest(LoggerFactory.class)
public class UserServiceTest {

  @Test
  public void expect_removal_to_be_logged() {
    // PowerMock enables us to make the static method getLogger a test double
    mockStatic(LoggerFactory.class);
    Logger logger = mock(Logger.class);
    when(LoggerFactory.getLogger(any(Class.class)))
      .thenReturn(logger);

    String userToRemove = "John Doe";
    // exercise SUT
    new UserService().remove(userToRemove);

    // check that the info message is OK
    verify(logger).info(startsWith("Removed " + userToRemove + " from the database"));
  }

}
