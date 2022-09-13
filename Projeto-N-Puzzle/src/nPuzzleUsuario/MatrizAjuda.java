package nPuzzleUsuario;
import nPuzzle.Matriz;
import nPuzzle.MatrizNumero;
import nPuzzle.MatrizPath;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MatrizAjuda extends MatrizNumero {
	JFrame frame = new JFrame ();
	MatrizPath mP = new MatrizPath();
	private JLabel[][] labelResposta = new JLabel[3][3];
	private BufferedImage [][] framesResposta = new BufferedImage [3][3];
	private MatrizNumero mN= new MatrizNumero(3);
	
	public MatrizAjuda() {
		mN.criarTabuleiro();
		int cont=0;
		for(int i=0;i<3;i++) {
    		for(int j=0;j<3;j++) {
    				try {
    					if(i==2 && j==2) {
    						framesResposta [i] [j] = ImageIO.read(new File("C://Imagens//"+0+".jpg"));
    						labelResposta[i][j] = new JLabel(new ImageIcon(framesResposta[i][j]));
    						labelResposta[i][j].setBounds((100*i), (120*j), 85, 100);
    						frame.getContentPane().add(labelResposta[i][j]);
    					}
						framesResposta [i] [j] = ImageIO.read(new File("C://Imagens//"+(cont+1)+".jpg"));
						labelResposta[i][j] = new JLabel(new ImageIcon(framesResposta[i][j]));
						labelResposta[i][j].setBounds((100*j), (120*i), 85, 100);
						frame.getContentPane().add(labelResposta[i][j]);
						cont++;
					} catch (IOException e) {
					}
    			
    		}
    	}
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setSize(600,600);
		    frame.setLayout(null);
		    frame.setVisible(true);
	}
	
}
