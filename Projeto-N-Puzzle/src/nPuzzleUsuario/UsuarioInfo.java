package nPuzzleUsuario;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class UsuarioInfo implements ActionListener{
	
	private JogoStart jS= new JogoStart();
	private String nome,modoMaluco;
	private int nivelDeMaluquice;
	private String acao;
	private String str = "Digite seu nome";
	private final static String newline = "\n";
	private JTextField textField;
    private JTextArea textArea;
	private JLabel label;
	private JButton [] buttonStart = new JButton[2];
	private JButton [] buttonMaluquice = new JButton[3];
	private JButton [] buttonDificuldade= new JButton [3];
	private JButton [] buttonModo = new JButton [5];
	private JFrame frame= new JFrame();
	
	public UsuarioInfo() {
		frame.setSize(800, 800);
		menuStart();
		criarFrame();
	}
	

    public void criarFrame() {
    	frame.setLayout(null);
	    frame.setVisible(true);
    }
    
	public void menuStart() {
		label = new JLabel("Bem vindo a NPuzzle");
		label.setVisible(true);
		label.setBounds(100, 400, 200, 200);
		
		buttonStart[0]= new JButton("Start");
		buttonStart[0].setBounds(300, 400, 200, 200);
		buttonStart[0].setFocusable(false);
		buttonStart[0].addActionListener(this);
		frame.getContentPane().add(buttonStart[0]);
		
		buttonStart[1]= new JButton("Start");
		buttonStart[1].setBounds(500, 400, 200, 200);
		buttonStart[1].setFocusable(false);
		buttonStart[1].addActionListener(this);
		frame.getContentPane().add(buttonStart[1]);

	}
    
	public void usuarioNome() {
		//System.out.print("Digite seu Nome: ");
		label = new JLabel(" "+ str);
		label.setVisible(true);
		label.setBounds(200, 300, 100, 100);
		
		textField = new JTextField(20);
		textField.setBounds(300, 300, 100, 100);
        textField.addActionListener(this);
 
        textArea = new JTextArea(5, 20);
        textArea.setBounds(300, 300, 100, 100);
        textArea.setEditable(false);

        frame.getContentPane().add(label);
        frame.getContentPane().add(textField);
        frame.getContentPane().add(textArea);
	}
	
	public void modoDeJogo() {
		buttonModo[0] = new JButton("Numeros");
		buttonModo[1] = new JButton("Numeros Malucos");
		buttonModo[2] = new JButton("Caracteres ");
		buttonModo[3] = new JButton("caracteres Malucos ");
		buttonModo[4] = new JButton("Path ");
		
		for(int i=0;i<5;i++) {
			buttonModo[i].setBounds(300, (100*i)+100, 200, 50);
			buttonModo[i].setFocusable(false);
			buttonModo[i].addActionListener(this);
			frame.getContentPane().add(buttonModo[i]);
		}

		
	}
	
	public void dificuldadeDoJogo() {
		buttonDificuldade[0] = new JButton("Facil");
		buttonDificuldade[1]= new JButton("medio");
		buttonDificuldade[2]= new JButton("dificil");
		
		for(int i=0;i<3;i++) {
			buttonDificuldade[i].setBounds(300,(100*i)+100, 100, 50);
			buttonDificuldade[i].setFocusable(false);
			buttonDificuldade[i].addActionListener(this);
			frame.getContentPane().add(buttonDificuldade[i]);
		}
		
		
	}
	public void nivelDeMaluquice() {
		buttonMaluquice[0] = new JButton("Quase normal");
		buttonMaluquice[1]= new JButton("Maluco");
		buttonMaluquice[2]= new JButton("Insano");
		
		for(int i=0;i<3;i++) {
			buttonMaluquice[i].setBounds(300,(100*i)+100, 100, 50);
			buttonMaluquice[i].setFocusable(false);
			buttonMaluquice[i].addActionListener(this);
			frame.getContentPane().add(buttonMaluquice[i]);
		}
	
		
	}
	
	public void actionPerformed(ActionEvent e) {
       if(e.getSource()==buttonStart[0]) {
    	   usuarioNome();
       }if(e.getSource()==buttonStart[1]) {
    	   frame.setVisible(false);
       }
		
		if(e.getSource()==buttonDificuldade[0]) {
        	jS.setDificuldade(3);
	        frame.getContentPane().removeAll();
	        modoDeJogo();
	        frame.repaint();

        }else if(e.getSource()==buttonDificuldade[1]) {
        	jS.setDificuldade(4);
	        frame.getContentPane().removeAll();
	        modoDeJogo();
	        frame.repaint();

        }else if(e.getSource()==buttonDificuldade[2]) {
        	jS.setDificuldade(5);
	        frame.getContentPane().removeAll();
	        modoDeJogo();
	        frame.repaint();
        }
		
        if(e.getSource()==buttonModo[0]) {
        	jS.layoutJogo("N");
        	frame.setVisible(false);
        }else if(e.getSource()==buttonModo[1]) {
        	modoMaluco="NM";
        	frame.getContentPane().removeAll();
        	nivelDeMaluquice();
        	frame.repaint();
        }else if(e.getSource()==buttonModo[2]) {
        	jS.layoutJogo("C");
        	frame.setVisible(false);
        }else if(e.getSource()==buttonModo[3]) {
        	modoMaluco="CM";
        	frame.getContentPane().removeAll();
        	nivelDeMaluquice();
        	frame.repaint();
        }else if(e.getSource()==buttonModo[4]) {
        	jS.layoutJogo("P");
        	frame.setVisible(false);
        }
        
        if(e.getSource()==buttonMaluquice[0]) {
        	nivelDeMaluquice=3;
        	jS.setNivelDeMaluquice(3);
        	jS.layoutJogo(modoMaluco);
        	frame.setVisible(false);
        	
        }else if(e.getSource()==buttonMaluquice[1]) {
        	nivelDeMaluquice=6;
        	jS.setNivelDeMaluquice(6);
        	jS.layoutJogo(modoMaluco);
        	frame.setVisible(false);
        	
        }else if(e.getSource()==buttonMaluquice[2]){
        	nivelDeMaluquice=9;
        	jS.setNivelDeMaluquice(9);
        	jS.layoutJogo(modoMaluco);
        	frame.setVisible(false);
        	
        }
        
        
		if(jS.getNome().equalsIgnoreCase("default")) {
			jS.setNome(textField.getText()); 
	        textField.selectAll();
	        textArea.setCaretPosition(textArea.getDocument().getLength());
	        System.out.println(jS.getNome());
	        frame.getContentPane().removeAll();
	        dificuldadeDoJogo();
	        frame.repaint();
		}
		
		
    }
	
	public String getNome() {
		return nome;
	}

	public String getAcao() {
		return acao;
	}
	
	public int getNivelDeMaluquice() {
		return nivelDeMaluquice;
	}
	
}
