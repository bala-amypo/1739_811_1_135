public interface EventUpdateRepository extends JpaRepository<EventUpdate,Long> {
    List<EventUpdate> findByEventId(Long eventId);
}
