import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Evan McStay
 * Controller class
 */
@ManagedBean //connection to JSF
@SessionScoped //Each client has their own view to the data object
public class StudentController 
{
	private List<Student> students;
	private StudentDBUtil studentDBUtil;
	private Logger logger = Logger.getLogger(getClass().getName());
	
	
	public StudentController() throws Exception 
	{
		students = new ArrayList<>();
		
		studentDBUtil = StudentDBUtil.getInstance();
	}
	
	public List<Student> getStudents()
	{
		return students;
	}
	
	public void loadStudents()
	{
		logger.info("Loading students");
		
		students.clear();
		
		try 
		{
			//Get all students from database
			students = studentDBUtil.getStudents();
		} 
		catch (Exception e) 
		{
			//Send this to server logs
			logger.log(Level.SEVERE, "Error loading students", e);
			
			//Add error message
			addErrorMessage(e);
		}
	}
	
	public String addStudent(Student theStudent)
	{
		logger.info("Adding Student: " + theStudent);
		
		try
		{
			//Add student to database
			studentDBUtil.addStudent(theStudent);
		}
		catch (Exception e)
		{
			//Send this to server logs
			logger.log(Level.SEVERE, "Error loading students", e);
			
			//Add error message
			addErrorMessage(e);
			
			return null;
		}
		
		return "list-students?faces-redirect=true";
	}

	private void addErrorMessage(Exception e) 
	{
		FacesMessage message = new FacesMessage("Error: " + e.getMessage());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
}