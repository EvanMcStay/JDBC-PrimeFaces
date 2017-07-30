import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import javax.sql.DataSource;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Evan McStay
 * Servlet coding (How JSP would be coded from the beginning)
 */
//@WebServlet(/Test/name_of_class)
@WebServlet("/Test/TestServlet")
public class TestServlet extends HttpServlet
{
	@Resource(name="jdbc/student_tracker")
	
	private DataSource dataSource;
	
	protected void doGet(HttpServletRequest request, 
						 HttpServletResponse response) 
						 throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");
		
		Connection myConnection = null;
		Statement myStatement = null;
		ResultSet myResult = null;
		
		try
		{
			myConnection = dataSource.getConnection();
			
			String sql = "select * from student;";
			
			myStatement = myConnection.createStatement();
			
			myResult = myStatement.executeQuery(sql);
			
			while (myResult.next())
			{
				String email = myResult.getString("email");
				out.println(email);
				System.out.println(email);
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			out.println(e.getMessage());
		}
	}
}