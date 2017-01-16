package stub.manually.configurable;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import app.stub.Address;
import app.stub.AddressService;
import app.stub.City;
import app.stub.Province;

public class ConfigurableAddressServiceTest {

  @Test
  public void should_find_an_address_with_two_configurable_stubs() {
    City city = new City("Paradise City", new Province("FooBar", "FB"));
    Address validAddress = new Address("Test Street", 33, "a", city, "9999 TT");
    
    // configure the stubRepository
    ConfigurableStubAddressRepository stubRepository = new ConfigurableStubAddressRepository();
    stubRepository.setAddress(validAddress);
    
    // configure the stubFormatter
    ConfigurableStubAddressFormatter stubFormatter = new ConfigurableStubAddressFormatter();
    stubFormatter.setFormattedAddress("address");

    // instantiate the SUT with the configurable stubs 
    AddressService service = new AddressService(stubRepository, stubFormatter);
    // verify SUT
    assertEquals("address", service.getAddress("5555TT", 12, "c"));
  }

  @Test
  public void should_find_no_address_with_two_configurable_stubs() {
    Address invalidAddress = null;
    
    // configure the saboteurStubRepository
    ConfigurableStubAddressRepository saboteurStubRepository = new ConfigurableStubAddressRepository();
    saboteurStubRepository.setAddress(invalidAddress);
    
    // configure the saboteurStubFormatter
    ConfigurableStubAddressFormatter saboteurStubFormatter = new ConfigurableStubAddressFormatter();
    saboteurStubFormatter.setFormattedAddressNotFound("Address not found");
    
    // instantiate the SUT with the configurable stubs 
    AddressService service = new AddressService(saboteurStubRepository, saboteurStubFormatter);
    // verify SUT
    assertEquals("Address not found", service.getAddress("TT5555", 112, "^"));
  }

}
