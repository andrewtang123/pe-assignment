package kata.supermarket;

import java.math.BigDecimal;

import kata.supermarket.Product.CATEGORY;

public class ItemByUnit implements Item {

    private final UnitProduct product;
    private final BigDecimal weightOrUnit;

    ItemByUnit(final UnitProduct product) {
        this.product = product;
        this.weightOrUnit = BigDecimal.ONE;
    }
    
    ItemByUnit(final UnitProduct product, BigDecimal weightOrUnit) {
        this.product = product;
        this.weightOrUnit = weightOrUnit;
    }

    public BigDecimal price() {
        return product.pricePerUnit();
    }
    
    public BigDecimal weightOrUnit() {
    	return weightOrUnit;
    }
    
    public String productName() {
    	return product.getName();
    }
    
    public CATEGORY productCategory() {
    	return product.getCategory();
    }
}
