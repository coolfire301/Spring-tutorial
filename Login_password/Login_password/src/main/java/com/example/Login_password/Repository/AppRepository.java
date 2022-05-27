package com.example.Login_password.Repository;

import com.example.Login_password.Construct.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AppRepository extends JpaRepository<Users, String> {


    public Users findByUsername(String username);

    @Query(value = "SELECT password FROM users WHERE username='Timo'", nativeQuery = true)
    String getTimoPS();
}
