import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.ExternalContext;
import javax.faces.application.FacesMessage;

@ManagedBean
@SessionScoped
public class EmployeeController 
{
	private List<Employee> employee;
	private EmployeeDbUtil employeeDbUtil;
	private Logger logger = Logger.getLogger(getClass().getName());
	
	public EmployeeController() throws Exception 
	{
		employee = new ArrayList<>();
		
		employeeDbUtil = EmployeeDbUtil.getInstance();
	}
	
	public List<Employee> getEmployee() 
	{
		return employee;
	}

	public void loadEmployee() 
	{
		logger.info("Loading employees");
		
		employee.clear();

		try 
		{
			// get all employees from database
			employee = employeeDbUtil.getEmployees();
		} 
		catch (Exception exc) 
		{
			// send this to server logs
			logger.log(Level.SEVERE, "Error loading employee", exc);
			
			// add error message for JSF page
			addErrorMessage(exc);
		}
	}
		
	public String addEmployee(Employee theEmployee) 
	{
		logger.info("Adding employee: " + theEmployee);

		try 
		{
			// add employee to the database
			employeeDbUtil.addEmployee(theEmployee);
		} 
		catch (Exception exc) 
		{
			// send this to server logs
			logger.log(Level.SEVERE, "Error adding employee", exc);
			
			// add error message for JSF page
			addErrorMessage(exc);

			return null;
		}
		
		return "list-employees?faces-redirect=true";
	}

	public String loadEmployee(int employeeId) 
	{
		logger.info("loading employee: " + employeeId);
		
		try 
		{
			// get employee from database
			Employee theEmployee = employeeDbUtil.getEmployee(employeeId);
			
			// put in the request attribute ... so we can use it on the form page
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();		

			Map<String, Object> requestMap = externalContext.getRequestMap();
			requestMap.put("employee", theEmployee);	
		} 
		catch (Exception exc) 
		{
			// send this to server logs
			logger.log(Level.SEVERE, "Error loading employee id:" + employeeId, exc);
			
			// add error message for JSF page
			addErrorMessage(exc);
			
			return null;
		}
				
		return "update-employee-form.xhtml";
	}	
	
	public String updateEmployee(Employee theEmployee) 
	{
		logger.info("updating employee: " + theEmployee);
		
		try 
		{
			// update employee in the database
			employeeDbUtil.updateEmployee(theEmployee);
		} 
		catch (Exception exc) 
		{
			// send this to server logs
			logger.log(Level.SEVERE, "Error updating employee: " + theEmployee, exc);
			
			// add error message for JSF page
			addErrorMessage(exc);
			
			return null;
		}
		
		return "list-employees?faces-redirect=true";		
	}
	
	public String deleteEmployee(int employeeId) 
	{
		logger.info("deleting employee: " + employeeId);
		
		try 
		{
			//delete employee in the database
			employeeDbUtil.deleteEmployee(employeeId);
		} 
		catch (Exception e) 
		{
			// send this to server logs
			logger.log(Level.SEVERE, "Error deleting employee: " + employeeId, e);
			
			// add error message for JSF page
			addErrorMessage(e);
			
			return null;
		}
			
		return "list-employees";	
	}	
	
	private void addErrorMessage(Exception exc) 
	{
		FacesMessage message = new FacesMessage("Error: " + exc.getMessage());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
}