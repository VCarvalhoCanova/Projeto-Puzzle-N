package nPuzzleUi;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

import nPuzzle.MatrizNumero;
import nPuzzleMaluco.MatrizNPuzzleMalucoNumero;
import nPuzzleUsuario.JogoStart;
import nPuzzleUsuario.MatrizAjuda;
import nPuzzleUsuario.Menu;
import nPuzzleUsuario.Ranking;
import nPuzzleUsuario.SalvarECarregar;
import nPuzzleUsuario.UsuarioInfo;

public class PuzzleUiNumero implements ActionListener {
	 private int nivelDeMaluquice,dificuldade;
	 private int count=0;
	 private int elapsedTime=0;	
	 private int segundos=0;
	 private int minutos=0;
	 private int horas=0;
	 private String nome, modo;
	 private MatrizNumero mN;
	 private JogoStart jS;
	 private MatrizNPuzzleMalucoNumero mNM;
	 private Menu m;
	 private UsuarioInfo user;
	 private MatrizAjuda mA;
	 private JButton[] [] button;
	 private JButton [] buttonPausa= new JButton [2];
	 private JButton buttonAjuda, buttonMenu,buttonSalvar;
	 private JLabel labelContador,labelTemporizador,labelSalvar;
	 private JFrame frame= new JFrame();
	 
	  	 
	 
	public PuzzleUiNumero(int tamanhoTabuleiro,int nivelDeMaluquice,int [][]tabuleiro,int contadorDeMovimento,int [][] matrizResposta,boolean jogoPrevio){
		mN= new MatrizNumero (tamanhoTabuleiro);
		mNM = new MatrizNPuzzleMalucoNumero(nivelDeMaluquice);
		button = new JButton [tamanhoTabuleiro][tamanhoTabuleiro];
		if(jogoPrevio==false) {
    	mN.criarTabuleiro();
		
		}else {
			mN.setContador(contadorDeMovimento);
			mN.setTabuleiroMatriz(tabuleiro);
			mN.setMatrizResposta(matrizResposta);
				
						
		}
		frame.setSize(800, 800);
		criarButton();
		mudarLabel();
		criarFrame();
	}
	
	
	
	
	public void criarButton(){
	 mudarButton();	    	
	 
	buttonMenu= new JButton("Menu");
	buttonMenu.setBounds(600, 200, 100, 100);
	buttonMenu.setFocusable(false);
	buttonMenu.addActionListener(this);
	frame.add(buttonMenu);
	
	buttonSalvar = new JButton("Salvar");
	buttonSalvar.setBounds(600,400,100,100);
	buttonSalvar.setFocusable(false);
	buttonSalvar.addActionListener(this);
	frame.add(buttonSalvar);
	
 	buttonAjuda=new JButton ("Ajuda");
 	buttonAjuda.setBounds(600, 300, 100, 100);
 	buttonAjuda.setFocusable(false);
 	buttonAjuda.addActionListener(this);
 	frame.add(buttonAjuda);
 	mNM.setMN(mN);
	}
		
	public void pausa() {
		buttonPausa[0]= new JButton("Continuar");
    	buttonPausa[0].setBounds(300, 200, 300, 100);
    	buttonPausa[0].setFocusable(false);
    	buttonPausa[0].addActionListener(this);
    	frame.getContentPane().add(buttonPausa[0]);
    			
    	buttonPausa[1]=new JButton("Voltar ao menu Principal");
    	buttonPausa[1].setBounds(300, 500, 300, 100);
    	buttonPausa[1].setFocusable(false);
    	buttonPausa[1].addActionListener(this);
    	frame.getContentPane().add(buttonPausa[1]);
    	
	}
		
	
	
	public void mudarButton() {
		mN.posicaoDe0();
    	mN.pecaMovimentaveis();
		for(int i=0;i<mN.getTamanhoTabuleiro();i++) {
    		for(int j=0;j<mN.getTamanhoTabuleiro();j++) {
    			if(mN.getTabuleiro()[i][j]==0) {
    				button[i][j]= new JButton(" ");
    			}else {
    				button[i][j]= new JButton(" "+mN.getTabuleiro()[i][j]);
    			}
    				button[i][j].setBounds(100*j,125*i,80,80);
    			   	button[i][j].setFocusable(false);
    			   	button[i][j].addActionListener(this);	
    			   	frame.getContentPane().add(button[i][j]);
    			 
    			 if(mN.getTabuleiro()[i][j]==mN.getMatrizResposta()[i][j]) {
    				 button[i][j].setBackground(Color.green);
    			 }
    			    	
    			    		}
    			
    		}

	}	
	
	public void labelTemporizador() {
		 minutos=(getElapsedTime()/60000)%60;
		 segundos=(getElapsedTime()/1000)%60; 
		 labelTemporizador= new JLabel("Tempo: "+minutos+": "+segundos);
		 labelTemporizador.setBounds(0, 700, 150, 100);
		 frame.add(labelTemporizador);
	}
	
