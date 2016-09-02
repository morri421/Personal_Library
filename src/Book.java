
public class Book implements java.io.Serializable {
	
		 private int currentPage;
		 private String genre;
		 private String author;
		 private String title;
		 private Boolean readAgain;
		 
		 //Accessors
		 public int pageCount() {
			 return currentPage;
		 }
		 public String genreCall() {
			 return genre;
		 }
		 public String authorCall() {
			 return author;
		 }
		 public String titleCall() {
			 return title;
		 }
		 public Boolean keeperCall() {
			 return readAgain;
		 }
		 
		 //Mutators
		 public void setPage(int pageNum) {
			 currentPage = pageNum;
		 }
		 public void setGenre(String genreIn) {
			 genre = genreIn;
		 }
		 public void setAuthor(String authorIn) {
			 author = authorIn;
		 }
		 public void setTitle(String titleIn) {
			 title = titleIn;
		 }
		 public void setKeeper(Boolean keeperIn) {
			 readAgain = keeperIn;
		 }
}

