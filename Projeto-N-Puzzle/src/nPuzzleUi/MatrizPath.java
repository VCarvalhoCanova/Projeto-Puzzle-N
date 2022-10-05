package nPuzzleUi;
import nPuzzle.*;
import nPuzzleUsuario.MatrizAjuda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.*;


public class MatrizPath implements ActionListener{
	 
	 private int []imagensMovimentaveis = new int [4];
	 private MatrizPath mP;
	 private MatrizNumero mN;
	 private MatrizAjuda mA;
	 private BufferedImage[][] Imagens;
	 private JLabel[][] label;
	 private JButton[] button;
	 private JButton buttonAjuda;
	 private JFrame frame= new JFrame();
	 
	 	
	   
	    
	    public MatrizPath(int tamanhoTabuleiro) {
	    	mN= new MatrizNumero (tamanhoTabuleiro);
	    	mN.criarTabuleiro();
	    	mN.posicaoDe0();
	    	mN.pecaMovimentaveis();
	    	frame.setSize(800, 800);
	    	Imagens = new BufferedImage [tamanhoTabuleiro] [tamanhoTabuleiro];
	    	label = new JLabel [tamanhoTabuleiro] [tamanhoTabuleiro];
			button = new JButton[4];
			criarLabels();
			criarButton();
			criarFrame();
	    	} 
	    
	    public void criarLabels() {
	    	for(int i=0;i<mN.getTamanhoTabuleiro();i++) {
    		for(int j=0;j<mN.getTamanhoTabuleiro();j++) {
    				try {
						Imagens [i] [j] = ImageIO.read(new File("resource//Imagens//"+mN.getTabuleiro() [i] [j]+".jpg"));
						label[i][j] = new JLabel(new ImageIcon(Imagens[i][j]));
						label[i][j].setBounds((100*j), (120*i), 85, 100);
						frame.getContentPane().add(label[i][j]);
					} catch (IOException e) {
						System.err.print("Error ");
					}
    			
    		}
    	}
	    }
	    
	    public void criarButton() {
	    	for(int k=0;k<4;k++) {
	    		if(mN.pecasMoviNum[k]!=0) {
	    		System.out.println("foi adicionado"+mN.pecasMoviNum[k]);
	    		button[k]= new JButton (" "+mN.pecasMoviNum[k]);
	    		button[k].setBounds(500,125*k,80,80);
		    	button[k].setFocusable(false);
		        button[k].addActionListener(this);
		        frame.getContentPane().add(button[k]);

	    		}

	    	}
	    	buttonAjuda=new JButton ("Ajuda");
	    	buttonAjuda.setBounds(200, 300, 100, 100);
	    	buttonAjuda.setFocusable(false);
	    	buttonAjuda.addActionListener(this);
	    	frame.add(buttonAjuda);
	    }
	    
	    public void criarFrame() {
	    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	frame.setLayout(null);
    	    frame.setVisible(true);
	    }
	    
	    public void mudarLabel() {
	    	for(int i=0;i<mN.getTamanhoTabuleiro();i++) {
	    		for(int j=0;j<mN.getTamanhoTabuleiro();j++) {
	    				try {
	    					frame.getContentPane().remove(label[i][j]);
							Imagens [i] [j] = ImageIO.read(new File("resource//Imagens//"+mN.getTabuleiro() [i] [j]+".jpg"));
							label[i][j] = new JLabel(new ImageIcon(Imagens[i][j]));
							label[i][j].setBounds((100*j), (120*i), 85, 100);
							frame.getContentPane().add(label[i][j]);
							
						} catch (IOException e) {
							System.err.print("Error ");
						}
	    			}
	    		}
	    }
	    
	    private void mudarButton() {
	    	mN.posicaoDe0();
	    	mN.pecaMovimentaveis();
	    	   	for(int k=0;k<4;k++) {
	    		if(mN.pecasMoviNum[k]!=0) {
	    			button[k]= new JButton (" "+mN.pecasMoviNum[k]);
	    			System.out.println("foi adicionado"+mN.pecasMoviNum[k]);
		    		button[k].setBounds(500,125*k,80,80);
			    	button[k].setFocusable(false);
			        button[k].addActionListener(this);
			        frame.add(button[k]);
	    		}else {
	    			button[k]=new JButton(" ");
	    			button[k].setBounds(500,125*k,80,80);
			    	button[k].setFocusable(false);
			        button[k].addActionListener(this);
			        button[k].setVisible(false);
			        frame.add(button[k]);
	    		}
	    	}
	    	
	    				
	    }
	    
	    
	    public void actionPerformed(ActionEvent e) {
	    	if(e.getSource()==button[0]) {
	    		mN.moverPecaP(mN.pecasMoviNum[0]);
	    		mudarLabel();
	    		mudarButton();
	    		frame.repaint();
	    	}else if(e.getSource()==button[1]) {
	    		mN.moverPecaP(mN.pecasMoviNum[1]);
	    		mudarLabel();
	    		mudarButton();
	    		frame.repaint();
	    	}else if(e.getSource()==button[2]) {
	    		mN.moverPecaP(mN.pecasMoviNum[2]);
	    		mudarLabel();
	    		mudarButton();
	    		frame.repaint();
	    	}else if (e.getSource()==button[3]) {
	    		mN.moverPecaP(mN.pecasMoviNum[3]);
	    		mudarLabel();
	    		mudarButton();
	    		frame.repaint();
	    	}if(e.getSource()==buttonAjuda) {
	    		mA= new MatrizAjuda(3);
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
	    
	    
	 }

		
	
