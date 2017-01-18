package entities.employees;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import entities.team.ITSupportTeam;
import entities.team.Team;

@Entity
@DiscriminatorValue("IT-SPECIALIST")
public class ITSpecialist extends Employee {

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = ITSupportTeam.class, //
			optional = true)
	@JoinColumn(name = "IT_SUPPORT_TEAM_ID", //
	foreignKey = @ForeignKey(name = "IT_SPECIALIST_IT_SUPPORT_TEAM_FK"))
	private Team team;

	public Team getTeam() {
		return this.team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
}