package stub.manually.with_mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import app.stub.Address;
import app.stub.AddressFormatter;
import app.stub.AddressRepository;
import app.stub.AddressService;
import app.stub.City;
import app.stub.Province;

public class AddressServiceTest {
  
  @Test
  public void should_find_an_address_with_two_mockito_stubs() {
    City city = new City("Paradise City", new Province("FooBar", "FB"));
    Address validAddress = new Address("Test Street", 33, "a", city, "9999 TT");

    AddressFormatter formatter = mock(AddressFormatter.class);
    AddressRepository repository = mock(AddressRepository.class);

    when(repository.getAddress("5555TT", 12, "c"))
      .thenReturn(validAddress);
    when(formatter.formatAddress(validAddress))
      .thenReturn("Address");
    
    AddressService service = new AddressService(repository, formatter);
    assertEquals("Address", service.getAddress("5555TT", 12, "c"));
  }
  

  @Test
  public void should_find_no_address_with_two_mockito_stubs() {
    Address invalidAddress = null;
    
    AddressFormatter formatter = mock(AddressFormatter.class);
    AddressRepository repository = mock(AddressRepository.class);

    when(repository.getAddress("TT5555", -12, "^"))
      .thenReturn(invalidAddress);
    when(formatter.formatAddressNotFound())
      .thenReturn("Address not found");
    
    AddressService service = new AddressService(repository, formatter);
    assertEquals("Address not found", service.getAddress("TT5555", 112, "^"));
  }

}
