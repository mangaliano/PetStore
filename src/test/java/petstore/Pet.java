// 1 - Pacote
package petstore;

// 2 - Bibliotecas

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

//3 - Classe
public class Pet {
    //3.1 - Atributos
    String url = "https://petstore.swagger.io/v2/pet";// endereço da entidade pet

    // 3.2 - Métodos e Funções
    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    // Incluir - Create - Post
    @Test // identifica o testes ou função como um teste
    public void incluirPet() throws IOException{
        String jsonBody = lerJson("db/pet1.json");

        // Sintaxe Gherkin
        // Dado - Quando - Então

        given()
                .contentType("application/json")
                .log().all()
                .body(jsonBody)
        .when()
                .post(url)
        .then()
                .log().all()
                .statusCode(200)
        ;
    }
}