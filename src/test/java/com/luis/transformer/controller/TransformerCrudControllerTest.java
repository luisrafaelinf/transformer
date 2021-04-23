package com.luis.transformer.controller;

import com.luis.transformer.Application;
import com.luis.transformer.model.response.TransformerResponse;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * This test use the data from DataLoader class, used to populate the database when the application starts
 * 
 * @see com.luis.transformer.component.DataLoader
 */

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestPropertySource("classpath:application.properties")
@ContextConfiguration(classes = {Application.class})
@ActiveProfiles("dev")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class TransformerCrudControllerTest {

    @LocalServerPort
    int port;

    public TransformerCrudControllerTest() {
    }

    @BeforeAll
    public void setUpClass() {

        RestAssured.port = port;
        RestAssured.baseURI = "http://localhost";
    }

    @AfterAll
    public void tearDownClass() {
    }

    @Test
    @DisplayName("Find all transformers")
    public void testFindAllTransformers() {

        List<TransformerResponse> transformers = RestAssured.given()
                .when()
                .contentType(ContentType.JSON)
                .get("transformers/v1/")
                .then()
                .statusCode(200)
                .and()
                .log()
                .all()
                .extract()
                .body()
                .jsonPath().getList("_embedded.transformerResponseList");

        assertThat("List of transformers should not be empty", transformers.isEmpty(), is(false));

    }

    @Test
    @DisplayName("Find transformer by ID")
    public void testFindTransformerById() {

        RestAssured.given()
                .pathParam("id", 1)
                .when()
                .contentType(ContentType.JSON)
                .get("transformers/v1/{id}")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("name", equalTo("Optimus Prime"));

    }

    @Test
    @DisplayName("Find transformer by ID unknown")
    public void testFindTransformerByIdUnknown() {

        RestAssured.given()
                .pathParam("id", 20)
                .when()
                .contentType(ContentType.JSON)
                .get("transformers/v1/{id}")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(404)
                .contentType(ContentType.JSON)
                .body("message", equalTo("Entity not found with ID 20. Please try another Id."));

    }

    @Test
    @DisplayName("Create a new Transformer")
    public void testCreateTransformer() {

        RestAssured.given()
                .body("{"
                        + "    \"team\": \"A\","
                        + "    \"name\": \"optimmus\","
                        + "    \"mechanicalStrength\": 1,"
                        + "    \"artificialIntelligence\": 2,"
                        + "    \"mechanicalSpeed\": 2,"
                        + "    \"endurance\": 2,"
                        + "    \"rank\": 2,"
                        + "    \"courage\": 2,"
                        + "    \"firepower\": 2,"
                        + "    \"mechanicalSkill\": 2"
                        + "}")
                .contentType(ContentType.JSON)
                .when()
                .post("transformers/v1/")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .body("id", greaterThan(0));

 
    }

    @Test
    @DisplayName("Create a new Transformer with existent name")
    public void testCreateTransformerWithExistentName() {

        RestAssured.given()
                .body("{"
                        + "    \"team\": \"A\","
                        + "    \"name\": \"Optimus Prime\","
                        + "    \"mechanicalStrength\": 1,"
                        + "    \"artificialIntelligence\": 2,"
                        + "    \"mechanicalSpeed\": 2,"
                        + "    \"endurance\": 2,"
                        + "    \"rank\": 2,"
                        + "    \"courage\": 2,"
                        + "    \"firepower\": 2,"
                        + "    \"mechanicalSkill\": 2"
                        + "}")
                .contentType(ContentType.JSON)
                .when()
                .post("transformers/v1/")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(409)
                .contentType(ContentType.JSON)
                .body("message", equalTo("Transformer with name Optimus Prime already exits"));

 
    }

    @Test
    @DisplayName("Update a transformer")
    public void testUpdateTransformer() {
                
        RestAssured.given()
                .pathParam("id", 2)
                .body("{"
                        + "    \"team\": \"A\","
                        + "    \"name\": \"Bumblebee\","
                        + "    \"mechanicalStrength\": 1,"
                        + "    \"artificialIntelligence\": 2,"
                        + "    \"mechanicalSpeed\": 2,"
                        + "    \"endurance\": 2,"
                        + "    \"rank\": 2,"
                        + "    \"courage\": 2,"
                        + "    \"firepower\": 2,"
                        + "    \"mechanicalSkill\": 2"
                        + "}")
                .contentType(ContentType.JSON)
                .when()
                .put("transformers/v1/{id}/")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("name", equalTo("Bumblebee"));
        
    }

    @Test
    @DisplayName("Update a transformer with existent name")
    public void testUpdateTransformerWithExistentName() {
                
        RestAssured.given()
                .pathParam("id", 2)
                .body("{"
                        + "    \"team\": \"A\","
                        + "    \"name\": \"Bluestreak\","
                        + "    \"mechanicalStrength\": 1,"
                        + "    \"artificialIntelligence\": 2,"
                        + "    \"mechanicalSpeed\": 2,"
                        + "    \"endurance\": 2,"
                        + "    \"rank\": 2,"
                        + "    \"courage\": 2,"
                        + "    \"firepower\": 2,"
                        + "    \"mechanicalSkill\": 2"
                        + "}")
                .contentType(ContentType.JSON)
                .when()
                .put("transformers/v1/{id}/")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(409)
                .contentType(ContentType.JSON)
                .body("message", equalTo("Transformer with name Bluestreak already exits. Change the name and try again"));
        
    }

    @Test
    @DisplayName("Delete a transformer by ID")
    public void testDeleteTransformer() {
        
        RestAssured.given()
                .pathParam("id", 8)
                .contentType(ContentType.JSON)
                .when()
                .delete("transformers/v1/{id}/")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(204);
    }

    @Test
    @DisplayName("Delete a transformer by ID unknown")
    public void testDeleteTransformerWithIdUnknown() {
        
        RestAssured.given()
                .pathParam("id", 100)
                .contentType(ContentType.JSON)
                .when()
                .delete("transformers/v1/{id}/")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(404)
                .contentType(ContentType.JSON)
                .body("message", equalTo("Entity not found with ID 100. Please try another Id."));
    }

}
