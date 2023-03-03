package domaine;

import java.io.Serializable;
import java.util.ArrayList;

public class Etudiant implements Serializable {
    private int numEtu;
    private String nom;
    private String prenom;
    private String classe;
    private ArrayList<Module> modules;

    public Etudiant() {
        this.modules = new ArrayList<Module>();
    }

    public Etudiant(int numEtu, String nom, String prenom, String classe) {
        this.numEtu = numEtu;
        this.nom = nom;
        this.prenom = prenom;
        this.classe = classe;
        this.modules = new ArrayList<Module>();
    }

    public int getNumEtu() {
        return numEtu;
    }

    public void setNumEtu(int numEtu) {
        this.numEtu = numEtu;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public ArrayList<Module> getModules() {
        return modules;
    }

    public void setModules(ArrayList<Module> modules) {
        this.modules = modules;
    }
    public void addModule(Module module) {
        Module moduleRech = null;
        for (Module m : this.getModules()) {
            if (m.getNumMod() == (module.getNumMod()))
            {
                moduleRech = m;
                break;
            }
        }

        if (moduleRech != null){
            System.out.println("*********************************************");
            System.out.println("Le module '" + module.getNomMod() + "' à deja été ajouté");
            System.out.println("*********************************************");
        }else {
            this.modules.add(module);
        }
    }

    public void removeModule(Module module) {
        Module moduleRech = null;
        for (Module m : this.getModules()) {
            if (m.getNumMod() == (module.getNumMod()))
            {
                moduleRech = m;
                break;
            }
        }

        if (moduleRech != null){
            this.modules.remove(module);
        }else {
            System.out.println("*********************************************");
            System.out.println("Le module '" + module.getNomMod() + "' à deja été suprimer");
            System.out.println("*********************************************");
        }
    }

    public void afficher() {
        this.afficherSansModule();
        System.out.println("________Module de l'étudiant_______");
        this.modules.forEach(m -> {
            m.afficher();
        });
        System.out.println("______________________________________");
    }

    public void afficherSansModule() {
        System.out.println("\nNuméro : "+this.numEtu);
        System.out.println("Nom : "+this.nom);
        System.out.println("Prenom : "+this.prenom);
        System.out.println("Classe : "+this.classe);
    }
}
