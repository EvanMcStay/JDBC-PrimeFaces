import java.io.FileInputStream;
import java.security.MessageDigest;

/**
 * @author Evan McStay
 *
 */
public class MD5ChecksumFile 
{
	/**
	 * @param args
	 */
	public static void main1(String[] args) throws Exception
	{
		MessageDigest md = MessageDigest.getInstance("MD5");
		
		FileInputStream fis = new FileInputStream("/Users/evanmcstay/Documents/Spring 2017/IST452/Labs/testHash.txt");
		
		byte[] dataBytes = new byte[1024];
		
		int nread = 0;
		
		//Need a semicolon at the end of the while 
		//statement because it is a command. The
		//loop iterates through the file until it reaches the end
		while((nread = fis.read(dataBytes)) != -1)
		{
			md.update(dataBytes, 0, nread);
		};
		
		byte[] mdBytes = md.digest();
		
		//Convert the byte to hex format: Method 1
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < mdBytes.length; i++)
		{
			sb.append(Integer.toString((mdBytes[i] & 0xff) + 0x100, 16).substring(1));
		}
		
		System.out.println("Digest (in hex format): " + sb.toString());
	}
}