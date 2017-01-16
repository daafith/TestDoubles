package app.stub;

public class Address {

  public final String street;
  public final int houseNumber;
  public final String suffix;
  public final String postalCode;
  public final City city;
  
  public Address(String street, int houseNumber, String suffix, City city, String postalCode) {
    this.street = street;
    this.houseNumber = houseNumber;
    this.suffix = suffix;
    this.postalCode = postalCode;
    this.city = city;
    if (isInvalidAddress()) throw new InvalidAddressException("Address cannot contain null values or a houseNumber lower than one");
  }

  private boolean isInvalidAddress() {
    return this.street == null
        || this.suffix == null
        || this.postalCode == null
        || this.city == null
        || this.houseNumber < 1 ;
  }
  
  public static class InvalidAddressException extends RuntimeException {
    private static final long serialVersionUID = -7442694580938093159L;
    public InvalidAddressException(String message) {
      super(message);
    }
  }
  
}
