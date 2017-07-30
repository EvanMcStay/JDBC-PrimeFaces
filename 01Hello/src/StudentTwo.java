import javax.faces.bean.ManagedBean;

/**
 * @author Evan McStay
 * 
 * This class is used to manage the beans for the student two response. The managed beans are the business 
 * logic of the MVC architecture. 
 */

@ManagedBean
public class StudentTwo 
{
	//Fields -- Class level variables
	private String firstName, lastName, postalCode, studentEmail;
	private int freePasses, studentAge;

	//Create a no argument constructor
	public StudentTwo()
	{
		
	}
	
	//Getters and Setters for Class level variables (can generate)
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

	public int getFreePasses() 
	{
		return freePasses;
	}

	public void setFreePasses(int freePasses) 
	{
		this.freePasses = freePasses;
	}

	public String getPostalCode() 
	{
		return postalCode;
	}

	public void setPostalCode(String postalCode) 
	{
		this.postalCode = postalCode;
	}
	
	public String getStudentEmail() 
	{
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) 
	{
		this.studentEmail = studentEmail;
	}

	public int getStudentAge() 
	{
		return studentAge;
	}

	public void setStudentAge(int studentAge) 
	{
		this.studentAge = studentAge;
	}
}
