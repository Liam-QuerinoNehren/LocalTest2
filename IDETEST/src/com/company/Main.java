package com.company;
import javax.swing.JOptionPane;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import static com.company.BuildTableModel.buildTableModel;


public class Main {
        static JButton button1;
        static JTable table1;
        static JFrame frame = new JFrame("JTable Test");
static int initial = 0;
        static DefaultTableModel model = new DefaultTableModel();
        public static void tableFiller()
        {
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
                        table1 = new JTable();
                	model = new DefaultTableModel();
                        table1 = new JTable(model);
                        model.addColumn("ID");
                        model.addColumn("LastName");
                        model.addColumn("Name");
                        while (rs.next()) {
                                String id = rs.getString("idtt");
                                String lastName = rs.getString("lastnamett");
                                String name = rs.getString("namett");
                                model.addRow(new Object[]{id, lastName, name});
                                System.out.println(query + " " +id + ": " + lastName + ", " + name);
                        }



                        table1 = new JTable(model);
                        refresh();
                        JOptionPane.showMessageDialog(null, "Done");
                } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "2");
                        e.printStackTrace();

                }
        }
public static void refresh(){
                if (initial==1){
                        frame.setVisible(false);
                }
        JPanel Panel1 = new JPanel();
        table1 = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table1);
        table1.setFillsViewportHeight(true);
        Panel1.add(scrollPane, BorderLayout.CENTER);
        button1 = new JButton();
        Panel1.add(button1, BorderLayout.LINE_END);


        frame = new JFrame("JTable Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(Panel1);
        frame.pack();
        frame.setVisible(true);
if (initial == 0) {initial = 1;}
}
    public static void main(String[] args) throws SQLException {
        JOptionPane.showMessageDialog(null, "start");
mainForm form = new mainForm();

                tableFiller();



            button1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                            tableFiller();
                    }
            });

    }
        public void mainForm(){

        }
}
