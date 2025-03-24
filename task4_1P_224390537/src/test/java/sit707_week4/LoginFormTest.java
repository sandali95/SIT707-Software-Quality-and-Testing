package sit707_week4;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests functions in LoginForm.
 * @author Ahsan Habib
 */
public class LoginFormTest
{

	@Test
	public void testStudentIdentity() {
		String studentId = "224390537";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Sandali Samarawickrama";
		Assert.assertNotNull("Student name is null", studentName);
	}

	@Test
	public void testFailEmptyUsernameAndEmptyPasswordAndDontCareValCode()
	{
		LoginStatus status = LoginForm.login(null, null);
		Assert.assertTrue( status.isLoginSuccess() == false );
	}

	@Test
	public void testFailEmptyUsernameAndWrongPasswordAndDontCareValCode() {
		LoginStatus status = LoginForm.login(null, "wrong_password");
		Assert.assertFalse(status.isLoginSuccess());
	}

	@Test
	public void testFailEmptyUsernameAndCorrectPasswordAndDontCareValCode() {
		LoginStatus status = LoginForm.login(null, "ahsan_pass");
		Assert.assertFalse(status.isLoginSuccess());
	}

	@Test
	public void testFailWrongUsernameAndEmptyPasswordAndDontCareValCode() {
		LoginStatus status = LoginForm.login("wrong_user", null);
		Assert.assertFalse(status.isLoginSuccess());
	}

	@Test
	public void testFailWrongUsernameAndWrongPasswordAndDontCareValCode() {
		LoginStatus status = LoginForm.login("wrong_user", "wrong_password");
		Assert.assertFalse(status.isLoginSuccess());
	}

	@Test
	public void testFailWrongUsernameAndCorrectPasswordAndDontCareValCode() {
		LoginStatus status = LoginForm.login("wrong_user", "ahsan_pass");
		Assert.assertFalse(status.isLoginSuccess());
	}

	@Test
	public void testFailCorrectUsernameAndEmptyPasswordAndDontCareValCode() {
		LoginStatus status = LoginForm.login("ahsan", null);
		Assert.assertFalse(status.isLoginSuccess());
	}

	@Test
	public void testFailCorrectUsernameAndWrongPasswordAndDontCareValCode() {
		LoginStatus status = LoginForm.login("ahsan", "wrong_password");
		Assert.assertFalse(status.isLoginSuccess());
	}

	@Test
	public void testSuccessCorrectUsernameAndCorrectPasswordAndEmptyValCode() {
		LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
		Assert.assertTrue(status.isLoginSuccess());
	}

	@Test
	public void testFailCorrectUsernameAndCorrectPasswordAndWrongValCode() {
		LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
		Assert.assertTrue(status.isLoginSuccess());
		boolean isCodeValid = LoginForm.validateCode("wrong_code");
		Assert.assertFalse(isCodeValid);
	}

	@Test
	public void testSuccessCorrectUsernameAndCorrectPasswordAndCorrectValCode() {
		LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
		Assert.assertTrue(status.isLoginSuccess());
		boolean isCodeValid = LoginForm.validateCode("123456");
		Assert.assertTrue(isCodeValid);
	}
}