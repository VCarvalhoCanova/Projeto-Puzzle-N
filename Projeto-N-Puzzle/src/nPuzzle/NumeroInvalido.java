package nPuzzle;

public class NumeroInvalido extends Exception {
		private String string;
	
		
		public NumeroInvalido(String string) {
			super(string);
			this.string=string;
		}
}
