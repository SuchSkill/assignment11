package entities.address;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import entities.EntityBase;

@Entity
@Table(name = "CITY", uniqueConstraints = { //
		@UniqueConstraint(name = "CITY_ID_UQ", columnNames = { "CITY_ID" }), //
		@UniqueConstraint(name = "CITY_NAME_UQ", columnNames = { "CITY_NAME" }), //
		@UniqueConstraint(name = "CITY_ID_NAME_UQ", columnNames = { "CITY_ID", "CITY_NAME" })

})
public class City extends EntityBase {

	@Id
	@GeneratedValue(//
			strategy = GenerationType.SEQUENCE, //
			generator = "CITY_SEQ")
	@SequenceGenerator( //
			name = "CITY_SEQ", //
			sequenceName = "CITY_SEQ", //
			allocationSize = 1)
	@Column(name = "CITY_ID", nullable = false)
	private int id;

	@Column(name = "CITY_NAME", nullable = false)
	private String name;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}