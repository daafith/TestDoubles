package app.stub;

public interface AddressRepository {
  
  /**
   * 
   * @param postCode
   * @param houseNumber
   * @param suffix
   * @return address or {@code null} when no address can be retrieved
   */
  Address getAddress(String postCode, int houseNumber, String suffix);
  
}
