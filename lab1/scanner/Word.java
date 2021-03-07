package scanner;

/**
 * A class for Word
 */
public class Word {

	//���嵥���ַ���
	//����ʵ��info,��¼���ʵ�λ�ú��к���Ϣ
	private String word;
	private Info info;
	
	/**
	 * Builds a Word object with the actual
	 * word (string) 'word' and the information 'info'
	 */
	public Word(String word, Info info) {
		this.word = word;
		this.info = info;
	}
	
	/**
	 * Returns the actual word (string)
	 * of this Word
	 */
	public String getWord() {
		return word;
	}
	
	/**
	 * Returns the information (Info)
	 * of this Word
	 */
	public Info getInfo() {
		return info;
	}
	
	/**
	 * Returns a String representation
	 * of this Word
	 * (for testing/debugging only)
	 */
	//���ص��ʺ���Ϣ��
	public String toString() {
		return word + " " + info;
	}
}
