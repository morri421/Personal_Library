import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ListMa {  //short for ListManipulation
	
	File f = new File("booklist.ser");
	
	public void addBookToList(Book i) {
		
		if(!f.exists()) {    //Error check in case first time running and file not created
			BookToFile bookFile = new BookToFile();       
			ArrayList<Book> temp = new ArrayList<Book>(); //makes initial list for serialization
			temp.add(i);
			bookFile.bookSer(temp); //sends list to serialzer
			return;
		} else {
			BookToFile bookFile = new BookToFile();    
			ArrayList<Book> temp = bookFile.bookRet();  //deserializes saved list and assigns to temp list
			temp.add(i);								//adds new book object to temp list
			bookFile.bookSer(temp);  					// sends temp list to serializer
		}
		System.out.println("");
		System.out.println("Book has been added to library database.");
		System.out.println("");
	}
	//close addBooktoList
	
	public void removeBook(String title) {
		
		ArrayList<Book> book = new ArrayList<Book>();
		
		if(!f.exists()) {    //Error check in case first time running and file not created
			System.out.println("Error, no books have been added.");
			System.out.println("");
			return;
		}
		BookToFile temp = new BookToFile(); 
		ArrayList<Book> bookList = temp.bookRet(); //Deserializes list of Books
		
		for (int i = 0; i<=bookList.size()-1; i++) {
			if (!title.equals(bookList.get(i).titleCall())) {  //if title is not equal to Book title
				book.add(bookList.get(i));                      //add Book object to new ArrayList book
			}
		}
		bookList = book;     //sets bookList to book list and serializes
		temp.bookSer(bookList);
		System.out.println("");
		System.out.println("The book titled, '" + title + "', has been removed.");
		System.out.println("");
	}//close removeBook
	
	public void showList() { //Sorts and shows list of titles, uses bubblesort
		
		if(!f.exists()) {    //Error check in case first time running and file not created
			System.out.println("Error, no books have been added.");
			System.out.println("");
			return;
		}
		
		BookToFile tempList = new BookToFile();
		ArrayList<Book> bookList = tempList.bookRet(); //deserializes stored list and assigns to a temp list
		Book temp;
		for(int i=0; i<bookList.size(); i++) {
			for(int j=0; j<bookList.size()-1-i; j++) {   //bubble sort method by author
				if(bookList.get(j).authorCall().compareTo(bookList.get(j+1).authorCall())>0) {  
					temp = bookList.get(j);
			        bookList.set(j, bookList.get(j+1));
			        bookList.set(j+1, temp);
			    }
			 }
		}
		tempList.bookSer(bookList);  //sends temp sorted list to be serialized
		System.out.println("");
		System.out.println("Below is the complete list:");
		System.out.println("");
		for (int i = 0; i<= bookList.size()-1; i++) { //prints out newly sorted list, title and author
			System.out.println(bookList.get(i).titleCall() + " by " + bookList.get(i).authorCall());
		}
		System.out.println("");
	}
	
	public void exportList() {
		
		if(!f.exists()) {    //Error check in case first time running and file not created
			System.out.println("Error, no books have been added.");
			System.out.println("");
			return;
		}
		ArrayList<String> exList = new ArrayList<String>();  //temp list for booklist file creation
		BookToFile tempList = new BookToFile();
		ArrayList<Book> bookList = tempList.bookRet(); //deserializes saved list to iterate through
		
		for (int i = 0; i<=bookList.size()-1; i++) {  
			String tempStr = bookList.get(i).titleCall() + " by " + bookList.get(i).authorCall(); //abstracts info and converts to string  
			exList.add(tempStr); //adds string to temporary list exList
		}
		ArrayList<String> borList = new ArrayList<String>(); //temp list for borrowedlist file creation
		String comStr = "none";								//string value to compare to abstracted information
		for (int i = 0; i<=bookList.size()-1; i++) {
			if (!comStr.equals(bookList.get(i).borrowerCall())) { //if borrower value is not 'none', assign to temp list borList
				String tempStr = bookList.get(i).titleCall() + " borrowed by " + bookList.get(i).borrowerCall();
				borList.add(tempStr);
			}
		}
		Path file = Paths.get("booklist.txt");  //file will be created with this name in current directory
		try {
		Files.write(file, exList, Charset.forName("UTF-8")); //booklist created with exList
		} catch (IOException e) {
			e.printStackTrace();
		}
		Path file2 = Paths.get("borrowedlist.txt"); //file will be created with this name in current directory
		try {
		Files.write(file2, borList, Charset.forName("UTF-8")); //borrowedlist created with borList
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("");
		System.out.println("Lists exported to current directory.");
		System.out.println("");
	}

}
	
