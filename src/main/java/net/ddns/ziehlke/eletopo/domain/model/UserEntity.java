package net.ddns.ziehlke.eletopo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.ddns.ziehlke.eletopo.model.Grade;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class UserEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    private String password;
    private String email;

    @OneToMany(mappedBy = "userEntity")
    private Set<VoteEntity> votedRoutes = new HashSet<>();

    public void addRouteVote(RouteEntity routeEntity, Grade grade) {
        VoteEntity voteEntity = new VoteEntity();
        voteEntity.setUserEntity(this);
        voteEntity.setRouteEntity(routeEntity);
        voteEntity.setUserGrade(grade);

        votedRoutes.add(voteEntity);
        routeEntity.getVotedUsers().add(voteEntity);
    }

    public void removeVoteOnRoute(RouteEntity routeEntity) {
        for (Iterator<VoteEntity> iterator = votedRoutes.iterator();
             iterator.hasNext(); ) {
            VoteEntity voteEntity = iterator.next();

            if (voteEntity.getUserEntity().equals(this) &&
                    voteEntity.getRouteEntity().equals(routeEntity)) {
                iterator.remove();
                voteEntity.getRouteEntity().getVotedUsers().remove(voteEntity);
                voteEntity.setUserEntity(null);
                voteEntity.setRouteEntity(null);
                voteEntity.setUserGrade(null);
            }
        }
    }
}
