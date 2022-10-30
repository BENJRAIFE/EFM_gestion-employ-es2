package gestion.empls;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.print.attribute.standard.DateTimeAtCompleted;
public interface IEmploye {
	public abstract int age();
	public abstract int Anciennete();
	public abstract LocalDate dateRetraite(int ageRetraite);
	public abstract boolean equals(Employe e);
	public abstract String tostring();
}

