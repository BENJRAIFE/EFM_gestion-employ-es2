package gestion.empls;

public abstract class IR {
	private static double [] Tranches=new double[6];
	private static double [] TauxIR=new double[6];
	public IR() {
		double [] Tranches = {0,30000,50000,60000,80000,180000};
		double [] TauxIR= {0,10,20,30,34,38};
	}
	public static double getIR(double salaireAnn) {
		for(int i=0;i<Tranches[i];i++) {
			for(int j=0;j<TauxIR[j];j++) {
				if(Tranches[i]>=salaireAnn) {
					return TauxIR[j-1];
				}
			}
			return TauxIR[5];
		}
		return salaireAnn;
	}
}
