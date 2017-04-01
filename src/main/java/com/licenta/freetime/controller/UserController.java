package com.licenta.freetime.controller;

import com.licenta.freetime.data.domain.User;
import com.licenta.freetime.data.repository.UserRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

@CrossOrigin(allowedHeaders = "*")
@RestController("users")
public class UserController {

  private final UserRepository userRepository;

  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @GetMapping(value = "users/{email}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public User getUserByEmail(@PathVariable("email") String email) {
    return userRepository.getUserByEmail(email);
  }

  @GetMapping(value = "users", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public List<User> getAllUsers() {
    return userRepository.getAllUsers();
  }

  @PostMapping(value = "users", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public User createUser(@RequestBody User user) {
    user.setCreatedOn(new Date());
    userRepository.saveUser(user);
    return user;
  }

  @PutMapping(value = "users/{email}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public User updateUser(@RequestBody User user) {
    User userRepSearched = userRepository.getUserByEmail(user.getEmail());

    if(userRepSearched !=null) {
      userRepSearched.setUpdatedOn(new Date());
      user.setCreatedOn(userRepSearched.getCreatedOn());
      String userPassword = ( user.getPassword()!= null ) ? user.getPassword() : userRepSearched.getPassword();
      String firstName = ( user.getFirstName()!= null ) ? user.getFirstName() : userRepSearched.getFirstName();
      String lastName = ( user.getLastName()!= null ) ? user.getLastName() : userRepSearched.getLastName();
      userRepository.updateUser( userRepSearched.getEmail(), userPassword, firstName, lastName);
    }
    return userRepository.getUserByEmail(user.getEmail());
  }

  @DeleteMapping(value = "users/{email}")
  public void deleteUserByEmail(@PathVariable("email") String email) {
    userRepository.deleteUserByEmail(email);
  }
}
