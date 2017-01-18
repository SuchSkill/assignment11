package entities.periods;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Period {
	
	@Column(name = "START_DATE", nullable = false)
	private Date startDate;
	
	@Column(name = "END_DATE", nullable = true)
	private Date endDate;
}