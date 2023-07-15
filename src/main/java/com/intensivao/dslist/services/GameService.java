package com.intensivao.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intensivao.dslist.dto.GameMinDTO;
import com.intensivao.dslist.entities.Game;
import com.intensivao.dslist.repositories.GameRepository;

@Service
public class GameService {

  @Autowired
  private GameRepository gameRepository;

  public List<GameMinDTO> findAll() {
    List<Game> result = gameRepository.findAll();
    // para cada valor em result ele troca o objeto por o de um novo objeto do tipo
    // gameMinDTO e transforma em lista
    return result.stream().map(GameMinDTO::new).toList();
  }

  public Game findById(Long id) {
    return gameRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("teste"));
  }

}