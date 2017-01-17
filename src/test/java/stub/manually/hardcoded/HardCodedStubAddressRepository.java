package stub.manually.hardcoded;

import app.stub.Address;
import app.stub.AddressRepository;
import app.stub.City;
import app.stub.Province;

public class HardCodedStubAddressRepository implements AddressRepository {

  @Override
  public Address getAddress(String postCode, int houseNumber, String suffix) {
    City city = new City("Paradise City", new Province("FooBar", "FB"));
    Address validAddress = new Address("Test Street", 12, "c", city, "5555 TT");
    return validAddress;
  }

}
