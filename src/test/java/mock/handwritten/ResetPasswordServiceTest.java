package mock.handwritten;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import app.mock.ResetPasswordService;

public class ResetPasswordServiceTest {

  private static final String VALID_EMAIL = "tester@test.com";
  private MockedEmailService mockedEmailService;
  
  @Before
  public void setUp() {
    mockedEmailService = new MockedEmailService();    
  }
  
  @Test
  public void expect_successful_password_reset() {
    // stub response
    mockedEmailService.setAvailable(true);
    // predefine verifications
    mockedEmailService.setExpectedNumberOfCallsToSend(1);
    mockedEmailService.setExpectedNumberOfCallsToIsAvailable(1);
  
    // install SUT
    ResetPasswordService passwordService = new ResetPasswordService(mockedEmailService);

    // verify state of SUT
    Assert.assertTrue(passwordService.reset(VALID_EMAIL));
    // execute predefined verification
    mockedEmailService.verfiyBehavior();
  }

  @Test
  public void expect_unsuccessful_password_reset() {
    // stub response
    mockedEmailService.setAvailable(false);
    // predefine verifications
    mockedEmailService.setExpectedNumberOfCallsToSend(0);
    mockedEmailService.setExpectedNumberOfCallsToIsAvailable(2);

    // install SUT
    ResetPasswordService passwordService = new ResetPasswordService(mockedEmailService);

    // verify state of SUT
    Assert.assertFalse(passwordService.reset(VALID_EMAIL));
    // execute predefined verification
    mockedEmailService.verfiyBehavior();
  }

}
