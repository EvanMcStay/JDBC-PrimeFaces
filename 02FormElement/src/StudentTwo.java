import java.util.List;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;

/**
 * @author Evan McStay
 * Controller for the student_two_form and student_two_response to create the managed bean
 */

@ManagedBean
public class StudentTwo 
{
	//Class level variables 
	private String firstName, lastName, country;
	
	//List of countries for the drop-down menu
	List<String> countryOptions;
	
	//No argument constructor
	public StudentTwo()
	{
		//Populate the list with countries
		countryOptions = new ArrayList<>();
		
		countryOptions.add("Brazil");
		countryOptions.add("Chile");
		countryOptions.add("France");
		countryOptions.add("Germany");
		countryOptions.add("Ghana");
		countryOptions.add("Turkey");
		countryOptions.add("United Kingdom");
		countryOptions.add("United States");
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

	public String getCountry() 
	{
		return country;
	}

	public void setCountry(String country) 
	{
		this.country = country;
	}
	
	public List<String> getCountryOptions() 
	{
		return countryOptions;
	}

	public void setCountryOptions(List<String> countryOptions) 
	{
		this.countryOptions = countryOptions;
	}
}
