package gestion.empls;

import java.sql.Date;
import java.time.LocalDate;

public class Agent extends Employe{
	private double primeRespensabilite;
	public Agent(int mtle,String nomString,LocalDate dateDeNaissance,LocalDate DateEmbeauche,double SalaireBase,double primeResp ) {
		super(mtle,nomString,dateDeNaissance,DateEmbeauche,SalaireBase);
		this.primeRespensabilite=primeResp;	
	}
	public Agent() {
		this.primeRespensabilite=0;
	}
	public double getPrimeRespensabilite() {
		return primeRespensabilite;
	}

	public void setPrimeRespensabilite(double primeRespensabilite) {
		this.primeRespensabilite = primeRespensabilite;
	}
	@Override
	public double SalairePlayer() {
		double salaireNet=(getSalaireBase()+getPrimeRespensabilite())*(1-IR.getIR(getSalaireBase())*12);
		return salaireNet;
	}
}
