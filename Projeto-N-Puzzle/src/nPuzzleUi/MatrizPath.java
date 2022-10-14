package nPuzzleUi;
import nPuzzle.*;
import nPuzzleMaluco.MatrizNPuzzleMaluco;
import nPuzzleUsuario.MatrizAjuda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.imageio.*;


public class MatrizPath implements ActionListener{
	 
	 private int []imagensMovimentaveis = new int [4];
	 private MatrizPath mP;
	 private MatrizNumero mN;
	 private MatrizAjuda mA;	 
	 private BufferedImage[][] Imagens;
	 private JLabel[][] label;
	 private JButton[] button;
	 private JButton[] [] buttonGame;
	 private JButton buttonAjuda;
	 private JFrame frame= new JFrame();
	 
	 	
	   
	    
	    public MatrizPath(int tamanhoTabuleiro) {
	    	mN= new MatrizNumero (tamanhoTabuleiro);
	    	mN.criarTabuleiro();
	    	frame.setSize(800, 800);
	    	Imagens = new BufferedImage [tamanhoTabuleiro] [tamanhoTabuleiro];
	    	label = new JLabel [tamanhoTabuleiro] [tamanhoTabuleiro];
			button = new JButton[4];
			buttonGame = new JButton[tamanhoTabuleiro][tamanhoTabuleiro];
			criarButtons();
			criarFrame();
	    	} 
	    
	    public void criarButtons() {
	    	mudarButton();
	    	
	    	buttonAjuda=new JButton ("Ajuda");
	    	buttonAjuda.setBounds(400, 300, 100, 100);
	    	buttonAjuda.setFocusable(false);
	    	buttonAjuda.addActionListener(this);
	    	frame.add(buttonAjuda);
	    }
	    
	    
	    public void criarFrame() {
	    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	frame.setLayout(null);
    	    frame.setVisible(true);
	    }
	    
	   
	    
	    
	    public void mudarButton() {
	    	mN.posicaoDe0();
	    	mN.pecaMovimentaveis();
	    	for(int i=0;i<mN.getTamanhoTabuleiro();i++) {
	    		for(int j=0;j<mN.getTamanhoTabuleiro();j++) {
	    				try {
	    					Imagens [i] [j] = ImageIO.read(new File("resource//Imagens//"+mN.getTabuleiro() [i] [j]+".jpg"));
							buttonGame[i][j] = new JButton(new ImageIcon(Imagens[i][j]));
							buttonGame[i][j].setBounds((100*j), (120*i), 75, 120);
							buttonGame[i][j].setBorder(BorderFactory.createEmptyBorder());
							buttonGame[i][j].addActionListener(this);
							frame.getContentPane().add(buttonGame[i][j]);
							
						} catch (IOException e) {
							System.err.print("Error ");
						}
	    			}
	    		}
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
	    
	    public void actionPerformed(ActionEvent e) {
	    	for(int i=0;i<mN.getTamanhoTabuleiro();i++) {
	    		if(e.getSource()==buttonAjuda) {
		    		mA= new MatrizAjuda(mN.getTamanhoTabuleiro(),"A");
		    		break;
	    		}
	    		for(int j=0;j<mN.getTamanhoTabuleiro();j++) {
	    			
	    			if(e.getSource()==buttonGame[i][j]&& validarButton(i,j)) {
	    				// System.out.println(mN.getTabuleiro()[i][j]);
	    				mN.moverPecaP(mN.getTabuleiro()[i][j]);
	    				// System.out.println(mN.getTabuleiro()[i][j]);
	    				frame.getContentPane().removeAll();
	    				criarButtons();
	    				frame.repaint();
	    				break;
	    	}
	    }
	   
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

		
	
