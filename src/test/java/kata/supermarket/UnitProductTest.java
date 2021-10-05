package kata.supermarket;

import org.junit.jupiter.api.Test;

import kata.supermarket.Product.CATEGORY;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UnitProductTest {

    @Test
    void singleItemHasExpectedUnitPriceFromProduct() {
        final BigDecimal price = new BigDecimal("2.49");
        assertEquals(price, new UnitProduct(price, "Milk",  CATEGORY.Drinks).oneOf().price());
        assertEquals("Milk", new UnitProduct(price, "Milk",  CATEGORY.Drinks).oneOf().productName());
        assertEquals(CATEGORY.Drinks, new UnitProduct(price, "Milk",  CATEGORY.Drinks).oneOf().productCategory());
    }
}