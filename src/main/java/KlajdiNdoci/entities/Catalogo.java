package KlajdiNdoci.entities;

import javax.persistence.*;
import java.util.Random;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "Catalogo")
@DiscriminatorValue("Catalogo")
public abstract class Catalogo {
    @Id
    @GeneratedValue
    protected long ISBN;
    protected String titolo;
    protected int annoPubblicazione;
    protected int numeroPagine;

    public Catalogo() {
    }

    public Catalogo(String titolo) {
        Random random = new Random();
        this.titolo = titolo;
        this.annoPubblicazione = random.nextInt(1800, 2023);
        this.numeroPagine = random.nextInt(100, 800);
    }

    public Catalogo(long ISBN, String titolo, int annoPubblicazione, int numeroPagine) {
        this.ISBN = ISBN;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    public String getTitolo() {
        return titolo;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public long getISBN() {
        return ISBN;
    }

    @Override
    public String toString() {
        return "Catalogo{" +
                "ISBN=" + ISBN +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}';
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

}
