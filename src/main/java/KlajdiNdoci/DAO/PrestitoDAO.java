package KlajdiNdoci.DAO;

import KlajdiNdoci.entities.Prestito;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

public class PrestitoDAO {
    private final EntityManager em;

    public PrestitoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Prestito prestito) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(prestito);
        transaction.commit();
        System.out.println("Prestito salvato correttamente");
    }

    public Prestito getById(long id) {
        return em.find(Prestito.class, id);

    }

    public void delete(long id) {
        Prestito selectedEl = em.find(Prestito.class, id);
        if (selectedEl != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(selectedEl);
            transaction.commit();
            System.out.println("Il prestito é con l'id " + id + " stato correttamente cancellato");
        } else {
            System.err.println("Il prestito con l'id " + id + " non esiste");
        }
    }

    public List<Prestito> getOverdueRentals() {
        LocalDate today = LocalDate.now();
        TypedQuery<Prestito> query = em.createQuery("SELECT p FROM Prestito p WHERE p.dataRestituzioneEffettiva IS NULL AND p.dataRestituzionePrevista < :today", Prestito.class);
        query.setParameter("today", today);
        return query.getResultList();
    }

}
