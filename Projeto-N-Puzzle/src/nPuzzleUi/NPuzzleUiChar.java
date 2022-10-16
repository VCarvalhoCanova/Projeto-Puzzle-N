package nPuzzleUi;

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
import nPuzzleUsuario.SalvarECarregar;
import nPuzzleUsuario.UsuarioInfo;

public class NPuzzleUiChar implements ActionListener {
	 private String nome,modo; 
	 private int count=0;
	 private int elapsedTime;	
	 private int segundos=0;
	 private int minutos=0;
	 private int horas=0;
	 private MatrizNPuzzleMalucoNumero mNM;
	 private MatrizNumero mN;
	 private JogoStart jS;
	 private Menu m;
	 private MatrizAjuda mA;
	 private JButton[] [] button;
	 private JButton buttonAjuda,buttonMenu,buttonSalvar;
	 private JFrame frame= new JFrame();
	 private JLabel labelContador,labelTemporizador;
		
	 
	 public NPuzzleUiChar(int tamanhoTabuleiro,int nivelDeMaluquice,int [][]tabuleiro,int contadorDeMovimento,boolean jogoPrevio){
			mN= new MatrizNumero (tamanhoTabuleiro);
			mNM = new MatrizNPuzzleMalucoNumero(nivelDeMaluquice);
			if(jogoPrevio==false) {
		    	mN.criarTabuleiro();
				}else {
					mN.setContador(contadorDeMovimento);
					for(int i=0;i<tamanhoTabuleiro;i++) {
						for(int j=0;j<tamanhoTabuleiro;j++) {
							mN.setTabuleiroMatriz(tabuleiro);
							System.out.println(mN.getTabuleiro()[i][j]);
						}
					}			
				}
	    	button = new JButton [tamanhoTabuleiro][tamanhoTabuleiro];

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
			
			
			
		
		
		public void mudarButton() {
			mN.posicaoDe0();
	    	mN.pecaMovimentaveis();
			for(int i=0;i<mN.getTamanhoTabuleiro();i++) {
	    		for(int j=0;j<mN.getTamanhoTabuleiro();j++) {
	    			if(mN.getTabuleiro()[i][j]==0) {
	    				button[i][j]= new JButton(" ");
	    			}else {
	    				button[i][j]= new JButton(" "+((char) (mN.getTabuleiro()[i][j]+64)));
	    			}
	    					button[i][j].setBounds(100*j,125*i,80,80);
	    			    	button[i][j].setFocusable(false);
	    			    	button[i][j].addActionListener(this);	
	    			    	frame.getContentPane().add(button[i][j]);
	    			    		}

	    			
	    		}

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
		 
		 public void labelTemporizador() {
			 minutos=(getElapsedTime()/60000)%60;
			 segundos=(getElapsedTime()/1000)%60;
			 labelTemporizador= new JLabel("Tempo: "+minutos+": "+segundos);
			 labelTemporizador.setBounds(0, 600, 150, 100);
			 frame.add(labelTemporizador);
		}
		
		 
		 public void mudarLabel() {
				labelContador= new JLabel("Movimentos feitos "+mN.getContador());
				labelContador.setBounds(0, (100*mN.getTamanhoTabuleiro())+100, 200, 100);
				frame.add(labelContador);
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
		 

		@Override
		public void actionPerformed(ActionEvent e) {
			for(int i=0;i<mN.getTamanhoTabuleiro();i++) {
				
				if(e.getSource()==buttonAjuda) {
		    		mA= new MatrizAjuda(mN.getTamanhoTabuleiro(),"C");
		    		break;
				}if(e.getSource()==buttonMenu) {
					m= new Menu(false);
					m.pausa();
					break;
				}
				if(e.getSource()==buttonSalvar) {
					salvarJogo();
					break;
				}
					if(e.getSource()==buttonMenu) {
						m= new Menu(false);
						m.pausa();
						break;
					}

		    		
		    		
		    	for(int j=0;j<mN.getTamanhoTabuleiro();j++) {
					
		    		if(e.getSource()==button[i][j]&& validarButton(i,j)&& mN.getTabuleiro()[i][j]!=0) {
		    			if(count==0) {
		    				count=1;
		    				StartTimer();
		    				labelTemporizador();
		    			}
		    			
		    			mN.moverPecaP(mN.getTabuleiro()[i][j]);
		    			if(mNM.getNivelDeMaluquice()!=0) {
		    				mNM.chanceDeEmbaralhar();
		    			}
		    			frame.getContentPane().removeAll();
						criarButton();
						mudarLabel();
						labelTemporizador();
						frame.repaint();
						break;
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
			user.setElapsedTime(getElapsedTime());
			
			try {
				SalvarECarregar.save(user, "resource//1.save");
				System.out.println("salvo");
				System.out.println(user.getModoDeJogo());
			}catch(Exception e){
					System.out.print("Não conseguiu Salvar");
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
