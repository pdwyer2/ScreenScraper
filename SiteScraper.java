import java.util.ArrayList;
import java.util.Scanner;
import java.net.URL;

/**
 * This class grabs the data from the website and puts it into an array list.
 * It uses a specific search of a set of characters to find the desired lines.
 * It includes if else statements to weed out any unwanted material.
 * It replaces unwanted quotes that come from the website's source.
 * Finally it adds each fish to the result. 
 * @author Payton Dwyer
 *
 */

public class SiteScraper {
	public static ArrayList<ReefFish> Scraper(String url) {
		ArrayList<ReefFish> result = new ArrayList<ReefFish>();
		String line;
		String name = "";
		ReefFish fish;
		try {
			URL link = new URL(url);
			Scanner linksc = new Scanner(link.openStream());
			while (linksc.hasNextLine()) {
				line = linksc.nextLine();
				if (line.contains(",\"name\":")) {
					if (line.contains("Stan & Debbie Hauter")) {
						linksc.nextLine();
					} else {
					String parts[] = line.split(": ");
					for (String part : parts) {
						name = parts[1];
						name = name.replace("\"", "");
					}
					fish = new ReefFish(name);
					result.add(fish);
					}
				}
			}
			linksc.close();
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Could not connect to the website specified.");
			return null;
		}
	}
}
