package Jogo;

public class Cavalo extends Bispo{

	public Cavalo(String nome, String tipo, int id, int posicao, Plano plano) {
		super(nome, tipo, id, posicao, plano);
		Limite(2);
	}
	public void Limite(int num) {
		this.limite = num;
	}
}
