package Beans.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table
public class Reservation  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reservation")
    private int idReservation ;
    @Column
    private String nom ;
    @Column
    private String prenom ;
    @Column(name = "date_naissance")
    private String dateNais ;
    @Column
    private String type ;
    @Column(name = "date_reservation")
    private String dateReservation ;
    @Column(name = "id_destination")
    private int idDestination ;

    public Reservation() {
    }

    public Reservation(String nom, String prenom, String dateNais, String type, String dateReservation, int idDestination) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNais = dateNais;
        this.type = type;
        this.dateReservation = dateReservation;
        this.idDestination = idDestination;
    }

    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDateNais() {
        return dateNais;
    }

    public void setDateNais(String dateNais) {
        this.dateNais = dateNais;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(String dateReservation) {
        this.dateReservation = dateReservation;
    }

    public int getIdDestination() {
        return idDestination;
    }

    public void setIdDestination(int idDestination) {
        this.idDestination = idDestination;
    }
}
