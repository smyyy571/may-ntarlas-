
package com.gokcehilal.mayintarlam;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;



 

public final class mayin implements ActionListener, MouseListener {
 
     
    
       private final JFrame ekran;
      
     
       private JFrame customEkran;
    
       private final JButton gulucuk = new JButton("");
       private final JPanel karma = new JPanel();
       private final JPanel ustPanel = new JPanel();
       private JTextField textSkor=new JTextField();
       private JTextField textZaman= new JTextField();
      
      
       
          ImageIcon deneme=null;
          ImageIcon gulucukResim = null;
          ImageIcon BlokResmi = null;
          ImageIcon mayinResmi = null;
          ImageIcon lossImageIcon = null;
          ImageIcon mutsuzResmi = null;
          ImageIcon birResmi = null;
          ImageIcon ikiResmi = null;
          ImageIcon ucResmi = null;
          ImageIcon dortResmi = null;
          ImageIcon besResmi = null;
          
           Timer timer = new Timer();
           Timer timer2 = new Timer();
           
         InputStream patlama;
         InputStream secim;
         InputStream arkaplan;
         
    
         
          
        
       public mayin() {
           
           
           
              ekran = new JFrame("Mayın Tarlası");
              ekran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              ekran.setVisible(true);
              ekran.setLocation(900, 60);
        
              ekran.setResizable(false);
             
              ekran.setJMenuBar(Menu_Bar_Bolumu());
              MayinTarlasiResimler();
              
              karma.setLayout(new BorderLayout());
              
                JLabel ara1 = new JLabel("");
                ara1.setPreferredSize(new Dimension(40, 40));
             ustPanel.add(ara1);
              
             ustPanel.setBackground(Color.WHITE);
             
             textSkor = new JTextField(""+mayin);
             textSkor.setBackground(Color.BLACK);
             textSkor.setForeground(Color.RED);
             textSkor.setFont(textSkor.getFont().deriveFont(Font.BOLD,20f));
            
              ustPanel.add(textSkor);
              
         
              
            
              
              gulucuk.setPreferredSize(new Dimension(30, 30));
              gulucuk.setIcon(gulucukResim);
              ustPanel.add(gulucuk);
              
              JLabel ara2 = new JLabel("");
                ara2.setPreferredSize(new Dimension(40, 40));
             ustPanel.add(ara2);
              
             
             textZaman = new JTextField("0");
             textZaman.setBackground(Color.BLACK);
             textZaman.setForeground(Color.RED);
             textZaman.setFont(textZaman.getFont().deriveFont(Font.BOLD,20f));
             textZaman.setPreferredSize(new Dimension(30, 30));
             ustPanel.add(textZaman);
            
              
           
              
             
              
             
              
              karma.add(ustPanel, BorderLayout.NORTH);
              gulucuk.addActionListener(this);
              gulucuk.addMouseListener(this);
              butonDuzenle();
              ekran.add(karma);
               

              ekran.pack();
              
           
              
            zamanBaşla();
       }
       
       
      public void zamanBaşla(){
        
         
          TimerTask sayacTimerTask= new TimerTask() {
                 int sayi=0;
                  @Override
                  public void run() {
                       sayi++;
                      String zamanK = String.valueOf(sayi);
                       textZaman.setText(zamanK);
                       
                  }
              };
               timer.schedule(sayacTimerTask, 0,1000);
      }
      
      public void  zamanDur(){
          timer.cancel();
       TimerTask sayacTask = new TimerTask() {
            int sayi=0;
           @Override
           public void run() {
                sayi++;
                      String zamanK = String.valueOf(sayi);
                       textZaman.setText(zamanK);
           }
       };
    
       timer2.schedule(sayacTask, 0, 1000);
          
      }
      public void zamanSıfırla(){
          
          textZaman.setText("0");
      }
      
