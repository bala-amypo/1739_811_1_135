import jakarta.persistence.*;
import java.sql.Timestamp;


@Entity
public class BroadcastLog {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    private EventUpdate eventUpdate;

    @ManyToOne
    private User subscriber;

    private String deliveryStatus;
    private Timestamp sentAt = new Timestamp(System.currentTimeMillis());
}
