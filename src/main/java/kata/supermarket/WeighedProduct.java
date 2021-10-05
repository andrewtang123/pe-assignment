package kata.supermarket;

import java.math.BigDecimal;

import kata.supermarket.Product.CATEGORY;

public class WeighedProduct extends Product{

    private final BigDecimal pricePerKilo;

    public WeighedProduct(final BigDecimal pricePerKilo, String name, CATEGORY category) {
        this.pricePerKilo = pricePerKilo;
        super.setName(name);
        super.setCategory(category);
    }

    BigDecimal pricePerKilo() {
        return pricePerKilo;
    }

    public Item weighing(final BigDecimal kilos) {
        return new ItemByWeight(this, kilos);
    }
}
