package com.nri;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class Test1to1Mapping 
{
    public static void main( String[] args )
    {
        System.out.println( "Hibernate Mapping started" );
        
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        
        Transaction tx = session.beginTransaction();
        
        Customer cone = new Customer();
        cone.setCustid(1);
        cone.setCustname("pooja");
        cone.setCustcity("kol");
        
        Customer ctwo = new Customer();
        ctwo.setCustid(1);
        ctwo.setCustname("dj");
        ctwo.setCustcity("bom");
        
        Orders ordone = new Orders();
        ordone.setOrdid(1);
        ordone.setOrdname("khaana");
        ordone.setOrdprice(200);
        ordone.setCustomers(cone);
        
        Orders ordtwo = new Orders();
        ordtwo.setOrdid(1);
        ordtwo.setOrdname("khaana");
        ordtwo.setOrdprice(200);
        ordtwo.setCustomers(ctwo);
        
        cone.setOrder(ordone);
        ctwo.setOrder(ordtwo);
        
        session.save(cone);
        session.save(ctwo);
        
        tx.commit();
        session.close();
        factory.close();
        
        }
}
