package persistence;

import entities.team.Team ;
import domain.repositories.ITeamRepository ;

public final class TeamRepository extends RepositoryBase<Team> implements ITeamRepository {

	protected TeamRepository(Context context) {
		super(context, Team.class);
	}
}