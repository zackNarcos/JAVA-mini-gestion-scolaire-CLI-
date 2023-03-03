package presentation;

import domaine.Enseignant;
import domaine.Etudiant;
import domaine.Module;
import metier.EtudiantService;
import metier.ModuleService;

import java.util.Scanner;

public class EtudiantVue {
    private static final EtudiantService etudiantService = new EtudiantService();
    private static final ModuleService moduleService =new ModuleService();
    public void menu() {
        Scanner sc = new Scanner(System.in);
        int choix = 0;

        do {
            System.out.println("\n");
            System.out.println("________________________________");
            System.out.println("_____________ETUDIANTS__________");
            System.out.println("________________________________");
            System.out.println("1. Créer un etudiant");
            System.out.println("2. Afficher les etudiant");
            System.out.println("3. Modifier un etudiant");
            System.out.println("4. Supprimer un etudiant");
            System.out.println("5. Assigner un module a un etudiant");
            System.out.println("6. Retirer un module a un etudiant");
            System.out.println("7. Afficher module d'un etudiant");
            System.out.println("0. Menu precedent");
            choix = sc.nextInt();

            switch (choix) {
                case 1 -> {
                    Etudiant etudiant = new Etudiant();
                    System.out.println("Nom ?");
                    etudiant.setNom(sc.next());
                    System.out.println("Prénom ?");
                    etudiant.setPrenom(sc.next());
                    System.out.println("classe ?");
                    etudiant.setClasse(sc.next());
                    int numModuleEtu = 0;
                    do {
                        System.out.println("\t_______Choisir le modules a ajouter______");
                        moduleService.afficherModule();
                        System.out.println("\tChoisir le '0' pour terminer !!!");
                        numModuleEtu = sc.nextInt();
                        Module moduleRech = moduleService.rechercherModuleByNum(numModuleEtu);
                        if (moduleRech != null) {
                            etudiant.addModule(moduleRech);
                            moduleRech.addEtudiant(etudiant);
                        } else {
                            System.out.println("******************************");
                            System.out.println("* rentrer un numero correcte *");
                            System.out.println("******************************");
                        }
                    } while (numModuleEtu != 0);
                    etudiantService.createEtudiant(etudiant);
                }
                case 2 -> etudiantService.afficherEtudiants();
                case 3 -> {
                    int numEtu = 0;
                    System.out.println("Saisir le numero de l'etudiant a modifier");
                    numEtu = sc.nextInt();
                    Etudiant etudiantRechercher = etudiantService.rechercherEtudiantByNumber(numEtu);
                    if (etudiantRechercher != null){
                        System.out.println("Nom ?");
                        etudiantRechercher.setNom(sc.next());
                        System.out.println("Prénom ?");
                        etudiantRechercher.setPrenom(sc.next());
                        System.out.println("classe ?");
                        etudiantRechercher.setClasse(sc.next());
                    }else {
                        System.out.println("\n\033[31m ********************************************* \033[0m");
                        System.out.println("\033[31m L'etudiant(e) recherché est inexistant \033[0m");
                        System.out.println("\033[31m ********************************************* \033[0m");
                    }
                }
                case 4 -> {
                    int numEtu = 0;
                    System.out.println("Saisir le numero de l'etudiant a suprimer");
                    numEtu = sc.nextInt();
                    Etudiant etudiantRechercher = etudiantService.rechercherEtudiantByNumber(numEtu);
                    if (etudiantRechercher != null){
                        etudiantService.deleteEtudiant(etudiantRechercher);
                    }else {
                        System.out.println("\n\033[31m ********************************************* \033[0m");
                        System.out.println("\033[31m L'etudiant(e) recherché est inexistant \033[0m");
                        System.out.println("\033[31m ********************************************* \033[0m");
                    }
                }
                case 5 -> {
                    int numEtu = 0;
                    System.out.println("Saisir le numero de l'etudiant a editer");
                    numEtu = sc.nextInt();
                    Etudiant etudiantRechercher = etudiantService.rechercherEtudiantByNumber(numEtu);
                    if (etudiantRechercher != null){
                        moduleService.afficherModule();
                        int numModuleRech = 0;
                        System.out.println("Saisir le numero du module a assigner");
                        numModuleRech = sc.nextInt();
                        Module moduleRech = moduleService.rechercherModuleByNum(numModuleRech);
                        if (moduleRech != null) {
                            etudiantRechercher.addModule(moduleRech);
                        } else {
                            System.out.println("****************************************");
                            System.out.println("* rentrer un numero de module existant *");
                            System.out.println("****************************************");
                        }
                    }else {
                        System.out.println("\n\033[31m ********************************************* \033[0m");
                        System.out.println("\033[31m L'etudiant recherché est inexistant \033[0m");
                        System.out.println("\033[31m ********************************************* \033[0m");
                    }
                }
                case 6 -> {
                    int numEtu = 0;
                    System.out.println("Saisir le numero de l'etudiant a editer");
                    numEtu = sc.nextInt();
                    Etudiant etudiantRechercher = etudiantService.rechercherEtudiantByNumber(numEtu);
                    if (etudiantRechercher != null){
                        etudiantRechercher.afficher();
                        int numModuleRech = 0;
                        System.out.println("Saisir le numero du module a retirer");
                        numModuleRech = sc.nextInt();
                        Module moduleRech = moduleService.rechercherModuleByNum(numModuleRech);
                        if (moduleRech != null) {
                            etudiantRechercher.removeModule(moduleRech);
                        } else {
                            System.out.println("****************************************");
                            System.out.println("* rentrer un numero de module existant *");
                            System.out.println("****************************************");
                        }
                    }else {
                        System.out.println("\n\033[31m ********************************************* \033[0m");
                        System.out.println("\033[31m L'etudiant recherché est inexistant \033[0m");
                        System.out.println("\033[31m ********************************************* \033[0m");
                    }
                }
                case 7 -> {
                    int numEtu = 0;
                    System.out.println("Saisir le numero de l'etudiant recherché");
                    numEtu = sc.nextInt();
                    etudiantService.afficherEtudiantsDonnee(numEtu);
                }
            }
        } while (choix!=0);
    }
}
