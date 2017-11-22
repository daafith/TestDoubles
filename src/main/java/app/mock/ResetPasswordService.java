package app.mock;

public class ResetPasswordService {

  private static final String BODY = "You can reset your password using this link: http://bit.ly/IqT6zt";
  private static final String SUBJECT = "Reset Your Password";
  private static final long RETRY_INTERVAL = 1000;
  private final EmailService emailService;

  public ResetPasswordService(EmailService emailService) {
    this.emailService = emailService;
  }

  public boolean reset(String email) {
    if (isEmailServiceAvailableWithRetry()) {
      emailService.send(email, SUBJECT, BODY);
      return true;
    }
    return false;
  }

  private boolean isEmailServiceAvailableWithRetry() {
    if (emailService.isAvailable()) {
      return true;
    }
    pause(RETRY_INTERVAL);
    return emailService.isAvailable();
  }

  private void pause(long timeOut) {
    try {
      Thread.sleep(timeOut);
    } catch (InterruptedException ex) {
      Thread.currentThread().interrupt();
    }
  }

}
