import java.util.ArrayList;
import java.util.Scanner;
import java.net.URL;

public class SiteScraper {
	public static ArrayList<ReefFish> Scraper(String url) {
		System.out.print("Enter url: ");
		Scanner sc = new Scanner(System.in);
		String addr = sc.nextLine();
		String line;
		String excess = "";
		String name = "";
		ReefFish fish;
		ArrayList<ReefFish> Fish = new ArrayList<ReefFish>();
		try {
			URL link = new URL(addr);
			Scanner linksc = new Scanner(link.openStream());
			while (linksc.hasNextLine()) {
				line = linksc.nextLine();
				if (line.contains(",\"name\":")) {
					String parts[] = line.split(": ");
					for (String part : parts) {
						excess = parts[0];
						name = parts[1];
					}
					fish = new ReefFish(name);
					Fish.add(fish);
				}
			}
			linksc.close();
			return Fish;
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Could not connect to the website specified.");
			return null;
		}
	}
}
