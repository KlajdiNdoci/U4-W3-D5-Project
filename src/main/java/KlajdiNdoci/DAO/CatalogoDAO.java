package KlajdiNdoci.DAO;

import KlajdiNdoci.entities.Catalogo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;

public class CatalogoDAO {
    private final EntityManager em;

    public CatalogoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Catalogo catalogo) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(catalogo);
        transaction.commit();
        System.out.println("Elemento del catalogo salvato correttamente");
    }

    public Catalogo getByISBN(long ISBN) {
        return em.find(Catalogo.class, ISBN);

    }

    public void delete(long ISBN) {
        Catalogo selectedEl = em.find(Catalogo.class, ISBN);
        if (selectedEl != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(selectedEl);
            transaction.commit();
            System.out.println("L'elemento con l'ISBN " + ISBN + " é stato correttamente cancellato");
        } else {
            System.err.println("L'elemento con l'ISBN " + ISBN + " non esiste");
        }
    }

    public List<Catalogo> getByYear(int year) {
        TypedQuery<Catalogo> getByYearQuery = em.createQuery(
                "SELECT c FROM Catalogo c WHERE annoPubblicazione = :year", Catalogo.class);
        getByYearQuery.setParameter("year", year);
        return getByYearQuery.getResultList();
    }


    public List<Catalogo> getByAuthor(String author) {
        TypedQuery<Catalogo> getByAuthorQuery = em.createNamedQuery("getByAuthor", Catalogo.class);
        getByAuthorQuery.setParameter("author", author);
        List<Catalogo> results = getByAuthorQuery.getResultList();
        if (!results.isEmpty()) {

            return getByAuthorQuery.getResultList();
        } else {
            System.out.println("Non esistono autori con questo nome nel database");
            return Collections.emptyList();
        }
    }

    public List<Catalogo> getByTitle(String title) {
        TypedQuery<Catalogo> getByTitleQuery = em.createQuery(
                "SELECT c FROM Catalogo c WHERE LOWER(titolo) LIKE LOWER(:title)", Catalogo.class);
        getByTitleQuery.setParameter("title", "%" + title.toLowerCase() + "%");
        List<Catalogo> results = getByTitleQuery.getResultList();
        if (!results.isEmpty()) {
            return getByTitleQuery.getResultList();
        } else {
            System.out.println("Non esistono autori con questo nome nel database");
            return Collections.emptyList();
        }
    }


}

