package com.nri;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Test1toMMapping 
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
        ctwo.setCustid(2);
        ctwo.setCustname("dj");
        ctwo.setCustcity("bom");
        
        Orders ordone = new Orders();
        ordone.setOrdid(1);
        ordone.setOrdname("khaana");
        ordone.setOrdprice(200);
        ordone.setCustomers(cone);
        
        Orders ordtwo = new Orders();
        ordtwo.setOrdid(2);
        ordtwo.setOrdname("khana");
        ordtwo.setOrdprice(300);
        ordtwo.setCustomers(cone);
        
        List<Orders> listord = new ArrayList<Orders>();
        listord.add(ordone);
        listord.add(ordtwo);
        cone.setOrder(listord);
        
        session.save(cone);
        
        tx.commit();
        session.close();
        factory.close();
        
        }
}
