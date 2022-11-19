package com.DermApp.Backend.test.step;

import com.DermApp.Backend.diagnostic.resource.CreateDermatologistResource;
import com.DermApp.Backend.diagnostic.resource.DermatologistResource;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@CucumberContextConfiguration
public class DermatologistStepDefinitions {


    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private String randomServerPort;

    private String endpointPath;

    private ResponseEntity<String> responseEntity;

    @Given("The Endpoint {string} is available")
    public void theEndpointIsAvailable(String endpointPath) {
        this.endpointPath = String.format(endpointPath, randomServerPort);
        testRestTemplate = new TestRestTemplate();
    }

    @When("A post Request is sent with values {string}, {int}, {string}, {string}")
    public void aPostRequestIsSentWithValues(String name, int age, String address, String description) {
        CreateDermatologistResource resource = new CreateDermatologistResource()
                .withName(name)
                .withAge(age)
                .withAddress(address)
                .withDescription(description);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<CreateDermatologistResource> request = new HttpEntity<>(resource, headers);
        responseEntity = testRestTemplate.postForEntity(endpointPath, request, String.class );
    }

    @Then("A Response is received with Status {int}")
    public void aResponseIsReceivedWithStatus(int expectedStatusCode) {
        int actualStatusCode = responseEntity.getStatusCodeValue();
        assertThat(expectedStatusCode).isEqualTo(actualStatusCode);
    }

    @And("A Dermatologist Resource is included in Response Body, with values {string}, {int}, {string}, {string}")
    public void aDermatologistResourceIsIncludedInResponseBodyWithValues(String name, int age, String address, String description) {
        DermatologistResource expectedResource = new DermatologistResource()
                .withName(name)
                .withAge(age)
                .withAddress(address)
                .withDescription(description);
        String value = responseEntity.getBody();
        ObjectMapper mapper = new ObjectMapper();
        DermatologistResource actualResource;
        try {
            actualResource = mapper.readValue(value, DermatologistResource.class);

        } catch (JsonProcessingException | NullPointerException e){
            actualResource = new DermatologistResource();
        }
        expectedResource.setId(actualResource.getId());
        assertThat(expectedResource).usingRecursiveComparison().isEqualTo(actualResource);
    }
    @Given("A Dermatologist Resource with values {string}, {int}, {string}, {string} is already stored")
    public void aDermatologistResourceWithValuesIsAlreadyStored(String name, int age, String address, String description) {
        CreateDermatologistResource resource = new CreateDermatologistResource()
                .withName(name)
                .withAge(age)
                .withAddress(address)
                .withDescription(description);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<CreateDermatologistResource> request = new HttpEntity<>(resource, headers);
        responseEntity = testRestTemplate.postForEntity(endpointPath, request, String.class);
    }

    @And("A Message is included in Response Body, with values {string}")
    public void aMessageIsIncludedInResponseBodyWithValues(String expectedMessage) {
        String responseBody = responseEntity.getBody();
        assertThat(responseBody).contains(expectedMessage);
    }
}
