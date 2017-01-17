package stub;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import app.stub.Address;
import app.stub.Address.InvalidAddressException;
import app.stub.City;
import app.stub.Province;

public class AdressTest {


  @Rule
  public ExpectedException expectedException = ExpectedException.none();
  
  private static final int VALID_HOUSE_NUMBER = 1;
  private static final String VALID_POSTAL_CODE = "4444GG";
  private static final String VALID_SUFFIX = "a";
  private static final String VALID_STREET = "The Alley";
  private static final City VALID_CITY = new City("PlaceHolder", new Province("RunTime", "RT"));
  
  
  @Test
  public void can_create_with_suffix() {
    new Address(VALID_STREET, VALID_HOUSE_NUMBER, VALID_SUFFIX, VALID_CITY, VALID_POSTAL_CODE);
  }
  
  @Test
  public void can_create_with_empty_suffix() {
    new Address(VALID_STREET, VALID_HOUSE_NUMBER, "", VALID_CITY, VALID_POSTAL_CODE);
  }
  
  @Test
  public void disallow_null_for_street() {
    assertThatInvalidAddressException();
    new Address(null, VALID_HOUSE_NUMBER, VALID_SUFFIX, VALID_CITY, VALID_POSTAL_CODE);
  }
  
  @Test
  public void disallow_null_for_suffix() {
    assertThatInvalidAddressException();
    new Address(VALID_STREET, VALID_HOUSE_NUMBER, null, VALID_CITY, VALID_POSTAL_CODE);
  }
  
  @Test
  public void disallow_null_for_city() {
    assertThatInvalidAddressException();
    new Address(VALID_STREET, VALID_HOUSE_NUMBER, VALID_SUFFIX, null, VALID_POSTAL_CODE);
  }
  
  @Test
  public void disallow_null_for_postalCode() {
    assertThatInvalidAddressException();
    new Address(VALID_STREET, VALID_HOUSE_NUMBER, VALID_SUFFIX, VALID_CITY, null);
  }
  
  private void assertThatInvalidAddressException() {
    expectedException.expect(InvalidAddressException.class);
    expectedException.expectMessage("Address cannot contain null values");
  }

}
