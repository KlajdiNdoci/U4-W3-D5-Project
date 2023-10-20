package KlajdiNdoci.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@DiscriminatorValue("Libro")
@NamedQuery(name = "getByAuthor", query = "SELECT c FROM Catalogo c WHERE LOWER(autore) = :author")
public class Libro extends Catalogo {

    private String autore;
    private String genere;


    public Libro(String titolo, String autore, String genere) {
        super(titolo);
        this.autore = autore;
        this.genere = genere;
    }

    public Libro() {
    }

    public Libro(long ISBN, String titolo, int annoPubblicazione, int numeroPagine, String autore, String genere) {
        super(ISBN, titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }

    public String getGenere() {
        return genere;
    }

    public String getAutore() {
        return autore;
    }


    @Override
    public String toString() {
        return "Libro{" +
                "autore='" + autore + '\'' +
                ", genere='" + genere + '\'' +
                ", ISBN=" + ISBN +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}';
    }


}
