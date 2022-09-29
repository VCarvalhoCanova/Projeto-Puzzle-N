package nPuzzle;

public class ValorInvalido extends Exception {
		private String string;
	
		
		public ValorInvalido(String string) {
			super(string);
			this.string=string;
		}
}
