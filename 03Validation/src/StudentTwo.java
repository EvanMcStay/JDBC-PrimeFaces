import javax.faces.bean.ManagedBean;

/**
 * @author Evan McStay
 *
 */
@ManagedBean
public class StudentTwo 
{
	//Class Level Variables 
	private String firstName, lastName; 
	private int postalCode, freePasses;
	
	//No Argument Constructor
	public StudentTwo()
	{
		
	}

	public int getFreePasses() 
	{
		return freePasses;
	}

	public void setFreePasses(int freePasses) 
	{
		this.freePasses = freePasses;
	}

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

	public int getPostalCode() 
	{
		return postalCode;
	}

	public void setPostalCode(int postalCode) 
	{
		this.postalCode = postalCode;
	}
}
