package presentation;

import java.util.Scanner;

public class Vue {
    private static final ModuleVue moduleVue = new ModuleVue();
    private static final EtudiantVue etudiantVue = new EtudiantVue();
    private static final EnseignantVue enseignantVue = new EnseignantVue();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choix = 0;

        do {
            System.out.println("\n");
            System.out.println("________________________________");
            System.out.println("__________MENU PRINCIPAL________");
            System.out.println("________________________________");
            System.out.println("1.Module");
            System.out.println("2.Enseignant");
            System.out.println("3.Etudiant");
            System.out.println("0.Sortie");
            choix=sc.nextInt();

            switch (choix) {
                case 1 -> moduleVue.menu();
                case 2 -> enseignantVue.menu();
                case 3 -> etudiantVue.menu();
            }
        }while (choix!=0);
        System.out.println("Fin de l'application");
    }
}
