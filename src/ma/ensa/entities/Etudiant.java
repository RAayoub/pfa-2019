package ma.ensa.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Etudiant implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEtudiant;
	private String cin;
	private long cne;
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private String lienNaissance;
	private String sexe;
	private String nationalite;
	private String telephone;
	

	
}
