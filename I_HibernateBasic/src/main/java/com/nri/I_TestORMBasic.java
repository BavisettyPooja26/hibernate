package com.nri;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class I_TestORMBasic 
{
    public static void main( String[] args )
    {
        System.out.println( "Hibernate started" );
        
        //we need to configure session for hibernate
        Configuration config = new Configuration();
        SessionFactory factory = config.configure("hibernate.cfg.xml").buildSessionFactory();
       
        Session session=factory.openSession();

		Customer obj=new Customer();
		obj.setCustid(1);
		obj.setCustcity("kol");
		obj.setCustname("Pooja");
		
		Orders ordobj = new Orders();
		ordobj.setOrdid(1);
		ordobj.setOrdname("Farm fresh pizza");
		ordobj.setOrdprice(123);
		
		obj.setOrder(ordobj);
		
		// now we need to start transaction before asking hibernate to save our obj in database
		Transaction tx= session.beginTransaction();
		//-->updating virtual table; temporarily saves the result	
        //session.save(obj);
        //fetches the data; fires select command; eager loading
		//Customer cone = (Customer)session.get(Customer.class, 1);
        
        //doesnot fires select command; lazy loading; loads only when getters are called
        Customer cone = (Customer)session.load(Customer.class, 1);
        System.out.println(cone);
        //-->pushing in db
		tx.commit(); 
        
		session.close();
        factory.close();
    }
}
