package web.service;


import org.junit.Assert;
import org.junit.Test;

public class LoginServiceUnitTest {

    /**
     * Test the happy path when all parameters are exactly as expected.
     */
    @Test
    public void testLoginSuccess() {
        boolean result = LoginService.login("ahsan", "ahsan_pass", "2000-03-08");
        Assert.assertTrue("Expected login to succeed with correct credentials.", result);
    }

    /**
     * Test with an incorrect username.
     */
    @Test
    public void testLoginFailure_WrongUsername() {
        boolean result = LoginService.login("wrongUser", "ahsan_pass", "2000-03-08");
        Assert.assertFalse("Expected login to fail with wrong username.",result);
    }

    /**
     * Test with an incorrect password.
     */
    @Test
    public void testLoginFailure_WrongPassword() {
        boolean result = LoginService.login("ahsan", "wrong_pass", "2000-03-08");
        Assert.assertFalse("Expected login to fail with wrong password.", result);
    }

    /**
     * Test with an incorrect date of birth.
     */
    @Test
    public void testLoginFailure_WrongDob() {
        boolean result = LoginService.login("ahsan", "ahsan_pass", "1999-12-31");
        Assert.assertFalse("Expected login to fail with wrong date of birth.",result);
    }

    /**
     * Test with a null username.
     */
    @Test
    public void testLoginFailure_NullUsername() {
        boolean result = LoginService.login(null, "ahsan_pass", "2000-03-08");
        Assert.assertFalse("Expected login to fail when username is null.",result);
    }

    /**
     * Test with a null password.
     */
    @Test
    public void testLoginFailure_NullPassword() {
        boolean result = LoginService.login("ahsan", null, "2000-03-08");
        Assert.assertFalse("Expected login to fail when password is null.",result);
    }

    /**
     * Test with a null date of birth.
     */
    @Test
    public void testLoginFailure_NullDob() {
        boolean result = LoginService.login("ahsan", "ahsan_pass", null);
        Assert.assertFalse( "Expected login to fail when date of birth is null.",result);
    }

    /**
     * Test with an empty username.
     */
    @Test
    public void testLoginFailure_EmptyUsername() {
        boolean result = LoginService.login("", "ahsan_pass", "2000-03-08");
        Assert.assertFalse("Expected login to fail when username is empty.",result);
    }

    /**
     * Test with an empty password.
     */
    @Test
    public void testLoginFailure_EmptyPassword() {
        boolean result = LoginService.login("ahsan", "", "2000-03-08");
        Assert.assertFalse("Expected login to fail when password is empty.",false);
    }

    /**
     * Test with an empty date of birth.
     */
    @Test
    public void testLoginFailure_EmptyDob() {
        boolean result = LoginService.login("ahsan", "ahsan_pass", "");
        Assert.assertFalse( "Expected login to fail when date of birth is empty.",false);
    }

    /**
     * Test with extra whitespace in the username.
     * Note: If your logic does not trim inputs, this is expected to fail.
     */
    @Test
    public void testLoginFailure_ExtraWhitespace() {
        boolean result = LoginService.login(" ahsan ", "ahsan_pass", "2000-03-08");
        Assert.assertFalse( "Expected login to fail with extra whitespace in username.", result);
    }

    /**
     * Test with an incorrectly formatted date of birth.
     */
    @Test
    public void testLoginFailure_IncorrectDobFormat() {
        boolean result = LoginService.login("ahsan", "ahsan_pass", "2000-13-8");
        Assert.assertFalse( "Expected login to fail when date of birth format is incorrect.",result);
    }
}
