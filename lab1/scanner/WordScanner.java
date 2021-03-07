package scanner;

import java.io.*;

/**
 * This class implements a word (string) scanner
 */
//ɨ������еĵ���
public class WordScanner
{

	private BufferedReader input; //����һ��input�ļ�
	private String line; // ��ȡ��ǰ����
	private int charPos; // �ַ��ڵ�ǰ���е�λ��
	private int lineNum; // ��ǰ�е��к�
	
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
	//�Ӵ��׿�ʼ�������ʵ�Ԫ��,ֱ���������ǵ���Ԫ��,��д��word����(�ַ�������Ϣ(λ�ú��к�))
	public Word nextWord() throws IOException //��������һ��������Ϣ
	{
		int start = charPos;//��¼�ڵ�ǰ�еĳ�ʼλ��start
		charPos++;
		boolean isWord = true; //�жϵ�ǰ�ַ��Ƿ����ڵ���
		
		while ( charPos < line.length() && isWord ) 
		{
			char c = line.charAt(charPos);
			if ( isLetter(c) || ( c == '\'' && charPos + 1 < line.length() && isLetter(line.charAt(charPos+1) ) ) )
				charPos++;
			else  //���ɨ�赽�ո����������,�������ǰ������ʵ�ɨ��
				isWord = false;
		}
		Word w = new Word(line.substring(start, charPos),new Info(start+1,lineNum));
		moveToNextWord(); //��ָ���ƶ�����һ�����ʵ�λ��
		return w;
	}
	
	/**
	 * Returns true if there is at least
	 * one word left in the input, false otherwise
	 */
	public boolean hasNextWord()  //һ����������Ҳ�϶�Ϊֻ��һ��,����ж������Ƿ�Ϊ�ռ���
	{
		return line != null;
	}
	
	//��charPos��ʼɨ��,������β����Ч�ַ�,ֱ���ҵ���ĸ�ַ�����ѭ��
	private void moveToNextWord() throws IOException 
	{
		boolean hasLetter = true;
		while ( line != null && hasLetter ) 
		{
			if ( charPos == line.length() ) //���ָ��ɨ�赽�е����һ��λ��
			{
				line = input.readLine();  //�����µ�һ��,�����ַ�ָ��,�кż�1
				charPos = 0;
				lineNum++;
			}
			else if ( ! isLetter(line.charAt(charPos)) )//�����϶����ʵ����ַ�һ������ĸ
				charPos++;
			else
				hasLetter = false;
		}
	}
	
	private boolean isLetter(char c) {
		return 'a' <= c && c <= 'z' || 'A' <= c && c <= 'Z';
	}	
}