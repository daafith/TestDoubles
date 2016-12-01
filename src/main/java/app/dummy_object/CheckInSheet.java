package app.dummy_object;

import java.util.ArrayList;
import java.util.List;

/**
 * Imagine a pawn shop that needs to keep track of what the customer sells to the shop.<br>
 */
public class CheckInSheet {

  private final List<Product> products;
  private final ICustomer customer;
  
  public CheckInSheet(ICustomer customer) {
    this.customer = customer;
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
  
  
  @Override
  /**
   * This will result in a runtime exception if used with the dummy customer.<b>
   */
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Product product  : products) {
        sb.append(product.productName);
        sb.append("\t");
    }
    return String.format("%s checked in the following product(s) %s", customer.getFullName(), sb.toString());
  }
  
}
