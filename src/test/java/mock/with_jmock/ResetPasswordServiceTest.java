package mock.with_jmock;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import app.mock.EmailService;
import app.mock.ResetPasswordService;

public class ResetPasswordServiceTest {

  private static final String VALID_EMAIL = "tester@test.com";
  private static final String SUBJECT = "Reset Your Password";
  private static final String BODY = "You can reset your password using this link: http://bit.ly/IqT6zt";
  private EmailService mockedEmailService;
  private Mockery context;

  @Before
  public void setUp() {
    context = new Mockery();
    mockedEmailService = context.mock(EmailService.class);
  }

  @Test
  public void expect_successful_password_reset() {
    context.checking(new Expectations() {
      {
        // stub response
        allowing(mockedEmailService).isAvailable();
        will(returnValue(Boolean.TRUE));
        
        // predefine verification
        exactly(1).of(mockedEmailService).send(VALID_EMAIL, SUBJECT, BODY);
      }
    });

    // install SUT
    ResetPasswordService passwordService = new ResetPasswordService(mockedEmailService);

    // verify state of SUT
    Assert.assertTrue(passwordService.reset(VALID_EMAIL));
    // execute predefined verification
    context.assertIsSatisfied();
  }

  @Test
  public void expect_unsuccessful_password_reset() {
    context.checking(new Expectations() {
      {
        // stub response
        allowing(mockedEmailService).isAvailable();
        will(returnValue(Boolean.FALSE));
        
        // predefine verification
        exactly(0).of(mockedEmailService).send(VALID_EMAIL, SUBJECT, BODY);
      }
    });

    // install SUT
    ResetPasswordService passwordService = new ResetPasswordService(mockedEmailService);

    // verify state of SUT
    Assert.assertFalse(passwordService.reset(VALID_EMAIL));
    // execute predefined verification
    context.assertIsSatisfied();
  }

}