	public void mudarLabel() {
		labelContador= new JLabel("Movimentos feitos "+mN.getContador());
		labelContador.setBounds(0, (100*mN.getTamanhoTabuleiro())+100, 200, 100);
		frame.add(labelContador);
	}
	public void foiPossivelSalvar() {
		labelSalvar= new JLabel("Foi possivel salvar");
		labelSalvar.setBounds(200, 600, 200, 100);
		frame.add(labelSalvar);
	}
	public void naoFoiPossivelSalvar() {
		labelSalvar= new JLabel("Não foi possivel Salvar");
		labelSalvar.setBounds(200, 600, 200, 100);
		frame.add(labelSalvar);
	}
	
	 public boolean validarButton(int i, int j) {
	    	boolean valido=false;
	    	if(mN.getTabuleiro()[i][j]==mN.pecasMoviNum[0]) {
	    		//System.out.println(mN.getTabuleiro()[i][j]);
	    		valido=true;
	    		return true;
	    	}else if(mN.getTabuleiro()[i][j]==mN.pecasMoviNum[1]) {
	    		//System.out.println(mN.getTabuleiro()[i][j]);
	    		valido=true;
	    		return true;
	    	}else if(mN.getTabuleiro()[i][j]==mN.pecasMoviNum[2]) {
	    		//System.out.println(mN.getTabuleiro()[i][j]);
	    		valido=true;
	    		return true;
	    	}else if(mN.getTabuleiro()[i][j]==mN.pecasMoviNum[3]) {
	    		//System.out.println(mN.getTabuleiro()[i][j]);
	    		valido=true;
	    		return true;
	    	}
	    	return valido;
	    }
		
	public void criarFrame() {
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setLayout(null);
	    frame.setVisible(true);
    }

	Timer time = new Timer(1000, new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				frame.getContentPane().remove(labelTemporizador);
			}catch(Exception a){
				
			}
			
			setElapsedTime(getElapsedTime()+1000);
			labelTemporizador();
			frame.repaint();
		}
	    }); 
	
	public void StartTimer() {
		time.start();
	}
	
	public void stopTimer() {
		time.stop();
	}
	
		@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<mN.getTamanhoTabuleiro();i++) {
			if(e.getSource()==buttonAjuda) {
				mA= new MatrizAjuda(mN.getTamanhoTabuleiro(),"N");
				break;
				
    	}
			if(e.getSource()==buttonMenu) {
				frame.getContentPane().removeAll();
				pausa();
				frame.repaint();
				stopTimer();
				count=0;
				break;
			}
			
			 if(e.getSource()==buttonPausa[0]) {
				 frame.getContentPane().removeAll();
				 criarButton();
				 mudarLabel();
		    	 frame.repaint();
		       }else if(e.getSource()==buttonPausa[1]) {
		    	   frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		    	   frame.setVisible(false);
		    	   jS = new JogoStart();
		    	   jS.layout();
		    	   break;
		       }
			
			if(e.getSource()==buttonSalvar) {
				salvarJogo();
				frame.repaint();
				break;
			}
			
			
			for(int j=0;j<mN.getTamanhoTabuleiro();j++) {
			
    		if(e.getSource()==button[i][j]&& validarButton(i,j)&& mN.getTabuleiro()[i][j]!=0) {
    			if(count==0) {
    				count=1;
    				StartTimer();
    				frame.repaint();
    			}
    			
    			mN.moverPecaP(mN.getTabuleiro()[i][j]);
    			mN.winCondition();
    			if(mN.getWinCon()==(mN.getTamanhoTabuleiro()*mN.getTamanhoTabuleiro())) {
    				frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    				frame.setVisible(false);
    				Ranking r= new Ranking();
    				r.verificarPontuacao(mN.getContador(), modo,nome,mN.getTamanhoTabuleiro(), mNM.getNivelDeMaluquice());
    			}
    			if(mNM.getNivelDeMaluquice()!=0) {
    				mNM.chanceDeEmbaralhar();
    			}
    			frame.getContentPane().removeAll();
				criarButton();
				mudarLabel();
				labelTemporizador();
				frame.repaint();
				}
    		}
		}
		
		}
	
	
	public void salvarJogo() {
		UsuarioInfo user = new UsuarioInfo();
		user.setNome(nome);
		user.setModoDeJogo(modo);
		user.setDificuldade(mN.getTamanhoTabuleiro());
		user.setNivelDeMaluquice(mNM.getNivelDeMaluquice());
		user.setContadorDePassos(mN.getContador());
		user.setTabuleiro(mN.getTabuleiro());
		user.setMatrizResposta(mN.getMatrizResposta());
		user.setElapsedTime(elapsedTime);
		
		try {
			SalvarECarregar.save(user, "resource//1.save");
			foiPossivelSalvar();
			
		}catch(Exception e){
			naoFoiPossivelSalvar();
		}
	}
	
	
	
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getModo() {
		return modo;
	}

	public void setModo(String modo) {
		this.modo = modo;
	}




	public int getElapsedTime() {
		return elapsedTime;
	}




	public void setElapsedTime(int elapsedTime) {
		this.elapsedTime = elapsedTime;
	}	
	
}
