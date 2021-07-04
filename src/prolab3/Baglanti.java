/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolab3;

import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bayram
 */
public class Baglanti {
   static Connection myConn;
       static     Statement myStat;
       
    static ResultSet yap() {
        ResultSet myRs=null;
        try {
            myConn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/netflixveritabani","root","555666");
                  myStat=(Statement)myConn.createStatement();
                  myRs= myStat.executeQuery("select * from kullanıcılar");
                  
        } catch (Exception e) {
                        e.printStackTrace();           
        }
        return myRs;
    }
    static void ekle(String sqlsorgu){
        try {
            myStat.executeUpdate(sqlsorgu);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    static String emailara(String girilen) {
        ResultSet myRs=null;
        String sifre="0";
        try {
            myConn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/netflixveritabani","root","555666");
                  myStat=(Statement)myConn.createStatement();
                  myRs= myStat.executeQuery("select * from kullanıcılar");
                  while(myRs.next()){
                      if(girilen.compareTo(myRs.getString("kullanıcıemail"))==0){
                          sifre=myRs.getString("kullanıcısifre");
                          break;
                      }
                  }
        } catch (Exception e) {
                        e.printStackTrace();           
        }
        return sifre;
    }
static boolean kayıt(String email){
    ResultSet myRs=null;
        try {
            myConn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/netflixveritabani","root","555666");
                  myStat=(Statement)myConn.createStatement();
                  myRs= myStat.executeQuery("select * from kullanıcılar");
                  while(myRs.next()){                      
                      if(email.compareTo(myRs.getNString("kullanıcıemail"))==0){
                          return false;
                      }
                  }
        } catch (Exception e) {
                        e.printStackTrace();           
        }
    return true;    
}

static String kullanıcıadıgönder(String girilen) {
        ResultSet myRs=null;
        String kullanıcıadı="0";
        try {
            myConn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/netflixveritabani","root","555666");
                  myStat=(Statement)myConn.createStatement();
                  myRs= myStat.executeQuery("select * from kullanıcılar");
                  while(myRs.next()){
                      if(girilen.compareTo(myRs.getString("kullanıcıemail"))==0){
                          kullanıcıadı=myRs.getString("kullanıcıadı");
                          break;
                      }
                  }
        } catch (Exception e) {
                        e.printStackTrace();           
        }
        return kullanıcıadı;
    }
static String dogumtarihigönder(String girilen) {
        ResultSet myRs=null;
        String dogumtarihi="0";
        try {
            myConn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/netflixveritabani","root","555666");
                  myStat=(Statement)myConn.createStatement();
                  myRs= myStat.executeQuery("select * from kullanıcılar");
                  while(myRs.next()){
                      if(girilen.compareTo(myRs.getString("kullanıcıemail"))==0){
                          dogumtarihi=myRs.getString("kullanıcıdogumtarihi");
                          break;
                      }
                  }
        } catch (Exception e) {
                        e.printStackTrace();           
        }
        return dogumtarihi;
    }


static ResultSet ismegöresorgula(String sqlsorgu) {
    ResultSet myRs=null;
    try {          
           myRs=myStat.executeQuery(sqlsorgu);           
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return myRs;
    }
}
