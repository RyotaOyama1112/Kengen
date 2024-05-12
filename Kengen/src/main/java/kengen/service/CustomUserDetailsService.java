package kengen.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kengen.entity.User;
import kengen.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // `findByName` メソッドを使ってユーザーを取得
        Optional<User> userOpt = userRepository.findByName(username);
        if (!userOpt.isPresent()) {
            throw new UsernameNotFoundException("User not found");
        }
        User user = userOpt.get();
        return org.springframework.security.core.userdetails.User.builder()
            .username(user.getName())
            .password(user.getPassword())
            .roles("USER") // 適切なロールを割り当ててください
            .build();
    }
}
