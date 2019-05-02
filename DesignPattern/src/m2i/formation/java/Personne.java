package m2i.formation.java;

public class Personne {
	private int _idPersonne;
	private String _nom;
	private String _prenom;
	private float _poids;
	private float _taille;
	private Genre _sexe;
	
	private int _idSociete;
	
	public Personne(int _idPersonne, String _nom, String _prenom, float _poids, float _taille, Genre _sexe) {
		super();
		this._idPersonne = _idPersonne;
		this._nom = _nom;
		this._prenom = _prenom;
		this._poids = _poids;
		this._taille = _taille;
		this._sexe = _sexe;
	}
	
	public Personne(int idPersonne, String nom, String prenom, float poids, float taille, Genre sexe, int idSociete) {
		this._idPersonne = idPersonne;
		this._nom = nom;
		this._prenom = prenom;
		this._poids = poids;
		this._taille = taille;
		this._sexe = sexe;
		
		this._idSociete = idSociete;
	}


	// GETTERS & SETTERS
	public int get_idPersonne() {
		return _idPersonne;
	}
	
	public String get_nom() {
		return _nom;
	}
	
	public void set_idPersonne(int _idPersonne) {
		this._idPersonne = _idPersonne;
	}


	public void set_nom(String _nom) {
		this._nom = _nom;
	}

	public String get_prenom() {
		return _prenom;
	}

	public void set_prenom(String _prenom) {
		this._prenom = _prenom;
	}

	public float get_poids() {
		return _poids;
	}

	public void set_poids(float _poids) {
		this._poids = _poids;
	}

	public float get_taille() {
		return _taille;
	}

	public void set_taille(float _taille) {
		this._taille = _taille;
	}

	public Genre get_sexe() {
		return _sexe;
	}

	public void set_sexe(Genre _sexe) {
		this._sexe = _sexe;
	}
		
	public int get_idSociete() {
		return _idSociete;
	}
	public void set_idSociete(int _idSociete) {
		this._idSociete = _idSociete;
	}
	/**
	 * IMC
	 * @return float IMC
	 */
	public float IMC() {
		return this._poids/this._taille * this._taille;	
	}
	
	/**
	 * Poids mini
	 * @return float  Poids mini
	 */
	public float poidsMin() {
		return 19 * this._taille * this._taille;	
	}
	
	/**
	 * Poids maxi
	 * @return float Poids maxi
	 */
	public float poidsMax() {
		return 25 * this._taille * this._taille;	
	}
	
	/**
	 * Poids ideal
	 * @return float Taille ideal
	 */
	public float poidsIdeal() {
		if(this._sexe == Genre.MASCULIN)
			return 22 * this._taille * this._taille;
		else
			return 21 * this._taille * this._taille;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Personne [_nom=");
		builder.append(_nom);
		builder.append(", _prenom=");
		builder.append(_prenom);
		builder.append(", _poids=");
		builder.append(_poids);
		builder.append(", _taille=");
		builder.append(_taille);
		builder.append(", _sexe=");
		builder.append(_sexe);
		builder.append(", IMC()=");
		builder.append(IMC());
		builder.append(", poidsMin()=");
		builder.append(poidsMin());
		builder.append(", poidsMax()=");
		builder.append(poidsMax());
		builder.append(", poidsIdeal()=");
		builder.append(poidsIdeal());
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
	
	
}
