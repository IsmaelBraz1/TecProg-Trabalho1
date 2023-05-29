package Jogo;
public class Icone {
	private String iconAluno;
	private String iconBug;
	private String iconRobo;
	private Celula celula;
	
	public Icone(Celula celula) {
		this.celula = celula;
		this.iconRobo = null;
		this.iconAluno = null;
		this.iconBug = null;
	}

	
	public void setIconAluno(boolean temAluno) {
		if(temAluno)
			this.iconAluno = "@";
	}

	public void setIconBug(boolean temBug) {
		if(temBug)
			this.iconBug = "#";
	}


	public String retornarIcone() {
		if(celula.getListaRobos().size() == 1) {
			return this.iconRobo = celula.getListaRobos().get(0).getNome();
		}else if(celula.getListaRobos().size() > 1){
			return this.iconRobo = "+"+celula.getListaRobos().size();
		}else if(this.iconAluno!=null && celula.celulaVisitada()) {
			return this.iconAluno;
		}else if(this.iconBug!=null && celula.celulaVisitada()){
			return this.iconBug;
		}else if(celula.celulaVisitada()) {
			return "-";
		}
		return "*";
	}
}
