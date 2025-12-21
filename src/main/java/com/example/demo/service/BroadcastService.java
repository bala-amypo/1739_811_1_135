@Service
public class BroadcastService {
    private final SubscriptionRepository subRepo;
    private final BroadcastLogRepository logRepo;

    public BroadcastService(SubscriptionRepository subRepo, BroadcastLogRepository logRepo) {
        this.subRepo = subRepo;
        this.logRepo = logRepo;
    }

    public void broadcast(EventUpdate update) {
        for (Subscription s : subRepo.findAll()) {
            BroadcastLog log = new BroadcastLog();
            log.setEventUpdate(update);
            log.setSubscriber(s.getUser());
            log.setDeliveryStatus("SENT");
            logRepo.save(log);
        }
    }
}
