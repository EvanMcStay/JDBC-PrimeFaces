import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * @author Evan McStay
 * Session Scope testing -- need to use @SessionScoped
 * The objects are different browsers. Each browser will have different objects 
 * for each user. This is used in shopping cart applications where each shopping 
 * cart is unique to the user. 
 */
@ManagedBean
@SessionScoped 
public class CounterTwo 
{
	//Class level variables
	private int value = 0;
	
	//No argument constructor
	public CounterTwo()
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
		
		return "counter_two";
	}
}
