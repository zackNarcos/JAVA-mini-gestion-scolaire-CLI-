package metier;

import dao.ModuleDAO;
import domaine.Module;

public class ModuleService {
    private ModuleDAO moduleDAO = new ModuleDAO();

    public ModuleService() {
        this.moduleDAO.getModules().add(new Module(1, "JAVA", 30));
        this.moduleDAO.getModules().add(new Module(2, "Anglais", 80));
        this.moduleDAO.getModules().add(new Module(3, "Maths", 20));
    }

    public ModuleService(ModuleDAO moduleDAO) {
        this.moduleDAO = moduleDAO;
    }

    public void createModule(Module module){
        this.moduleDAO.creatModule(module);
    }
    public void deleteModule(Module module){
        this.moduleDAO.deleteModule(module);
    }
    public Module rechercherModuleByNum(int num){
        return this.moduleDAO.rechercherModuleByNum(num);
    }
    public void afficherModule() {
        System.out.println("\n____________________");
        System.out.println("______Modules_______");
        System.out.println("____________________");
        this.moduleDAO.getModules().forEach(m -> {
            m.afficher();
            System.out.println("____________________");
        });
    }
    public void afficherModuleDonnee(int numModule) {
        Module moduleRechercher = rechercherModuleByNum(numModule);
        if (moduleRechercher != null){
            moduleRechercher.afficherEtudiant();
        }else {
            System.out.println("\n\033[31m ********************************************* \033[0m");
            System.out.println("\033[31m Le module recherché est inexistant \033[0m");
            System.out.println("\033[31m ********************************************* \033[0m");
        }
    }


}
