package domain.queries;

public final class CityQuery extends QueryBase {

	public String _name;
	
	public boolean hasName() {
		return this.isSet(_name);
	}

	public void clear() {
		_id = null;
		_name = null;
	}
}