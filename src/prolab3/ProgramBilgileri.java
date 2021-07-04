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
public class ProgramBilgileri {
    
   static String ProgramAdı,Tür;
   static String uzunluk;
   static int bölüm;
   static String izlemesüresi;

    public static String getIzlemesüresi() {
        return izlemesüresi;
    }

    public static void setIzlemesüresi(String izlemesüresi) {
        ProgramBilgileri.izlemesüresi = izlemesüresi;
    }

    public static int getBölüm() {
        return bölüm;
    }

    public static void setBölüm(int bölüm) {
        ProgramBilgileri.bölüm = bölüm;
    }
  

    public static String getTür() {
        return Tür;
    }

    public static void setTür(String Tür) {
        ProgramBilgileri.Tür = Tür;
    }

    public static String getUzunluk() {
        return uzunluk;
    }

    public static void setUzunluk(String uzunluk) {
        ProgramBilgileri.uzunluk = uzunluk;
    }
    public ProgramBilgileri(String ProgramAdı){
       ProgramBilgileri.ProgramAdı=ProgramAdı;
    }
    public ProgramBilgileri(){
        
    }

    static public String getProgramAdı() {
        return ProgramAdı;
    }

    static public void setProgramAdı(String ProgramAdı) {
        ProgramBilgileri.ProgramAdı = ProgramAdı;
    }
    
}
