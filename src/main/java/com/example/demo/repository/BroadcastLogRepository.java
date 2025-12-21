import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;


public interface BroadcastLogRepository extends JpaRepository<BroadcastLog,Long> {
    List<BroadcastLog> findByEventUpdateId(Long eventUpdateId);
}
