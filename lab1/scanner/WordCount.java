package scanner;

import java.util.*;

/**
 * A class for the WordCount data structure.
 * A WordCount object is a map which pairs a word (string)
 * with a list of information (Info)
 */
//为每一个单词生成信息列表并统计频次
public class WordCount {

	//建立单词和信息list的map容器
	private Map<String,List<Info>> wordTable;
	
	/**
	 * Builds an empty WordCount
	 */
	public WordCount() 
	{
		//使用TreeMap或HashMap
		wordTable = new TreeMap<String,List<Info>>();
	}
	
	/**
	 * Adds the given 'info' in the list of
	 * Infos of the given word 'word'
	 */
	
	public void add(String word, Info info)
	{
		//根据参数,先获取指定单词的info列表
		List<Info> list = wordTable.get(word);
		if ( list == null ) 
		{
			//new一个新的list对象,将空list写入word的键值
			list = new LinkedList<Info>();
			wordTable.put(word, list);
		}
		//将info指向word的list
		list.add(info);
	}
	
	/**
	 * Returns an iterator over the informations of
	 * the given word 'word'. If 'word' has no information
	 * returns null
	 */
	//获取指定单词的信息表的迭代器
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
		//迭代所有的词汇
		for ( String word : wordTable.keySet() ) 
		{
			//获取指定单词的信息表
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