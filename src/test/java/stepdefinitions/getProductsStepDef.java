package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import static org.junit.Assert.assertEquals;

public class getProductsStepDef {

    RequestSpecification httpRequest;
    Response response;
   ResponseBody body;

    @Given("I hit the url of get api products endpoint")
    public void i_hit_the_url_of_get_api_products_endpoint() {
        RestAssured.baseURI = "https://fakestoreapi.com/";
        throw new io.cucumber.java.PendingException();
    }

    // When step: Send the GET request to the "products" endpoint
    @When("I pass the url of product in the request")
    public void i_pass_the_url_of_product_in_the_request() {
        // Initialize the request specification
        httpRequest = RestAssured.given();

        // Send the GET request to fetch all products
        response = httpRequest.get("products");
        throw new io.cucumber.java.PendingException();
    }

    // Then step: Assert that the response status code is 200
    @Then("I receive the response code as {int}")
    public void i_receive_the_response_code_as(Integer expectedStatusCode) {
        // Get the actual status code from the response
        int actualStatusCode = response.getStatusCode();
        // Assert that the actual status code matches the expected status code
        assertEquals((int) expectedStatusCode, actualStatusCode);
    }

    @Then("I verify the rate of the first product is <FirstProductRate>")
    public void i_verify_the_rate_of_the_first_product_is_first_product_rate() {
        body = response.getBody();
        // convert response body to string
        String responseBody = body.toString();
        // JSON representation from response body
        JsonPath jsonPath = response.jsonPath();
        String s = jsonPath.getJsonObject("rating");

        throw new io.cucumber.java.PendingException();
    }

}
