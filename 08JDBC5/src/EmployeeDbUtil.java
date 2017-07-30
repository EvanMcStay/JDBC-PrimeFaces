import java.util.List;
import java.util.ArrayList;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class EmployeeDbUtil 
{
	private static EmployeeDbUtil instance;
	private DataSource dataSource;
	private String jndiName = "java:comp/env/jdbc/megamindsDB";
	
	public static EmployeeDbUtil getInstance() throws Exception 
	{
		if (instance == null) 
		{
			instance = new EmployeeDbUtil();
		}
		
		return instance;
	}
	
	private EmployeeDbUtil() throws Exception 
	{		
		dataSource = getDataSource();
	}

	private DataSource getDataSource() throws NamingException 
	{
		Context context = new InitialContext();
		
		DataSource theDataSource = (DataSource) context.lookup(jndiName);
		
		return theDataSource;
	}
		
	public List<Employee> getEmployees() throws Exception 
	{
		List<Employee> employee = new ArrayList<>();

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try 
		{
			myConn = getConnection();

			String sql = "select * from employee order by last_name";

			myStmt = myConn.createStatement();

			myRs = myStmt.executeQuery(sql);

			// process result set
			while (myRs.next()) 
			{
				// retrieve data from result set row
				int id = myRs.getInt("id");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String email = myRs.getString("email");
				Blob image = myRs.getBlob("resume");
				
				Employee tempEmployee = new Employee(id, firstName, lastName, 
													 email, image);

				// add it to the list of employees
				employee.add(tempEmployee);
			}
			
			return employee;		
		}
		finally 
		{
			close (myConn, myStmt, myRs);
		}
	}

	public void addEmployee(Employee theEmployee) throws Exception 
	{
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try 
		{
			myConn = getConnection();

			String sql = "insert into employee (first_name, last_name, email) values (?, ?, ?)";

			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setString(1, theEmployee.getFirstName());
			myStmt.setString(2, theEmployee.getLastName());
			myStmt.setString(3, theEmployee.getEmail());
			
			myStmt.execute();			
		}
		finally 
		{
			close (myConn, myStmt);
		}
	}
	
	public Employee getEmployee(int employeeId) throws Exception 
	{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try 
		{
			myConn = getConnection();

			String sql = "select * from employee where id=?";

			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, employeeId);
			
			myRs = myStmt.executeQuery();

			Employee theEmployee = null;
			
			// retrieve data from result set row
			if (myRs.next()) 
			{
				int id = myRs.getInt("id");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String email = myRs.getString("email");
				Blob image = myRs.getBlob("resume");

				theEmployee = new Employee(id, firstName, lastName, email, image);
			}
			else 
			{
				throw new Exception("Could not find employee id: " + employeeId);
			}

			return theEmployee;
		}
		finally 
		{
			close (myConn, myStmt, myRs);
		}
	}
	
	public void updateEmployee(Employee theEmployee) throws Exception 
	{
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try 
		{
			myConn = getConnection();

			String sql = "update employee "
						+ " set first_name=?, last_name=?, email=?"
						+ " where id=?";

			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setString(1, theEmployee.getFirstName());
			myStmt.setString(2, theEmployee.getLastName());
			myStmt.setString(3, theEmployee.getEmail());
			myStmt.setInt(4, theEmployee.getId());
			
			myStmt.execute();
		}
		finally 
		{
			close (myConn, myStmt);
		}
	}
	
	public void deleteEmployee(int employeeId) throws Exception 
	{
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try 
		{
			myConn = getConnection();

			String sql = "delete from employee where id=?";

			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setInt(1, employeeId);
			
			myStmt.execute();
		}
		finally 
		{
			close (myConn, myStmt);
		}		
	}	
	
	private Connection getConnection() throws Exception 
	{
		Connection theConn = dataSource.getConnection();
		
		return theConn;
	}
	
	private void close(Connection theConn, Statement theStmt) 
	{
		close(theConn, theStmt, null);
	}
	
	private void close(Connection theConn, Statement theStmt, ResultSet theRs) 
	{
		try 
		{
			if (theRs != null) 
			{
				theRs.close();
			}

			if (theStmt != null) 
			{
				theStmt.close();
			}

			if (theConn != null) 
			{
				theConn.close();
			}
		} 
		catch (Exception exc) 
		{
			exc.printStackTrace();
		}
	}	
}