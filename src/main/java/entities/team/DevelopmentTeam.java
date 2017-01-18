package entities.team;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import entities.employees.Developer;

@Entity
@DiscriminatorValue("DEVELOPMENT-TEAM")
@Table(name = "DEVELOPMENT_TEAM")
public class DevelopmentTeam extends Team {

	@ManyToMany( //
			fetch = FetchType.LAZY, //
			targetEntity = Developer.class)
	@JoinTable( //
			name = "DEVELOPMENT_TEAM_DEVELOPER", //
			joinColumns = { //
					@JoinColumn(name = "DEVELOPMENT_TEAM_ID", referencedColumnName = "TEAM_ID") }, //
			inverseJoinColumns = { //
					@JoinColumn(name = "DEVELOPER_ID", referencedColumnName = "EMPLOYEE_ID") //
			})
	private List<Developer> developers;

	public List<Developer> getDevelopers() {
		return this.developers;
	}

	public void setDevelopers(List<Developer> developers) {
		this.developers = developers;
	}

	public void addDeveloper(Developer developer) {
		if (this.developers == null) {
			this.developers = new ArrayList<Developer>();
		}
		this.developers.add(developer);
	}

	public void removeDeveloper(Developer developer) {
		if (this.developers == null) {
			return;
		}
		this.developers.remove(developer);
	}
}