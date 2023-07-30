package com.intensivao.dslist.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.intensivao.dslist.entities.Game;
import com.intensivao.dslist.projections.GameMinProjection;

public interface GameRepository extends JpaRepository<Game, Long> {

  @EntityGraph(value = "game-platforms", type = EntityGraph.EntityGraphType.LOAD)
  Optional<Game> findById(Long id);

  @Query(nativeQuery = true, value = """
      SELECT tb_game.id,
      tb_game.title,
      tb_game.game_year         AS "year",
      tb_game.img_url           AS imgUrl,
      tb_game.short_description AS shortDescription,
      tb_belonging.position
      FROM tb_game
      INNER JOIN tb_belonging
      ON tb_game.id= tb_belonging.game_id
      WHERE tb_belonging.list_id = :listId
      ORDER BY tb_belonging.position""")
  List<GameMinProjection> searchByList(Long listId);

  @EntityGraph(value = "game-platforms", type = EntityGraph.EntityGraphType.LOAD)
  @Query(value = "Select obj from Game obj JOIN FETCH obj.platforms", countQuery = "Select count(obj) from Game obj")
  Page<Game> searchAll(Pageable pageable);

}