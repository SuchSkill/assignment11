package entities.address;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import entities.EntityBase;
import entities.employees.Employee ;

@Entity
@Table(name = "ADDRESS")
public class Address extends EntityBase {

	@Id
	@GeneratedValue(//
			strategy = GenerationType.SEQUENCE, //
			generator = "ADDRESS_SEQ")
	@SequenceGenerator(name = "ADDRESS_SEQ", sequenceName = "ADDRESS_SEQ", allocationSize = 1)
	@Column(name = "ADDRESS_ID", unique = true, nullable = false)
	private int id;

	@ManyToOne(targetEntity = City.class)
	@JoinColumn( //
			name = "CITY_ID", //
			nullable = false, //
			foreignKey = @ForeignKey(name = "ADDRESS_CITY_FK"))
	private City city;

	@ManyToOne(targetEntity = PostalCode.class)
	@JoinColumn( //
			name = "POSTAL_CODE_ID", //
			nullable = false, //
			foreignKey = @ForeignKey(name = "ADDRESS_POSTAL_CODE_FK"))
	private PostalCode postalCode;

	@OneToMany(targetEntity = Employee.class)
	@JoinColumn(name = "ADDRESS_ID")
	private List<Employee> employees;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public PostalCode getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(PostalCode postalCode) {
		this.postalCode = postalCode;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setPersons(List<Employee> employees) {
		this.employees = employees;
	}
}