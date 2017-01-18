package entities.employees;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import entities.team.DevelopmentTeam;

@Entity
@DiscriminatorValue("DEVELOPER")
public class Developer extends Employee {

	@ManyToMany(fetch = FetchType.LAZY, targetEntity = DevelopmentTeam.class)
	@JoinTable( //
	name = "DEVELOPMENT_TEAM_DEVELOPER", //
	joinColumns = { // 
			@JoinColumn(name = "DEVELOPER_ID", referencedColumnName = "EMPLOYEE_ID") }, //
	inverseJoinColumns = { // 
			@JoinColumn(name = "DEVELOPMENT_TEAM_ID", referencedColumnName = "TEAM_ID") } //
	)
	private List<DevelopmentTeam> teams;

	public List<DevelopmentTeam> getTeams() {
		return this.teams;
	}

	public void setTeams(List<DevelopmentTeam> teams) {
		this.teams = teams;
	}
}