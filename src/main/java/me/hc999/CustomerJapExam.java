package me.hc999;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import me.hc999.entity.Customer;

public class CustomerJapExam {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("customer-exam");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try {
//            em.persist(Customer.sample());
            Customer selectCustomer = em.find(Customer.class, "ID0001");
//            selectCustomer.setName("Kim");
//            selectCustomer.setRegisterDate(System.currentTimeMillis());
            em.remove(selectCustomer);

            System.out.println(selectCustomer.toString());
            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
