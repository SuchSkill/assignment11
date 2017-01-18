package entities;

public abstract class EntityBase {

	public boolean isSameClass(Object o) {
		return o instanceof EntityBase //
				&& this.getClass() == o.getClass();
	}

	/**
	 * surrogate identifier
	 * 
	 * @return
	 */
	public abstract int getId();

	public abstract void setId(int id);

	@Override
	public boolean equals(final Object otherObject) {
		if (this == otherObject) {
			return true;
		}
		if (!this.isSameClass(otherObject)) {
			return false;
		}
		EntityBase otherEntity = (EntityBase) otherObject;
		return this.getId() == otherEntity.getId();
	}

	@Override
	public int hashCode() {
		return this.getId();
	}
}