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
		
		//Scans for current page and sets current page
		System.out.println("Please enter the current page your on in the book: ");
		while (!inputInfo.hasNextInt()) {
			System.out.println("Wrong! Try again!");
			inputInfo.next();
        }
		int createdPage = inputInfo.nextInt(); 
		newBook.setPage(createdPage);
		
		//Scans for keeper and sets keeper
		System.out.println("Please enter whether or not you'll keep the book: ");
		System.out.println("-- 'true' or 'false' --");
		while (!inputInfo.hasNextBoolean()) {
			System.out.println("Wrong! Try again!");
			inputInfo.next();
        }
		Boolean createdKeeper = inputInfo.nextBoolean();
		newBook.setKeeper(createdKeeper);
		
		//inputInfo.close(); //Closes scanner system, keep commented out, system.in cant be reopened once closed
		//test(newBook);  //Test for object inputs
		return newBook;    //Returns created book
	}
	
	
	//public void test(Book test) {   //Tests variables in Book object
		//System.out.println(test.pageCount());
		//System.out.println(test.genreCall());
		//System.out.println(test.authorCall());
		//System.out.println(test.titleCall());
		//System.out.println(test.keeperCall());
	//}
}
