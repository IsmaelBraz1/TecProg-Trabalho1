package Jogo;

import java.util.ArrayList;

public class Andador extends Robo{
	public Andador(String nome,String tipo, int id, int posicao, Plano plano) {
		super(nome, tipo, id, posicao, plano);
		this.Limite(999);
	}
	public void Limite(int num) {
		this.limite = num;
	}
	public boolean avancar(int nCelulas) {
		ArrayList<Robo> listaRobos = plano.getListaCelulas().get(getPosicaoAtual()).getListaRobos();
		Celula celula;
		for(int i = 0; i <  listaRobos.size(); i++) {
			celula = plano.getListaCelulas().get(getPosicaoAtual());
			if(listaRobos.get(i) == this && celula.getCoordX() < plano.getTamanhoX()-nCelulas) {
				listaRobos.remove(i);
				this.setPosicaoAtual(this.getPosicaoAtual()+(plano.getTamanhoY())*nCelulas);
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
			if(listaRobos.get(i) == this && celula.getCoordX() < plano.getTamanhoX()+nCelulas) {
				listaRobos.remove(i);
				this.setPosicaoAtual(this.getPosicaoAtual()-plano.getTamanhoY()*nCelulas);
				pontuador(plano.getListaCelulas().get(getPosicaoAtual()));
				plano.getListaCelulas().get(getPosicaoAtual()).addRobo(this);
				return true;
			}
		}
		return false;
	}

	


	

	
}
