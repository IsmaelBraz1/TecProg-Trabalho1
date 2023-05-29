package Jogo;

import java.util.ArrayList;

public class Bispo extends Robo{

	public Bispo(String nome, String tipo, int id, int posicao, Plano plano) {
		super(nome, tipo, id, posicao, plano);
		Limite(2);
	}

	public void Limite(int num) {
		this.limite = num;
	}
	
	public boolean avancar(int nCelulas) {
		ArrayList<Robo> listaRobos = plano.getListaCelulas().get(getPosicaoAtual()).getListaRobos();
		Celula celula;
		for(int i = 0; i <  listaRobos.size(); i++) {
			celula = plano.getListaCelulas().get(getPosicaoAtual());
			if(listaRobos.get(i) == this && celula.getCoordX() < plano.getTamanhoX()-nCelulas && celula.getCoordY() < plano.getTamanhoY()-nCelulas) {
				listaRobos.remove(i);
				this.setPosicaoAtual(this.getPosicaoAtual()+(plano.getTamanhoY()+1)*nCelulas);
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
			if(listaRobos.get(i) == this && celula.getCoordX()-nCelulas >=0 && celula.getCoordY()-nCelulas >= 0) {
				listaRobos.remove(i);
				this.setPosicaoAtual(this.getPosicaoAtual()-(plano.getTamanhoY()+1)*nCelulas);
				pontuador(plano.getListaCelulas().get(getPosicaoAtual()));
				plano.getListaCelulas().get(getPosicaoAtual()).addRobo(this);
				return true;
			}
		}
		return false;
	}

	
	

}
