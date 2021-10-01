package Beans.Session;

import Beans.Entity.Destination;
import Beans.Entity.Reservation;


import javax.ejb.Local;
import java.util.List;
import java.util.Vector;


@Local
public interface LocalAgence {

    String addDestination(Destination destination) ;
    String editDestination(int id, Destination destination) ;
    String delDestination(int id) ;
    Destination getDestination(int id) ;
    List<Destination> getAllDestination() ;
    String addReservation(Reservation reservation) ;
    String delReservation(int id) ;
    Object[] getReservation(int id );
    List<Reservation> getAllReservation() ;
}
