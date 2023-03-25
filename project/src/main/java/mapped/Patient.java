package mapped;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Patient")
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPatient", unique = true, nullable = false)
	private int idPatient;
	
	@Column(name = "Firstname", nullable = false)
	private String firstname;
	
	@Column(name = "Lastname", nullable = false)
	private String lastname;
	
	@Column(name = "phoneNumber", nullable = false)
	private int phoneNumber;
	
	@Column(name = "email", nullable = true)
	private String email;

    public Patient() {
    	
    }
    
	public Patient(String firstname, String lastname, 
			int phoneNumber, String email) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	
	public Patient(String firstname, String lastname, 
			int phoneNumber) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.phoneNumber = phoneNumber;
	}
	
	public int getIdPatient() {
		return idPatient;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Override
	public String toString() {
		return firstname + " " + lastname;
	}
	
}
