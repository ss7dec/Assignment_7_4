//Assignment 7.4

//Write a program that finds all anagram sets from a list of words. Anagrams are those words in 
//which there are same characters jumbled. For example -> GOD - DOG ARE ANAGRAMS. Both
//words have same characters but in jumbled order.
//Input: listen, pot, part, opt, trap, silent, top, this, hello, hits, what, shit ------- 
//Output: { listen, silent} { part, trap } { pot, opt, top }{ this, hits, shit }

//Two or more Strings are called as Anagrams, if they contains same characters but on different 
//order e.g. army and Mary, stop and pots etc. Anagrams are actually mix-up of characters in String.


package assignment_7_4;

import java.util.*;
public class Anagram_Demo{
	public static ArrayList<ArrayList<Integer>> anagram(final List<String> a) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();

		for(int i = 0; i < a.size(); i++){
			//we take the array element and break down each word to character array
			char[] c = a.get(i).toCharArray();
			Arrays.sort(c);//we sort all the character array alphabetically
			String t = String.valueOf(c);//put the value in string t
			if(map.get(t) == null){
				//we map the value to t
				ArrayList<Integer> l = new ArrayList<Integer>();
				l.add(i+1);
				map.put(t, l);
			}
			else
				map.get(t).add(i + 1);
		}
		for(ArrayList<Integer> l : map.values()){
			// if(l.size() > 1) {
			result.add(l);
			//}
		}

		return result;
	}
	public static void main(String[] args){
		//creating an Arraylist of the given input. All inputs should be in lower case
		List<String> a = new ArrayList<String>();
		a.add("listen");
		a.add("pot");
		a.add("part");
		a.add("opt");
		a.add("trap");
		a.add("silent");
		a.add("top");
		a.add("this");
		a.add("hello");
		a.add("hits");
		a.add("what");
		a.add("shit");
		
		//put these values into anagram function and output
		ArrayList<ArrayList<Integer>> result = anagram(a);
		System.out.println("Anagram Examples from a selected list are enlisted below: \n");
		for(int i = 0; i < result.size(); i++){
			System.out.print("[");
			for(int j : result.get(i))
				System.out.print(a.get(j-1) + " ");
			System.out.println("]");
			
		}
	}
	
}