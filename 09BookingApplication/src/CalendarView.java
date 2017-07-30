import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

/**
 * @author Evan McStay | IST411 Midterm 2 | 
 * Hotel Booking with JSF and PrimeFaces | March 17, 2017 
 * Model
 */
@ManagedBean
public class CalendarView 
{
	//Class-level variables
	private Date checkIn;
	private Date checkOut;
	
	//No Argument Constructor
	public CalendarView () {}
	
	public void onDateSelect(SelectEvent event) 
	{
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
        						"Date Selected", format.format(event.getObject())));
    }
	
	public void click() 
	{
        RequestContext requestContext = RequestContext.getCurrentInstance();
         
        requestContext.update("form:display");
        requestContext.execute("PF('dlg').show()");
    }

	//Check-in getters and setters
	public Date getCheckIn() 
	{
		return checkIn;
	}

	public void setCheckIn(Date checkIn) 
	{
		this.checkIn = checkIn;
	}

	//Check-out getters and setters 
	public Date getCheckOut() 
	{
		return checkOut;
	}

	public void setCheckOut(Date checkOut) 
	{
		this.checkOut = checkOut;
	}
}