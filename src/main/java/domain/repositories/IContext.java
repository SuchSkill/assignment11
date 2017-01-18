package domain.repositories;

public interface IContext {

	ICityRepository city();
	IPostalCodeRepository postalCode();
	IEmployeeRepository employee();
	ITeamRepository team();
}