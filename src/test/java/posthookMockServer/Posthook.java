package posthookMockServer;

import org.json.simple.JSONObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class Posthook {

	@Test(enabled = false)
   public void scheduleAHook() {
	   given().when().post("https://posthook-api.mock.beeceptor.com/v1/hooks").then().log().all();
   }
	@Test(enabled = false)
	public void getHooks() {
		given().when().get("https://posthook-api.mock.beeceptor.com/v1/hooks").then().log().all();
	}
	
	@Test(enabled = false)
	public void getHookID() {
		
		given().when().get("https://posthook-api.mock.beeceptor.com/v1/hooks/8e3aa909-fb84-4495-944d-a4c192defe66")
		.then().log().all();
	}
	
	@Test(enabled = false)
	public void deleteAHook() {
		given().when().delete("https://posthook-api.mock.beeceptor.com/v1/hooks/8e3aa909-fb84-4495-944d-a4c192defe66")
		.then().log().all();
	}
	
	@Test(enabled = true)
	public void updateAHook() {
		
		JSONObject jo = new JSONObject();
		jo.put("name", "updated-project");
		jo.put("domain", "api.example.com");
		jo.put("headerAuthorization", "");
		jo.put("minRetries", 1);
		jo.put("retryDelaySecs", 5);
		
		given().contentType(ContentType.JSON).body(jo.toJSONString()).when().put("https://posthook-api.mock.beeceptor.com/v1/projects/").then().log().all();
	}
}
