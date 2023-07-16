package com.intensivao.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intensivao.dslist.dto.GameListDTO;
import com.intensivao.dslist.repositories.GameListRepository;

@Service
public class GameListService {

  @Autowired
  private GameListRepository gameListRepository;

  @Transactional(readOnly = true)
  public List<GameListDTO> findAll() {
    return gameListRepository.findAll().stream().map(GameListDTO::new).toList();
  }
}
