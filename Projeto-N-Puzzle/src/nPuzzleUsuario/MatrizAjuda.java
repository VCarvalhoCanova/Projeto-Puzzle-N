package nPuzzleUsuario;
import nPuzzle.Matriz;
import nPuzzle.MatrizNumero;
import nPuzzleUi.MatrizPath;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MatrizAjuda{
	JFrame frame = new JFrame ();
	private MatrizPath mP;
	private MatrizNumero mN;
	private JLabel[][] labelResposta = new JLabel[3][3];
	private BufferedImage [][] framesResposta = new BufferedImage [3][3];
	
	public MatrizAjuda(int tamanhoTabuleiro) {
		int cont=0;
		mN = new MatrizNumero (tamanhoTabuleiro);
		mN.criarTabuleiro();
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
	
	
	
	
	
	
}
