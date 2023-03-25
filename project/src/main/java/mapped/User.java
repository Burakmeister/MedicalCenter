package mapped;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="User")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idUser", unique = true, nullable = false)
	private int idUser;
	
	@Column(name = "login", unique = true, nullable = false)
	private String login;
	
	@Column(name = "password", unique = true, nullable = false)
	private String password;
	
	@Column(name = "Access_level", unique = false, nullable = false)
	private byte accessLevel;

    @OneToOne
    @JoinColumn(name = "Patient_idPatient", referencedColumnName = "idPatient", nullable = true)
    private Patient patient;
    
	public User() {
	}
	
	public User(String login, String password, byte accessLevel) {
		this.login = login;
		this.password = password;
		this.accessLevel = accessLevel;
	}
	
	public User(String login, String password, byte accessLevel, Patient patient) {
		this.login = login;
		this.password = password;
		this.accessLevel = accessLevel;
		this.patient = patient;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public byte getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(byte accessLevel) {
		this.accessLevel = accessLevel;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Override
	public int hashCode() {
		return Objects.hash(login);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(login, other.login);
	}
	
	
}
