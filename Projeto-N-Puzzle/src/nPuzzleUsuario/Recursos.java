package nPuzzleUsuario;

public class Recursos {
	
	public void textoAcao() {
		System.out.print("Digite sua ação: ");
	}
	
	public void ajuda() {
		int [] [] tabuleiroCorreto = new int [3] [3];
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++){
				tabuleiroCorreto[i][j] = (i*3+j+1);
				System.out.print(tabuleiroCorreto[i][j] + " ");
			}
			System.out.println();
		}
			
	}
	public void limparTela() {
		int i;
		for(i=0;i<300;i++) {
			System.out.print("\r\n");
		}
	}
	public void checkAjuda() {
		System.out.println("Caso precise de ajuda digite (?)");
	}
	
}
