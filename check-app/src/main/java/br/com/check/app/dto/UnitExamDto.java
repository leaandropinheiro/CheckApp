package br.com.check.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@ToString
public class UnitExamDto implements Dto<UnitExamDto>{

  private String examName;
  private Long examCode;
  private Long unitId;
}
