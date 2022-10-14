package nPuzzleUi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import nPuzzle.MatrizNumero;
import nPuzzleMaluco.MatrizNPuzzleMalucoNumero;
import nPuzzleUsuario.MatrizAjuda;

public class PuzzleUiNumero implements ActionListener {
	 private MatrizNumero mN;
	 private MatrizNPuzzleMalucoNumero mNM;
	 private MatrizPath mP;
	 private MatrizAjuda mA;
	 private JButton[] [] button;
	 private JButton buttonAjuda;
	 private JFrame frame= new JFrame();

	public PuzzleUiNumero(int tamanhoTabuleiro,int nivelDeMaluquice){
		mN= new MatrizNumero (tamanhoTabuleiro);
		mNM = new MatrizNPuzzleMalucoNumero(nivelDeMaluquice);
    	mN.criarTabuleiro();
    	frame.setSize(800, 800);
    	button = new JButton [tamanhoTabuleiro][tamanhoTabuleiro];
    	criarButton();
    	criarFrame();
    	
	}
	
	public void criarButton(){
	 mudarButton();	    	
	 
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
    				button[i][j]= new JButton(" "+mN.getTabuleiro()[i][j]);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<mN.getTamanhoTabuleiro();i++) {
		if(e.getSource()==buttonAjuda) {
    		mA= new MatrizAjuda(mN.getTamanhoTabuleiro(),"N");
    		break;
    	}for(int j=0;j<mN.getTamanhoTabuleiro();j++) {
			
    		if(e.getSource()==button[i][j]&& validarButton(i,j)) {
    			mN.moverPecaP(mN.getTabuleiro()[i][j]);
    			if(mNM.getNivelDeMaluquice()!=0) {
    				mNM.chanceDeEmbaralhar();
    			}
    			frame.getContentPane().removeAll();
				criarButton();
				frame.repaint();
				break;
    		}
		}
		
		}
		
	}
	
	
}
