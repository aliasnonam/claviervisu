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
	
	 String � ="�"; String � ="�"; String � ="�";
	 String � ="�"; String � ="�"; String � ="�";
	 String � ="�"; String � ="�"; String � ="�";
	 String � ="�"; String � ="�"; String � ="�";
	 String � ="�"; String � ="�";
	 String caps ="caps";
	 JButton bouton� = new JButton(�); JButton bouton� = new JButton(�); JButton bouton� = new JButton(�);
	 JButton bouton� = new JButton(�); JButton bouton� = new JButton(�); JButton bouton� = new JButton(�);
	 JButton bouton� = new JButton(�); JButton bouton� = new JButton(�); JButton bouton� = new JButton(�);
	 JButton bouton� = new JButton(�); 
	 JButton bouton� = new JButton(�); JButton bouton� = new JButton(�); JButton bouton� = new JButton(�);
	 JButton bouton� = new JButton(�);
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
     String guide1="press reset r�initialisera le txtarea";
     String guide2="---------------------------------------------";
     String guide3="press deline supprimera la ligne";
     String guide4="caps off = � | � | � | � | � | � | � | � | � | � | � | � | � | �";
     String guide5="-------------------------------------------------------------------------------";
     String guide6="CAPS ON = � | � | � | � | � | � | � | � | � | � | � | � | � | �";
     
     String guide11="press reset r�initialisera le txtarea"+"                                                          ";
     String guide21="---------------------------------------------"+"                                                          ";
     String guide31="press deline supprimera la ligne"+"                                                             ";
     String guide41="caps off = � | � | � | � | � | � | � | � | � | � | � | � | � | �                          ";
     String guide51="-------------------------------------------------------------------------------"+"                 ";
     String guide61="CAPS ON = � | � | � | � | � | � | � | � | � | � | � | � | � | �                  ";
     
     int lenguide1 = (guide11.length() - guide1.length())/2; int lenguide2 = (guide21.length() - guide2.length())/2;
     int lenguide3 = (guide31.length() - guide3.length())/2; int lenguide4 = (guide41.length() - guide4.length())/2;
     int lenguide5 = (guide51.length() - guide5.length())/2; int lenguide6 = (guide61.length() - guide6.length())/2;
     
     String strlenguide1=""; String strlenguide2=""; String strlenguide3="";
     String strlenguide4=""; String strlenguide5=""; String strlenguide6="";
     
	 public appliclavier(){
			
		    // Titre de la fenetre & Taille
		    this.setTitle("Clavier visuel accent fran�ais"); this.setSize(size1, 500);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setLayout(null);
		    setIconImage(new ImageIcon(this.getClass().getResource("/img/claviervisuel.png")).getImage());

		    // Apparition au milieu de l'�cran
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

		    String guideutilisateur=strlenguide1+"press reset r�initialisera le txtarea"+"\r\n"
		      	+ strlenguide2+"---------------------------------------------"+"\r\n"
		      	+ strlenguide3+"press deline supprimera la ligne"+"\r\n"
		      	+"---------------------------------------------------------------------------------------------"+"\r\n"
		      	+ strlenguide4+"caps off = � | � | � | � | � | � | � | � | � | � | � | � | � | �"+"\r\n"
		      	+ strlenguide5+"-------------------------------------------------------------------------------"+"\r\n"
		      	+ strlenguide6+"CAPS ON = � | � | � | � | � | � | � | � | � | � | � | � | � | �";
		    
		    textArea.setText(guideutilisateur);
		    
		      
		    // BOUTONS NON FOCUSABLE
		    bouton�.setFocusable(false);
		    bouton�.setFocusable(false);
		    bouton�.setFocusable(false);
		    
		    bouton�.setFocusable(false);
		    bouton�.setFocusable(false);
		    bouton�.setFocusable(false);
		    bouton�.setFocusable(false);
		    
		    bouton�.setFocusable(false);
		    bouton�.setFocusable(false);
		    
		    bouton�.setFocusable(false);
		    bouton�.setFocusable(false);
		   
		    bouton�.setFocusable(false);
		    bouton�.setFocusable(false);
		    bouton�.setFocusable(false);
		    
		    boutonreset.setFocusable(false);
		    boutoncaps.setFocusable(false);  
		    boutondelete.setFocusable(false);
		    
		    boutoncaps.setEnabled(false);
		    
		    bouton�.setBackground(noir2);
		    bouton�.setForeground(rouge);
		    bouton�.setBackground(noir2);
		    bouton�.setForeground(rouge);
		    bouton�.setBackground(noir2);
		    bouton�.setForeground(rouge); 
		    
		    bouton�.setBackground(violet);
		    bouton�.setForeground(blanc);
		    bouton�.setBackground(violet);
		    bouton�.setForeground(blanc);
		    bouton�.setBackground(violet);
		    bouton�.setForeground(blanc);
		    bouton�.setBackground(violet);
		    bouton�.setForeground(blanc);
		    bouton�.setBackground(violet);
		    bouton�.setForeground(blanc);
		    
		    bouton�.setBackground(blanc);
		    bouton�.setForeground(bleu);
		    bouton�.setBackground(blanc);
		    bouton�.setForeground(bleu);
		    bouton�.setBackground(blanc);
		    bouton�.setForeground(bleu);
		   
		    bouton�.setBackground(rose);
		    bouton�.setForeground(noir2);
		    
		    bouton�.setBackground(bleufb);
		    bouton�.setForeground(jauneinsta);
		    bouton�.setBackground(bleufb);
		    bouton�.setForeground(jauneinsta);
    
			// Regler l'affichage en fonction de caps lock ou non
			if (isOn == true){	
				
				� = �.toUpperCase();
				bouton�.setText(�);
				� = �.toUpperCase();
				bouton�.setText(�);
				� = �.toUpperCase();
				bouton�.setText(�);
				
				� = �.toUpperCase();
				bouton�.setText(�);
				� = �.toUpperCase();
				bouton�.setText(�);		
				� = �.toUpperCase();
				bouton�.setText(�);
				� = �.toUpperCase();
				bouton�.setText(�);
				
				� = �.toUpperCase();
				bouton�.setText(�);
				� = �.toUpperCase();
				bouton�.setText(�);
				
				� = �.toUpperCase();
				bouton�.setText(�);		
				� = �.toUpperCase();
				bouton�.setText(�);
				
				� = �.toUpperCase();
				bouton�.setText(�);
				� = �.toUpperCase();
				bouton�.setText(�);
				� = �.toUpperCase();
				bouton�.setText(�);
				
				caps = caps.toUpperCase();
				boutoncaps.setText(caps);	
			}
			else if(isOn == false){
				
				� = �.toLowerCase();
				bouton�.setText(�);
				� = �.toLowerCase();
				bouton�.setText(�);
				� = �.toLowerCase();
				bouton�.setText(�);
				
				� = �.toLowerCase();
				bouton�.setText(�);
				� = �.toLowerCase();
				bouton�.setText(�);		
				� = �.toLowerCase();
				bouton�.setText(�);
				� = �.toLowerCase();
				bouton�.setText(�);
				
				� = �.toLowerCase();
				bouton�.setText(�);
				� = �.toLowerCase();
				bouton�.setText(�);
				
				� = �.toLowerCase();
				bouton�.setText(�);		
				� = �.toLowerCase();
				bouton�.setText(�);
				
				� = �.toLowerCase();
				bouton�.setText(�);
				� = �.toLowerCase();
				bouton�.setText(�);
				� = �.toLowerCase();
				bouton�.setText(�);
				
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
					
						� = �.toUpperCase();
						bouton�.setText(�);
						� = �.toUpperCase();
						bouton�.setText(�);
						� = �.toUpperCase();
						bouton�.setText(�);
						
						� = �.toUpperCase();
						bouton�.setText(�);
						� = �.toUpperCase();
						bouton�.setText(�);		
						� = �.toUpperCase();
						bouton�.setText(�);
						� = �.toUpperCase();
						bouton�.setText(�);
						
						� = �.toUpperCase();
						bouton�.setText(�);
						� = �.toUpperCase();
						bouton�.setText(�);
						
						� = �.toUpperCase();
						bouton�.setText(�);		
						� = �.toUpperCase();
						bouton�.setText(�);
						
						� = �.toUpperCase();
						bouton�.setText(�);
						� = �.toUpperCase();
						bouton�.setText(�);
						� = �.toUpperCase();
						bouton�.setText(�);
						
						caps = caps.toUpperCase();
						boutoncaps.setText(caps);
						
						isOn = true;
					}
					else if(arg0.getKeyCode() == KeyEvent.VK_CAPS_LOCK && isOn == true){
						
						� = �.toLowerCase();
						bouton�.setText(�);
						� = �.toLowerCase();
						bouton�.setText(�);
						� = �.toLowerCase();
						bouton�.setText(�);
						
						� = �.toLowerCase();
						bouton�.setText(�);
						� = �.toLowerCase();
						bouton�.setText(�);		
						� = �.toLowerCase();
						bouton�.setText(�);
						� = �.toLowerCase();
						bouton�.setText(�);
						
						� = �.toLowerCase();
						bouton�.setText(�);
						� = �.toLowerCase();
						bouton�.setText(�);
						
						� = �.toLowerCase();
						bouton�.setText(�);		
						� = �.toLowerCase();
						bouton�.setText(�);
						
						� = �.toLowerCase();
						bouton�.setText(�);
						� = �.toLowerCase();
						bouton�.setText(�);
						� = �.toLowerCase();
						bouton�.setText(�);
						
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
			bouton�.setBounds(62, 40, 50, 50);
			add(bouton�);
			bouton�.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					textArea.replaceSelection("");
					if(isOn == false) {
						� = �.toLowerCase();
						int position = textArea.getCaretPosition();
						textArea.insert(�,position);	
					}
					else if (isOn == true) {
						� = �.toUpperCase();
						int position = textArea.getCaretPosition();
						textArea.insert(�,position);	
					}
				} 
			});
			
			bouton�.setBounds((int) 150.66, 40, 50, 50);
			add(bouton�);
			bouton�.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					textArea.replaceSelection(""); 
					
					if(isOn == false) {
						� = �.toLowerCase();
						int position = textArea.getCaretPosition();
						textArea.insert(�,position);
					}
					else if (isOn == true) {
						� = �.toUpperCase();
						int position = textArea.getCaretPosition();
						textArea.insert(�,position);	
					}
				}
			});
				
			bouton�.setBounds((int) 239.33, 40, 50, 50);
			add(bouton�);
			bouton�.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					textArea.replaceSelection(""); 
					
					if(isOn == false) {
						� = �.toLowerCase();
						int position = textArea.getCaretPosition();
						textArea.insert(�,position);
					}
					else if (isOn == true) {
						� = �.toUpperCase();
						int position = textArea.getCaretPosition();
						textArea.insert(�,position);
					}
				}
			});
			
		    bouton�.setBounds(328, 40, 50, 50);
			add(bouton�);
			bouton�.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					textArea.replaceSelection(""); 
					
					if(isOn == false) {
						� = �.toLowerCase();
						int position = textArea.getCaretPosition();
						textArea.insert(�,position);
					}
					else if (isOn == true) {
						� = �.toUpperCase();
						int position = textArea.getCaretPosition();
						textArea.insert(�,position);
					}
				}
			});
			
			bouton�.setBounds((int) 416.66, 40, 50, 50);
			add(bouton�);
			bouton�.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					textArea.replaceSelection(""); 
					
					if(isOn == false) {
						� = �.toLowerCase();
						int position = textArea.getCaretPosition();
						textArea.insert(�,position);
					}
					else if (isOn == true) {
						� = �.toUpperCase();
						int position = textArea.getCaretPosition();
						textArea.insert(�,position);
					}
				}
			});
			
			bouton�.setBounds((int) 505.33, 40, 50, 50);
			add(bouton�);
			bouton�.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					textArea.replaceSelection(""); 
					
					if(isOn == false) {
						� = �.toLowerCase();
						int position = textArea.getCaretPosition();
						textArea.insert(�,position);
					}
					else if (isOn == true) {
						� = �.toUpperCase();
						int position = textArea.getCaretPosition();
						textArea.insert(�,position);
					}
				}
			});
			
			bouton�.setBounds(594, 40, 50, 50);
			add(bouton�);
			bouton�.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					textArea.replaceSelection(""); 
					
					if(isOn == false) {
						� = �.toLowerCase();
						int position = textArea.getCaretPosition();
						textArea.insert(�,position);
					}
					else if (isOn == true) {
						� = �.toUpperCase();
						int position = textArea.getCaretPosition();
						textArea.insert(�,position);
					}
				}
			});
				
			bouton�.setBounds(62, 105, 50, 50);
			add(bouton�);
			bouton�.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					textArea.replaceSelection(""); 
					
					if(isOn == false) {
						� = �.toLowerCase();
						int position = textArea.getCaretPosition();
						textArea.insert(�,position);
					}
					else if (isOn == true) {
						� = �.toUpperCase();
						int position = textArea.getCaretPosition();
						textArea.insert(�,position);
					}
				}
			});			
			
			bouton�.setBounds((int) 150.66, 105, 50, 50);
			add(bouton�);
			bouton�.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					textArea.replaceSelection(""); 
					
					if(isOn == false) {
						� = �.toLowerCase();
						int position = textArea.getCaretPosition();
						textArea.insert(�,position);
					}
					else if (isOn == true) {
						� = �.toUpperCase();
						int position = textArea.getCaretPosition();
						textArea.insert(�,position);
					}
				}
			});
			
			bouton�.setBounds((int) 239.33, 105, 50, 50);
			add(bouton�);
			bouton�.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					textArea.replaceSelection(""); 
					
					if(isOn == false) {
						� = �.toLowerCase();
						int position = textArea.getCaretPosition();
						textArea.insert(�,position);
					}
					else if (isOn == true) {
						� = �.toUpperCase();
						int position = textArea.getCaretPosition();
						textArea.insert(�,position);
					}
				}
			});			
			
			bouton�.setBounds(328, 105, 50, 50);
			add(bouton�);
			bouton�.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					textArea.replaceSelection(""); 
					
					if(isOn == false) {
						� = �.toLowerCase();
						int position = textArea.getCaretPosition();
						textArea.insert(�,position);
					}
					else if (isOn == true) {
						� = �.toUpperCase();
						int position = textArea.getCaretPosition();
						textArea.insert(�,position);
					}
				}
			});		
			
			bouton�.setBounds((int) 416.66, 105, 50, 50);
			add(bouton�); 
			bouton�.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					textArea.replaceSelection(""); 
					
					if(isOn == false) {
						� = �.toLowerCase();
						int position = textArea.getCaretPosition();
						textArea.insert(�,position);
					}
					else if (isOn == true) {
						� = �.toUpperCase();
						int position = textArea.getCaretPosition();
						textArea.insert(�,position);
					}
				}
			});
			
			bouton�.setBounds((int) 505.33, 105, 50, 50);
			add(bouton�); 
			bouton�.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					textArea.replaceSelection(""); 
					
					if(isOn == false) {
						� = �.toLowerCase();
						int position = textArea.getCaretPosition();
						textArea.insert(�,position);
					}
					else if (isOn == true) {
						� = �.toUpperCase();
						int position = textArea.getCaretPosition();
						textArea.insert(�,position);
					}
				}
			});
			
			bouton�.setBounds(594, 105, 50, 50);
			add(bouton�); 
			bouton�.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					textArea.replaceSelection(""); 
					
					if(isOn == false) {
						� = �.toLowerCase();
						int position = textArea.getCaretPosition();
						textArea.insert(�,position);
					}
					else if (isOn == true){
						� = �.toUpperCase();
						int position = textArea.getCaretPosition();
						textArea.insert(�,position);
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
					//bouton�.setText("A");
					/*
					if(isOn == false) {
						� = �.toUpperCase();
						bouton�.setText(�);
						� = �.toUpperCase();
						bouton�.setText(�);
						� = �.toUpperCase();
						bouton�.setText(�);
						
						� = �.toUpperCase();
						bouton�.setText(�);
						� = �.toUpperCase();
						bouton�.setText(�);
						� = �.toUpperCase();
						bouton�.setText(�);
						
						� = �.toUpperCase();
						bouton�.setText(�);
						� = �.toUpperCase();
						bouton�.setText(�);
						� = �.toUpperCase();
						bouton�.setText(�);
						� = �.toUpperCase();
						bouton�.setText(�);
						
						caps = caps.toUpperCase();
						boutoncaps.setText(caps);
						
						isOn = true;
					}
					
					else if (isOn == true){
						� = �.toLowerCase();
						bouton�.setText(�);
						� = �.toLowerCase();
						bouton�.setText(�);
						� = �.toLowerCase();
						bouton�.setText(�);
						
						� = �.toLowerCase();
						bouton�.setText(�);
						� = �.toLowerCase();
						bouton�.setText(�);
						� = �.toLowerCase();
						bouton�.setText(�);
						
						� = �.toLowerCase();
						bouton�.setText(�);
						� = �.toLowerCase();
						bouton�.setText(�);
						� = �.toLowerCase();
						bouton�.setText(�);
						� = �.toLowerCase();
						bouton�.setText(�);
						
						caps = caps.toLowerCase();
						boutoncaps.setText(caps);
						
						isOn = false;
					}*/
				}
			});	
	     } 
}

