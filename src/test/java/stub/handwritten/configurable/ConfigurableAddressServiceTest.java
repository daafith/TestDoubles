package stub.handwritten.configurable;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import app.stub.Address;
import app.stub.AddressService;
import app.stub.City;
import app.stub.Province;

public class ConfigurableAddressServiceTest {
  
  private ConfigurableStubAddressRepository stubRepository;
  private ConfigurableStubAddressFormatter stubFormatter;
  
  @Before
  public void setUp() {
    stubRepository = new ConfigurableStubAddressRepository();
    stubFormatter = new ConfigurableStubAddressFormatter();
  }

  @Test
  public void should_find_an_address_with_two_configurable_stubs() {
    City city = new City("Paradise City", new Province("FooBar", "FB"));
    Address validAddress = new Address("Test Street", 12, "c", city, "5555 TT");
    
    // configure the stubRepository as responder
    stubRepository.setAddress(validAddress);
    
    // configure the stubFormatter as responder
    stubFormatter.setFormattedAddress("address");

    // instantiate the SUT with the configurable stubs 
    AddressService service = new AddressService(stubRepository, stubFormatter);
    // verify SUT
    assertEquals("address", service.getAddress("5555 TT", 12, "c"));
  }

  @Test
  public void should_find_no_address_with_two_configurable_stubs() {
    Address invalidAddress = null;
    
    // configure the stubRepository as saboteur
    stubRepository.setAddress(invalidAddress);
    
    // configure the stubFormatter as responder
    stubFormatter.setFormattedAddressNotFound("Address not found");
    
    // instantiate the SUT with the configurable stubs 
    AddressService service = new AddressService(stubRepository, stubFormatter);
    // verify SUT
    assertEquals("Address not found", service.getAddress("TT5555", -12, "^"));
  }

}
