package dummy_object;

import app.dummy_object.Address;
import app.dummy_object.ICustomer;

/**
 * This dummy object also helps you ensure it is not used in the SUT
 */
public class DummyCustomer implements ICustomer {

  @Override
  public String getFullName() {
    throw new RuntimeException("I should never be used by the SUT!");
  }
  
  @Override
  public Address getAddress() {
    throw new RuntimeException("I should never be used by the SUT!");
  }

}
