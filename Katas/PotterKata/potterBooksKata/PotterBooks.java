package potterBooksKata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class PotterBooks {

	private static int book1 = 0, book2 = 0, book3 = 0, book4 = 0, book5 = 0;
	
	public static void main(String[] args) throws IOException {

		PotterBooks bookSets = new PotterBooks();
		bookSets.menu();
	}

	private void menu() throws IOException {
		
		int[] bookArray = new int[5];
		
		System.out.println("Enter the number of copies for each books:");
		BufferedReader bookCount = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Book 1: ");
		try{
            book1 = Integer.parseInt(bookCount.readLine());
        }catch(NumberFormatException nfe){
            System.err.println("Invalid Format!");
        }
		bookArray[0] = book1;
		System.out.print("Book 2: ");
		try{
            book2 = Integer.parseInt(bookCount.readLine());
        }catch(NumberFormatException nfe){
            System.err.println("Invalid Format!");
        }
		bookArray[1] = book2;
		System.out.print("Book 3: ");
		try{
            book3 = Integer.parseInt(bookCount.readLine());
        }catch(NumberFormatException nfe){
            System.err.println("Invalid Format!");
        }
		bookArray[2] = book3;
		System.out.print("Book 4: ");
		try{
            book4 = Integer.parseInt(bookCount.readLine());
        }catch(NumberFormatException nfe){
            System.err.println("Invalid Format!");
        }
		bookArray[3] = book4;
		System.out.print("Book 5: ");
		try{
            book5 = Integer.parseInt(bookCount.readLine());
        }catch(NumberFormatException nfe){
            System.err.println("Invalid Format!");
        }
		bookArray[4] = book5;
		
		for (int i = 0; i < 5; i++){
			System.out.println(bookArray[i]);
		}
	}

}

