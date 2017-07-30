import javax.faces.bean.ManagedBean;

/**
 * @author Evan McStay
 * Conditional navigation controller:
 * This allows the user to be directed to multiple response pages based on their input 
 */

@ManagedBean
public class TourBean 
{
	//Class level variables/fields
	private String kindOfTour;
	
	//No-argument constructor
	public TourBean()
	{
		
	}

	public String getKindOfTour() 
	{
		return kindOfTour;
	}

	public void setKindOfTour(String kindOfTour) 
	{
		this.kindOfTour = kindOfTour;
	}
	
	public String startTheTour()
	{
		//This assumes the user clicked on the city tour so that is the response that will be shown
		//JSF interprets city_tour as the city_tour.xhtml 
		if (kindOfTour != null && kindOfTour.equals("city"))
		{
			return "city_tour";
		}
		else if (kindOfTour != null && kindOfTour.equals("country"))
		{
			return "country_tour";
		}
		else if (kindOfTour != null && kindOfTour.equals("campus"))
		{
			return "campus_tour";
		}
		else if (kindOfTour != null && kindOfTour.equals("museum"))
		{
			return "museum_tour";
		}
		else 
		{
			return "zoo_tour";
		}
	}
}
