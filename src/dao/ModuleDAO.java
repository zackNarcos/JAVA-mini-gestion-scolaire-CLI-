package dao;

import domaine.Module;

import java.util.ArrayList;

public class ModuleDAO {
    private ArrayList<Module> modules = new ArrayList<Module>();
    private static int incModule = 3;
    public ArrayList<Module> getModules() {
        return modules;
    }


    public void creatModule(Module module){
        Module moduleRechercher = rechercherModule(module.getNomMod());
        if (moduleRechercher != null){
            System.out.println("\n\033[31m ********************************************* \033[0m");
            System.out.println("\033[31m Le module '" + module.getNomMod() + "' est deja exitant \033[0m");
            System.out.println("\033[31m ********************************************* \033[0m");
        }else {
            incModule++;
            module.setNumMod(incModule);
            modules.add(module);
        }
    }
    public void deleteModule(Module module){
            modules.remove(module);
    }


    public Module rechercherModule(String nomMod) {
        Module module = null;
        for (Module m : this.getModules()) {
            if (m.getNomMod().equalsIgnoreCase((nomMod)))
            {
                module = m;
                break;
            }
        }
        return module;
    }
    public Module rechercherModuleByNum(int numMod) {
        Module module = null;
        for (Module m : this.getModules()) {
            if (m.getNumMod() == numMod)
            {
                module = m;
                break;
            }
        }
        return module;
    }
}
