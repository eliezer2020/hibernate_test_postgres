package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="alumnos")
public class Alumno implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int matricula;
	
	@Column(nullable = false, length = 20)
	private String name;
	private int age;
	
	//foreing key
	//relacion un alumno muchas materias
	//lazy bring manerias
	//cascada persiste trnasactiones anidadas
	//@OneToMany(mappedBy = "alumno" , fetch=FetchType.LAZY, cascade = CascadeType.ALL )
	@ManyToMany
	@JoinTable(
			name="alumno_materia",
			joinColumns = @JoinColumn(name="alumno_id"),
			inverseJoinColumns = @JoinColumn(name="materia_id"))
	private List<Materia> materias ;

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}

	public Alumno( String name, int age) {
		super();
		
		this.name = name;
		this.age = age;
		
	} 
	
	public Alumno() {}
	
	

	
	
}
