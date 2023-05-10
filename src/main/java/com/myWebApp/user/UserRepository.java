package com.myWebApp.user;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users, Integer> {
    Long countById(Integer is);
}
