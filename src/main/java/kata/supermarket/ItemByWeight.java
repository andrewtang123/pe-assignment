package kata.supermarket;

import java.math.BigDecimal;

import kata.supermarket.Product.CATEGORY;

public class ItemByWeight implements Item {

    private final WeighedProduct product;
    private final BigDecimal weightInKilos;

    ItemByWeight(final WeighedProduct product, final BigDecimal weightInKilos) {
        this.product = product;
        this.weightInKilos = weightInKilos;
    }

    public BigDecimal price() {
        return product.pricePerKilo().multiply(weightInKilos).setScale(2, BigDecimal.ROUND_HALF_UP);
    }
    
    public BigDecimal weightOrUnit() {
    	return weightInKilos;
    }
    
    public String productName() {
    	return product.getName();
    }
    
    public CATEGORY productCategory() {
    	return product.getCategory();
    }
}
