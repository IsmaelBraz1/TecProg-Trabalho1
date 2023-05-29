package Jogo;

public class Rainha extends Bispo{

	public Rainha(String nome, String tipo, int id, int posicao, Plano plano) {
		super(nome, tipo, id, posicao, plano);
		Limite(4);
	}

}
