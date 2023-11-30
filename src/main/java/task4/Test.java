package task4;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class Test {
    static EntityManager em;

    public static void main(String[] args) {
        em = Persistence.createEntityManagerFactory("userPU").createEntityManager();
        System.out.println(em.createQuery("select u from User u").getResultList());
    }
}
