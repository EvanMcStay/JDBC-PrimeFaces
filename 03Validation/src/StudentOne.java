import javax.faces.bean.ManagedBean;

/**
 * @author Evan McStay
 *
 */

@ManagedBean
public class StudentOne 
{
	//Class Level Variables/Fields
	private String firstName, lastName, email;

	//No Argument Constructor
	public StudentOne()
	{
		
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

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}
}
