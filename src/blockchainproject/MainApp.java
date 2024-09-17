package blockchainproject;
import java.awt.event.ComponentEvent;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.*;
import javax.swing.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.table.*;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.ParseException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import java.security.InvalidKeyException;
import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;

public class MainApp extends javax.swing.JFrame {
    
    static String dbName = "blockchainproject";
    static Connection c = null;
    static PreparedStatement ps;
    static ResultSet rs=null;
    static String URL = "jdbc:mysql://localhost:3306/" + dbName;
  
    static String username1 = "root";
    static String password1 = "";
    
    private int bit=1500;
    private int ripple=1200;
    private int eth=1000;
    
    String retrievedName = "";
    int retrievedAmount =0;
    float retrievedbit = 0;
    float retrievedripple = 0;
    float retrievedetherium = 0;
    int retrievedTransaction =0;
    String retrievedPassword="";
    String RecieverName="";
    String chainname="";
    static String chainname1 = "";
    String SignupFullname="";
    
    private boolean isclick=false;
    

    private boolean clicked=false;
    private long lastClickTime=0;
    
    private static float changingBit;
    private static float changingRipple;
    private static float changingetherium;
    private static long lastChangeTime;
    
    public MainApp() {
        initComponents();
        
   jTabbedPane1.setUI(new javax.swing.plaf.basic.BasicTabbedPaneUI() {
    @Override
    protected void paintTabArea(Graphics g, int tabPlacement, int selectedIndex) {
        // Do nothing to prevent the tab headers from being painted
    }

    @Override
    protected int calculateTabAreaHeight(int tabPlacement, int runCount, int maxTabHeight) {
        // Set the height of the tab area to 0 to hide the tab header and make it unclickable
        return 0;
    }
});

        this.addComponentListener(new ComponentAdapter(){
        @Override
         public void componentResized(ComponentEvent e){
           
            JTableHeader tableHeader = jTable2.getTableHeader();
            tableHeader.setBackground(new Color(15, 25, 33)); // Set background using RGB values
            tableHeader.setForeground(new Color(57,225,20));
             
            JTableHeader tableHeader2 = jTable1.getTableHeader();
            tableHeader2.setBackground(new Color(15, 25, 33)); // Set background using RGB values
            tableHeader2.setForeground(new Color(57,225,20));
            
            JTableHeader tableHeader3 = jTable3.getTableHeader();
            tableHeader3.setBackground(new Color(15, 25, 33)); // Set background using RGB values
            tableHeader3.setForeground(new Color(57,225,20));
            
            ImageIcon originalIcon = new ImageIcon(getClass().getResource("/blockchainproject/logo.jpg"));
            Image originalImage = originalIcon.getImage();
            
            
            ImageIcon originalIcon2 = new ImageIcon(getClass().getResource("/blockchainproject/COIN.PNG"));
            Image originalImage2 = originalIcon2.getImage();
             int frameWidth=getWidth();
             
             if(frameWidth<=800 ){
                jButton1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12));
                jButton36.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12));
                jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14));
                jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 10));
                jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 10));
                jLabel4.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 10));
                jLabel7.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14));
                jLabel8.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 10));
                jLabel9.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 10));
                jLabel10.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 10));
                jLabel11.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 10));
                
                Image resizedImage = originalImage.getScaledInstance(jPanel13.getWidth(),jPanel13.getHeight(), Image.SCALE_SMOOTH);
                jLabel6.setIcon(new ImageIcon(resizedImage));
                
                // Responsiveness for Rate with change
                
                jLabel89.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 10));
                jLabel91.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 10));
                jLabel93.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 10));
                jButton13.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 11)); // NOI18N
                jButton14.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 11)); // NOI18N
                
                
                // Responsive ness for public ledger
                jPanel23.setPreferredSize(new java.awt.Dimension(20, 669));
                jButton4.setFont(new java.awt.Font("Segoe UI", 1, 11));
                jLabel12.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
                
                

                //responsiveness for login page
                jLabel20.setText("SignUp");
                jPanel51.remove(jLabel19);
                jButton6.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 11)); // NOI18N
                jButton7.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 9)); // NOI18N
                
                // responsiveness for start new chain
                jLabel25.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
                jLabel25.setText("Joining MnM block chain");
                jLabel21.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24));
                jPanel62.setPreferredSize(new java.awt.Dimension(20, 669));
                jPanel65.setPreferredSize(new java.awt.Dimension(50, 669));
                jPanel66.setPreferredSize(new java.awt.Dimension(100, 669));
                
                Image resizedImage2 = originalImage.getScaledInstance(jPanel84.getWidth(),jPanel84.getHeight(), Image.SCALE_SMOOTH);
                jLabel22.setIcon(new ImageIcon(resizedImage2));
                
                // responsiveness for start block chain
                jButton37.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 9)); // NOI18N
                jButton37.setText("New");
                jButton38.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 9));
                jButton38.setMargin(new Insets(0, 0, 0, 0));

                jButton38.setText("Existing");
                jButton8.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 9)); // NOI18N
                jLabel27.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N

                //responsiveness for Join Existing chain
                jLabel31.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
                jPanel129.setPreferredSize(new java.awt.Dimension(50, 669));
                jPanel128.setPreferredSize(new java.awt.Dimension(50, 669));
                jLabel30.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
                jPanel122.setPreferredSize(new java.awt.Dimension(20, 669));
                
                //responsivenes for buy Coin
                jPanel140.setPreferredSize(new java.awt.Dimension(20, 669));
                jPanel143.setPreferredSize(new java.awt.Dimension(40, 669));
                jPanel144.setPreferredSize(new java.awt.Dimension(40, 669));
                jButton18.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 11)); // NOI18N
                jButton39.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 11)); // NOI18N
                jLabel34.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18Nv
                jLabel36.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18Nv
                jLabel38.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18Nv
                jLabel40.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18Nv
                jLabel37.setText("_____________");
                jLabel39.setText("_____________");
                jLabel41.setText("_____________");
                
                Image resizedImage3 = originalImage2.getScaledInstance(jPanel149.getWidth(),jPanel149.getHeight(), Image.SCALE_SMOOTH);
                jLabel35.setIcon(new ImageIcon(resizedImage3));
                
                //Responsiveness for Math problem
                jPanel163.setPreferredSize(new java.awt.Dimension(20, 669));
                jPanel176.setPreferredSize(new java.awt.Dimension(40, 669));
                jPanel177.setPreferredSize(new java.awt.Dimension(40, 669));
                jLabel46.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18Nv
                jLabel47.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18Nv
                
                
                //Responsiveness for Choose block chain
                jPanel184.setPreferredSize(new java.awt.Dimension(20, 669));
                jPanel187.setPreferredSize(new java.awt.Dimension(40, 669));
                jPanel188.setPreferredSize(new java.awt.Dimension(40, 669));
                jLabel44.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18Nv
                jPanel202.remove(jPanel205);
                jButton21.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 11   )); // NOI18N
                jButton22.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 11   )); // NOI18N
                
                Image resizedImage4 = originalImage.getScaledInstance(jPanel194.getWidth(),jPanel194.getHeight(), Image.SCALE_SMOOTH);
                jLabel45.setIcon(new ImageIcon(resizedImage4));
                
                //Reponsiveness for Signup page
                jPanel207.setPreferredSize(new java.awt.Dimension(20, 669));
                jPanel210.setPreferredSize(new java.awt.Dimension(40, 669));
                jPanel211.setPreferredSize(new java.awt.Dimension(40, 669));
                jLabel51.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18Nv
                
                Image resizedImage5 = originalImage.getScaledInstance(jPanel217.getWidth(),jPanel217.getHeight(), Image.SCALE_SMOOTH);
                jLabel52.setIcon(new ImageIcon(resizedImage5));
                
                //Responsiveness for Transaction
                jPanel236.setPreferredSize(new java.awt.Dimension(20, 669));
                jPanel239.setPreferredSize(new java.awt.Dimension(40, 669));
                jPanel240.setPreferredSize(new java.awt.Dimension(40, 669));
                jLabel58.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18Nv
                jButton26.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 11)); // NOI18N
                jButton40.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 11)); // NOI18N
                
                
                //Responsiveness for sell coin
                jPanel261.setPreferredSize(new java.awt.Dimension(20, 669));
                jPanel264.setPreferredSize(new java.awt.Dimension(40, 669));
                jPanel265.setPreferredSize(new java.awt.Dimension(40, 669));
                jLabel63.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18Nv
                jLabel65.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 11)); // NOI18Nv
                jLabel66.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 11)); // NOI18Nv
                jLabel67.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 11)); // NOI18Nv
                jButton27.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 11)); // NOI18N
                jButton28.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 11)); // NOI18N
                
                Image resizedImage6 = originalImage2.getScaledInstance(jPanel271.getWidth(),jPanel271.getHeight(), Image.SCALE_SMOOTH);
                jLabel64.setIcon(new ImageIcon(resizedImage6));
                
                //Responsiveness for User profile
                jPanel286.setPreferredSize(new java.awt.Dimension(20, 669));
                jPanel290.setPreferredSize(new java.awt.Dimension(100, 669));
                jButton2.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 11)); // NOI18N
                jButton11.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 11)); // NOI18N
                jPanel289.setPreferredSize(new java.awt.Dimension(80, 669));
                jButton2.setMargin(new Insets(2, 2, 3, 2));
                jButton11.setMargin(new Insets(2, 2, 3, 2));
                
                
                jLabel68.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18Nv
                jLabel72.setText("_______________"); // NOI18Nv
                jLabel73.setText("_______________");
                jLabel75.setText("_______________");
                jButton34.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 11)); // NOI18N
                jButton35.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 11)); // NOI18N
                
                jButton29.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 11)); // NOI18N
                jButton30.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 11)); // NOI18N
                jButton31.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 11)); // NOI18N
                jButton32.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 11)); // NOI18N
                jButton33.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 11)); // NOI18N

                
                jButton29.setMargin(new Insets(2, 2, 3, 2));
                jButton30.setMargin(new Insets(2, 2, 3, 2));
                jButton31.setMargin(new Insets(2, 2, 3, 2));
                jButton32.setMargin(new Insets(2, 2, 3, 2));
                jButton33.setMargin(new Insets(2, 2, 3, 2));
                
                Image resizedImage7 = originalImage.getScaledInstance(jPanel297.getWidth(),jPanel297.getHeight(), Image.SCALE_SMOOTH);
                jLabel69.setIcon(new ImageIcon(resizedImage7));
             }
                
            else{
                jButton1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18));
                jButton36.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18));
                
                jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blockchainproject/logo.jpg"))); // NOI18N
                jPanel13.add(jLabel6, java.awt.BorderLayout.CENTER);
            

                jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
                jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12));
                jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12));
                jLabel4.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12));
                jLabel7.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
                jLabel8.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12));
                jLabel9.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12));
                jLabel10.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12));
                jLabel11.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12));
                // Responsive for public ledger
                jPanel23.setPreferredSize(new java.awt.Dimension(40, 669));
                jLabel12.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 36));
                jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14));
                
                //Responsiveness for Login page
                jLabel20.setText("Don't have an account?");
                jPanel51.add(jLabel19);
                jButton6.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
                jButton7.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
                 
                //Responsiveness for Starting new chain
                jLabel25.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 17)); // NOI18N
                jLabel25.setText("Joining MnM block chain platform");
                jLabel21.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 36));
                jPanel62.setPreferredSize(new java.awt.Dimension(40, 669));
                jPanel65.setPreferredSize(new java.awt.Dimension(100, 669));
                jPanel66.setPreferredSize(new java.awt.Dimension(100, 669));
                
                jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blockchainproject/logo.jpg"))); // NOI18N
                jPanel84.add(jLabel22, java.awt.BorderLayout.CENTER);
                
                // Responsiveness for Rate with change
                
                jLabel89.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14));
                jLabel91.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14));
                jLabel93.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14));
                jButton13.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
                jButton14.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N

                // responsiveness for start block chain
                jButton37.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
                jButton37.setText("New Chain");
                jButton38.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
                jButton38.setText("Existing Chain");
                jButton38.setMargin(new Insets(2, 14, 3, 14));
                jButton8.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
                jLabel27.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 36)); // NOI18N

                //responsiveness for Join Existing chain
                jLabel31.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 36)); // NOI18N
                jPanel129.setPreferredSize(new java.awt.Dimension(100, 669));
                jPanel128.setPreferredSize(new java.awt.Dimension(100, 669));
                jLabel30.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 36));
                jPanel122.setPreferredSize(new java.awt.Dimension(40, 669));
                
                
                //responsivenes for buy Coin
                jPanel140.setPreferredSize(new java.awt.Dimension(40, 669));
                jPanel143.setPreferredSize(new java.awt.Dimension(100, 669));
                jPanel144.setPreferredSize(new java.awt.Dimension(100, 669));
                jButton18.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
                jButton39.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
                jLabel34.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 36)); // NOI18Nv
                jLabel36.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18Nv
                jLabel38.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18Nv
                jLabel40.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18Nv
                jLabel37.setText("____________________");
                jLabel39.setText("____________________");
                jLabel41.setText("____________________");
                
                jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blockchainproject/COIN.PNG"))); // NOI18N
                jPanel149.add(jLabel35, java.awt.BorderLayout.CENTER);
        
                
                //Responsiveness for Math problem
                jPanel163.setPreferredSize(new java.awt.Dimension(40, 669));
                jPanel176.setPreferredSize(new java.awt.Dimension(100, 669));
                jPanel177.setPreferredSize(new java.awt.Dimension(100, 669));
                jLabel46.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 36)); // NOI18Nv
                jLabel47.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 36)); // NOI18Nv
                
                //Responsiveness for Choose block chain
                jPanel184.setPreferredSize(new java.awt.Dimension(40, 669));
                jPanel187.setPreferredSize(new java.awt.Dimension(100, 669));
                jPanel188.setPreferredSize(new java.awt.Dimension(100, 669));
                jLabel44.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 36)); // NOI18Nv
               // jPanel202.add(jPanel205);
                jButton21.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14   )); // NOI18N
                jButton22.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14   )); // NOI18N
                
                jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blockchainproject/logo.PNG"))); // NOI18N
                jPanel194.add(jLabel45, java.awt.BorderLayout.CENTER);
                
                //Reponivenes for Signup page
                jPanel207.setPreferredSize(new java.awt.Dimension(40, 669));
                jPanel210.setPreferredSize(new java.awt.Dimension(100, 669));
                jPanel211.setPreferredSize(new java.awt.Dimension(100, 669));
                jLabel51.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 36)); // NOI18Nv
                
                jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blockchainproject/logo.jpg"))); // NOI18N
                jPanel217.add(jLabel52, java.awt.BorderLayout.CENTER);
                
                //Responsiveness for Transaction
                jPanel236.setPreferredSize(new java.awt.Dimension(40, 669));
                jPanel239.setPreferredSize(new java.awt.Dimension(100, 669));
                jPanel240.setPreferredSize(new java.awt.Dimension(100, 669));
                jLabel58.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 36)); // NOI18Nv
                
                jButton26.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
                jButton40.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
                
                //Responsiveness for sell coin
                jPanel261.setPreferredSize(new java.awt.Dimension(40, 669));
                jPanel264.setPreferredSize(new java.awt.Dimension(100, 669));
                jPanel265.setPreferredSize(new java.awt.Dimension(100, 669));
                jLabel63.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 36)); // NOI18Nv
                jLabel65.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18Nv
                jLabel66.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18Nv
                jLabel67.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18Nv
                jButton27.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
                jButton28.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
                
                jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blockchainproject/COIN.PNG"))); // NOI18N
                jPanel271.add(jLabel64, java.awt.BorderLayout.CENTER);
                
                //Responsive ness for User profile
                jPanel286.setPreferredSize(new java.awt.Dimension(40, 669));
                jPanel289.setPreferredSize(new java.awt.Dimension(116, 669));

                jLabel68.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 36)); // NOI18Nv

                jPanel290.setPreferredSize(new java.awt.Dimension(150, 669));
                jButton2.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
                jButton11.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
                jPanel289.setPreferredSize(new java.awt.Dimension(80, 669));
                jButton2.setMargin(new Insets(2, 14, 3, 14));
                jButton11.setMargin(new Insets(2, 14, 3, 14));
                
                jLabel68.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 36)); // NOI18Nv
                jLabel72.setText("_______________________"); // NOI18Nv
                jLabel73.setText("_______________________");
                jLabel75.setText("_______________________");
                jButton34.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
                jButton35.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
                
                jButton29.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 11)); // NOI18N
                jButton30.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
                jButton31.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
                jButton32.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
                jButton33.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N

                
                jButton29.setMargin(new Insets(2, 14, 3, 14));
                jButton30.setMargin(new Insets(2, 14, 3, 14));
                jButton31.setMargin(new Insets(2, 14, 3, 14));
                jButton32.setMargin(new Insets(2, 14, 3, 14));
                jButton33.setMargin(new Insets(2, 14, 3, 14));
                
                jLabel69.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel69.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blockchainproject/logo.jpg"))); // NOI18N
                jPanel297.add(jLabel69, java.awt.BorderLayout.CENTER);
                
            }

            jButton1.revalidate();
            jButton1.repaint();
            jButton36.revalidate();
            jButton36.repaint();
        }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jButton36 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel33 = new javax.swing.JPanel();
        jPanel34 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jPanel35 = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jPanel39 = new javax.swing.JPanel();
        jPanel40 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jPanel41 = new javax.swing.JPanel();
        jPanel42 = new javax.swing.JPanel();
        jPanel43 = new javax.swing.JPanel();
        jPanel44 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel105 = new javax.swing.JPanel();
        jPanel112 = new javax.swing.JPanel();
        jPanel116 = new javax.swing.JPanel();
        jPanel38 = new javax.swing.JPanel();
        jPanel45 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel58 = new javax.swing.JPanel();
        jPanel110 = new javax.swing.JPanel();
        jPanel169 = new javax.swing.JPanel();
        jPanel312 = new javax.swing.JPanel();
        jLabel89 = new javax.swing.JLabel();
        jPanel313 = new javax.swing.JPanel();
        jLabel86 = new javax.swing.JLabel();
        jPanel257 = new javax.swing.JPanel();
        jPanel314 = new javax.swing.JPanel();
        jLabel91 = new javax.swing.JLabel();
        jPanel315 = new javax.swing.JPanel();
        jLabel88 = new javax.swing.JLabel();
        jPanel282 = new javax.swing.JPanel();
        jPanel316 = new javax.swing.JPanel();
        jLabel93 = new javax.swing.JLabel();
        jPanel317 = new javax.swing.JPanel();
        jLabel87 = new javax.swing.JLabel();
        jPanel307 = new javax.swing.JPanel();
        jPanel318 = new javax.swing.JPanel();
        jButton13 = new javax.swing.JButton();
        jPanel319 = new javax.swing.JPanel();
        jPanel311 = new javax.swing.JPanel();
        jPanel320 = new javax.swing.JPanel();
        jButton14 = new javax.swing.JButton();
        jPanel321 = new javax.swing.JPanel();
        jPanel120 = new javax.swing.JPanel();
        jPanel322 = new javax.swing.JPanel();
        jPanel323 = new javax.swing.JPanel();
        jPanel324 = new javax.swing.JPanel();
        jPanel325 = new javax.swing.JPanel();
        jPanel327 = new javax.swing.JPanel();
        jButton17 = new javax.swing.JButton();
        jPanel328 = new javax.swing.JPanel();
        jPanel326 = new javax.swing.JPanel();
        jPanel46 = new javax.swing.JPanel();
        jPanel47 = new javax.swing.JPanel();
        jPanel48 = new javax.swing.JPanel();
        jPanel50 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel52 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPanel53 = new javax.swing.JPanel();
        jPanel51 = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel19 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jPanel55 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jPanel56 = new javax.swing.JPanel();
        jPanel57 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jPanel59 = new javax.swing.JPanel();
        jPanel60 = new javax.swing.JPanel();
        jPanel54 = new javax.swing.JPanel();
        jPanel49 = new javax.swing.JPanel();
        jPanel61 = new javax.swing.JPanel();
        jPanel62 = new javax.swing.JPanel();
        jPanel63 = new javax.swing.JPanel();
        jPanel64 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel65 = new javax.swing.JPanel();
        jPanel66 = new javax.swing.JPanel();
        jPanel67 = new javax.swing.JPanel();
        jPanel68 = new javax.swing.JPanel();
        jPanel70 = new javax.swing.JPanel();
        jPanel71 = new javax.swing.JPanel();
        jPanel73 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jPanel74 = new javax.swing.JPanel();
        jPanel75 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jPanel76 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel77 = new javax.swing.JPanel();
        jTextField5 = new javax.swing.JTextField();
        jPanel78 = new javax.swing.JPanel();
        jPanel79 = new javax.swing.JPanel();
        jPanel80 = new javax.swing.JPanel();
        jButton10 = new javax.swing.JButton();
        jPanel81 = new javax.swing.JPanel();
        jPanel83 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jPanel72 = new javax.swing.JPanel();
        jPanel69 = new javax.swing.JPanel();
        jPanel82 = new javax.swing.JPanel();
        jPanel84 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel85 = new javax.swing.JPanel();
        jPanel86 = new javax.swing.JPanel();
        jPanel87 = new javax.swing.JPanel();
        jPanel88 = new javax.swing.JPanel();
        jPanel89 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jPanel90 = new javax.swing.JPanel();
        jPanel91 = new javax.swing.JPanel();
        jPanel92 = new javax.swing.JPanel();
        jPanel93 = new javax.swing.JPanel();
        jPanel95 = new javax.swing.JPanel();
        jPanel97 = new javax.swing.JPanel();
        jPanel98 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jPanel99 = new javax.swing.JPanel();
        jPanel103 = new javax.swing.JPanel();
        jPanel106 = new javax.swing.JPanel();
        jPanel113 = new javax.swing.JPanel();
        jPanel114 = new javax.swing.JPanel();
        jButton37 = new javax.swing.JButton();
        jPanel115 = new javax.swing.JPanel();
        jPanel107 = new javax.swing.JPanel();
        jPanel108 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jPanel109 = new javax.swing.JPanel();
        jPanel111 = new javax.swing.JPanel();
        jPanel94 = new javax.swing.JPanel();
        jPanel96 = new javax.swing.JPanel();
        jPanel100 = new javax.swing.JPanel();
        jPanel101 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jPanel102 = new javax.swing.JPanel();
        jPanel104 = new javax.swing.JPanel();
        jPanel117 = new javax.swing.JPanel();
        jPanel118 = new javax.swing.JPanel();
        jButton38 = new javax.swing.JButton();
        jPanel119 = new javax.swing.JPanel();
        jPanel121 = new javax.swing.JPanel();
        jPanel122 = new javax.swing.JPanel();
        jPanel123 = new javax.swing.JPanel();
        jPanel124 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jPanel128 = new javax.swing.JPanel();
        jPanel129 = new javax.swing.JPanel();
        jPanel130 = new javax.swing.JPanel();
        jPanel131 = new javax.swing.JPanel();
        jPanel125 = new javax.swing.JPanel();
        jPanel126 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jPanel132 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jPanel127 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        jPanel133 = new javax.swing.JPanel();
        jPanel134 = new javax.swing.JPanel();
        jPanel135 = new javax.swing.JPanel();
        jButton16 = new javax.swing.JButton();
        jPanel136 = new javax.swing.JPanel();
        jPanel137 = new javax.swing.JPanel();
        jButton15 = new javax.swing.JButton();
        jPanel138 = new javax.swing.JPanel();
        jPanel139 = new javax.swing.JPanel();
        jPanel140 = new javax.swing.JPanel();
        jPanel141 = new javax.swing.JPanel();
        jPanel142 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jPanel143 = new javax.swing.JPanel();
        jPanel144 = new javax.swing.JPanel();
        jPanel145 = new javax.swing.JPanel();
        jPanel146 = new javax.swing.JPanel();
        jPanel147 = new javax.swing.JPanel();
        jPanel148 = new javax.swing.JPanel();
        jPanel150 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jPanel151 = new javax.swing.JPanel();
        jPanel152 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jPanel153 = new javax.swing.JPanel();
        jPanel154 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jPanel155 = new javax.swing.JPanel();
        jPanel156 = new javax.swing.JPanel();
        jPanel157 = new javax.swing.JPanel();
        jButton18 = new javax.swing.JButton();
        jPanel158 = new javax.swing.JPanel();
        jPanel159 = new javax.swing.JPanel();
        jPanel160 = new javax.swing.JPanel();
        jButton39 = new javax.swing.JButton();
        jPanel161 = new javax.swing.JPanel();
        jPanel149 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jPanel162 = new javax.swing.JPanel();
        jPanel163 = new javax.swing.JPanel();
        jPanel174 = new javax.swing.JPanel();
        jPanel175 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jPanel176 = new javax.swing.JPanel();
        jPanel177 = new javax.swing.JPanel();
        jPanel178 = new javax.swing.JPanel();
        jPanel179 = new javax.swing.JPanel();
        jPanel180 = new javax.swing.JPanel();
        jPanel182 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jPanel183 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jPanel164 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jPanel20 = new javax.swing.JPanel();
        jPanel165 = new javax.swing.JPanel();
        jPanel166 = new javax.swing.JPanel();
        jPanel167 = new javax.swing.JPanel();
        jPanel168 = new javax.swing.JPanel();
        jButton20 = new javax.swing.JButton();
        jPanel170 = new javax.swing.JPanel();
        jPanel171 = new javax.swing.JPanel();
        jButton19 = new javax.swing.JButton();
        jPanel172 = new javax.swing.JPanel();
        jPanel181 = new javax.swing.JPanel();
        jPanel173 = new javax.swing.JPanel();
        jPanel184 = new javax.swing.JPanel();
        jPanel185 = new javax.swing.JPanel();
        jPanel186 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jPanel187 = new javax.swing.JPanel();
        jPanel188 = new javax.swing.JPanel();
        jPanel189 = new javax.swing.JPanel();
        jPanel190 = new javax.swing.JPanel();
        jPanel195 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jPanel196 = new javax.swing.JPanel();
        jPanel191 = new javax.swing.JPanel();
        jPanel193 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel194 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jPanel192 = new javax.swing.JPanel();
        jPanel197 = new javax.swing.JPanel();
        jPanel199 = new javax.swing.JPanel();
        jPanel200 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jPanel201 = new javax.swing.JPanel();
        jPanel202 = new javax.swing.JPanel();
        jPanel203 = new javax.swing.JPanel();
        jButton22 = new javax.swing.JButton();
        jPanel205 = new javax.swing.JPanel();
        jPanel206 = new javax.swing.JPanel();
        jButton21 = new javax.swing.JButton();
        jPanel198 = new javax.swing.JPanel();
        jPanel204 = new javax.swing.JPanel();
        jPanel207 = new javax.swing.JPanel();
        jPanel208 = new javax.swing.JPanel();
        jPanel209 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jPanel210 = new javax.swing.JPanel();
        jPanel211 = new javax.swing.JPanel();
        jPanel212 = new javax.swing.JPanel();
        jPanel213 = new javax.swing.JPanel();
        jPanel231 = new javax.swing.JPanel();
        jPanel232 = new javax.swing.JPanel();
        jPanel233 = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        jPanel234 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jPanel214 = new javax.swing.JPanel();
        jPanel216 = new javax.swing.JPanel();
        jPanel218 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jPanel219 = new javax.swing.JPanel();
        jPanel220 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jPanel221 = new javax.swing.JPanel();
        jPanel222 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jPasswordField2 = new javax.swing.JPasswordField();
        jPanel223 = new javax.swing.JPanel();
        jPanel224 = new javax.swing.JPanel();
        jButton23 = new javax.swing.JButton();
        jPanel225 = new javax.swing.JPanel();
        jPanel226 = new javax.swing.JPanel();
        jPanel227 = new javax.swing.JPanel();
        jButton24 = new javax.swing.JButton();
        jPanel229 = new javax.swing.JPanel();
        jPanel228 = new javax.swing.JPanel();
        jPanel230 = new javax.swing.JPanel();
        jPanel217 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jPanel215 = new javax.swing.JPanel();
        jPanel235 = new javax.swing.JPanel();
        jPanel236 = new javax.swing.JPanel();
        jPanel237 = new javax.swing.JPanel();
        jPanel238 = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        jPanel239 = new javax.swing.JPanel();
        jPanel240 = new javax.swing.JPanel();
        jPanel241 = new javax.swing.JPanel();
        jPanel242 = new javax.swing.JPanel();
        jPanel243 = new javax.swing.JPanel();
        jPanel245 = new javax.swing.JPanel();
        jPanel247 = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jPanel248 = new javax.swing.JPanel();
        jPanel249 = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jPanel250 = new javax.swing.JPanel();
        jPanel251 = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel252 = new javax.swing.JPanel();
        jPanel253 = new javax.swing.JPanel();
        jButton25 = new javax.swing.JButton();
        jPanel254 = new javax.swing.JPanel();
        jPanel255 = new javax.swing.JPanel();
        jPanel256 = new javax.swing.JPanel();
        jButton26 = new javax.swing.JButton();
        jPanel258 = new javax.swing.JPanel();
        jPanel259 = new javax.swing.JPanel();
        jButton40 = new javax.swing.JButton();
        jPanel246 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jPanel244 = new javax.swing.JPanel();
        jPanel260 = new javax.swing.JPanel();
        jPanel261 = new javax.swing.JPanel();
        jPanel262 = new javax.swing.JPanel();
        jPanel263 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jPanel264 = new javax.swing.JPanel();
        jPanel265 = new javax.swing.JPanel();
        jPanel266 = new javax.swing.JPanel();
        jPanel267 = new javax.swing.JPanel();
        jPanel268 = new javax.swing.JPanel();
        jPanel270 = new javax.swing.JPanel();
        jPanel272 = new javax.swing.JPanel();
        jLabel65 = new javax.swing.JLabel();
        jPasswordField3 = new javax.swing.JPasswordField();
        jPanel273 = new javax.swing.JPanel();
        jPanel274 = new javax.swing.JPanel();
        jLabel66 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jPanel275 = new javax.swing.JPanel();
        jPanel276 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jPanel277 = new javax.swing.JPanel();
        jPanel278 = new javax.swing.JPanel();
        jButton27 = new javax.swing.JButton();
        jPanel279 = new javax.swing.JPanel();
        jPanel280 = new javax.swing.JPanel();
        jPanel281 = new javax.swing.JPanel();
        jButton28 = new javax.swing.JButton();
        jPanel283 = new javax.swing.JPanel();
        jPanel284 = new javax.swing.JPanel();
        jPanel271 = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        jPanel269 = new javax.swing.JPanel();
        jPanel285 = new javax.swing.JPanel();
        jPanel286 = new javax.swing.JPanel();
        jPanel287 = new javax.swing.JPanel();
        jPanel288 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        jPanel289 = new javax.swing.JPanel();
        jPanel291 = new javax.swing.JPanel();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jPanel292 = new javax.swing.JPanel();
        jPanel290 = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jPanel293 = new javax.swing.JPanel();
        jPanel294 = new javax.swing.JPanel();
        jPanel295 = new javax.swing.JPanel();
        jPanel297 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        jPanel298 = new javax.swing.JPanel();
        jPanel299 = new javax.swing.JPanel();
        jLabel70 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jPanel300 = new javax.swing.JPanel();
        jPanel301 = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jPanel302 = new javax.swing.JPanel();
        jPanel303 = new javax.swing.JPanel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jPanel304 = new javax.swing.JPanel();
        jButton34 = new javax.swing.JButton();
        jPanel305 = new javax.swing.JPanel();
        jButton35 = new javax.swing.JButton();
        jPanel296 = new javax.swing.JPanel();
        jPanel306 = new javax.swing.JPanel();
        jPanel308 = new javax.swing.JPanel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jPanel309 = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jPanel310 = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(900, 600));
        setMinimumSize(new java.awt.Dimension(900, 600));
        setPreferredSize(new java.awt.Dimension(900, 600));

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jPanel3.setLayout(new java.awt.GridLayout(2, 0));

        jPanel6.setBackground(new java.awt.Color(15, 25, 33));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 606, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 878, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel6);

        jPanel7.setLayout(new java.awt.GridLayout(2, 0));

        jPanel9.setBackground(new java.awt.Color(15, 25, 33));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 606, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 439, Short.MAX_VALUE)
        );

        jPanel7.add(jPanel9);

        jPanel22.setBackground(new java.awt.Color(15, 25, 33));
        jPanel22.setLayout(new java.awt.GridLayout(4, 0));

        jLabel1.setBackground(new java.awt.Color(15, 25, 33));
        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(57, 255, 20));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("About");
        jPanel22.add(jLabel1);

        jLabel2.setForeground(new java.awt.Color(238, 238, 238));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Project replicating block chain.");
        jPanel22.add(jLabel2);

        jLabel3.setForeground(new java.awt.Color(238, 238, 238));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("We tried to replicate as many");
        jPanel22.add(jLabel3);

        jLabel4.setForeground(new java.awt.Color(238, 238, 238));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("functionalities as we can");
        jPanel22.add(jLabel4);

        jPanel7.add(jPanel22);

        jPanel3.add(jPanel7);

        jPanel1.add(jPanel3);

        jPanel4.setLayout(new java.awt.GridLayout(3, 0));

        jPanel12.setBackground(new java.awt.Color(15, 25, 33));
        jPanel12.setLayout(new java.awt.BorderLayout());

        jLabel5.setBackground(new java.awt.Color(15, 25, 33));
        jLabel5.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(57, 255, 20));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Welcome");
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel12.add(jLabel5, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel12);

        jPanel13.setBackground(new java.awt.Color(15, 25, 33));
        jPanel13.setLayout(new java.awt.BorderLayout());

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blockchainproject/logo.jpg"))); // NOI18N
        jPanel13.add(jLabel6, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel13);

        jPanel14.setBackground(new java.awt.Color(15, 25, 33));
        jPanel14.setLayout(new java.awt.GridLayout(6, 0));

        jPanel15.setBackground(new java.awt.Color(15, 25, 33));
        jPanel15.setLayout(new java.awt.GridLayout(1, 0));

        jPanel17.setBackground(new java.awt.Color(15, 25, 33));
        jPanel17.setLayout(new java.awt.BorderLayout());

        jButton1.setBackground(new java.awt.Color(17, 23, 33));
        jButton1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(57, 255, 20));
        jButton1.setText("Login");
        jButton1.setAutoscrolls(true);
        jButton1.setMargin(new java.awt.Insets(2, 7, 3, 7));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel17.add(jButton1, java.awt.BorderLayout.CENTER);

        jPanel15.add(jPanel17);

        jPanel18.setBackground(new java.awt.Color(15, 25, 33));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 202, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );

        jPanel15.add(jPanel18);

        jPanel19.setBackground(new java.awt.Color(15, 25, 33));
        jPanel19.setLayout(new java.awt.BorderLayout());

        jButton36.setBackground(new java.awt.Color(17, 23, 33));
        jButton36.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jButton36.setForeground(new java.awt.Color(57, 255, 20));
        jButton36.setText("Signup");
        jButton36.setMargin(new java.awt.Insets(2, 7, 3, 7));
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);
            }
        });
        jPanel19.add(jButton36, java.awt.BorderLayout.CENTER);

        jPanel15.add(jPanel19);

        jPanel14.add(jPanel15);

        jPanel4.add(jPanel14);

        jPanel1.add(jPanel4);

        jPanel5.setLayout(new java.awt.GridLayout(2, 0));

        jPanel10.setBackground(new java.awt.Color(15, 25, 33));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 606, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 878, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel10);

        jPanel11.setLayout(new java.awt.GridLayout(2, 0));

        jPanel8.setBackground(new java.awt.Color(15, 25, 33));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 606, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 439, Short.MAX_VALUE)
        );

        jPanel11.add(jPanel8);

        jPanel21.setBackground(new java.awt.Color(15, 25, 33));
        jPanel21.setLayout(new java.awt.GridLayout(5, 0));

        jLabel7.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(57, 255, 20));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Contact");
        jPanel21.add(jLabel7);

        jLabel8.setForeground(new java.awt.Color(238, 238, 238));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Muhammad Abdullah ");
        jPanel21.add(jLabel8);

        jLabel9.setForeground(new java.awt.Color(238, 238, 238));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Muhammad Munib Nawaz");
        jPanel21.add(jLabel9);

        jLabel10.setForeground(new java.awt.Color(238, 238, 238));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Husnain Tahir");
        jPanel21.add(jLabel10);

        jLabel11.setForeground(new java.awt.Color(238, 238, 238));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Radeel Ahmed");
        jPanel21.add(jLabel11);

        jPanel11.add(jPanel21);

        jPanel5.add(jPanel11);

        jPanel1.add(jPanel5);

        jTabbedPane1.addTab("MainPage", jPanel1);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel23.setBackground(new java.awt.Color(15, 25, 33));
        jPanel23.setPreferredSize(new java.awt.Dimension(40, 669));

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1757, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel23, java.awt.BorderLayout.LINE_START);

        jPanel24.setLayout(new java.awt.BorderLayout());

        jPanel25.setBackground(new java.awt.Color(15, 25, 33));
        jPanel25.setLayout(new java.awt.BorderLayout());

        jLabel12.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(57, 225, 20));
        jLabel12.setText("Public Ledger");
        jLabel12.setPreferredSize(new java.awt.Dimension(43, 70));
        jPanel25.add(jLabel12, java.awt.BorderLayout.CENTER);

        jPanel24.add(jPanel25, java.awt.BorderLayout.PAGE_START);

        jPanel26.setBackground(new java.awt.Color(15, 25, 33));
        jPanel26.setLayout(new java.awt.GridLayout(1, 0));

        jPanel27.setBackground(new java.awt.Color(15, 25, 33));

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 593, Short.MAX_VALUE)
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1687, Short.MAX_VALUE)
        );

        jPanel26.add(jPanel27);

        jPanel28.setLayout(new java.awt.BorderLayout());

        jPanel30.setBackground(new java.awt.Color(15, 25, 33));

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 593, Short.MAX_VALUE)
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel28.add(jPanel30, java.awt.BorderLayout.PAGE_START);

        jPanel31.setBackground(new java.awt.Color(15, 25, 33));
        jPanel31.setLayout(new java.awt.GridLayout(2, 0, 0, 5));

        jPanel32.setBackground(new java.awt.Color(15, 25, 33));
        jPanel32.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setBackground(new java.awt.Color(15, 25, 33));

        jTable2.setBackground(new java.awt.Color(15, 25, 33));
        jTable2.setForeground(new java.awt.Color(57, 225, 20));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Sender", "Reciever"
            }
        ));
        jTable2.setToolTipText("");
        jTable2.setGridColor(new java.awt.Color(15, 25, 33));
        jTable2.setSelectionBackground(new java.awt.Color(15, 25, 33));
        jTable2.setSelectionForeground(new java.awt.Color(57, 225, 20));
        jScrollPane2.setViewportView(jTable2);

        jPanel32.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel31.add(jPanel32);

        jPanel33.setBackground(new java.awt.Color(15, 25, 33));
        jPanel33.setLayout(new java.awt.GridLayout(8, 0, 0, 2));

        jPanel34.setLayout(new java.awt.BorderLayout());

        jButton3.setBackground(new java.awt.Color(57, 225, 20));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Show Records");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel34.add(jButton3, java.awt.BorderLayout.CENTER);

        jPanel33.add(jPanel34);

        jPanel35.setBackground(new java.awt.Color(15, 25, 33));
        jPanel35.setLayout(new java.awt.GridLayout(1, 0));

        jPanel36.setLayout(new java.awt.BorderLayout());

        jButton4.setBackground(new java.awt.Color(57, 225, 20));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel36.add(jButton4, java.awt.BorderLayout.CENTER);

        jPanel35.add(jPanel36);

        jPanel39.setBackground(new java.awt.Color(15, 25, 33));

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 197, Short.MAX_VALUE)
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );

        jPanel35.add(jPanel39);

        jPanel40.setBackground(new java.awt.Color(15, 25, 33));

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 197, Short.MAX_VALUE)
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );

        jPanel35.add(jPanel40);

        jPanel33.add(jPanel35);

        jPanel31.add(jPanel33);

        jPanel28.add(jPanel31, java.awt.BorderLayout.CENTER);

        jPanel26.add(jPanel28);

        jPanel29.setBackground(new java.awt.Color(15, 25, 33));

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 593, Short.MAX_VALUE)
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1687, Short.MAX_VALUE)
        );

        jPanel26.add(jPanel29);

        jPanel24.add(jPanel26, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel24, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("PublicLedger", jPanel2);

        jPanel41.setBackground(new java.awt.Color(15, 25, 33));
        jPanel41.setLayout(new java.awt.BorderLayout());

        jPanel42.setBackground(new java.awt.Color(15, 25, 33));
        jPanel42.setPreferredSize(new java.awt.Dimension(40, 669));

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1757, Short.MAX_VALUE)
        );

        jPanel41.add(jPanel42, java.awt.BorderLayout.LINE_START);

        jPanel43.setBackground(new java.awt.Color(15, 25, 33));
        jPanel43.setLayout(new java.awt.BorderLayout());

        jPanel44.setBackground(new java.awt.Color(15, 25, 33));
        jPanel44.setLayout(new java.awt.BorderLayout());

        jLabel14.setBackground(new java.awt.Color(15, 25, 33));
        jLabel14.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 36)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(57, 225, 20));
        jLabel14.setText("Rate with time");
        jLabel14.setPreferredSize(new java.awt.Dimension(43, 70));
        jPanel44.add(jLabel14, java.awt.BorderLayout.CENTER);

        jPanel43.add(jPanel44, java.awt.BorderLayout.PAGE_START);

        jPanel105.setBackground(new java.awt.Color(15, 25, 33));

        javax.swing.GroupLayout jPanel105Layout = new javax.swing.GroupLayout(jPanel105);
        jPanel105.setLayout(jPanel105Layout);
        jPanel105Layout.setHorizontalGroup(
            jPanel105Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel105Layout.setVerticalGroup(
            jPanel105Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1687, Short.MAX_VALUE)
        );

        jPanel43.add(jPanel105, java.awt.BorderLayout.LINE_START);

        jPanel112.setBackground(new java.awt.Color(15, 25, 33));

        javax.swing.GroupLayout jPanel112Layout = new javax.swing.GroupLayout(jPanel112);
        jPanel112.setLayout(jPanel112Layout);
        jPanel112Layout.setHorizontalGroup(
            jPanel112Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel112Layout.setVerticalGroup(
            jPanel112Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1687, Short.MAX_VALUE)
        );

        jPanel43.add(jPanel112, java.awt.BorderLayout.LINE_END);

        jPanel116.setBackground(new java.awt.Color(15, 25, 33));
        jPanel116.setLayout(new java.awt.BorderLayout());

        jPanel38.setBackground(new java.awt.Color(15, 25, 33));
        jPanel38.setLayout(new java.awt.GridLayout(3, 0));

        jPanel45.setBackground(new java.awt.Color(15, 25, 33));
        jPanel45.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBackground(new java.awt.Color(15, 25, 33));

        jTable1.setBackground(new java.awt.Color(15, 25, 33));
        jTable1.setForeground(new java.awt.Color(57, 225, 20));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Time", "Bitcoin", "Etherium", "Ripple"
            }
        ));
        jTable1.setSelectionBackground(new java.awt.Color(15, 25, 33));
        jTable1.setSelectionForeground(new java.awt.Color(57, 225, 20));
        jScrollPane1.setViewportView(jTable1);

        jPanel45.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel38.add(jPanel45);

        jPanel58.setBackground(new java.awt.Color(15, 25, 33));
        jPanel58.setLayout(new java.awt.GridLayout(1, 0));

        jPanel110.setBackground(new java.awt.Color(15, 25, 33));
        jPanel110.setLayout(new java.awt.GridLayout(5, 0, 0, 3));

        jPanel169.setBackground(new java.awt.Color(15, 25, 33));
        jPanel169.setLayout(new java.awt.GridLayout(1, 0));

        jPanel312.setBackground(new java.awt.Color(15, 25, 33));
        jPanel312.setLayout(new java.awt.BorderLayout());

        jLabel89.setBackground(new java.awt.Color(15, 25, 33));
        jLabel89.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel89.setForeground(new java.awt.Color(57, 225, 20));
        jLabel89.setText("Bitcoin price");
        jPanel312.add(jLabel89, java.awt.BorderLayout.CENTER);

        jPanel169.add(jPanel312);

        jPanel313.setBackground(new java.awt.Color(15, 25, 33));
        jPanel313.setLayout(new java.awt.BorderLayout());

        jLabel86.setForeground(new java.awt.Color(57, 225, 20));
        jLabel86.setText("_________________");
        jPanel313.add(jLabel86, java.awt.BorderLayout.CENTER);

        jPanel169.add(jPanel313);

        jPanel110.add(jPanel169);

        jPanel257.setLayout(new java.awt.GridLayout(1, 0));

        jPanel314.setBackground(new java.awt.Color(15, 25, 33));
        jPanel314.setLayout(new java.awt.BorderLayout());

        jLabel91.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel91.setForeground(new java.awt.Color(57, 225, 20));
        jLabel91.setText("Ripple price");
        jPanel314.add(jLabel91, java.awt.BorderLayout.CENTER);

        jPanel257.add(jPanel314);

        jPanel315.setBackground(new java.awt.Color(15, 25, 33));
        jPanel315.setLayout(new java.awt.BorderLayout());

        jLabel88.setBackground(new java.awt.Color(15, 25, 33));
        jLabel88.setForeground(new java.awt.Color(57, 225, 20));
        jLabel88.setText("_________________");
        jPanel315.add(jLabel88, java.awt.BorderLayout.CENTER);

        jPanel257.add(jPanel315);

        jPanel110.add(jPanel257);

        jPanel282.setLayout(new java.awt.GridLayout(1, 0));

        jPanel316.setBackground(new java.awt.Color(15, 25, 33));
        jPanel316.setLayout(new java.awt.BorderLayout());

        jLabel93.setBackground(new java.awt.Color(15, 25, 33));
        jLabel93.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel93.setForeground(new java.awt.Color(57, 225, 20));
        jLabel93.setText("Etherium price");
        jPanel316.add(jLabel93, java.awt.BorderLayout.CENTER);

        jPanel282.add(jPanel316);

        jPanel317.setBackground(new java.awt.Color(15, 25, 33));
        jPanel317.setLayout(new java.awt.BorderLayout());

        jLabel87.setForeground(new java.awt.Color(57, 225, 20));
        jLabel87.setText("_________________");
        jPanel317.add(jLabel87, java.awt.BorderLayout.CENTER);

        jPanel282.add(jPanel317);

        jPanel110.add(jPanel282);

        jPanel307.setBackground(new java.awt.Color(57, 225, 20));
        jPanel307.setLayout(new java.awt.GridLayout(1, 0));

        jPanel318.setBackground(new java.awt.Color(57, 225, 20));
        jPanel318.setLayout(new java.awt.BorderLayout());

        jButton13.setBackground(new java.awt.Color(57, 225, 20));
        jButton13.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setText("Current rate");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel318.add(jButton13, java.awt.BorderLayout.CENTER);

        jPanel307.add(jPanel318);

        jPanel319.setBackground(new java.awt.Color(15, 25, 33));

        javax.swing.GroupLayout jPanel319Layout = new javax.swing.GroupLayout(jPanel319);
        jPanel319.setLayout(jPanel319Layout);
        jPanel319Layout.setHorizontalGroup(
            jPanel319Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
        );
        jPanel319Layout.setVerticalGroup(
            jPanel319Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );

        jPanel307.add(jPanel319);

        jPanel110.add(jPanel307);

        jPanel311.setLayout(new java.awt.GridLayout(1, 0));

        jPanel320.setBackground(new java.awt.Color(15, 25, 33));
        jPanel320.setLayout(new java.awt.BorderLayout());

        jButton14.setBackground(new java.awt.Color(57, 225, 20));
        jButton14.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jButton14.setForeground(new java.awt.Color(255, 255, 255));
        jButton14.setText("Previous record");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel320.add(jButton14, java.awt.BorderLayout.CENTER);

        jPanel311.add(jPanel320);

        jPanel321.setBackground(new java.awt.Color(15, 25, 33));

        javax.swing.GroupLayout jPanel321Layout = new javax.swing.GroupLayout(jPanel321);
        jPanel321.setLayout(jPanel321Layout);
        jPanel321Layout.setHorizontalGroup(
            jPanel321Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
        );
        jPanel321Layout.setVerticalGroup(
            jPanel321Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );

        jPanel311.add(jPanel321);

        jPanel110.add(jPanel311);

        jPanel58.add(jPanel110);

        jPanel120.setBackground(new java.awt.Color(15, 25, 33));

        javax.swing.GroupLayout jPanel120Layout = new javax.swing.GroupLayout(jPanel120);
        jPanel120.setLayout(jPanel120Layout);
        jPanel120Layout.setHorizontalGroup(
            jPanel120Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 790, Short.MAX_VALUE)
        );
        jPanel120Layout.setVerticalGroup(
            jPanel120Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );

        jPanel58.add(jPanel120);

        jPanel38.add(jPanel58);

        jPanel322.setBackground(new java.awt.Color(15, 25, 33));
        jPanel322.setLayout(new java.awt.GridLayout(5, 0));

        jPanel323.setBackground(new java.awt.Color(15, 25, 33));

        javax.swing.GroupLayout jPanel323Layout = new javax.swing.GroupLayout(jPanel323);
        jPanel323.setLayout(jPanel323Layout);
        jPanel323Layout.setHorizontalGroup(
            jPanel323Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1580, Short.MAX_VALUE)
        );
        jPanel323Layout.setVerticalGroup(
            jPanel323Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );

        jPanel322.add(jPanel323);

        jPanel324.setBackground(new java.awt.Color(15, 25, 33));
        jPanel324.setLayout(new java.awt.GridLayout(1, 0));

        jPanel325.setBackground(new java.awt.Color(15, 25, 33));
        jPanel325.setLayout(new java.awt.GridLayout(1, 0));

        jPanel327.setLayout(new java.awt.BorderLayout());

        jButton17.setBackground(new java.awt.Color(57, 225, 20));
        jButton17.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jButton17.setForeground(new java.awt.Color(255, 255, 255));
        jButton17.setText("Back");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jPanel327.add(jButton17, java.awt.BorderLayout.CENTER);

        jPanel325.add(jPanel327);

        jPanel328.setBackground(new java.awt.Color(15, 25, 33));

        javax.swing.GroupLayout jPanel328Layout = new javax.swing.GroupLayout(jPanel328);
        jPanel328.setLayout(jPanel328Layout);
        jPanel328Layout.setHorizontalGroup(
            jPanel328Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
        );
        jPanel328Layout.setVerticalGroup(
            jPanel328Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );

        jPanel325.add(jPanel328);

        jPanel324.add(jPanel325);

        jPanel326.setBackground(new java.awt.Color(15, 25, 33));

        javax.swing.GroupLayout jPanel326Layout = new javax.swing.GroupLayout(jPanel326);
        jPanel326.setLayout(jPanel326Layout);
        jPanel326Layout.setHorizontalGroup(
            jPanel326Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 790, Short.MAX_VALUE)
        );
        jPanel326Layout.setVerticalGroup(
            jPanel326Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );

        jPanel324.add(jPanel326);

        jPanel322.add(jPanel324);

        jPanel38.add(jPanel322);

        jPanel116.add(jPanel38, java.awt.BorderLayout.CENTER);

        jPanel43.add(jPanel116, java.awt.BorderLayout.CENTER);

        jPanel41.add(jPanel43, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("RateWithTime", jPanel41);

        jPanel46.setLayout(new java.awt.GridLayout(1, 0));

        jPanel47.setBackground(new java.awt.Color(15, 25, 33));

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 606, Short.MAX_VALUE)
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1757, Short.MAX_VALUE)
        );

        jPanel46.add(jPanel47);

        jPanel48.setLayout(new java.awt.GridLayout(4, 0));

        jPanel50.setBackground(new java.awt.Color(15, 25, 33));
        jPanel50.setLayout(new java.awt.BorderLayout());

        jLabel15.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 36)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(57, 225, 20));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Login");
        jLabel15.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel50.add(jLabel15, java.awt.BorderLayout.CENTER);

        jPanel48.add(jPanel50);

        jPanel52.setBackground(new java.awt.Color(17, 23, 33));
        jPanel52.setLayout(new java.awt.GridLayout(6, 0, 0, 2));

        jLabel17.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(57, 225, 20));
        jLabel17.setText("Sign in to your account");
        jPanel52.add(jLabel17);

        jLabel16.setForeground(new java.awt.Color(57, 225, 20));
        jLabel16.setText("Username");
        jPanel52.add(jLabel16);

        jTextField1.setBackground(new java.awt.Color(25, 34, 49));
        jTextField1.setForeground(new java.awt.Color(57, 225, 20));
        jTextField1.setDisabledTextColor(new java.awt.Color(57, 225, 20));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel52.add(jTextField1);

        jLabel18.setForeground(new java.awt.Color(57, 225, 20));
        jLabel18.setText("Password");
        jPanel52.add(jLabel18);

        jPasswordField1.setBackground(new java.awt.Color(25, 34, 49));
        jPasswordField1.setForeground(new java.awt.Color(57, 225, 20));
        jPasswordField1.setDisabledTextColor(new java.awt.Color(57, 225, 20));
        jPanel52.add(jPasswordField1);

        jPanel48.add(jPanel52);

        jPanel53.setBackground(new java.awt.Color(17, 23, 33));
        jPanel53.setLayout(new java.awt.GridLayout(6, 0, 0, 3));

        jPanel51.setBackground(new java.awt.Color(17, 23, 33));
        jPanel51.setLayout(new java.awt.GridLayout(1, 0));

        jCheckBox1.setBackground(new java.awt.Color(17, 23, 33));
        jCheckBox1.setForeground(new java.awt.Color(57, 225, 20));
        jCheckBox1.setText("Keep me signed in ");
        jPanel51.add(jCheckBox1);

        jLabel19.setForeground(new java.awt.Color(57, 225, 20));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Forgot password?");
        jPanel51.add(jLabel19);

        jPanel53.add(jPanel51);

        jButton5.setBackground(new java.awt.Color(57, 225, 20));
        jButton5.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Login");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel53.add(jButton5);

        jPanel55.setBackground(new java.awt.Color(17, 23, 33));
        jPanel55.setLayout(new java.awt.GridLayout(1, 0));

        jLabel20.setBackground(new java.awt.Color(17, 23, 33));
        jLabel20.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(57, 225, 20));
        jLabel20.setText("Don't have an account?");
        jPanel55.add(jLabel20);

        jButton6.setBackground(new java.awt.Color(57, 225, 20));
        jButton6.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("JOIN NOW");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel55.add(jButton6);

        jPanel53.add(jPanel55);

        jPanel56.setBackground(new java.awt.Color(17, 23, 33));
        jPanel56.setLayout(new java.awt.GridLayout(1, 0));

        jPanel57.setLayout(new java.awt.BorderLayout());

        jButton7.setBackground(new java.awt.Color(57, 225, 20));
        jButton7.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("BACK");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel57.add(jButton7, java.awt.BorderLayout.CENTER);

        jPanel56.add(jPanel57);

        jPanel59.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel59Layout = new javax.swing.GroupLayout(jPanel59);
        jPanel59.setLayout(jPanel59Layout);
        jPanel59Layout.setHorizontalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 202, Short.MAX_VALUE)
        );
        jPanel59Layout.setVerticalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jPanel56.add(jPanel59);

        jPanel60.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel60Layout = new javax.swing.GroupLayout(jPanel60);
        jPanel60.setLayout(jPanel60Layout);
        jPanel60Layout.setHorizontalGroup(
            jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 202, Short.MAX_VALUE)
        );
        jPanel60Layout.setVerticalGroup(
            jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jPanel56.add(jPanel60);

        jPanel53.add(jPanel56);

        jPanel48.add(jPanel53);

        jPanel54.setBackground(new java.awt.Color(15, 25, 33));

        javax.swing.GroupLayout jPanel54Layout = new javax.swing.GroupLayout(jPanel54);
        jPanel54.setLayout(jPanel54Layout);
        jPanel54Layout.setHorizontalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 606, Short.MAX_VALUE)
        );
        jPanel54Layout.setVerticalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 439, Short.MAX_VALUE)
        );

        jPanel48.add(jPanel54);

        jPanel46.add(jPanel48);

        jPanel49.setBackground(new java.awt.Color(15, 25, 33));

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 606, Short.MAX_VALUE)
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1757, Short.MAX_VALUE)
        );

        jPanel46.add(jPanel49);

        jTabbedPane1.addTab("Login", jPanel46);

        jPanel61.setBackground(new java.awt.Color(17, 23, 33));
        jPanel61.setLayout(new java.awt.BorderLayout());

        jPanel62.setBackground(new java.awt.Color(17, 23, 33));
        jPanel62.setPreferredSize(new java.awt.Dimension(40, 669));

        javax.swing.GroupLayout jPanel62Layout = new javax.swing.GroupLayout(jPanel62);
        jPanel62.setLayout(jPanel62Layout);
        jPanel62Layout.setHorizontalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        jPanel62Layout.setVerticalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1757, Short.MAX_VALUE)
        );

        jPanel61.add(jPanel62, java.awt.BorderLayout.LINE_START);

        jPanel63.setBackground(new java.awt.Color(17, 23, 33));
        jPanel63.setLayout(new java.awt.BorderLayout());

        jPanel64.setBackground(new java.awt.Color(17, 23, 33));
        jPanel64.setLayout(new java.awt.BorderLayout());

        jLabel21.setBackground(new java.awt.Color(17, 23, 33));
        jLabel21.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 36)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(57, 225, 20));
        jLabel21.setText("Start new chain");
        jLabel21.setPreferredSize(new java.awt.Dimension(43, 70));
        jPanel64.add(jLabel21, java.awt.BorderLayout.CENTER);

        jPanel63.add(jPanel64, java.awt.BorderLayout.PAGE_START);

        jPanel65.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel65Layout = new javax.swing.GroupLayout(jPanel65);
        jPanel65.setLayout(jPanel65Layout);
        jPanel65Layout.setHorizontalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel65Layout.setVerticalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1687, Short.MAX_VALUE)
        );

        jPanel63.add(jPanel65, java.awt.BorderLayout.LINE_START);

        jPanel66.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel66Layout = new javax.swing.GroupLayout(jPanel66);
        jPanel66.setLayout(jPanel66Layout);
        jPanel66Layout.setHorizontalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel66Layout.setVerticalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1687, Short.MAX_VALUE)
        );

        jPanel63.add(jPanel66, java.awt.BorderLayout.LINE_END);

        jPanel67.setBackground(new java.awt.Color(17, 23, 33));
        jPanel67.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        jPanel68.setBackground(new java.awt.Color(17, 23, 33));
        jPanel68.setLayout(new java.awt.GridLayout(3, 0));

        jPanel70.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel70Layout = new javax.swing.GroupLayout(jPanel70);
        jPanel70.setLayout(jPanel70Layout);
        jPanel70Layout.setHorizontalGroup(
            jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 785, Short.MAX_VALUE)
        );
        jPanel70Layout.setVerticalGroup(
            jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );

        jPanel68.add(jPanel70);

        jPanel71.setBackground(new java.awt.Color(17, 23, 33));
        jPanel71.setLayout(new java.awt.GridLayout(10, 0));

        jPanel73.setBackground(new java.awt.Color(17, 23, 33));
        jPanel73.setLayout(new java.awt.GridLayout(1, 0));

        jLabel23.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(57, 225, 20));
        jLabel23.setText("Name:");
        jPanel73.add(jLabel23);

        jTextField3.setEditable(false);
        jTextField3.setBackground(new java.awt.Color(17, 23, 33));
        jTextField3.setForeground(new java.awt.Color(57, 225, 20));
        jPanel73.add(jTextField3);

        jPanel71.add(jPanel73);

        jPanel74.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel74Layout = new javax.swing.GroupLayout(jPanel74);
        jPanel74.setLayout(jPanel74Layout);
        jPanel74Layout.setHorizontalGroup(
            jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 785, Short.MAX_VALUE)
        );
        jPanel74Layout.setVerticalGroup(
            jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 56, Short.MAX_VALUE)
        );

        jPanel71.add(jPanel74);

        jPanel75.setBackground(new java.awt.Color(17, 23, 33));
        jPanel75.setLayout(new java.awt.GridLayout(1, 0));

        jLabel24.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(57, 225, 20));
        jLabel24.setText("Chain Name");
        jPanel75.add(jLabel24);

        jTextField4.setBackground(new java.awt.Color(25, 34, 49));
        jTextField4.setForeground(new java.awt.Color(57, 225, 20));
        jPanel75.add(jTextField4);

        jPanel71.add(jPanel75);

        jPanel76.setBackground(new java.awt.Color(17, 23, 33));
        jPanel76.setForeground(new java.awt.Color(238, 238, 238));

        javax.swing.GroupLayout jPanel76Layout = new javax.swing.GroupLayout(jPanel76);
        jPanel76.setLayout(jPanel76Layout);
        jPanel76Layout.setHorizontalGroup(
            jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 785, Short.MAX_VALUE)
        );
        jPanel76Layout.setVerticalGroup(
            jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 56, Short.MAX_VALUE)
        );

        jPanel71.add(jPanel76);

        jLabel25.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 17)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(238, 238, 238));
        jLabel25.setText("Joining MnM block chain platform");
        jPanel71.add(jLabel25);

        jLabel26.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(57, 225, 20));
        jLabel26.setText("Right Above in Field");
        jPanel71.add(jLabel26);

        jPanel77.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel77Layout = new javax.swing.GroupLayout(jPanel77);
        jPanel77.setLayout(jPanel77Layout);
        jPanel77Layout.setHorizontalGroup(
            jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 785, Short.MAX_VALUE)
        );
        jPanel77Layout.setVerticalGroup(
            jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 56, Short.MAX_VALUE)
        );

        jPanel71.add(jPanel77);

        jTextField5.setBackground(new java.awt.Color(25, 34, 49));
        jTextField5.setForeground(new java.awt.Color(57, 225, 20));
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jPanel71.add(jTextField5);

        jPanel78.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel78Layout = new javax.swing.GroupLayout(jPanel78);
        jPanel78.setLayout(jPanel78Layout);
        jPanel78Layout.setHorizontalGroup(
            jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 785, Short.MAX_VALUE)
        );
        jPanel78Layout.setVerticalGroup(
            jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 56, Short.MAX_VALUE)
        );

        jPanel71.add(jPanel78);

        jPanel79.setLayout(new java.awt.GridLayout(1, 0));

        jPanel80.setLayout(new java.awt.BorderLayout());

        jButton10.setBackground(new java.awt.Color(57, 225, 20));
        jButton10.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        jButton10.setForeground(new java.awt.Color(1, 1, 1));
        jButton10.setText("Back");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel80.add(jButton10, java.awt.BorderLayout.CENTER);

        jPanel79.add(jPanel80);

        jPanel81.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel81Layout = new javax.swing.GroupLayout(jPanel81);
        jPanel81.setLayout(jPanel81Layout);
        jPanel81Layout.setHorizontalGroup(
            jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 261, Short.MAX_VALUE)
        );
        jPanel81Layout.setVerticalGroup(
            jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 56, Short.MAX_VALUE)
        );

        jPanel79.add(jPanel81);

        jPanel83.setLayout(new java.awt.BorderLayout());

        jButton9.setBackground(new java.awt.Color(57, 225, 20));
        jButton9.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        jButton9.setForeground(new java.awt.Color(1, 1, 1));
        jButton9.setText("Go");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel83.add(jButton9, java.awt.BorderLayout.CENTER);

        jPanel79.add(jPanel83);

        jPanel71.add(jPanel79);

        jPanel68.add(jPanel71);

        jPanel72.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel72Layout = new javax.swing.GroupLayout(jPanel72);
        jPanel72.setLayout(jPanel72Layout);
        jPanel72Layout.setHorizontalGroup(
            jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 785, Short.MAX_VALUE)
        );
        jPanel72Layout.setVerticalGroup(
            jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );

        jPanel68.add(jPanel72);

        jPanel67.add(jPanel68);

        jPanel69.setBackground(new java.awt.Color(17, 23, 33));
        jPanel69.setLayout(new java.awt.GridLayout(3, 0));

        jPanel82.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel82Layout = new javax.swing.GroupLayout(jPanel82);
        jPanel82.setLayout(jPanel82Layout);
        jPanel82Layout.setHorizontalGroup(
            jPanel82Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 785, Short.MAX_VALUE)
        );
        jPanel82Layout.setVerticalGroup(
            jPanel82Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );

        jPanel69.add(jPanel82);

        jPanel84.setBackground(new java.awt.Color(17, 23, 33));
        jPanel84.setLayout(new java.awt.BorderLayout());

        jLabel22.setBackground(new java.awt.Color(17, 23, 33));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blockchainproject/logo.jpg"))); // NOI18N
        jPanel84.add(jLabel22, java.awt.BorderLayout.CENTER);

        jPanel69.add(jPanel84);

        jPanel85.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel85Layout = new javax.swing.GroupLayout(jPanel85);
        jPanel85.setLayout(jPanel85Layout);
        jPanel85Layout.setHorizontalGroup(
            jPanel85Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 785, Short.MAX_VALUE)
        );
        jPanel85Layout.setVerticalGroup(
            jPanel85Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );

        jPanel69.add(jPanel85);

        jPanel67.add(jPanel69);

        jPanel63.add(jPanel67, java.awt.BorderLayout.CENTER);

        jPanel61.add(jPanel63, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("StartNewChain", jPanel61);

        jPanel86.setLayout(new java.awt.BorderLayout());

        jPanel87.setBackground(new java.awt.Color(17, 23, 33));
        jPanel87.setPreferredSize(new java.awt.Dimension(40, 669));

        javax.swing.GroupLayout jPanel87Layout = new javax.swing.GroupLayout(jPanel87);
        jPanel87.setLayout(jPanel87Layout);
        jPanel87Layout.setHorizontalGroup(
            jPanel87Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        jPanel87Layout.setVerticalGroup(
            jPanel87Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1757, Short.MAX_VALUE)
        );

        jPanel86.add(jPanel87, java.awt.BorderLayout.LINE_START);

        jPanel88.setLayout(new java.awt.BorderLayout());

        jPanel89.setBackground(new java.awt.Color(17, 23, 33));
        jPanel89.setLayout(new java.awt.BorderLayout());

        jLabel27.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 36)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(57, 225, 20));
        jLabel27.setText("Start Block Chain");
        jLabel27.setPreferredSize(new java.awt.Dimension(43, 70));
        jPanel89.add(jLabel27, java.awt.BorderLayout.CENTER);

        jPanel88.add(jPanel89, java.awt.BorderLayout.PAGE_START);

        jPanel90.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel90Layout = new javax.swing.GroupLayout(jPanel90);
        jPanel90.setLayout(jPanel90Layout);
        jPanel90Layout.setHorizontalGroup(
            jPanel90Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel90Layout.setVerticalGroup(
            jPanel90Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1687, Short.MAX_VALUE)
        );

        jPanel88.add(jPanel90, java.awt.BorderLayout.LINE_START);

        jPanel91.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel91Layout = new javax.swing.GroupLayout(jPanel91);
        jPanel91.setLayout(jPanel91Layout);
        jPanel91Layout.setHorizontalGroup(
            jPanel91Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel91Layout.setVerticalGroup(
            jPanel91Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1687, Short.MAX_VALUE)
        );

        jPanel88.add(jPanel91, java.awt.BorderLayout.LINE_END);

        jPanel92.setBackground(new java.awt.Color(17, 23, 33));
        jPanel92.setLayout(new java.awt.GridLayout(1, 0, 5, 0));

        jPanel93.setBackground(new java.awt.Color(17, 23, 33));
        jPanel93.setLayout(new java.awt.BorderLayout());

        jPanel95.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel95Layout = new javax.swing.GroupLayout(jPanel95);
        jPanel95.setLayout(jPanel95Layout);
        jPanel95Layout.setHorizontalGroup(
            jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 787, Short.MAX_VALUE)
        );
        jPanel95Layout.setVerticalGroup(
            jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel93.add(jPanel95, java.awt.BorderLayout.PAGE_START);

        jPanel97.setLayout(new java.awt.GridLayout(2, 0));

        jPanel98.setBackground(new java.awt.Color(17, 23, 33));
        jPanel98.setLayout(new java.awt.BorderLayout());

        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blockchainproject/pic 1.PNG"))); // NOI18N
        jPanel98.add(jLabel28, java.awt.BorderLayout.CENTER);

        jPanel97.add(jPanel98);

        jPanel99.setBackground(new java.awt.Color(17, 23, 33));
        jPanel99.setLayout(new java.awt.GridLayout(6, 0, 0, 10));

        jPanel103.setLayout(new java.awt.GridLayout(1, 0));

        jPanel106.setBackground(new java.awt.Color(17, 23, 33));
        jPanel106.setLayout(new java.awt.GridLayout(1, 0));

        jPanel113.setBackground(new java.awt.Color(17, 23, 33));
        jPanel113.setLayout(new java.awt.BorderLayout());
        jPanel106.add(jPanel113);

        jPanel114.setBackground(new java.awt.Color(17, 23, 33));
        jPanel114.setLayout(new java.awt.BorderLayout());

        jButton37.setBackground(new java.awt.Color(57, 225, 20));
        jButton37.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jButton37.setForeground(new java.awt.Color(255, 255, 255));
        jButton37.setText("New Chain");
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });
        jPanel114.add(jButton37, java.awt.BorderLayout.CENTER);

        jPanel106.add(jPanel114);

        jPanel115.setBackground(new java.awt.Color(17, 23, 33));
        jPanel115.setLayout(new java.awt.BorderLayout());
        jPanel106.add(jPanel115);

        jPanel103.add(jPanel106);

        jPanel99.add(jPanel103);

        jPanel107.setBackground(new java.awt.Color(17, 23, 33));
        jPanel107.setLayout(new java.awt.GridLayout(1, 0));

        jPanel108.setLayout(new java.awt.BorderLayout());

        jButton8.setBackground(new java.awt.Color(57, 225, 20));
        jButton8.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Back");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel108.add(jButton8, java.awt.BorderLayout.CENTER);

        jPanel107.add(jPanel108);

        jPanel109.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel109Layout = new javax.swing.GroupLayout(jPanel109);
        jPanel109.setLayout(jPanel109Layout);
        jPanel109Layout.setHorizontalGroup(
            jPanel109Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 262, Short.MAX_VALUE)
        );
        jPanel109Layout.setVerticalGroup(
            jPanel109Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 123, Short.MAX_VALUE)
        );

        jPanel107.add(jPanel109);

        jPanel111.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel111Layout = new javax.swing.GroupLayout(jPanel111);
        jPanel111.setLayout(jPanel111Layout);
        jPanel111Layout.setHorizontalGroup(
            jPanel111Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 262, Short.MAX_VALUE)
        );
        jPanel111Layout.setVerticalGroup(
            jPanel111Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 123, Short.MAX_VALUE)
        );

        jPanel107.add(jPanel111);

        jPanel99.add(jPanel107);

        jPanel97.add(jPanel99);

        jPanel93.add(jPanel97, java.awt.BorderLayout.CENTER);

        jPanel92.add(jPanel93);

        jPanel94.setBackground(new java.awt.Color(17, 23, 33));
        jPanel94.setLayout(new java.awt.BorderLayout());

        jPanel96.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel96Layout = new javax.swing.GroupLayout(jPanel96);
        jPanel96.setLayout(jPanel96Layout);
        jPanel96Layout.setHorizontalGroup(
            jPanel96Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 787, Short.MAX_VALUE)
        );
        jPanel96Layout.setVerticalGroup(
            jPanel96Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel94.add(jPanel96, java.awt.BorderLayout.PAGE_START);

        jPanel100.setBackground(new java.awt.Color(17, 23, 33));
        jPanel100.setLayout(new java.awt.GridLayout(2, 0));

        jPanel101.setBackground(new java.awt.Color(17, 23, 33));
        jPanel101.setLayout(new java.awt.BorderLayout());

        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blockchainproject/pic 2.PNG"))); // NOI18N
        jPanel101.add(jLabel29, java.awt.BorderLayout.CENTER);

        jPanel100.add(jPanel101);

        jPanel102.setBackground(new java.awt.Color(17, 23, 33));
        jPanel102.setLayout(new java.awt.GridLayout(6, 0, 0, 10));

        jPanel104.setBackground(new java.awt.Color(17, 23, 33));
        jPanel104.setLayout(new java.awt.GridLayout(1, 0));

        jPanel117.setBackground(new java.awt.Color(17, 23, 33));
        jPanel117.setLayout(new java.awt.BorderLayout());
        jPanel104.add(jPanel117);

        jPanel118.setBackground(new java.awt.Color(17, 23, 33));
        jPanel118.setLayout(new java.awt.BorderLayout());

        jButton38.setBackground(new java.awt.Color(57, 225, 20));
        jButton38.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jButton38.setForeground(new java.awt.Color(255, 255, 255));
        jButton38.setText("Existing Chain");
        jButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton38ActionPerformed(evt);
            }
        });
        jPanel118.add(jButton38, java.awt.BorderLayout.CENTER);

        jPanel104.add(jPanel118);

        jPanel119.setBackground(new java.awt.Color(17, 23, 33));
        jPanel119.setLayout(new java.awt.BorderLayout());
        jPanel104.add(jPanel119);

        jPanel102.add(jPanel104);

        jPanel100.add(jPanel102);

        jPanel94.add(jPanel100, java.awt.BorderLayout.CENTER);

        jPanel92.add(jPanel94);

        jPanel88.add(jPanel92, java.awt.BorderLayout.CENTER);

        jPanel86.add(jPanel88, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("StartBlockChain", jPanel86);

        jPanel121.setBackground(new java.awt.Color(17, 23, 33));
        jPanel121.setLayout(new java.awt.BorderLayout());

        jPanel122.setBackground(new java.awt.Color(17, 23, 33));
        jPanel122.setPreferredSize(new java.awt.Dimension(40, 669));

        javax.swing.GroupLayout jPanel122Layout = new javax.swing.GroupLayout(jPanel122);
        jPanel122.setLayout(jPanel122Layout);
        jPanel122Layout.setHorizontalGroup(
            jPanel122Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        jPanel122Layout.setVerticalGroup(
            jPanel122Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1757, Short.MAX_VALUE)
        );

        jPanel121.add(jPanel122, java.awt.BorderLayout.LINE_START);

        jPanel123.setBackground(new java.awt.Color(17, 23, 33));
        jPanel123.setLayout(new java.awt.BorderLayout());

        jPanel124.setBackground(new java.awt.Color(17, 23, 33));
        jPanel124.setLayout(new java.awt.BorderLayout());

        jLabel30.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 36)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(57, 225, 20));
        jLabel30.setText("Join existing chain");
        jLabel30.setPreferredSize(new java.awt.Dimension(43, 70));
        jPanel124.add(jLabel30, java.awt.BorderLayout.CENTER);

        jPanel123.add(jPanel124, java.awt.BorderLayout.PAGE_START);

        jPanel128.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel128Layout = new javax.swing.GroupLayout(jPanel128);
        jPanel128.setLayout(jPanel128Layout);
        jPanel128Layout.setHorizontalGroup(
            jPanel128Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel128Layout.setVerticalGroup(
            jPanel128Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1687, Short.MAX_VALUE)
        );

        jPanel123.add(jPanel128, java.awt.BorderLayout.LINE_END);

        jPanel129.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel129Layout = new javax.swing.GroupLayout(jPanel129);
        jPanel129.setLayout(jPanel129Layout);
        jPanel129Layout.setHorizontalGroup(
            jPanel129Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel129Layout.setVerticalGroup(
            jPanel129Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1687, Short.MAX_VALUE)
        );

        jPanel123.add(jPanel129, java.awt.BorderLayout.LINE_START);

        jPanel130.setBackground(java.awt.Color.cyan);
        jPanel130.setToolTipText("");
        jPanel130.setLayout(new java.awt.GridLayout(2, 0));

        jPanel131.setBackground(new java.awt.Color(17, 23, 33));
        jPanel131.setLayout(new java.awt.GridLayout(2, 0));

        jPanel125.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel125Layout = new javax.swing.GroupLayout(jPanel125);
        jPanel125.setLayout(jPanel125Layout);
        jPanel125Layout.setHorizontalGroup(
            jPanel125Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1580, Short.MAX_VALUE)
        );
        jPanel125Layout.setVerticalGroup(
            jPanel125Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 421, Short.MAX_VALUE)
        );

        jPanel131.add(jPanel125);

        jPanel126.setBackground(new java.awt.Color(17, 23, 33));
        jPanel126.setLayout(new java.awt.BorderLayout());

        jLabel31.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 36)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(57, 225, 20));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("2*2*2 x ( 10 - 4 ) + 5*5 / 3 + 2");
        jPanel126.add(jLabel31, java.awt.BorderLayout.CENTER);

        jPanel131.add(jPanel126);

        jPanel130.add(jPanel131);

        jPanel132.setBackground(new java.awt.Color(17, 23, 33));
        jPanel132.setLayout(new java.awt.GridLayout(8, 0, 0, 10));

        jLabel32.setBackground(new java.awt.Color(17, 23, 33));
        jLabel32.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(57, 225, 20));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Answer format: MnM{INPUT}");
        jPanel132.add(jLabel32);

        jPanel127.setBackground(new java.awt.Color(17, 23, 33));
        jPanel127.setLayout(new java.awt.GridLayout(1, 0));

        jLabel33.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(57, 225, 20));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Answer:");
        jPanel127.add(jLabel33);

        jTextField6.setBackground(new java.awt.Color(25, 34, 49));
        jTextField6.setForeground(new java.awt.Color(57, 225, 20));
        jPanel127.add(jTextField6);

        jPanel16.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 526, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 96, Short.MAX_VALUE)
        );

        jPanel127.add(jPanel16);

        jPanel132.add(jPanel127);

        jPanel133.setBackground(new java.awt.Color(17, 23, 33));
        jPanel133.setLayout(new java.awt.GridLayout(1, 0));

        jPanel134.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel134Layout = new javax.swing.GroupLayout(jPanel134);
        jPanel134.setLayout(jPanel134Layout);
        jPanel134Layout.setHorizontalGroup(
            jPanel134Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 316, Short.MAX_VALUE)
        );
        jPanel134Layout.setVerticalGroup(
            jPanel134Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 96, Short.MAX_VALUE)
        );

        jPanel133.add(jPanel134);

        jPanel135.setLayout(new java.awt.BorderLayout());

        jButton16.setBackground(new java.awt.Color(57, 225, 20));
        jButton16.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        jButton16.setForeground(new java.awt.Color(242, 242, 242));
        jButton16.setText("Back");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel135.add(jButton16, java.awt.BorderLayout.CENTER);

        jPanel133.add(jPanel135);

        jPanel136.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel136Layout = new javax.swing.GroupLayout(jPanel136);
        jPanel136.setLayout(jPanel136Layout);
        jPanel136Layout.setHorizontalGroup(
            jPanel136Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 316, Short.MAX_VALUE)
        );
        jPanel136Layout.setVerticalGroup(
            jPanel136Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 96, Short.MAX_VALUE)
        );

        jPanel133.add(jPanel136);

        jPanel137.setBackground(new java.awt.Color(17, 23, 33));
        jPanel137.setLayout(new java.awt.BorderLayout());

        jButton15.setBackground(new java.awt.Color(57, 225, 20));
        jButton15.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        jButton15.setForeground(new java.awt.Color(242, 242, 242));
        jButton15.setText("GO");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel137.add(jButton15, java.awt.BorderLayout.CENTER);

        jPanel133.add(jPanel137);

        jPanel138.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel138Layout = new javax.swing.GroupLayout(jPanel138);
        jPanel138.setLayout(jPanel138Layout);
        jPanel138Layout.setHorizontalGroup(
            jPanel138Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 316, Short.MAX_VALUE)
        );
        jPanel138Layout.setVerticalGroup(
            jPanel138Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 96, Short.MAX_VALUE)
        );

        jPanel133.add(jPanel138);

        jPanel132.add(jPanel133);

        jPanel130.add(jPanel132);

        jPanel123.add(jPanel130, java.awt.BorderLayout.CENTER);

        jPanel121.add(jPanel123, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("JoinExistingChain", jPanel121);

        jPanel139.setLayout(new java.awt.BorderLayout());

        jPanel140.setBackground(new java.awt.Color(17, 23, 33));
        jPanel140.setPreferredSize(new java.awt.Dimension(40, 669));

        javax.swing.GroupLayout jPanel140Layout = new javax.swing.GroupLayout(jPanel140);
        jPanel140.setLayout(jPanel140Layout);
        jPanel140Layout.setHorizontalGroup(
            jPanel140Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        jPanel140Layout.setVerticalGroup(
            jPanel140Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1757, Short.MAX_VALUE)
        );

        jPanel139.add(jPanel140, java.awt.BorderLayout.LINE_START);

        jPanel141.setLayout(new java.awt.BorderLayout());

        jPanel142.setBackground(new java.awt.Color(17, 23, 33));
        jPanel142.setForeground(new java.awt.Color(57, 225, 20));
        jPanel142.setLayout(new java.awt.BorderLayout());

        jLabel34.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 36)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(57, 225, 20));
        jLabel34.setText("Buy Coins");
        jLabel34.setPreferredSize(new java.awt.Dimension(43, 70));
        jPanel142.add(jLabel34, java.awt.BorderLayout.CENTER);

        jPanel141.add(jPanel142, java.awt.BorderLayout.PAGE_START);

        jPanel143.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel143Layout = new javax.swing.GroupLayout(jPanel143);
        jPanel143.setLayout(jPanel143Layout);
        jPanel143Layout.setHorizontalGroup(
            jPanel143Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel143Layout.setVerticalGroup(
            jPanel143Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1687, Short.MAX_VALUE)
        );

        jPanel141.add(jPanel143, java.awt.BorderLayout.LINE_END);

        jPanel144.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel144Layout = new javax.swing.GroupLayout(jPanel144);
        jPanel144.setLayout(jPanel144Layout);
        jPanel144Layout.setHorizontalGroup(
            jPanel144Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel144Layout.setVerticalGroup(
            jPanel144Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1687, Short.MAX_VALUE)
        );

        jPanel141.add(jPanel144, java.awt.BorderLayout.LINE_START);

        jPanel145.setBackground(new java.awt.Color(17, 23, 33));
        jPanel145.setLayout(new java.awt.GridLayout(3, 0));

        jPanel146.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel146Layout = new javax.swing.GroupLayout(jPanel146);
        jPanel146.setLayout(jPanel146Layout);
        jPanel146Layout.setHorizontalGroup(
            jPanel146Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1580, Short.MAX_VALUE)
        );
        jPanel146Layout.setVerticalGroup(
            jPanel146Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );

        jPanel145.add(jPanel146);

        jPanel147.setBackground(new java.awt.Color(17, 23, 33));
        jPanel147.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        jPanel148.setBackground(new java.awt.Color(17, 23, 33));
        jPanel148.setLayout(new java.awt.GridLayout(7, 0));

        jPanel150.setBackground(new java.awt.Color(17, 23, 33));
        jPanel150.setLayout(new java.awt.GridLayout(1, 0));

        jLabel36.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(57, 225, 20));
        jLabel36.setText("B I T C O I N");
        jPanel150.add(jLabel36);

        jLabel37.setForeground(new java.awt.Color(57, 225, 20));
        jLabel37.setText("_______________________");
        jPanel150.add(jLabel37);

        jPanel148.add(jPanel150);

        jPanel151.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel151Layout = new javax.swing.GroupLayout(jPanel151);
        jPanel151.setLayout(jPanel151Layout);
        jPanel151Layout.setHorizontalGroup(
            jPanel151Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 785, Short.MAX_VALUE)
        );
        jPanel151Layout.setVerticalGroup(
            jPanel151Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        jPanel148.add(jPanel151);

        jPanel152.setBackground(new java.awt.Color(17, 23, 33));
        jPanel152.setLayout(new java.awt.GridLayout(1, 0));

        jLabel38.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(57, 225, 20));
        jLabel38.setText("E T H E R I U M");
        jPanel152.add(jLabel38);

        jLabel39.setForeground(new java.awt.Color(57, 225, 20));
        jLabel39.setText("_______________________");
        jPanel152.add(jLabel39);

        jPanel148.add(jPanel152);

        jPanel153.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel153Layout = new javax.swing.GroupLayout(jPanel153);
        jPanel153.setLayout(jPanel153Layout);
        jPanel153Layout.setHorizontalGroup(
            jPanel153Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 785, Short.MAX_VALUE)
        );
        jPanel153Layout.setVerticalGroup(
            jPanel153Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        jPanel148.add(jPanel153);

        jPanel154.setBackground(new java.awt.Color(17, 23, 33));
        jPanel154.setLayout(new java.awt.GridLayout(1, 0));

        jLabel40.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(57, 225, 20));
        jLabel40.setText("R I P P L E");
        jPanel154.add(jLabel40);

        jLabel41.setForeground(new java.awt.Color(57, 225, 20));
        jLabel41.setText("_______________________");
        jPanel154.add(jLabel41);

        jPanel148.add(jPanel154);

        jPanel155.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel155Layout = new javax.swing.GroupLayout(jPanel155);
        jPanel155.setLayout(jPanel155Layout);
        jPanel155Layout.setHorizontalGroup(
            jPanel155Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 785, Short.MAX_VALUE)
        );
        jPanel155Layout.setVerticalGroup(
            jPanel155Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        jPanel148.add(jPanel155);

        jPanel156.setBackground(new java.awt.Color(17, 23, 33));
        jPanel156.setLayout(new java.awt.GridLayout(1, 0));

        jPanel157.setLayout(new java.awt.BorderLayout());

        jButton18.setBackground(new java.awt.Color(57, 225, 20));
        jButton18.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jButton18.setForeground(new java.awt.Color(255, 255, 255));
        jButton18.setText("Back");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        jPanel157.add(jButton18, java.awt.BorderLayout.CENTER);

        jPanel156.add(jPanel157);

        jPanel158.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel158Layout = new javax.swing.GroupLayout(jPanel158);
        jPanel158.setLayout(jPanel158Layout);
        jPanel158Layout.setHorizontalGroup(
            jPanel158Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 157, Short.MAX_VALUE)
        );
        jPanel158Layout.setVerticalGroup(
            jPanel158Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        jPanel156.add(jPanel158);

        jPanel159.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel159Layout = new javax.swing.GroupLayout(jPanel159);
        jPanel159.setLayout(jPanel159Layout);
        jPanel159Layout.setHorizontalGroup(
            jPanel159Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 157, Short.MAX_VALUE)
        );
        jPanel159Layout.setVerticalGroup(
            jPanel159Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        jPanel156.add(jPanel159);

        jPanel160.setBackground(new java.awt.Color(17, 23, 33));
        jPanel160.setLayout(new java.awt.BorderLayout());

        jButton39.setBackground(new java.awt.Color(57, 225, 20));
        jButton39.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jButton39.setForeground(new java.awt.Color(255, 255, 255));
        jButton39.setText("Buy");
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton39ActionPerformed(evt);
            }
        });
        jPanel160.add(jButton39, java.awt.BorderLayout.CENTER);

        jPanel156.add(jPanel160);

        jPanel161.setBackground(new java.awt.Color(17, 23, 33));
        jPanel161.setLayout(new java.awt.BorderLayout());
        jPanel156.add(jPanel161);

        jPanel148.add(jPanel156);

        jPanel147.add(jPanel148);

        jPanel149.setBackground(new java.awt.Color(17, 23, 33));
        jPanel149.setLayout(new java.awt.BorderLayout());

        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blockchainproject/COIN.PNG"))); // NOI18N
        jPanel149.add(jLabel35, java.awt.BorderLayout.CENTER);

        jPanel147.add(jPanel149);

        jPanel145.add(jPanel147);

        jPanel141.add(jPanel145, java.awt.BorderLayout.CENTER);

        jPanel139.add(jPanel141, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("BuyCoin", jPanel139);

        jPanel162.setLayout(new java.awt.BorderLayout());

        jPanel163.setBackground(new java.awt.Color(17, 23, 33));
        jPanel163.setPreferredSize(new java.awt.Dimension(40, 669));

        javax.swing.GroupLayout jPanel163Layout = new javax.swing.GroupLayout(jPanel163);
        jPanel163.setLayout(jPanel163Layout);
        jPanel163Layout.setHorizontalGroup(
            jPanel163Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        jPanel163Layout.setVerticalGroup(
            jPanel163Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1757, Short.MAX_VALUE)
        );

        jPanel162.add(jPanel163, java.awt.BorderLayout.LINE_START);

        jPanel174.setLayout(new java.awt.BorderLayout());

        jPanel175.setBackground(new java.awt.Color(17, 23, 33));
        jPanel175.setLayout(new java.awt.BorderLayout());

        jLabel46.setBackground(new java.awt.Color(25, 34, 49));
        jLabel46.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 36)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(57, 225, 20));
        jLabel46.setText("Math problem");
        jLabel46.setPreferredSize(new java.awt.Dimension(43, 70));
        jPanel175.add(jLabel46, java.awt.BorderLayout.CENTER);

        jPanel174.add(jPanel175, java.awt.BorderLayout.PAGE_START);

        jPanel176.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel176Layout = new javax.swing.GroupLayout(jPanel176);
        jPanel176.setLayout(jPanel176Layout);
        jPanel176Layout.setHorizontalGroup(
            jPanel176Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel176Layout.setVerticalGroup(
            jPanel176Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1687, Short.MAX_VALUE)
        );

        jPanel174.add(jPanel176, java.awt.BorderLayout.LINE_START);

        jPanel177.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel177Layout = new javax.swing.GroupLayout(jPanel177);
        jPanel177.setLayout(jPanel177Layout);
        jPanel177Layout.setHorizontalGroup(
            jPanel177Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel177Layout.setVerticalGroup(
            jPanel177Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1687, Short.MAX_VALUE)
        );

        jPanel174.add(jPanel177, java.awt.BorderLayout.LINE_END);

        jPanel178.setBackground(new java.awt.Color(17, 23, 33));
        jPanel178.setLayout(new java.awt.GridLayout(3, 0));

        jPanel179.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel179Layout = new javax.swing.GroupLayout(jPanel179);
        jPanel179.setLayout(jPanel179Layout);
        jPanel179Layout.setHorizontalGroup(
            jPanel179Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1580, Short.MAX_VALUE)
        );
        jPanel179Layout.setVerticalGroup(
            jPanel179Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );

        jPanel178.add(jPanel179);

        jPanel180.setBackground(new java.awt.Color(17, 23, 33));
        jPanel180.setLayout(new java.awt.GridLayout(2, 0));

        jPanel182.setBackground(new java.awt.Color(17, 23, 33));
        jPanel182.setLayout(new java.awt.BorderLayout());

        jLabel47.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 36)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(57, 225, 20));
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setText("5+3 * ( 6 - 2 ) * ( 6 - 2 ) / 4");
        jPanel182.add(jLabel47, java.awt.BorderLayout.CENTER);

        jPanel180.add(jPanel182);

        jPanel183.setBackground(new java.awt.Color(17, 23, 33));
        jPanel183.setLayout(new java.awt.GridLayout(4, 0));

        jLabel42.setBackground(new java.awt.Color(17, 23, 33));
        jLabel42.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(57, 225, 20));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("Answer Formate: MNM{ANSWER}");
        jPanel183.add(jLabel42);

        jPanel164.setBackground(new java.awt.Color(17, 23, 33));
        jPanel164.setLayout(new java.awt.GridLayout(1, 0));

        jLabel43.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(57, 225, 20));
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("Answer");
        jPanel164.add(jLabel43);

        jTextField7.setBackground(new java.awt.Color(25, 34, 49));
        jTextField7.setForeground(new java.awt.Color(57, 225, 20));
        jPanel164.add(jTextField7);

        jPanel20.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 526, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jPanel164.add(jPanel20);

        jPanel183.add(jPanel164);

        jPanel165.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel165Layout = new javax.swing.GroupLayout(jPanel165);
        jPanel165.setLayout(jPanel165Layout);
        jPanel165Layout.setHorizontalGroup(
            jPanel165Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1580, Short.MAX_VALUE)
        );
        jPanel165Layout.setVerticalGroup(
            jPanel165Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jPanel183.add(jPanel165);

        jPanel166.setBackground(new java.awt.Color(17, 23, 33));
        jPanel166.setLayout(new java.awt.GridLayout(1, 0));

        jPanel167.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel167Layout = new javax.swing.GroupLayout(jPanel167);
        jPanel167.setLayout(jPanel167Layout);
        jPanel167Layout.setHorizontalGroup(
            jPanel167Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 316, Short.MAX_VALUE)
        );
        jPanel167Layout.setVerticalGroup(
            jPanel167Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jPanel166.add(jPanel167);

        jPanel168.setLayout(new java.awt.BorderLayout());

        jButton20.setBackground(new java.awt.Color(57, 225, 20));
        jButton20.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        jButton20.setForeground(new java.awt.Color(242, 242, 242));
        jButton20.setText("Back");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        jPanel168.add(jButton20, java.awt.BorderLayout.CENTER);

        jPanel166.add(jPanel168);

        jPanel170.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel170Layout = new javax.swing.GroupLayout(jPanel170);
        jPanel170.setLayout(jPanel170Layout);
        jPanel170Layout.setHorizontalGroup(
            jPanel170Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 316, Short.MAX_VALUE)
        );
        jPanel170Layout.setVerticalGroup(
            jPanel170Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jPanel166.add(jPanel170);

        jPanel171.setLayout(new java.awt.GridLayout(1, 0));

        jButton19.setBackground(new java.awt.Color(57, 225, 20));
        jButton19.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        jButton19.setForeground(new java.awt.Color(242, 242, 242));
        jButton19.setText("Create");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        jPanel171.add(jButton19);

        jPanel166.add(jPanel171);

        jPanel172.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel172Layout = new javax.swing.GroupLayout(jPanel172);
        jPanel172.setLayout(jPanel172Layout);
        jPanel172Layout.setHorizontalGroup(
            jPanel172Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 316, Short.MAX_VALUE)
        );
        jPanel172Layout.setVerticalGroup(
            jPanel172Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jPanel166.add(jPanel172);

        jPanel183.add(jPanel166);

        jPanel180.add(jPanel183);

        jPanel178.add(jPanel180);

        jPanel181.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel181Layout = new javax.swing.GroupLayout(jPanel181);
        jPanel181.setLayout(jPanel181Layout);
        jPanel181Layout.setHorizontalGroup(
            jPanel181Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1580, Short.MAX_VALUE)
        );
        jPanel181Layout.setVerticalGroup(
            jPanel181Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );

        jPanel178.add(jPanel181);

        jPanel174.add(jPanel178, java.awt.BorderLayout.CENTER);

        jPanel162.add(jPanel174, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("MathProblem", jPanel162);

        jPanel173.setBackground(new java.awt.Color(17, 23, 33));
        jPanel173.setLayout(new java.awt.BorderLayout());

        jPanel184.setBackground(new java.awt.Color(17, 23, 33));
        jPanel184.setPreferredSize(new java.awt.Dimension(40, 669));

        javax.swing.GroupLayout jPanel184Layout = new javax.swing.GroupLayout(jPanel184);
        jPanel184.setLayout(jPanel184Layout);
        jPanel184Layout.setHorizontalGroup(
            jPanel184Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        jPanel184Layout.setVerticalGroup(
            jPanel184Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1757, Short.MAX_VALUE)
        );

        jPanel173.add(jPanel184, java.awt.BorderLayout.LINE_START);

        jPanel185.setBackground(new java.awt.Color(17, 23, 33));
        jPanel185.setLayout(new java.awt.BorderLayout());

        jPanel186.setBackground(new java.awt.Color(17, 23, 33));
        jPanel186.setLayout(new java.awt.BorderLayout());

        jLabel44.setBackground(new java.awt.Color(17, 23, 33));
        jLabel44.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 36)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(57, 225, 20));
        jLabel44.setText("Choose Blockchain");
        jLabel44.setPreferredSize(new java.awt.Dimension(43, 70));
        jPanel186.add(jLabel44, java.awt.BorderLayout.CENTER);

        jPanel185.add(jPanel186, java.awt.BorderLayout.PAGE_START);

        jPanel187.setBackground(new java.awt.Color(17, 23, 33));
        jPanel187.setPreferredSize(new java.awt.Dimension(40, 1094));

        javax.swing.GroupLayout jPanel187Layout = new javax.swing.GroupLayout(jPanel187);
        jPanel187.setLayout(jPanel187Layout);
        jPanel187Layout.setHorizontalGroup(
            jPanel187Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        jPanel187Layout.setVerticalGroup(
            jPanel187Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1687, Short.MAX_VALUE)
        );

        jPanel185.add(jPanel187, java.awt.BorderLayout.LINE_START);

        jPanel188.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel188Layout = new javax.swing.GroupLayout(jPanel188);
        jPanel188.setLayout(jPanel188Layout);
        jPanel188Layout.setHorizontalGroup(
            jPanel188Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel188Layout.setVerticalGroup(
            jPanel188Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1687, Short.MAX_VALUE)
        );

        jPanel185.add(jPanel188, java.awt.BorderLayout.LINE_END);

        jPanel189.setBackground(new java.awt.Color(51, 51, 0));
        jPanel189.setLayout(new java.awt.GridLayout(3, 0));

        jPanel190.setBackground(new java.awt.Color(17, 23, 33));
        jPanel190.setLayout(new java.awt.GridLayout(1, 0));

        jPanel195.setBackground(new java.awt.Color(17, 23, 33));
        jPanel195.setLayout(new java.awt.BorderLayout());

        jLabel49.setBackground(new java.awt.Color(57, 225, 20));
        jLabel49.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(57, 225, 20));
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel49.setText("Available blockchain");
        jLabel49.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel195.add(jLabel49, java.awt.BorderLayout.CENTER);

        jPanel190.add(jPanel195);

        jPanel196.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel196Layout = new javax.swing.GroupLayout(jPanel196);
        jPanel196.setLayout(jPanel196Layout);
        jPanel196Layout.setHorizontalGroup(
            jPanel196Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 820, Short.MAX_VALUE)
        );
        jPanel196Layout.setVerticalGroup(
            jPanel196Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );

        jPanel190.add(jPanel196);

        jPanel189.add(jPanel190);

        jPanel191.setBackground(new java.awt.Color(17, 23, 33));
        jPanel191.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        jPanel193.setBackground(new java.awt.Color(17, 23, 33));
        jPanel193.setLayout(new java.awt.BorderLayout());

        jScrollPane3.setBackground(new java.awt.Color(15, 25, 33));

        jTable3.setBackground(new java.awt.Color(15, 25, 33));
        jTable3.setForeground(new java.awt.Color(57, 225, 20));
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                ""
            }
        ));
        jTable3.setToolTipText("");
        jTable3.setGridColor(new java.awt.Color(15, 25, 33));
        jTable3.setSelectionBackground(new java.awt.Color(15, 25, 33));
        jTable3.setSelectionForeground(new java.awt.Color(57, 225, 20));
        jScrollPane3.setViewportView(jTable3);

        jPanel193.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        jPanel191.add(jPanel193);

        jPanel194.setBackground(new java.awt.Color(17, 23, 33));
        jPanel194.setLayout(new java.awt.BorderLayout());

        jLabel45.setBackground(new java.awt.Color(17, 23, 33));
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blockchainproject/logo.jpg"))); // NOI18N
        jPanel194.add(jLabel45, java.awt.BorderLayout.CENTER);

        jPanel191.add(jPanel194);

        jPanel189.add(jPanel191);

        jPanel192.setBackground(new java.awt.Color(17, 23, 33));
        jPanel192.setLayout(new java.awt.GridLayout(1, 0));

        jPanel197.setBackground(new java.awt.Color(17, 23, 33));
        jPanel197.setLayout(new java.awt.GridLayout(8, 0));

        jPanel199.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel199Layout = new javax.swing.GroupLayout(jPanel199);
        jPanel199.setLayout(jPanel199Layout);
        jPanel199Layout.setHorizontalGroup(
            jPanel199Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 820, Short.MAX_VALUE)
        );
        jPanel199Layout.setVerticalGroup(
            jPanel199Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jPanel197.add(jPanel199);

        jPanel200.setBackground(new java.awt.Color(17, 23, 33));
        jPanel200.setLayout(new java.awt.GridLayout(1, 0));

        jLabel50.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(57, 225, 20));
        jLabel50.setText("Option:");
        jPanel200.add(jLabel50);

        jTextField8.setBackground(new java.awt.Color(25, 34, 49));
        jTextField8.setForeground(new java.awt.Color(57, 225, 20));
        jPanel200.add(jTextField8);

        jPanel197.add(jPanel200);

        jPanel201.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel201Layout = new javax.swing.GroupLayout(jPanel201);
        jPanel201.setLayout(jPanel201Layout);
        jPanel201Layout.setHorizontalGroup(
            jPanel201Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 820, Short.MAX_VALUE)
        );
        jPanel201Layout.setVerticalGroup(
            jPanel201Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jPanel197.add(jPanel201);

        jPanel202.setBackground(new java.awt.Color(17, 23, 33));
        jPanel202.setLayout(new java.awt.GridLayout(1, 0));

        jPanel203.setLayout(new java.awt.BorderLayout());

        jButton22.setBackground(new java.awt.Color(57, 225, 20));
        jButton22.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jButton22.setForeground(new java.awt.Color(242, 242, 242));
        jButton22.setText("Back");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });
        jPanel203.add(jButton22, java.awt.BorderLayout.CENTER);

        jPanel202.add(jPanel203);

        jPanel205.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel205Layout = new javax.swing.GroupLayout(jPanel205);
        jPanel205.setLayout(jPanel205Layout);
        jPanel205Layout.setHorizontalGroup(
            jPanel205Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 205, Short.MAX_VALUE)
        );
        jPanel205Layout.setVerticalGroup(
            jPanel205Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jPanel202.add(jPanel205);

        jPanel206.setBackground(new java.awt.Color(17, 23, 33));
        jPanel206.setLayout(new java.awt.BorderLayout());
        jPanel202.add(jPanel206);

        jButton21.setBackground(new java.awt.Color(57, 225, 20));
        jButton21.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jButton21.setForeground(new java.awt.Color(242, 242, 242));
        jButton21.setText("Submit");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        jPanel202.add(jButton21);

        jPanel197.add(jPanel202);

        jPanel192.add(jPanel197);

        jPanel198.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel198Layout = new javax.swing.GroupLayout(jPanel198);
        jPanel198.setLayout(jPanel198Layout);
        jPanel198Layout.setHorizontalGroup(
            jPanel198Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 820, Short.MAX_VALUE)
        );
        jPanel198Layout.setVerticalGroup(
            jPanel198Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );

        jPanel192.add(jPanel198);

        jPanel189.add(jPanel192);

        jPanel185.add(jPanel189, java.awt.BorderLayout.CENTER);

        jPanel173.add(jPanel185, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("ChooseBlockChain", jPanel173);

        jPanel204.setBackground(new java.awt.Color(17, 23, 33));
        jPanel204.setLayout(new java.awt.BorderLayout());

        jPanel207.setBackground(new java.awt.Color(17, 23, 33));
        jPanel207.setPreferredSize(new java.awt.Dimension(40, 669));

        javax.swing.GroupLayout jPanel207Layout = new javax.swing.GroupLayout(jPanel207);
        jPanel207.setLayout(jPanel207Layout);
        jPanel207Layout.setHorizontalGroup(
            jPanel207Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        jPanel207Layout.setVerticalGroup(
            jPanel207Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1757, Short.MAX_VALUE)
        );

        jPanel204.add(jPanel207, java.awt.BorderLayout.LINE_START);

        jPanel208.setBackground(new java.awt.Color(17, 23, 33));
        jPanel208.setLayout(new java.awt.BorderLayout());

        jPanel209.setBackground(new java.awt.Color(17, 23, 33));
        jPanel209.setLayout(new java.awt.BorderLayout());

        jLabel51.setBackground(new java.awt.Color(57, 225, 20));
        jLabel51.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 36)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(57, 225, 20));
        jLabel51.setText("Signup");
        jLabel51.setPreferredSize(new java.awt.Dimension(43, 70));
        jPanel209.add(jLabel51, java.awt.BorderLayout.CENTER);

        jPanel208.add(jPanel209, java.awt.BorderLayout.PAGE_START);

        jPanel210.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel210Layout = new javax.swing.GroupLayout(jPanel210);
        jPanel210.setLayout(jPanel210Layout);
        jPanel210Layout.setHorizontalGroup(
            jPanel210Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel210Layout.setVerticalGroup(
            jPanel210Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1687, Short.MAX_VALUE)
        );

        jPanel208.add(jPanel210, java.awt.BorderLayout.LINE_START);

        jPanel211.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel211Layout = new javax.swing.GroupLayout(jPanel211);
        jPanel211.setLayout(jPanel211Layout);
        jPanel211Layout.setHorizontalGroup(
            jPanel211Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel211Layout.setVerticalGroup(
            jPanel211Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1687, Short.MAX_VALUE)
        );

        jPanel208.add(jPanel211, java.awt.BorderLayout.LINE_END);

        jPanel212.setBackground(new java.awt.Color(17, 23, 33));
        jPanel212.setLayout(new java.awt.GridLayout(3, 0));

        jPanel213.setBackground(new java.awt.Color(17, 23, 33));
        jPanel213.setLayout(new java.awt.GridLayout(2, 0));

        jPanel231.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel231Layout = new javax.swing.GroupLayout(jPanel231);
        jPanel231.setLayout(jPanel231Layout);
        jPanel231Layout.setHorizontalGroup(
            jPanel231Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1580, Short.MAX_VALUE)
        );
        jPanel231Layout.setVerticalGroup(
            jPanel231Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 281, Short.MAX_VALUE)
        );

        jPanel213.add(jPanel231);

        jPanel232.setBackground(new java.awt.Color(17, 23, 33));
        jPanel232.setLayout(new java.awt.GridLayout(2, 0));

        jPanel233.setBackground(new java.awt.Color(17, 23, 33));
        jPanel233.setLayout(new java.awt.BorderLayout());

        jLabel56.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(238, 238, 238));
        jLabel56.setText("Create your account");
        jPanel233.add(jLabel56, java.awt.BorderLayout.CENTER);

        jPanel232.add(jPanel233);

        jPanel234.setBackground(new java.awt.Color(17, 23, 33));
        jPanel234.setLayout(new java.awt.BorderLayout());

        jLabel57.setBackground(new java.awt.Color(17, 23, 33));
        jLabel57.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(57, 225, 20));
        jLabel57.setText("Join Thousands Other! ");
        jLabel57.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel234.add(jLabel57, java.awt.BorderLayout.CENTER);

        jPanel232.add(jPanel234);

        jPanel213.add(jPanel232);

        jPanel212.add(jPanel213);

        jPanel214.setBackground(new java.awt.Color(17, 23, 33));
        jPanel214.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        jPanel216.setBackground(new java.awt.Color(17, 23, 33));
        jPanel216.setLayout(new java.awt.GridLayout(9, 0));

        jPanel218.setBackground(new java.awt.Color(17, 23, 33));
        jPanel218.setLayout(new java.awt.GridLayout(1, 0));

        jLabel53.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(57, 225, 20));
        jLabel53.setText("First Name");
        jPanel218.add(jLabel53);

        jTextField9.setBackground(new java.awt.Color(25, 34, 49));
        jTextField9.setForeground(new java.awt.Color(57, 225, 20));
        jPanel218.add(jTextField9);

        jPanel216.add(jPanel218);

        jPanel219.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel219Layout = new javax.swing.GroupLayout(jPanel219);
        jPanel219.setLayout(jPanel219Layout);
        jPanel219Layout.setHorizontalGroup(
            jPanel219Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 785, Short.MAX_VALUE)
        );
        jPanel219Layout.setVerticalGroup(
            jPanel219Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        jPanel216.add(jPanel219);

        jPanel220.setBackground(new java.awt.Color(17, 23, 33));
        jPanel220.setLayout(new java.awt.GridLayout(1, 0));

        jLabel54.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(57, 225, 20));
        jLabel54.setText("Last Name");
        jPanel220.add(jLabel54);

        jTextField10.setBackground(new java.awt.Color(25, 34, 49));
        jTextField10.setForeground(new java.awt.Color(57, 225, 20));
        jPanel220.add(jTextField10);

        jPanel216.add(jPanel220);

        jPanel221.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel221Layout = new javax.swing.GroupLayout(jPanel221);
        jPanel221.setLayout(jPanel221Layout);
        jPanel221Layout.setHorizontalGroup(
            jPanel221Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 785, Short.MAX_VALUE)
        );
        jPanel221Layout.setVerticalGroup(
            jPanel221Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        jPanel216.add(jPanel221);

        jPanel222.setBackground(new java.awt.Color(17, 23, 33));
        jPanel222.setLayout(new java.awt.GridLayout(1, 0));

        jLabel55.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(57, 225, 20));
        jLabel55.setText("Password");
        jPanel222.add(jLabel55);

        jPasswordField2.setBackground(new java.awt.Color(25, 34, 49));
        jPasswordField2.setForeground(new java.awt.Color(57, 225, 20));
        jPanel222.add(jPasswordField2);

        jPanel216.add(jPanel222);

        jPanel223.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel223Layout = new javax.swing.GroupLayout(jPanel223);
        jPanel223.setLayout(jPanel223Layout);
        jPanel223Layout.setHorizontalGroup(
            jPanel223Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 785, Short.MAX_VALUE)
        );
        jPanel223Layout.setVerticalGroup(
            jPanel223Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        jPanel216.add(jPanel223);

        jPanel224.setLayout(new java.awt.BorderLayout());

        jButton23.setBackground(new java.awt.Color(57, 225, 20));
        jButton23.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jButton23.setForeground(new java.awt.Color(255, 255, 255));
        jButton23.setText("Register");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });
        jPanel224.add(jButton23, java.awt.BorderLayout.CENTER);

        jPanel216.add(jPanel224);

        jPanel225.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel225Layout = new javax.swing.GroupLayout(jPanel225);
        jPanel225.setLayout(jPanel225Layout);
        jPanel225Layout.setHorizontalGroup(
            jPanel225Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 785, Short.MAX_VALUE)
        );
        jPanel225Layout.setVerticalGroup(
            jPanel225Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        jPanel216.add(jPanel225);

        jPanel226.setBackground(new java.awt.Color(17, 23, 33));
        jPanel226.setLayout(new java.awt.GridLayout(1, 0));

        jPanel227.setLayout(new java.awt.BorderLayout());

        jButton24.setBackground(new java.awt.Color(57, 225, 20));
        jButton24.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jButton24.setForeground(new java.awt.Color(255, 255, 255));
        jButton24.setText("Back");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });
        jPanel227.add(jButton24, java.awt.BorderLayout.CENTER);

        jPanel226.add(jPanel227);

        jPanel229.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel229Layout = new javax.swing.GroupLayout(jPanel229);
        jPanel229.setLayout(jPanel229Layout);
        jPanel229Layout.setHorizontalGroup(
            jPanel229Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 196, Short.MAX_VALUE)
        );
        jPanel229Layout.setVerticalGroup(
            jPanel229Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        jPanel226.add(jPanel229);

        jPanel228.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel228Layout = new javax.swing.GroupLayout(jPanel228);
        jPanel228.setLayout(jPanel228Layout);
        jPanel228Layout.setHorizontalGroup(
            jPanel228Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 196, Short.MAX_VALUE)
        );
        jPanel228Layout.setVerticalGroup(
            jPanel228Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        jPanel226.add(jPanel228);

        jPanel230.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel230Layout = new javax.swing.GroupLayout(jPanel230);
        jPanel230.setLayout(jPanel230Layout);
        jPanel230Layout.setHorizontalGroup(
            jPanel230Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 196, Short.MAX_VALUE)
        );
        jPanel230Layout.setVerticalGroup(
            jPanel230Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        jPanel226.add(jPanel230);

        jPanel216.add(jPanel226);

        jPanel214.add(jPanel216);

        jPanel217.setBackground(new java.awt.Color(17, 23, 33));
        jPanel217.setLayout(new java.awt.BorderLayout());

        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blockchainproject/logo.jpg"))); // NOI18N
        jPanel217.add(jLabel52, java.awt.BorderLayout.CENTER);

        jPanel214.add(jPanel217);

        jPanel212.add(jPanel214);

        jPanel215.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel215Layout = new javax.swing.GroupLayout(jPanel215);
        jPanel215.setLayout(jPanel215Layout);
        jPanel215Layout.setHorizontalGroup(
            jPanel215Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1580, Short.MAX_VALUE)
        );
        jPanel215Layout.setVerticalGroup(
            jPanel215Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );

        jPanel212.add(jPanel215);

        jPanel208.add(jPanel212, java.awt.BorderLayout.CENTER);

        jPanel204.add(jPanel208, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Signup", jPanel204);

        jPanel235.setBackground(new java.awt.Color(17, 23, 33));
        jPanel235.setLayout(new java.awt.BorderLayout());

        jPanel236.setBackground(new java.awt.Color(17, 23, 33));
        jPanel236.setPreferredSize(new java.awt.Dimension(40, 669));

        javax.swing.GroupLayout jPanel236Layout = new javax.swing.GroupLayout(jPanel236);
        jPanel236.setLayout(jPanel236Layout);
        jPanel236Layout.setHorizontalGroup(
            jPanel236Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        jPanel236Layout.setVerticalGroup(
            jPanel236Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1757, Short.MAX_VALUE)
        );

        jPanel235.add(jPanel236, java.awt.BorderLayout.LINE_START);

        jPanel237.setBackground(new java.awt.Color(17, 23, 33));
        jPanel237.setLayout(new java.awt.BorderLayout());

        jPanel238.setBackground(new java.awt.Color(17, 23, 33));
        jPanel238.setLayout(new java.awt.BorderLayout());

        jLabel58.setBackground(new java.awt.Color(17, 23, 33));
        jLabel58.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 36)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(57, 225, 20));
        jLabel58.setText("Transaction");
        jLabel58.setPreferredSize(new java.awt.Dimension(43, 70));
        jPanel238.add(jLabel58, java.awt.BorderLayout.CENTER);

        jPanel237.add(jPanel238, java.awt.BorderLayout.PAGE_START);

        jPanel239.setBackground(new java.awt.Color(17, 23, 33));
        jPanel239.setPreferredSize(new java.awt.Dimension(60, 1094));

        javax.swing.GroupLayout jPanel239Layout = new javax.swing.GroupLayout(jPanel239);
        jPanel239.setLayout(jPanel239Layout);
        jPanel239Layout.setHorizontalGroup(
            jPanel239Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );
        jPanel239Layout.setVerticalGroup(
            jPanel239Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1687, Short.MAX_VALUE)
        );

        jPanel237.add(jPanel239, java.awt.BorderLayout.LINE_START);

        jPanel240.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel240Layout = new javax.swing.GroupLayout(jPanel240);
        jPanel240.setLayout(jPanel240Layout);
        jPanel240Layout.setHorizontalGroup(
            jPanel240Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel240Layout.setVerticalGroup(
            jPanel240Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1687, Short.MAX_VALUE)
        );

        jPanel237.add(jPanel240, java.awt.BorderLayout.LINE_END);

        jPanel241.setBackground(new java.awt.Color(17, 23, 33));
        jPanel241.setLayout(new java.awt.GridLayout(3, 0));

        jPanel242.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel242Layout = new javax.swing.GroupLayout(jPanel242);
        jPanel242.setLayout(jPanel242Layout);
        jPanel242Layout.setHorizontalGroup(
            jPanel242Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1620, Short.MAX_VALUE)
        );
        jPanel242Layout.setVerticalGroup(
            jPanel242Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );

        jPanel241.add(jPanel242);

        jPanel243.setBackground(new java.awt.Color(17, 23, 33));
        jPanel243.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        jPanel245.setBackground(new java.awt.Color(17, 23, 33));
        jPanel245.setLayout(new java.awt.GridLayout(9, 0));

        jPanel247.setBackground(new java.awt.Color(17, 23, 33));
        jPanel247.setLayout(new java.awt.GridLayout(1, 0));

        jLabel60.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(57, 225, 20));
        jLabel60.setText("Reciever");
        jPanel247.add(jLabel60);

        jTextField12.setBackground(new java.awt.Color(15, 25, 33));
        jTextField12.setForeground(new java.awt.Color(57, 225, 20));
        jPanel247.add(jTextField12);

        jPanel245.add(jPanel247);

        jPanel248.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel248Layout = new javax.swing.GroupLayout(jPanel248);
        jPanel248.setLayout(jPanel248Layout);
        jPanel248Layout.setHorizontalGroup(
            jPanel248Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 805, Short.MAX_VALUE)
        );
        jPanel248Layout.setVerticalGroup(
            jPanel248Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        jPanel245.add(jPanel248);

        jPanel249.setBackground(new java.awt.Color(17, 23, 33));
        jPanel249.setLayout(new java.awt.GridLayout(1, 0));

        jLabel61.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(57, 225, 20));
        jLabel61.setText("Coins");
        jPanel249.add(jLabel61);

        jTextField13.setBackground(new java.awt.Color(15, 25, 33));
        jTextField13.setForeground(new java.awt.Color(57, 225, 20));
        jPanel249.add(jTextField13);

        jPanel245.add(jPanel249);

        jPanel250.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel250Layout = new javax.swing.GroupLayout(jPanel250);
        jPanel250.setLayout(jPanel250Layout);
        jPanel250Layout.setHorizontalGroup(
            jPanel250Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 805, Short.MAX_VALUE)
        );
        jPanel250Layout.setVerticalGroup(
            jPanel250Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        jPanel245.add(jPanel250);

        jPanel251.setBackground(new java.awt.Color(17, 23, 33));
        jPanel251.setLayout(new java.awt.GridLayout(1, 0));

        jLabel62.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(57, 225, 20));
        jLabel62.setText("Coin Type");
        jPanel251.add(jLabel62);

        jComboBox1.setBackground(new java.awt.Color(15, 25, 33));
        jComboBox1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(57, 225, 20));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "bitcoin", "etherium", "ripple" }));
        jPanel251.add(jComboBox1);

        jPanel245.add(jPanel251);

        jPanel252.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel252Layout = new javax.swing.GroupLayout(jPanel252);
        jPanel252.setLayout(jPanel252Layout);
        jPanel252Layout.setHorizontalGroup(
            jPanel252Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 805, Short.MAX_VALUE)
        );
        jPanel252Layout.setVerticalGroup(
            jPanel252Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        jPanel245.add(jPanel252);

        jPanel253.setLayout(new java.awt.BorderLayout());

        jButton25.setBackground(new java.awt.Color(57, 225, 20));
        jButton25.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jButton25.setText("Send");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });
        jPanel253.add(jButton25, java.awt.BorderLayout.CENTER);

        jPanel245.add(jPanel253);

        jPanel254.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel254Layout = new javax.swing.GroupLayout(jPanel254);
        jPanel254.setLayout(jPanel254Layout);
        jPanel254Layout.setHorizontalGroup(
            jPanel254Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 805, Short.MAX_VALUE)
        );
        jPanel254Layout.setVerticalGroup(
            jPanel254Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        jPanel245.add(jPanel254);

        jPanel255.setBackground(new java.awt.Color(17, 23, 33));
        jPanel255.setLayout(new java.awt.GridLayout(1, 0));

        jPanel256.setLayout(new java.awt.BorderLayout());

        jButton26.setBackground(new java.awt.Color(57, 225, 20));
        jButton26.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jButton26.setForeground(new java.awt.Color(255, 255, 255));
        jButton26.setText("Back");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });
        jPanel256.add(jButton26, java.awt.BorderLayout.CENTER);

        jPanel255.add(jPanel256);

        jPanel258.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel258Layout = new javax.swing.GroupLayout(jPanel258);
        jPanel258.setLayout(jPanel258Layout);
        jPanel258Layout.setHorizontalGroup(
            jPanel258Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 268, Short.MAX_VALUE)
        );
        jPanel258Layout.setVerticalGroup(
            jPanel258Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        jPanel255.add(jPanel258);

        jPanel259.setBackground(new java.awt.Color(17, 23, 33));
        jPanel259.setLayout(new java.awt.BorderLayout());

        jButton40.setBackground(new java.awt.Color(57, 225, 20));
        jButton40.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jButton40.setForeground(new java.awt.Color(255, 255, 255));
        jButton40.setText("Start Bitcoin");
        jButton40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton40ActionPerformed(evt);
            }
        });
        jPanel259.add(jButton40, java.awt.BorderLayout.CENTER);

        jPanel255.add(jPanel259);

        jPanel245.add(jPanel255);

        jPanel243.add(jPanel245);

        jPanel246.setBackground(new java.awt.Color(17, 23, 33));
        jPanel246.setLayout(new java.awt.BorderLayout());

        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel59.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blockchainproject/pic 3.PNG"))); // NOI18N
        jPanel246.add(jLabel59, java.awt.BorderLayout.CENTER);

        jPanel243.add(jPanel246);

        jPanel241.add(jPanel243);

        jPanel244.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel244Layout = new javax.swing.GroupLayout(jPanel244);
        jPanel244.setLayout(jPanel244Layout);
        jPanel244Layout.setHorizontalGroup(
            jPanel244Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1620, Short.MAX_VALUE)
        );
        jPanel244Layout.setVerticalGroup(
            jPanel244Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );

        jPanel241.add(jPanel244);

        jPanel237.add(jPanel241, java.awt.BorderLayout.CENTER);

        jPanel235.add(jPanel237, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Transaction", jPanel235);

        jPanel260.setBackground(new java.awt.Color(17, 23, 33));
        jPanel260.setLayout(new java.awt.BorderLayout());

        jPanel261.setBackground(new java.awt.Color(17, 23, 33));
        jPanel261.setPreferredSize(new java.awt.Dimension(40, 669));

        javax.swing.GroupLayout jPanel261Layout = new javax.swing.GroupLayout(jPanel261);
        jPanel261.setLayout(jPanel261Layout);
        jPanel261Layout.setHorizontalGroup(
            jPanel261Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        jPanel261Layout.setVerticalGroup(
            jPanel261Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1757, Short.MAX_VALUE)
        );

        jPanel260.add(jPanel261, java.awt.BorderLayout.LINE_START);

        jPanel262.setBackground(new java.awt.Color(17, 23, 33));
        jPanel262.setLayout(new java.awt.BorderLayout());

        jPanel263.setBackground(new java.awt.Color(17, 23, 33));
        jPanel263.setLayout(new java.awt.BorderLayout());

        jLabel63.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 36)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(57, 225, 20));
        jLabel63.setText("Sell Coin");
        jLabel63.setPreferredSize(new java.awt.Dimension(43, 70));
        jPanel263.add(jLabel63, java.awt.BorderLayout.CENTER);

        jPanel262.add(jPanel263, java.awt.BorderLayout.PAGE_START);

        jPanel264.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel264Layout = new javax.swing.GroupLayout(jPanel264);
        jPanel264.setLayout(jPanel264Layout);
        jPanel264Layout.setHorizontalGroup(
            jPanel264Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel264Layout.setVerticalGroup(
            jPanel264Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1687, Short.MAX_VALUE)
        );

        jPanel262.add(jPanel264, java.awt.BorderLayout.LINE_START);

        jPanel265.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel265Layout = new javax.swing.GroupLayout(jPanel265);
        jPanel265.setLayout(jPanel265Layout);
        jPanel265Layout.setHorizontalGroup(
            jPanel265Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel265Layout.setVerticalGroup(
            jPanel265Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1687, Short.MAX_VALUE)
        );

        jPanel262.add(jPanel265, java.awt.BorderLayout.LINE_END);

        jPanel266.setBackground(new java.awt.Color(17, 23, 33));
        jPanel266.setLayout(new java.awt.GridLayout(3, 0));

        jPanel267.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel267Layout = new javax.swing.GroupLayout(jPanel267);
        jPanel267.setLayout(jPanel267Layout);
        jPanel267Layout.setHorizontalGroup(
            jPanel267Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1580, Short.MAX_VALUE)
        );
        jPanel267Layout.setVerticalGroup(
            jPanel267Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );

        jPanel266.add(jPanel267);

        jPanel268.setBackground(new java.awt.Color(17, 23, 33));
        jPanel268.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        jPanel270.setBackground(new java.awt.Color(17, 23, 33));
        jPanel270.setLayout(new java.awt.GridLayout(9, 0));

        jPanel272.setBackground(new java.awt.Color(17, 23, 33));
        jPanel272.setLayout(new java.awt.GridLayout(1, 0));

        jLabel65.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(57, 225, 20));
        jLabel65.setText("Password");
        jPanel272.add(jLabel65);

        jPasswordField3.setBackground(new java.awt.Color(25, 34, 49));
        jPasswordField3.setForeground(new java.awt.Color(57, 255, 20));
        jPanel272.add(jPasswordField3);

        jPanel270.add(jPanel272);

        jPanel273.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel273Layout = new javax.swing.GroupLayout(jPanel273);
        jPanel273.setLayout(jPanel273Layout);
        jPanel273Layout.setHorizontalGroup(
            jPanel273Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 785, Short.MAX_VALUE)
        );
        jPanel273Layout.setVerticalGroup(
            jPanel273Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        jPanel270.add(jPanel273);

        jPanel274.setBackground(new java.awt.Color(17, 23, 33));
        jPanel274.setLayout(new java.awt.GridLayout(1, 0));

        jLabel66.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(57, 225, 20));
        jLabel66.setText("Select coin");
        jPanel274.add(jLabel66);

        jComboBox2.setBackground(new java.awt.Color(25, 34, 49));
        jComboBox2.setForeground(new java.awt.Color(57, 255, 20));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "bitcoin", "etherium", "ripple" }));
        jPanel274.add(jComboBox2);

        jPanel270.add(jPanel274);

        jPanel275.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel275Layout = new javax.swing.GroupLayout(jPanel275);
        jPanel275.setLayout(jPanel275Layout);
        jPanel275Layout.setHorizontalGroup(
            jPanel275Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 785, Short.MAX_VALUE)
        );
        jPanel275Layout.setVerticalGroup(
            jPanel275Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        jPanel270.add(jPanel275);

        jPanel276.setBackground(new java.awt.Color(17, 23, 33));
        jPanel276.setLayout(new java.awt.GridLayout(1, 0));

        jLabel67.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(57, 225, 20));
        jLabel67.setText("Enter coin to sell");
        jPanel276.add(jLabel67);

        jTextField17.setBackground(new java.awt.Color(25, 34, 49));
        jTextField17.setForeground(new java.awt.Color(57, 255, 20));
        jPanel276.add(jTextField17);

        jPanel270.add(jPanel276);

        jPanel277.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel277Layout = new javax.swing.GroupLayout(jPanel277);
        jPanel277.setLayout(jPanel277Layout);
        jPanel277Layout.setHorizontalGroup(
            jPanel277Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 785, Short.MAX_VALUE)
        );
        jPanel277Layout.setVerticalGroup(
            jPanel277Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        jPanel270.add(jPanel277);

        jPanel278.setLayout(new java.awt.BorderLayout());

        jButton27.setBackground(new java.awt.Color(57, 225, 20));
        jButton27.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jButton27.setForeground(new java.awt.Color(255, 255, 255));
        jButton27.setText("Click To Sell");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });
        jPanel278.add(jButton27, java.awt.BorderLayout.CENTER);

        jPanel270.add(jPanel278);

        jPanel279.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel279Layout = new javax.swing.GroupLayout(jPanel279);
        jPanel279.setLayout(jPanel279Layout);
        jPanel279Layout.setHorizontalGroup(
            jPanel279Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 785, Short.MAX_VALUE)
        );
        jPanel279Layout.setVerticalGroup(
            jPanel279Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        jPanel270.add(jPanel279);

        jPanel280.setBackground(new java.awt.Color(17, 23, 33));
        jPanel280.setLayout(new java.awt.GridLayout(1, 0));

        jPanel281.setLayout(new java.awt.BorderLayout());

        jButton28.setBackground(new java.awt.Color(57, 225, 20));
        jButton28.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jButton28.setForeground(new java.awt.Color(255, 255, 255));
        jButton28.setText("Back");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });
        jPanel281.add(jButton28, java.awt.BorderLayout.CENTER);

        jPanel280.add(jPanel281);

        jPanel283.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel283Layout = new javax.swing.GroupLayout(jPanel283);
        jPanel283.setLayout(jPanel283Layout);
        jPanel283Layout.setHorizontalGroup(
            jPanel283Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 261, Short.MAX_VALUE)
        );
        jPanel283Layout.setVerticalGroup(
            jPanel283Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        jPanel280.add(jPanel283);

        jPanel284.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel284Layout = new javax.swing.GroupLayout(jPanel284);
        jPanel284.setLayout(jPanel284Layout);
        jPanel284Layout.setHorizontalGroup(
            jPanel284Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 261, Short.MAX_VALUE)
        );
        jPanel284Layout.setVerticalGroup(
            jPanel284Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        jPanel280.add(jPanel284);

        jPanel270.add(jPanel280);

        jPanel268.add(jPanel270);

        jPanel271.setBackground(new java.awt.Color(17, 23, 33));
        jPanel271.setLayout(new java.awt.BorderLayout());

        jLabel64.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(57, 255, 20));
        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel271.add(jLabel64, java.awt.BorderLayout.CENTER);

        jPanel268.add(jPanel271);

        jPanel266.add(jPanel268);

        jPanel269.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel269Layout = new javax.swing.GroupLayout(jPanel269);
        jPanel269.setLayout(jPanel269Layout);
        jPanel269Layout.setHorizontalGroup(
            jPanel269Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1580, Short.MAX_VALUE)
        );
        jPanel269Layout.setVerticalGroup(
            jPanel269Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );

        jPanel266.add(jPanel269);

        jPanel262.add(jPanel266, java.awt.BorderLayout.CENTER);

        jPanel260.add(jPanel262, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("SellCoin", jPanel260);

        jPanel285.setBackground(new java.awt.Color(17, 23, 33));
        jPanel285.setLayout(new java.awt.BorderLayout());

        jPanel286.setBackground(new java.awt.Color(17, 23, 33));
        jPanel286.setPreferredSize(new java.awt.Dimension(40, 669));

        javax.swing.GroupLayout jPanel286Layout = new javax.swing.GroupLayout(jPanel286);
        jPanel286.setLayout(jPanel286Layout);
        jPanel286Layout.setHorizontalGroup(
            jPanel286Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        jPanel286Layout.setVerticalGroup(
            jPanel286Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1757, Short.MAX_VALUE)
        );

        jPanel285.add(jPanel286, java.awt.BorderLayout.LINE_START);

        jPanel287.setBackground(new java.awt.Color(17, 23, 33));
        jPanel287.setLayout(new java.awt.BorderLayout());

        jPanel288.setBackground(new java.awt.Color(17, 23, 33));
        jPanel288.setLayout(new java.awt.BorderLayout());

        jLabel68.setBackground(new java.awt.Color(17, 23, 33));
        jLabel68.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 36)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(57, 225, 20));
        jLabel68.setText("User Profile");
        jLabel68.setPreferredSize(new java.awt.Dimension(43, 70));
        jPanel288.add(jLabel68, java.awt.BorderLayout.CENTER);

        jPanel287.add(jPanel288, java.awt.BorderLayout.PAGE_START);

        jPanel289.setBackground(new java.awt.Color(17, 23, 33));
        jPanel289.setLayout(new java.awt.GridLayout(3, 0));

        jPanel291.setBackground(new java.awt.Color(17, 23, 33));
        jPanel291.setLayout(new java.awt.GridLayout(5, 0, 0, 2));

        jButton29.setBackground(new java.awt.Color(17, 23, 33));
        jButton29.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jButton29.setForeground(new java.awt.Color(242, 242, 242));
        jButton29.setText("Sell Coin");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });
        jPanel291.add(jButton29);

        jButton30.setBackground(new java.awt.Color(17, 23, 33));
        jButton30.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jButton30.setForeground(new java.awt.Color(242, 242, 242));
        jButton30.setText("Coin Rate");
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });
        jPanel291.add(jButton30);

        jButton31.setBackground(new java.awt.Color(17, 23, 33));
        jButton31.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jButton31.setForeground(new java.awt.Color(242, 242, 242));
        jButton31.setText("Transaction");
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });
        jPanel291.add(jButton31);

        jButton32.setBackground(new java.awt.Color(17, 23, 33));
        jButton32.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jButton32.setForeground(new java.awt.Color(242, 242, 242));
        jButton32.setText("Go To Chain");
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });
        jPanel291.add(jButton32);

        jButton33.setBackground(new java.awt.Color(17, 23, 33));
        jButton33.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jButton33.setForeground(new java.awt.Color(242, 242, 242));
        jButton33.setText("Buy Coin");
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });
        jPanel291.add(jButton33);

        jPanel289.add(jPanel291);

        jPanel292.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel292Layout = new javax.swing.GroupLayout(jPanel292);
        jPanel292.setLayout(jPanel292Layout);
        jPanel292Layout.setHorizontalGroup(
            jPanel292Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 116, Short.MAX_VALUE)
        );
        jPanel292Layout.setVerticalGroup(
            jPanel292Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );

        jPanel289.add(jPanel292);

        jPanel287.add(jPanel289, java.awt.BorderLayout.LINE_START);

        jPanel290.setBackground(new java.awt.Color(17, 23, 33));
        jPanel290.setPreferredSize(new java.awt.Dimension(150, 1288));
        jPanel290.setLayout(new java.awt.GridLayout(6, 0));

        jPanel37.setLayout(new java.awt.GridLayout(2, 0));

        jButton2.setBackground(new java.awt.Color(17, 23, 33));
        jButton2.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Logout");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel37.add(jButton2);

        jButton11.setBackground(new java.awt.Color(17, 23, 33));
        jButton11.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("Refresh");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel37.add(jButton11);

        jPanel290.add(jPanel37);

        jPanel287.add(jPanel290, java.awt.BorderLayout.LINE_END);

        jPanel293.setBackground(new java.awt.Color(17, 23, 33));
        jPanel293.setLayout(new java.awt.GridLayout(3, 0));

        jPanel294.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel294Layout = new javax.swing.GroupLayout(jPanel294);
        jPanel294.setLayout(jPanel294Layout);
        jPanel294Layout.setHorizontalGroup(
            jPanel294Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1514, Short.MAX_VALUE)
        );
        jPanel294Layout.setVerticalGroup(
            jPanel294Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );

        jPanel293.add(jPanel294);

        jPanel295.setBackground(new java.awt.Color(17, 23, 33));
        jPanel295.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        jPanel297.setBackground(new java.awt.Color(17, 23, 33));
        jPanel297.setLayout(new java.awt.BorderLayout());

        jLabel69.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel69.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blockchainproject/logo.jpg"))); // NOI18N
        jPanel297.add(jLabel69, java.awt.BorderLayout.CENTER);

        jPanel295.add(jPanel297);

        jPanel298.setBackground(new java.awt.Color(17, 23, 33));
        jPanel298.setLayout(new java.awt.GridLayout(9, 0));

        jPanel299.setBackground(new java.awt.Color(17, 23, 33));
        jPanel299.setLayout(new java.awt.GridLayout(1, 0));

        jLabel70.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(57, 225, 20));
        jLabel70.setText("Username");
        jPanel299.add(jLabel70);

        jLabel73.setForeground(new java.awt.Color(57, 225, 20));
        jLabel73.setText("_______________________________________");
        jPanel299.add(jLabel73);

        jPanel298.add(jPanel299);

        jPanel300.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel300Layout = new javax.swing.GroupLayout(jPanel300);
        jPanel300.setLayout(jPanel300Layout);
        jPanel300Layout.setHorizontalGroup(
            jPanel300Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 752, Short.MAX_VALUE)
        );
        jPanel300Layout.setVerticalGroup(
            jPanel300Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        jPanel298.add(jPanel300);

        jPanel301.setBackground(new java.awt.Color(17, 23, 33));
        jPanel301.setLayout(new java.awt.GridLayout(1, 0));

        jLabel71.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(57, 225, 20));
        jLabel71.setText("Balance");
        jPanel301.add(jLabel71);

        jLabel72.setForeground(new java.awt.Color(57, 225, 20));
        jLabel72.setText("_______________________________________");
        jPanel301.add(jLabel72);

        jPanel298.add(jPanel301);

        jPanel302.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel302Layout = new javax.swing.GroupLayout(jPanel302);
        jPanel302.setLayout(jPanel302Layout);
        jPanel302Layout.setHorizontalGroup(
            jPanel302Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 752, Short.MAX_VALUE)
        );
        jPanel302Layout.setVerticalGroup(
            jPanel302Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        jPanel298.add(jPanel302);

        jPanel303.setBackground(new java.awt.Color(17, 23, 33));
        jPanel303.setLayout(new java.awt.GridLayout(1, 0));

        jLabel74.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(57, 225, 20));
        jLabel74.setText("Transaction");
        jPanel303.add(jLabel74);

        jLabel75.setForeground(new java.awt.Color(57, 225, 20));
        jLabel75.setText("_____________________________________");
        jPanel303.add(jLabel75);

        jPanel298.add(jPanel303);

        jPanel304.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel304Layout = new javax.swing.GroupLayout(jPanel304);
        jPanel304.setLayout(jPanel304Layout);
        jPanel304Layout.setHorizontalGroup(
            jPanel304Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 752, Short.MAX_VALUE)
        );
        jPanel304Layout.setVerticalGroup(
            jPanel304Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        jPanel298.add(jPanel304);

        jButton34.setBackground(new java.awt.Color(57, 225, 20));
        jButton34.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jButton34.setForeground(new java.awt.Color(255, 255, 255));
        jButton34.setText("Show Detail");
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });
        jPanel298.add(jButton34);

        jPanel305.setBackground(new java.awt.Color(17, 23, 33));

        javax.swing.GroupLayout jPanel305Layout = new javax.swing.GroupLayout(jPanel305);
        jPanel305.setLayout(jPanel305Layout);
        jPanel305Layout.setHorizontalGroup(
            jPanel305Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 752, Short.MAX_VALUE)
        );
        jPanel305Layout.setVerticalGroup(
            jPanel305Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        jPanel298.add(jPanel305);

        jButton35.setBackground(new java.awt.Color(57, 225, 20));
        jButton35.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton35.setForeground(new java.awt.Color(255, 255, 255));
        jButton35.setText("Ledger");
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });
        jPanel298.add(jButton35);

        jPanel295.add(jPanel298);

        jPanel293.add(jPanel295);

        jPanel296.setBackground(new java.awt.Color(17, 23, 33));
        jPanel296.setLayout(new java.awt.GridLayout(2, 0));

        jPanel306.setBackground(new java.awt.Color(17, 23, 33));
        jPanel306.setLayout(new java.awt.GridLayout(1, 0));

        jPanel308.setBackground(new java.awt.Color(17, 23, 33));
        jPanel308.setLayout(new java.awt.GridLayout(2, 0));

        jLabel76.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(57, 225, 20));
        jLabel76.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel76.setText("R I P P L E");
        jPanel308.add(jLabel76);

        jLabel77.setForeground(new java.awt.Color(57, 225, 20));
        jLabel77.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel77.setText("____________");
        jLabel77.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel308.add(jLabel77);

        jPanel306.add(jPanel308);

        jPanel309.setBackground(new java.awt.Color(17, 23, 33));
        jPanel309.setLayout(new java.awt.GridLayout(2, 0));

        jLabel78.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(57, 225, 20));
        jLabel78.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel78.setText("E T H E R I U M");
        jPanel309.add(jLabel78);

        jLabel79.setForeground(new java.awt.Color(57, 225, 20));
        jLabel79.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel79.setText("________________");
        jLabel79.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel309.add(jLabel79);

        jPanel306.add(jPanel309);

        jPanel310.setBackground(new java.awt.Color(17, 23, 33));
        jPanel310.setLayout(new java.awt.GridLayout(2, 0));

        jLabel80.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(57, 225, 20));
        jLabel80.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel80.setText("B I T C O I N");
        jPanel310.add(jLabel80);

        jLabel82.setForeground(new java.awt.Color(57, 225, 20));
        jLabel82.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel82.setText("_____________");
        jLabel82.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel310.add(jLabel82);

        jPanel306.add(jPanel310);

        jPanel296.add(jPanel306);

        jPanel293.add(jPanel296);

        jPanel287.add(jPanel293, java.awt.BorderLayout.CENTER);

        jPanel285.add(jPanel287, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("UserProFile", jPanel285);

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jTabbedPane1.setSelectedIndex(3);
    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
        jTabbedPane1.setSelectedIndex(10);
    }//GEN-LAST:event_jButton36ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        jTextField1.setText("");
        jPasswordField1.setText("");
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        jTextField1.setText("");
        jPasswordField1.setText("");
        
        jTabbedPane1.setSelectedIndex(10);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        
        jTextField9.setText("");
        jTextField10.setText("");
        jPasswordField2.setText("");

        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String  username = jTextField1.getText();
        String  password = jPasswordField1.getText();

        try {
            SearchForLogin(username,password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
        jTextField1.setText("");
        jPasswordField1.setText("");

        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        String fname=jTextField9.getText().trim();
        String lname=jTextField10.getText().trim();
        SignupFullname=fname+lname;
        String password=jPasswordField2.getText();
        if (jTextField9.getText().isEmpty() || jPasswordField2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Username or password is missing");
        }
        else {
            try {
                if(!saveToDatabase(SignupFullname, password)){

                    SearchForLogin(SignupFullname,password);
                };
            } catch (Exception ex) {
                Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {

        } catch (Exception ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            jTextField9.setText("");
            jTextField10.setText("");
            jPasswordField2.setText("");
        }
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
        if(!isclick){
            retrieveData();
            isclick=true;
        }
    }//GEN-LAST:event_jButton34ActionPerformed

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_jButton35ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        jTabbedPane1.setSelectedIndex(11);
    }//GEN-LAST:event_jButton31ActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
        NumTransaction(retrievedTransaction,retrievedName);
    }//GEN-LAST:event_jButton32ActionPerformed

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
        try {
            CurrenyWithTime();
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        jLabel37.setText(String.valueOf(changingBit));
        jLabel39.setText(String.valueOf(changingetherium));
        jLabel41.setText(String.valueOf(changingRipple));
        jTabbedPane1.setSelectedIndex(7);
    }//GEN-LAST:event_jButton33ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        try {
            CurrenyWithTime() ;
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        jLabel64.setText("<html>Bitcoin >> " + changingBit + "<br/>Ripple >> " + changingRipple + "<br/>Etherium >> " + changingetherium + "</html>");

        jTabbedPane1.setSelectedIndex(12);
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        
        String SellCoinType=(String) jComboBox2.getSelectedItem();
        String PasswordSeller=jPasswordField3.getText().trim();
        String NumCoin=jTextField17.getText().trim();
        float SellNumCoin=Float.parseFloat(NumCoin);
        if(NumCoin.equals("")|| PasswordSeller.equals("")){
            JOptionPane.showMessageDialog(this, "Password or number of coin incorrect");
        }
        
        if(NumCoin.equals("") && PasswordSeller.equals("")){
            JOptionPane.showMessageDialog(this, "Password and number of coin aare not entered");
        }
        else{
            try {
                Sellcoin(SellCoinType,PasswordSeller,SellNumCoin);
            } catch (Exception ex) {
                Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
                jPasswordField3.setText("");
                jTextField17.setText("");
            }
        }
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        jPasswordField3.setText("");
        jTextField17.setText("");
        jTabbedPane1.setSelectedIndex(13);
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        jTabbedPane1.setSelectedIndex(13);
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jTabbedPane1.setSelectedIndex(13);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String query = "SELECT Sender, Reciever FROM publicledger";
        try {
            ps=c.prepareStatement(query);
            rs=ps.executeQuery();
            
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.setRowCount(0);
            while(rs.next()){
               String sender = rs.getString("Sender");
                String receiver = rs.getString("Reciever");

                model.addRow(new Object[]{sender, receiver});
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton39ActionPerformed
        JPanel p=new JPanel();
        JTextField ForCoinName=new JTextField(20);
        JTextField ForNumCoin=new JTextField(20);
        p.add(new JLabel("Enter Type of Currency"));
        p.add(ForCoinName);
        p.add(new Label("Enter number of Coins"));
        p.add(ForNumCoin);

        int result = JOptionPane.showConfirmDialog(null, p, "Enter Coin Details", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String CoinName=ForCoinName.getText().trim();
            float NumCoin=Float.parseFloat(ForNumCoin.getText().trim());
            try {
                if((CoinName.equals("bitcoin") && NumCoin*1500<=retrievedAmount) || (CoinName.equals("etherium") && NumCoin*1000<=retrievedAmount) ||(CoinName.equals("ripple") && NumCoin*1200<=retrievedAmount)){
                    BuyDigitalCoin(CoinName,NumCoin,retrievedName);
                }
                else if(!CoinName.equals("bitcoin")&& NumCoin*1500<=retrievedAmount || !CoinName.equals("etherium")&& NumCoin*1000<=retrievedAmount || CoinName.equals("ripple")&& NumCoin*1200<=retrievedAmount){
                        JOptionPane.showMessageDialog(this, "Enter Correct coin Name");
                }
                else{
                    JOptionPane.showMessageDialog(this, "Not Engough money");
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }//GEN-LAST:event_jButton39ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        RecieverName=jTextField12.getText().trim();
        Float SendCoin=Float.parseFloat(jTextField13.getText());
        String CoinSelection=(String)jComboBox1.getSelectedItem();
        try {
            //Transaction(RecieverName,SendCoin,retrievedName,CoinSelection);
            Transaction(retrievedName,RecieverName,SendCoin,CoinSelection);
        } catch (Exception ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        finally{
           jTextField12.setText("");
           jTextField13.setText("");
           
        }
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        
        jTextField12.setText("");
        jTextField13.setText("");
        jTabbedPane1.setSelectedIndex(13);
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton40ActionPerformed
        jTabbedPane1.setSelectedIndex(4);
    }//GEN-LAST:event_jButton40ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        jTabbedPane1.setSelectedIndex(13);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton38ActionPerformed
        showblockchain();
        jTabbedPane1.setSelectedIndex(9);
    }//GEN-LAST:event_jButton38ActionPerformed

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
        jTabbedPane1.setSelectedIndex(4);
    }//GEN-LAST:event_jButton37ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
            jTextField3.setText("");
            jTextField4.setText("");
            jTextField5.setText("");
        jTabbedPane1.setSelectedIndex(13);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        try{
            if(!jTextField3.getText().trim().isEmpty() && !jTextField4.getText().trim().isEmpty() && jTextField5.getText().trim().equals("Joining MnM block chain platform")){
                jTabbedPane1.setSelectedIndex(8);
            }
            else{
                JOptionPane.showMessageDialog(this, "Enter correct Information");
            }
        }
        
        finally{
            jTextField3.setText("");
            jTextField4.setText("");
            jTextField5.setText("");
        }
        
        
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        jTextField8.setText("");
        jTabbedPane1.setSelectedIndex(5); 
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        boolean isClick1=false;
        if(jTextField7.getText().trim().equals("MNM{17}")){
            try {
                createBlock();
                JOptionPane.showMessageDialog(this, "Congratulation for creating your own chain");
                isClick1=true;
                jTabbedPane1.setSelectedIndex(13);
            } catch (Exception ex) {
                Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        else
        {
            JOptionPane.showMessageDialog(this, "Answer is not correct we cannot procceed");
        }
        
        jTextField7.setText("");
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed

        try {
            checkchain();
        } catch (SQLException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
        jTextField8.setText("");
        }
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed

    String store = jTextField6.getText().trim();
    String Transaction = String.valueOf(retrievedTransaction);

    if (store.equals("MNM{73/5}") || store.equals("MNM{14.7}")) {
        try {
            Block_Creation firstBlock = new Block_Creation(0, "Initial Data");
            Block_Creation newBlock = new Block_Creation(1, Transaction);
            newBlock.addToBlockTable();
            JOptionPane.showMessageDialog(this, "Congratulations for being part of Blockchain");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error creating block: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(); 
        }
    } else {
        JOptionPane.showMessageDialog(this, "Not Proceed due to invalid Answer");   
    }
    
        jTextField6.setText("");
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        jTextField6.setText("");
        jTabbedPane1.setSelectedIndex(9);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            
    bit=1500;
    ripple=1200;
    eth=1000;
    
    retrievedName = "";
    retrievedAmount =0;
    retrievedbit = 0;
    retrievedripple = 0;
    retrievedetherium = 0;
    retrievedTransaction =0;
    retrievedPassword="";
    RecieverName="";
    chainname="";
    chainname1 = "";
    SignupFullname="";
    
    isclick=false;
    
    changingBit=0;
    changingRipple=0;
    changingetherium=0;
    lastChangeTime=0;

    jTextField1.setText("");
    jTextField10.setText("");
    jTextField12.setText("");
    jTextField13.setText("");
    jTextField17.setText("");
    jTextField3.setText("");
    jTextField4.setText("");
    jTextField5.setText("");
    jTextField6.setText("");
    jTextField7.setText("");
    jTextField8.setText("");
    jTextField9.setText("");

    jLabel73.setText("");
    jLabel72.setText("");
    jLabel75.setText("");
    jLabel79.setText("");
    jLabel82.setText("");
    jLabel77.setText("");
    
    jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        jTextField7.setText("");
         jTabbedPane1.setSelectedIndex(4); 
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        try {
            refresh();
        } catch (Exception ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        
        if (!clicked || (System.currentTimeMillis() - lastClickTime) >= 300000) {
            try {
                CurrenyWithTime();
            } catch (SQLException ex) {
                Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
            }
            clicked = true;
            lastClickTime = System.currentTimeMillis();
        } else {
            JOptionPane.showMessageDialog(this,"Wait for five minutes before clicking again.");
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        
        String query = "SELECT * FROM currencywithtime ORDER BY Time";
        try {
            ps=c.prepareStatement(query);
            rs=ps.executeQuery();
            
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            //StringBuilder outputToLedger = new StringBuilder("<html>");
            while(rs.next()){
                String Time = rs.getString("Time");
                String bitcoinPrice=rs.getString("bitcoin");
                String EtheriumPrice=rs.getString("etherium");
                String RipplePrice=rs.getString("ripple");
                //  outputToLedger.append(rowText);
                model.addRow(new Object[]{Time, bitcoinPrice,EtheriumPrice,RipplePrice});
            }
            //outputToLedger.append("</html>");
            //jLabel81.setText(outputToLedger.toString());
        } catch (SQLException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
         }
                
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        jTabbedPane1.setSelectedIndex(13);
    }//GEN-LAST:event_jButton17ActionPerformed
    
    
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainApp().setVisible(true);
            }
        });
    }
    
    private void showblockchain(){
    String query = "SELECT Name FROM existingblockchain";
        try{
            ps=c.prepareStatement(query);
            rs=ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
            model.setRowCount(0);
            while(rs.next()){
            
             String rowText =rs.getString("Name");
                         
                model.addRow(new Object[]{rowText});

            }
        } catch (SQLException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }
    
    String checkchain() throws SQLException{
        String query = "SELECT Name FROM existingblockchain";
        chainname=jTextField8.getText().trim();
        boolean chainexist=false;
        ps=c.prepareStatement(query);
            rs=ps.executeQuery();
            while(rs.next()){
            if(chainname.equals(rs.getString("Name"))){
                    chainexist=true;
            }
            }
            if(chainexist){
                 jTabbedPane1.setSelectedIndex(6);
                 chainname1=chainname;
                 return chainname; 
            }
            else{
                JOptionPane.showMessageDialog(this, "No such chain exist");
                return null;
            } 
    }
    
    private void createBlock() throws SQLException, Exception {
        String tableName = jTextField4.getText().trim();
        String data = String.valueOf(retrievedTransaction);
        
        if(!isValidTableName(tableName)){
            throw new IllegalArgumentException("Invalid table name.");
        }
        String createTableQuery = "CREATE TABLE IF NOT EXISTS `" + tableName + "` (id VARCHAR(250), TimeStamp VARCHAR(250), hash VARCHAR(250), previousHash VARCHAR(250), data VARCHAR(250))";

      c.prepareStatement(createTableQuery).executeUpdate();
        String insertQuery = "INSERT INTO `" + tableName + "` (id, TimeStamp, hash, previousHash, data) VALUES (?, ?, ?, ?, ?)";


      ps = c.prepareStatement(insertQuery);
        ps.setString(1, "1");
        ps.setString(2, getExtractTime());
        ps.setString(3, getHash(data));
        ps.setString(4, "Genesis Block");
        ps.setString(5, data);
        ps.executeUpdate();

        String insertBlockchainQuery = "INSERT INTO existingblockchain (Name) VALUES (?)";
        ps = c.prepareStatement(insertBlockchainQuery);
        ps.setString(1, tableName);
        ps.executeUpdate();
    }
    
    private boolean isValidTableName(String tableName) {
        return tableName.matches("^[a-zA-Z0-9_]+$");
    }
    
    private void refresh() throws Exception{
        
        String SearchQuery ="SELECT * FROM account WHERE name =? ";
        String SearchQuery2="SELECT Sender, Reciever from publicledger";
        
        PreparedStatement ps = c.prepareStatement(SearchQuery);
        ps.setString(1,retrievedName.trim());
        rs=ps.executeQuery();
        if(rs.next()){
                 retrievedName = rs.getString("name");
                 retrievedAmount = rs.getInt("dollars");
                 retrievedbit = rs.getFloat("bitcoin");
                 retrievedripple = rs.getFloat("ripple");
                 retrievedetherium = rs.getFloat("etherium");
                 retrievedTransaction = rs.getInt("Transaction");

                 jLabel12.setText(retrievedName);
                 jLabel82.setText(String.valueOf(retrievedbit));
                 jLabel72.setText(String.valueOf(retrievedAmount));

                 jLabel77.setText(String.valueOf(retrievedripple));
                 jLabel79.setText(String.valueOf(retrievedetherium));
                 jLabel75.setText(String.valueOf(retrievedTransaction));

    }
        PreparedStatement ps2 = c.prepareStatement(SearchQuery);
        
        ResultSet rs2 = ps2.executeQuery();
        
        while (rs2.next()) {
        String sender = rs2.getString("Sender");
        String receiver = rs2.getString("Receiver");
        
        // Handle sender and receiver data, e.g., print or update UI
        System.out.println("Sender: " + sender + ", Receiver: " + receiver);
        // You can also update UI components here if needed
        }
    }
    private void Sellcoin(String SellCoinType, String PasswordSeller, float SellNumCoin) throws Exception {
        String searchQuery = "SELECT * FROM account WHERE password = ?";
        String updateQuery = "UPDATE account SET " + SellCoinType + " = " + SellCoinType + " - ?, dollars = dollars + ? WHERE password = ?";

        PreparedStatement ps = c.prepareStatement(searchQuery);
        ps.setString(1, PasswordSeller.trim());
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            float currentCoins = rs.getFloat(SellCoinType);
            float coinValue = 0;

            if (SellCoinType.equals("bitcoin")) {
                coinValue = SellNumCoin * changingBit;
            } else if (SellCoinType.equals("ripple")) {
                coinValue = SellNumCoin * changingRipple;
            } else if (SellCoinType.equals("ethereum")) {
                coinValue = SellNumCoin * changingetherium;
            } else {
                JOptionPane.showMessageDialog(this, "Select a valid coin type");
                return;
            }

            if (currentCoins- SellNumCoin>=-0.0001) {
                // Update coins and dollars
                ps = c.prepareStatement(updateQuery);
                ps.setFloat(1, SellNumCoin);
                ps.setFloat(2, coinValue);
                ps.setString(3, PasswordSeller.trim());
                ps.executeUpdate();

                JOptionPane.showMessageDialog(this, "Coins sold successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Insufficient coins to sell");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Incorrect password or no such user exists");
        }
    }
    
    private boolean saveToDatabase(String username, String password)throws Exception {
     //   Class.forName("com.mysql.cj.jdbc.Driver"); 
            c = DriverManager.getConnection(URL, username1, password1);
            if (accountExists(username)) {
            JOptionPane.showMessageDialog(this, "Account with the same name already exists.");
            return true;
        } else {
            String insertQuery = "INSERT INTO account (name, password) VALUES (?, ?)";
            ps = c.prepareStatement(insertQuery);
            ps.setString(1, username);
            ps.setString(2, password); 

           int status = ps.executeUpdate();
                if (status != 0) {
                        jTabbedPane1.setSelectedIndex(13);
            } else {
                JOptionPane.showMessageDialog(this, "Error while signing up. Please try again.");
            } 

            return false;
        }

    }
    
    private boolean accountExists(String username) throws SQLException {
        String checkQuery = "SELECT COUNT(*) AS count FROM account WHERE name = ?";
        try (PreparedStatement checkStatement = c.prepareStatement(checkQuery)) {
            checkStatement.setString(1, username);
            try (ResultSet resultSet = checkStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt("count");
                    return count > 0;
                }
            }
        }
        return false;
    }
    private void SearchForLogin(String name2, String password2) throws Exception{
       // Class.forName("com.mysql.cj.jdbc.Driver");
        c = DriverManager.getConnection(URL, username1, password1);
        String name="";
        String SearchQuery ="SELECT*FROM account WHERE name =? AND password =?";
        PreparedStatement ps = c.prepareStatement(SearchQuery);
        ps.setString(1,name2.trim());
        ps.setString(2,password2.trim());

        rs=ps.executeQuery();
        if(rs.next()){
                 retrievedName = rs.getString("name");
                 retrievedAmount = rs.getInt("dollars");
                 retrievedbit = rs.getFloat("bitcoin");
                 retrievedripple = rs.getFloat("ripple");
                 retrievedetherium = rs.getFloat("etherium");
                 retrievedTransaction = rs.getInt("Transaction");
                 retrievedPassword = rs.getString("password");

                jTabbedPane1.setSelectedIndex(13);
            }
        else {
            JOptionPane.showMessageDialog(this, "Incorrect - No matching records found");
        }

    }
    
    private void retrieveData(){
        jLabel73.setText(String.valueOf(retrievedName));
        jLabel82.setText(String.valueOf(retrievedbit)); 
        jLabel72.setText(String.valueOf(retrievedAmount));
        jLabel75.setText(String.valueOf(retrievedTransaction));
        jLabel79.setText(String.valueOf(retrievedetherium));
        jLabel77.setText(String.valueOf(retrievedripple));
    }
    
    private void NumTransaction(int TransCount,String retrievedName) {

       if (retrievedTransaction>=3) {
            jTabbedPane1.setSelectedIndex(5);
        } else {
            JOptionPane.showMessageDialog(this,"Make Atleast three transaction to start blochchain.");
        }
    }
    public void CurrenyWithTime() throws SQLException, ParseException{
        Random R=new Random();
        Timer t=new Timer();
        TimerTask task = new TimerTask() {
                @Override
            public void run() {
                            float bitcoin = R.nextFloat(10000-100)+100;
            float ripple = R.nextFloat(10000-100)+100;
            float etherium = R.nextFloat(10000-100)+100;
            if (changingRipple !=ripple ||changingetherium !=etherium || changingBit !=bitcoin) {
                changingRipple=ripple;
                changingetherium=etherium;
                changingBit=bitcoin;
                lastChangeTime = System.currentTimeMillis();
                }
            }
        };      

        t.scheduleAtFixedRate(task, 0, 30000);
        String insertQuery = "INSERT INTO currencywithtime (Time, bitcoin, etherium, ripple) VALUES (?, ?, ?, ?)";
        ps=c.prepareStatement(insertQuery);

        String time = getExtractTime();


        ps.setString(1, time);
        ps.setFloat(2, changingBit);
        ps.setFloat(3, changingetherium);
        ps.setFloat(4, changingRipple);
        ps.executeUpdate();

        jLabel86.setText(String.valueOf(changingBit));
        jLabel88.setText(String.valueOf(changingRipple));
        jLabel87.setText(String.valueOf(changingetherium));
    }

    public String getExtractTime(){
        LocalDateTime currentTime=LocalDateTime.now();
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss.SSS");
        String Time=currentTime.format(dtf);
        return Time;
    }
    
    private String getHash(String Data) throws Exception{
        String OriginalData="1"+getExtractTime()+"GenesisBlock"+Data;
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
        byte[] hash = messageDigest.digest(OriginalData.getBytes());
        return Base64.getEncoder().encodeToString(hash);
    }
    private void BuyDigitalCoin(String CoinName,float NumCoin,String retrievedName ) throws ClassNotFoundException, SQLException{
    c = DriverManager.getConnection(URL, username1, password1);
      
      float value=0;
      if(CoinName.equals("bitcoin")){
            value=NumCoin*bit;
           String SearchQuery ="UPDATE account SET dollars = dollars - ?,bitcoin= bitcoin + ? WHERE name = ?";
               PreparedStatement ps = c.prepareStatement(SearchQuery);
               ps.setFloat(1, value); 
               ps.setFloat(2,NumCoin); 
                ps.setString(3, retrievedName);
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(this,"Bitcoin purchase successful");
             String SearchQuery2 = "SELECT * FROM account WHERE name = ?";
    PreparedStatement ps2 = c.prepareStatement(SearchQuery2);
    ps2.setString(1, retrievedName);
    
    ResultSet rs = ps2.executeQuery();
    if (rs.next()) {
        // Fetch and display the account details from the result set
        String accountDetails = "Name: " + rs.getString("name") + 
                                "\nDollars: " + rs.getInt("dollars") + 
                                "\nBitcoin: " + rs.getFloat("bitcoin");
        
            
    }
        } else {
            JOptionPane.showMessageDialog(this,"Bitcoin purchase failed. Check your input .");
        }
       }
      
      else if(CoinName.equals("etherium")){
           value=NumCoin*eth;
         String SearchQuery ="UPDATE account SET dollars = dollars - ?,etherium= etherium + ? WHERE name = ?";
             PreparedStatement ps = c.prepareStatement(SearchQuery);

                ps.setFloat(1, value); 
               ps.setFloat(2,NumCoin); 
                ps.setString(3, retrievedName);
             int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(this,"etherium purchase successful");
        } else {
            JOptionPane.showMessageDialog(this,"etherium purchase failed. Check your input");
        }
       }
       
      else if(CoinName.equals("ripple")){
           value=NumCoin*ripple;
           String SearchQuery ="UPDATE account SET dollars = dollars - ?,ripple = ripple + ? WHERE name = ?";
               PreparedStatement ps = c.prepareStatement(SearchQuery);
                ps.setFloat(1, value); 
               ps.setFloat(2,NumCoin); 
                ps.setString(3, retrievedName);
               int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    
            JOptionPane.showMessageDialog(this,"ripple purchase successful.");
        } else {
            JOptionPane.showMessageDialog(this,"ripple purchase failed. Check your input.");
        }
       }
      
       else{
       JOptionPane.showMessageDialog(this, "Select from:\nbitcoin\nnetherium\nripple ");
       }
    }
    
    private void Transaction(String senderName, String receiverName, float sendAmount, String coinSelection) throws Exception {
        String senderQuery = "UPDATE account SET %s = %s - ?, Transaction = Transaction + 1 WHERE name = ?";
        String receiverQuery = "UPDATE account SET %s = %s + ? WHERE name = ?";

        String coinColumn = "";
        switch (coinSelection) {
            case "bitcoin":
                coinColumn = "bitcoin";
                break;
            case "etherium":
                coinColumn = "etherium";
                break;
            case "ripple":
                coinColumn = "ripple";
                break;
            default:
                JOptionPane.showMessageDialog(this, "Select from:\nbitcoin\netherium\nripple");
                return;
        }

        float senderBalance = getCoinBalance(senderName, coinColumn);
        if (senderBalance < sendAmount) {
            JOptionPane.showMessageDialog(this, "Not enough " + coinSelection + " to transfer.");
            return;
        }

        try {
            String FsenderQuery = String.format(senderQuery, coinColumn, coinColumn);
            String FreceiverQuery = String.format(receiverQuery, coinColumn, coinColumn);

            PreparedStatement senderPs = c.prepareStatement(FsenderQuery);
            senderPs.setFloat(1, sendAmount);
            senderPs.setString(2, senderName);
            int senderRowsAffected = senderPs.executeUpdate();

            PreparedStatement receiverPs = c.prepareStatement(FreceiverQuery);
            receiverPs.setFloat(1, sendAmount);
            receiverPs.setString(2, receiverName);
            int receiverRowsAffected = receiverPs.executeUpdate();

            if (senderRowsAffected > 0 && receiverRowsAffected > 0) {
                JOptionPane.showMessageDialog(this, coinSelection + " transfer successful");
                  SaveToLedger();
            } else {
                JOptionPane.showMessageDialog(this, coinSelection + " transfer failed. Check your input.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred during the transaction.");
        }

      
    }
    
    protected String Getretrievedname(){
         return retrievedName;
    }
    protected int GetretrievedTransaction(){
        return retrievedTransaction;
    }
    
    private void SaveToLedger() throws Exception{
      String insertQuery = "INSERT INTO ledger (Sender,Reciever) VALUES (?, ?)";
      ps = c.prepareStatement(insertQuery);
      ps.setString(1, retrievedName);
      ps.setString(2, RecieverName);
      ps.executeUpdate();
      EncryptedLedger();
    }  
    
    private void EncryptedLedger() throws NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException, SQLException{

    String insertQuery = "INSERT INTO Publicledger (Sender,Reciever) VALUES (?, ?)";
            
            String Sender=retrievedName;
            String Reciever=RecieverName;
            KeyGenerator kg=KeyGenerator.getInstance("AES");
            kg.init(128);
            SecretKey sk=kg.generateKey();
            Cipher cip=Cipher.getInstance("AES");
            cip.init(cip.ENCRYPT_MODE, sk);
            byte[] encSender=cip.doFinal(Sender.getBytes());
            byte[] encReciever=cip.doFinal(Reciever.getBytes());
            
            String base64encSender = Base64.getEncoder().encodeToString(encSender);
            String base64encReciever = Base64.getEncoder().encodeToString(encReciever);
            
            ps = c.prepareStatement(insertQuery);
            ps.setString(1, base64encSender);
            ps.setString(2, " send coins to "+base64encReciever);
            ps.executeUpdate();
                
    }
    private float getCoinBalance(String name, String coinColumn) {
        float balance = 0;

        try {
            String query = "SELECT " + coinColumn + " FROM account WHERE name = ?";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                balance = rs.getFloat(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return balance;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel100;
    private javax.swing.JPanel jPanel101;
    private javax.swing.JPanel jPanel102;
    private javax.swing.JPanel jPanel103;
    private javax.swing.JPanel jPanel104;
    private javax.swing.JPanel jPanel105;
    private javax.swing.JPanel jPanel106;
    private javax.swing.JPanel jPanel107;
    private javax.swing.JPanel jPanel108;
    private javax.swing.JPanel jPanel109;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel110;
    private javax.swing.JPanel jPanel111;
    private javax.swing.JPanel jPanel112;
    private javax.swing.JPanel jPanel113;
    private javax.swing.JPanel jPanel114;
    private javax.swing.JPanel jPanel115;
    private javax.swing.JPanel jPanel116;
    private javax.swing.JPanel jPanel117;
    private javax.swing.JPanel jPanel118;
    private javax.swing.JPanel jPanel119;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel120;
    private javax.swing.JPanel jPanel121;
    private javax.swing.JPanel jPanel122;
    private javax.swing.JPanel jPanel123;
    private javax.swing.JPanel jPanel124;
    private javax.swing.JPanel jPanel125;
    private javax.swing.JPanel jPanel126;
    private javax.swing.JPanel jPanel127;
    private javax.swing.JPanel jPanel128;
    private javax.swing.JPanel jPanel129;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel130;
    private javax.swing.JPanel jPanel131;
    private javax.swing.JPanel jPanel132;
    private javax.swing.JPanel jPanel133;
    private javax.swing.JPanel jPanel134;
    private javax.swing.JPanel jPanel135;
    private javax.swing.JPanel jPanel136;
    private javax.swing.JPanel jPanel137;
    private javax.swing.JPanel jPanel138;
    private javax.swing.JPanel jPanel139;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel140;
    private javax.swing.JPanel jPanel141;
    private javax.swing.JPanel jPanel142;
    private javax.swing.JPanel jPanel143;
    private javax.swing.JPanel jPanel144;
    private javax.swing.JPanel jPanel145;
    private javax.swing.JPanel jPanel146;
    private javax.swing.JPanel jPanel147;
    private javax.swing.JPanel jPanel148;
    private javax.swing.JPanel jPanel149;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel150;
    private javax.swing.JPanel jPanel151;
    private javax.swing.JPanel jPanel152;
    private javax.swing.JPanel jPanel153;
    private javax.swing.JPanel jPanel154;
    private javax.swing.JPanel jPanel155;
    private javax.swing.JPanel jPanel156;
    private javax.swing.JPanel jPanel157;
    private javax.swing.JPanel jPanel158;
    private javax.swing.JPanel jPanel159;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel160;
    private javax.swing.JPanel jPanel161;
    private javax.swing.JPanel jPanel162;
    private javax.swing.JPanel jPanel163;
    private javax.swing.JPanel jPanel164;
    private javax.swing.JPanel jPanel165;
    private javax.swing.JPanel jPanel166;
    private javax.swing.JPanel jPanel167;
    private javax.swing.JPanel jPanel168;
    private javax.swing.JPanel jPanel169;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel170;
    private javax.swing.JPanel jPanel171;
    private javax.swing.JPanel jPanel172;
    private javax.swing.JPanel jPanel173;
    private javax.swing.JPanel jPanel174;
    private javax.swing.JPanel jPanel175;
    private javax.swing.JPanel jPanel176;
    private javax.swing.JPanel jPanel177;
    private javax.swing.JPanel jPanel178;
    private javax.swing.JPanel jPanel179;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel180;
    private javax.swing.JPanel jPanel181;
    private javax.swing.JPanel jPanel182;
    private javax.swing.JPanel jPanel183;
    private javax.swing.JPanel jPanel184;
    private javax.swing.JPanel jPanel185;
    private javax.swing.JPanel jPanel186;
    private javax.swing.JPanel jPanel187;
    private javax.swing.JPanel jPanel188;
    private javax.swing.JPanel jPanel189;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel190;
    private javax.swing.JPanel jPanel191;
    private javax.swing.JPanel jPanel192;
    private javax.swing.JPanel jPanel193;
    private javax.swing.JPanel jPanel194;
    private javax.swing.JPanel jPanel195;
    private javax.swing.JPanel jPanel196;
    private javax.swing.JPanel jPanel197;
    private javax.swing.JPanel jPanel198;
    private javax.swing.JPanel jPanel199;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel200;
    private javax.swing.JPanel jPanel201;
    private javax.swing.JPanel jPanel202;
    private javax.swing.JPanel jPanel203;
    private javax.swing.JPanel jPanel204;
    private javax.swing.JPanel jPanel205;
    private javax.swing.JPanel jPanel206;
    private javax.swing.JPanel jPanel207;
    private javax.swing.JPanel jPanel208;
    private javax.swing.JPanel jPanel209;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel210;
    private javax.swing.JPanel jPanel211;
    private javax.swing.JPanel jPanel212;
    private javax.swing.JPanel jPanel213;
    private javax.swing.JPanel jPanel214;
    private javax.swing.JPanel jPanel215;
    private javax.swing.JPanel jPanel216;
    private javax.swing.JPanel jPanel217;
    private javax.swing.JPanel jPanel218;
    private javax.swing.JPanel jPanel219;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel220;
    private javax.swing.JPanel jPanel221;
    private javax.swing.JPanel jPanel222;
    private javax.swing.JPanel jPanel223;
    private javax.swing.JPanel jPanel224;
    private javax.swing.JPanel jPanel225;
    private javax.swing.JPanel jPanel226;
    private javax.swing.JPanel jPanel227;
    private javax.swing.JPanel jPanel228;
    private javax.swing.JPanel jPanel229;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel230;
    private javax.swing.JPanel jPanel231;
    private javax.swing.JPanel jPanel232;
    private javax.swing.JPanel jPanel233;
    private javax.swing.JPanel jPanel234;
    private javax.swing.JPanel jPanel235;
    private javax.swing.JPanel jPanel236;
    private javax.swing.JPanel jPanel237;
    private javax.swing.JPanel jPanel238;
    private javax.swing.JPanel jPanel239;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel240;
    private javax.swing.JPanel jPanel241;
    private javax.swing.JPanel jPanel242;
    private javax.swing.JPanel jPanel243;
    private javax.swing.JPanel jPanel244;
    private javax.swing.JPanel jPanel245;
    private javax.swing.JPanel jPanel246;
    private javax.swing.JPanel jPanel247;
    private javax.swing.JPanel jPanel248;
    private javax.swing.JPanel jPanel249;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel250;
    private javax.swing.JPanel jPanel251;
    private javax.swing.JPanel jPanel252;
    private javax.swing.JPanel jPanel253;
    private javax.swing.JPanel jPanel254;
    private javax.swing.JPanel jPanel255;
    private javax.swing.JPanel jPanel256;
    private javax.swing.JPanel jPanel257;
    private javax.swing.JPanel jPanel258;
    private javax.swing.JPanel jPanel259;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel260;
    private javax.swing.JPanel jPanel261;
    private javax.swing.JPanel jPanel262;
    private javax.swing.JPanel jPanel263;
    private javax.swing.JPanel jPanel264;
    private javax.swing.JPanel jPanel265;
    private javax.swing.JPanel jPanel266;
    private javax.swing.JPanel jPanel267;
    private javax.swing.JPanel jPanel268;
    private javax.swing.JPanel jPanel269;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel270;
    private javax.swing.JPanel jPanel271;
    private javax.swing.JPanel jPanel272;
    private javax.swing.JPanel jPanel273;
    private javax.swing.JPanel jPanel274;
    private javax.swing.JPanel jPanel275;
    private javax.swing.JPanel jPanel276;
    private javax.swing.JPanel jPanel277;
    private javax.swing.JPanel jPanel278;
    private javax.swing.JPanel jPanel279;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel280;
    private javax.swing.JPanel jPanel281;
    private javax.swing.JPanel jPanel282;
    private javax.swing.JPanel jPanel283;
    private javax.swing.JPanel jPanel284;
    private javax.swing.JPanel jPanel285;
    private javax.swing.JPanel jPanel286;
    private javax.swing.JPanel jPanel287;
    private javax.swing.JPanel jPanel288;
    private javax.swing.JPanel jPanel289;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel290;
    private javax.swing.JPanel jPanel291;
    private javax.swing.JPanel jPanel292;
    private javax.swing.JPanel jPanel293;
    private javax.swing.JPanel jPanel294;
    private javax.swing.JPanel jPanel295;
    private javax.swing.JPanel jPanel296;
    private javax.swing.JPanel jPanel297;
    private javax.swing.JPanel jPanel298;
    private javax.swing.JPanel jPanel299;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel300;
    private javax.swing.JPanel jPanel301;
    private javax.swing.JPanel jPanel302;
    private javax.swing.JPanel jPanel303;
    private javax.swing.JPanel jPanel304;
    private javax.swing.JPanel jPanel305;
    private javax.swing.JPanel jPanel306;
    private javax.swing.JPanel jPanel307;
    private javax.swing.JPanel jPanel308;
    private javax.swing.JPanel jPanel309;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel310;
    private javax.swing.JPanel jPanel311;
    private javax.swing.JPanel jPanel312;
    private javax.swing.JPanel jPanel313;
    private javax.swing.JPanel jPanel314;
    private javax.swing.JPanel jPanel315;
    private javax.swing.JPanel jPanel316;
    private javax.swing.JPanel jPanel317;
    private javax.swing.JPanel jPanel318;
    private javax.swing.JPanel jPanel319;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel320;
    private javax.swing.JPanel jPanel321;
    private javax.swing.JPanel jPanel322;
    private javax.swing.JPanel jPanel323;
    private javax.swing.JPanel jPanel324;
    private javax.swing.JPanel jPanel325;
    private javax.swing.JPanel jPanel326;
    private javax.swing.JPanel jPanel327;
    private javax.swing.JPanel jPanel328;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel60;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JPanel jPanel62;
    private javax.swing.JPanel jPanel63;
    private javax.swing.JPanel jPanel64;
    private javax.swing.JPanel jPanel65;
    private javax.swing.JPanel jPanel66;
    private javax.swing.JPanel jPanel67;
    private javax.swing.JPanel jPanel68;
    private javax.swing.JPanel jPanel69;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel70;
    private javax.swing.JPanel jPanel71;
    private javax.swing.JPanel jPanel72;
    private javax.swing.JPanel jPanel73;
    private javax.swing.JPanel jPanel74;
    private javax.swing.JPanel jPanel75;
    private javax.swing.JPanel jPanel76;
    private javax.swing.JPanel jPanel77;
    private javax.swing.JPanel jPanel78;
    private javax.swing.JPanel jPanel79;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel80;
    private javax.swing.JPanel jPanel81;
    private javax.swing.JPanel jPanel82;
    private javax.swing.JPanel jPanel83;
    private javax.swing.JPanel jPanel84;
    private javax.swing.JPanel jPanel85;
    private javax.swing.JPanel jPanel86;
    private javax.swing.JPanel jPanel87;
    private javax.swing.JPanel jPanel88;
    private javax.swing.JPanel jPanel89;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanel90;
    private javax.swing.JPanel jPanel91;
    private javax.swing.JPanel jPanel92;
    private javax.swing.JPanel jPanel93;
    private javax.swing.JPanel jPanel94;
    private javax.swing.JPanel jPanel95;
    private javax.swing.JPanel jPanel96;
    private javax.swing.JPanel jPanel97;
    private javax.swing.JPanel jPanel98;
    private javax.swing.JPanel jPanel99;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JPasswordField jPasswordField3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
