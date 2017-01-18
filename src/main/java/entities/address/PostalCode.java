package entities.address;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.SequenceGenerator;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import entities.EntityBase;

@NamedStoredProcedureQueries({ //
		@NamedStoredProcedureQuery(//
				name = "PostalCodeGet", // query name to further refer to in the
										// application
				// code
				resultClasses = { PostalCode.class }, //
				procedureName = "POSTAL_CODE_GET", //
				parameters = { //
						@StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "POSTAL_CODE_CURSOR", type = Void.class), //
						@StoredProcedureParameter(mode = ParameterMode.IN, name = "POSTAL_CODE_ID", type = Integer.class), //
						@StoredProcedureParameter(mode = ParameterMode.IN, name = "POSTAL_CODE", type = String.class), //
						@StoredProcedureParameter(mode = ParameterMode.IN, name = "CITY_NAME", type = String.class), //
				}) //
})
@Entity
@Table(name = "POSTAL_CODE")
public class PostalCode extends EntityBase {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "POSTAL_CODE_SEQ")
	@SequenceGenerator(name = "POSTAL_CODE_SEQ", sequenceName = "POSTAL_CODE_SEQ", allocationSize = 1)
	@Column(name = "POSTAL_CODE_ID", unique = true, nullable = false)
	private int id;

	@ManyToOne(targetEntity = City.class)
	@JoinColumn(//
			name = "CITY_ID", //
			nullable = false, //
			foreignKey = @ForeignKey(name = "POSTAL_CODE_CITY_FK"))
	private City city;

	@Column(name = "POSTAL_CODE_CODE", nullable = false)
	private String code;

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

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}