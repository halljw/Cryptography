/**
* The mono_alphabetic_cipher class implements a basic mono-alphabetic shift cipher.
* The cipher object is declared with either an integer or char key, where the
* the key refers a letter and its position in the alphabet (i.e., C/3). The int
* value denotes the extent to which an encrypted letter is shifted through the
* alphabet.
*
* @author John W. Hall, jwhall5@illinois.edu
* @version 1.0 Dec. 20, 2016
*/
public class mono_alphabetic_cipher{

	public final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public final String LOWER = "abcdefghijklmnopqrstuvwxyz";
	private char key;
	private int key_index;

	/**
	* Constructs and initializes a cipher with integer key k
	* @param k The integer representing the key
	*/
	public mono_alphabetic_cipher(int k){
		while (k >= 26)	k -= 26;
		key_index = k;
		key = UPPER.charAt(k);
	}

	/**
	* Constructs and initializes a cipher with char key k
	* @param k The char representing the key
	*/
	public mono_alphabetic_cipher(char k){
		if (Character.isUpperCase(k))
			key_index = UPPER.indexOf(k) + 1;
		else 
			key_index = LOWER.indexOf(k) + 1;
		key = UPPER.charAt(key_index);
	}

	/**
	* Returns the char representing the cipher key.
	* @return The cipher key
	*/
	public char getKey() {return key;}


	/**
	* Returns the int representing the cipher key.
	* @return The cipher key
	*/
	public int getKeyIndex() {return key_index;}

	/**
	* Sets the char representing the cipher key.
	* @param k The new cipher key
	*/
	public void setKey(char k) {
		key = k;
		if (Character.isUpperCase(k))
			key_index = UPPER.indexOf(k);
		else
			key_index = LOWER.indexOf(k);
	}

	/**
	* Sets the int representing the cipher key.
	* @param k The new cipher key
	*/
	public void setKeyIndex(int k) {
		while (k >= 26)	k -= 26;
		key_index = k;
		key = UPPER.charAt(k);
	}

	public char shift(char letter){return shift(letter, false);}

	/**
	* Returns a letter that has been shifted according to the cipher.
	* Non-letter characters are returned unaltered.
	*
	* @param letter The letter being shifted
	* @param decrypt Determines whether the shift is encryption (true) or decryption (false)
	* @return The letter resulting from the shift
	*/
	public char shift(char letter, boolean decrypt){
		String letters;
		if (Character.isUpperCase(letter))
			letters = UPPER;
		else if (Character.isLowerCase(letter))
			letters = LOWER;
		else
			return letter;

		int old_index = letters.indexOf(letter);
		int new_index;

		if(decrypt)
			new_index = old_index - key_index;
		else
			new_index = old_index + key_index;
		while (new_index >= 26)
			new_index -= 26;
		while (new_index < 0)
			new_index += 26;

		return letters.charAt(new_index);
	}

	/**
	* Returns a message that has been encrypted by the cipher.
	* Spaces, punctuation, non-letter characters are unaffected by encryption.
	*
	* @param text The message being encrypted
	* @return The encrypted text
	*/
	public String encrypt(String text){
		String encrypted = "";
		for(int i = 0; i<text.length(); i++)
			encrypted += shift(text.charAt(i));
		return encrypted;
	}

	/**
	* Returns a message that has been decrypted by the cipher.
	* Spaces, punctuation, non-letter characters are unaffected by decryption.
	*
	* @param text The encrypted message being decrypted
	* @return The decrypted text
	*/
	public String decrypt(String text){
		String decrypted = "";
		for(int i = 0; i<text.length(); i++)
			decrypted += shift(text.charAt(i), true);
		return decrypted;
	}

}
