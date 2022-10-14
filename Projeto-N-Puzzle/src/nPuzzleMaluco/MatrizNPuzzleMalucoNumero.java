package nPuzzleMaluco;

import java.util.Random;
import java.util.Scanner;

import nPuzzle.MatrizNumero;
import nPuzzle.ValorInvalido;

public class MatrizNPuzzleMalucoNumero{
	
	private int nivelDeMaluquice,xRand,yRand,temp;
	private int [] numerosMalucos= new int [2];
	private MatrizNumero mN;
	
	private Random rand= new Random();
	private int[][] tabuleiro;
	
	public MatrizNPuzzleMalucoNumero(int nivelDeMaluquice) {
		this.nivelDeMaluquice=nivelDeMaluquice;
	}
	
		public void chanceDeEmbaralhar(){
		int temp= rand.nextInt(0,10);
		if(getNivelDeMaluquice()>temp) {
		}
		embaralharPecas();
	}
	
	public void pecasEmbaralhaveis() {
		int cont=0;
		while(true) {
		xRand = rand.nextInt(0, mN.getTamanhoTabuleiro());
		yRand= rand.nextInt(0, mN.getTamanhoTabuleiro());
		if(mN.getTabuleiro()[yRand][xRand]!=mN.getTabuleiro()[mN.getY()][mN.getX()] && mN.getTabuleiro()[yRand][xRand]!=0 && mN.getTabuleiro()[yRand][xRand]!= numerosMalucos[0]) {
			numerosMalucos[cont]=mN.getTabuleiro()[yRand][xRand];
			cont=cont+1;	
		}
		if(cont==2) {
		break;	
		}
		
	 }
	}
	
	public void embaralharPecas() {
		pecasEmbaralhaveis();
		for(int i=0;i<mN.getTamanhoTabuleiro();i++) {
			for(int j=0;j<mN.getTamanhoTabuleiro();j++) {
				if(mN.getTabuleiro()[i][j]== numerosMalucos [0]) {
					mN.setTabuleiro(numerosMalucos[1],i,j);
				}else if(mN.getTabuleiro()[i][j]==numerosMalucos[1]) {
					mN.setTabuleiro(numerosMalucos[0],i,j);
				}
			}
		}
	}

	public int getNivelDeMaluquice() {
		return nivelDeMaluquice;
	}

	public void setNivelDeMaluquice(int nivelDeMaluquice) {
		this.nivelDeMaluquice = nivelDeMaluquice;
	}
	public void setMN(MatrizNumero mN) {
		this.mN=mN;
	}
	
	
	
	
	
	
	
}
