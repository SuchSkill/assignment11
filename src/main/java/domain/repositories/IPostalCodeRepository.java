package domain.repositories;

import java.util.List;

import entities.address.PostalCode ;
import domain.queries.PostalCodeQuery ;

public interface IPostalCodeRepository extends IRepository<PostalCode> {

	/**
	 * Get PostalCode entities based on query --- dynamically criteria-base generated
	 * query
	 */
	List<PostalCode> getByQuery(PostalCodeQuery query);

	/**
	 * Get PostalCode entities based on query --- named stored procedure invocation
	 */
	List<PostalCode> getByQueryNative(PostalCodeQuery query);
}