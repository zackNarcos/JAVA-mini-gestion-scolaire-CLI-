package presentation;

import domaine.Enseignant;
import domaine.Module;
import metier.EnseignantService;
import metier.ModuleService;

import java.util.Scanner;

public class EnseignantVue {
    private static final EnseignantService enseignantService = new EnseignantService() ;
    private static final ModuleService moduleService =new ModuleService();
    private static VacataireVue vacataireVue = new VacataireVue();
    private static PermanantVue permanantVue = new PermanantVue();
    public void menu() {
        Scanner sc = new Scanner(System.in);
        int choix = 0;

        do {
            System.out.println("\n");
            System.out.println("________________________________");
            System.out.println("___________ENSEIGNANTS__________");
            System.out.println("________________________________");
            System.out.println("1. Vacataire");
            System.out.println("2. Permanant");
            System.out.println("3. Afficher les enseignants");
            System.out.println("4. Rechercher un enseignant");
            System.out.println("5. Assigner un module a un enseignant");
            System.out.println("6. Retirer un module a un enseignant");
            System.out.println("0. Menu precedent");
            choix = sc.nextInt();

            switch (choix) {
                case 1 -> vacataireVue.menu();
                case 2 -> permanantVue.menu();
                case 3 -> enseignantService.afficherEnseignants();
                case 4 -> {
                    int numEnseignantRech = 0;
                    System.out.println("Saisir le numero de l'enseignant a recherché");
                    numEnseignantRech = sc.nextInt();
                    Enseignant enseignantRech = enseignantService.rechercherEnseignantByNumber(numEnseignantRech);
                    if (enseignantRech != null){
                        enseignantRech.afficher();
                    }else {
                        System.out.println("\n\033[31m ********************************************* \033[0m");
                        System.out.println("\033[31m L'enseignant recherché est inexistant \033[0m");
                        System.out.println("\033[31m ********************************************* \033[0m");
                    }
                }
                case 5 -> {
                    int numEnseignantRech = 0;
                    System.out.println("Saisir le numero de l'enseignant a editer");
                    numEnseignantRech = sc.nextInt();
                    Enseignant enseignantRech = enseignantService.rechercherEnseignantByNumber(numEnseignantRech);
                    if (enseignantRech != null){
                        moduleService.afficherModule();
                        int numModuleRech = 0;
                        System.out.println("Saisir le numero du module a assigner");
                        numModuleRech = sc.nextInt();
                        Module moduleRech = moduleService.rechercherModuleByNum(numModuleRech);
                        if (moduleRech != null) {
                            enseignantRech.addModule(moduleRech);
                        } else {
                            System.out.println("****************************************");
                            System.out.println("* rentrer un numero de module existant *");
                            System.out.println("****************************************");
                        }
                    }else {
                        System.out.println("\n\033[31m ********************************************* \033[0m");
                        System.out.println("\033[31m L'enseignant recherché est inexistant \033[0m");
                        System.out.println("\033[31m ********************************************* \033[0m");
                    }
                }
                case 6 -> {
                    int numEnseignantRech = 0;
                    System.out.println("Saisir le numero de l'enseignant a editer");
                    numEnseignantRech = sc.nextInt();
                    Enseignant enseignantRech = enseignantService.rechercherEnseignantByNumber(numEnseignantRech);
                    if (enseignantRech != null){
                        enseignantRech.afficherModules();
                        int numModuleRech = 0;
                        System.out.println("Saisir le numero du module a retirer");
                        numModuleRech = sc.nextInt();
                        Module moduleRech = moduleService.rechercherModuleByNum(numModuleRech);
                        if (moduleRech != null) {
                            enseignantRech.removeModule(moduleRech);
                        } else {
                            System.out.println("****************************************");
                            System.out.println("* rentrer un numero de module existant *");
                            System.out.println("****************************************");
                        }
                    }else {
                        System.out.println("\n\033[31m ********************************************* \033[0m");
                        System.out.println("\033[31m L'enseignant recherché est inexistant \033[0m");
                        System.out.println("\033[31m ********************************************* \033[0m");
                    }
                }
            }
        } while (choix!=0);
    }
}
