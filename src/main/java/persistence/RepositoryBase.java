package persistence;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

import entities.EntityBase ;
import domain.repositories.IRepository;
public abstract class RepositoryBase<TEntity extends EntityBase> implements
		IRepository<TEntity> {

	private final Context _context;
	private final Class<TEntity> _entityClass;

	protected RepositoryBase(Context context, Class<TEntity> entityClass) {
		_context = context;
		_entityClass = entityClass;
	}

	public final void persist(TEntity entity) {
		this.entityManager().persist(entity);
	}

	public final void delete(TEntity entity) {
		this.entityManager().remove(entity);
	}

	public final TEntity getById(int id) {
		CriteriaBuilder builder = this.criteriaBuilder();
		CriteriaQuery<TEntity> criteria = this.criteria(builder);
		Root<TEntity> root = getRoot(criteria);
		criteria.where(builder.equal(root.get("id"), id));
		Query query = this.entityManager().createQuery(criteria);
		TEntity result = (TEntity) query.getSingleResult();
		return result;
	}

	public final long count() {
		CriteriaBuilder builder = this.criteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		criteria.select(builder.count(criteria.from(this.getEntityClass())));
		Query query = this.entityManager().createQuery(criteria);
		return (long) query.getSingleResult();
	}

	protected final Context context() {
		return _context;
	}

	protected final EntityManager entityManager() {
		return this.context().entityManager();
	}

	protected final CriteriaBuilder criteriaBuilder() {
		return this.context().criteriaBuilder();
	}

	protected final CriteriaQuery<TEntity> criteria(CriteriaBuilder builder) {
		return builder.createQuery(this.getEntityClass());
	}

	protected final Root<TEntity> getRoot(CriteriaQuery<TEntity> criteria) {
		return criteria.from(this.getEntityClass());
	}

	protected final Class<TEntity> getEntityClass() {
		return _entityClass;
	}

	protected final Metamodel metamodel() {
		return this.entityManager().getMetamodel();
	}

	protected final <TAnotherEntity> EntityType<TAnotherEntity> entityType(
			Class<TAnotherEntity> anotherEntityClass) {
		return this.metamodel().entity(anotherEntityClass);
	}
}