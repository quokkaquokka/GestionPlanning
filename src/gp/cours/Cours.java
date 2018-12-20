package gp.cours;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import gp.db.ICours;
import gp.utilisateur.Contact;

public class Cours {
	private Long id = 0L;
	private Date dateDebut = null;
	private Date dateFin = null;
	private Long idSalle = 0L;
	private Long matricule = 0L; // le matricule du professeur
	private Long idGroupe = 0L;
	private int nbPlaceSalle = 0;
	private int numSemaine = 0;

	public Cours(Date debut, Date fin, Long idsalle, Long matricule,
			Long idGroupe, int numSemaine) {
		this.dateDebut = debut;
		this.dateFin = fin;
		this.idSalle = idsalle;
		this.matricule = matricule;
		this.idGroupe = idGroupe;
		this.nbPlaceSalle = getNbPlacesSalle();
	}

	public Cours creerCours(Date debut, Date fin, Long idsalle, Long matricule,
			Long idGroupe, int numSemaine) {
		Cours cours = new Cours(debut, fin, idsalle, matricule, idGroupe,
				numSemaine);
		String value = "INSERT INTO RESPONSABLE VALUES( '"
				+ cours.getId().toString() + "','" + debut + "','" + fin
				+ "','" + idsalle + "','" + matricule + cours.getNumSemaine()
				+ "');";
		int status = 0;
		// status = statement.executeUpdate(value);
		if (status == 0) {
			// msg d'erreur l'element n'a pas pu etre inserer dans a base
			return null;
		} else {
			return cours;
		}
	}

	public int supprimerCours(Long id) {
		String value = "DELETE FROM COURS WHERE idCours = " + id.toString()
				+ ";";
		int status = 0;
		// status = statement.executeUpdate(value);
		return status;

	}

	public Date getDateDebut() {
		return this.dateDebut;
	}

	public Date getDateFin() {
		return this.dateFin;
	}

	// si le cours existe deja
	// selectionne le cours avec une date de d�but �gale
	public boolean getCoursbyDateDebut(Date date, Long idGroupe) {
		// selectionne le cours avec une date de d�but �gale
		String str = "SELECT * FROM SALLE WHERE dateDebut = " + date
				+ " AND idGroupe = " + idGroupe + ";";
		// ResultSet resultat = statement.executeQuery(str);
		Cours cours;
		Long idCours = -1L;
		// idCours = resultat.getLong();
		return !(idCours == -1);
	}

	public Long getIdSalle() {
		return idSalle;

	}

	public int getNbPlacesSalle() {
		String str = "SELECT nbPlaces FROM SALLE WHERE idSalle = "
				+ this.idSalle + ";";
		// ResultSet resultat = statement.executeQuery(str);
		int nbPlace = 0;
		// nbPlace = resultat.getInt();
		return nbPlace;
	}

	public Long getIdGroup() {
		return this.idGroupe;
	}

	public Long getId() {
		return this.id;
	}

	public int getNumSemaine() {
		return this.numSemaine;
	}

	public ArrayList<Cours> getCoursbyIdSemaine(int idSemaine, Long idGroupe) {
		String str = "SELECT * FROM COURS WHERE numSemaine = " + idSemaine
				+ " AND idGroupe = " + idGroupe + ";";
		// ResultSet resultat = statement.executeQuery(str);

		// traite la liste de r�sultat
		ArrayList<Cours> listCours = new ArrayList<Cours>();
		/*
		 * while(resultat.next()){ Long id = resultat.getLong(); Date debut =
		 * resultat.getDate(); Date fin = resultat.getDate(); Long idSalle =
		 * resultat.getLong(); Long matricule = resultat.getLong(); Long
		 * idGroupe = resultat.getLong(); int numSemaine = resultat.getString();
		 * Cours cours = new Cours(id, debut, fin, idSalle, matricule, idGroupe,
		 * numSemaine); listContact.add(contact); }
		 */
		return listCours;
	}

	public ArrayList<Cours> getCoursbyIdDate(Date date, Long idGroupe) {
		String str = "SELECT * FROM COURS WHERE dateDebut = " + date
				+ " AND idGroupe = " + idGroupe + ";";
		// ResultSet resultat = statement.executeQuery(str);

		// traiter la liste de r�sultat
		ArrayList<Cours> listCours = new ArrayList<Cours>();
		/*
		 * while(resultat.next()){ Long id = resultat.getLong(); Date debut =
		 * resultat.getDate(); Date fin = resultat.getDate(); Long idSalle =
		 * resultat.getLong(); Long matricule = resultat.getLong(); Long
		 * idGroupe = resultat.getLong(); int numSemaine = resultat.getString();
		 * Cours cours = new Cours(id, debut, fin, idSalle, matricule, idGroupe,
		 * numSemaine); listContact.add(contact); }
		 */
		return listCours;
	}

}
