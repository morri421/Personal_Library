import java.util.Scanner;

public class BookCreator {
	
	public Book createBook() { //Create Book Object, make its own class, set interface to scan for numerical options
		
		System.out.println("Please add the following information.");
		
		Book newBook = new Book(); //Creates empty book object
		Scanner inputInfo = new Scanner(System.in);  //Opens scanner system for inputs
		
		// Scans for title and sets title
		System.out.println("Please enter the title of the book: ");
		String createdTitle = inputInfo.nextLine(); 
		newBook.setTitle(createdTitle);
		
		//Scans for author and sets author
		System.out.println("Please enter the author of the book: ");
		String createdAuthor = inputInfo.nextLine(); 
		newBook.setAuthor(createdAuthor);
		
		//Scans for genre and sets genre
		System.out.println("Please enter the genre of the book: ");
		String createdGenre = inputInfo.nextLine(); 
		newBook.setGenre(createdGenre);
		
		//Scans for name of borrower and sets borrower
		System.out.println("Please enter name of who borrowed book: ");
		System.out.println("-- 'name of person' or 'none' --");
		String newBorrower = inputInfo.nextLine();
		newBook.setBorrower(newBorrower);
		
		return newBook;    //Returns created book
	}
}
