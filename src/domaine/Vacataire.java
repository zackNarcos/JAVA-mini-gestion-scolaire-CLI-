package domaine;

import java.io.Serializable;

public class Vacataire extends Enseignant implements Serializable {
    private double primeV;

    public Vacataire() {
    }

    public Vacataire(int numero, String nom, String prenom, String specialite, double primeV) {
        super(numero, nom, prenom, specialite);
        this.primeV = primeV;
    }

    public double getPrimeV() {
        return primeV;
    }

    public void setPrimeV(double primeV) {
        this.primeV = primeV;
    }

    @Override
    public void afficher() {
        System.out.println("Prime : " + this.primeV + " Fcfa");
        super.afficher();
    }
}