       public void patlamaMuzikCal(){
           
           
          
           
           
            try {
               patlama = new FileInputStream("png/patlama.wav");
               AudioStream patlamaMuzik= new AudioStream(patlama);
               AudioPlayer.player.start(patlamaMuzik);
             
               
           } catch (FileNotFoundException ex) {
               Logger.getLogger(mayin.class.getName()).log(Level.SEVERE, null, ex);
           } catch (IOException ex) {
               Logger.getLogger(mayin.class.getName()).log(Level.SEVERE, null, ex);
           }
            
          
           
           
              
              
              
          }
     
    
      public void secimMuzikCal(){
               try {
               secim = new FileInputStream("png/puanSes.wav");
               AudioStream secimMuzik= new AudioStream(secim);
               AudioPlayer.player.start(secimMuzik);
           } catch (FileNotFoundException ex) {
               Logger.getLogger(mayin.class.getName()).log(Level.SEVERE, null, ex);
           } catch (IOException ex) {
               Logger.getLogger(mayin.class.getName()).log(Level.SEVERE, null, ex);
           }
              
          }
          
           
         
    

     
       public void MayinTarlasiResimler() {
           gulucukResim = getScaledImage("png/mutlu.png");
           BlokResmi = getScaledImage("png/blok.png");
           mayinResmi = getScaledImage("png/mayin.png");
           lossImageIcon = getScaledImage("png/uzgun.png");
           mutsuzResmi = getScaledImage("png/korku.png");
           birResmi = getScaledImage("png/1.png");
           ikiResmi = getScaledImage("png/2.png");
           ucResmi = getScaledImage("png/3.png");
           dortResmi = getScaledImage("png/4.png");
           besResmi = getScaledImage("png/5.png");
         
          
       }
       
