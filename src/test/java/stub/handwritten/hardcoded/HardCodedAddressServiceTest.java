package stub.handwritten.hardcoded;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import app.stub.Address;
import app.stub.AddressFormatter;
import app.stub.AddressRepository;
import app.stub.AddressService;

public class HardCodedAddressServiceTest {

  @Test
  public void should_find_an_address_with_two_hardcoded_stubs() {
    // setup the hard-coded stubs 
    AddressRepository stubRepository = new HardCodedStubAddressRepository();
    AddressFormatter stubFormatter = new HardCodedStubAddressFormatter();

    // instantiate the SUT with the hard-coded stubs 
    AddressService service = new AddressService(stubRepository, stubFormatter);
    // verify SUT
    assertEquals("Address", service.getAddress("5555 TT", 12, "c"));
  }

  @Test
  public void should_find_no_address_with_two_hardcoded_stubs() {
    AddressFormatter stubFormatter = new HardCodedStubAddressFormatter();
    // instantiate the SUT with the hard-coded anonymous inner class stub
    AddressService service = new AddressService(saboteurStubRepository, stubFormatter);
    // verify SUT
    assertEquals("Address not found", service.getAddress("TT5555", -12, "^"));
  }

  // anonymous inner class that acts as a saboteur
  AddressRepository saboteurStubRepository = new AddressRepository() {
    
    @Override
    public Address getAddress(String postCode, int houseNumber, String suffix) {
      Address invalidAddress = null;
      return invalidAddress;
    }
    
  };
  
}
