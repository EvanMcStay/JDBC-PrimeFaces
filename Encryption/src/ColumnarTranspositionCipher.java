import java.util.*;
import java.io.*;
import java.lang.*;

/**
 * @author Evan McStay
 * 
 */
public class ColumnarTranspositionCipher 
{
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		String line = System.getProperty("line.separator");
		in.useDelimiter(line);
		
		System.out.println("Press 1. Encrypt 2. Decrypt");
		int option = in.nextInt();
		
		switch(option)
		{
			case 1:
				System.out.print("Enter a string to encrypt: ");
				String text = in.next();
				
				System.out.print("Enter a key to encrypt the string: ");
				String key = in.next();
				
				System.out.println("Encrypted Text: " + encryptFunction(key, text).toUpperCase());
				break;
				
			case 2:
				System.out.print("Enter the cipher text (encrypted string) to decrypt: ");
				text = in.next();
				
				System.out.print("Enter the key to decrypt the cipher text: ");
				key = in.next();
				
				System.out.println("Decrypted Text: " + decryptFunction(key, text));
				break;
			
			default:
				break;
		}
	}
	
	/**
	 * 
	 * @param key
	 * @param text
	 * @return
	 */
	public static String encryptFunction(String key, String text)
	{
		int[] arrange = arrangeKey(key);
		
		int lengthOfKey = arrange.length;
		int lengthOfText = text.length();
		
		int row = (int) Math.ceil((double) lengthOfText / lengthOfKey);
		
		char[][] grid = new char[row][lengthOfKey];
		int z = 0;
		for (int x = 0; x < row; x++)
		{
			for (int y = 0; y < lengthOfKey; y++)
			{
				if (lengthOfText == z)
				{
					grid[x][y] = RandomAlpha();
					z--;
				}
				else
				{
					grid[x][y] = text.charAt(z);
				}
				z++;
			}
		}
		
		String encrypt = "";
		
		for (int x = 0; x < lengthOfKey; x++)
		{
			for (int y = 0; y < lengthOfKey; y++)
			{
				if (x == arrange[y])
				{
					for (int a = 0; a < row; a++)
					{
						encrypt = encrypt + grid[a][y];
					}
				}
			}
		}
		
		return encrypt;
	}
	
	/**
	 * 
	 * @param key
	 * @param text
	 * @return
	 */
	public static String decryptFunction(String key, String text) 
	{
		int[] arrange = arrangeKey(key);
		
		int lengthOfKey = arrange.length;
		int lengthOfText = text.length();
		
		int row = (int) Math.ceil((double) lengthOfText / lengthOfKey);
		
		String regex = "(?<=\\G.{" + row + "})";
		String[] get = text.split(regex);
		
		char[][] grid = new char[row][lengthOfKey];
		for (int x = 0; x < lengthOfKey; x++)
		{
			for (int y = 0; y < lengthOfKey; y++)
			{
				if (arrange[x] == y)
				{
					for (int z = 0; z < row; z++)
					{
						grid[z][y] = get[arrange[y]].charAt(z);
					}
				}
			}
		}
		
		String decrypt = "";
		
		for (int x = 0; x < row; x++)
		{
			for (int y = 0; y < lengthOfKey; y++)
			{
				decrypt = decrypt + grid[x][y];
			}
		}
		
		return decrypt;
	}
	
	/**
	 * 
	 * @return
	 */
	public static char RandomAlpha()
	{
		//Generate random alpha for null space or in other 
		//words generate random letter for a space
		Random r = new Random();
		
		return (char)(r.nextInt(26) + 'a');
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public static int[] arrangeKey(String key)
	{
		//Arrange the position of the key
		String[] keys = key.split("");
		
		//Sorting the array
		Arrays.sort(keys);
		int[] num = new int[key.length()];
		
		//Iterate through sorted array
		for (int x = 0; x < keys.length; x++)
		{
			for (int y = 0; y < keys.length; y++)
			{
				if (keys[x].equals(key.charAt(y) + ""))
				{
					num[y] = x;
					break;
				}
			}
		}
		
		return num;
	}
}