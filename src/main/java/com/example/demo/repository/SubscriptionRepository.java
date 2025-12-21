public interface SubscriptionRepository extends JpaRepository<Subscription,Long> {
    boolean existsByUserIdAndEventId(Long userId, Long eventId);
    List<Subscription> findByUserId(Long userId);
}
