package Jogo;

import java.util.ArrayList;

public class Peao extends Robo {

	public Peao(String nome,String tipo, int id, int posicao, Plano plano) {
		super(nome, tipo, id, posicao, plano);
		this.Limite(1);
	}
	public void Limite(int num) {
		this.limite = num;
	}
	public boolean avancar(int nCelulas) {
		ArrayList<Robo> listaRobos = plano.getListaCelulas().get(getPosicaoAtual()).getListaRobos();
		Celula celula;
		for(int i = 0; i <  listaRobos.size(); i++) {
			celula = plano.getListaCelulas().get(getPosicaoAtual());
			if(listaRobos.get(i) == this && celula.getCoordY() < plano.getTamanhoX()-1) {
				listaRobos.remove(i);
				this.setPosicaoAtual(this.getPosicaoAtual()+1);
				pontuador(plano.getListaCelulas().get(getPosicaoAtual()));
				plano.getListaCelulas().get(getPosicaoAtual()).addRobo(this);
				return true;
			}
		}
		return false;
	}
	
	public boolean retroceder(int nCelulas) {
		ArrayList<Robo> listaRobos = plano.getListaCelulas().get(getPosicaoAtual()).getListaRobos();
		Celula celula;
		for(int i = 0; i <  listaRobos.size(); i++) {
			celula = plano.getListaCelulas().get(getPosicaoAtual());
			if(listaRobos.get(i) == this && celula.getCoordY() > 0) {
				listaRobos.remove(i);
				this.setPosicaoAtual(this.getPosicaoAtual()-1);
				pontuador(plano.getListaCelulas().get(getPosicaoAtual()));
				plano.getListaCelulas().get(getPosicaoAtual()).addRobo(this);
				return true;
			}
		}
		return false;
	}

	
}
