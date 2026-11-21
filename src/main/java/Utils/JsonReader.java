package Utils;

import com.jayway.jsonpath.JsonPath;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class JsonReader {

    String jsonReader;
    String jsonFileName;

    public JsonReader(String jsonFileName) {
        this.jsonFileName = jsonFileName;
        try {
            JSONObject data = (JSONObject) new JSONParser().parse(new FileReader("src/test/java/test-data/" + jsonFileName +".json"));
            jsonReader = data.toJSONString();
        }
        catch (Exception e) {
            System.out.println("Error reading JSON file: " + e.getMessage());
        }
    }

    public String getJsonData(String jsonPath) {
        try {
            return JsonPath.read(jsonReader, jsonPath);
        }
        catch (Exception e) {
            System.out.println("Error reading JSON data: " + e.getMessage());
            return null;
        }
    }
}
