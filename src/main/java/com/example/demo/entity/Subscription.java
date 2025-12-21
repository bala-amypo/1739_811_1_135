@Entity
public class Subscription {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Event event;

    private Timestamp subscribedAt = new Timestamp(System.currentTimeMillis());
}
