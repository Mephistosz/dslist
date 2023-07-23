package com.intensivao.dslist.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.intensivao.dslist.dto.GameListDTO;
import com.intensivao.dslist.dto.GameMinDTO;
import com.intensivao.dslist.dto.ReplacementDTO;
import com.intensivao.dslist.services.GameListService;
import com.intensivao.dslist.services.GameService;

@RestController
@RequestMapping(value = "/gameLists")
public class GameListController {

  @Autowired
  private GameListService gameListService;

  @Autowired
  private GameService gameService;

  @GetMapping
  public ResponseEntity<List<GameListDTO>> findAll() {
    return ResponseEntity.ok().body(gameListService.findAll());
  }

  @GetMapping(value = "/{id}/games")
  public ResponseEntity<List<GameMinDTO>> findByList(@PathVariable Long id) {
    return ResponseEntity.ok().body(gameService.findByList(id));
  }

  @PostMapping(value = "/{listId}/replacement")
  public ResponseEntity<Void> replacement(@PathVariable Long listId, @RequestBody ReplacementDTO replacementDTO) {

    gameListService.move(listId, replacementDTO.getSourceIndex(),
        replacementDTO.getDestinationIndex());

    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(listId).toUri();

    return ResponseEntity.created(uri).build();
  }

}
