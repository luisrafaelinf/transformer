package com.luis.transformer.model.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransformerRequest {
    
    private Long id;
    @NotBlank
    @Size(max = 1)
    @Pattern(regexp = "[A|D]")
    private String team;
    @NotBlank
    private String name;
    @Range(min = 1, max = 10)
    private Integer mechanicalStrength;
    @Range(min = 1, max = 10)
    private Integer artificialIntelligence;
    @Range(min = 1, max = 10)
    private Integer mechanicalSpeed;
    @Range(min = 1, max = 10)
    private Integer endurance;
    @Range(min = 1, max = 10)
    private Integer rank;
    @Range(min = 1, max = 10)
    private Integer courage;
    @Range(min = 1, max = 10)
    private Integer firepower;
    @Range(min = 1, max = 10)
    private Integer mechanicalSkill;

    @Override
    public String toString() {
        return getName();
    }
    
}