       public ImageIcon getScaledImage(String ResimIcon) {
           
          ImageIcon imageIcon = new ImageIcon(ResimIcon);
          Image resim = imageIcon.getImage(); 
          Image yeniResim = resim.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
          imageIcon = new ImageIcon(yeniResim);
          return imageIcon;
       }
       
 
       public JMenuBar Menu_Bar_Bolumu() {
 
              JMenuBar mBar = new JMenuBar();
              JMenu oyun = new JMenu("Oyun");
 
              
 
              final JMenuItem Yeni_oyun_intent = new JMenuItem("Yeni Oyun");
              final JMenuItem Baslangic_oyun_intent = new JMenuItem("Başlangıç");
              final JMenuItem Standart_oyun_intent = new JMenuItem("Standart");
              final JMenuItem Zor_oyun_intent = new JMenuItem("Zor");
              final JMenuItem Manuel_Ayarlama_intent = new JMenuItem("Özelleştir");
              final JMenuItem Cıkıs_oyun_intent = new JMenuItem("Çıkış");
 
              
 
              oyun.add(Yeni_oyun_intent);
              oyun.add(Baslangic_oyun_intent);
              oyun.add(Standart_oyun_intent);
              oyun.add(Zor_oyun_intent);
              oyun.add(Manuel_Ayarlama_intent);
              oyun.add(Cıkıs_oyun_intent);
 
              
 
              ActionListener MenuListener = new ActionListener() {
 
                     @Override
                     public void actionPerformed(ActionEvent degisken) {
                           if (Yeni_oyun_intent == degisken.getSource()) {
                                 zamanSıfırla();
                                  yenile();
                           }
                           if (Baslangic_oyun_intent == degisken.getSource()) {
                                  btngenislik = 8;
                                  btnyukseklik = 8;
                                  mayin = 10;
                                  
                                  textSkor.setText(""+mayin);
                                   zamanSıfırla();
                                  yenile();
 
                           }
                           if (Standart_oyun_intent == degisken.getSource()) {
                                  btngenislik = 16;
                                  btnyukseklik = 16;
                                  mayin = 40;
                                  textSkor.setText(""+mayin);
                                 
                                  zamanSıfırla();
                                  yenile();
 
                           }
                           if (Zor_oyun_intent == degisken.getSource()) {
                                  btngenislik = 16;
                                  btnyukseklik = 30;
                                  mayin = 99;
                                textSkor.setText(""+mayin);
                                 zamanSıfırla();
                                  yenile();
                           }
                           if (Manuel_Ayarlama_intent== degisken.getSource()) {
                              
                               ekran.enable(false);
                               customEkran = new JFrame("Özelleştir");
                               customEkran.setVisible(true);
                               customEkran.setResizable(false);
                               customEkran.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                               customEkran.addWindowListener(new WindowAdapter() {
                                   
                                @Override
                                public void windowClosing(WindowEvent e) {
                                    System.out.println("A is closing");
                                    ekran.enable(true);
                                    ekran.setVisible(true);
                                                                            }

          
                                @Override
                                 public void windowClosed(WindowEvent e) {
                                    System.out.println("A has closed");
                                                                         }
                                   
                                                                });
                              
 
                              
                               customEkran.setBounds(300, 300, 250, 150);
                               
                               
                               JPanel panel = new JPanel();
                            
                                
                               customEkran.add(panel);
                               panel.setLayout(null);
                               
                              
                               
                               JLabel uzunluk = new JLabel("Uzunluk:");
                               uzunluk.setBounds(10, 15, 50, 15);
                               panel.add(uzunluk);
                               
                               JLabel genişlik = new JLabel("Genişlik:")   ;       
                               genişlik.setBounds(10, 45, 50, 15);
                               panel.add(genişlik);
                               
                               JLabel mayin_Label = new JLabel("Mayın:");
                               mayin_Label.setBounds(10, 75, 50, 15);
                               panel.add(mayin_Label);
                               
                               JTextField uzunluk_text= new JTextField(""+btnyukseklik);
                               uzunluk_text.setBounds(70,12,50,20);
                               panel.add(uzunluk_text);
                                
                               JTextField genişlik_text= new JTextField(""+btngenislik);
                               genişlik_text.setBounds(70,42,50,20);
                               panel.add(genişlik_text);
                               
                               JTextField mayin_text= new JTextField(""+mayin);
                               mayin_text.setBounds(70,72,50,20);
                               panel.add(mayin_text);
                   
                           
                              JButton olustur_button = new JButton("Oluştur");
                              olustur_button.setBounds(130, 12, 90, 20);
                              panel.add(olustur_button);
                              
                              
                              olustur_button.addActionListener(new ActionListener() {
                                   @Override
                                   public void actionPerformed(ActionEvent e) {
                                
                                  btnyukseklik = Integer.valueOf(uzunluk_text.getText());
                                  btngenislik = Integer.valueOf(genişlik_text.getText());
                                  
                                  mayin = Integer.valueOf(mayin_text.getText());
                                   textSkor.setText(""+mayin);
                                  yenile();
                                  zamanSıfırla();
                                  customEkran.setVisible(false);
                                  ekran.setVisible(true);
                                  ekran.enable(true);
                                   }
                               });
                              
                              JButton vazgec_button = new JButton("Vazgeç");
                              vazgec_button.setBounds(130, 42, 90, 20);
                              panel.add(vazgec_button);
                              
                              vazgec_button.addActionListener(new ActionListener() {
                                   @Override
                                   public void actionPerformed(ActionEvent e) {
                                      customEkran.setVisible(false);
                                  ekran.setVisible(true);
                                  ekran.enable(true);
                                   }
                               });
          
                               
                         }
                           if (Cıkıs_oyun_intent == degisken.getSource()) {
                                  if (ekran != null) {
                                         ekran.dispose();
                                  }
                                  System.exit(0);
 
                           }
                     }
 
              };
 
              Yeni_oyun_intent.addActionListener(MenuListener);
              Baslangic_oyun_intent.addActionListener(MenuListener);
              Standart_oyun_intent.addActionListener(MenuListener);
              Zor_oyun_intent.addActionListener(MenuListener);
              Manuel_Ayarlama_intent.addActionListener(MenuListener);
              Cıkıs_oyun_intent.addActionListener(MenuListener);
              
              mBar.add(oyun);
              
              
              return mBar;
       }
 
       
       private int btngenislik = 8;
 
