package Beans.Session;

import Beans.Entity.Destination;
import Beans.Entity.Reservation;

import javax.ejb.Remote;
import javax.ejb.Remove;
import java.rmi.RemoteException;
import java.util.List;

@Remote
public interface RemoteAgence {

    String addDestination(Destination destination) ;
    String editDestination(int id, Destination destination) ;
    String delDestination(int id) ;
    Destination getDestination(int id) ;
    List<Destination> getAllDestination() ;
    String addReservation(Reservation reservation);
    String delReservation(int id)  ;
    Object[] getReservation(int id );
    List<Reservation> getAllReservation() ;
}
