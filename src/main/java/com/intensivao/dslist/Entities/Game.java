package com.intensivao.dslist.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_game")
public class Game {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;
  private String genre;
  private String platform;
  private String imgUrl;
  private String shortDescription;
  private String longDescription;

  @Column(name = "game_year")
  private Integer year;

  private Double score;

  public Game() {
  }

  public Game(Long id, String title, String genre, String platform, String imgUrl, String shortDescription,
      String longDescription, Integer year, Double score) {
    this.id = id;
    this.title = title;
    this.genre = genre;
    this.platform = platform;
    this.imgUrl = imgUrl;
    this.shortDescription = shortDescription;
    this.longDescription = longDescription;
    this.year = year;
    this.score = score;
  }

  public Long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public Integer getYear() {
    return year;
  }

  public String getGenre() {
    return genre;
  }

  public String getPlatform() {
    return platform;
  }

  public Double getScore() {
    return score;
  }

  public String getImgUrl() {
    return imgUrl;
  }

  public String getShortDescription() {
    return shortDescription;
  }

  public String getLongDescription() {
    return longDescription;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public void setPlatform(String platform) {
    this.platform = platform;
  }

  public void setScore(Double score) {
    this.score = score;
  }

  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
  }

  public void setShortDescription(String shortDescription) {
    this.shortDescription = shortDescription;
  }

  public void setLongDescription(String longDescription) {
    this.longDescription = longDescription;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Game other = (Game) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

}
