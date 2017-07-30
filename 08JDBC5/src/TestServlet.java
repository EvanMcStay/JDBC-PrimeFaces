import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

import javax.sql.DataSource;

import javax.annotation.Resource;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
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
	private static final long serialVersionUID = 1L;
	
	@Resource(name="jdbc/megamindsDB")
	
	private DataSource dataSource;
	
	protected void doGet(HttpServletRequest request, 
						 HttpServletResponse response) 
						 throws ServletException, IOException
	{
//		PrintWriter out = response.getWriter();
//		response.setContentType("text/plain");
		
		Connection myConnection = null;
		Statement myStatement = null;
		ResultSet myResult = null;
		
		try
		{	
			myConnection = dataSource.getConnection();
			
			String sql = "select resume from employee where email='mary.public@foo.com'";
			
			myStatement = myConnection.createStatement();
			
			myResult = myStatement.executeQuery(sql);
			
			Blob image = null;
			
			while (myResult.next())
			{
				image = myResult.getBlob("resume");
				
//				String email = myResult.getString("email");
//				out.println("Email: " + email);
//				System.out.println("Email: " + email);
			}
			
			response.setContentType("image/jpg");
			InputStream input = image.getBinaryStream();
			int imageLength = (int) image.length();
			byte[] imageBytes = new byte[1024];
			ServletOutputStream output = response.getOutputStream();
			
			while ((imageLength = input.read(imageBytes)) != -1)
			{
				output.write(imageBytes, 0, imageLength);
			}
			
			input.close();
			output.flush();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
//			out.println(e.getMessage());
		}
	}
}