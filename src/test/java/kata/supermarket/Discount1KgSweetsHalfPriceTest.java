package kata.supermarket;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import kata.supermarket.Product.CATEGORY;

class Discount1KgSweetsHalfPriceTest {

	Discount1KgSweetsHalfPrice discount1KgSweetsHalfPrice = new Discount1KgSweetsHalfPrice();
		
	static Item milk1Unit = new UnitProduct(BigDecimal.valueOf(1.10), "Milk",  CATEGORY.Drinks).oneOf();
	static Item orangeJuice1Unit = new UnitProduct(BigDecimal.ONE, "OrangeJuice",  CATEGORY.Drinks).oneOf();
	static Item pickMix500g = new ItemByWeight(new WeighedProduct(BigDecimal.valueOf(2.5), "Pick&Mix", CATEGORY.Sweets), BigDecimal.valueOf(0.5));
	static Item americanSweets1Kg = new ItemByWeight(new WeighedProduct(BigDecimal.valueOf(1.5), "AmericanSweets", CATEGORY.Sweets), BigDecimal.ONE);
	static Item banana1Kg = new ItemByWeight(new WeighedProduct(BigDecimal.ONE, "Banana", CATEGORY.Fruit), BigDecimal.ONE);
	

    @ParameterizedTest
    @MethodSource
	void testItemQualifies(Item item, Boolean qualify) {
    	assertEquals(qualify, discount1KgSweetsHalfPrice.itemQualifies(item));
	}
    
    static Stream<Arguments> testItemQualifies() {
        return Stream.of(
                Arguments.of(milk1Unit, Boolean.FALSE), 
                Arguments.of(orangeJuice1Unit, Boolean.FALSE),
                Arguments.of(pickMix500g, Boolean.TRUE), //applies to Sweets category
                Arguments.of(americanSweets1Kg, Boolean.TRUE), //applies to Sweets category
                Arguments.of(banana1Kg, Boolean.FALSE)
        );
    }
    


    @ParameterizedTest
    @MethodSource
	void testItemsQualify(List<Item> items, Boolean qualify) {
    	assertEquals(qualify, discount1KgSweetsHalfPrice.itemsQualify(items));

	}
    
    static Stream<Arguments> testItemsQualify() {
        return Stream.of(
        		Arguments.of(Collections.emptyList(), Boolean.FALSE),
        		Arguments.of(Arrays.asList(pickMix500g), Boolean.FALSE),
        		Arguments.of(Arrays.asList(pickMix500g, pickMix500g), Boolean.TRUE), //only 1kg sweets passes
        		Arguments.of(Arrays.asList(americanSweets1Kg), Boolean.TRUE) //only 1kg sweets passes
        );
    }
    
    
	@Test
	void testCalcDiscount() {
		assertEquals(BigDecimal.valueOf(1.25), discount1KgSweetsHalfPrice.calcDiscount(Arrays.asList(pickMix500g, pickMix500g)));
		assertEquals(BigDecimal.valueOf(0.75), discount1KgSweetsHalfPrice.calcDiscount(Arrays.asList(americanSweets1Kg)));
	}

}
