package tree;

import java.util.HashMap;
import java.util.List;

public class Solution {
	public static int fun(List<Integer> speed, List<Integer> reliability, int maxMachine) {
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i= 0;i<speed.size();i++) {
			map.put(reliability.get(i), speed.get(i))
		}
	}
	
	Collections.sort(reliability);
	int max;
	int maxq;
	int sumspeed;
	int nextSpped;
	
	for(int i=0;i<maxMachine;i++) {
		if(map.containsKey(reliability.get(i))) {
			nextSpped = map.get(reliability.get(i));
		}
		sumspeed += nextSpped;
		maxq = sumspeed*
		
		
	}
	
	
	
	
	
	
}
