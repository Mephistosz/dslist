package com.intensivao.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intensivao.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}