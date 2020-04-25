package edu.tcu.cs.hogwartsartifactsonline.dao;

import edu.tcu.cs.hogwartsartifactsonline.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
}
