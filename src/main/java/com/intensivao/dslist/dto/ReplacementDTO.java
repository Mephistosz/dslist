package com.intensivao.dslist.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;

public class ReplacementDTO {

  @NotNull(message = "The value can't be null")
  @Max(value = 100, message = "The value has to be equal to or less than 100")
  private Integer sourceIndex;
  @Max(value = 100, message = "The value has to be equal to or less than 100")
  private Integer destinationIndex;

  public ReplacementDTO() {
  }

  public ReplacementDTO(Integer sourceIndex, Integer destinationIndex) {
    this.sourceIndex = sourceIndex;
    this.destinationIndex = destinationIndex;
  }

  public Integer getSourceIndex() {
    return sourceIndex;
  }

  public void setSourceIndex(Integer sourceIndex) {
    this.sourceIndex = sourceIndex;
  }

  public Integer getDestinationIndex() {
    return destinationIndex;
  }

  public void setDestinationIndex(Integer destinationIndex) {
    this.destinationIndex = destinationIndex;
  }

}
