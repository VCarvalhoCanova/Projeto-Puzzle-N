package nPuzzleUsuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import nPuzzleUsuario.Ranking;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Menu implements ActionListener {
	private JogoStart jS= new JogoStart();
	private Ranking r;
	private String nome,modoMaluco;
	private int nivelDeMaluquice,cont=0;
	private String acao;
	private String str = "Digite seu nome";
	private final static String newline = "\n";
	private JTextField textField;
    private JTextArea textArea;
	private JLabel label;
	private JButton buttonReturn;
	private JButton [] buttonPausa= new JButton[2];
	private JButton [] buttonStart = new JButton[4];
	private JButton [] buttonMaluquice = new JButton[3];
	private JButton [] buttonDificuldade= new JButton [3];
	private JButton [] buttonModo = new JButton [5];
	private JFrame frame= new JFrame();

	
	public Menu(boolean saveAnterior) {
		criarFrame();
	}
	
	
    public void criarFrame() {
    	frame.setSize(800, 800);
    	frame.setLayout(null);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
    }
    
    
    public void Return() {
    	
    	buttonReturn= new JButton("Retornar ao menu principal");
    	buttonReturn.setBounds(300, 500, 300, 100);
    	buttonReturn.setFocusable(false);
    	buttonReturn.addActionListener(this);
    	frame.getContentPane().add(buttonReturn);
    }
    
    
    public void naoPodeCarregar() {
    	frame.getContentPane().removeAll();
    	label= new JLabel("Nao foi possivel carregar o jogo");
    	label.setBounds(300, 300, 200, 100);
    	label.setVisible(true);
    	frame.getContentPane().add(label);
    	Return();
    	frame.repaint();
    }
    
	public void menuStart() {
		label = new JLabel("Bem vindo a NPuzzle");
		label.setVisible(true);
		label.setBounds(245, 100, 200, 100);
		frame.getContentPane().add(label);
		
		buttonStart[0]= new JButton("Start");
		buttonStart[0].setBounds(200, 300, 200, 100);
		buttonStart[0].setFocusable(false);
		buttonStart[0].addActionListener(this);
		frame.getContentPane().add(buttonStart[0]);
		
		buttonStart[1]= new JButton("Sair do jogo");
		buttonStart[1].setBounds(200, 600, 200, 100);
		buttonStart[1].setFocusable(false);
		buttonStart[1].addActionListener(this);
		frame.getContentPane().add(buttonStart[1]);
		
		buttonStart[2]= new JButton("Carregar");
		buttonStart[2].setBounds(200, 400, 200, 100);
		buttonStart[2].setFocusable(false);
		buttonStart[2].addActionListener(this);
		frame.getContentPane().add(buttonStart[2]);
		
		buttonStart[3]=new JButton("Ranking");
		buttonStart[3].setBounds(200, 500, 200, 100);
		buttonStart[3].setFocusable(false);
		buttonStart[3].addActionListener(this);
		frame.getContentPane().add(buttonStart[3]);
		

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
    	   frame.getContentPane().removeAll();
    	   usuarioNome();
    	   frame.repaint();
    	   
       }if(e.getSource()==buttonStart[1]) {
    	   frame.setVisible(false);
    	   
       }if(e.getSource()==buttonStart[2]) {
    	   frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    	   frame.setVisible(false);
    	   jS.CarregarJogo();
       }if(e.getSource()==buttonStart[3]) {
    	   setR(new Ranking());
    	   r.criarLabelRanking();
    	   r.criarFrame();
       }
       
       if(e.getSource()==buttonReturn) {
    	   frame.getContentPane().removeAll();
    	   menuStart();
    	   frame.repaint();
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
        	jS.setModo("N");
        	jS.layoutJogo(false);
        	frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        	frame.setVisible(false);
        	
        }else if(e.getSource()==buttonModo[1]) {
        	jS.setModo("NM");
        	frame.getContentPane().removeAll();
        	nivelDeMaluquice();
        	frame.repaint();
        }else if(e.getSource()==buttonModo[2]) {
        	jS.setModo("C");
        	jS.layoutJogo(false);
        	frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        	frame.setVisible(false);
        }else if(e.getSource()==buttonModo[3]) {
        	jS.setModo("CM");
        	frame.getContentPane().removeAll();
        	nivelDeMaluquice();
        	frame.repaint();
        }else if(e.getSource()==buttonModo[4]) {
        	jS.setModo("P");
        	jS.layoutJogo(false);
        	frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        	frame.setVisible(false);
        }
        
        if(e.getSource()==buttonMaluquice[0]) {
        	nivelDeMaluquice=3;
        	jS.setNivelDeMaluquice(3);
        	jS.layoutJogo(false);
        	frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        	frame.setVisible(false);
        	
        }else if(e.getSource()==buttonMaluquice[1]) {
        	nivelDeMaluquice=6;
        	jS.setNivelDeMaluquice(6);
        	jS.layoutJogo(false);
        	frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        	frame.setVisible(false);
        	
        }else if(e.getSource()==buttonMaluquice[2]){
        	nivelDeMaluquice=9;
        	jS.setNivelDeMaluquice(9);
        	jS.layoutJogo(false);
        	frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        	frame.setVisible(false);
        	
        }
        
        
		if(e.getSource()==textField) {
			nome=textField.getText(); 
			jS.setNome(nome);
	        textField.selectAll();
	        textArea.setCaretPosition(textArea.getDocument().getLength());
	        System.out.println(nome);
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


	public void setNome(String nome) {
		this.nome=nome;
		
	}


	public Ranking getR() {
		return r;
	}


	public void setR(Ranking r) {
		this.r = r;
	}



}
