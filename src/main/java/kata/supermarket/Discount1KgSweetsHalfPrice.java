package kata.supermarket;

import static java.util.Objects.nonNull;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import kata.supermarket.Product.CATEGORY;

public class Discount1KgSweetsHalfPrice implements Discount {

	
	public String description() {
		return "1KG Sweets Half Price";
	}

	public List<String> allowedProducts() {
		return null;
	}

	public List<CATEGORY> allowedCategories() {
		return Arrays.asList(CATEGORY.Sweets);
	}
	
	public BigDecimal qualifyingCount() {
		return null;
	}

	public BigDecimal qualityingWeight() {
		return BigDecimal.ONE;
	}
	
	public Boolean itemQualifies(Item item) {
		return allowedCategories().contains(item.productCategory());
	}
	
	public Boolean itemsQualify(List<Item> items) {
		if (!items.isEmpty() && items.stream().allMatch(item -> itemQualifies(item))) {
			BigDecimal combineWeight = items.stream().map(Item::weightOrUnit).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
			return combineWeight.compareTo(qualityingWeight()) >= 0;						
		}
				
		return false;			
	}
	
	public BigDecimal calcDiscount(List<Item> items) {
		// sum price and divide by half
		return items.stream().map(Item::price).reduce(BigDecimal::add).orElse(BigDecimal.ZERO).divide(BigDecimal.valueOf(2)).setScale(2, RoundingMode.HALF_UP);
	}

}
