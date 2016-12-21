import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class Test_mono_alphabetic_cipher {

	mono_alphabetic_cipher cipher_1 = new mono_alphabetic_cipher(1);
	mono_alphabetic_cipher cipher_10 = new mono_alphabetic_cipher('J');
	mono_alphabetic_cipher cipher_100 = new mono_alphabetic_cipher(100);

	@Test
	public void testShift() {
		char shift_1 = cipher_1.shift('A');
		assertEquals('B', shift_1);

		shift_1 = cipher_1.shift('Z');
		assertEquals('A', shift_1);

		shift_1 = cipher_1.shift('a');
		assertEquals('b', shift_1);

		shift_1 = cipher_1.shift('z');
		assertEquals('a', shift_1);

		char shift_10 = cipher_10.shift('A');
		assertEquals('K', shift_10);

		shift_10 = cipher_10.shift('x');
		assertEquals('h', shift_10);

		char shift_100 = cipher_100.shift('A');
		assertEquals('W', shift_100);

		shift_100 = cipher_100.shift('b');
		assertEquals('x', shift_100);

	}

	@Test
	public void testEncrypt() {
		String encrypted = cipher_1.encrypt("HELLO");
		assertEquals("IFMMP", encrypted);

		encrypted = cipher_1.encrypt("HELLO WORLD");
		assertEquals("IFMMP XPSME", encrypted);

		encrypted = cipher_10.encrypt("HELLO WORLD");
		assertEquals("ROVVY GYBVN", encrypted);

		encrypted = cipher_100.encrypt("BAB ABA");
		assertEquals("XWX WXW", encrypted);

		encrypted = cipher_100.encrypt("aBa bAb");
		assertEquals("wXw xWx", encrypted);
	}

	@Test
	public void testDecrypt() {
		String decrypted = cipher_1.decrypt("IFMMP");
		assertEquals("HELLO", decrypted);

		decrypted = cipher_10.decrypt("ROVVY GYBVN");
		assertEquals("HELLO WORLD", decrypted);

		decrypted = cipher_100.decrypt("XWX WXW");
		assertEquals("BAB ABA", decrypted);

		decrypted = cipher_100.decrypt("wXw xWx");
		assertEquals("aBa bAb", decrypted);
	}

}
