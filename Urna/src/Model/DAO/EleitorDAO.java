/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Connection.ConnectionFactory;
import Model.bean.Eleitor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Bryan's PC
 */
public class EleitorDAO {
     
    public void create(Eleitor e) {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO eleitor (nome,cpf,cep,rua,bairro,numero)VALUES(?,?,?,?,?,?)");
            stmt.setString(1,e.getNomeEleitor());
            stmt.setString(2,e.getCpf());
            stmt.setString(3,e.getCep());
            stmt.setString(4,e.getRua());
            stmt.setString(5,e.getBairro());
            stmt.setString(6,e.getNumero());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
}
