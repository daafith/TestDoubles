package mock.manually;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;

import app.mock.EmailService;

public class MockedEmailService implements EmailService {
  
  private boolean desiredState;
  private int actualNumberOfCallsToSend;
  private int expectedNumberOfCallsToSend;
  private int expectedNumberOfCallsToIsAvailable;
  private int actualNumberOfCallsToIsAvailable;

  void setAvailable(boolean desiredState) {
    this.desiredState = desiredState;
  }
  
  void setExpectedNumberOfCallsToSend(int expectedNumberOfCalls) {
    this.expectedNumberOfCallsToSend = expectedNumberOfCalls;
  }
  
  public void setExpectedNumberOfCallsToIsAvailable(int expectedNumberOfCallsForIsAvailable) {
    this.expectedNumberOfCallsToIsAvailable = expectedNumberOfCallsForIsAvailable;
  }

  @Override
  public boolean isAvailable() {
    actualNumberOfCallsToIsAvailable++;
    return desiredState;
  }

  @Override
  public void send(String email, String subject, String body) {
    actualNumberOfCallsToSend++;  
  }
  
  void verfiy() {
    Assert.assertThat("Number of calls to send should be " + expectedNumberOfCallsToSend, //
        actualNumberOfCallsToSend, //
        CoreMatchers.equalTo(expectedNumberOfCallsToSend));
    Assert.assertThat("Number of calls to isAvailable should be " + expectedNumberOfCallsToIsAvailable, //
        actualNumberOfCallsToIsAvailable, //
        CoreMatchers.equalTo(expectedNumberOfCallsToIsAvailable));
  }

}
