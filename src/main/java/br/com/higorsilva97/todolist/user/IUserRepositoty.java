package br.com.higorsilva97.todolist.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IUserRepositoty extends JpaRepository <UserModel, UUID>{
    UserModel findByUsername(String username);

}
