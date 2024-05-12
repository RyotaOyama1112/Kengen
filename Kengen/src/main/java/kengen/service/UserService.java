package kengen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kengen.entity.User;
import kengen.form.UserForm;
import kengen.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean authenticate(String name, String password) {
        return userRepository.findByName(name)
                .map(user -> user.getPassword().equals(password))
                .orElse(false);
    }

    public void saveUser(UserForm userForm) {
        User user = new User();
        user.setUserID(userForm.getUserID());
        user.setName(userForm.getName());
        user.setPassword(userForm.getPassword());
        userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
