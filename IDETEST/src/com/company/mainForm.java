package com.company;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Properties;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static com.company.BuildTableModel.buildTableModel;



public class mainForm extends JFrame{
    public JButton button1;
    JTable table1;
    public JPanel Panel;
    JScrollPane TScroll;


    public mainForm() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null, "arrived");
                Statement stmt = null;
                ResultSet rs = null;
                String username = "user=LIAMNEHREN";
                String password = "password=Rubilacxe1";
                String query = "SELECT * FROM testschema.testtable";
                String url = "jdbc:mysql://localhost:3306/mysql?";
                Connection conn = null;
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                     conn = DriverManager.getConnection(url + username + "&"+ password);
                } catch (SQLException | ClassNotFoundException e) {
                    JOptionPane.showMessageDialog(null, "connection");
                    e.printStackTrace();
                }



                try {
                    stmt = conn.createStatement();
                    rs = stmt.executeQuery(query);
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "1");
                    e.printStackTrace();
                }
                try {
                    table1 = new JTable(buildTableModel(rs));
                    JOptionPane.showMessageDialog(null, "Done");
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "2");
                    e.printStackTrace();

                }
            }
        });
    }


}
