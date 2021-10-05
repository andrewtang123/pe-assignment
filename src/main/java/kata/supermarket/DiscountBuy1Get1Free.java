package kata.supermarket;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

import kata.supermarket.Product.CATEGORY;

public class DiscountBuy1Get1Free implements Discount {

	
	public String description() {
		return "Buy 1 Get 1 Free";
	}

	public List<String> allowedProducts() {
		return Arrays.asList("Milk");
	}

	public List<CATEGORY> allowedCategories() {
		return null;
	}
	
	public BigDecimal qualifyingCount() {
		return BigDecimal.valueOf(2);
	}


	public BigDecimal qualityingWeight() {
		return null;
	}
	
	public Boolean itemQualifies(Item item) {
		return allowedProducts().contains(item.productName());
	}

	public Boolean itemsQualify(List<Item> items) {
		if (!items.isEmpty() && items.stream().allMatch(item -> itemQualifies(item))) { 
			//assuming all items have 1 unit so not tracking remainders
			return items.stream().map(Item::weightOrUnit).reduce(BigDecimal::add).orElse(BigDecimal.ZERO).compareTo(qualifyingCount()) >= 0;	
		}
				
		return false;			
	}
	
	public BigDecimal calcDiscount(List<Item> items) {
		// assume both have same price
		return items.stream().findFirst().get().price();		
	}

}
