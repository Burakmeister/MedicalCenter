package mapped;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Agreement")
public class Agreement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idAgreement", unique = true, nullable = false)
	private int idAgreement;
	
	@Column(name = "Agreement", nullable = true)
	private String agreementSource;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Research_idResearch", nullable = true)
	private Research research;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Patient_idPatient", nullable = false)
	private Patient patient;

	public Agreement() {
	}
	
	public Agreement(Patient patient) {
		this.patient = patient;
	}

	public int getIdAgreement() {
		return idAgreement;
	}

	public void setIdAgreement(int idAgreement) {
		this.idAgreement = idAgreement;
	}

	public String getAgreementSource() {
		return agreementSource;
	}

	public void setAgreementSource(String agreementSource) {
		this.agreementSource = agreementSource;
	}

	public Research getResearch() {
		return research;
	}

	public void setResearch(Research research) {
		this.research = research;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
}
