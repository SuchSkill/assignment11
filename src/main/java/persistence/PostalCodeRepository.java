package persistence;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;

import entities.address.*;
import domain.queries.*;
import domain.repositories.*;

public final class PostalCodeRepository extends RepositoryBase<PostalCode>
		implements IPostalCodeRepository {

	PostalCodeRepository(Context context) {
		super(context, PostalCode.class);
	}

	public List<PostalCode> getByQuery(PostalCodeQuery query) {
		CriteriaBuilder builder = this.criteriaBuilder();
		CriteriaQuery<PostalCode> criteria = this.criteria(builder);
		Root<PostalCode> postalCode = this.getRoot(criteria);
		if (query.hasId()) {
			criteria.where(builder.equal(postalCode.get("id"), query._id));
		}
		if (query.hasPostalCode()) {
			criteria.where(builder.equal(postalCode.get("code"),
					query._postalCode));
		}
		if (query.hasCityName()) {
			EntityType<PostalCode> postalCodeType = this
					.entityType(PostalCode.class);
			Join<PostalCode, City> city = postalCode //
					.join(postalCodeType.getDeclaredSingularAttribute("city",
							City.class));
			criteria.where(builder.like(city.get("name"), query._cityName));
		}
		Query criteriaQuery = this.entityManager() //
				.createQuery(criteria);
		return (List<PostalCode>) criteriaQuery.getResultList();
	}

	public List<PostalCode> getByQueryNative(PostalCodeQuery query) {
		StoredProcedureQuery namedQuery = this.entityManager()
				.createNamedStoredProcedureQuery("PostalCodeGet");
		namedQuery.setParameter("POSTAL_CODE_ID", query._id);
		namedQuery.setParameter("POSTAL_CODE", query._postalCode);
		namedQuery.setParameter("CITY_NAME", query._cityName);
		namedQuery.execute();
		List<PostalCode> postalCodes = (List<PostalCode>) namedQuery.getOutputParameterValue("POSTAL_CODE_CURSOR");
		return postalCodes;
	}
}