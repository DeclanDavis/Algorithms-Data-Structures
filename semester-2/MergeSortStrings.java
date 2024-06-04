public class MergeSortStrings {
  public static void main(String[] args) {
    System.out.println("MergeSort Strings!");

    String str1 = "afbdh";
    char[] letters = new char[str1.length()];

    for(int i = 0; i<str1.length(); i++){
      letters[i] = str1.charAt(i);
    }
    
    System.out.println("Before: ");
    for(char letter: letters){
      System.out.print(letter);
    }
    System.out.println();
    
    mergeSort(letters);
    
    System.out.println("After: ");
    for(char letter: letters){
      System.out.print(letter);
    }
  }

  public static void mergeSort(char[] nums){

    if(nums.length < 2){
      return ;
    }

    int midIndex = nums.length/2;
    char[] left = new char[midIndex];
    char[] right = new char[nums.length-midIndex];

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

  public static char[] merge(char[] left, char[] right, char[] nums){

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
