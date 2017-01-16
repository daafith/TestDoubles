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
  }
  
}
