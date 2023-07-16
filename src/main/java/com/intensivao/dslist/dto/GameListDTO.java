package com.intensivao.dslist.dto;

import org.springframework.beans.BeanUtils;

import com.intensivao.dslist.entities.GameList;

public class GameListDTO {

  private Long id;
  private String name;

  public GameListDTO() {
  }

  public GameListDTO(GameList list) {
    BeanUtils.copyProperties(list, this);
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
