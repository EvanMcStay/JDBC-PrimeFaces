import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Formatter;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author Evan McStay
 * 
 */
public class HmacSHA1Signature 
{
	//Constant variable
	private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";
	
	private static String toHexString(byte[] bytes)
	{
		Formatter formatter = new Formatter();
		
		for (byte b: bytes)
		{
			formatter.format("%02x", b);
		}
		
		return formatter.toString();
	}
	
	//SHA1 algorithm 
	public static String calculateRFC2104HMAC(String data, String key) 
		   throws SignatureException, NoSuchAlgorithmException, InvalidKeyException
	{
		SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), HMAC_SHA1_ALGORITHM);
		Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
		mac.init(signingKey);
		
		return toHexString(mac.doFinal(data.getBytes()));
	}
	
	public static void main(String[] args) throws Exception
	{
		String hmac = calculateRFC2104HMAC("Evan has a big head", "password");
		
		System.out.println(hmac);
		//assert hmac.equals();
	}
}