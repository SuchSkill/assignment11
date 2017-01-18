package entities.team;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import entities.EntityBase ;
import entities.employees.ProjectManager ;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TEAM_TYPE")
@Table(name = "TEAM")
public abstract class Team extends EntityBase {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TEAM_SEQ")
	@SequenceGenerator(name = "TEAM_SEQ", sequenceName = "TEAM_SEQ", allocationSize = 1)
	@Column(name = "TEAM_ID", unique = true, nullable = false)
	private int id;

	@Column(name = "TEAM_NAME", nullable = false)
	private String name;

	@OneToOne( //
			fetch = FetchType.EAGER, //
			targetEntity = ProjectManager.class, //
			optional = false)
	@JoinColumn( //
			name = "PROJECT_MANAGER_ID", //
			foreignKey = @ForeignKey(name = "TEAM_PROJECT_MANAGER_FK"))
	private ProjectManager projectManager;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ProjectManager getProjectManager() {
		return this.projectManager;
	}

	public void setProjectManager(ProjectManager projectManager) {
		this.projectManager = projectManager;
	}
}