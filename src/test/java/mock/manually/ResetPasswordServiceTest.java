package mock.manually;

import org.junit.Assert;
import org.junit.Test;

import app.mock.ResetPasswordService;

public class ResetPasswordServiceTest {

  private static final String VALID_EMAIL = "tester@test.com";
  
  @Test
  public void expect_successful_password_reset() {
    MockedEmailService emailService = new MockedEmailService();
    emailService.setAvailable(true);
    emailService.setExpectedNumberOfCalls(1);
  
    // install SUT
    ResetPasswordService passwordService = new ResetPasswordService(emailService);

    // verify state of SUT
    Assert.assertTrue(passwordService.reset(VALID_EMAIL));
    // execute predefined verification
    emailService.verfiy();
  }

  @Test
  public void expect_unsuccessful_password_reset() {
    MockedEmailService emailService = new MockedEmailService();
    emailService.setAvailable(false);
    emailService.setExpectedNumberOfCalls(0);
  
    // install SUT
    ResetPasswordService passwordService = new ResetPasswordService(emailService);

    // verify state of SUT
    Assert.assertFalse(passwordService.reset(VALID_EMAIL));
    // execute predefined verification
    emailService.verfiy();
  }

}
