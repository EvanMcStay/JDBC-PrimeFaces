import javax.faces.bean.ManagedBean;

/**
 * @author Evan McStay
 *
 */

@ManagedBean
public class StudentFour 
{
	//Class Level Variables
	private String firstName, lastName;
	
	//Need to put favoriteLanguages into a String array because you cannot assign multiple
	//values to one variable (since the user may choose multiple options)
	private String[] favoriteLanguages;
	
	//No Argument Constructor
	public StudentFour()
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

	public String[] getFavoriteLanguages() 
	{
		return favoriteLanguages;
	}

	public void setFavoriteLanguages(String[] favoriteLanguages) 
	{
		this.favoriteLanguages = favoriteLanguages;
	}
}
