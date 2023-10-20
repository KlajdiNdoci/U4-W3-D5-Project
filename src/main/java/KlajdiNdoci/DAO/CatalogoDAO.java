package KlajdiNdoci.DAO;

import KlajdiNdoci.entities.Catalogo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

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

    public Catalogo getById(long id) {
        return em.find(Catalogo.class, id);

    }

    public void delete(long id) {
        Catalogo selectedEl = em.find(Catalogo.class, id);
        if (selectedEl != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(selectedEl);
            transaction.commit();
            System.out.println("L'elemento é stato correttamente cancellato");
        } else {
            System.err.println("L'elemento con l'id " + id + " non esiste");
        }
    }


}

