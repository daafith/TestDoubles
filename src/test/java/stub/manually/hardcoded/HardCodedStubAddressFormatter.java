package stub.manually.hardcoded;

import app.stub.Address;
import app.stub.AddressFormatter;

public class HardCodedStubAddressFormatter implements AddressFormatter {

  @Override
  /**
   * @return "Address"
   */
  public String formatAddress(Address address) {
    return "Address";
  }

  
  @Override
  /**
   * @return "Address not found" 
   */
  public String formatAddressNotFound() {
    return "Address not found";
  }

}
