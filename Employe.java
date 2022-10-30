package gestion.empls;  
import java.security.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.Year;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;    


public abstract class Employe implements IEmploye {

	private int mtle;
	private static int count;
	private String nomString;
	private LocalDate dateDeNaissance;
	private LocalDate dateEmbeaucheDate;
	private double salaireBase;
	public Employe(int mtle,String nomString,LocalDate dateDeNaissance,LocalDate dateEmbeauche,double salaireBase) {
		this.mtle=count++;
		this.nomString=nomString;
		this.dateDeNaissance=dateDeNaissance;
		this.dateEmbeaucheDate=dateEmbeauche;
		this.salaireBase=salaireBase;
	}
	public Employe() {
		this.mtle=count++;
		this.nomString="";
		this.salaireBase=0;
		this.dateDeNaissance=dateDeNaissance.of(0,0,0);
		
		
	}
 
	public void setSalaireBase(double salaireBase) {
		this.salaireBase=salaireBase;
	}
	public double getSalaireBase() {
		return salaireBase;
	}
	public LocalDate getDateDeNaissance() {
		return dateDeNaissance;
	}
	public void setDateDeNaissance(LocalDate dateDeNaissance) {
		this.dateDeNaissance =dateDeNaissance;
	}
	public LocalDate getDateEmbeaucheDate() {
		return dateEmbeaucheDate;
	}
	public void setDateEmbeaucheDate(LocalDate dateEmbeaucheDate) throws Exception {
		LocalDate datenow=LocalDate.now();
		LocalDate birthday=LocalDate.of(0,0,0);
		int period=Period.between(birthday,datenow).getYears();
		if(period<16) 
			throw new Exception("l'age d'employée doit etre supérieur de 16");
				this.dateEmbeaucheDate = dateEmbeaucheDate;
	}

	@Override
	public int age() {
		LocalDate datenow=LocalDate.now();
		LocalDate birthday=LocalDate.of(0,0,0);
		int period=Period.between(birthday,datenow).getYears();
		return period;
	}

	@Override
	public int Anciennete() {	
		LocalDate datenow=LocalDate.now();
		LocalDate dateEmbeDate=LocalDate.of(0,0,0);
		int anciennete=Period.between(dateEmbeDate,datenow).getYears();
		return anciennete;
	}

	@Override
	public LocalDate dateRetraite(int ageRetraite) {	
		LocalDate ageRetraitDate=LocalDate.of(0,0,0);
		LocalDate birthday=LocalDate.of(dateDeNaissance.getYear(),dateDeNaissance.getMonth(),dateDeNaissance.getDayOfYear());
		int dateRetrait=Period.between(birthday,ageRetraitDate).getYears();
		return ageRetraitDate;	
	}
	public abstract double SalairePlayer();
	@Override
	public String tostring() {
		return "Matricule: "+this.mtle+"-"+"Nom: "+this.nomString+"-"+
	            "Date de naissance :"+this.dateDeNaissance+"-"
				+"Date d'embeauche: "+this.dateEmbeaucheDate+"-"
				+"Salaire de base: "+this.salaireBase;
	}
	@Override
	public boolean equals(Employe e) {
		Employe em1=(Employe) e;
		if(this.mtle==em1.mtle) {
			return true;
		}else {
			return false;
		}	
	}	
}
