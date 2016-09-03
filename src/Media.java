
public class Media implements java.io.Serializable {
	
	private String title;
	private String borrower;
	
	//Accesors
	public String titleCall() {
		 return title;
	 }
	public String borrowerCall() {
		 return borrower;
	 }
	//Mutators
	public void setTitle(String titleIn) {
		 title = titleIn;
	 }
	public void setBorrower(String borrow) {
		 borrower = borrow;
	 }
	
}
