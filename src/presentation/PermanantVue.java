package presentation;

import domaine.Module;
import domaine.Permanent;
import metier.EnseignantService;
import metier.ModuleService;

import java.util.Scanner;

public class PermanantVue {
    private static final EnseignantService enseignantService = new EnseignantService() ;
    private static final ModuleService moduleService =new ModuleService();
    public void menu() {
        Scanner sc = new Scanner(System.in);
        int choix = 0;

        do {
            System.out.println("\n");
            System.out.println("________________________________");
            System.out.println("____________PERMANANTS__________");
            System.out.println("________________________________");
            System.out.println("1. Créer un permanant");
            System.out.println("2. Afficher les permanants");
            System.out.println("3. Modifier un permanant");
            System.out.println("4. Supprimer un permanant");
            System.out.println("0. Menu precedent");
            choix = sc.nextInt();

            switch (choix) {
                case 1 -> {
                    Permanent permanent = new Permanent();
                    System.out.println("Nom ?");
                    permanent.setNom(sc.next());
                    System.out.println("Prénom ?");
                    permanent.setPrenom(sc.next());
                    System.out.println("Spécialité ?");
                    permanent.setSpecialite(sc.next());
                    System.out.println("Grade ?");
                    permanent.setGrade(sc.next());
                    System.out.println("Prime ?");
                    permanent.setPrimeP(sc.nextDouble());
                    int numModule = 0;
                    do {
                        System.out.println("\t_______Choisir le modules a ajouter______");
                        moduleService.afficherModule();
                        System.out.println("\tChoisir le '0' pour terminer !!!");
                        numModule = sc.nextInt();
                        Module moduleRech = moduleService.rechercherModuleByNum(numModule);
                        if (moduleRech != null) {
                            permanent.addModule(moduleRech);
                        } else {
                            System.out.println("******************************");
                            System.out.println("* rentrer un numero correcte *");
                            System.out.println("******************************");
                        }
                    } while (numModule != 0);
                    enseignantService.creatPermanent(permanent);
                }
                case 2 -> enseignantService.afficherPermanents();
                case 3 -> {
                    int numPermanantRech = 0;
                    System.out.println("Saisir le numero du permanent a modifier");
                    numPermanantRech = sc.nextInt();
                    Permanent permanentRechercher = enseignantService.rechercherPermanantByNumber(numPermanantRech);
                    if (permanentRechercher != null){
                        System.out.println("Nom ?");
                        permanentRechercher.setNom(sc.next());
                        System.out.println("Prénom ?");
                        permanentRechercher.setPrenom(sc.next());
                        System.out.println("Spécialité ?");
                        permanentRechercher.setSpecialite(sc.next());
                        System.out.println("Grade ?");
                        permanentRechercher.setGrade(sc.next());
                        System.out.println("Prime ?");
                        permanentRechercher.setPrimeP(sc.nextDouble());
                    }else {
                        System.out.println("\n\033[31m ********************************************* \033[0m");
                        System.out.println("\033[31m Le permanant est inexistant \033[0m");
                        System.out.println("\033[31m ********************************************* \033[0m");
                    }
                }
                case 4 -> {
                    int numPermanantRech = 0;
                    System.out.println("Saisir le numero du permanant a supprimer");
                    numPermanantRech = sc.nextInt();
                    Permanent permanantRechercher = enseignantService.rechercherPermanantByNumber(numPermanantRech);
                    if (permanantRechercher != null){
                        enseignantService.deletePermanent(permanantRechercher);
                    }else {
                        System.out.println("\n\033[31m ********************************************* \033[0m");
                        System.out.println("\033[31m Le permanant est inexistant \033[0m");
                        System.out.println("\033[31m ********************************************* \033[0m");
                    }
                }
            }
        } while (choix!=0);
    }
}
