package string;

import java.util.*;

public class Permute {
	
	public static List<String> permute(char[] str){
		Map<Character, Integer> countMap = new TreeMap();
		for(char ch:str) {
			countMap.compute(ch, (key,val) ->{
				if(val == null) {
					return 1;
				}
				else {
					return val+1;
				}
			});
		}
			char input[] = new char[countMap.size()];
			int count[] = new int[countMap.size()];
			
			int index = 0;
			for(Map.Entry<Character, Integer> entry:countMap.entrySet()) {
				input[index] = entry.getKey();
				count[index] = entry.getValue();
				index++;
			}
			List<String> resultList = new ArrayList<>();
			char result[] = new char[str.length];
			permuteUtil(result,resultList,input,count,0);
			return resultList;
			
		
	}
	
	public static void permuteUtil(char[] result, List<String>resultList, char[] input, int[] count, int level) {
		if(level == result.length) {
			resultList.add(new String(result));
		}
		
		for(int i =0;i<input.length;i++) {
			if(count[i] == 0)
				continue;
			result[level] = input[i];
			count[i]--;
			permuteUtil(result,resultList, input,count,level+1);
			count[i]++;
			
		}
		
	}
	
	
	public static void main(String args[]) {
		String str = "aabc";
		permute(str.toCharArray());
		
	}

}
