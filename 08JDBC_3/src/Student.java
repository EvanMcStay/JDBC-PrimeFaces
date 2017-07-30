import javax.annotation.ManagedBean;

/**
 * @author Evan McStay
 * DAO Architecture - Controller 
 */
@ManagedBean
public class Student 
{
	//Class level variables
	private int id; 
	private String firstName, lastName, email;
	
	//No-Argument Constructor
	public Student() {}
	
	//Overriding Constructor 
	public Student(int id, String firstName, String lastName, String email)
	{
		//Self referencing variables (this class variable = passed variable)
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	//ID Getters and Setters
	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	//First Name Getters and Setters
	public String getFirstName() 
	{
		return firstName;
	}

	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}
	
	//Last Name Getters and Setters
	public String getLastName() 
	{
		return lastName;
	}

	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}

	//Email Getters and Setters
	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}
	
	//To-String method
	@Override
	public String toString()
	{
		return "student[id:" + id + ", firstName:" + firstName + 
			   ", lastName:" + lastName + ", email:" + email + "]";
	}
}