package app.mock;

public interface EmailService {

  boolean isAvailable();

  void send(String email, String subject, String body);

}
