package web.service;

import sun.lwawt.macosx.CSystemTray;

/**
 * Business logic to handle login functions.
 * 
 * @author Ahsan.
 */
public class LoginService {

	/**
	 * Static method returns true for successful login, false otherwise.
	 * @param username
	 * @param password
	 * @return
	 */
	public static boolean login(String username, String password, String dob) {
		System.out.println(dob);
		if ("2000-03-08".equals(dob)) {
			System.out.println("dob ok");
		}
		if ("ahsan".equals(username) && "ahsan_pass".equals(password) && "2000-03-08".equals(dob)) {
			return true;
		}
		return false;
	}
	
	
}
