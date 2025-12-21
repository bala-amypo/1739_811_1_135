@Entity
public class EventUpdate {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    private Event event;

    private String updateContent;
    private String updateType;

    private Timestamp postedAt = new Timestamp(System.currentTimeMillis());
}
