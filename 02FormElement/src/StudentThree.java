import javax.faces.bean.ManagedBean;

/**
 * @author Evan McStay
 */

@ManagedBean
public class StudentThree 
{
	//Class level variables
	private String firstName, lastName, favoriteLanguage;
	
	//No Argument Constructor
	public StudentThree()
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

	public String getFavoriteLanguage() 
	{
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) 
	{
		this.favoriteLanguage = favoriteLanguage;
	}
}
