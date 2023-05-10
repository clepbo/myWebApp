package com.myWebApp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired private UserRepository repo;

    public List<Users> listAll(){
        return (List<Users>) repo.findAll();
    }

    public void save(Users users) {
        repo.save(users);
    }

    public Users get(Integer id) throws UserNotFoundException{
       Optional<Users> result =  repo.findById(id);

       if(result.isPresent()){
           return result.get();
       }
       throw new UserNotFoundException("Could not find any user with Id " + id);
    }

    public void deleteUser (Integer id) throws UserNotFoundException {
        Long count = repo.countById(id);
        if(count == null || count == 0){
            throw new UserNotFoundException("Could not find any user with Id " + id);
        }
        repo.deleteById(id);
    }
}
