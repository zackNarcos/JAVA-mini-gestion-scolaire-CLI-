package domaine;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Enseignant implements Serializable {

    protected int numero;
    protected String nom;
    protected String prenom;
    protected String grade;
    protected String specialite;
    private ArrayList<Module> modules;

    public Enseignant() {
        this.modules = new ArrayList<Module>();
    }

    public Enseignant( int numero, String nom, String prenom, String specialite) {
        this.numero = numero;
        this.nom = nom;
        this.prenom = prenom;
        this.specialite = specialite;
        this.modules = new ArrayList<Module>();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int inc) {
        this.numero = inc;
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
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
            System.out.println("Le module '" + module.getNomMod() + "' est present dans la liste");
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
            System.out.println("Le module '" + module.getNomMod() + "' est introuvable dans la liste");
        }
    }

    public void afficher() {
        System.out.println("Numéro : "+this.numero);
        System.out.println("Nom : "+this.nom);
        System.out.println("Prenom : "+this.prenom);
        System.out.println("Spécialité : "+this.specialite);
        System.out.println("Grade : "+this.grade);
        System.out.println("________Module de l'enseignant_______");
        this.modules.forEach(m -> {
            m.afficher();
            System.out.println("\n");
        });
        System.out.println("______________________________________");

    }

    public void afficherModules() {
        System.out.println("________Module de l'enseignant_______");
        this.modules.forEach(Module::afficher);
        System.out.println("______________________________________");

    }
}
