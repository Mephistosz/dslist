package com.intensivao.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intensivao.dslist.dto.GameListDTO;
import com.intensivao.dslist.projections.GameMinProjection;
import com.intensivao.dslist.repositories.GameListRepository;
import com.intensivao.dslist.repositories.GameRepository;
import com.intensivao.dslist.services.exception.ResourceNotFoundException;

@Service
public class GameListService {

  @Autowired
  private GameListRepository gameListRepository;

  @Autowired
  private GameRepository gameRepository;

  @Transactional(readOnly = true)
  public List<GameListDTO> findAll() {
    return gameListRepository.findAll().stream().map(GameListDTO::new).toList();
  }

  @Transactional
  public void move(Long listId, int sourceIndex, int destinationIndex) {

    List<GameMinProjection> list = gameRepository.searchByList(listId);

    if (list.isEmpty()) {
      throw new ResourceNotFoundException("List not found with id: " + listId);
    }

    GameMinProjection obj = list.remove(sourceIndex);

    list.add(destinationIndex, obj);

    int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
    int max = sourceIndex > destinationIndex ? sourceIndex : destinationIndex;

    for (int i = min; i <= max; i++) {
      gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
    }
  }
}
