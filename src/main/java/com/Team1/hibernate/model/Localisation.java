package com.Team1.hibernate.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "localisations")
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Localisation extends BaseEntity{

    @Column(name = "geographic_coordinates")
    private String geographicCoordinates;

    private String region;

    private String name;

    private String country;
}
