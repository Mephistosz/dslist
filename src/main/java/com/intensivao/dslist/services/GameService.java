package com.intensivao.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intensivao.dslist.dto.GameDTO;
import com.intensivao.dslist.dto.GameMinDTO;
import com.intensivao.dslist.repositories.GameRepository;
import com.intensivao.dslist.services.exception.ResourceNotFoundException;

@Service
public class GameService {

  @Autowired
  private GameRepository gameRepository;

  @Transactional(readOnly = true)
  public Page<GameMinDTO> searchAll(Pageable pageable) {
    return gameRepository.searchAll(pageable).map(GameMinDTO::new);
  }

  @Transactional(readOnly = true)
  public GameDTO findById(Long id) {
    return new GameDTO(gameRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id)));
  }

  @Transactional(readOnly = true)
  public List<GameMinDTO> findByList(Long id) {
    return gameRepository.searchByList(id).stream().map(GameMinDTO::new).toList();
  }

}