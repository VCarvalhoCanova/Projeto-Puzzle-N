package nPuzzle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import nPuzzle.MatrizPath;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import nPuzzleUsuario.MatrizAjuda;

public class MatrizPath0 extends MatrizPath {
	 private int []imagensMovimentaveis = new int [4];
	 private int pecaSelecionada,x,y;
	 private int [][] tabuleiro = new int [3][3];
	 protected BufferedImage [][] frames0 = new BufferedImage [3][3];
	 private JLabel[][] label = new JLabel[3][3];
	 private JButton[] button = new JButton [4];
	 JButton buttonAjuda = new JButton ("Ajuda");
	 BufferedImage img0,img1,img2,img3,img4,img5,img6,img7,img8;
	 JFrame frame = new JFrame ();
	 Matriz m = new Matriz();
	 MatrizPath mP = new MatrizPath(); 
	 
		public MatrizPath0() {
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
	    	
	    	for(int i=0;i<3;i++) {
	    		for(int j=0;j<3;j++) {
	    				frames0 [i] [j] = getFrames(j, j);
						label[i][j] = new JLabel(new ImageIcon(frames0[i][j]));
						label[i][j].setBounds((100*j), (120*i), 85, 100);
						frame.getContentPane().add(label[i][j]);
	    			
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
		
		public void actionPerformed(ActionEvent e) {
	    	if(e.getSource()==button[0]) {
	    		MatrizPath0 m0 = new MatrizPath0();
	    	}else if(e.getSource()==button[1]) {
	    		this.pecaSelecionada=this.imagensMovimentaveis[1];
	    		MatrizPath1 m1 = new MatrizPath1();
	    	}else if (e.getSource()==button[2]) {
	    		this.pecaSelecionada=this.imagensMovimentaveis[2];
	    		MatrizPath2 m2 = new MatrizPath2();
	    	}else if (e.getSource()==button[3]) {
	    		this.pecaSelecionada=this.imagensMovimentaveis[3];
	    		MatrizPath3 m3 = new MatrizPath3();
	    	}else if (e.getSource()==buttonAjuda) {
	    		MatrizAjuda mA = new MatrizAjuda();
	    	}
	    }
		}

