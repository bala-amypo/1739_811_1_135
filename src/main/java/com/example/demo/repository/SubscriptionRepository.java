import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;


public interface SubscriptionRepository extends JpaRepository<Subscription,Long> {
    boolean existsByUserIdAndEventId(Long userId, Long eventId);
    List<Subscription> findByUserId(Long userId);
}
