import java.util.List;
import java.util.ArrayList;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 * @author Evan McStay
 * Utility class that interacts with list_demo.xhtml
 * Model in the MVC architecture (Data is stored)
 */
@ManagedBean
@ApplicationScoped
public class StudentDataUtil 
{
	//Class-level variables
	//List <Student> is from the Student class
	private List<Student> students;
	
	public StudentDataUtil()
	{
		//Method call to the loadSampleData below
		loadSampleData();
	}

	private void loadSampleData() 
	{
		students = new ArrayList<>();
		
		//Adding data to the ArrayList
		students.add(new Student("Griffen", "Ocean", "GO11@psu.edu"));
		students.add(new Student("Evan", "McStay", "EM01@psu.edu"));
		students.add(new Student("Alex", "Mammay", "AM99@psu.edu"));
		students.add(new Student("Garrett", "Scheffler", "GS34@psu.edu"));
		students.add(new Student("Bradley", "Andrews", "BA88@psu.edu"));
		students.add(new Student("Richard", "Lomotey", "RL44@psu.edu"));
	}
	
	//Only getStudent() because we are setting the 
	//student information in the Student class
	public List<Student> getStudents() 
	{
		return students;
	}
}