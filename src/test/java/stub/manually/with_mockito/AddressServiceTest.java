package stub.manually.with_mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import app.stub.Address;
import app.stub.AddressFormatter;
import app.stub.AddressRepository;
import app.stub.AddressService;
import app.stub.City;
import app.stub.Province;

public class AddressServiceTest {
  
  //the two stubs we want to use
  @Mock AddressFormatter stubFormatter;
  @Mock AddressRepository stubRepository;

  @Before
  public void setUp() {
    // use new stubs for each @Test
    MockitoAnnotations.initMocks(this);
  }
  
  @Test
  public void should_find_an_address_with_two_mockito_stubs() {
    City city = new City("Paradise City", new Province("FooBar", "FB"));
    Address validAddress = new Address("Test Street", 33, "a", city, "9999 TT");

    // configure the stubRepository as responder
    when(stubRepository.getAddress("5555TT", 12, "c"))
      .thenReturn(validAddress);
    // configure the stubFormatter as responder
    when(stubFormatter.formatAddress(validAddress))
      .thenReturn("Address");
    
    AddressService service = new AddressService(stubRepository, stubFormatter);
    // verify SUT
    assertEquals("Address", service.getAddress("5555TT", 12, "c"));
    // verify that formatAddressNotFound is never used
    verify(stubFormatter, never()).formatAddressNotFound();
  }
  

  @Test
  public void should_find_no_address_with_two_mockito_stubs() {
    Address invalidAddress = null;
    
    // configure the stubRepository as saboteur
    when(stubRepository.getAddress("TT5555", -12, "^"))
      .thenReturn(invalidAddress);
    // configure the stubFormatter as saboteur
    when(stubFormatter.formatAddressNotFound())
      .thenReturn("Address not found");
    
    AddressService service = new AddressService(stubRepository, stubFormatter);
    // verify SUT
    assertEquals("Address not found", service.getAddress("TT5555", 112, "^"));
    // verify that formatAddress is never used
    verify(stubFormatter, never()).formatAddress(any());
  }

}
