package nPuzzleUi;
import nPuzzle.*;
import nPuzzleUsuario.JogoStart;
import nPuzzleUsuario.MatrizAjuda;
import nPuzzleUsuario.Menu;
import nPuzzleUsuario.Ranking;
import nPuzzleUsuario.SalvarECarregar;
import nPuzzleUsuario.UsuarioInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.*;


public class MatrizPath implements ActionListener{
	 private String nome, modo;
	 private MatrizNumero mN;
	 private int segundos=0;
	 private int minutos=0;
	 private int count=0;
	 private Menu m;
	 private MatrizAjuda mA;	
	 private JogoStart jS;
	 private BufferedImage[][] Imagens;
	 private JLabel[][] label;
	 private JLabel labelContador,labelTemporizador,labelSalvar;
	 private JButton[] button;
	 private JButton [] buttonPausa= new JButton [2];
	 private JButton[] [] buttonGame;
	 private JButton buttonAjuda,buttonMenu,buttonSalvar;
	 private JFrame frame= new JFrame();
	 private int elapsedTime;
	 
	 	
	   
	    
	    public MatrizPath(int tamanhoTabuleiro,int nivelDeMaluquice,int [][]tabuleiro,int contadorDeMovimento,int[][] matrizResposta,boolean jogoPrevio) {
	    	mN= new MatrizNumero (tamanhoTabuleiro);
	    	if(jogoPrevio==false) {
	    	mN.criarTabuleiro();
	    	}else {
				mN.setContador(contadorDeMovimento);
				mN.setTabuleiroMatriz(tabuleiro);
				mN.setMatrizResposta(matrizResposta);	
			}
	    	
	    	frame.setSize(900, 900);
	    	Imagens = new BufferedImage [tamanhoTabuleiro] [tamanhoTabuleiro];
	    	setLabel(new JLabel [tamanhoTabuleiro] [tamanhoTabuleiro]);
			setButton(new JButton[4]);
			buttonGame = new JButton[tamanhoTabuleiro][tamanhoTabuleiro];
			criarButtons();
			mudarLabel();
			criarFrame();
	    	} 
	    
	    public void criarButtons() {
	    	mudarButton();
	    	
	    	buttonMenu= new JButton("Menu");
	    	buttonMenu.setBounds(700, 200, 100, 100);
	    	buttonMenu.setFocusable(false);
	    	buttonMenu.addActionListener(this);
	    	frame.add(buttonMenu);
	    	
	    	buttonSalvar = new JButton("Salvar");
	    	buttonSalvar.setBounds(700,400,100,100);
	    	buttonSalvar.setFocusable(false);
	    	buttonSalvar.addActionListener(this);
	    	frame.add(buttonSalvar);
	    	
	     	buttonAjuda=new JButton ("Ajuda");
	     	buttonAjuda.setBounds(700, 300, 100, 100);
	     	buttonAjuda.setFocusable(false);
	     	buttonAjuda.addActionListener(this);
	     	frame.add(buttonAjuda);
	    }
	    
	    
	    public void criarFrame() {
	    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	frame.setLayout(null);
    	    frame.setVisible(true);
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
	    				try {
	    					Imagens [i] [j] = ImageIO.read(new File("resource//Imagens//"+mN.getTabuleiro() [i] [j]+".jpg"));
							buttonGame[i][j] = new JButton(new ImageIcon(Imagens[i][j]));
							buttonGame[i][j].setBounds((140*j), (100*i), 140, 100);
							buttonGame[i][j].setBorder(BorderFactory.createEmptyBorder());
							buttonGame[i][j].addActionListener(this);
							frame.getContentPane().add(buttonGame[i][j]);
							
							 if(mN.getTabuleiro()[i][j]==mN.getMatrizResposta()[i][j]) {
			    				 buttonGame[i][j].setBorder(BorderFactory.createLineBorder(Color.green));
			    			 }
							
						} catch (IOException e) {
							System.err.print("Error ");
						}
	    			}
	    		}
	    }
	    
	    public void criarLabel() {
			mudarLabel();
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
			labelSalvar.setBounds(100, 800, 200, 100);
			frame.add(labelSalvar);
		}
	    
	    public boolean validarButton(int i, int j) {
	    	boolean valido=false;
	    	if(mN.getTabuleiro()[i][j]==mN.pecasMoviNum[0]) {
	    		
	    		valido=true;
	    		return true;
	    	}else if(mN.getTabuleiro()[i][j]==mN.pecasMoviNum[1]) {
	    		
	    		valido=true;
	    		return true;
	    	}else if(mN.getTabuleiro()[i][j]==mN.pecasMoviNum[2]) {
	    		
	    		valido=true;
	    		return true;
	    	}else if(mN.getTabuleiro()[i][j]==mN.pecasMoviNum[3]) {
	    		
	    		valido=true;
	    		return true;
	    	}
	    	return valido;
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
	    public void actionPerformed(ActionEvent e) {
	    	for(int i=0;i<mN.getTamanhoTabuleiro();i++) {
	    		if(e.getSource()==buttonAjuda) {
		    		mA= new MatrizAjuda(mN.getTamanhoTabuleiro(),"A");
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
					 mudarButton();
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
	    			
	    			if(e.getSource()==buttonGame[i][j]&& validarButton(i,j)&& mN.getTabuleiro()[i][j]!=0) {
	    				if(count==0) {
	    					count=1;
	    					StartTimer();
	    					
	    				}
	    				mN.moverPecaP(mN.getTabuleiro()[i][j]);
	    				mN.winCondition();
	        			if(mN.getWinCon()==(mN.getTamanhoTabuleiro()*mN.getTamanhoTabuleiro())) {
	        				frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	        				frame.setVisible(false);
	        				Ranking r= new Ranking();
	        				r.verificarPontuacao(elapsedTime, modo, nome, mN.getTamanhoTabuleiro(), 0);
	        			}
	    				frame.getContentPane().removeAll();
	    				criarButtons();
	    				mudarLabel();
	    				if(count==1) {
	    				labelTemporizador();
	    				}
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
			user.setNivelDeMaluquice(0);
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

		
	    
	    //public static void main(String[] args) {
	    	//MatrizNumero mN = new MatrizNumero(3);
	    	//mN.criarTabuleiro();
	    	//mN.posicaoDe0();
	    	//mN.pecaMovimentaveis();
	    	//MatrizPath mP = new MatrizPath(3);
	    	//mP.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	    //mP.frame.setLayout(null);
    	    //mP.frame.setVisible(true);
	    	
	    //}
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

		public JButton[] getButton() {
			return button;
		}

		public void setButton(JButton[] button) {
			this.button = button;
		}

		public JLabel[][] getLabel() {
			return label;
		}

		public void setLabel(JLabel[][] label) {
			this.label = label;
		}

		public int getElapsedTime() {
			return elapsedTime;
		}

		public void setElapsedTime(int elapsedTime) {
			this.elapsedTime = elapsedTime;
		}	
	    
	    
	 }

		
	
