package stub.manually.hardcoded;

import app.stub.Address;
import app.stub.AddressRepository;
import app.stub.City;
import app.stub.Province;

public class HardCodedStubAddressRepository implements AddressRepository {

  @Override
  public Address getAddress(String postCode, int houseNumber, String suffix) {
    City city = new City("Paradise City", new Province("FooBar", "FB"));
    Address validAddress = new Address("Test Street", 33, "a", city, "9999 TT");
    return validAddress;
  }

}
