package KlajdiNdoci;


import KlajdiNdoci.utils.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


public class Application {
    private static final EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        try {


        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        } finally {
            em.close();
            emf.close();
        }

    }
}
