package kata.supermarket;

import java.math.BigDecimal;

import kata.supermarket.Product.CATEGORY;

public interface Item {
    BigDecimal price();
    BigDecimal weightOrUnit();
    
    String productName();
    CATEGORY productCategory();
}
