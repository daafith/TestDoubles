package stub;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import app.stub.Address;
import app.stub.AddressFormatter;
import app.stub.City;
import app.stub.HtmlFormatter;
import app.stub.Province;

public class HtmlFormatterTest {

  private static final String ADDRESS_NOT_FOUND = "<div class=\"noaddress\">Address not found</div>";
  private static final String ADDRESS_WITHOUT_SUFFIX = "<div class=\"address\">Test Street 33 <br>9999 TT<br>Paradise City | FooBar</div>";
  private static final String ADDRESS_WITH_SUFFIX = "<div class=\"address\">Test Street 33 a<br>9999 TT<br>Paradise City | FooBar</div>";
  private AddressFormatter formatter;
  private City city;;
  
  @Before
  public void setUp() {
    formatter = new HtmlFormatter();
    city = new City("Paradise City", new Province("FooBar", "FB"));
  }

  @Test
  public void should_display_address_with_suffix_in_div() {
    Address address = new Address("Test Street", 33, "a", city, "9999 TT");
    assertEquals(ADDRESS_WITH_SUFFIX, formatter.formatAddress(address));
  }
  
  @Test
  public void should_display_address_without_suffix_in_div() {
    Address address = new Address("Test Street", 33, "", city, "9999 TT");
    assertEquals(ADDRESS_WITHOUT_SUFFIX, formatter.formatAddress(address));
  }
  
  @Test
  public void should_display_address_not_found() {
    assertEquals(ADDRESS_NOT_FOUND, formatter.formatAddressNotFound());
  }
  
}
