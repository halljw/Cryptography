/**
* The poly_alphabetic_cipher class implements a basic poly-alphabetic cipher.
* The cipher object is declared with a String key. The cipher is modeled as a
* collection of mono-alphabetic ciphers, where each mono-alphabetic cipher
* has a key corresponding to each of the characters in the String key.
* 
* The encrypt method shifts all characters in a string forward along the
* alphabet by the numerical value of each char in the String key. The decrypt
* method shifts all characters in a string backward along the alphabet in the
* same manner.
*
* @author John W. Hall, jwhall5@illinois.edu
* @version 1.0 Dec. 20, 2016
*/
public class poly_alphabetic_cipher{

	public final String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private final String key;
	private final mono_alphabetic_cipher ciphers[];

	/**
	* Constructs and initializes a poly-alphabetic cipher.
	* @param k The poly-alphabetic cipher key.
	*/
	public poly_alphabetic_cipher(String k){
		key = k.toUpperCase();
		ciphers = new mono_alphabetic_cipher[key.length()];
		for(int i=0; i<key.length(); i++){
			int cipher_key = letters.indexOf(key.charAt(i));
			ciphers[i] = new mono_alphabetic_cipher(cipher_key+1);
		}

	}

	/**
	* Returns the key assigned to the cipher.
	* @return The poly-alphabetic cipher key
	*/
	public String getKey(){return key;}

	/**
	* Encrypts text using the poly-alphabetic cipher.
	* Spaces, punctuation, non-letter characters are unaffected by encryption.
	* Non-letter characters do not activate encryption so do not invoke a shift
	* along the cipher key (i.e., "Hello World" and "HelloWorld" will be
	* encrypted/decrypted in the same way.
	*
	* @param text The text to be encrypted
	* @return The encrypted text.
	*/
	public String encrypt(String text){
		String encrypted = "";
		mono_alphabetic_cipher c;
		int counter = 0;
		for(int i = 0; i<text.length(); i++){
			if (text.charAt(i) == ' ')
				encrypted += " ";
			else {
				c = ciphers[counter%key.length()];
				encrypted += c.shift(text.charAt(i));
				counter++;
			}
		}
		return encrypted;
	}

	/**
	* Decrypts text using the poly-alphabetic cipher.
	* Spaces, punctuation, non-letter characters are unaffected by decryption.
	* Non-letter characters do not activate encryption so do not invoke a shift
	* along the cipher key (i.e., "Hello World" and "HelloWorld" will be
	* encrypted/decrypted in the same way.
	*
	* @param text The encyrpted text to be decrypted
	* @return The decrypted text.
	*/
	public String decrypt(String text){
		String decrypted = "";
		mono_alphabetic_cipher c;
		int counter = 0;
		for(int i = 0; i<text.length(); i++){
			if (text.charAt(i) == ' ')
				decrypted += " ";
			else {
				c = ciphers[counter%key.length()];
				decrypted += c.shift(text.charAt(i), true);
				counter++;
			}
		}
		return decrypted;
	}

}
