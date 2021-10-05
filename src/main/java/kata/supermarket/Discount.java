package kata.supermarket;

import java.math.BigDecimal;
import java.util.List;

import kata.supermarket.Product.CATEGORY;

public interface Discount {
	
	String description();
	List<String> allowedProducts();
	List<CATEGORY> allowedCategories();
	BigDecimal qualifyingCount();
	BigDecimal qualityingWeight();	
	Boolean itemQualifies(Item items);
	Boolean itemsQualify(List<Item> items);
	BigDecimal calcDiscount(List<Item> items);
	
}
