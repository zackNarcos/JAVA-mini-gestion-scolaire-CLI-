package dao;

import domaine.Etudiant;

import java.util.ArrayList;

public class EtudiantDAO {
    private ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>();
    private static int incEtudiant = 0;

    public ArrayList<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void createEtudiant(Etudiant etudiant){
        Etudiant etudiantRechercher = rechercherEtudiantByName(etudiant.getNom(), etudiant.getPrenom());
        if (etudiantRechercher != null){
            System.out.println("\n\033[31m ********************************************* \033[0m");
            System.out.println("\033[31m L'etudiant(e) '" + etudiant.getNom() + " " + etudiant.getPrenom() + "' est deja exitant \033[0m");
            System.out.println("\033[31m ********************************************* \033[0m");
        }else {
            incEtudiant++;
            etudiant.setNumEtu(incEtudiant);
            etudiants.add(etudiant);
        }
    }
    public void deleteEtudiant(Etudiant etudiant){
        etudiants.remove(etudiant);
    }
    public Etudiant rechercherEtudiantByName(String nom, String prenom) {
        Etudiant etudiant = null;
        for (Etudiant e : etudiants) {
            if (e.getNom().equalsIgnoreCase(nom) && e.getPrenom().equalsIgnoreCase(prenom))
            {
                etudiant = e;
                break;
            }
        }
        return etudiant;
    }
    public Etudiant rechercherEtudiantByNumber(int numEtu) {
        Etudiant etudiant = null;
        for (Etudiant e : etudiants) {
            if (e.getNumEtu() == numEtu)
            {
                etudiant = e;
                break;
            }
        }
        return etudiant;
    }
}
