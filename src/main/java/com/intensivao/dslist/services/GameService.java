package com.intensivao.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intensivao.dslist.dto.GameDTO;
import com.intensivao.dslist.dto.GameMinDTO;
import com.intensivao.dslist.entities.Game;
import com.intensivao.dslist.repositories.GameRepository;
import com.intensivao.dslist.services.exception.ResourceNotFoundException;

@Service
public class GameService {

  @Autowired
  private GameRepository gameRepository;

  @Transactional(readOnly = true)
  public List<GameMinDTO> findAll() {
    List<Game> result = gameRepository.findAll();
    // para cada valor em result ele troca o objeto por o de um novo objeto do tipo
    // gameMinDTO e transforma em lista
    return result.stream().map(GameMinDTO::new).toList();
  }

  @Transactional(readOnly = true)
  public GameDTO findById(Long id) {
    return new GameDTO(gameRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Object not found")));
  }

}