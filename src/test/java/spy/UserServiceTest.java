package spy;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.startsWith;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import app.spy.UserService;

@RunWith(PowerMockRunner.class)
@PrepareForTest(LoggerFactory.class)
public class UserServiceTest {

  @Test
  public void expect_removal_to_be_logged() {
    // PowerMock enables us to insert our spy logger into the static method getLogger
    Logger spyLogger = mock(Logger.class);
    mockStatic(LoggerFactory.class);
    when(LoggerFactory.getLogger(any(Class.class)))
      .thenReturn(spyLogger);

    String userToRemove = "John Doe";
    // exercise real SUT
    new UserService().remove(userToRemove);

    // check that the info message is OK
    verify(spyLogger).info(startsWith("Removed " + userToRemove + " from the database"));
  }

}
