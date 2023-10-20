package KlajdiNdoci.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Prestito implements Serializable {
    @ManyToMany
    @JoinTable(name = "prestito_utente",
            joinColumns = @JoinColumn(name = "prestito_id"),
            inverseJoinColumns = @JoinColumn(name = "utente_id"))
    private Set<Utente> utenti;

    @Id
    @ManyToOne
    @JoinColumn(name = "elemento_prestato_isbn", nullable = false)
    private Catalogo elementoPrestato;

    private LocalDate dataInizioPrestito;
    private LocalDate dataRestituzionePrevista;
    private LocalDate dataRestituzioneEffettiva;


    public Prestito() {
    }

    public Prestito(Set<Utente> utenti, Catalogo elementoPrestato, LocalDate dataInizioPrestito, LocalDate getDataRestituzioneEffettiva) {
        this.utenti = utenti;
        this.elementoPrestato = elementoPrestato;
        this.dataInizioPrestito = dataInizioPrestito;
        dataRestituzionePrevista = dataInizioPrestito.plusDays(30);
        this.dataRestituzioneEffettiva = getDataRestituzioneEffettiva;
    }

    public Set<Utente> getUtenti() {
        return utenti;
    }

    public void setUtenti(Set<Utente> utenti) {
        this.utenti = utenti;
    }

    public Catalogo getElementoPrestato() {
        return elementoPrestato;
    }

    public void setElementoPrestato(Catalogo ElementoPrestato) {
        this.elementoPrestato = ElementoPrestato;
    }


    public LocalDate getDataInizioPrestito() {
        return dataInizioPrestito;
    }

    public void setDataInizioPrestito(LocalDate dataInizioPrestito) {
        this.dataInizioPrestito = dataInizioPrestito;
    }

    public LocalDate getDataRestituzionePrevista() {
        return dataRestituzionePrevista;
    }


    public LocalDate getDataRestituzioneEffettiva() {
        return dataRestituzioneEffettiva;
    }

    public void setDataRestituzioneEffettiva(LocalDate dataRestituzioneEffettiva) {
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "utente=" + utenti +
                ", elementoPrestato=" + elementoPrestato +
                ", dataInizioPrestito=" + dataInizioPrestito +
                ", dataRestituzionePrevista=" + dataRestituzionePrevista +
                ", dataRestituzioneEffettiva=" + dataRestituzioneEffettiva +
                '}';
    }
}
