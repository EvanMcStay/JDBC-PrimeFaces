import javax.faces.bean.ManagedBean;

/**
 * @author Evan McStay
 * 
 * This class is used to manage the beans for the student response. The managed beans are the business 
 * logic of the MVC architecture. 
 */

@ManagedBean
public class Student 
{
	//Class level variables
	private String firstName, lastName, email;  
	
	//Create a no argument constructor
	public Student()
	{
		
	}

	//Define getters/setters
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
