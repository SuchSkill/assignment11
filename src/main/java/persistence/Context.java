package persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;

import domain.repositories.*;
//import eu.glowacki.jpa.repositories.IContext;
//import eu.glowacki.jpa.repositories.IEmployeeRepository;
//import eu.glowacki.jpa.repositories.IPostalCodeRepository;
//import eu.glowacki.jpa.repositories.ITeamRepository;

public final class Context implements IContext {

	private static final String PERSISTENCE_UNIT_NAME = "jpa"; // see
																// persistence.xml
	private static final EntityManagerFactory _entityManagerFactory;

	static {
		_entityManagerFactory = Persistence
				.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	}

	private final EntityManager _entityManager; // created for session
	
	private final ICityRepository _city;
	private final IPostalCodeRepository _postalCode;
	private final IEmployeeRepository _employee;
	private final ITeamRepository _team;

	public Context() {
		_entityManager = _entityManagerFactory.createEntityManager();
		_city = new CityRepository(this);
		_postalCode = new PostalCodeRepository(this);
		_employee = new EmployeeRepository(this);
		_team = new TeamRepository(this);
	}

	public ICityRepository city() {
		return _city;
	}
	
	public IPostalCodeRepository postalCode() {
		return _postalCode;
	}

	public IEmployeeRepository employee() {
		return _employee;
	}

	public ITeamRepository team() {
		return _team;
	}

	public EntityManager entityManager() {
		return _entityManager;
	}

	public CriteriaBuilder criteriaBuilder() {
		return this.entityManager() //
				.getCriteriaBuilder(); //
	}

	public EntityTransaction transaction() {
		return this.entityManager() //
				.getTransaction();
	}

	public void flush() {
		this.entityManager() //
				.flush();
	}
}