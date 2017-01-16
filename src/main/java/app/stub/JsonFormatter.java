package app.stub;

public class JsonFormatter implements AddressFormatter {

  @Override
  public String formatAddress(Address address) {
    return "{" +
        "\"address\" : {" +
          "\"street\" : \""+address.street+"\"," +
          "\"houseNumber\" : \""+address.houseNumber+"\"," +
          "\"suffix\" : \""+address.suffix+"\"," +
          "\"postalCode\" : \""+address.postalCode+"\"," +
          "\"city\" : {" +
            "\"cityName\" : \""+address.city.name+"\"," +
            "\"provinceName\" : \""+address.city.province.provinceName+"\"," +
          "}" +
        "}" +
        "}";
  }
  
  @Override
  public String formatAddressNotFound() {
    return "{\"error\" : \"Address not found\"}";
  }

}
