package com.mycompany.gestionetudiants.dao;

import com.mycompany.gestionetudiants.model.Etudiant;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EtudiantDAO {

    public boolean ajouter(Etudiant e) {
        String sql = "INSERT INTO etudiant (nom, prenom, classe, cin) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConnexionBD.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, e.getNom());
            stmt.setString(2, e.getPrenom());
            stmt.setString(3, e.getClasse());
            stmt.setString(4, e.getCin());

            stmt.executeUpdate();
            return true;

        } catch (SQLException ex) {
            System.out.println("Erreur lors de l'ajout : " + ex.getMessage());
            return false;
        }
    }

    public List<Etudiant> lister() {
        List<Etudiant> liste = new ArrayList<>();
        String sql = "SELECT * FROM etudiant";
        try (Connection conn = ConnexionBD.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String classe = rs.getString("classe");
                String cin = rs.getString("cin");

                Etudiant etudiant = new Etudiant(id, nom, prenom, classe, cin);
                liste.add(etudiant);
            }

        } catch (SQLException ex) {
            System.out.println("Erreur lors de la lecture : " + ex.getMessage());
        }

        return liste;

    }

    public boolean supprimer(int id) {
        String sql = "delete from etudiant where id=?";
        try (Connection conn = ConnexionBD.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int lignesAffectees = stmt.executeUpdate();

            return lignesAffectees > 0;

        } catch (SQLException ex) {
            System.out.println("Erreur lors de suppression : " + ex.getMessage());
            return false;
        }
    }
    
    public boolean modifier(Etudiant e) {
        String sql = "UPDATE etudiant SET nom = ?, prenom = ?, classe = ?, cin = ? WHERE id = ?";
        try (Connection conn = ConnexionBD.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, e.getNom());
            stmt.setString(2, e.getPrenom());
            stmt.setString(3, e.getClasse());
            stmt.setString(4, e.getCin());
            stmt.setInt(5, e.getId());
            
            int lignesAffectees = stmt.executeUpdate();

            return lignesAffectees > 0;

        } catch (SQLException ex) {
            System.out.println("Erreur lors de suppression : " + ex.getMessage());
            return false;
        }
    }
    

}
