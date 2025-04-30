package web.service;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestMathQuestionService {

	// Test cases for q1Addition
	@Test
	public void testQ1AdditionWithPositiveNumbers() {
		double result = MathQuestionService.q1Addition("5.5", "4.5");
		assertEquals(10.0, result, 0.0001);
	}

	@Test
	public void testQ1AdditionWithNegativeNumbers() {
		double result = MathQuestionService.q1Addition("-3.2", "1.2");
		assertEquals(-2.0, result, 0.0001);
	}

	@Test
	public void testQ1AdditionWithZero() {
		double result = MathQuestionService.q1Addition("0", "0");
		assertEquals(0.0, result, 0.0001);
	}

	@Test(expected = NumberFormatException.class)
	public void testQ1AdditionWithInvalidInput() {
		MathQuestionService.q1Addition("abc", "5");
	}

	@Test(expected = NumberFormatException.class)
	public void testQ1AdditionWithFirstEmptyString() {
		MathQuestionService.q1Addition("", "5");
	}

	@Test(expected = NumberFormatException.class)
	public void testQ1AdditionWithSecondEmptyString() {
		MathQuestionService.q1Addition("5", "");
	}

	@Test(expected = NumberFormatException.class)
	public void testQ1AdditionWithBothEmptyStrings() {
		MathQuestionService.q1Addition("", "");
	}

	// Test cases for q2Subtraction
	@Test
	public void testQ2SubtractionWithPositiveResult() {
		double result = MathQuestionService.q2Subtraction("10.5", "4.5");
		assertEquals(6.0, result, 0.0001);
	}

	@Test
	public void testQ2SubtractionWithNegativeResult() {
		double result = MathQuestionService.q2Subtraction("3.5", "5.5");
		assertEquals(-2.0, result, 0.0001);
	}

	@Test
	public void testQ2SubtractionWithZero() {
		double result = MathQuestionService.q2Subtraction("0", "0");
		assertEquals(0.0, result, 0.0001);
	}

	@Test(expected = NumberFormatException.class)
	public void testQ2SubtractionWithInvalidInput() {
		MathQuestionService.q2Subtraction("10", "xyz");
	}

	@Test(expected = NumberFormatException.class)
	public void testQ2SubtractionWithFirstEmptyString() {
		MathQuestionService.q2Subtraction("", "5");
	}

	@Test(expected = NumberFormatException.class)
	public void testQ2SubtractionWithSecondEmptyString() {
		MathQuestionService.q2Subtraction("5", "");
	}

	@Test(expected = NumberFormatException.class)
	public void testQ2SubtractionWithBothEmptyStrings() {
		MathQuestionService.q2Subtraction("", "");
	}

	// Test cases for q3Multiply
	@Test
	public void testQ3MultiplyWithPositiveNumbers() {
		double result = MathQuestionService.q3Multiply("2.5", "4.0");
		assertEquals(10.0, result, 0.0001);
	}

	@Test
	public void testQ3MultiplyWithNegativeNumbers() {
		double result = MathQuestionService.q3Multiply("-3.0", "2.5");
		assertEquals(-7.5, result, 0.0001);
	}

	@Test
	public void testQ3MultiplyWithZero() {
		double result = MathQuestionService.q3Multiply("5.5", "0");
		assertEquals(0.0, result, 0.0001);
	}

	@Test
	public void testQ3MultiplyWithDecimalNumbers() {
		double result = MathQuestionService.q3Multiply("1.234", "5.678");
		assertEquals(7.006652, result, 0.000001);
	}

	@Test(expected = NumberFormatException.class)
	public void testQ3MultiplyWithInvalidInput() {
		MathQuestionService.q3Multiply("abc", "def");
	}

	@Test(expected = NumberFormatException.class)
	public void testQ3MultiplyWithFirstEmptyString() {
		MathQuestionService.q3Multiply("", "5");
	}

	@Test(expected = NumberFormatException.class)
	public void testQ3MultiplyWithSecondEmptyString() {
		MathQuestionService.q3Multiply("5", "");
	}

	@Test(expected = NumberFormatException.class)
	public void testQ3MultiplyWithBothEmptyStrings() {
		MathQuestionService.q3Multiply("", "");
	}
}