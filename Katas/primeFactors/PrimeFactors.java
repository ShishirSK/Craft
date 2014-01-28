package primeFactors;

import java.util.*;

public class PrimeFactors {

//public static void generate(int x){
public static List<Integer> generate(int x){	

	List<Integer> primes = new ArrayList<Integer>();
// Key - All numbers can be broken down into product of primes. 	
	for(int prime=2; x > 1; prime++){
		for(; x%prime == 0; x = x/prime){
				primes.add(prime);
		}
	}

	System.out.println("Prime Factors are: " + primes);
	return primes;
}
}
