package tests.temp;

import org.json.JSONArray;
import org.json.JSONObject;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import tests.utils.APITestBase;
import tests.utils.CSVParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SampleStarterAPITestCase extends APITestBase {

    @DataProvider(name = "csv")
    public Object[] dp() {
        CSVParser csv = new CSVParser(
                osHome + "/EPACAMD/Testing/src/main/resources/sample/SampleStarterAPITestData.csv");
        List data = csv.getData();
        return data.toArray();
    }

    @BeforeMethod
    public void beforeMethod() {
        super.setup("https://posts-api-wacky-civet-gl.app.cloud.gov/api");
    }

    @Test(dataProvider = "csv")
    public void apiTest(Map<String, String> map) {

        System.out.println(getString("/posts"));

        String post = "{\"title\":\"" + map.get("title") + "\",\"content\":\"" + map.get("content1") + "\"}";

        System.out.println(postString(post, "/posts"));

        JSONArray response = getJSONArray("/posts");

        System.out.println(response.toString(4));

        ArrayList<Integer> ids = new ArrayList<>();

        for (Object obj : response) {
            if (obj instanceof JSONObject) {
                JSONObject res = (JSONObject) obj;
                if (res.getString("title").equals(map.get("title"))) {
                    ids.add(res.getInt("id"));
                }
            }
        }

        for (int id : ids) {
            System.out.println(getString("/posts/" + id));
                //currently doesn't work, returns "Error, cannot get /api/posts/{id}
            System.out.println(deleteString("/posts/" + id));
        }

        JSONObject postJSON = new JSONObject();

        postJSON.put("title", map.get("title"));
        postJSON.put("content", map.get("content2"));

        JSONObject postResponse = postJSON(postJSON, "/posts");

        System.out.println(postResponse.toString(4));

        System.out.println(getJSONArray("/posts").toString(4));

        int id = postResponse.getInt("id");

        System.out.println(deleteJSON("/posts/" + id).toString(4));

        System.out.println(getString("/posts"));

    }

}
