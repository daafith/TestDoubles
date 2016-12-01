package app.dummy_object;

import java.util.ArrayList;
import java.util.List;

/**
 * Imagine a pawn shop that needs to keep track of what the customer sells to the shop.<br>
 * I leave the customer untouched, because I want the example not to be obscured by details.
 */
public class CheckInSheet {

  private List<Product> products;
  
  public CheckInSheet(ICustomer customer) {
    products = new ArrayList<>();
  }

  public void add(Product product, int quantity) {
    for (int i = 0; i < quantity; i++) {
      products.add(product);      
    }
  }

  public List<Product> getLineItems() {
    return products;
  }
}
