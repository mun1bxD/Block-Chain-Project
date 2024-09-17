package blockchainproject;

import static blockchainproject.MainApp.chainname1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Block_Creation {

    private int index;
    private long timeStamp;
    private String blockHash;
    private String previousHash;
    private String data;
    private static Block_Creation firstBlock;
    private static Block_Creation head;
    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private boolean isClick = false;
    private Block_Creation inst;
    static String URL = "jdbc:mysql://localhost:3306/";
    static String dbName = "blockchainproject"; 
    static String username = "root";
    static String password = "";
    private MainApp b;
    String BlockChainName="";
    public Block_Creation(int index, String data) throws NoSuchAlgorithmException, ClassNotFoundException, SQLException {
        this.b = new MainApp();
        this.data = data;
        this.index = index;
        this.data = String.valueOf(b.GetretrievedTransaction());
        this.previousHash =getPreviousHash();
        this.BlockChainName=chainname1;
        this.blockHash =calculateHash(data);
      

    }
   
    public int getIndex() throws Exception {
       // return index;
       Class.forName("com.mysql.cj.jdbc.Driver");
    connection = DriverManager.getConnection(URL + dbName, username, password);
    
    String id = "select max(id) as id from "+BlockChainName;
    int id1=0;
    try (PreparedStatement preparedStatement = connection.prepareStatement(id);
         ResultSet resultSet = preparedStatement.executeQuery()) {
        String previousHash = "";
        if (resultSet.next()) {
            id = resultSet.getString("id");
            id1=Integer.parseInt(id);
        }
        return id1+1;
     
    }
    
    
    }
    
    
    
    public long getTimeStamp() {
        return timeStamp;
    }

    public String getBlockHash() {
        return blockHash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public String getData() {
        return data;
    }

    public static Block_Creation getHead() {
        return head;
    }
    

public String getPreviousHash1() throws Exception {
    Class.forName("com.mysql.cj.jdbc.Driver");
    connection = DriverManager.getConnection(URL + dbName, username, password);
  String takePreviousHash = "SELECT hash FROM `" + BlockChainName + "` ORDER BY id DESC LIMIT 1;";
  
  try (PreparedStatement preparedStatement = connection.prepareStatement(takePreviousHash);
         ResultSet resultSet = preparedStatement.executeQuery()) {
        String previousHash = "";
        if (resultSet.next()) {
            previousHash = resultSet.getString("hash");
        }
        return previousHash;
    } 
}

    private String calculateHash(String data) throws NoSuchAlgorithmException {
        this.data = data;
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
        byte[] hash = messageDigest.digest(data.getBytes());
        return Base64.getEncoder().encodeToString(hash);
    }

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL + dbName, username, password);
             firstBlock = new Block_Creation(0, "Initial Data");
            head = firstBlock;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Block_Creation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Block_Creation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addToBlockTable() throws Exception {
      String insertQuery = "INSERT INTO "+BlockChainName+" (id, timeStamp, hash, previousHash, data) VALUES (?, ?, ?, ?, ?)";
    try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
        String previousHash = getPreviousHash1();
        preparedStatement.setInt(1,head.getIndex());
        preparedStatement.setString(2,getExtractTime());
        preparedStatement.setString(3, blockHash);
        preparedStatement.setString(4, previousHash);
        preparedStatement.setString(5, data);
        preparedStatement.executeUpdate();
        isClick = true;
    }
}
    public String getExtractTime() {
    LocalDateTime currentTime=LocalDateTime.now();
    DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss.SSS");
    String Time=currentTime.format(dtf);
    return Time;
}
    
}
