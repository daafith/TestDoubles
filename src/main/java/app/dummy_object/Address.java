package app.dummy_object;

public class Address {

  public final String street;
  public final City city;
  public final String postalCode;

  public Address(String street, City city, String postalCode) {
    this.street = street;
    this.city = city;
    this.postalCode = postalCode;
  }

}