       private int btnyukseklik = 8;
 
       private int mayin = 10;
      
       int[][] mayinDizi;
 
       JButton[][] butonDizi;
       JPanel mayin_karistir_dizi = null;
 
       public void butonDuzenle() {
         
              mayinDizi = new int[btngenislik][btnyukseklik];
              butonDizi = new JButton[btngenislik][btnyukseklik];
              boolean baslama = true;
              if (mayin_karistir_dizi != null) {
                     karma.remove(mayin_karistir_dizi);
                     mayin_karistir_dizi = null;
                     baslama = false;
 
              }
              mayin_karistir_dizi = new JPanel();
              mayin_karistir_dizi.setLayout(new GridLayout(btngenislik, btnyukseklik));
 
              for (int x = 0; x < btngenislik; x++) {
                     for (int y = 0; y < btnyukseklik; y++) {
                           mayinDizi[x][y] = 0;
                           butonDizi[x][y] = new JButton("");
                         
                           butonDizi[x][y].setPreferredSize(new Dimension(16, 16));
                           butonDizi[x][y].addActionListener((ActionEvent degisken) -> {
                                if (degisken.getSource() == gulucuk) {
                     yenile();
              } else {
                  
                     for (int i = 0; i < btngenislik; i++)
                           for (int j = 0; j < btnyukseklik; j++) {
                                  if (butonDizi[i][j] == degisken.getSource()) { //Kutunun değerine göre işlem yaptır
                                         if (mayinDizi[i][j] == 9) {
                                                for (int k = 0; k < btngenislik; k++) {
                                                       for (int l = 0; l < btnyukseklik; l++) {
 
                                                              if (mayinDizi[k][l] == 9) {
                                                                     butonDizi[k][l].setIcon(mayinResmi);
                                                                     
                                                              }
 
                                                              butonDizi[k][l].removeActionListener(this);
                                                              butonDizi[k][l].removeMouseListener(this);
 
                                                       }
                                                }
 
                                         }
                                         if (mayinDizi[i][j] == 1) {
                                                butonDizi[i][j].setIcon(birResmi);
                                         }
                                         if (mayinDizi[i][j] == 2) {
                                                butonDizi[i][j].setIcon(ikiResmi);
                                         }
                                         if (mayinDizi[i][j] == 3) {
                                                butonDizi[i][j].setIcon(ucResmi);
                                         }
                                         if (mayinDizi[i][j] == 4) {
                                                butonDizi[i][j].setIcon(dortResmi);
                                         }
                                         if (mayinDizi[i][j] == 5) {
                                                butonDizi[i][j].setIcon(besResmi);
                                         }
                                         if (mayinDizi[i][j] == 0) {
                                              BosKutucukBul(i, j);
                                         }
                                  }
                           }
              }
                           });
                           butonDizi[x][y].addMouseListener(this);
                           mayin_karistir_dizi.add(butonDizi[x][y]);
                     }
              }
 
              mayin_karistir_dizi.setVisible(true);
              karma.add(mayin_karistir_dizi, BorderLayout.CENTER);
              if (baslama) {
                     mayinOlusturucu(butonDizi);
              }
              ekran.pack();
       }
       public void yenile() {
           
           
         
           zamanSıfırla();
              gulucuk.setIcon(gulucukResim);
             
             
              butonDuzenle();
              for (int i = 0; i < btngenislik; i++) {
                     for (int j = 0; j < btnyukseklik; j++) {
                           mayinDizi[i][j] = 0;
                           butonDizi[i][j].addActionListener(this);
                           butonDizi[i][j].addMouseListener(this);
                           butonDizi[i][j].setText("");
                         
                     }
              }
              mayinOlusturucu(butonDizi);
              System.out.println("");
              System.out.println("");
       }
 
