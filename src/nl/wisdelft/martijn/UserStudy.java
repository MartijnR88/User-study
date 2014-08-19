package nl.wisdelft.martijn;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class UserStudy {
	public static void main(String[] args) throws IOException {
		Map<String, Integer> prevent_doubles = new HashMap<String, Integer>();
		ArrayList<String> files = new ArrayList<String>();
		files.add("8f55db7d-a3da-48e0-a836-84cddba176e4.json");
		files.add("e2114b01-5c50-44d4-b556-0c3534878c52.json");
		files.add("ef819609-dbde-4983-93e9-2a19c8d27d66.json");

		FileWriter fw = new FileWriter(new File("user_study.csv"));
		fw.append("videoId, performerId, algorithm1, algorithm2, choice");
		fw.append('\n');

		for (String file : files) {
			FileReader fr = new FileReader(new File(file));
			BufferedReader br = new BufferedReader(fr);
			JSONArray myJSONArray = new JSONArray(br.readLine());

			for (int i = 0; i < myJSONArray.length(); i++) {
				//System.out.println(myJSONArray);

//				boolean add = true;
				String videoId = new JSONObject(new JSONObject(myJSONArray.get(
						i).toString()).get("data").toString()).get("id")
						.toString();

				if (videoId.equals("1493") || videoId.equals("639267") || videoId.equals("613631")) {
					String response = new JSONObject(myJSONArray.get(i)
							.toString()).get("response").toString();
					System.out.println(videoId + response);
				}
//
//				if (!prevent_doubles.containsKey(videoId)) {
//					prevent_doubles.put(videoId, 1);
//				}
//
//				else {
//					int already_added = prevent_doubles.get(videoId);
//					if (!(already_added >= 3)) {
//						prevent_doubles.put(videoId, already_added+1);
//					} else {
//						add = false;
//					}
//				}
//
//				if (add) {
//					String performerId = new JSONObject(myJSONArray.get(i)
//							.toString()).get("performerId").toString();
//					String response = new JSONObject(myJSONArray.get(i)
//							.toString()).get("response").toString();
////					System.out.println(videoId);
////					System.out.println(performerId);
////					System.out.println(response);
////
//					JSONArray array = new JSONArray("["
//							+ new JSONArray(response).get(0).toString() + "]");
//					JSONObject bio_data = new JSONObject(array.get(0)
//							.toString());
////
//					for (int j = 20; j < array.length(); j++) {
//						JSONObject object = new JSONObject(array.get(j)
//								.toString());
////						String comparison = object.get("comparison").toString();
////						String choice = object.get("chosen").toString();
//						String comment = object.get("comment").toString();
//						System.out.println("Comment on video " + videoId + ":" + comment + " made by: " + bio_data.get("First name").toString());
//						fw.append(videoId + "," + performerId + ","
//								+ comparison.charAt(1) + ","
//								+ comparison.charAt(3) + "," + choice);
//						fw.append('\n');
//					}
//				}
			}
			br.close();
		}

//		fw.flush();
//		fw.close();
	}
}
