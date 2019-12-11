import java.util.ArrayList;
import java.io.*;
import org.json.simple.*;

public class FishWriter {
	public static boolean writeFishToTextFile(String fname, ArrayList<ReefFish> fish) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fname)));
			for (ReefFish r : fish) {
				pw.println(r);
			}
			pw.close();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	
	public static boolean writeAssessmentsToJSON(String fname, 
			ArrayList<ReefFish> fish) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new 
					FileWriter(fname)));
			JSONObject rObj;
			JSONArray array = new JSONArray();
			for (ReefFish r : fish) {
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
