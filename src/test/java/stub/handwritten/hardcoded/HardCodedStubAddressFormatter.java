package stub.handwritten.hardcoded;

import app.stub.Address;
import app.stub.AddressFormatter;

public class HardCodedStubAddressFormatter implements AddressFormatter {

  @Override
  public String formatAddress(Address address) {
    return "Address";
  }
  
  @Override
  public String formatAddressNotFound() {
    return "Address not found";
  }

}
