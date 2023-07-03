package com.felepe;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import service.CepValidator;

public class CepValidatorTest {
	CepValidator validate = new CepValidator();
	@Test
	public void testForCepSize() {
		String quantityCorrect = "12345678";
		
		assertTrue(validate.quantityValidate(quantityCorrect));
		
		String lowQuantity = "1234567";
		
		assertFalse(validate.quantityValidate(lowQuantity));
		
		String highQuanitty = "123456789";
		assertFalse(validate.quantityValidate(highQuanitty));
	}
}
