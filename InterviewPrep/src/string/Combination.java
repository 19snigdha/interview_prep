package string;
import java.util.*;

public class Combination {

	public static void combinationEasy(char[] str) {
		List<Character> result = new ArrayList<>();
		Arrays.sort(str);
		combinationUtil(result,str,0);
	}
	
	public static void combinationUtil(List<Character> result, char[] str, int level) {
		result.forEach(r1->System.out.print(r1+" "));
		System.out.println();
		for(int index = level;index<str.length;index++) {
			if(index !=level && str[index] == str[index-1]) {
				continue;
			}
			result.add(str[index]);
			combinationUtil(result,str,level+1);
			result.remove(result.size()-1);
			
		}
	}

	
	public static void main(String args[]) {
		String str = "aabc";
		combinationEasy(str.toCharArray());
	}
}
