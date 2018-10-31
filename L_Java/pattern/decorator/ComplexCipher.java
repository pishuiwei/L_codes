package decorator;

public class ComplexCipher extends CipherDecorator{

	public ComplexCipher(Cipher cipher) {
		super(cipher);
	}
	
	@Override
	public String encrypt(String plainText) {
		String result =  super.encrypt(plainText);
		result = reverse(result);
		return result;
	}
	
	/** 新增加的职责 */
	public String reverse(String text) {
		String string = "";
		for (int i = text.length(); i > 0; i--) {
			string+=text.substring(i-1, i);
		}
		return string;
	}
	
}
