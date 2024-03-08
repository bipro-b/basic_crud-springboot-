package bipro.groups.crud_dev.repository;

import bipro.groups.crud_dev.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long > {

}
