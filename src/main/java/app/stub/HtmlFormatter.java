package app.stub;

public class HtmlFormatter implements AddressFormatter {

  @Override
  public String formatAddress(final Address address) {
    return "<div class=\"address\">" + address.street + " " + address.houseNumber + " " + address.suffix + "<br>"
            + "" + address.postalCode +"<br>"
            + "" + address.city.name + " | " + address.city.province.provinceName + "</div>";
  }
  
  @Override
  public String formatAddressNotFound() {
    return "<div class=\"noaddress\">Address not found</div>";
  } 
}
