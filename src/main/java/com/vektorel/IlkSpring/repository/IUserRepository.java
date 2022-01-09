package com.vektorel.IlkSpring.repository;

import com.vektorel.IlkSpring.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {

    // Jpa Repository içinde özelleştirilmiş sorgular  yazabilrisiniz.
    // Örnek kullanıcı adi ve şifresi için sorgulama yapmak
    // 1- aram parametrelerinin başına "find" eklenmeli
    // 2- arayacağınız alan için "By" eklemelisiniz
    // 3- değişken adını doğru niteleyin -> username=>Username,
    User findByUsernameAndPassword(String username,String password);
    User findOptionalByUsernameAndPassword(String username,String password);

}
