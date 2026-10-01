package com.mycompany.gestionetudiants.view;

import com.mycompany.gestionetudiants.controller.EtudiantController;
import com.mycompany.gestionetudiants.model.Etudiant;
import java.util.List;

import java.util.Scanner;

public class EtudiantView {

    private EtudiantController controller = new EtudiantController();

    public void afficherMenu() {
        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            System.out.println("=== Menu Gestion Étudiants ===");
            System.out.println("1. Ajouter un étudiant");
            System.out.println("2. Lister les étudiants");
            System.out.println("3. Modifier un étudiant");
            System.out.println("4. Supprimer un étudiant");
            System.out.println("5. Quitter");
            System.out.print("Ton choix : ");
            choix = scanner.nextInt();

            switch (choix) {
                case 1:

                    System.out.print("Nom : ");
                    String nom = scanner.next();
                    System.out.print("Prénom : ");
                    String prenom = scanner.next();
                    System.out.print("Classe : ");
                    String classe = scanner.next();
                    System.out.print("CIN : ");
                    String cin = scanner.next();

                    Etudiant nouvel = new Etudiant(nom, prenom, classe, cin);
                    boolean ok = controller.ajouterEtudiant(nouvel);

                    if (ok) {
                        System.out.println("Étudiant ajouté avec succès.");
                    } else {
                        System.out.println("Échec : CIN invalide.");
                    }
                    break;

                case 2:
                    List<Etudiant> liste = controller.listerEtudiants();
                    if (liste.isEmpty()) {
                        System.out.println("Aucun étudiant enregistré.");
                    } else {
                        for (Etudiant e : liste) {
                            System.out.println(e.getId() + " - " + e.getNom() + " "
                                    + e.getPrenom() + " - Classe: " + e.getClasse()
                                    + " - CIN: " + e.getCin());
                        }
                    }
                    break;

                case 3:
                    System.out.println("l'etudiant a modifier ");
                    System.out.print("ID : ");
                    int m = scanner.nextInt();
                    System.out.print("Nom : ");
                    nom = scanner.next();
                    System.out.print("Prénom : ");
                    prenom = scanner.next();
                    System.out.print("Classe : ");
                    classe = scanner.next();
                    System.out.print("CIN : ");
                    cin = scanner.next();
                    Etudiant etu = new Etudiant(m, nom, prenom, classe, cin);
                    boolean yes = controller.modifierEtudiant(etu);
                    if (yes) {
                        System.out.println("Étudiant modifié avec succès.");
                    } else {
                        System.out.println("Échec : etudiant introuvable");
                    }

                    break;
                case 4:
                    System.out.print("ID : ");
                    int i = scanner.nextInt();
                    boolean o = controller.supprimerEtudiant(i);
                    if (o) {
                        System.out.println("Étudiant supprimé avec succès.");
                    } else {
                        System.out.println("Échec");
                    }
                    break;

                case 5:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide.");
            }

        } while (choix != 5);
    }

}
