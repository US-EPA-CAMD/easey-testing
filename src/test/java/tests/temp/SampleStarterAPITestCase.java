package tests.temp;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.utils.APITestBase;

import java.util.ArrayList;

public class SampleStarterAPITestCase extends APITestBase {

    @BeforeMethod
    public void beforeMethod() {
        super.setup("https://posts-api-wacky-civet-gl.app.cloud.gov/api");
    }

    @Test
    public void test() {
        System.out.println(getString("/posts"));

        String post = "{\"title\":\"APITest\",\"content\":\"testtesttesttest\"}";

        System.out.println(postString(post, "/posts"));

        JSONArray response = getJSONArray("/posts");

        System.out.println(response.toString(4));

        ArrayList<Integer> ids = new ArrayList<>();

        for (Object obj : response) {
            if (obj instanceof JSONObject) {
                JSONObject res = (JSONObject) obj;
                if (res.getString("title").equals("APITest")) {
                    ids.add(res.getInt("id"));
                }
            }
        }

        for (int id : ids) {
            System.out.println(getString("/posts/" + id)); //currently doesn't work, returns "Error, cannot get /api/posts/{id}
            System.out.println(deleteString("/posts/" + id));
        }

        JSONObject postJSON = new JSONObject();

        postJSON.put("title", "APITest");
        postJSON.put("content", "test-test-test-test-test");

        JSONObject postResponse = postJSON(postJSON, "/posts");

        System.out.println(postResponse.toString(4));

        System.out.println(getJSONArray("/posts").toString(4));

        int id = postResponse.getInt("id");

        System.out.println(deleteJSON("/posts/" + id).toString(4));

        System.out.println(getString("/posts"));

    }

}
