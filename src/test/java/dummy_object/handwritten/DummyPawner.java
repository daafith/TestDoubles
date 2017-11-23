package dummy_object.handwritten;

import app.dummy_object.Address;
import app.dummy_object.Customer;

/**
 * This dummy object also helps you ensure it is not used in the SUT
 */
public class DummyPawner implements Customer {

  @Override
  public String getFullName() {
    throw new RuntimeException("I should never be used by the SUT!");
  }
  
  @Override
  public Address getAddress() {
    throw new RuntimeException("I should never be used by the SUT!");
  }

}
