package net.guides.springboot2.springboot2jpacrudexample.model.tms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "PositionFournisseur")
public class PositionFournisseur {

    @Id
    @Column(name ="id")
    Long Id;

    @Column(name= "latitude")
    String latitude;

    @Column(name= "longitude")
    String longitude;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public PositionFournisseur(Long id, String latitude, String longitude) {
        Id = id;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public PositionFournisseur(String latitude, String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public PositionFournisseur() {
    }
}
