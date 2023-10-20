package KlajdiNdoci;


import KlajdiNdoci.DAO.CatalogoDAO;
import KlajdiNdoci.DAO.PrestitoDAO;
import KlajdiNdoci.DAO.UtenteDAO;
import KlajdiNdoci.entities.*;
import KlajdiNdoci.enums.Periodicitá;
import KlajdiNdoci.utils.JpaUtil;
import com.github.javafaker.Book;
import com.github.javafaker.Faker;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;


public class Application {
    private static final EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        try {
            CatalogoDAO catalogoDAO = new CatalogoDAO(em);
            PrestitoDAO prestitoDAO = new PrestitoDAO(em);
            UtenteDAO utenteDAO = new UtenteDAO(em);
            Faker faker = new Faker();
            Book fakeBook = new Faker().book();
            Libro book1 = new Libro(fakeBook.title(), fakeBook.author(), fakeBook.genre());
//            catalogoDAO.save(book1);

            Book fakeMagazine = new Faker().book();
            Rivista settimanale = new Rivista(fakeMagazine.title(), Periodicitá.SETTIMANALE);
            Rivista mensile = new Rivista(fakeMagazine.title(), Periodicitá.MENSILE);
            Rivista semestrale = new Rivista(fakeMagazine.title(), Periodicitá.SEMESTRALE);
//            catalogoDAO.save(settimanale);
//            catalogoDAO.save(mensile);
//            catalogoDAO.save(semestrale);


            Utente utente1 = new Utente(faker.name().firstName(), faker.name().lastName(), generateLocalDate());
            Utente utente2 = new Utente(faker.name().firstName(), faker.name().lastName(), generateLocalDate());
            Utente utente3 = new Utente(faker.name().firstName(), faker.name().lastName(), generateLocalDate());
//            utenteDAO.save(utente1);
//            utenteDAO.save(utente2);
//            utenteDAO.save(utente3);

            Set<Utente> utentiPrestito1 = new HashSet<>();
            Catalogo elemPrestito1 = catalogoDAO.getByISBN(76);
            Utente utenteDB = utenteDAO.getById(80);
            if (utenteDB != null) {
                utentiPrestito1.add(utenteDB);
            }

            Prestito prestito1 = new Prestito(utentiPrestito1, elemPrestito1, LocalDate.of(2023, 10, 10), null);
            System.out.println(prestito1);
//            prestitoDAO.save(prestito1);
            catalogoDAO.getByYear(2011).forEach(System.out::println);


//            catalogoDAO.delete(4);
//            utenteDAO.delete(9);5


        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        } finally {
            em.close();
            emf.close();
        }

    }

    public static LocalDate generateLocalDate() {
        Random random = new Random();

        int year = random.nextInt(100) + 1920;
        int month = random.nextInt(12) + 1;
        int day = random.nextInt(LocalDate.of(year, month, 1).lengthOfMonth()) + 1;
        return LocalDate.of(year, month, day);
    }
}
