package MyFinanceHub.fino.Repo;

import MyFinanceHub.fino.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

//    public User findByUsernameAndPassword(String username,String Password);

    public User findByUsername(String username);


}
