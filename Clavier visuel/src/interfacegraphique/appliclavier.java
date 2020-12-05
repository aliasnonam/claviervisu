package interfacegraphique;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.text.DecimalFormat;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Utilities;

public class appliclavier extends JFrame{
	
	 String à ="à"; String â ="â"; String é ="é";
	 String è ="è"; String ê ="ê"; String ç ="ç";
	 String ï ="ï"; String ô ="ô"; String œ ="œ";
	 String ù ="ù"; String ë ="ë"; String î ="î";
	 String û ="û"; String ü ="ü";
	 String caps ="caps";
	 JButton boutonà = new JButton(à); JButton boutonâ = new JButton(â); JButton boutoné = new JButton(é);
	 JButton boutonè = new JButton(è); JButton boutonê = new JButton(ê); JButton boutonç = new JButton(ç);
	 JButton boutonï = new JButton(ï); JButton boutonô = new JButton(ô); JButton boutonœ = new JButton(œ);
	 JButton boutonù = new JButton(ù); 
	 JButton boutonë = new JButton(ë); JButton boutonî = new JButton(î); JButton boutonû = new JButton(û);
	 JButton boutonü = new JButton(ü);
	 JButton boutonreset = new JButton("reset"); JButton boutondelete = new JButton("deline");
	 
	 private JTextField fromField = new JTextField(16);
	 private JTextField toField = new JTextField(16);
	 
