package com.vektorel.IlkSpring.service;

import com.vektorel.IlkSpring.repository.IUserRepository;
import com.vektorel.IlkSpring.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    IUserRepository iUserRepository;

    public User save(User user){
        iUserRepository.save(user);
        return user;
    }
    public User update(User user){
        iUserRepository.save(user);
        return user;
    }
    public boolean delete(User user){
        try {
            iUserRepository.delete(user);
            return true;
        }catch (Exception exception){
            return false;
        }

    }
    public List<User> save(){
        return iUserRepository.findAll();
    }
    public User findById(long id){
      Optional<User> user = iUserRepository.findById(id);
      if(user.isPresent())
          return user.get();
      else
          return null;
    }
    public boolean isPassword(String username,String password){
        User user = iUserRepository.findByUsernameAndPassword(username,password);
        if(user==null)
            return false;
        else
            return true;
    }
}
