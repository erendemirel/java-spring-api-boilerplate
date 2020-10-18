package testprojectcore.dataprovider;

import com.google.gson.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


/**
 * @author Eren Demirel <eren.demirel@payten.com>
 */
public class JsonFileParser {

    private static JsonFileParser jsonFileParser = new JsonFileParser();

    private JsonFileParser() {
    }

    public static JsonFileParser getInstance() {
        return jsonFileParser;
    }

    //TODO: Do not use more than one JSON library
    public String parseJsonFileAndReturnRequestedDAta(String dataGroup, String requestedData) throws Exception {
        String path = "src/test/resources/testdata/testdata.json";
        path = path.replace('/', File.separatorChar);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(bufferedReader, JsonObject.class);
        return jsonObject.getAsJsonObject(dataGroup).get(requestedData).getAsString();
    }
}

