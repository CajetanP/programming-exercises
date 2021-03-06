import org.junit.Ignore;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LuhnValidatorTest {
    private LuhnValidator luhnValidator;

    @Before
    public void setUp() {
      luhnValidator = new LuhnValidator();
    }

    @Test
    public void testThatSingleDigitStringIsNotValid() {
        assertFalse(luhnValidator.isValid("1"));
    }

    @Test
    public void testThatTheStringConsistingOfASingleZeroIsInvalid() {
        assertFalse(luhnValidator.isValid("0"));
    }

    @Test
    public void testThatASimpleValidNumberIsIdentifiedAsValid() {
        assertTrue(luhnValidator.isValid(" 5 9 "));
    }

    @Test
    public void testThatAValidCanadianSocialInsuranceNumberIsIdentifiedAsValidV1() {
        assertTrue(luhnValidator.isValid("046 454 286"));
    }

    @Test
    public void testThatAValidCanadianSocialInsuranceNumberIsIdentifiedAsValidV2() {
        assertTrue(luhnValidator.isValid("055 444 285"));
    }

    @Test
    public void testThatAnInvalidCanadianSocialInsuranceNumberIsIdentifiedAsInvalid() {
        assertFalse(luhnValidator.isValid("046 454 287"));
    }

    @Test
    public void testThatAnInvalidCreditCardIsIdentifiedAsInvalid() {
        assertFalse(luhnValidator.isValid("8273 1232 7352 0569"));
    }

    @Test
    public void testThatAddingANonDigitCharacterToAValidStringInvalidatesTheString() {
        assertFalse(luhnValidator.isValid("046a 454 286"));
    }

    @Test
    public void testThatStringContainingPunctuationIsInvalid() {
        assertFalse(luhnValidator.isValid("055-444-285"));
    }

    @Test
    public void testThatStringContainingSymbolsIsInvalid() {
        assertFalse(luhnValidator.isValid("055£ 444$ 285"));
    }

    @Test
    public void testThatTheStringConsistingOfASpaceAndASingleZeroIsInvalid() {
        assertFalse(luhnValidator.isValid(" 0"));
    }

    @Test
    public void testThatStringContainingMultipleZerosIsValid() {
        assertTrue(luhnValidator.isValid(" 00000"));
    }

    @Test
    public void testThatDoublingNineIsHandledCorrectly() {
        assertTrue(luhnValidator.isValid("091"));
    }

}
