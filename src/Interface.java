import java.util.ArrayList;
import java.util.Scanner;

public class Interface {

	public void optionChoice() {
		//Opens scanner system for inputs
		Scanner inputChoice = new Scanner(System.in);  
		System.out.println("-- Please choose an option below --");
		System.out.println("-- Select '1' to Create Book --");
		System.out.println("-- Select '2' to Delete Book --");
		System.out.println("-- Select '3' to List Books --");
		System.out.println("-- Select '0' to Exit Program --");
		//Checks to make sure scanner input is integer		
		while (!inputChoice.hasNextInt()) { 
			System.out.println("-- That is not an option. Please try again! --");
			System.out.println("");
			System.out.println("-- Please choose an option below --");
			System.out.println("-- Select '1' to Create Book --");
			System.out.println("-- Select '2' to Delete Book --");
			System.out.println("-- Select '3' to List Books --");
			System.out.println("-- Select '0' to Exit Program --");
			inputChoice.next();
        }
		int optionChosen = inputChoice.nextInt();
		
		boolean programLife = true; //variable to kill the program
		
		while (programLife = true) {
		if (optionChosen == 0) { //Kills program
			programLife = false;
			break;
		}
		
		else if (optionChosen == 1) { //Create Book Selection interface option
			
			BookCreator newBook = new BookCreator(); //constructor to create new BookCreator object
			Book forFile = newBook.createBook(); //runs createBook method, returns Book for file
			BookToFile b = new BookToFile(); // constructor to create new BooktoFile object
			b.addBookToList(forFile); //runs addBookToList to add book to list and serializes
			optionChoice(); //reloops the option chooser after selection
			break;
			
		} else if (optionChosen == 2) { //Delete Book Selection
			
			BookToFile a = new BookToFile();
			Scanner dBook = new Scanner(System.in);  
			System.out.println("-- Please type a book title to delete --");
			String dbChosen = inputChoice.next();
			a.removeBook(dbChosen);
			optionChoice();
			break;
		
		} else if (optionChosen == 3) {
			
			BookToFile c = new BookToFile();
			c.showList();
			optionChoice();
			break;
			
		} else {  //Error checking for wrong numbers for interface selection
			System.out.println("-- That is not an option. Please try again! --");
			System.out.println("");
			optionChoice();
			break;
		}
		}
	}
}