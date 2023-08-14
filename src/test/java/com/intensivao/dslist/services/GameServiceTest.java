package com.intensivao.dslist.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class GameServiceTest {

  @Autowired
  WebTestClient webTestClient;

  @Test
  void testFindById() {

    webTestClient
        .get()
        .uri("/games/1")
        .exchange()
        .expectStatus().isOk()
        .expectBody()
        .jsonPath("$").isNotEmpty()
        .jsonPath("$.length()").isEqualTo(9)
        .jsonPath("$.title").isEqualTo("Mass Effect Trilogy")
        .jsonPath("$.genre").isEqualTo("Role-playing (RPG), Shooter")
        .jsonPath("$.year").isEqualTo(2012)
        .jsonPath("$.platforms[0].name").isEqualTo("Xbox")
        .jsonPath("$.platforms[1].name").isEqualTo("Playstation")
        .jsonPath("$.platforms[2].name").isEqualTo("PC")
        .jsonPath("$.score").isEqualTo(4.8)
        .jsonPath("$.imgUrl")
        .isEqualTo("https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/1.png")
        .jsonPath("$.shortDescription")
        .isEqualTo(
            "Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit esse officiis corrupti unde repellat non quibusdam! Id nihil itaque ipsum!")
        .jsonPath("$.longDescription").isEqualTo(
            "Lorem ipsum dolor sit amet consectetur adipisicing elit. Delectus dolorum illum placeat eligendi, quis maiores veniam. Incidunt dolorum, nisi deleniti dicta odit voluptatem nam provident temporibus reprehenderit blanditiis consectetur tenetur. Dignissimos blanditiis quod corporis iste, aliquid perspiciatis architecto quasi tempore ipsam voluptates ea ad distinctio, sapiente qui, amet quidem culpa.");

  }

  @Test
  void testNotFindById() {
    webTestClient
        .get()
        .uri("/games/11")
        .exchange()
        .expectStatus().isNotFound();
  }

  @Test
  void testFindByList() {
    webTestClient
        .get()
        .uri("/gameLists/1/games")
        .exchange()
        .expectStatus().isOk()
        .expectBody()
        .jsonPath("$").isNotEmpty()
        .jsonPath("$[0].id").isEqualTo(1)
        .jsonPath("$[0].title").isEqualTo("Mass Effect Trilogy")
        .jsonPath("$[0].year").isEqualTo(2012)
        .jsonPath("$[0].imgUrl")
        .isEqualTo("https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/1.png")
        .jsonPath("$[0].shortDescription").isEqualTo(
            "Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit esse officiis corrupti unde repellat non quibusdam! Id nihil itaque ipsum!");

  }

  @Test
  void testNotFindByList() {
    webTestClient
        .get()
        .uri("/gameLists/3/games")
        .exchange()
        .expectStatus().isOk()
        .expectBody()
        .jsonPath("$").isEmpty();
  }

  @Test
  void testSearchAll() {
    webTestClient
        .get()
        .uri("/games")
        .exchange()
        .expectStatus().isOk()
        .expectBody()
        .jsonPath("$").isNotEmpty()
        .jsonPath("$.content").isArray()
        .jsonPath("$.content[0].id").isEqualTo(1)
        .jsonPath("$.content[0].title").isEqualTo("Mass Effect Trilogy")
        .jsonPath("$.content[0].year").isEqualTo(2012)
        .jsonPath("$.content[0].imgUrl")
        .isEqualTo("https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/1.png")
        .jsonPath("$.content[0].shortDescription").isEqualTo(
            "Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit esse officiis corrupti unde repellat non quibusdam! Id nihil itaque ipsum!");

  }
}
