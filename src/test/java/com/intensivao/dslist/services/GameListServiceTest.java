package com.intensivao.dslist.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class GameListServiceTest {

  @Autowired
  WebTestClient webTestClient;

  @Test
  void testFindAll() {

    webTestClient
        .get()
        .uri("/gameLists")
        .exchange()
        .expectBody()
        .jsonPath("$").isNotEmpty()
        .jsonPath("$").isArray()
        .jsonPath("$.length()").isEqualTo(2)
        .jsonPath("$.[0]id").isEqualTo(1)
        .jsonPath("$.[0]name").isEqualTo("Aventura e RPG");

  }

  @Test
  void testMove() {

    String requestBody = """
        {
            "sourceIndex": 1,
            "destinationIndex": 1
          }
          """;

    webTestClient.post().uri("/gameLists/2/replacement").contentType(MediaType.APPLICATION_JSON).bodyValue(requestBody)
        .exchange().expectStatus().isCreated();
  }
}
