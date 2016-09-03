
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
	
	@SuppressWarnings("finally")
	public ArrayList<Book> bookRet() {
		ArrayList<Book> bookList = new ArrayList<Book>();
		try {
		    FileInputStream streamIn = new FileInputStream("booklist.ser");              //deserializes list of objects 
		    ObjectInputStream objectinputstream = new ObjectInputStream(streamIn);		//and then returns list
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
			return bookList;
		}
	}//close bookRet
	
}//close class