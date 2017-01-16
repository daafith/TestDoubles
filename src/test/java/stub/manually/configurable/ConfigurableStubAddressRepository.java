package stub.manually.configurable;

import app.stub.Address;
import app.stub.AddressRepository;

public class ConfigurableStubAddressRepository implements AddressRepository {
  
  private Address address;

  public void setAddress(Address address) {
    this.address = address;
  }

  @Override
  public Address getAddress(String postCode, int houseNumber, String suffix) {
    return address;
  }

}
