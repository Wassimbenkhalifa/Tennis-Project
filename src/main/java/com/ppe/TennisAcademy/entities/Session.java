package com.ppe.TennisAcademy.entities;

import java.time.LocalDateTime;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "typesession", discriminatorType = DiscriminatorType.STRING, length = 20)
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idSession;

    private LocalDateTime dateHeureDebut;

    private LocalDateTime dateHeureFin;

    @ManyToOne
    @JoinColumn(name = "idTerrain")
    private Terrain terrain;

    public static Session mapToSession(SessionDTO sessionDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return (modelMapper.map(sessionDTO, Session.class));
    }
}