package Jogo;

public class Rei extends Bispo{

	public Rei(String nome, String tipo, int id, int posicao, Plano plano) {
		super(nome, tipo, id, posicao, plano);
		Limite(4);
	}

}
