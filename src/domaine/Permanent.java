package domaine;

import java.io.Serializable;

public class Permanent extends Enseignant implements Serializable {
    private double primeP;

    public Permanent() {
    }

    public Permanent(int numero, String nom, String prenom, String specialite, double primeP) {
        super(numero, nom, prenom, specialite);
        this.primeP = primeP;
    }

    public double getPrimeP() {
        return primeP;
    }

    public void setPrimeP(double primeP) {
        this.primeP = primeP;
    }

    @Override
    public void afficher() {
        System.out.println("Prime : " + this.primeP + " Fcfa");
        super.afficher();
    }
}