	 JButton boutoncaps = new JButton(caps);
	 String text; int size1 = 726; int size2 = 200;
	 String blank = "";
	 int start; int end;
	 boolean uppercase; JTextArea textArea = new JTextArea(text, 14, 36);
	 boolean isOn = Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK); 
	 
	 Color noir=new Color(33,33,33);
	 Color blood=new Color(102,0,0);
     Color gris=new Color(191,191,191);
     Color orange=new Color(252, 129, 74);
     Color vert=new Color(42, 60, 36);
     Color purple=new Color(33, 31, 51);
     Color darkgris=new Color(55, 55, 55);
   
     Color rouge=new Color(212,4,4);
     Color noir2=new Color(19,20,24);
     Color jauneinsta=new Color(255, 252, 0);  
     Color rose=new Color(239, 195, 245);
     Color bleufb=new Color(59, 89, 153);
     Color blanc=new Color(250,250,250);
     Color violet=new Color(87,24,69);
     Color bleu=new Color(65,161,218);
     
     // centrer texte guideutilisateur dans JtextArea non scroll
     String guide1="press reset réinitialisera le txtarea";
     String guide2="---------------------------------------------";
     String guide3="press deline supprimera la ligne";
     String guide4="caps off = â | à | ç | é | ê | ë | è | î | ï | ô | œ | û | ü | ù";
     String guide5="-------------------------------------------------------------------------------";
     String guide6="CAPS ON = Â | À | Ç | É | Ê | Ë | È | Î | Ï | Ô | Œ | Û | Ü | Ù";
     
     String guide11="press reset réinitialisera le txtarea"+"                                                          ";
     String guide21="---------------------------------------------"+"                                                          ";
     String guide31="press deline supprimera la ligne"+"                                                             ";
     String guide41="caps off = â | à | ç | é | ê | ë | è | î | ï | ô | œ | û | ü | ù                          ";
     String guide51="-------------------------------------------------------------------------------"+"                 ";
     String guide61="CAPS ON = Â | À | Ç | É | Ê | Ë | È | Î | Ï | Ô | Œ | Û | Ü | Ù                  ";
     
     int lenguide1 = (guide11.length() - guide1.length())/2; int lenguide2 = (guide21.length() - guide2.length())/2;
     int lenguide3 = (guide31.length() - guide3.length())/2; int lenguide4 = (guide41.length() - guide4.length())/2;
     int lenguide5 = (guide51.length() - guide5.length())/2; int lenguide6 = (guide61.length() - guide6.length())/2;
     
     String strlenguide1=""; String strlenguide2=""; String strlenguide3="";
     String strlenguide4=""; String strlenguide5=""; String strlenguide6="";
     
	 public appliclavier(){
			
		    // Titre de la fenetre & Taille
		    this.setTitle("Clavier visuel accent français"); this.setSize(size1, 500);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setLayout(null);
		    setIconImage(new ImageIcon(this.getClass().getResource("/img/claviervisuel.png")).getImage());

		    // Apparition au milieu de l'écran
		    this.setLocationRelativeTo(null);
		    // Rendre visible 
		    this.setVisible(true);
		    this.setResizable(false);
		    
		    // TEXTE AREA AVEC SCROLL  
		    textArea.setFont(new Font("Arial",Font.PLAIN,18));
		    textArea.setForeground(Color.BLACK);
		    
			JScrollPane scroll1 = new JScrollPane(textArea);
		    scroll1.setBounds(65, 235, 577, 180);     
		    add(scroll1, BorderLayout.CENTER);
		    textArea.requestFocus();
		      
		    for (int i = 0; i < lenguide1; i++) strlenguide1 +=" "; for (int i = 0; i < lenguide2; i++) strlenguide2 +=" ";
		    for (int i = 0; i < lenguide3; i++) strlenguide3 +=" "; for (int i = 0; i < lenguide4; i++) strlenguide4 +=" ";
		    for (int i = 0; i < lenguide5; i++) strlenguide5 +=" "; for (int i = 0; i < lenguide6; i++) strlenguide6 +=" ";

		    String guideutilisateur=strlenguide1+"press reset réinitialisera le txtarea"+"\r\n"
		      	+ strlenguide2+"---------------------------------------------"+"\r\n"
		      	+ strlenguide3+"press deline supprimera la ligne"+"\r\n"
		      	+"---------------------------------------------------------------------------------------------"+"\r\n"
		      	+ strlenguide4+"caps off = â | à | ç | é | ê | ë | è | î | ï | ô | œ | û | ü | ù"+"\r\n"
		      	+ strlenguide5+"-------------------------------------------------------------------------------"+"\r\n"
		      	+ strlenguide6+"CAPS ON = Â | À | Ç | É | Ê | Ë | È | Î | Ï | Ô | Œ | Û | Ü | Ù";
		    
		    textArea.setText(guideutilisateur);
		    
		      
		    // BOUTONS NON FOCUSABLE
		    boutonà.setFocusable(false);
		    boutonâ.setFocusable(false);
		    boutonç.setFocusable(false);
		    
		    boutoné.setFocusable(false);
		    boutonê.setFocusable(false);
		    boutonë.setFocusable(false);
		    boutonè.setFocusable(false);
		    
		    boutonœ.setFocusable(false);
		    boutonô.setFocusable(false);
		    
		    boutonî.setFocusable(false);
		    boutonï.setFocusable(false);
		   
		    boutonû.setFocusable(false);
		    boutonü.setFocusable(false);
		    boutonù.setFocusable(false);
		    
		    boutonreset.setFocusable(false);
		    boutoncaps.setFocusable(false);  
		    boutondelete.setFocusable(false);
		    
		    boutoncaps.setEnabled(false);
		    
		    boutonà.setBackground(noir2);
		    boutonà.setForeground(rouge);
		    boutonè.setBackground(noir2);
		    boutonè.setForeground(rouge);
		    boutonù.setBackground(noir2);
		    boutonù.setForeground(rouge); 
		    
		    boutonâ.setBackground(violet);
		    boutonâ.setForeground(blanc);
		    boutonê.setBackground(violet);
		    boutonê.setForeground(blanc);
		    boutonî.setBackground(violet);
		    boutonî.setForeground(blanc);
		    boutonû.setBackground(violet);
		    boutonû.setForeground(blanc);
		    boutonô.setBackground(violet);
		    boutonô.setForeground(blanc);
		    
		    boutonï.setBackground(blanc);
		    boutonï.setForeground(bleu);
		    boutonë.setBackground(blanc);
		    boutonë.setForeground(bleu);
		    boutonü.setBackground(blanc);
		    boutonü.setForeground(bleu);
		   
		    boutoné.setBackground(rose);
		    boutoné.setForeground(noir2);
		    
		    boutonœ.setBackground(bleufb);
		    boutonœ.setForeground(jauneinsta);
		    boutonç.setBackground(bleufb);
		    boutonç.setForeground(jauneinsta);
    
			// Regler l'affichage en fonction de caps lock ou non
			if (isOn == true){	
				
				â = â.toUpperCase();
				boutonâ.setText(â);
				à = à.toUpperCase();
				boutonà.setText(à);
				ç = ç.toUpperCase();
				boutonç.setText(ç);
				
				é = é.toUpperCase();
				boutoné.setText(é);
				ê = ê.toUpperCase();
				boutonê.setText(ê);		
				ë = ë.toUpperCase();
				boutonë.setText(ë);
				è = è.toUpperCase();
				boutonè.setText(è);
				
				œ = œ.toUpperCase();
				boutonœ.setText(œ);
				ô = ô.toUpperCase();
				boutonô.setText(ô);
				
				î = î.toUpperCase();
				boutonî.setText(î);		
				ï = ï.toUpperCase();
				boutonï.setText(ï);
				
				û = û.toUpperCase();
				boutonû.setText(û);
				ü = ü.toUpperCase();
				boutonü.setText(ü);
				ù = ù.toUpperCase();
				boutonù.setText(ù);
				
				caps = caps.toUpperCase();
				boutoncaps.setText(caps);	
			}
			else if(isOn == false){
				
				â = â.toLowerCase();
				boutonâ.setText(â);
				à = à.toLowerCase();
				boutonà.setText(à);
				ç = ç.toLowerCase();
				boutonç.setText(ç);
				
				é = é.toLowerCase();
				boutoné.setText(é);
				ê = ê.toLowerCase();
				boutonê.setText(ê);		
				ë = ë.toLowerCase();
				boutonë.setText(ë);
				è = è.toLowerCase();
				boutonè.setText(è);
				
				œ = œ.toLowerCase();
				boutonœ.setText(œ);
				ô = ô.toLowerCase();
				boutonô.setText(ô);
				
				î = î.toLowerCase();
				boutonî.setText(î);		
				ï = ï.toLowerCase();
				boutonï.setText(ï);
				
				û = û.toLowerCase();
				boutonù.setText(û);
				ü = ü.toLowerCase();
				boutonü.setText(ü);
				ù = ù.toLowerCase();
				boutonù.setText(ù);
				
				caps = caps.toLowerCase();
				boutoncaps.setText(caps);	
			}
		    
			// 	Ecoute du Champ texte
			textArea.addKeyListener(new KeyListener(){
				@Override
				public void keyReleased(KeyEvent arg0){
				}
				@Override
				public void keyPressed(KeyEvent arg0){
					if (arg0.getKeyCode() == KeyEvent.VK_CAPS_LOCK && isOn == false){
					
						â = â.toUpperCase();
						boutonâ.setText(â);
						à = à.toUpperCase();
						boutonà.setText(à);
						ç = ç.toUpperCase();
						boutonç.setText(ç);
						
						é = é.toUpperCase();
						boutoné.setText(é);
						ê = ê.toUpperCase();
						boutonê.setText(ê);		
						ë = ë.toUpperCase();
						boutonë.setText(ë);
						è = è.toUpperCase();
						boutonè.setText(è);
						
						œ = œ.toUpperCase();
						boutonœ.setText(œ);
						ô = ô.toUpperCase();
						boutonô.setText(ô);
						
						î = î.toUpperCase();
						boutonî.setText(î);		
						ï = ï.toUpperCase();
						boutonï.setText(ï);
						
						û = û.toUpperCase();
						boutonû.setText(û);
						ü = ü.toUpperCase();
						boutonü.setText(ü);
						ù = ù.toUpperCase();
						boutonù.setText(ù);
						
						caps = caps.toUpperCase();
						boutoncaps.setText(caps);
						
						isOn = true;
					}
					else if(arg0.getKeyCode() == KeyEvent.VK_CAPS_LOCK && isOn == true){
						
						â = â.toLowerCase();
						boutonâ.setText(â);
						à = à.toLowerCase();
						boutonà.setText(à);
						ç = ç.toLowerCase();
						boutonç.setText(ç);
						
						é = é.toLowerCase();
						boutoné.setText(é);
						ê = ê.toLowerCase();
						boutonê.setText(ê);		
						ë = ë.toLowerCase();
						boutonë.setText(ë);
						è = è.toLowerCase();
						boutonè.setText(è);
						
						œ = œ.toLowerCase();
						boutonœ.setText(œ);
						ô = ô.toLowerCase();
						boutonô.setText(ô);
						
						î = î.toLowerCase();
						boutonî.setText(î);		
						ï = ï.toLowerCase();
						boutonï.setText(ï);
						
						û = û.toLowerCase();
						boutonû.setText(û);
						ü = ü.toLowerCase();
						boutonü.setText(ü);
						ù = ù.toLowerCase();
						boutonù.setText(ù);
						
						caps = caps.toLowerCase();
						boutoncaps.setText(caps);
						
						isOn = false;
					}
				}
				@Override
				public void keyTyped(KeyEvent arg0){
					// TODO Auto-generated method stub
				}
			});
   
		    //public void setBounds (int x, int y, int width, int height)
			boutonç.setBounds(62, 40, 50, 50);
			add(boutonç);
			boutonç.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					textArea.replaceSelection("");
					if(isOn == false) {
						ç = ç.toLowerCase();
						int position = textArea.getCaretPosition();
						textArea.insert(ç,position);	
					}
					else if (isOn == true) {
						ç = ç.toUpperCase();
						int position = textArea.getCaretPosition();
						textArea.insert(ç,position);	
					}
				} 
			});
			
			boutoné.setBounds((int) 150.66, 40, 50, 50);
			add(boutoné);
			boutoné.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					textArea.replaceSelection(""); 
					
					if(isOn == false) {
						é = é.toLowerCase();
						int position = textArea.getCaretPosition();
						textArea.insert(é,position);
					}
					else if (isOn == true) {
						é = é.toUpperCase();
						int position = textArea.getCaretPosition();
						textArea.insert(é,position);	
					}
				}
			});
				
			boutonè.setBounds((int) 239.33, 40, 50, 50);
			add(boutonè);
			boutonè.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					textArea.replaceSelection(""); 
					
					if(isOn == false) {
						è = è.toLowerCase();
						int position = textArea.getCaretPosition();
						textArea.insert(è,position);
					}
					else if (isOn == true) {
						è = è.toUpperCase();
						int position = textArea.getCaretPosition();
						textArea.insert(è,position);
					}
				}
			});
			
		    boutonê.setBounds(328, 40, 50, 50);
			add(boutonê);
			boutonê.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					textArea.replaceSelection(""); 
					
					if(isOn == false) {
						ê = ê.toLowerCase();
						int position = textArea.getCaretPosition();
						textArea.insert(ê,position);
					}
					else if (isOn == true) {
						ê = ê.toUpperCase();
						int position = textArea.getCaretPosition();
						textArea.insert(ê,position);
					}
				}
			});
			
			boutonë.setBounds((int) 416.66, 40, 50, 50);
			add(boutonë);
			boutonë.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					textArea.replaceSelection(""); 
					
					if(isOn == false) {
						ë = ë.toLowerCase();
						int position = textArea.getCaretPosition();
						textArea.insert(ë,position);
					}
					else if (isOn == true) {
						ë = ë.toUpperCase();
						int position = textArea.getCaretPosition();
						textArea.insert(ë,position);
					}
				}
			});
			
			boutonï.setBounds((int) 505.33, 40, 50, 50);
			add(boutonï);
			boutonï.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					textArea.replaceSelection(""); 
					
					if(isOn == false) {
						ï = ï.toLowerCase();
						int position = textArea.getCaretPosition();
						textArea.insert(ï,position);
					}
					else if (isOn == true) {
						ï = ï.toUpperCase();
						int position = textArea.getCaretPosition();
						textArea.insert(ï,position);
					}
				}
			});
			
			boutonü.setBounds(594, 40, 50, 50);
			add(boutonü);
			boutonü.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					textArea.replaceSelection(""); 
					
					if(isOn == false) {
						ü = ü.toLowerCase();
						int position = textArea.getCaretPosition();
						textArea.insert(ü,position);
					}
					else if (isOn == true) {
						ü = ü.toUpperCase();
						int position = textArea.getCaretPosition();
						textArea.insert(ü,position);
					}
				}
			});
				
			boutonœ.setBounds(62, 105, 50, 50);
			add(boutonœ);
			boutonœ.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					textArea.replaceSelection(""); 
					
					if(isOn == false) {
						œ = œ.toLowerCase();
						int position = textArea.getCaretPosition();
						textArea.insert(œ,position);
					}
					else if (isOn == true) {
						œ = œ.toUpperCase();
						int position = textArea.getCaretPosition();
						textArea.insert(œ,position);
					}
				}
			});			
			
			boutonù.setBounds((int) 150.66, 105, 50, 50);
			add(boutonù);
			boutonù.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					textArea.replaceSelection(""); 
					
					if(isOn == false) {
						ù = ù.toLowerCase();
						int position = textArea.getCaretPosition();
						textArea.insert(ù,position);
					}
					else if (isOn == true) {
						ù = ù.toUpperCase();
						int position = textArea.getCaretPosition();
						textArea.insert(ù,position);
					}
				}
			});
			
			boutonà.setBounds((int) 239.33, 105, 50, 50);
			add(boutonà);
			boutonà.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					textArea.replaceSelection(""); 
					
					if(isOn == false) {
						à = à.toLowerCase();
						int position = textArea.getCaretPosition();
						textArea.insert(à,position);
					}
					else if (isOn == true) {
						à = à.toUpperCase();
						int position = textArea.getCaretPosition();
						textArea.insert(à,position);
					}
				}
			});			
			
			boutonâ.setBounds(328, 105, 50, 50);
			add(boutonâ);
			boutonâ.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					textArea.replaceSelection(""); 
					
					if(isOn == false) {
						â = â.toLowerCase();
						int position = textArea.getCaretPosition();
						textArea.insert(â,position);
					}
					else if (isOn == true) {
						â = â.toUpperCase();
						int position = textArea.getCaretPosition();
						textArea.insert(â,position);
					}
				}
			});		
			
			boutonô.setBounds((int) 416.66, 105, 50, 50);
			add(boutonô); 
			boutonô.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					textArea.replaceSelection(""); 
					
					if(isOn == false) {
						ô = ô.toLowerCase();
						int position = textArea.getCaretPosition();
						textArea.insert(ô,position);
					}
					else if (isOn == true) {
						ô = ô.toUpperCase();
						int position = textArea.getCaretPosition();
						textArea.insert(ô,position);
					}
				}
			});
			
			boutonî.setBounds((int) 505.33, 105, 50, 50);
			add(boutonî); 
			boutonî.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					textArea.replaceSelection(""); 
					
					if(isOn == false) {
						î = î.toLowerCase();
						int position = textArea.getCaretPosition();
						textArea.insert(î,position);
					}
					else if (isOn == true) {
						î = î.toUpperCase();
						int position = textArea.getCaretPosition();
						textArea.insert(î,position);
					}
				}
			});
			
			boutonû.setBounds(594, 105, 50, 50);
			add(boutonû); 
			boutonû.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					textArea.replaceSelection(""); 
					
					if(isOn == false) {
						û = û.toLowerCase();
						int position = textArea.getCaretPosition();
						textArea.insert(û,position);
					}
					else if (isOn == true){
						û = û.toUpperCase();
						int position = textArea.getCaretPosition();
						textArea.insert(û,position);
					}
				}
			});
			
			
			boutonreset.setBounds((size1+250)/2, 170, 100, 50);
			add(boutonreset); 
			boutonreset.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					textArea.setText("");
				}
			});
			
			boutondelete.setBounds((size1-100)/2, 170, 100, 50);
			add(boutondelete);
			
			boutondelete.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					/*String texte = textArea.getText();
					if (texte.length()>=5){*/
					textArea.replaceSelection(""); 
					
						int offset = textArea.getCaretPosition();
						try{
							start = Utilities.getRowStart(textArea, offset);
						} catch (BadLocationException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						try{
							end = Utilities.getRowEnd(textArea, offset);
						} catch (BadLocationException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						textArea.replaceRange("", start, end);
						
						/*Delete par la gauche
					    int start = 0;
					    int end = 5;
					    textArea.replaceRange(null, start, end);
					    Delete par la droite
					    int nbOfCharsToRemove = 5;
					    String texteminus = texte.substring(0, texte.length()-nbOfCharsToRemove);
					    textArea.setText(texteminus);    
					}
					else {
						textArea.setText("");
					}*/
				}
				});
			
			boutoncaps.setBounds((size1-450)/2, 170, 100, 50);
			add(boutoncaps); 
			boutoncaps.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					//boutonà.setText("A");
					/*
					if(isOn == false) {
						à = à.toUpperCase();
						boutonà.setText(à);
						â = â.toUpperCase();
						boutonâ.setText(â);
						é = é.toUpperCase();
						boutoné.setText(é);
						
						è = è.toUpperCase();
						boutonè.setText(è);
						ê = ê.toUpperCase();
						boutonê.setText(ê);
						ç = ç.toUpperCase();
						boutonç.setText(ç);
						
						ï = ï.toUpperCase();
						boutonï.setText(ï);
						ô = ô.toUpperCase();
						boutonô.setText(ô);
						œ = œ.toUpperCase();
						boutonœ.setText(œ);
						ù = ù.toUpperCase();
						boutonù.setText(ù);
						
						caps = caps.toUpperCase();
						boutoncaps.setText(caps);
						
						isOn = true;
					}
					
					else if (isOn == true){
						à = à.toLowerCase();
						boutonà.setText(à);
						â = â.toLowerCase();
						boutonâ.setText(â);
						é = é.toLowerCase();
						boutoné.setText(é);
						
						è = è.toLowerCase();
						boutonè.setText(è);
						ê = ê.toLowerCase();
						boutonê.setText(ê);
						ç = ç.toLowerCase();
						boutonç.setText(ç);
						
						ï = ï.toLowerCase();
						boutonï.setText(ï);
						ô = ô.toLowerCase();
						boutonô.setText(ô);
						œ = œ.toLowerCase();
						boutonœ.setText(œ);
						ù = ù.toLowerCase();
						boutonù.setText(ù);
						
						caps = caps.toLowerCase();
						boutoncaps.setText(caps);
						
						isOn = false;
					}*/
				}
			});	
	     } 
}

