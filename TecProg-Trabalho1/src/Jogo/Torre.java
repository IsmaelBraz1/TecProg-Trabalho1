package Jogo;

public class Torre extends Andador{

	public Torre(String nome, String tipo, int id, int posicao, Plano plano) {
		super(nome, tipo, id, posicao, plano);
		Limite(2);
	}

}
