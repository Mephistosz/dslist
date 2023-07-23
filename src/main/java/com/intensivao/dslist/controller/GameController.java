package com.intensivao.dslist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intensivao.dslist.dto.GameDTO;
import com.intensivao.dslist.dto.GameMinDTO;
import com.intensivao.dslist.services.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameController {

  @Autowired
  private GameService gameService;

  @GetMapping
  public ResponseEntity<Page<GameMinDTO>> searchAll(Pageable pageable) {
    return ResponseEntity.ok().body(gameService.searchAll(pageable));
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<GameDTO> findById(@PathVariable Long id) {
    return ResponseEntity.ok().body(gameService.findById(id));
  }

}