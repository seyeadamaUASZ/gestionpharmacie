package com.sid.gl.repositories;

import com.sid.gl.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
   public User findUserByTelephone(String telephone);
}
