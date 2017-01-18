package entities.employees;

import java.math.BigDecimal;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import entities.EntityBase;
import entities.address.Address;
import entities.periods.Period;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "EMPLOYEE_TYPE")
@Table(name = "EMPLOYEE")
public abstract class Employee extends EntityBase {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPLOYEE_SEQ")
	@SequenceGenerator(name = "EMPLOYEE_SEQ", sequenceName = "EMPLOYEE_SEQ", allocationSize = 1)
	@Column(name = "EMPLOYEE_ID", unique = true, nullable = false)
	private int id;

	@Column(name = "EMPLOYEE_FIRST_NAME", nullable = false)
	private String firstName;

	@Column(name = "EMPLOYEE_LAST_NAME", nullable = false)
	private String lastName;

	@ManyToOne(targetEntity = Address.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "ADDRESS_ID", //
	foreignKey = @ForeignKey(name = "EMPLOYEE_ADDRESS_FK"))
	private Address address;

	@Column(name = "EMPLOYEE_SALARY")
	private BigDecimal salary;

	@Embedded
	@AttributeOverrides({ //
			@AttributeOverride(name = "startDate", column = @Column(name = "CONTRACT_START_DATE", nullable = false)), //
			@AttributeOverride(name = "endDate", column = @Column(name = "CONTRACT_CEASE_DATE", nullable = true)) //
	})
	private Period contractPeriod;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public BigDecimal getSalary() {
		return this.salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	
	public Period getContractPeriod() {
		return this.contractPeriod;
	}
	
	public void setContractPeriod(Period contractPeriod) {
		this.contractPeriod = contractPeriod;
	}

	public String getName() {
		return String.format("%1$s %2$s", getFirstName(), getLastName());
	}
}