       public void mayinOlusturucu(JButton button[][]) {
           
              int[] mayinD = RandomUret(btngenislik, btnyukseklik, mayin);
              int sayi = 1;
              for (int i = 0; i < btngenislik; i++) {
                     for (int j = 0; j < btnyukseklik; j++)
 
                     {
 
                           for (int k = 0; k < mayinD.length && mayinD[k] != 0; k++) {
                                  if (sayi == mayinD[k]) {
                                         mayinDizi[i][j] = 9;
                                         
                                  }
                           }
                           sayi++; 
                     }
              }
          
              int kutusayisi = 0;
              for (int i = 0; i < btngenislik; i++) {
                     for (int j = 0; j < btnyukseklik; j++) {
                           kutusayisi = 0;
 
                           if (mayinDizi[i][j] != 9) {
                                  if (i > 0 && j > 0) {
                                         if (mayinDizi[i - 1][j - 1] == 9)
                                                kutusayisi++;
                                  }
 
                                  if (i > 0) {
                                         if (mayinDizi[i - 1][j] == 9)
                                                kutusayisi++;
                                  }
 
                                  if (i > 0 && j < btnyukseklik - 1) {
                                         if (mayinDizi[i - 1][j + 1] == 9)
                                                kutusayisi++;
                                  }
 
                                  if (i < btngenislik - 1 && j > 0) {
                                         if (mayinDizi[i + 1][j - 1] == 9)
                                                kutusayisi++;
                                  }
                                  if (i < btngenislik - 1) {
                                         if (mayinDizi[i + 1][j] == 9)
                                                kutusayisi++;
                                  }
 
                                  if (i < btngenislik - 1 && j < btnyukseklik - 1) {
                                         if (mayinDizi[i + 1][j + 1] ==9)
                                                kutusayisi++;
                                  }
 
                                  if (j > 0) {
                                         if (mayinDizi[i][j - 1] == 9)
                                                kutusayisi++;
                                  }
                                  if (j < btnyukseklik - 1) {
                                         if (mayinDizi[i][j + 1] == 9)
                                                kutusayisi++;
                                  }
                                  
                                  if (kutusayisi != 0 && mayinDizi[i][j]!=9){
                                mayinDizi[i][j] = kutusayisi;
                           }
                                 
                           }
                     }
              }

       }
 
       public int[] RandomUret(int butongenislik, int butonyukseklik, int mayin) {
              Random rand = new Random();
              
              int[] randommayin = new int[butongenislik * butonyukseklik];
              boolean test = false;
              int sayi = 0;
              while (sayi < mayin) {
                   int   randomNumara = (int) ((butongenislik * butonyukseklik) * (rand.nextDouble())) + 1;
                     test = false;
                     for (int i = 0; i < sayi; i++) {
                           if (randommayin[i] == randomNumara) {
                                  test = true;
                                  break;
                           }
                     }
                     if (!test) {
                           randommayin[sayi++] = randomNumara;
                     }
              }
              
              return randommayin;
       }
 
       @Override
       public void actionPerformed(ActionEvent degisken) {
 
             
       }
 
