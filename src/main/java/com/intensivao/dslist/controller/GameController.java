package com.intensivao.dslist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intensivao.dslist.dto.GameMinDTO;
import com.intensivao.dslist.services.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameController {

  @Autowired
  private GameService gameService;

  @GetMapping
  public List<GameMinDTO> findAll() {
    return gameService.findAll();
  }

}