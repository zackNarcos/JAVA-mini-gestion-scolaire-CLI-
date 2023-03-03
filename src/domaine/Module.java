package domaine;

import java.io.Serializable;
import java.util.ArrayList;

public class Module implements Serializable {
    private int numMod;
    private String nomMod;
    private int duree;

    private Enseignant enseignant;
    private ArrayList<Etudiant> etudiants;

    public Module() {
        this.etudiants = new ArrayList<Etudiant>();
    }

    public Module(int numMod, String nomMod, int duree) {
        this.numMod = numMod;
        this.nomMod = nomMod;
        this.duree = duree;
        this.etudiants = new ArrayList<Etudiant>();
    }

    public Module(int numMod, String nomMod, int duree, Enseignant enseignant) {
        this.numMod = numMod;
        this.nomMod = nomMod;
        this.duree = duree;
        this.enseignant = enseignant;
        this.etudiants = new ArrayList<Etudiant>();
    }

    public int getNumMod() {
        return numMod;
    }

    public void setNumMod( int numMod ) {
        this.numMod = numMod;
    }

    public String getNomMod() {
        return nomMod;
    }

    public void setNomMod(String nomMod) {
        this.nomMod = nomMod;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public ArrayList<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(ArrayList<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    public void addEtudiant(Etudiant etudiant) {
        this.etudiants.add(etudiant);
    }

    public void afficher() {
        System.out.println("Numéro : " + this.getNumMod());
        System.out.println("Nom : " + this.getNomMod());
        System.out.println("Durée : " + this.getDuree() + " Heure");
        if (enseignant != null) {
            System.out.println("Nom de l'enseignant :"+ enseignant.getNom());
            System.out.println("Numero de l'enseignant :" +enseignant.getNumero());
        }
    }

    public void afficherEtudiant() {
        this.afficher();
        System.out.println("________liste des étudiants_______");
        this.etudiants.forEach(m -> {
            m.afficherSansModule();
        });
        System.out.println("______________________________________");
    }
}
