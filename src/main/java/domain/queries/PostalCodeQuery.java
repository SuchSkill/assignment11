package domain.queries;

public final class


PostalCodeQuery extends QueryBase {

	public String _postalCode;
	public String _cityName;
	
	public boolean hasPostalCode() {
		return this.isSet(_postalCode);
	}
	
	public boolean hasCityName(){
		return this.isSet(_cityName);
	}
	
	public void clear() {
		_id = null;
		_cityName = null;
		_postalCode = null;
	}
}