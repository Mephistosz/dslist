package com.intensivao.dslist.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.intensivao.dslist.entities.Game;
import com.intensivao.dslist.entities.Platforms;

public class GameDTO {

  private Long id;
  private String title;
  private String genre;
  private Integer year;
  private List<Platforms> platforms = new ArrayList<>();
  private Double score;
  private String imgUrl;
  private String shortDescription;
  private String longDescription;

  public GameDTO() {
  }

  public GameDTO(Game game) {
    BeanUtils.copyProperties(game, this); // copiar tudo e joga nas variaveis da classe, vars precisam estar iguais
    this.platforms = game.getPlatforms();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public List<Platforms> getPlatforms() {
    return platforms;
  }

  public void addPlatforms(Platforms platforms) {
    this.platforms.add(platforms);
  }

  public void removePlatforms(Platforms platforms) {
    this.platforms.remove(platforms);
  }

  public Double getScore() {
    return score;
  }

  public void setScore(Double score) {
    this.score = score;
  }

  public String getImgUrl() {
    return imgUrl;
  }

  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
  }

  public String getShortDescription() {
    return shortDescription;
  }

  public void setShortDescription(String shortDescription) {
    this.shortDescription = shortDescription;
  }

  public String getLongDescription() {
    return longDescription;
  }

  public void setLongDescription(String longDescription) {
    this.longDescription = longDescription;
  }

  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

}