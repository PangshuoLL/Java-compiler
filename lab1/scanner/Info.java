package scanner;

/**
 * A class for the Info objects.
 * An Info object stores the line number and
 * the first character position of a word in an input
 */
public class Info {
	
	//定义字符所在的位置和行号
	private int charPos;
	private int lineNum;
	
	/**
	 * Builds an Info object with the given
	 * character position 'charPos' and line
	 * number 'lineNum'
	 */
	//构造函数
	public Info(int charPos, int lineNum) {
		this.charPos = charPos;
		this. lineNum = lineNum;
	}
	
	//下部为get and set 方法
	/**
	 * Returns the character position 
	 * of this Info
	 */
	public int getCharPos() {
		return charPos;
	}
	
	/**
	 * Returns the line number
	 * of this Info
	 */	
	public int getLineNum() {
		return lineNum;
	}
	
	/**
	 * Returns a String representation of
	 * this Info in the form "[ln:cp]"
	 * where ln is the line number and
	 * cp the character position
	 */
	public String toString() {
		return "[" + lineNum + ":" + charPos + "]";
	}
}