package app.stub;

public interface AddressFormatter {

  /**
   * @param address
   * @return an address with or without suffix
   */
  String formatAddress(Address address);

  /**
   * 
   * @return the message that no address can be found
   */
  String formatAddressNotFound();

}