import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository repo;
    private final PasswordEncoder encoder;

    public UserService(UserRepository repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    public User register(User u) {
        if (repo.existsByEmail(u.getEmail()))
            throw new IllegalArgumentException("Email already exists");
        u.setPassword(encoder.encode(u.getPassword()));
        return repo.save(u);
    }
}
