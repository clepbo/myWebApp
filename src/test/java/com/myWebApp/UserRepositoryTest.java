package com.myWebApp;

import com.myWebApp.user.UserRepository;
import com.myWebApp.user.Users;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTest {
    @Autowired private UserRepository repo;

    @Test
    public void testAddNew(){
        Users users = new Users();
        users.setEmail("peter.abraham@uniabuja.edu.ng");
        users.setPassword("peter123");
        users.setFirstName("Abraham");
        users.setLastName("Peter");

        Users savedUser = repo.save(users);

        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testListALl(){
        Iterable<Users> users = repo.findAll();
        Assertions.assertThat(users).hasSizeGreaterThan(0);
        for (Users user : users) {
            System.out.println(user);

        }

    }

    @Test
    public void testUpdateUser(){
        int userId = 1;
        Optional<Users> optionalUsers = repo.findById(userId);
        Users users = optionalUsers.get();
        users.setPassword("oni123");
        repo.save(users);

        Users updateUser = repo.findById(userId).get();
        Assertions.assertThat(updateUser.getPassword()).isEqualTo("oni123");
    }

    @Test
    public  void testGetUserById(){
        int userId = 2;
        Optional<Users> optionalUsers = repo.findById(userId);
        Assertions.assertThat(optionalUsers).isPresent();
        System.out.println(optionalUsers.get());
    }

    @Test
    public void testDelete(){
        int userId = 1;
        repo.deleteById(userId);

        Optional<Users> optionalUsers = repo.findById(userId);
        Assertions.assertThat(optionalUsers).isNotPresent();
    }
}
