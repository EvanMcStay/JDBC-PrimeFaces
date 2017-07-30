import javax.faces.bean.ManagedBean;

/**
 * @author Evan McStay
 * Class used in StudentDataUtil for the ArrayList 
 * Controller in the MVC architecture (The managed bean class)
 */
@ManagedBean
public class Student 
{
	//Class-level variables
	private String firstName, lastName, email;
	
	//No Argument Constructor
	public Student() {	}
	
	//Constructor with two string parameters
	public Student(String firstName, String lastName, String email) 
	{	
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	//Setters and getters
	public String getFirstName() 
	{
		return firstName;
	}

	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}

	public String getLastName() 
	{
		return lastName;
	}

	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}
}
