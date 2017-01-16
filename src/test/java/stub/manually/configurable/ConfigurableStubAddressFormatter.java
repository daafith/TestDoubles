package stub.manually.configurable;

import app.stub.Address;
import app.stub.AddressFormatter;

public class ConfigurableStubAddressFormatter implements AddressFormatter {
  
  private String formattedAddress;
  private String formattedAddressNotFound;

  public void setFormattedAddress(String formattedAddress) {
    this.formattedAddress = formattedAddress;
  }
  
  public void setFormattedAddressNotFound(String formattedAddressNotFound) {
    this.formattedAddressNotFound = formattedAddressNotFound;
  }
  
  @Override
  public String formatAddress(Address address) {
    return formattedAddress;
  }

  @Override
  public String formatAddressNotFound() {
    return formattedAddressNotFound;
  }

}
