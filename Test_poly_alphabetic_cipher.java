import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Test_poly_alphabetic_cipher {

	poly_alphabetic_cipher cipher_aaa = new poly_alphabetic_cipher("AAA");
	poly_alphabetic_cipher cipher_ab = new poly_alphabetic_cipher("AB");
	poly_alphabetic_cipher cipher_tesla = new poly_alphabetic_cipher("TESLA");

	@Test
	public void testEncrypt() {
		String encrypted = cipher_aaa.encrypt("HELLO");
		assertEquals("IFMMP", encrypted);

		encrypted = cipher_aaa.encrypt("HELLO WORLD");
		assertEquals("IFMMP XPSME", encrypted);

		encrypted = cipher_ab.encrypt("HELLO WORLD");
		assertEquals("IGMNP YPTMF", encrypted);

		encrypted = cipher_tesla.encrypt("HELLO WORLD");
		assertEquals("BJEXP QTKXE", encrypted);
	}

	@Test
	public void testDecrypt() {
		String decrypted = cipher_aaa.decrypt("IFMMP");
		assertEquals("HELLO", decrypted);

		decrypted = cipher_aaa.decrypt("IFMMP XPSME");
		assertEquals("HELLO WORLD", decrypted);

		decrypted = cipher_ab.decrypt("IGMNP YPTMF");
		assertEquals("HELLO WORLD", decrypted);

		decrypted = cipher_tesla.decrypt("BJEXP QTKXE");
		assertEquals("HELLO WORLD", decrypted);
	}


}
