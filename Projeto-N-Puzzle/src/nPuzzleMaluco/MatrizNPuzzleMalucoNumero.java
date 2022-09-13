package nPuzzleMaluco;

public class MatrizNPuzzleMalucoNumero extends MatrizNPuzzleMaluco {

	public MatrizNPuzzleMalucoNumero(int tamanhoTabuleiro, int nivelDeMaluquice) {
		super(tamanhoTabuleiro, nivelDeMaluquice);
		
	}
	
	
		public static void main(String[] args) {
			MatrizNPuzzleMalucoNumero mNPM = new MatrizNPuzzleMalucoNumero(3,11);
			mNPM.criaTabuleiro();
			mNPM.exibirTabuleiro();
			mNPM.posicaoDe0();
			mNPM.pecaMovimentaveis();
			mNPM.moverPeca();
			mNPM.chanceDeEmbaralhar();
			mNPM.exibirTabuleiro();
		}
}
