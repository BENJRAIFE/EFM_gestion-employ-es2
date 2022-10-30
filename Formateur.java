package gestion.empls;
import java.sql.Date;
import java.time.LocalDate;
public class Formateur extends Employe {
	private double heureSup;
	private double remunerationHSup;
	public Formateur(int mtle,String nomString,LocalDate dateDeNaissance,LocalDate DateEmbeauche,double SalaireBase,double heureSup,double remunerationHSup ) {
		super(mtle,nomString,dateDeNaissance,DateEmbeauche,SalaireBase);
		this.heureSup=heureSup;
		this.remunerationHSup=remunerationHSup;
	}
	public Formateur() {
		this.heureSup=0;
		this.remunerationHSup=70.00;
	}
	public double getRemunerationHSup() {
		return remunerationHSup;
	}

	public void setRemunerationHSup(double remunerationHSup) {
		this.remunerationHSup = remunerationHSup;
	}

	public double getHeureSup() {
		return heureSup;
	}

	public void setHeureSup(double heureSup) {
		this.heureSup = heureSup;
	}

	@Override
	public double SalairePlayer() {
		double salaireNet=(getSalaireBase()+getHeureSup()*getRemunerationHSup())*(1-IR.getIR(getSalaireBase()*12));
		return salaireNet;
	}
	public String tostrString() {
		return super.tostring()+"-"+"les heures suplementaires: "+getHeureSup()+"-"+
	"remuneration par heure suplementaire: "+getRemunerationHSup();
	}
}
