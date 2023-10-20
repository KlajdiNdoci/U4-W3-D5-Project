package KlajdiNdoci;


import KlajdiNdoci.DAO.CatalogoDAO;
import KlajdiNdoci.entities.Libro;
import KlajdiNdoci.utils.JpaUtil;
import com.github.javafaker.Book;
import com.github.javafaker.Faker;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


public class Application {
    private static final EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        try {
            CatalogoDAO catalogoDAO = new CatalogoDAO(em);
            Faker faker = new Faker();
            Book fakeBook = new Faker().book();
            Libro book1 = new Libro(fakeBook.title(), fakeBook.author(), fakeBook.genre());
            catalogoDAO.save(book1);

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        } finally {
            em.close();
            emf.close();
        }

    }
}
