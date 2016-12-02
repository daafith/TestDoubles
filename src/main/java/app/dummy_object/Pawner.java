package app.dummy_object;

public class Pawner implements Customer {

  private final String firstName;
  private final String lastName ;
  private final Address address;
  
  public Pawner(String firstName, String lastName, Address address) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
  }
  
  @Override
  public String getFullName() {
    return firstName + " " + lastName;
  }

  @Override
  public Address getAddress() {
    return address;
  }

}
