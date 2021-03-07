package scanner;

import java.io.*;

/**
 * This class implements a word (string) scanner
 */
//扫描句子中的单词
public class WordScanner
{

	private BufferedReader input; //读入一个input文件
	private String line; // 获取当前的行
	private int charPos; // 字符在当前行中的位置
	private int lineNum; // 当前行的行号
	
	/**
	 * Builds a WordScanner object based on the given input
	 */
	public WordScanner(FileReader input) throws IOException
	{
		this.input = new BufferedReader(input);
		this.line = this.input.readLine();
		this.charPos = 0;
		this.lineNum = 1;
		moveToNextWord();
	}
	
	/**
	 * Returns the next word from input
	 * Precond: there must be at least
	 * one word left in the input
	 * (i.e. hasNextWord() must evaluate to true)
	 */
	//从词首开始遍历单词的元素,直到遍历到非单词元素,并写入word对象(字符串和信息(位置和行号))
	public Word nextWord() throws IOException //用来返回一个单词信息
	{
		int start = charPos;//记录在当前行的初始位置start
		charPos++;
		boolean isWord = true; //判断当前字符是否属于单词
		
		while ( charPos < line.length() && isWord ) 
		{
			char c = line.charAt(charPos);
			if ( isLetter(c) || ( c == '\'' && charPos + 1 < line.length() && isLetter(line.charAt(charPos+1) ) ) )
				charPos++;
			else  //如果扫描到空格或其他符号,则结束当前这个单词的扫描
				isWord = false;
		}
		Word w = new Word(line.substring(start, charPos),new Info(start+1,lineNum));
		moveToNextWord(); //将指针移动到下一个单词的位置
		return w;
	}
	
	/**
	 * Returns true if there is at least
	 * one word left in the input, false otherwise
	 */
	public boolean hasNextWord()  //一个单词我们也认定为只有一行,因此判断行数是否为空即可
	{
		return line != null;
	}
	
	//从charPos开始扫描,跳过行尾和无效字符,直到找到字母字符跳出循环
	private void moveToNextWord() throws IOException 
	{
		boolean hasLetter = true;
		while ( line != null && hasLetter ) 
		{
			if ( charPos == line.length() ) //如果指针扫描到行的最后一个位置
			{
				line = input.readLine();  //读入新的一行,更新字符指针,行号加1
				charPos = 0;
				lineNum++;
			}
			else if ( ! isLetter(line.charAt(charPos)) )//我们认定单词的首字符一定是字母
				charPos++;
			else
				hasLetter = false;
		}
	}
	
	private boolean isLetter(char c) {
		return 'a' <= c && c <= 'z' || 'A' <= c && c <= 'Z';
	}	
}