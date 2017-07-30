import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

/**
 * @author Evan McStay
 * Server-side validation example 
 */

@ManagedBean
public class StudentFour 
{
	//Class Level Variables
	private String firstName, lastName, courseCode;
	
	//No-Argument Constructor
	public StudentFour()
	{
		
	}

	//Setters and Getters
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

	public String getCourseCode() 
	{
		return courseCode;
	}

	public void setCourseCode(String courseCode) 
	{
		this.courseCode = courseCode;
	}
	
	//Server-Side Validation
	//The method name is the validator inside the student_four_form
	public void validateCourseCode(FacesContext context, UIComponent component, Object value) throws ValidatorException
	{
		if (value == null)
		{
			return; 
		}
		
		//value is the actual information that is entered by the user in the text box 
		String data = value.toString();
		
		//Course code must start with "IST," if it does not then throw exception and throw the error
		if (!data.startsWith("IST"))
		{
			FacesMessage message = new FacesMessage("Course code must start with 'IST'");
			throw new ValidatorException(message);
		}
	}
}
