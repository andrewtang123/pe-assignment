package kata.supermarket;
import static java.util.Objects.nonNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import kata.supermarket.Product.CATEGORY;

class DiscountCalculatorTest {

	static Item milk1Unita = new UnitProduct(BigDecimal.valueOf(1.10), "Milk",  CATEGORY.Drinks).oneOf();
	static Item milk1Unitb = new UnitProduct(BigDecimal.valueOf(1.10), "Milk",  CATEGORY.Drinks).oneOf();
	static Item milk1Unitc = new UnitProduct(BigDecimal.valueOf(1.10), "Milk",  CATEGORY.Drinks).oneOf();
	static Item milk1Unitd = new UnitProduct(BigDecimal.valueOf(1.10), "Milk",  CATEGORY.Drinks).oneOf();
	
	static Item orangeJuice1Unit = new UnitProduct(BigDecimal.ONE, "OrangeJuice",  CATEGORY.Drinks).oneOf();
	static Item pickMix500g = new ItemByWeight(new WeighedProduct(BigDecimal.valueOf(2.5), "Pick&Mix", CATEGORY.Sweets), BigDecimal.valueOf(0.5));
	static Item americanSweets1Kg = new ItemByWeight(new WeighedProduct(BigDecimal.valueOf(1.5), "AmericanSweets", CATEGORY.Sweets), BigDecimal.ONE);
	static Item banana1Kg = new ItemByWeight(new WeighedProduct(BigDecimal.ONE, "Banana", CATEGORY.Fruit), BigDecimal.ONE);
	

    @Test
	void testApplyDiscountsNone() {
		DiscountCalculator discountCalculator = new DiscountCalculator();
		List<AppliedDiscount> applied = discountCalculator.applyDiscounts(Arrays.asList(milk1Unita));
		assertEquals(0, applied.size());
		assertEquals(BigDecimal.ZERO, discountCalculator.discounts());
	}
    
    @Test
	void testApplyDiscountsB1G1F() {
		DiscountCalculator discountCalculator = new DiscountCalculator();
		List<AppliedDiscount> applied = discountCalculator.applyDiscounts(Arrays.asList(milk1Unita, milk1Unitb));
		assertEquals(1, applied.size());
		assertEquals("Buy 1 Get 1 Free", applied.get(0).discountDescription());
		assertTrue(applied.get(0).containsItem(milk1Unita));
		assertTrue(applied.get(0).containsItem(milk1Unitb));
		assertEquals(BigDecimal.valueOf(1.1), discountCalculator.discounts());
	}
    
    @Test
	void testApplyDiscountsB1G1FTwice() {
		DiscountCalculator discountCalculator = new DiscountCalculator();
		List<AppliedDiscount> applied = discountCalculator.applyDiscounts(Arrays.asList(milk1Unita, milk1Unitb, milk1Unitc, milk1Unitd));
		assertEquals(2, applied.size());
		assertEquals("Buy 1 Get 1 Free", applied.get(0).discountDescription());
		assertEquals("Buy 1 Get 1 Free", applied.get(1).discountDescription());
		assertTrue(applied.get(0).containsItem(milk1Unita));
		assertTrue(applied.get(0).containsItem(milk1Unitb));
		assertTrue(applied.get(1).containsItem(milk1Unitc));
		assertTrue(applied.get(1).containsItem(milk1Unitd));
		assertEquals(BigDecimal.valueOf(2.2), discountCalculator.discounts());
	}




}
