import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * @author Evan McStay
 * Request Scope test -- need to use @RequestScoped 
 * The object is short-lived and not kept in memory. Once the value is 1, 
 * the value is not remembered once the button is pressed again, but instead 
 * is reset to 0 and then will increment when requested. This is the default 
 * scope of the web. 
 */
@ManagedBean
@RequestScoped
public class CounterThree 
{
	//Class level variables
	private int value = 0;
	
	//No argument constructor
	public CounterThree()
	{
		
	}
	
	public int getValue() 
	{
		return value;
	}

	public void setValue(int value) 
	{
		this.value = value;
	}

	public String increment()
	{
		value++;
		
		return "counter_three";
	}
}
