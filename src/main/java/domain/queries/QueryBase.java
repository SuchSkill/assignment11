package domain.queries;

public abstract class QueryBase implements IQuery {

	public Integer _id;
	
	public final boolean hasId() {
		return this.isSet(_id);
	}
}