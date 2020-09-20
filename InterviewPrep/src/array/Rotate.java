
public class Rotate {
	public static void main(String args[]) {
		int[] nums = {1,2,3,4,5,6,7};
//		int[] nums = {-1,-100,3,99};
		int k = 3;
				
		nums = rotate(nums,k);
		nums = rotate_temp(nums,k);
		nums = rotate_reverse(nums,k);

        for(int i=0;i<nums.length;i++){
          System.out.print(nums[i]+" "); 
          
      }
      System.out.println();
	}
	
	//brute force 
	public static int[] rotate(int[] nums, int k) {
		int n = nums.length, idx = 0;
        while(idx<k){
            int temp = nums[n-1];
            for(int i=n-1;i>0;i--){
                nums[i] = nums[i-1];
            }
            nums[0] = temp;
            idx++;
        }
        return nums;
	}
	
	//using temp array
	public static int[] rotate_temp(int[] nums, int k) {
		int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
        return nums;
	}
	
	public static int[] reverse(int[] nums, int start, int end) {
		while (start < end) {
		      int temp = nums[start];
		      nums[start] = nums[end];
		      nums[end] = temp;
		      start++;
		      end--;
		    }
		return nums;
	}
	//using temp array
	public static int[] rotate_reverse(int[] nums, int k) {
		k = k%nums.length;
		nums = reverse(nums,0,nums.length-1);
		nums = reverse(nums,0,k-1);
		nums = reverse(nums,k,nums.length-1);
		 
		return nums;
	}
}
