import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.io.File;
import java.io.FileInputStream;

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
 * --This code will convert the document into a binary file
 * 
 * --Things Noticed:
 * 		--If there are two prepared statements being executed, the first one will not execute properly (i.e.
 *  	  it will not insert the file into the corresponding code that was defined.), but the second will.
 *  	  In my case, the PDF was not inserted, but the picture was added. While troubleshooting I found that the 
 *  	  first BLOB can be inserted by commenting out the second prepared statement.
 * 		--Look into why this is...
 */
public class JavaBlob
{
	/**
	 * @param args
	 */
	public static void main1(String[] args) throws Exception
	{
		String user = "root";
		String password = "password";
		String url = "jdbc:mysql://127.0.0.1:3306/megaMindsDBBLOB";
		
		Connection myConnection = null;
		PreparedStatement myStatement = null;
		
		FileInputStream input = null;
		
		try
		{
			//1. Get connection to database
			myConnection = DriverManager.getConnection(url, user, password);
			
			
			//2. Prepared Statement
			String sql = "update employees set resume = ? where email = 'john.doe@foo.com'";
			myStatement = myConnection.prepareStatement(sql);
			
			//Comment out for first statement to work
			String sqlImage = "update employees set resume = ? where email = 'mary.public@foo.com'";
			myStatement = myConnection.prepareStatement(sqlImage);
			
			
			//3. Set parameter for resume file name
			File theFile = new File("syllabus.pdf"); //Handle for local files (syllabus.pdf)
			input = new FileInputStream(theFile);
			myStatement.setBinaryStream(1, input); //update the database with binary data
			System.out.println("Reading input file: " + theFile.getAbsolutePath());
			
			//Comment out for first statement to work
			File theImage = new File("photo.jpg"); //Handle for local files (photo.jpg)
			input = new FileInputStream(theImage);
			myStatement.setBinaryStream(1, input); //update the database with binary data
			System.out.println("Reading image file: " + theImage.getAbsolutePath());
			
			
			//4. Execute Statement
			System.out.println("\nStoring resume in database: " + theFile);
			System.out.println("\nStoring resume in database: " + theImage); //Comment out for first statement to work
			System.out.println("sql");
			
			myStatement.executeUpdate();
			System.out.println("\nCompleted successfully!");
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