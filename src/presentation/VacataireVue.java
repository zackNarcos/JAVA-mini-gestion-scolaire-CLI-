package presentation;

import domaine.Module;
import domaine.Vacataire;
import metier.EnseignantService;
import metier.ModuleService;

import java.util.Scanner;

public class VacataireVue {
    private static final EnseignantService enseignantService = new EnseignantService() ;
    private static final ModuleService moduleService =new ModuleService();
    public void menu() {
        Scanner sc = new Scanner(System.in);
        int choix = 0;

        do {
            System.out.println("\n");
            System.out.println("________________________________");
            System.out.println("____________VACATAIRES__________");
            System.out.println("________________________________");
            System.out.println("1. Créer un vacataire");
            System.out.println("2. Afficher les vacataires");
            System.out.println("3. Modifier un vacataire");
            System.out.println("4. Supprimer un vacataire");
            System.out.println("0. Menu precedent");
            choix = sc.nextInt();

            switch (choix) {
                case 1 -> {
                    Vacataire vacataire = new Vacataire();
                    System.out.println("Nom ?");
                    vacataire.setNom(sc.next());
                    System.out.println("Prénom ?");
                    vacataire.setPrenom(sc.next());
                    System.out.println("Spécialité ?");
                    vacataire.setSpecialite(sc.next());
                    System.out.println("Grade ?");
                    vacataire.setGrade(sc.next());
                    System.out.println("Prime ?");
                    vacataire.setPrimeV(sc.nextDouble());
                    int numModule1 = 0;
                    do {
                        System.out.println("\t_______Choisir le modules a ajouter______");
                        moduleService.afficherModule();
                        System.out.println("\tChoisir le '0' pour terminer !!!");
                        numModule1 = sc.nextInt();
                        Module moduleRech = moduleService.rechercherModuleByNum(numModule1);
                        if (moduleRech != null) {
                            vacataire.addModule(moduleRech);
                        } else {
                            System.out.println("******************************");
                            System.out.println("* rentrer un numero correcte *");
                            System.out.println("******************************");
                        }
                    } while (numModule1 != 0);
                    enseignantService.createVacataire(vacataire);
                }
                case 2 -> enseignantService.afficherVacataires();
                case 3 -> {
                    int numVacataireRech = 0;
                    System.out.println("Saisir le numero du vacataire a modifier");
                    numVacataireRech = sc.nextInt();
                    Vacataire vacataireRechercher = enseignantService.rechercherVacataireByNumber(numVacataireRech);
                    if (vacataireRechercher != null){
                        System.out.println("Nom ?");
                        vacataireRechercher.setNom(sc.next());
                        System.out.println("Prénom ?");
                        vacataireRechercher.setPrenom(sc.next());
                        System.out.println("Spécialité ?");
                        vacataireRechercher.setSpecialite(sc.next());
                        System.out.println("Grade ?");
                        vacataireRechercher.setGrade(sc.next());
                        System.out.println("Prime ?");
                        vacataireRechercher.setPrimeV(sc.nextDouble());
                    }else {
                        System.out.println("\n\033[31m ********************************************* \033[0m");
                        System.out.println("\033[31m Le vacataire est inexistant \033[0m");
                        System.out.println("\033[31m ********************************************* \033[0m");
                    }
                }
                case 4 -> {
                    int numVacataireRech = 0;
                    System.out.println("Saisir le numero du vacataire a supprimer");
                    numVacataireRech = sc.nextInt();
                    Vacataire vacataireRechercher = enseignantService.rechercherVacataireByNumber(numVacataireRech);
                    if (vacataireRechercher != null){
                        enseignantService.deleteVacataire(vacataireRechercher);
                    }else {
                        System.out.println("\n\033[31m ********************************************* \033[0m");
                        System.out.println("\033[31m Le vacataire est inexistant \033[0m");
                        System.out.println("\033[31m ********************************************* \033[0m");
                    }
                }
            }
        } while (choix!=0);
    }
}
