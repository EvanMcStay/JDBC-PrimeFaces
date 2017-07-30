import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 * @author Evan McStay
 * Application scope testing -- need to use @ApplicationScoped
 * The object (in this case the value) is shared between users. 
 * So, when using two browsers, one can update the object and then the 
 * other browser will pick up right from where the other left off object wise 
 * Ex. If one browser incremeneted the object to 10 from 0 the other browser will
 *     increment to 11 once clicked 
 */
@ManagedBean
@ApplicationScoped
public class Counter 
{
	//Class level variables
	private int value = 0;
	
	//No argument Constructor
	public Counter()
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
		
		return "counter";
	}
}