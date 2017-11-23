package mock.manually;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;

import app.mock.EmailService;

public class MockedEmailService implements EmailService {
  
  private boolean desiredState;
  private int actualNumberOfCalls;
  private int expectedNumberOfCalls;

  void setAvailable(boolean desiredState) {
    this.desiredState = desiredState;
  }
  
  void setExpectedNumberOfCalls(int expectedNumberOfCalls) {
    this.expectedNumberOfCalls = expectedNumberOfCalls;
  }

  @Override
  public boolean isAvailable() {
    return desiredState;
  }

  @Override
  public void send(String email, String subject, String body) {
    actualNumberOfCalls++;  
  }
  
  void verfiy() {
    Assert.assertThat("Number of calls should be " + expectedNumberOfCalls, //
        actualNumberOfCalls, //
        CoreMatchers.equalTo(expectedNumberOfCalls));
  }

}
