package scanner;

import java.util.*;

/**
 * A class for the WordCount data structure.
 * A WordCount object is a map which pairs a word (string)
 * with a list of information (Info)
 */
//Ϊÿһ������������Ϣ�б�ͳ��Ƶ��
public class WordCount {

	//�������ʺ���Ϣlist��map����
	private Map<String,List<Info>> wordTable;
	
	/**
	 * Builds an empty WordCount
	 */
	public WordCount() 
	{
		//ʹ��TreeMap��HashMap
		wordTable = new TreeMap<String,List<Info>>();
	}
	
	/**
	 * Adds the given 'info' in the list of
	 * Infos of the given word 'word'
	 */
	
	public void add(String word, Info info)
	{
		//���ݲ���,�Ȼ�ȡָ�����ʵ�info�б�
		List<Info> list = wordTable.get(word);
		if ( list == null ) 
		{
			//newһ���µ�list����,����listд��word�ļ�ֵ
			list = new LinkedList<Info>();
			wordTable.put(word, list);
		}
		//��infoָ��word��list
		list.add(info);
	}
	
	/**
	 * Returns an iterator over the informations of
	 * the given word 'word'. If 'word' has no information
	 * returns null
	 */
	//��ȡָ�����ʵ���Ϣ��ĵ�����
	public Iterator<Info> getListIterator(String word)
	{
		List<Info> list = wordTable.get(word);
		if ( list == null )
			return null;
		return list.iterator();
	}
	
	/**
	 * Displays the WordCount on System.out
	 */
	public void display() 
	{
		//�������еĴʻ�
		for ( String word : wordTable.keySet() ) 
		{
			//��ȡָ�����ʵ���Ϣ��
			List<Info> list = wordTable.get(word);
			System.out.print(word + " " + "(" + list.size() + "): ");
			
			for ( Info info : list ) 
			{
				System.out.print(info + " ");
			}
			System.out.println();
		}
	}
}