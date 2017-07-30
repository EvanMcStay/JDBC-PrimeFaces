import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

/**
 * @author Evan McStay | IST411 Final | 
 * Hotel Booking with JSF and PrimeFaces | May 4, 2017 
 * Model
 */
@ManagedBean
public class BookingView
{
	//Class-level variables
	private String firstName, lastName, email;
	private Date arrivalDate, departureDate;
	private Date currentDate = new Date();
	
	//No Argument Constructor
	public BookingView() {}
	
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
	
	//Arrival date getters and setters
	public Date getArrivalDate() 
	{
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) 
	{
		this.arrivalDate = arrivalDate;
	}

	//Departure date getters and setters
	public Date getDepartureDate() 
	{
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) 
	{
		this.departureDate = departureDate;
	}
	
	//Current date getters and setters
	public Date getCurrentDate() 
	{
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) 
	{
		this.currentDate = currentDate;
	}

	public void validateEmail(FacesContext myContext, UIComponent myComponent, Object myValue) throws ValidatorException
	{
		if (myValue == null) 
		{
			return;
		}
		
		String regex = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";

		Pattern pattern = Pattern.compile(regex);
		
		Matcher m = pattern.matcher((String) myValue);

		if (!m.matches()) 
		{
			throw new ValidatorException(new FacesMessage("Invalid email"));
		}
	}
}