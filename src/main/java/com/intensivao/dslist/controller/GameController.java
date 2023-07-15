package com.intensivao.dslist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intensivao.dslist.dto.GameMinDTO;
import com.intensivao.dslist.entities.Game;
import com.intensivao.dslist.services.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameController {

  @Autowired
  private GameService gameService;

  @GetMapping
  public ResponseEntity<List<GameMinDTO>> findAll() {
    return ResponseEntity.ok().body(gameService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Game> findById(@PathVariable Long id) {
    return ResponseEntity.ok().body(gameService.findById(id));
  }

}