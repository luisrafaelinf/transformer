package com.luis.transformer.model.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "transformer")
public class Transformer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @EqualsAndHashCode.Include
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "team")
    @Basic(optional = false)
    private String team;
    @Column(name = "name")
    @Basic(optional = false)
    private String name;
    @Column(name = "strength")
    @Basic(optional = false)
    private Integer strength;
    @Column(name = "intelligence")
    @Basic(optional = false)
    private Integer intelligence;
    @Column(name = "speed")
    @Basic(optional = false)
    private Integer speed;
    @Column(name = "endurance")
    @Basic(optional = false)
    private Integer endurance;
    @Column(name = "rank")
    @Basic(optional = false)
    private Integer rank;
    @Column(name = "courage")
    @Basic(optional = false)
    private Integer courage;
    @Column(name = "firepower")
    @Basic(optional = false)
    private Integer firepower;
    @Column(name = "skill")
    @Basic(optional = false)
    private Integer skill;

    @Override
    public String toString() {
        return getName();
    }
    
}
