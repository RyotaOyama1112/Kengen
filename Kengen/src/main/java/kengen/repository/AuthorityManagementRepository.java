package kengen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kengen.entity.AuthorityManagement;

public interface AuthorityManagementRepository extends JpaRepository<AuthorityManagement, String> {
}
