/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolab3;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import static javax.swing.JSplitPane.BOTTOM;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bayram
 */
public class KullanıcıPaneli extends javax.swing.JFrame {
// KullanıcıPaneli a=new KullanıcıPaneli();
    static String Email;
    static int bölüm;
static String ProgramAdı;
       Date now=new Date();
       DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
DefaultTableModel modelim=new DefaultTableModel();
DefaultTableModel modelim1=new DefaultTableModel();
DefaultTableModel bölümmodelim=new DefaultTableModel();
JTable table=new JTable(modelim);
java.util.Timer myTimer=new java.util.Timer();
java.util.Timer newTimer=new java.util.Timer();
TimerTask gorev =new TimerTask() {
 int i,j,k;
                    @Override
                    public void run() {
                           
                           
                                      
                                       
                             i++;
                          if(i==60){
                              i=0;
                              j++;
                          }
                           if(j==60){
                              j=0;
                              k++;
                          }
                    }
             };
Object[] kolonlar={"Program Adı","Program Tipi","Bölüm Sayısı",""};
Object[] satırlar= new Object[4];
Object[] kolonlar1={"Program Adı","Program Tipi","Bölüm Sayısı",""};
Object[] satırlar1= new Object[4];
Object[] bölümkolonlar={"Bölüm",""};
Object[] bölümsatırlar= new Object[1];
/**
     * Creates new form KullanıcıPaneli
     */
    public KullanıcıPaneli() {
       
        initComponents(); 
       
         this.getContentPane().setBackground(Color.darkGray);
         Giris giris=new Giris();
         
     
          Email=KullanıcıBilgileri.getEmail();
    
        jScrollPane1.setVisible(false);
        jPanel3.setVisible(false);
        jPanel1.setVisible(true);
        jPanel5.setVisible(false);
        jPanel4.setVisible(false);
        jPanel8.setVisible(false);
        jPanel9.setVisible(false);
        jLabel18.setVisible(false);
              
    }
    public KullanıcıPaneli(String kalınanprogram,String kalınansüre,int kalınanbölüm) {
       
        initComponents(); 
        KullanıcıBilgileri a=new KullanıcıBilgileri(Email);
     jPanel9.setVisible(false);
    /* String sorgu;
     sorgu="SELECT kullaniciprogramemail,kaldigiprogram,puan FROM kullanıcıprogram where kullaniciprogramemail='"+Email+"'";
         ResultSet myRs1=null;
         myRs1=Baglanti.ismegöresorgula(sorgu);
        try {
            while(myRs1.next()){
                if(kalınanprogram.compareTo(myRs1.getString("kaldigiprogram"))==0&&myRs1.getInt("puan")!=0){
                    jLabel20.setText("Bu Programa Daha Önceden Puan Verdiniz.");
                    jLabel18.setVisible(true);
                    jLabel18.setText("Verdiğiniz Puan"+myRs1.getInt("puan"));
                    jPanel9.setVisible(false);                   
                }
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(KullanıcıPaneli.class.getName()).log(Level.SEVERE, null, ex);
        }*/
     
     
     
     
     this.getContentPane().setBackground(Color.darkGray);
         Giris giris=new Giris();
         ProgramBilgileri.setBölüm(kalınanbölüm);
         int l=0;
         int bas=0,bas2=0;
         int [] basamaksayısı=new int[3];
         char[] ch=new char[kalınansüre.length()];
         for(int i=0;i<kalınansüre.length();i++){          
             bas++;
             if(kalınansüre.charAt(i)==58){
             basamaksayısı[bas2]=bas-1;
             bas=0;
             bas2++;              
             }
             if(i==kalınansüre.length()-1){
                 basamaksayısı[bas2]=bas;
             }
             
         }
           String i1=kalınansüre.substring(0, basamaksayısı[0]);
           String j1=kalınansüre.substring(basamaksayısı[0]+1, basamaksayısı[0]+basamaksayısı[1]+1);
           String k1=kalınansüre.substring(basamaksayısı[0]+basamaksayısı[1]+2, basamaksayısı[0]+basamaksayısı[1]+basamaksayısı[2]+2);
         
           
         this.i = Integer.parseInt(k1);
         this.j = Integer.parseInt(j1);
         this.k = Integer.parseInt(i1);
     jLabel16.setText(kalınanprogram+"  "+kalınanbölüm+".Bölüm");
          Email=KullanıcıBilgileri.getEmail();
    
        jScrollPane1.setVisible(false);
        jPanel3.setVisible(false);
        jPanel1.setVisible(false);
        jPanel5.setVisible(true);
        jPanel4.setVisible(false);
        jPanel8.setVisible(false);
        ResultSet myRs=null;
        String aranan=(String) jComboBox2.getSelectedItem();
        String sqlsorgu;
        sqlsorgu="SELECT * FROM programlar where programadi ='"+kalınanprogram+"'";
        myRs=Baglanti.ismegöresorgula(sqlsorgu);
       int bölümsayısı;
        
     
    try {
        while(myRs.next()){
            
            satırlar[0]=myRs.getString("programadi");
            String P1=myRs.getString("programadi");
           String süre=myRs.getString("programlaruzunlugu");
            satırlar[1]=myRs.getString("programtürü");
            satırlar[2]=myRs.getString("programtipi");
            satırlar[3]=myRs.getInt("bölümsayısı");
            bölümsayısı=myRs.getInt("bölümsayısı");
            bölüm=bölümsayısı;
        
            
           
             
                   ProgramBilgileri.setProgramAdı(P1);
                   ProgramBilgileri.setUzunluk(süre);
                   jPanel5.setVisible(true);
                    jPanel3.setVisible(false);
                    jTable1.setVisible(false);
                    jButton1.setVisible(true);
          
                 jTable2.setModel(bölümmodelim);
                 bölümmodelim.setColumnIdentifiers(bölümkolonlar);
             
                 
                 int e;
                 int w=0;
                 int q=0;
                for(e=1;e<bölüm+1;e++){
                    
                 int b=e;
                 bölümsatırlar[0]="   "+e+".Bölüm";                
                  JButton buton1=new JButton("İzle");
                  buton1.setBounds(200,5+w*50, 100, 40);             
                  buton1.addActionListener(new ActionListener() {
                @Override
                
                public void actionPerformed(ActionEvent a) {   
                    ProgramBilgileri.setProgramAdı(P1);
                 jLabel16.setText(ProgramBilgileri.getProgramAdı()+"   "+b+".Bölüm");
                 jPanel8.setVisible(false);
                 jPanel9.setVisible(false);
                 jButton1.setVisible(true);
                 ProgramBilgileri.setBölüm(b);
                   
                 
            if(timersayac>0){
                myTimer.cancel();
                timersayac=0;
            }
                 i=00;j=00;k=00;
                 
                }
            }); 
                  jTable2.add(buton1,BOTTOM,0);
                bölümmodelim.addRow(bölümsatırlar);
                w++;
                
                }
       
       
               
           
             
                                    
        
            l++;
        }
    } catch (SQLException ex) {
        Logger.getLogger(KullanıcıPaneli.class.getName()).log(Level.SEVERE, null, ex);
    }
           
                      
    }
    
   
  
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        textField4 = new java.awt.TextField();
        jComboBox3 = new javax.swing.JComboBox<>();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        textField3 = new java.awt.TextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton9 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setForeground(new java.awt.Color(0, 0, 0));
        setMaximumSize(new java.awt.Dimension(1280, 1024));
        setMinimumSize(new java.awt.Dimension(1280, 1024));
        setPreferredSize(new java.awt.Dimension(1280, 1024));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                KullanıcıPaneli.this.windowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setMaximumSize(new java.awt.Dimension(1280, 1024));
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 1024));

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));
        jPanel6.setForeground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Kullanıcı:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("E-mail:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText(KullanıcıBilgileri.getKullanıcıAdı());

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 0, 0));
        jLabel11.setText(KullanıcıBilgileri.getEmail());

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("DoğumTarihi:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        jLabel13.setText(KullanıcıBilgileri.getDogumtarihi());

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Kullanıcı Bilgileri");
        jLabel14.setToolTipText("");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel12)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel13)
                            .addGap(15, 15, 15))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addComponent(jLabel9))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel11)
                                .addComponent(jLabel10))
                            .addGap(20, 20, 20))))
                .addContainerGap(182, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addGap(26, 26, 26)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10))
                .addGap(26, 26, 26)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addGap(32, 32, 32))
        );

        textField4.setBackground(new java.awt.Color(153, 153, 153));
        textField4.setText("Film Arama");

        jComboBox3.setBackground(new java.awt.Color(153, 153, 153));
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aksiyon ve Macera", "Belgesel", "Bilim Kurgu ve Fantastik Yapımlar", "Bilim ve Doğa", "Çocuk ve Aile", "Drama", "Gerilim", "Komedi", "Korku", "Romantik" }));

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/arama.jpg"))); // NOI18N
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/arama.jpg"))); // NOI18N
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(textField4, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(210, 210, 210))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textField4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(799, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1280, 1024);

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setMaximumSize(new java.awt.Dimension(1280, 1024));
        jPanel3.setPreferredSize(new java.awt.Dimension(1280, 1024));
        jPanel3.setLayout(null);

        jTable1.setBackground(new java.awt.Color(102, 102, 102));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Program Adıaa", "Program Tipi", "Bölüm Sayısı", "null"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setEnabled(false);
        jTable1.setIntercellSpacing(new java.awt.Dimension(5, 5));
        jTable1.setRequestFocusEnabled(false);
        jTable1.setRowHeight(80);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(50);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(10, 275, 1260, 701);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Kullanıcı:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("E-mail:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText(KullanıcıBilgileri.getKullanıcıAdı());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText(KullanıcıBilgileri.getEmail());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("DoğumTarihi:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText(KullanıcıBilgileri.getDogumtarihi());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Kullanıcı Bilgileri");
        jLabel8.setToolTipText("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel3)
                            .addGap(15, 15, 15))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2))
                            .addGap(20, 20, 20))))
                .addContainerGap(182, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3))
                .addGap(32, 32, 32))
        );

        jPanel3.add(jPanel2);
        jPanel2.setBounds(0, 0, 479, 225);

        textField3.setBackground(new java.awt.Color(153, 153, 153));
        textField3.setText("Film Arama");
        jPanel3.add(textField3);
        textField3.setBounds(529, 59, 225, 20);

        jComboBox2.setBackground(new java.awt.Color(153, 153, 153));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aksiyon ve Macera", "Belgesel", "Bilim Kurgu ve Fantastik Yapımlar", "Bilim ve Doğa", "Çocuk ve Aile", "Drama", "Gerilim", "Komedi", "Korku", "Romantik" }));
        jPanel3.add(jComboBox2);
        jComboBox2.setBounds(844, 59, 200, 20);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/arama.jpg"))); // NOI18N
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton5);
        jButton5.setBounds(764, 59, 20, 20);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/arama.jpg"))); // NOI18N
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton6);
        jButton6.setBounds(1054, 59, 20, 20);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel3.add(jLabel21);
        jLabel21.setBounds(12, 240, 430, 30);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 0, 1280, 1024);

        jPanel4.setMinimumSize(new java.awt.Dimension(1280, 1024));
        jPanel4.setPreferredSize(new java.awt.Dimension(1280, 1024));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1280, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1024, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel4);
        jPanel4.setBounds(0, 0, 1280, 1024);

        jPanel5.setBackground(new java.awt.Color(102, 102, 102));
        jPanel5.setMinimumSize(new java.awt.Dimension(1280, 1024));
        jPanel5.setPreferredSize(new java.awt.Dimension(1280, 1024));
        jPanel5.setLayout(null);

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));
        jPanel7.setMinimumSize(new java.awt.Dimension(1000, 750));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/play.png"))); // NOI18N
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(378, 378, 378)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(522, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(224, 224, 224)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(426, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel7);
        jPanel7.setBounds(50, 160, 840, 590);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/play2.png"))); // NOI18N
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pause (2).png"))); // NOI18N
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15)
                .addContainerGap(744, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        jPanel5.add(jPanel8);
        jPanel8.setBounds(50, 750, 840, 30);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel16.setText(ProgramBilgileri.getProgramAdı()+"as");
        jPanel5.add(jLabel16);
        jLabel16.setBounds(300, 90, 470, 50);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel17.setText("İzlenen Program:");
        jPanel5.add(jLabel17);
        jLabel17.setBounds(50, 100, 250, 29);

        jButton4.setBackground(new java.awt.Color(153, 153, 153));
        jButton4.setText("Geri");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton4);
        jButton4.setBounds(50, 30, 73, 23);

        jScrollPane2.setBackground(new java.awt.Color(102, 102, 102));

        jTable2.setBackground(new java.awt.Color(102, 102, 102));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Bölüm", ""
            }
        ));
        jTable2.setEnabled(false);
        jTable2.setIntercellSpacing(new java.awt.Dimension(10, 10));
        jTable2.setRowHeight(50);
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setMinWidth(50);
            jTable2.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        jPanel5.add(jScrollPane2);
        jScrollPane2.setBounds(912, 160, 350, 590);

        jPanel9.setBackground(new java.awt.Color(102, 102, 102));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel19.setText("Puan Ver:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        jButton9.setBackground(new java.awt.Color(153, 153, 153));
        jButton9.setText("Puanla");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        jPanel5.add(jPanel9);
        jPanel9.setBounds(90, 890, 420, 92);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("Programı İzlemeden Puanlayamazsınız");
        jPanel5.add(jLabel20);
        jLabel20.setBounds(130, 810, 460, 30);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel5.add(jLabel18);
        jLabel18.setBounds(130, 850, 460, 49);

        getContentPane().add(jPanel5);
        jPanel5.setBounds(0, 0, 1280, 1024);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
      
        
        jPanel1.setVisible(false);
        jPanel3.setVisible(true);
        jScrollPane1.setVisible(true);
        modelim1.setRowCount(0);
        modelim.setRowCount(0);
        ResultSet myRs=null;
        String aranan=textField3.getText();
        String sqlsorgu;
        jLabel21.setText("'"+aranan+"' Araması Sonucunda Bulunan Programlar");
        sqlsorgu="SELECT * FROM programlar where programadi like '%"+aranan+"%'";
        myRs=Baglanti.ismegöresorgula(sqlsorgu);
        jTable1.setModel(modelim);
        modelim.setColumnIdentifiers(kolonlar); 
        int l=0;
       
       
    try {
        while(myRs.next()){
            
            satırlar[0]=myRs.getString("programadi");
            String P1=myRs.getString("programadi");
           String süre=myRs.getString("programlaruzunlugu");
            satırlar[1]=myRs.getString("programtipi");
            satırlar[2]=myRs.getInt("bölümsayısı");    
            
    
            JButton buton=new JButton("İzle");
             buton.setBounds(1000,15+l*80, 100, 50);
         
            int bölüm=myRs.getInt("bölümsayısı");
           
             buton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent a) {
                   ProgramBilgileri.setProgramAdı(P1);
                   ProgramBilgileri.setUzunluk(süre);
                   ProgramBilgileri.setBölüm(1);
                   jPanel5.setVisible(true);
                    jPanel3.setVisible(false);
                    jTable1.setVisible(false);
                    jButton1.setVisible(true);
                 jLabel16.setText(ProgramBilgileri.getProgramAdı()+"   1.Bölüm");
                 modelim.setRowCount(0);
                 modelim1.setRowCount(0);
                 jTable2.setModel(bölümmodelim);
                 bölümmodelim.setColumnIdentifiers(bölümkolonlar);
                
                 jTable1.remove(buton);
                 
                 int e;
                 int w=0;
                 int q=0;
                for(e=1;e<bölüm+1;e++){
                    
                 int b=e;
                 bölümsatırlar[0]="   "+e+".Bölüm";                
                  JButton buton1=new JButton("İzle");
                  buton1.setBounds(200,5+w*50, 100, 40);             
                  buton1.addActionListener(new ActionListener() {
                @Override
                
                public void actionPerformed(ActionEvent a) {   
                    ProgramBilgileri.setProgramAdı(P1);
                 jLabel16.setText(ProgramBilgileri.getProgramAdı()+"   "+b+".Bölüm");
                 jPanel8.setVisible(false);
                 jPanel9.setVisible(false);
                 jButton1.setVisible(true);
                 ProgramBilgileri.setBölüm(b);
                   
                 
            if(timersayac>0){
                myTimer.cancel();
                timersayac=0;
            }
                 i=0;j=0;k=0;
                 
                }
            }); 
                  jTable2.add(buton1,BOTTOM,0);
                bölümmodelim.addRow(bölümsatırlar);
                w++;
                
                }
       
               JButton butonsil=new JButton();
               butonsil.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent a) {
                    jTable2.remove(buton);
                }});
               
                }
            }); 
             
                                    
            jTable1.add(buton,BOTTOM,0);
            modelim.addRow(satırlar);
            l++;
            
             }
    } catch (SQLException ex) {
        Logger.getLogger(KullanıcıPaneli.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jButton5ActionPerformed
int buton1=0;
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
         modelim1.setRowCount(0);
        modelim.setRowCount(0);       
        jPanel1.setVisible(false);
        jPanel3.setVisible(true);
        jScrollPane1.setVisible(true);
        ResultSet myRs=null;
        String aranan=(String) jComboBox2.getSelectedItem();
        String sqlsorgu;
        jLabel21.setText(aranan+" Türünde Programlar");
       // sqlsorgu="SELECT * FROM programlar where programtürü like '%"+aranan+"%'";
       sqlsorgu="SELECT programadi,programtür.programtür_türıd,programlaruzunlugu,bölümsayisi,programtipi FROM programlar "
                + "INNER JOIN programtür ON programtür.programtür_programıd=programlar.program_ıd and programlar.programtürü=programtür.programtür_programıd "
                + "INNER JOIN tür ON programtür.programtür_türıd=tür.tür_ıd "
                + "WHERE tür.tür_programtürü like '%"+aranan+"%'";
        myRs=Baglanti.ismegöresorgula(sqlsorgu);
        jTable1.setModel(modelim);
        modelim.setColumnIdentifiers(kolonlar); 
        int l=0;
       
       
    try {
        while(myRs.next()){
            
            satırlar[0]=myRs.getString("programadi");
            String P1=myRs.getString("programadi");
           String süre=myRs.getString("programlaruzunlugu");
         //   satırlar[1]=myRs.getString("programtürü");
            satırlar[1]=myRs.getString("programtipi");
            satırlar[2]=myRs.getInt("bölümsayısı");    
            
   
            JButton buton=new JButton("İzle");
             buton.setBounds(1000,15+l*80, 100, 50);
        
            int bölüm=myRs.getInt("bölümsayısı");
           
             buton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent a) {
                   ProgramBilgileri.setProgramAdı(P1);
                   ProgramBilgileri.setUzunluk(süre);
                   ProgramBilgileri.setBölüm(1);
                   jPanel5.setVisible(true);
                    jPanel3.setVisible(false);
                    jTable1.setVisible(false);
                    jButton1.setVisible(true);
                 jLabel16.setText(ProgramBilgileri.getProgramAdı()+"   1.Bölüm");
                 modelim.setRowCount(0);
                 modelim1.setRowCount(0);
                 jTable2.setModel(bölümmodelim);
                 bölümmodelim.setColumnIdentifiers(bölümkolonlar);
                // buton.setVisible(false);
                 jTable1.remove(buton);
                 
                 int e;
                 int w=0;
                 int q=0;
                for(e=1;e<bölüm+1;e++){
                    
                 int b=e;
                 bölümsatırlar[0]="   "+e+".Bölüm";                
                  JButton buton1=new JButton("İzle");
                  buton1.setBounds(200,5+w*50, 100, 40);             
                  buton1.addActionListener(new ActionListener() {
                @Override
                
                public void actionPerformed(ActionEvent a) {   
                    ProgramBilgileri.setProgramAdı(P1);
                 jLabel16.setText(ProgramBilgileri.getProgramAdı()+"   "+b+".Bölüm");
                 jPanel8.setVisible(false);
                 jPanel9.setVisible(false);
                 jButton1.setVisible(true);
                 ProgramBilgileri.setBölüm(b);
                   
                 
            if(timersayac>0){
                myTimer.cancel();
                timersayac=0;
            }
                 i=0;j=0;k=0;
                 
                }
            }); 
                  jTable2.add(buton1,BOTTOM,0);
                bölümmodelim.addRow(bölümsatırlar);
                w++;
                
                }
       
               JButton butonsil=new JButton();
               butonsil.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent a) {
                    jTable2.remove(buton);
                }});
               
                }
            }); 
             
                                    
            jTable1.add(buton,BOTTOM,0);
            modelim.addRow(satırlar);
            l++;
            
             }
    } catch (SQLException ex) {
        Logger.getLogger(KullanıcıPaneli.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jButton6ActionPerformed
int timersayac=0;
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        
      modelim1.setRowCount(0);
        modelim.setRowCount(0);
        
        jPanel1.setVisible(false);
        jPanel3.setVisible(true);
        jScrollPane1.setVisible(true);
        ResultSet myRs=null;
        String aranan=textField4.getText();
        String sqlsorgu;
        jLabel21.setText("'"+aranan+"' Araması Sonucunda Bulunan Programlar");
        sqlsorgu="SELECT * FROM programlar where programadi like '%"+aranan+"%'";
        myRs=Baglanti.ismegöresorgula(sqlsorgu);
        jTable1.setModel(modelim);
        modelim.setColumnIdentifiers(kolonlar); 
        int l=0;
       
       
    try {
        while(myRs.next()){
            
            satırlar[0]=myRs.getString("programadi");
            String P1=myRs.getString("programadi");
           String süre=myRs.getString("programlaruzunlugu");
            satırlar[1]=myRs.getString("programtipi");
            satırlar[2]=myRs.getInt("bölümsayısı");    
            
   
            JButton buton=new JButton("İzle");
             buton.setBounds(1000,15+l*80, 100, 50);
        
            int bölüm=myRs.getInt("bölümsayısı");
           
             buton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent a) {
                   ProgramBilgileri.setProgramAdı(P1);
                   ProgramBilgileri.setUzunluk(süre);
                   ProgramBilgileri.setBölüm(1);
                   jPanel5.setVisible(true);
                    jPanel3.setVisible(false);
                    jTable1.setVisible(false);
                    jButton1.setVisible(true);
                 jLabel16.setText(ProgramBilgileri.getProgramAdı()+"   1.Bölüm");
                 modelim.setRowCount(0);
                 modelim1.setRowCount(0);
                 jTable2.setModel(bölümmodelim);
                 bölümmodelim.setColumnIdentifiers(bölümkolonlar);
               
                 jTable1.remove(buton);
                 
                 int e;
                 int w=0;
                 int q=0;
                for(e=1;e<bölüm+1;e++){
                    
                 int b=e;
                 bölümsatırlar[0]="   "+e+".Bölüm";                
                  JButton buton1=new JButton("İzle");
                  buton1.setBounds(200,5+w*50, 100, 40);             
                  buton1.addActionListener(new ActionListener() {
                @Override
                
                public void actionPerformed(ActionEvent a) {   
                    ProgramBilgileri.setProgramAdı(P1);
                 jLabel16.setText(ProgramBilgileri.getProgramAdı()+"   "+b+".Bölüm");
                 jPanel8.setVisible(false);
                 jPanel9.setVisible(false);
                 jButton1.setVisible(true);
                 ProgramBilgileri.setBölüm(b);
                   
                 
            if(timersayac>0){
                myTimer.cancel();
                timersayac=0;
            }
                 i=0;j=0;k=0;
                 
                }
            }); 
                  jTable2.add(buton1,BOTTOM,0);
                bölümmodelim.addRow(bölümsatırlar);
                w++;
                
                }
       
               JButton butonsil=new JButton();
               butonsil.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent a) {
                    jTable2.remove(buton);
                }});
               
                }
            }); 
             
                                    
            jTable1.add(buton,BOTTOM,0);
            modelim.addRow(satırlar);
            l++;
            
             }
    } catch (SQLException ex) {
        Logger.getLogger(KullanıcıPaneli.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }//GEN-LAST:event_jButton7ActionPerformed
int i=0,j=0,k=0;
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        modelim1.setRowCount(0);
        modelim.setRowCount(0);
        
        
        jPanel1.setVisible(false);
        jPanel3.setVisible(true);
        jScrollPane1.setVisible(true);
        ResultSet myRs=null;
        String aranan=(String) jComboBox3.getSelectedItem();
        jLabel21.setText(aranan+" Türünde Programlar");
        String sqlsorgu;
        //sqlsorgu="SELECT * FROM programlar where programtürü like '%"+aranan+"%'";
        sqlsorgu="SELECT programadi,programtür.programtür_türıd,programlaruzunlugu,bölümsayisi,programtipi FROM programlar "
                + "INNER JOIN programtür ON programtür.programtür_programıd=programlar.program_ıd and programlar.programtürü=programtür.programtür_programıd "
                + "INNER JOIN tür ON programtür.programtür_türıd=tür.tür_ıd "
                + "WHERE tür.tür_programtürü like '%"+aranan+"%'";
        myRs=Baglanti.ismegöresorgula(sqlsorgu);
        jTable1.setModel(modelim);
        modelim.setColumnIdentifiers(kolonlar); 
        int l=0;
       
       
    try {
        while(myRs.next()){
            
            satırlar[0]=myRs.getString("programadi");
            String P1=myRs.getString("programadi");
           String süre=myRs.getString("programlaruzunlugu");
            satırlar[1]=myRs.getString("programtipi");
            satırlar[2]=myRs.getInt("bölümsayısı");    
            
   
            JButton buton=new JButton("İzle");
             buton.setBounds(1000,15+l*80, 100, 50);
        
            int bölüm=myRs.getInt("bölümsayısı");
           
             buton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent a) {
                   ProgramBilgileri.setProgramAdı(P1);
                   ProgramBilgileri.setUzunluk(süre);
                   ProgramBilgileri.setBölüm(1);
                   jPanel5.setVisible(true);
                    jPanel3.setVisible(false);
                    jTable1.setVisible(false);
                    jButton1.setVisible(true);
                 jLabel16.setText(ProgramBilgileri.getProgramAdı()+"   1.Bölüm");
                 modelim.setRowCount(0);
                 modelim1.setRowCount(0);
                 jTable2.setModel(bölümmodelim);
                 bölümmodelim.setColumnIdentifiers(bölümkolonlar);
                
                 jTable1.remove(buton);
                 
                 int e;
                 int w=0;
                 int q=0;
                for(e=1;e<bölüm+1;e++){
                    
                 int b=e;
                 bölümsatırlar[0]="   "+e+".Bölüm";                
                  JButton buton1=new JButton("İzle");
                  buton1.setBounds(200,5+w*50, 100, 40);             
                  buton1.addActionListener(new ActionListener() {
                @Override
                
                public void actionPerformed(ActionEvent a) {   
                    ProgramBilgileri.setProgramAdı(P1);
                 jLabel16.setText(ProgramBilgileri.getProgramAdı()+"   "+b+".Bölüm");
                 jPanel8.setVisible(false);
                 jPanel9.setVisible(false);
                 jButton1.setVisible(true);
                 ProgramBilgileri.setBölüm(b);
                   
                 
            if(timersayac>0){
                myTimer.cancel();
                timersayac=0;
            }
                 i=0;j=0;k=0;
                 
                }
            }); 
                  jTable2.add(buton1,BOTTOM,0);
                bölümmodelim.addRow(bölümsatırlar);
                w++;
                
                }
       
               JButton butonsil=new JButton();
               butonsil.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent a) {
                    jTable2.remove(buton);
                }});
               
                }
            }); 
             
                                    
            jTable1.add(buton,BOTTOM,0);
            modelim.addRow(satırlar);
            l++;
            
             }
    } catch (SQLException ex) {
        Logger.getLogger(KullanıcıPaneli.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     jPanel9.setVisible(true);
     jButton2.setVisible(false);
    jButton3.setVisible(true);
    if(timersayac==0){
   java.util.Timer myTimer=new java.util.Timer();
  this.myTimer =myTimer;}
    timersayac++;
  TimerTask gorev =new TimerTask() {
                    @Override
                    public void run() {
                            
                           
                               
                                  jLabel15.setText(k+":"+j+":"+i+"/"+ProgramBilgileri.getUzunluk());
                                  ProgramBilgileri.setIzlemesüresi(k+":"+j+":"+i);
                                   
                                    
                             i++;
                          if(i==60){
                              i=0;
                              j++;
                          }
                           if(j==60){
                              j=0;
                              k++;
                          }
                    }
             };
 
  myTimer.schedule(gorev,0,30);
        jPanel5.setVisible(true);
        jButton1.setVisible(false);
        jPanel8.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       jButton2.setVisible(false);
       jButton3.setVisible(true);
       java.util.Timer myTimer=new java.util.Timer();
       this.myTimer=myTimer;
     timersayac++;
               TimerTask gorev =new TimerTask() {
                    @Override
                    public void run() {
                            
                           
                                 
                                  jLabel15.setText(k+":"+j+":"+i+"/"+ProgramBilgileri.getUzunluk());
                                   
                                    ProgramBilgileri.setIzlemesüresi(k+":"+j+":"+i);
                                     
                             i++;
                          if(i==60){
                              i=0;
                              j++;
                          }
                           if(j==60){
                              j=0;
                              k++;
                          }
                    }
             };
               
               myTimer.schedule(gorev,0,30);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jPanel5.setVisible(false);
        jPanel1.setVisible(true);
        jTable1.setVisible(true);
        jPanel8.setVisible(false);
        jPanel9.setVisible(false);
        jLabel20.setText("Programı İzlemeden Puanlayamazsınız");
        jLabel18.setVisible(false);
        bölümmodelim.setRowCount(0);
        modelim1.setRowCount(0);
        modelim.setRowCount(0);
        myTimer.cancel();
        timersayac=0;
        i=0;j=0;k=0;
        buton1=0;
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jButton3.setVisible(false);
        jButton2.setVisible(true);
        myTimer.cancel();
        timersayac=0;
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        String sorgu;
     sorgu="SELECT kullaniciprogramemail,kaldigiprogram,puan FROM kullanıcıprogram where kullaniciprogramemail='"+Email+"'";
         ResultSet myRs1=null;
         myRs1=Baglanti.ismegöresorgula(sorgu);
         System.out.println(ProgramBilgileri.getProgramAdı());
         int sayac=0;
        try {
            while(myRs1.next()){
                if(ProgramBilgileri.getProgramAdı().compareTo(myRs1.getString("kaldigiprogram"))==0&&myRs1.getInt("puan")!=0){
                    jLabel20.setText("Bu Programa Daha Önceden Puan Verdiniz.");
                    jLabel18.setVisible(true);
                    jLabel18.setText("Verdiğiniz Puan:"+myRs1.getInt("puan"));
                    jPanel9.setVisible(false); 
                    sayac++;
                }
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(KullanıcıPaneli.class.getName()).log(Level.SEVERE, null, ex);
        }      
        //System.out.println(df.format(now));
        if(sayac==0){
        String sql1="INSERT INTO kullanıcıprogram (kullaniciprogramemail,puan,kaldigiprogram,kaldigibolum,izlemesüresi,izlemetarihi) VALUES ('"+KullanıcıBilgileri.getEmail()+"','"+jComboBox1.getSelectedItem()+"','"+ProgramBilgileri.getProgramAdı()+"','"+ProgramBilgileri.getBölüm()+"','0:0:00','"+df.format(now)+"')";   
        Baglanti.ekle(sql1);
        jLabel18.setText("Programı Puanladınız.Verdiğiniz Puan:"+jComboBox1.getSelectedItem());
        jLabel18.setVisible(true);
        }
        
    }//GEN-LAST:event_jButton9ActionPerformed

    private void windowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_windowClosing
        if(jPanel5.isVisible()&&jPanel8.isVisible()){
        String sql="INSERT INTO kullanıcıprogram (kullaniciprogramemail,puan,kaldigiprogram,kaldigibolum,izlemesüresi,izlemetarihi) VALUES ('"+KullanıcıBilgileri.getEmail()+"','0','"+ProgramBilgileri.getProgramAdı()+"','"+ProgramBilgileri.getBölüm()+"','"+ProgramBilgileri.getIzlemesüresi()+"','"+df.format(now)+"')";     
       Baglanti.ekle(sql);
            }
    }//GEN-LAST:event_windowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
    /*    try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(KullanıcıPaneli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KullanıcıPaneli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KullanıcıPaneli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KullanıcıPaneli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }*/
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KullanıcıPaneli().setVisible(true);
                 
            }
        });
    }
    
  
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private java.awt.TextField textField3;
    private java.awt.TextField textField4;
    // End of variables declaration//GEN-END:variables
}
