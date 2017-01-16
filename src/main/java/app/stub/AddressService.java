package app.stub;

public class AddressService {
  
  private final AddressRepository repository;
  private final AddressFormatter formatter;

  public AddressService(AddressRepository repository, AddressFormatter formatter) {
    this.repository = repository;
    this.formatter = formatter;
  }
  
  public String getAddress(String postCode, int houseNumber, String suffix) {
    final Address address = repository.getAddress(postCode, houseNumber, suffix);
    if (address == null) {
      return formatter.formatAddressNotFound();
    }
    return formatter.formatAddress(address);
  }

}
