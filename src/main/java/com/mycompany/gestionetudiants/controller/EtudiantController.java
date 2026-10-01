package com.mycompany.gestionetudiants.controller;

import com.mycompany.gestionetudiants.dao.EtudiantDAO;
import com.mycompany.gestionetudiants.model.Etudiant;
import java.util.List;

public class EtudiantController {

    private EtudiantDAO etudiantDAO = new EtudiantDAO();

    public EtudiantController() {}

    public boolean ajouterEtudiant(Etudiant e) {
        if (e.getCin() != null && !e.getCin().isEmpty()) {
            etudiantDAO.ajouter(e);
            return true;
        }
        return false;
    }

    public List<Etudiant> listerEtudiants() {
        return etudiantDAO.lister();
    }

    public boolean supprimerEtudiant(int id) {
        return etudiantDAO.supprimer(id);
    }

    public boolean modifierEtudiant(Etudiant etudiantModifie) {

        return etudiantDAO.modifier(etudiantModifie);
    }
}
