package dao;

import domaine.Enseignant;
import domaine.Etudiant;
import domaine.Permanent;
import domaine.Vacataire;

import java.util.ArrayList;

public class EnseignantDAO {
    private ArrayList<Enseignant> enseignants = new ArrayList<Enseignant>();
    private static int incEnseignant = 4;
    public ArrayList<Enseignant> getEnseignants() {
        return enseignants;
    }

    public void creatPermanent(Permanent permanent){
        Permanent permanentRechercher = (Permanent) rechercherEnseignant(permanent.getNom(), permanent.getPrenom());
        if (permanentRechercher != null){
            System.out.println("\n\033[31m ********************************************* \033[0m");
            System.out.println("\033[31m L'enseignant '" + permanent.getNom() + " " + permanent.getPrenom() + "' est deja exitant \033[0m");
            System.out.println("\033[31m ********************************************* \033[0m");
        }else {
            incEnseignant++;
            permanent.setNumero(incEnseignant);
            enseignants.add(permanent);
        }
    }
    public void createVacataire(Vacataire vacataire){
        Vacataire vacRechercher = (Vacataire) rechercherEnseignant(vacataire.getNom(), vacataire.getPrenom());
        if (vacRechercher != null){
            System.out.println("\n\033[31m ********************************************* \033[0m");
            System.out.println("\033[31m L'enseignant '" + vacataire.getNom() + " " + vacataire.getPrenom() + "' est deja exitant \033[0m");
            System.out.println("\033[31m ********************************************* \033[0m");
        }else {
            incEnseignant++;
            vacataire.setNumero(incEnseignant);
            enseignants.add(vacataire);
        }
    }

    public void deletePermanent(Permanent permanent){
        enseignants.remove(permanent);
    }
    public void deleteVacataire(Vacataire vacataire){
        enseignants.remove(vacataire);
    }
    public Enseignant rechercherEnseignant(String nom, String prenom) {
        Enseignant enseignant = null;
        for (Enseignant e : enseignants) {
            if (e.getNom().equalsIgnoreCase(nom) && e.getPrenom().equalsIgnoreCase(prenom))
            {
                enseignant = e;
                break;
            }
        }
        return enseignant;
    }

    public Enseignant rechercherEnseignantByNumber(int numEtu) {
        Enseignant enseignant = null;
        for (Enseignant e : enseignants) {
            if (e.getNumero() == numEtu)
            {
                enseignant = e;
                break;
            }
        }
        return enseignant;
    }
    public Vacataire rechercherVacataireByNumber(int numEtu) {
        Enseignant enseignant = null;
        for (Enseignant e : enseignants) {
            if (e.getNumero() == numEtu)
            {
                enseignant = e;
                break;
            }
        }
        if (enseignant instanceof Vacataire) {
            return (Vacataire) enseignant;
        }else {
            System.out.println("Enseignant n'est pas de type Vacataire");
        }
        return null;
    }
    public Permanent rechercherPermanantByNumber(int numEtu) {
        Enseignant enseignant = null;
        for (Enseignant e : enseignants) {
            if (e.getNumero() == numEtu)
            {
                enseignant = e;
                break;
            }
        }
        if (enseignant instanceof Permanent) {
            return (Permanent) enseignant;
        }else {
            System.out.println("Enseignant n'est pas de type Permanent");
        }
        return null;
    }
}


