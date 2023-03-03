package presentation;

import domaine.Module;
import metier.ModuleService;

import java.util.Scanner;

public class ModuleVue {
    private static final ModuleService moduleService =new ModuleService();
    public void menu(){
        Scanner sc = new Scanner(System.in);
        int choix = 0;

        do {
            System.out.println("\n");
            System.out.println("________________________________");
            System.out.println("______________MODULES___________");
            System.out.println("________________________________");
            System.out.println("1. Créer un module");
            System.out.println("2. Afficher les modules");
            System.out.println("3. Modifier un module");
            System.out.println("4. Supprimer un module");
            System.out.println("5. rechercher un module");
            System.out.println("0. Menu precedent");
            choix = sc.nextInt();

            switch (choix) {
                case 1 -> {
                    Module module = new Module();
                    System.out.println("Nom du module?");
                    module.setNomMod(sc.next());
                    System.out.println("Duree du module?");
                    module.setDuree(sc.nextInt());
                    moduleService.createModule(module);
                }
                case 2 -> moduleService.afficherModule();
                case 3 -> {
                    int numModuleRech = 0;
                    System.out.println("Saisir le numero du module a modifier");
                    numModuleRech = sc.nextInt();
                    Module moduleRechercher = moduleService.rechercherModuleByNum(numModuleRech);
                    if (moduleRechercher != null){
                        System.out.println("Nom du module?");
                        moduleRechercher.setNomMod(sc.next());
                        System.out.println("Duree du module?");
                        moduleRechercher.setDuree(sc.nextInt());
                    }else {
                        System.out.println("\n\033[31m ********************************************* \033[0m");
                        System.out.println("\033[31m Le module est inexistant \033[0m");
                        System.out.println("\033[31m ********************************************* \033[0m");
                    }
                }
                case 4 -> {
                    int numModuleRech = 0;
                    System.out.println("Saisir le numero du module a supprimer");
                    numModuleRech = sc.nextInt();
                    Module moduleRechercher = moduleService.rechercherModuleByNum(numModuleRech);
                    if (moduleRechercher != null){
                        moduleService.deleteModule(moduleRechercher);
                    }else {
                        System.out.println("\n\033[31m ********************************************* \033[0m");
                        System.out.println("\033[31m Le module est inexistant \033[0m");
                        System.out.println("\033[31m ********************************************* \033[0m");
                    }
                }
                case 5 -> {
                    int numModuleRech = 0;
                    System.out.println("Saisir le numero du module a recherché");
                    numModuleRech = sc.nextInt();
                    moduleService.afficherModuleDonnee(numModuleRech);
                }
            }
        } while (choix!=0);
    }
}
