package metier;

import dao.EtudiantDAO;
import domaine.Etudiant;

public class EtudiantService {
    private EtudiantDAO etudiantDAO = new EtudiantDAO();
    public EtudiantService(){
    }

    public EtudiantService(EtudiantDAO etudiantDAO) {
        this.etudiantDAO = etudiantDAO;
    }
    public void createEtudiant(Etudiant etudiant){
        this.etudiantDAO.createEtudiant(etudiant);
    }
    public void deleteEtudiant(Etudiant etudiant){
        this.etudiantDAO.deleteEtudiant(etudiant);
    }
    public Etudiant rechercherEtudiantByNumber(int numEtu){
        return this.etudiantDAO.rechercherEtudiantByNumber(numEtu);
    }

    public void afficherEtudiants() {
        System.out.println("\n________________________");
        System.out.println("_______Etudiants________");
        System.out.println("________________________");
        this.etudiantDAO.getEtudiants().forEach(m -> {
            m.afficherSansModule();
            System.out.println("________________________");
        });
    }
    public void afficherEtudiantsDonnee(int numEtu) {
        Etudiant etudiantRechercher = rechercherEtudiantByNumber(numEtu);
        if (etudiantRechercher != null){
            etudiantRechercher.afficher();
        }else {
            System.out.println("\n\033[31m ********************************************* \033[0m");
            System.out.println("\033[31m L'etudiant(e) recherché est inexistant \033[0m");
            System.out.println("\033[31m ********************************************* \033[0m");
        }
    }
}
