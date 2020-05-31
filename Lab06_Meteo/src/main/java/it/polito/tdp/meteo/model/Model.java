package it.polito.tdp.meteo.model;

import java.util.List;
import java.util.Set;
import it.polito.tdp.meteo.DAO.MeteoDAO;

public class Model {
	
	private final static int COST = 100;
	private final static int NUMERO_GIORNI_CITTA_CONSECUTIVI_MIN = 3;
	private final static int NUMERO_GIORNI_CITTA_MAX = 6;
	private final static int NUMERO_GIORNI_TOTALI = 15;
	
	public MeteoDAO meteoDAO = new MeteoDAO();
	
	private double bestCosto = 0.0;
	private List<Citta> bestSoluzione = null;

	public Model() {

	}

	// of course you can change the String output with what you think works best
	public String getUmiditaMedia(int mese) {
		
		String risultato = "";
		Set<Citta> citta = meteoDAO.getAllCitta();
		for (Citta c : citta) {
			List<Rilevamento> lista = meteoDAO.getAllRilevamentiLocalitaMese(mese, c.getNome());
			double media = this.calcolaMedia(lista);
			risultato += c.getNome() + ": " + media + "\n";
		}
		
		return risultato;
	}
	
	// of course you can change the String output with what you think works best
	public String trovaSequenza(int mese) {
		return "TODO!";
	}
	
	public double calcolaMedia(List<Rilevamento> rilevamenti) {
		
		int somma = 0;
		for (Rilevamento r : rilevamenti)
			somma += r.getUmidita();
		return (double)somma/rilevamenti.size();
	}
	
	private void ricerca(List<Citta> parziale, int L) {
		
		// CASI TERMINALI
		if (L == NUMERO_GIORNI_TOTALI) {
			
			return ;
		}
		
		// GENERAZIONE SOTTOPROBLEMI
		
	}
}
