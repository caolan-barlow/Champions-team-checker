import java.util.List;

public class Team {
    private final List<TeamMember> teamMembers;

    public Team(List<TeamMember> members) {

        this.teamMembers = List.copyOf(members);

        if(members.isEmpty() || members.size() != 6){
            throw new IllegalArgumentException("You do not have 6 Pokemon in your team");
        }
    }

    public List<TeamMember> getTeam() {
        return teamMembers;
    }
    
}
