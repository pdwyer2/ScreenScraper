import java.util.ArrayList;
import java.io.*;
import org.json.simple.*;

public class FishWriter {
	
	public static void writeFishToScreen(ArrayList<ReefFish> fish) {
		for (ReefFish a : fish) {
			System.out.println(a);
		}
	}
	
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
