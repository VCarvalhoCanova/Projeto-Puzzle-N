package nPuzzleUsuario;
import nPuzzle.MatrizNumero;
import nPuzzleUi.MatrizPath;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MatrizAjuda{
	JFrame frame = new JFrame ();
	private MatrizPath mP;
	private MatrizNumero mN;
	private JLabel[][] labelResposta = new JLabel[3][3];
	private JButton [] [] button;
	private BufferedImage [][] framesResposta = new BufferedImage [3][3];
	
	public MatrizAjuda(int tamanhoTabuleiro, String modoAjuda) {
		mN = new MatrizNumero (tamanhoTabuleiro);
		mN.criarTabuleiro();
		button = new JButton [tamanhoTabuleiro] [tamanhoTabuleiro];
		  if(modoAjuda.equals("A")) {
			  matrizAjudaPath(tamanhoTabuleiro);
		  }else if(modoAjuda.equals("C")) {
			  matrizAjudaChar(tamanhoTabuleiro);
		  }else if(modoAjuda.equals("N")) {
			  matrizAjudaNumero(tamanhoTabuleiro);
		  }
	}
	
	public void matrizAjudaPath(int tamanhoTabuleiro) {
		int cont=0;
		for(int i=0;i<tamanhoTabuleiro;i++) {
    		for(int j=0;j<tamanhoTabuleiro;j++) {
    				try {
    					if(i==tamanhoTabuleiro-1 && j==tamanhoTabuleiro-1	) {
    						framesResposta [i] [j] = ImageIO.read(new File("resource//Imagens//"+0+".jpg"));
    						labelResposta[i][j] = new JLabel(new ImageIcon(framesResposta[i][j]));
    						labelResposta[i][j].setBounds((100*i), (120*j), 85, 100);
    						frame.getContentPane().add(labelResposta[i][j]);
    					}
						framesResposta [i] [j] = ImageIO.read(new File("resource//Imagens//"+mN.getMatrizResposta() [i][j]+".jpg"));
						labelResposta[i][j] = new JLabel(new ImageIcon(framesResposta[i][j]));
						labelResposta[i][j].setBounds((100*j), (120*i), 85, 100);
						frame.getContentPane().add(labelResposta[i][j]);
						cont++;
					} catch (IOException e) {
					}
    			
    		}
    	}
		frame.setSize(600,600);
	    frame.setLayout(null);
	    frame.setVisible(true);
	}
	
	public void matrizAjudaChar(int tamanhoTabuleiro) {
		for(int i=0;i<mN.getTamanhoTabuleiro();i++) {
    		for(int j=0;j<mN.getTamanhoTabuleiro();j++) {
    			if(mN.getMatrizResposta()[i][j]==0) {
    				button[i][j]= new JButton(" ");
    			}else {
    				button[i][j]= new JButton(" "+((char) (mN.getMatrizResposta()[i][j]+64)));
    			}
    					button[i][j].setBounds(100*j,125*i,80,80);
    			    	button[i][j].setFocusable(false);	
    			    	frame.getContentPane().add(button[i][j]);
    			    		}

    			
    		}
		frame.setSize(600,600);
	    frame.setLayout(null);
	    frame.setVisible(true);

	}
	public void matrizAjudaNumero(int tamanhoTabuleiro ) {
		for(int i=0;i<mN.getTamanhoTabuleiro();i++) {
    		for(int j=0;j<mN.getTamanhoTabuleiro();j++) {
    			if(mN.getMatrizResposta()[i][j]==0) {
    				button[i][j]= new JButton(" ");
    			}else {
    				button[i][j]= new JButton(" "+ (mN.getMatrizResposta()[i][j]));
    			}
    					button[i][j].setBounds(100*j,125*i,80,80);
    			    	button[i][j].setFocusable(false);	
    			    	frame.getContentPane().add(button[i][j]);
    			    		}

    			
    		}
		frame.setSize(600,600);
	    frame.setLayout(null);
	    frame.setVisible(true);
		
	}
	
	
	
	
}
