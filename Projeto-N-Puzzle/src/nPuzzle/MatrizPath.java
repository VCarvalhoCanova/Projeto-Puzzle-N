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


public class MatrizPath extends Component implements ActionListener{
	
	 private int []imagensMovimentaveis = new int [4];
	 private int pecaSelecionada,x,y;
	 private int [][] tabuleiro = new int [3][3];
	 private BufferedImage[][] frames = new BufferedImage [3][3];
	 private JLabel[][] label = new JLabel[3][3];
	 private JButton[] button = new JButton [4];
	 JButton buttonAjuda = new JButton ("Ajuda");
	 BufferedImage img0,img1,img2,img3,img4,img5,img6,img7,img8;
	 JFrame frame = new JFrame ();
	 Matriz m = new Matriz();
	   
	    
	    public MatrizPath() {
	    	System.out.println(pecaSelecionada);
	    	
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
    	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	    frame.setSize(600,600);
    	    frame.setLayout(null);
    	    frame.setVisible(true);
	    	
	    		
	    	}
	        
	   
	    
	    public BufferedImage getFrames(int i,int j) {		
	    	return frames[i][j];

		}    
	    	
	    	
	    
	    public void actionPerformed(ActionEvent e) {
	    	if(e.getSource()==button[0]) {
	    		MatrizPath0 m0 = new MatrizPath0();
	    	}else if(e.getSource()==button[1]) {
	    		MatrizPath1 m1 = new MatrizPath1();
	    	}else if (e.getSource()==button[2]) {
	    		MatrizPath2 m2 = new MatrizPath2();
	    	}else if (e.getSource()==button[3]) {	    		
	    		MatrizPath3 m3 = new MatrizPath3();
	    	}else if (e.getSource()==buttonAjuda) {
	    		MatrizAjuda mA = new MatrizAjuda();
	    	}
	    }

	    public void criarArray() {
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
	    
	    public static void main(String[] args) {
	    	MatrizPath mP = new MatrizPath();
	    	Matriz m = new Matriz();
	    	m.criarTabuleiro();
	        JFrame f = new JFrame("Load Image Sample");
	        
	        for(int i=0;i<3;i++) {
	        	for(int j=0;j<3;j++) {
	        		mP.tabuleiro[i][j]=m.tabuleiro[i][j];
	        	}
	        }
	        
	        	mP.criarArray();
	        	f.add(new MatrizPath());
	    }







		







		

		
	}
