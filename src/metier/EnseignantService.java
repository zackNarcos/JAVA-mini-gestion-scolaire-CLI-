package metier;

import dao.EnseignantDAO;
import domaine.Enseignant;
import domaine.Etudiant;
import domaine.Permanent;
import domaine.Vacataire;

public class EnseignantService {
    private EnseignantDAO enseignantDAO = new EnseignantDAO();

    public EnseignantService() {
        this.enseignantDAO.getEnseignants().add(new Permanent(1,"Abess","Zack","Python",1000000));
        this.enseignantDAO.getEnseignants().add(new Permanent(2,"Abessolo","Zackarie","angular",1000000));
        this.enseignantDAO.getEnseignants().add(new Vacataire(3,"Abess2","Zack2","anglais",1000000));
        this.enseignantDAO.getEnseignants().add(new Vacataire(4,"Abessolo2","Zackarie2","maths",100000));
    }
    public EnseignantService(EnseignantDAO enseignantDAO) {
        this.enseignantDAO = enseignantDAO;
    }

    public void creatPermanent(Permanent permanent){
        this.enseignantDAO.creatPermanent(permanent);
    }
    public void createVacataire(Vacataire vacataire){
        this.enseignantDAO.createVacataire(vacataire);
    }

    public void deletePermanent(Permanent permanent){
        this.enseignantDAO.deletePermanent(permanent);
    }
    public void deleteVacataire(Vacataire vacataire){
        this.enseignantDAO.deleteVacataire(vacataire);
    }


    public void afficherEnseignants() {
        System.out.println("\n________________________");
        System.out.println("______Enseignants_______");
        System.out.println("________________________");
        this.enseignantDAO.getEnseignants().forEach(m -> {
            m.afficher();
            System.out.println("________________________");
        });
    }
    public void afficherPermanents() {
        System.out.println("\n________________________");
        System.out.println("______Permanents________");
        System.out.println("________________________");
        this.enseignantDAO.getEnseignants().forEach(m -> {
            if(m instanceof Permanent) {
                m.afficher();
                System.out.println("________________________");
            }
        });
    }
    public void afficherVacataires() {
        System.out.println("\n________________________");
        System.out.println("_______Vacataires_______");
        System.out.println("________________________");
        this.enseignantDAO.getEnseignants().forEach(m -> {
            if(m instanceof Vacataire) {
                m.afficher();
                System.out.println("________________________");
            }
        });
    }

    public Enseignant rechercherEnseignantByNumber(int numEtu){
        return this.enseignantDAO.rechercherEnseignantByNumber(numEtu);
    }
    public Vacataire rechercherVacataireByNumber(int numEtu){
        return this.enseignantDAO.rechercherVacataireByNumber(numEtu);
    }
    public Permanent rechercherPermanantByNumber(int numEtu){
        return this.enseignantDAO.rechercherPermanantByNumber(numEtu);
    }
    public void afficherEnseignantDonnee(int numEns) {
        Enseignant enseignantRechercher = rechercherEnseignantByNumber(numEns);
        if (enseignantRechercher != null){
            enseignantRechercher.afficher();
        }else {
            System.out.println("\n\033[31m ********************************************* \033[0m");
            System.out.println("\033[31m L'enseignant(e) recherché est inexistant \033[0m");
            System.out.println("\033[31m ********************************************* \033[0m");
        }
    }
}
