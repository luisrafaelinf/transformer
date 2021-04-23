package com.luis.transformer.controller;

import com.luis.transformer.Application;
import com.luis.transformer.model.response.TransformerResponse;
import com.luis.transformer.model.response.Validation;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import java.util.List;
import java.util.Objects;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
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

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestPropertySource("classpath:application.properties")
@ContextConfiguration(classes = {Application.class})
@ActiveProfiles("dev")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class BattleControllerTest {

    @LocalServerPort
    int port;

    public BattleControllerTest() {
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
    @DisplayName("battle")
    public void testBattle() {

        String response = RestAssured.given()
                .when()
                .body("["
                        + "    {"
                        + "        \"team\": \"D\","
                        + "        \"name\": \"Soundwave\","
                        + "        \"mechanicalStrength\": 8,"
                        + "        \"artificialIntelligence\": 9,"
                        + "        \"mechanicalSpeed\": 2,"
                        + "        \"endurance\": 6,"
                        + "        \"rank\": 7,"
                        + "        \"courage\": 5,"
                        + "        \"firepower\": 6, "
                        + "        \"mechanicalSkill\": 10"
                        + "    },"
                        + "    {"
                        + "        \"team\": \"A\","
                        + "        \"name\": \"Bluestreak\","
                        + "        \"mechanicalStrength\": 6,"
                        + "        \"artificialIntelligence\": 6,"
                        + "        \"mechanicalSpeed\": 7,"
                        + "        \"endurance\": 9,"
                        + "        \"rank\": 5,"
                        + "        \"courage\": 2,"
                        + "        \"firepower\": 9, "
                        + "        \"mechanicalSkill\": 7"
                        + "    },"
                        + "    {"
                        + "        \"team\": \"A\","
                        + "        \"name\": \"Hubcap\","
                        + "        \"mechanicalStrength\": 4,"
                        + "        \"artificialIntelligence\": 4,"
                        + "        \"mechanicalSpeed\": 4,"
                        + "        \"endurance\": 4,"
                        + "        \"rank\": 4,"
                        + "        \"courage\": 4,"
                        + "        \"firepower\": 4, "
                        + "        \"mechanicalSkill\": 4"
                        + "    }"
                        + "]")
                .contentType(ContentType.JSON)
                .get("transformers/v1/battle")
                .then()
                .statusCode(200)
                .and()
                .log()
                .all()
                .extract().body().asString();

        assertThat("The response of battle should not be empty", response.isEmpty(), is(false));
        assertThat("The response of battle should not be empty", response.contains("1 battles"), is(true));

    }

    @Test
    @DisplayName("Data with mistake")
    public void testWithMistake() {

        Validation response = RestAssured.given()
                .when()
                .body("["
                        + "    {"
                        + "        \"team\": \"D\","
                        + "        \"name\": \"Soundwave\","
                        + "        \"mechanicalStrength\": 18,"
                        + "        \"artificialIntelligence\": 9,"
                        + "        \"mechanicalSpeed\": 2,"
                        + "        \"endurance\": 6,"
                        + "        \"rank\": 7,"
                        + "        \"courage\": 5,"
                        + "        \"firepower\": 6, "
                        + "        \"mechanicalSkill\": 10"
                        + "    }"
                        + "]")
                .contentType(ContentType.JSON)
                .get("transformers/v1/battle")
                .then()
                .statusCode(400)
                .and()
                .log()
                .all()
                .extract().body()
                .jsonPath().getObject("errors[0]", Validation.class);

        assertThat("The response of bad argument should be the code 'Soundwave' ", Objects.equals(response.getCode(),"Soundwave"), is(true));
        assertThat("The response of bad argument should be the argument 'mechanicalStrength' ", Objects.equals(response.getField(),"mechanicalStrength"), is(true));

    }
}
