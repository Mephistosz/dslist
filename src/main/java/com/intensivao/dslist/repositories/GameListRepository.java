package com.intensivao.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intensivao.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
