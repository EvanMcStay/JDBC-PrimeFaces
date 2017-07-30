import javax.faces.bean.ManagedBean;

/**
 * @author Evan McStay | IST411 Midterm 2 | 
 * Hotel Booking with JSF and PrimeFaces | March 17, 2017 
 * Model
 */
@ManagedBean
public class PersonalInformation 
{
	//Class-level variables
	private String firstName, lastName, email,
				   creditCardNum, ccvNum;
	
	//No Argument Constructor
	public PersonalInformation() {}

	//First name getters and setters
	public String getFirstName() 
	{
		return firstName;
	}

	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}

	//Last name getters and setters
	public String getLastName() 
	{
		return lastName;
	}

	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}

	//Email getters and setters
	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	//Credit card number getters and setters
	public String getCreditCardNum() 
	{
		return creditCardNum;
	}

	public void setCreditCardNum(String creditCardNum) 
	{
		this.creditCardNum = creditCardNum;
	}

	//CCV number getters and setters
	public String getCcvNum() 
	{
		return ccvNum;
	}

	public void setCcvNum(String ccvNum) 
	{
		this.ccvNum = ccvNum;
	}
}