package stub.manually.hardcoded;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import app.stub.Address;
import app.stub.AddressFormatter;
import app.stub.AddressRepository;
import app.stub.AddressService;

public class HardCodedAddressServiceTest {

  @Test
  public void should_find_an_address_with_two_hardcoded_stubs() {
    AddressRepository stubRepository = new HardCodedStubAddressRepository();
    AddressFormatter stubFormatter = new HardCodedStubAddressFormatter();

    AddressService service = new AddressService(stubRepository, stubFormatter);
    assertEquals("Address", service.getAddress("5555TT", 12, "c"));
  }

  @Test
  public void should_find_no_address_with_two_hardcoded_stubs() {
    AddressService service = new AddressService(saboteurStubRepository, saboteurStubFormatter);
    assertEquals("Address not found", service.getAddress("TT5555", 112, "^"));
  }

  AddressRepository saboteurStubRepository = new AddressRepository() {
    
    @Override
    public Address getAddress(String postCode, int houseNumber, String suffix) {
      Address invalidAddress = null;
      return invalidAddress;
    }
    
  };
  
  AddressFormatter saboteurStubFormatter = new AddressFormatter() {

    @Override
    public String formatAddress(Address address) {
      throw new RuntimeException("I should never be used by the SUT!");
    }

    @Override
    public String formatAddressNotFound() {
      return "Address not found";
    } 
   
  };

}
