package persistence;

import entities.employees.Employee ;
import domain.repositories.IEmployeeRepository ;

public final class EmployeeRepository extends RepositoryBase<Employee> implements IEmployeeRepository {

	protected EmployeeRepository(Context context) {
		super(context, Employee.class);
	}
}