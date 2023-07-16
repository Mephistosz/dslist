package com.intensivao.dslist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intensivao.dslist.dto.GameListDTO;
import com.intensivao.dslist.dto.GameMinDTO;
import com.intensivao.dslist.services.GameListService;
import com.intensivao.dslist.services.GameService;

@RestController
@RequestMapping(value = "/gameLists")
public class GameListController {

  @Autowired
  private GameListService gameListService;

  @Autowired
  private GameService gameService;

  @GetMapping()
  public ResponseEntity<List<GameListDTO>> findAll() {
    return ResponseEntity.ok().body(gameListService.findAll());
  }

  @GetMapping(value = "/{id}/games")
  public ResponseEntity<List<GameMinDTO>> findByList(@PathVariable Long id) {
    return ResponseEntity.ok().body(gameService.findByList(id));
  }

}
