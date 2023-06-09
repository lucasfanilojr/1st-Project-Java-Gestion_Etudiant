package menu;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author WINDOWS
 */
public class professeur extends javax.swing.JFrame {

    /**
     * Creates new form professeur
     */
    public professeur() {
        initComponents();
        connectBase();
        matriculeProfesseur();
        codematiere();
        listesP();
        listeC();
    }
    
    Connection con;
    PreparedStatement pst;
    ResultSet resultat;
            
    public void connectBase(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/gestionuniversite","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(professeur.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(professeur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void matriculeProfesseur(){
        try {
            pst = con.prepareStatement("select matricule from professeur");
            resultat = pst.executeQuery();
            matricule.removeAllItems();
            
            while(resultat.next()){
                matricule.addItem(resultat.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(professeur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void codematiere(){
        try {
            pst = con.prepareStatement("select codeC from cours");
            resultat = pst.executeQuery();
            champMatiere.removeAllItems();
            
            while(resultat.next()){
                champMatiere.addItem(resultat.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(professeur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void listesP(){
        String []etudiant = {"matricule","nom","prenom","telephone","adresse","code de cours"};
        String []afficher = new String[7];
        DefaultTableModel model = new DefaultTableModel(null,etudiant);
        try {
            pst = con.prepareStatement("select *from professeur");
            resultat = pst.executeQuery();
            while (resultat.next()) {                
                afficher[0]=resultat.getString("matricule");                
                afficher[1]=resultat.getString("nom");
                afficher[2]=resultat.getString("prenom");
                afficher[3]=resultat.getString("telephone");
                afficher[4]=resultat.getString("adresse");
                afficher[5]=resultat.getString("codeC");
                model.addRow(afficher);
            }
            listeprof.setModel(model);
        } catch (SQLException e) {
            
        }
    }
    
    public void listeC(){
        String []etudiant = {"code de matiere","nom","coefficient"};
        String []afficher = new String[7];
        DefaultTableModel model = new DefaultTableModel(null,etudiant);
        try {
            pst = con.prepareStatement("select *from cours");
            resultat = pst.executeQuery();
            while (resultat.next()) {                
                afficher[0]=resultat.getString("codeC");                
                afficher[1]=resultat.getString("nom");
                afficher[2]=resultat.getString("coefficient");
                model.addRow(afficher);
            }
            listecours.setModel(model);
        } catch (SQLException e) {
            
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        champNom = new javax.swing.JTextField();
        champPrenom = new javax.swing.JTextField();
        champAdresse = new javax.swing.JTextField();
        champTelephone = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        ajouterProf = new javax.swing.JButton();
        modifierProf = new javax.swing.JButton();
        supprimerProf = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        matricule = new javax.swing.JComboBox<>();
        recherche = new javax.swing.JButton();
        vider = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        champMatiere = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listeprof = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        listecours = new javax.swing.JTable();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Java Projet Final Lucas 2404/20");
        setBackground(new java.awt.Color(51, 51, 51));

        jPanel1.setBackground(new java.awt.Color(250, 250, 250));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Les professeurs de l'universite"));
        jPanel1.setToolTipText("");

        jLabel2.setText("Nom");

        jLabel3.setText("Prenom");

        jLabel4.setText("Adresse");

        jLabel5.setText("Telephone");

        jLabel6.setText("Code Matiere");

        champTelephone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                champTelephoneActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        ajouterProf.setBackground(new java.awt.Color(0, 153, 102));
        ajouterProf.setForeground(new java.awt.Color(255, 255, 255));
        ajouterProf.setText("AJOUTER UN PROFESEUR");
        ajouterProf.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ajouterProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterProfActionPerformed(evt);
            }
        });

        modifierProf.setBackground(new java.awt.Color(255, 255, 0));
        modifierProf.setText("MODIFIER LE PROFESSEUR");
        modifierProf.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        modifierProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifierProfActionPerformed(evt);
            }
        });

        supprimerProf.setBackground(new java.awt.Color(153, 0, 0));
        supprimerProf.setForeground(new java.awt.Color(255, 255, 255));
        supprimerProf.setText("SUPPRIMER LE PROFESSEUR");
        supprimerProf.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        supprimerProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimerProfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ajouterProf, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(supprimerProf, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(modifierProf, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(ajouterProf, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(modifierProf, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(supprimerProf, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        jLabel7.setText("Matricule du Professeur");

        recherche.setBackground(new java.awt.Color(0, 0, 0));
        recherche.setForeground(new java.awt.Color(255, 255, 255));
        recherche.setText("RECHERCHE");
        recherche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rechercheActionPerformed(evt);
            }
        });

        vider.setBackground(new java.awt.Color(0, 0, 0));
        vider.setForeground(new java.awt.Color(255, 255, 255));
        vider.setText("VIDER LES CHAMPS");
        vider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viderActionPerformed(evt);
            }
        });

        jButton1.setText("RETOUR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(vider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(30, 30, 30))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(16, 16, 16)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(champMatiere, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(champTelephone)
                            .addComponent(champNom, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(champPrenom)
                            .addComponent(champAdresse))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(matricule, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(recherche)))
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(champNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(matricule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(recherche))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(champPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(champAdresse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(champTelephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(champMatiere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(vider, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Institut Superieur En Informatique Professeur");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(21, 21, 21))
        );

        listeprof.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(listeprof);

        listecours.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(listecours);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(155, 155, 155))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void champTelephoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_champTelephoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_champTelephoneActionPerformed

    private void supprimerProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerProfActionPerformed
        try {
            String matr = matricule.getSelectedItem().toString();
            pst = con.prepareStatement("delete from professeur where matricule=? ");
            pst.setString(1, matr);
            int k = pst.executeUpdate();
            if (k==1) {
                JOptionPane.showMessageDialog(this, "le professeur est supprimer avec success");
                champNom.setText("");
                champPrenom.setText("");
                champAdresse.setText("");
                champTelephone.setText("");
                champNom.requestFocus();
                matriculeProfesseur();
                listesP();
                listeC();
            }else{
                JOptionPane.showMessageDialog(this, "une erreur est survenue pendant la suppresion");
            }
        } catch (SQLException ex) {
            Logger.getLogger(professeur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_supprimerProfActionPerformed

    private void ajouterProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterProfActionPerformed
        
        try {
            String nom = champNom.getText();
            String prenom = champPrenom.getText();
            String adresse = champAdresse.getText();
            String telephone = champTelephone.getText();
            String codematiere = champMatiere.getSelectedItem().toString();
            
            pst = con.prepareStatement("insert into professeur (nom,prenom,telephone,adresse,codeC) values(?,?,?,?,?)  ");
            pst.setString(1, nom);            
            pst.setString(2, prenom);            
            pst.setString(3, telephone);
            pst.setString(4, adresse);
            pst.setString(5, codematiere);
            int k = pst.executeUpdate();
            if (k==1) {
                JOptionPane.showMessageDialog(this, "le professeur est ajouter avec success");
                champNom.setText("");
                champPrenom.setText("");                
                champAdresse.setText("");                
                champTelephone.setText(""); 
                champNom.requestFocus();
                matriculeProfesseur();
                listesP();
                listeC();
            }else{
                JOptionPane.showMessageDialog(this, "une erreur est survenue pendant l'insertion");
            }

        } catch (SQLException ex) {
            Logger.getLogger(professeur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ajouterProfActionPerformed

    private void rechercheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rechercheActionPerformed
        try {
            String matriculeP = matricule.getSelectedItem().toString();
            pst = con.prepareStatement("select * from professeur where matricule=? ");
            pst.setString(1, matriculeP);
            resultat = pst.executeQuery();
            if (resultat.next()==true) {
                champNom.setText(resultat.getString(2));
                champPrenom.setText(resultat.getString(3));
                champAdresse.setText(resultat.getString(5));
                champTelephone.setText(resultat.getString(4));
                champMatiere.setSelectedItem(resultat.getString(6));
            } else {
            }
        } catch (SQLException ex) {
            Logger.getLogger(professeur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rechercheActionPerformed

    private void viderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viderActionPerformed
        champNom.setText("");
        champPrenom.setText("");                
        champAdresse.setText("");                
        champTelephone.setText("");
        champNom.requestFocus();
        matriculeProfesseur();
    }//GEN-LAST:event_viderActionPerformed

    private void modifierProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifierProfActionPerformed
           String matricules = matricule.getSelectedItem().toString();
           try {
            String nom = champNom.getText();
            String prenom = champPrenom.getText();
            String adresse = champAdresse.getText();
            String telephone = champTelephone.getText();
            String codematiere = champMatiere.getSelectedItem().toString();
            
            pst = con.prepareStatement("update professeur set nom=? , prenom=? ,telephone=? , adresse=? , codeC=? where matricule=? ");
            pst.setString(1, nom);            
            pst.setString(2, prenom);            
            pst.setString(3, telephone);
            pst.setString(4, adresse);
            pst.setString(5, codematiere);
            pst.setString(6, matricules);
            int k = pst.executeUpdate();
            if (k==1) {
                JOptionPane.showMessageDialog(this, "le professeur est modifier avec success");
                champNom.setText("");
                champPrenom.setText("");                
                champAdresse.setText("");                
                champTelephone.setText(""); 
                champNom.requestFocus();
                matriculeProfesseur();
                listesP();
                listeC();
            }else{
                JOptionPane.showMessageDialog(this, "une erreur est survenue pendant la modification");
            }

        } catch (SQLException ex) {
            Logger.getLogger(professeur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_modifierProfActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       professeur.super.dispose();
       accueil aff = new accueil();
       aff.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(professeur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(professeur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(professeur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(professeur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new professeur().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ajouterProf;
    private javax.swing.JTextField champAdresse;
    private javax.swing.JComboBox<String> champMatiere;
    private javax.swing.JTextField champNom;
    private javax.swing.JTextField champPrenom;
    private javax.swing.JTextField champTelephone;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable listecours;
    private javax.swing.JTable listeprof;
    private javax.swing.JComboBox<String> matricule;
    private javax.swing.JButton modifierProf;
    private javax.swing.JButton recherche;
    private javax.swing.JButton supprimerProf;
    private javax.swing.JButton vider;
    // End of variables declaration//GEN-END:variables
}
