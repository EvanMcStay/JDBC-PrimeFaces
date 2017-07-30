import java.security.MessageDigest;

/**
 * @author Evan McStay
 *
 */
public class MD5ChecksumString 
{
	/**
	 * @param args
	 */
	public static void main2(String[] args) throws Exception
	{
		//Variables
		String password = "Abcd123456";
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(password.getBytes());
		byte[] byteData = md.digest();
		
		//Convert the byte to hex format: Method 1
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < byteData.length; i++)
		{
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}
		
		System.out.println("Digest (in hex format): " + sb.toString());
	}
}

