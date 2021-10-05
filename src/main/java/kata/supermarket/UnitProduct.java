package kata.supermarket;

import java.math.BigDecimal;

public class UnitProduct extends Product {

    private final BigDecimal pricePerUnit;

    public UnitProduct(final BigDecimal pricePerUnit, String name, CATEGORY category) {
        this.pricePerUnit = pricePerUnit;
        super.setName(name);
        super.setCategory(category);
    }

    BigDecimal pricePerUnit() {
        return pricePerUnit;
    }

    public Item oneOf() {
        return new ItemByUnit(this);
    }
}
