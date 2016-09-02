
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class BookToFile {
	
	ObjectOutputStream oos = null;
	FileOutputStream fos = null;
	ObjectInputStream objectinputstream = null;
	ArrayList<Book> bookList = new ArrayList<Book>(); // Arraylist for serialization, deserialization
	
	
	public ArrayList<Book> addBookToList(Book i) {
		
		File f = new File("booklist.ser");
		
		if(!f.exists()) {   //Checks for existing file, if none, sends to bookSer method to create			
			bookList.add(i);
			bookSer(bookList);
			return bookList;
		} else if (bookList.isEmpty()) { //if list is empty, deserializes and assigns list
			bookRet();
			bookList.add(i);
			bookSer(bookList);
			return bookList;
		} else {                  //for all other scenarios
			bookList.add(i);
			bookSer(bookList);
			return bookList;
		}
	}//close addBooktoList
	
	public ArrayList<Book> removeBook(String title) {
		
		File f = new File("booklist.ser");
		ArrayList<Book> book = new ArrayList<Book>();
		
		if(!f.exists()) {    //Error check in case first time running and file not created
			System.out.println("Error, no books have been added.");
			return bookList;
		}
		bookRet(); //Deserializes list of Books
		
		for (int i = 0; i<=bookList.size()-1; i++) {
			if (!title.equals(bookList.get(i).titleCall())) {  //if title is not equal to Book title
				book.add(bookList.get(i));                      //add Book object to new ArrayList book
			}
		}
		bookList = book;     //sets bookList to book list and serializes
		bookSer(bookList);
		return bookList;
	}//close removeBook
	
	public ArrayList<Book> showList() { //Sorts and shows list of titles, uses bubblesort
		
		bookRet();
		Book temp;
		for(int i=0; i<bookList.size(); i++) {
			for(int j=0; j<bookList.size()-1-i; j++) {
				if(bookList.get(j).titleCall().compareTo(bookList.get(j+1).titleCall())>0) {
					temp = bookList.get(j);
			        bookList.set(j, bookList.get(j+1));
			        bookList.set(j+1, temp);
			    }
			 }
		}
		for (int i = 0; i<= bookList.size()-1; i++) {
			System.out.println(bookList.get(i).titleCall() + " by " + bookList.get(i).authorCall());
		}
		return bookList;
	}
	
	public void bookSer(ArrayList<Book> b) {
		try {
		FileOutputStream fos = new FileOutputStream("booklist.ser");  //Serializes list of Book objects
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(b);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (oos != null){
					oos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}//close bookSer
	
	public void bookRet() {
		try {
		    FileInputStream streamIn = new FileInputStream("booklist.ser");              //deserializes list of objects 
		    ObjectInputStream objectinputstream = new ObjectInputStream(streamIn);		//and assigns to list
		    ArrayList<Book> readCase = (ArrayList<Book>) objectinputstream.readObject();
		    bookList = readCase;
		} catch (FileNotFoundException e) {
			e.printStackTrace(); 
		} catch (IOException e) {
		    e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (oos != null){
					oos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
	}//close bookRet
	
}//close class