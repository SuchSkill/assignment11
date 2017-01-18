package domain.repositories;

import entities.EntityBase;

public interface IRepository<TEntity extends EntityBase>  {

	TEntity getById(int id);
	void persist(TEntity entity);
	void delete(TEntity entity);
	long count();
}