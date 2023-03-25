package mapped;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Research")
public class Research {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idResearch", unique = true, nullable = false)
	private int idResearch;
	
	@Column(name = "Title", unique = false, nullable = false)
	private String title;
	
	@Column(name = "Description", unique = false, nullable = true)
	private String description;
	
	public Research() {
	}
	
	public Research(String title, String description) {
		this.title = title;
		this.description = description;
	}
	
	public Research(String title) {
		this.title = title;
	}

	public int getIdResearch() {
		return idResearch;
	}

	public void setIdResearch(int idResearch) {
		this.idResearch = idResearch;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return title;
	}

	@Override
	public int hashCode() {
		return Objects.hash(title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Research other = (Research) obj;
		return Objects.equals(title, other.title);
	}
	
}
