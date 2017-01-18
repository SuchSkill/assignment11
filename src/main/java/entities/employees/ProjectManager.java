package entities.employees;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import entities.team.Team;

@Entity
@DiscriminatorValue("PROJECT-MANAGER")
public class ProjectManager extends Employee {
	
	@OneToOne(fetch = FetchType.LAZY, targetEntity = Team.class, optional = true)
	@JoinColumn(name = "TEAM_ID", foreignKey = @ForeignKey(name = "PROJECT_MANAGER_TEAM_FK"))
	private Team team;
	
	public Team getTeam() {
		return this.team;
	}
	
	public void setTeam(Team team) {
		this.team = team;
	}
}