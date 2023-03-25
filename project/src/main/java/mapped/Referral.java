package mapped;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Referral")
public class Referral {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idReferral", unique = true, nullable = false)
	private int idReferral;
	
	@Column(name = "term", unique = false, nullable = true)
	private Date term;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Research_idResearch")
	private Research research;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Patient_idPatient")
	private Patient patient;
	
    @OneToOne
    @JoinColumn(name = "Result_idResult", referencedColumnName = "idResult", nullable = true)
    private Result result;
    
    @OneToOne
    @JoinColumn(name = "Test_idTest", referencedColumnName = "idTest", nullable = false)
    private Test test;

    public Referral() {
    	
    }
    
	public Referral(Date term, Research research, Patient patient, Result result, Test test) {
		this.term = term;
		this.research = research;
		this.patient = patient;
		this.result = result;
		this.test = test;
	}

	public int getIdReferral() {
		return idReferral;
	}

	public void setIdReferral(int idReferral) {
		this.idReferral = idReferral;
	}

	public Date getTerm() {
		return term;
	}

	public void setTerm(Date term) {
		this.term = term;
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

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}
    
    
}
