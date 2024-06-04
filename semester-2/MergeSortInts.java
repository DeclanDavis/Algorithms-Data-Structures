public class MergeSortInts {
  public static void main(String[] args) {
    System.out.println("MergeSort ints!");

    int[] nums = {1,4,9,3,6};
    System.out.println("Before: ");
    for(int number: nums){
      System.out.print(number);
    }
    System.out.println();
    
    mergeSort(nums);
    
    System.out.println("After: ");
    for(int number: nums){
      System.out.print(number);
    }
  }

  public static void mergeSort(int[] nums){

    if(nums.length < 2){
      return ;
    }

    int midIndex = nums.length/2;
    int[] left = new int[midIndex];
    int[] right = new int[nums.length-midIndex];

    // put values in each split
    for(int i = 0; i < left.length; i++){
      left[i] = nums[i];
    }

    for(int j = 0; j < right.length; j++ ){
      right[j] = nums[midIndex + j];
    }

    //Recur split
    mergeSort(left);
    mergeSort(right);

    merge(left,right,nums);
    
  }

  public static int[] merge(int[] left, int[] right, int[] nums){

    // 3 iterators
    int i = 0; //left
    int j = 0; //right
    int k = 0; //nums

    //keep going until both are empty
    while(i < left.length && j < right.length){
      if(left[i] <= right[j]){
        nums[k] = left[i];
        i++;
      }
      else {
        nums[k] = right[j];
        j++;
      }
      k++;
    }
    while(i < left.length){
      nums[k] = left[i];
      i++;  
       k++;
    }

    while(j < right.length){
      nums[k] = right[j];
      j++;
      k++;
    }
    return nums;
  }

  
}
