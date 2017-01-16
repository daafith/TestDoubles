package stub;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import app.stub.Address;
import app.stub.AddressFormatter;
import app.stub.City;
import app.stub.JsonFormatter;
import app.stub.Province;

public class JsonFormatterTest {

  private static final String ADDRESS_WITHOUT_SUFFIX = "{\"address\" : "
      + "{\"street\" : \"Test Street\","
      + "\"houseNumber\" : \"33\","
      + "\"suffix\" : \"\","
      + "\"postalCode\" : \"9999 TT\","
      + "\"city\" : {"
      + "\"cityName\" : \"Paradise City\","
      + "\"provinceName\" : \"FooBar\",}}}";

  private static final String ADDRESS_WITH_SUFFIX = "{\"address\" : "
      + "{\"street\" : \"Test Street\","
      + "\"houseNumber\" : \"33\","
      + "\"suffix\" : \"a\","
      + "\"postalCode\" : \"9999 TT\","
      + "\"city\" : {"
      + "\"cityName\" : \"Paradise City\","
      + "\"provinceName\" : \"FooBar\",}}}";
  
  private AddressFormatter formatter;
  private City city;;
  
  @Before
  public void setUp() {
    formatter = new JsonFormatter();
    city = new City("Paradise City", new Province("FooBar", "FB"));
  }

  @Test
  public void should_display_address_with_suffix_in_span() {
    Address address =  new Address("Test Street", 33, "a", city, "9999 TT");
    Assert.assertEquals(ADDRESS_WITH_SUFFIX, formatter.formatAddress(address));
  }
  
  @Test
  public void should_display_address_without_suffix_in_span() {
    City city = new City("Paradise City", new Province("FooBar", "FB"));
    Address address =  new Address("Test Street", 33, "", city, "9999 TT");
    Assert.assertEquals(ADDRESS_WITHOUT_SUFFIX, formatter.formatAddress(address));
  }
  
  @Test
  public void should_display_address_not_found() {
    Assert.assertEquals("{\"error\" : \"Address not found\"}", formatter.formatAddressNotFound());
  }
  
}
