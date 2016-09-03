
public class Book extends Media implements java.io.Serializable {
	
		 private String genre;
		 private String author;
		 private String title;
		 private String borrower;
		 
		 //Accessors
		 public String genreCall() {
			 return genre;
		 }
		 public String authorCall() {
			 return author;
		 }
		 public String titleCall() {
			 return title;
		 }
		 public String borrowerCall() {
			 return borrower;
		 }
		 
		 //Mutators
		 public void setGenre(String genreIn) {
			 genre = genreIn;
		 }
		 public void setAuthor(String authorIn) {
			 author = authorIn;
		 }
		 public void setTitle(String titleIn) {
			 title = titleIn;
		 }
		 public void setBorrower(String borrow) {
			 borrower = borrow;
		 }
}

