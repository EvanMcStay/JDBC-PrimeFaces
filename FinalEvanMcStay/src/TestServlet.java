import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * @author Evan McStay
 *
 */
@WebServlet("/Test/TestServlet")
public class TestServlet extends HttpServlet
{	
	@Resource(name="jdbc/megamindsDB")
	
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
			
			String sql = "select * from employee";
			
			myStatement = myConnection.createStatement();
			
			myResult = myStatement.executeQuery(sql);
			
			while (myResult.next())
			{	
				String email = myResult.getString("email");
				out.println("Email: " + email);
				System.out.println("Email: " + email);
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			out.println(e.getMessage());
		}
	}
}
