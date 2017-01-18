package entities.team;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import entities.employees.ITSpecialist ;

@Entity
@DiscriminatorValue("IT-SUPPORT-TEAM")
@Table(name = "IT_SUPPORT_TEAM")
public class ITSupportTeam extends Team {

	@OneToMany( //
			fetch = FetchType.LAZY, //
			targetEntity = ITSpecialist.class)
	@JoinTable(name = "IT_SUPPORT_TEAM_IT_SPECIALIST")
	private List<ITSpecialist> itSpecialists;

	public List<ITSpecialist> getITSpecialists() {
		return this.itSpecialists;
	}

	public void setApprentices(List<ITSpecialist> itSpecialists) {
		this.itSpecialists = itSpecialists;
	}
}