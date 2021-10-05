package kata.supermarket;

import static java.util.Objects.nonNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiscountCalculator {
	
	private final static List<Discount> ALL_DISCOUNTS = Arrays.asList(new DiscountBuy1Get1Free(), new Discount1KgSweetsHalfPrice());

	private List<AppliedDiscount> appliedDiscounts;
	
	public List<AppliedDiscount> applyDiscounts(List<Item> items) {
		appliedDiscounts = new ArrayList<>();	
		
		ALL_DISCOUNTS.stream().forEach(discount -> {
			List<Item> itemsToApply = new ArrayList<>();
			
			for (Item item : items) {
				//item qualifies and has not already been applied in previous discount
				if (discount.itemQualifies(item) && appliedDiscounts.stream().noneMatch(a -> a.containsItem(item))) {
					itemsToApply.add(item);
					//we have enough items to satisfy discount
					if (discount.itemsQualify(itemsToApply)) {  
						appliedDiscounts.add(new AppliedDiscount(discount, itemsToApply));
						itemsToApply = new ArrayList<>();
					}
				}
			}
		});
		
		return appliedDiscounts;
		
	}
	
	public BigDecimal discounts() throws RuntimeException {
		if (nonNull(appliedDiscounts)) {
			return appliedDiscounts.stream().map(AppliedDiscount::calcDiscount).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
		} 
		else {
			throw new RuntimeException ("Call applyDiscount() first"); //need to call applyDisount() first
		}
		
	}
	
	

}
