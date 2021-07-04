/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolab3;

/**
 *
 * @author bayram
 */
public class KullanıcıBilgileri { 
     static String Email,KullanıcıAdı,Dogumtarihi;
    
    public KullanıcıBilgileri(String Email){
            //  super(Email,KullanıcıAdı,Dogumtarihi);
              KullanıcıBilgileri.Email=Email;             
    }
    public  KullanıcıBilgileri(){
        
    }

    public static String getEmail() {
        return Email;
    }

    public static void setEmail(String Email) {
        KullanıcıBilgileri.Email = Email;
    }

    public static String getKullanıcıAdı() {
        return KullanıcıAdı;
    }

    public static void setKullanıcıAdı(String KullanıcıAdı) {
        KullanıcıBilgileri.KullanıcıAdı = KullanıcıAdı;
    }

    public static String getDogumtarihi() {
        return Dogumtarihi;
    }

    public static  void setDogumtarihi(String Dogumtarihi) {
        KullanıcıBilgileri.Dogumtarihi = Dogumtarihi;
    }
    
}
