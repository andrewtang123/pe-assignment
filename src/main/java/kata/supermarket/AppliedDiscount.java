package kata.supermarket;

import static java.util.Objects.nonNull;
import java.math.BigDecimal;
import java.util.List;

public class AppliedDiscount {
	private Discount discount;
	private List<Item> items;
	
	public AppliedDiscount(Discount discount, List<Item> items) {
		super();
		this.discount = discount;
		this.items = items;	
	}
	
	public Boolean containsItem(Item item) {
		return nonNull(items) && items.contains(item);
	}
	
	public String discountDescription() {
		return discount.description();
	}
	
	public BigDecimal calcDiscount() {
		return discount.calcDiscount(items);
	} 
				

}
