package kengen.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kengen.entity.AuthorityManagement;
import kengen.repository.AuthorityManagementRepository;

@Service
public class AuthorityManagementService {

    @Autowired
    private AuthorityManagementRepository repository;

    public List<AuthorityManagement> findAll() {
        return repository.findAll();
    }

    public AuthorityManagement findById(String userId) {
        Optional<AuthorityManagement> result = repository.findById(userId);
        return result.orElse(null);
    }

    public void save(AuthorityManagement authorityManagement) {
        repository.save(authorityManagement);
    }
}
