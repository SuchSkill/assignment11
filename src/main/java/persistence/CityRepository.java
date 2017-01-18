package persistence;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import entities.address.City ;
import domain.queries.CityQuery ;
import domain.repositories.ICityRepository ;

public final class CityRepository extends RepositoryBase<City> implements
		ICityRepository {

	CityRepository(Context context) {
		super(context, City.class);
	}

	public List<City> getByQuery(CityQuery query) {
		CriteriaBuilder builder = this.criteriaBuilder();
		CriteriaQuery<City> criteria = this.criteria(builder);
		Root<City> city = this.getRoot(criteria);
		if (query.hasId()) {
			criteria.where(builder.equal(city.get("id"), query._id));
		}
		if (query.hasName()) {
			criteria.where(builder.like(city.get("name"), query._name));
		}
		Query criteriaQuery = this.entityManager().createQuery(criteria);
		return (List<City>) criteriaQuery.getResultList();
	}
}