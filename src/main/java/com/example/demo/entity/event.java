@Entity
public class Event {
    @Id @GeneratedValue
    private Long id;

    private String title;
    private String description;
    private String location;
    private String category;
    private boolean isActive = true;

    @ManyToOne
    private User publisher;

    private Timestamp createdAt = new Timestamp(System.currentTimeMillis());
}
