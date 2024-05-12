import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import kengen.KengenApplication;
import kengen.entity.User;
import kengen.repository.UserRepository;

@SpringBootTest(classes = {KengenApplication.class})
@ActiveProfiles("test") // これを追加します
public class UserRepositoryTest {
    
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByName() {
        String name = "test";
        Optional<User> user = userRepository.findByName(name);
        assertTrue(user.isPresent());
        assertEquals(name, user.get().getName());
    }
}
