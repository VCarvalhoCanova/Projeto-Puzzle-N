package nPuzzle;
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
	 
	 private Matriz m = new Matriz();
	 private int []imagensMovimentaveis;
	 private int pecaSelecionada,x,y;
	 private int [][] tabuleiro;
	 private BufferedImage[][] frames;
	 private JLabel[][] label;
	 private JButton[] button;
	 private JButton buttonAjuda;
	 private JFrame frame;
	 
	   
	    
	    public MatrizPath(BufferedImages[][] frames,) {
	    		
	    	}
	        
	   
	    
	    public BufferedImage getFrames(int i,int j) {	
	    	return frames[i][j];
	    		

		}  
	    
	    public void criarLabels() {
	    	m.criarTabuleiro();
	    	m.posicaoDe0();
	    	m.pecaMovimentaveis();
	    	for(int i=0;i<3;i++) {
    		for(int j=0;j<3;j++) {
    				try {
						frames [i] [j] = ImageIO.read(new File("C://Imagens//"+m.tabuleiro[i][j]+".jpg"));
						label[i][j] = new JLabel(new ImageIcon(frames[i][j]));
						label[i][j].setBounds((100*j), (120*i), 85, 100);
						frame.getContentPane().add(label[i][j]);
					} catch (IOException e) {
					}
    			
    		}
    	}
	    }	
	    
	    public void criarButton() {
	    	for(int k=0;k<4;k++) {
	    		if(m.pecasMovi[k]!=0) {
	    		imagensMovimentaveis[k] = m.pecasMovi[k];
	    		button[k]= new JButton (""+m.pecasMovi[k]);
	    		button[k].setBounds(300,125*k,200,100);
		    	button[k].setFocusable(false);
		        button[k].addActionListener(this);
		        frame.add(button[k]);
	    		}
	    	}
	    	buttonAjuda.setBounds(200, 450, 100, 100);
	    	buttonAjuda.setFocusable(false);
	    	buttonAjuda.addActionListener(this);
	    	frame.add(buttonAjuda);
	    }
	    
	    public void actionPerformed(ActionEvent e) {
	    	if(e.getSource()==button[0]) {
	    		
	    	}else if(e.getSource()==buttonAjuda) {
	    		
	    	}
	    }

	    
	    
	    public static void main(String[] args) {
	    	MatrizPath mP = new MatrizPath();
	    	mP.criarLabels();
	    	
	    	mP.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	    mP.frame.setSize(600,600);
    	    mP.frame.setLayout(null);
    	    mP.frame.setVisible(true);
	    	
	    }


		
	}
