package java8Practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;

/**
 * interface Supplier<T>{ T get(); }
 * 
 * @author G521885
 *
 */
public class SupplierTesting {

	public static void main(String[] args) {
		Supplier<Date> supplier = () -> new Date();
		System.out.println("Current Date is -> " + supplier.get());
		Supplier<String> otpS = () -> {
			StringBuilder otp = new StringBuilder();
			IntStream.range(0, 6).forEach(i -> otp.append((int) (Math.random() * 10)));
			return otp.toString();
		};
		System.out.println("otp is " + otpS.get());

		Supplier<String> generateDefaultPassword = () -> getDefaultPassword();
		System.out.println("default password generated -> " + generateDefaultPassword.get());
	}

	/**
	 * @f:off
	 * generate 8 digit random password with below restrictions -
	 * 1. 2 digit
	 * 2. 1 alphanumeric
	 * 3. 3 lowercase
	 * 4. 2 uppercase 
	 * @f:on
	 * @return random 8 digit password
	 */
	private static String getDefaultPassword() {
		String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowercase = "abcdefghijklmnopqrstuvwxyz";
		String specialChar = "@#~!";
		String digits = "0123456789";
		Supplier<Character> uppercaseSup = () -> uppercase.charAt((int) (Math.random() * uppercase.length()));
		Supplier<Character> lowercaseSup = () -> lowercase.charAt((int) (Math.random() * lowercase.length()));
		Supplier<Character> specialCharSup = () -> specialChar.charAt((int) (Math.random() * specialChar.length()));
		Supplier<Character> digitSup = () -> digits.charAt((int) (Math.random() * digits.length()));

		List<Character> chars = new ArrayList<>();
		chars.add(specialCharSup.get());
		chars.add(lowercaseSup.get());
		for (int i = 0; i < 2; i++) {
			chars.add(uppercaseSup.get());
			chars.add(lowercaseSup.get());
			chars.add(digitSup.get());
		}

		Supplier<String> finalPasswordSup = () -> {
			StringBuilder sb2 = new StringBuilder();
			Collections.shuffle(chars);
			chars.forEach(sb2::append);
			return sb2.toString();
		};

		return finalPasswordSup.get();
	}

}
