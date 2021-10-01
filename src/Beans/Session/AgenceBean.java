package Beans.Session;

import Beans.Entity.Destination;
import Beans.Entity.Reservation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



import javax.ejb.Stateless;

import java.util.List;


@Stateless(name = "AgenceEJB")
public class AgenceBean implements LocalAgence ,RemoteAgence {


    SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Destination.class)
            .addAnnotatedClass(Reservation.class)
            .buildSessionFactory();

    // create session
    Session session = factory.getCurrentSession();

    @Override
    public String addDestination(Destination destination) {
        session=factory.getCurrentSession() ;
        String str="";
        Transaction transaction=null ;
        try {
            transaction=session.beginTransaction();
            session.save(destination);
            transaction.commit();
            str="ok";
        }catch (Exception e){
            if (transaction!=null)
                transaction.rollback();
            e.printStackTrace();
        }

        return str;
    }

    @Override
    public String editDestination(int id ,Destination destination) {
        session=factory.getCurrentSession() ;
        Destination destination1=new Destination();
        String str="";
        Transaction transaction=null ;
        try {
            transaction=session.beginTransaction();
            destination1=session.get(Destination.class,id);
            destination1.setDesignation(destination.getDesignation());
            destination1.setDateDepart(destination.getDateDepart());
            destination1.setPrixAdo(destination.getPrixAdo());
            destination1.setPrixAdulte(destination.getPrixAdulte());
            destination1.setHotelSejoure(destination.getHotelSejoure());
            destination1.setNbrJour(destination.getNbrJour());
            transaction.commit();
            str="ok";
        }catch (Exception e){
            if (transaction!=null)
                transaction.rollback();
            e.printStackTrace();
        }

        return str;
    }

    @Override
    public String delDestination(int id) {
        session=factory.getCurrentSession() ;
        Destination destination ;
        List<Reservation> list=null;
        String str="";
        Transaction transaction=null ;
        try {
            transaction=session.beginTransaction();
            destination=session.get(Destination.class,id);
            session=factory.getCurrentSession();
            session.delete(destination);
            session=factory.getCurrentSession();
            list=session.createQuery("from Reservation  where id_destination ="+id).list();
            for (int i = 0; i <list.size() ; i++) {
                session=factory.getCurrentSession();
                session.delete(list.get(i));
            }
            transaction.commit();
            str="ok" ;
        }catch (Exception e){
            if (transaction!=null)
                transaction.rollback();
            e.printStackTrace();
        }
        return str;
    }

    @Override
    public Destination getDestination(int id) {
        session=factory.getCurrentSession() ;
        Destination destination=new Destination() ;
        Transaction transaction=null ;

        try {
            transaction=session.beginTransaction();
            destination=session.get(Destination.class,id);
            transaction.commit();
        }catch (Exception e){
            if (transaction!=null)
                transaction.rollback();
            e.printStackTrace();
        }
        return destination ;
    }

    @Override
    public List<Destination> getAllDestination() {
        session=factory.getCurrentSession() ;
        List<Destination> destinations =null;
        Transaction transaction=null ;
        try {
            transaction=session.beginTransaction();
            destinations= session.createQuery("from Destination").list();
            transaction.commit();
        }catch (Exception e){
            if (transaction!=null)
                transaction.rollback();
            e.printStackTrace();
        }

        return destinations;
    }

    @Override
    public String addReservation(Reservation reservation) {
        session=factory.getCurrentSession() ;
        String str="";
        Transaction transaction=null ;
        try {
            transaction=session.beginTransaction();
            session.save(reservation);
            transaction.commit();
            str="ok" ;
        }catch (Exception e){
            if (transaction!=null)
                transaction.rollback();
            e.printStackTrace();
        }
        return str;
    }

    @Override
    public String delReservation(int id) {
        session=factory.getCurrentSession() ;
        Reservation reservation ;
        String str="";
        Transaction transaction=null ;
        try {
            transaction=session.beginTransaction();
            reservation=session.get(Reservation.class,id);
            session=factory.getCurrentSession();
            session.delete(reservation);
            transaction.commit();
            str="ok" ;
        }catch (Exception e){
            if (transaction!=null)
                transaction.rollback();
            e.printStackTrace();
        }

        return str;
    }

    @Override
    public Object[] getReservation(int id) {
        session=factory.getCurrentSession();
        Object [] objects =new Object[2];
        Reservation reservation=new Reservation();
        Destination destination=new Destination();
        Transaction transaction=null;
        try {
            transaction=session.beginTransaction();
            reservation=session.get(Reservation.class,id);
            int des=reservation.getIdDestination();
            session=factory.getCurrentSession();
            destination=session.get(Destination.class,des);
            transaction.commit();
            objects[0]=reservation ;
            objects[1]=destination ;
        }
        catch (Exception e){
            if (transaction!=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return objects ;
    }

    @Override
    public List<Reservation> getAllReservation() {
        session=factory.getCurrentSession() ;
        List<Reservation>reservation=null ;
        Transaction transaction=null ;
        try {
            transaction=session.beginTransaction();
             reservation=session.createQuery("from Reservation").list();
            transaction.commit();
        }catch (Exception e){
            if (transaction!=null)
                transaction.rollback();
            e.printStackTrace();
        }
        return reservation;
    }
}
