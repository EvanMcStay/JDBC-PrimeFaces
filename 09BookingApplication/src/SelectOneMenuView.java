import javax.faces.bean.ManagedBean;

/**
 * @author Evan McStay | IST411 Midterm 2 | 
 * Hotel Booking with JSF and PrimeFaces | March 17, 2017 
 * Model
 */
@ManagedBean
public class SelectOneMenuView 
{
	//Class-level variables
    private String numberOfRooms, numberOfAdults,
    			   numberOfChildren;
 
    //No Argument Constructor
    public SelectOneMenuView() {}

    //Number of rooms getters and setters
	public String getNumberOfRooms() 
	{
		return numberOfRooms;
	}

	public void setNumberOfRooms(String numberOfRooms) 
	{
		this.numberOfRooms = numberOfRooms;
	}

	//Number of adults getters and setters
	public String getNumberOfAdults() 
	{
		return numberOfAdults;
	}

	public void setNumberOfAdults(String numberOfAdults) 
	{
		this.numberOfAdults = numberOfAdults;
	}

	//Number of children getters and setters
	public String getNumberOfChildren() 
	{
		return numberOfChildren;
	}

	public void setNumberOfChildren(String numberofChildren) 
	{
		this.numberOfChildren = numberofChildren;
	}
}