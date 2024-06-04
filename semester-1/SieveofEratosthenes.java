public class sieveEratosthenes{
	public static void main(String[] args){
		
		int N =100;
		boolean[] numArray = new boolean[N+1];
		
		//fill array with true
		for(int i=2;i<numArray.length;i++){
			numArray[i]=true;
		}
		
		//all non-primes set to false
		for(int i=2;i<numArray.length;i++){
			if(numArray[i]){
				for(int j=2;(i*j)<numArray.length;j++){
					numArray[i*j]=false;
				}
			}
		}
		
		//print array
		for(int i=0;i<numArray.length;i++){
			if(numArray[i]){
				System.out.println(i+" is a prime");
			}
			else{
				System.out.println(i+" is not a prime");
			}
		}
	}
}
