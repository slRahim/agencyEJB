package Beans.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table
public class Destination implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_destination")
    private int idDestination ;
    @Column
    private String designation ;
    @Column(name = "date_depart")
    private String dateDepart ;
    @Column(name = "hotel_sejoure")
    private String hotelSejoure;
    @Column(name = "nbr_jour")
    private String nbrJour ;
    @Column(name = "prix_adulte")
    private String prixAdulte ;
    @Column(name = "prix_ado")
    private String prixAdo ;

    public Destination() {
    }

    public Destination(String designation, String dateDepart, String hotelSejoure, String nbrJour, String prixAdulte, String prixAdo) {
        this.designation = designation;
        this.dateDepart = dateDepart;
        this.hotelSejoure = hotelSejoure;
        this.nbrJour = nbrJour;
        this.prixAdulte = prixAdulte;
        this.prixAdo = prixAdo;
    }

    public int getIdDestination() {
        return idDestination;
    }

    public void setIdDestination(int idDestination) {
        this.idDestination = idDestination;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(String dateDepart) {
        this.dateDepart = dateDepart;
    }

    public String getHotelSejoure() {
        return hotelSejoure;
    }

    public void setHotelSejoure(String hotelSejoure) {
        this.hotelSejoure = hotelSejoure;
    }

    public String getNbrJour() {
        return nbrJour;
    }

    public void setNbrJour(String nbrJour) {
        this.nbrJour = nbrJour;
    }

    public String getPrixAdulte() {
        return prixAdulte;
    }

    public void setPrixAdulte(String prixAdulte) {
        this.prixAdulte = prixAdulte;
    }

    public String getPrixAdo() {
        return prixAdo;
    }

    public void setPrixAdo(String prixAdo) {
        this.prixAdo = prixAdo;
    }
}