       public void BosKutucukBul(int KutuX, int KutuY) {
              int[] sayX = new int[(btngenislik) * (btnyukseklik)];
              int[] sayY = new int[(btngenislik) * (btnyukseklik)];
              int Bosluk = 0;
              for (int i = 0; i < ((btngenislik) * (btnyukseklik)); i++) {
                     sayX[i] = -1;
                     sayY[i] = -1;
              }
              sayX[Bosluk] = KutuX;
              sayY[Bosluk] = KutuY;
              Bosluk++;
 
              for (int i = 0; i < Bosluk; i++) {
                     if (sayX[i] > 0) {
                           int xxX = sayX[i] - 1;
                           int yyY = sayY[i];
                           if (mayinDizi[xxX][yyY] == 0) {
                                  if (!findIn(sayX, sayY, Bosluk, xxX, yyY)) {
                                         sayX[Bosluk] = xxX;
                                         sayY[Bosluk] = yyY;
                                         Bosluk++;
                                  }
                           }
                     }
 
                     if (sayX[i] < (btngenislik - 1)) {
                           int xxX = sayX[i] + 1;
                           int yyY = sayY[i];
                           if (mayinDizi[xxX][yyY] == 0) {
                                  if (!findIn(sayX, sayY, Bosluk, xxX, yyY)) {
                                         sayX[Bosluk] = xxX;
                                         sayY[Bosluk] = yyY;
                                         Bosluk++;
                                  }
                           }
                     }
 
                     if (sayY[i] > 0) {
                           int xxX = sayX[i];
                           int yyY = sayY[i] - 1;
                           if (mayinDizi[xxX][yyY] == 0) {
                                  if (!findIn(sayX, sayY, Bosluk, xxX, yyY)) {
                                         sayX[Bosluk] = xxX;
                                         sayY[Bosluk] = yyY;
                                         Bosluk++;
                                  }
                           }
                     }
 
                     if (sayY[i] < (btnyukseklik - 1)) {
                           int xxX = sayX[i];
                           int yyY = sayY[i] + 1;
                           if (mayinDizi[xxX][yyY] == 0) {
                                  if (!findIn(sayX, sayY, Bosluk, xxX, yyY)) {
                                         sayX[Bosluk] = xxX;
                                         sayY[Bosluk] = yyY;
                                         Bosluk++;
                                  }
                           }
                     }
              }
 
              for (int k = 0; k < Bosluk; k++) {
                     butonDizi[sayX[k]][sayY[k]].setBackground(new Color(200, 200, 250));
              }
 
       }
        
       public boolean findIn(int[] sayX, int[] sayY, int sayBos, int xxX, int yyY) {
              int j = 0;
              for (j = 0; j < sayBos; j++) {
                     if ((sayX[j] == (xxX)) && (sayY[j] == (yyY))) {
                           return true;
                     }
              }
              return false;
       }
 
       @Override
       public void mouseClicked(MouseEvent arg0) {
            
       }
         
       @Override
       public void mousePressed(MouseEvent me) {
           System.out.println("");
              boolean checkBtn = false;
              for (int i = 0; i < btngenislik; i++){
                     for (int j = 0; j < btnyukseklik; j++) {
                           if (butonDizi[i][j] == me.getSource()) {
                                  gulucuk.setIcon(mutsuzResmi);
                                  checkBtn = true;
                                  break;
                           }
                     }
                     if (checkBtn==true){
                         break;
                     }
              }
              if (me.getSource() == gulucuk) {
                    gulucuk.setIcon(mutsuzResmi);
              }

       }
 
       @Override
       public void mouseReleased(MouseEvent me) {
           
              
              if (me.getSource() == gulucuk) {
                     gulucuk.setIcon(gulucukResim);
              }
              
              for (int i = 0; i < btngenislik; i++)
                     for (int j = 0; j < btnyukseklik; j++) {
                           if (butonDizi[i][j] == me.getSource()) {
                                  if (mayinDizi[i][j] == 9) {
                                      patlamaMuzikCal();
                                         gulucuk.setIcon(lossImageIcon);  
                                  } else {
                                      secimMuzikCal();
                                         gulucuk.setIcon(gulucukResim);
                                  }
                           }
 
                     }
                    
       }
       
       
       
 
       @Override
       public void mouseEntered(MouseEvent arg0) {
           
 
       }
 
       @Override
       public void mouseExited(MouseEvent arg0) {
             
          
           
 
       }
       
       public static void main(String[] args) {
           
           
         mayin baglanti=new mayin();
    }

    
       
      
}
