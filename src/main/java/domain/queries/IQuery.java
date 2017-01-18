package domain.queries;

public interface IQuery {
	
	void clear();
	
	default public boolean isSet(String property) {
		return property != null && !property.isEmpty();
	}
	
	default public boolean isSet(Integer property) {
		return property != null;
	}
}