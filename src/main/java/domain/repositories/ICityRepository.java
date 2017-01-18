package domain.repositories;

import java.util.List;

import entities.address.City ;
import domain.queries.CityQuery ;

public interface ICityRepository extends IRepository<City> {

	/**
	 * Get City entities based on query --- dynamically criteria-base generated query
	 */
	List<City> getByQuery(CityQuery query);
}