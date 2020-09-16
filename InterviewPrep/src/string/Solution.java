package string;

public class Solution {

	
	
	
	
	    public int trap(int[] height) {
	     
	    int left = 0, right = height.length - 1;
	    int ans = 0;
	    int left_max = 0, right_max = 0;
	    while (left < right) {
	        if (height[left] < height[right]) {
	            if (left_max>0)
					height[left] = (left_max = height[left]);
				else
					height[left] = ans += (left_max - height[left]);
	            ++left;
	        }
	        else {
	            if (right_max>0)
					height[right] = (right_max = height[right]);
				else
					height[right] = ans += (right_max - height[right]);
	            --right;
	        }
	    }
	    return ans;
	    }
	
}
