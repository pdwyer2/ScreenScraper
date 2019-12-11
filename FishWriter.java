import java.util.ArrayList;
import java.io.*;
import org.json.simple.*;

/**
 * This class includes the three different writers; to screen, to text file, and to json file.
 * @author Payton Dwyer
 *
 */

public class FishWriter {
	
	/**
	 * Prints the array list of fish to the screen
	 * @param Fish - The array list of fish that is scraped from the website
	 */
	public static void writeFishToScreen(ArrayList<ReefFish> Fish) {
		for (ReefFish a : Fish) {
			System.out.println(a);
		}
	}
	
	/**
	 * writes the list of fish to a user specified text file
	 * @param f - the name of the specified file
	 * @param Fish - The array list of fish that is scraped from the website
	 * @return - will return true if successful, and false if there are any errors
	 */
	public static boolean writeFishToTextFile(File f, ArrayList<ReefFish> Fish) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f)));
			for (ReefFish r : Fish) {
				pw.println(r);
			}
			pw.close();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	
	/**
	 * writes the list of fish to a user specified json file
	 * @param f - the name of the specified file
	 * @param Fish - The array list of fish that is scraped from the website
	 * @return - will return true if successful, and false if there are any errors
	 */
	public static boolean writeAssessmentsToJSON(File f, 
			ArrayList<ReefFish> Fish) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new 
					FileWriter(f)));
			JSONObject rObj;
			JSONArray array = new JSONArray();
			for (ReefFish r : Fish) {
				rObj = new JSONObject();
				rObj.put("name,",r.getName());
				array.add(rObj);
			}
			pw.close();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
}
