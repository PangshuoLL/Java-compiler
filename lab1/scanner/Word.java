package scanner;

/**
 * A class for Word
 */
public class Word {

	//定义单词字符串
	//引用实体info,记录单词的位置和行号信息
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
	//返回单词和信息串
	public String toString() {
		return word + " " + info;
	}
}
