import java.util.Scanner;
import java.net.URL;

public class SiteScraper {
	public static void Scraper(String url) {
		System.out.print("Enter url: ");
		Scanner sc = new Scanner(System.in);
		String addr = sc.nextLine();
		String line;
		try {
			URL link = new URL(addr);
			Scanner linksc = new Scanner(link.openStream());
			while (linksc.hasNextLine()) {
				line = linksc.nextLine();
				System.out.println(line);
			}
			linksc.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Could not connect to the website specified.");
		}
	}
}
