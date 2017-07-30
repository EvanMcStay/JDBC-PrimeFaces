import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.io.File;
import java.io.InputStream;
import java.io.FileOutputStream;


/**
 * @author Evan McStay
 * 
 * What is a BLOB?
 * --(B)Binary (L)Large (OB)Objects; Is binary data that we store in a database
 * 		--A way of storing images, files, documents, etc. in MySQL through conversion of BLOB 
 * 		  or binary text and then store that binary text information
 * --You normally use BLOBs to keep track of documents, images, audio, or any other binary object that a user has
 * --Note that not all databases have support for BLOBs (not Universal)
 * --In this example, we are going to make use of MySQL and it's BLOB support
 * 
 * --This code will convert binary file into a document
 * 
 * --Things Noticed:
 * 		--If there are two statements being executed, the first one will not execute properly, but the second will.
 * 		  In my case, the PDF could not be opened, but the picture could open. 
 * 		--Look into why this is...
 */
public class JavaReadBlob
{
	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception
	{
		String user = "root";
		String password = "password";
		String url = "jdbc:mysql://127.0.0.1:3306/megaMindsDBBLOB";
		
		Connection myConnection = null;
		Statement myStatement = null;
		ResultSet myResult = null;
		
		InputStream input = null;
		FileOutputStream output = null;
		
		try
		{
			//1. Get connection to database
			myConnection = DriverManager.getConnection(url, user, password);
			
			
			//2. Execute Statement
			myStatement = myConnection.createStatement();
			String sql = "select resume from employees where email = 'john.doe@foo.com'";
			myResult = myStatement.executeQuery(sql);
			
			//Comment out for first statement to work
			myStatement = myConnection.createStatement();
			String sqlImage = "select resume from employees where email = 'mary.public@foo.com'";
			myResult = myStatement.executeQuery(sqlImage);
			
			
			//3. Setup a handle to the file
			File theFile = new File("syllabus_from_db.pdf");
			output = new FileOutputStream(theFile);
			
			//Comment out for first statement to work
			File theImage = new File("image_from_db.jpg");
			output = new FileOutputStream(theImage);
			
			if (myResult.next())
			{
				input = myResult.getBinaryStream("resume");
				System.out.println("Reading resume from database: " + input);
				System.out.println("sql");
				
				byte[] buffer = new byte[1024];
				
				while (input.read(buffer) > 0)
				{
					output.write(buffer);
				}
				
				System.out.println("\nSaved to file: " + theFile.getAbsolutePath());
				System.out.println("\nSaved to file: " + theImage.getAbsolutePath()); //Comment out for first statement to work
				System.out.println("\nCompleted successfully!");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (input != null)
			{
				input.close();
			}
			
			if (output != null)
			{
				output.close();
			}
			
			close(myConnection, myStatement);
		}
	}
	
	
	private static void close(Connection myConnection, Statement myStatement) throws SQLException
	{
		if (myStatement != null)
		{
			myStatement.close();
		}
		
		if (myConnection != null)
		{
			myConnection.close();
		}
	}
}