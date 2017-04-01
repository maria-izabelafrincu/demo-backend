package com.licenta.freetime.data.accessors;

import com.datastax.driver.mapping.Result;
import com.datastax.driver.mapping.annotations.Accessor;
import com.datastax.driver.mapping.annotations.Param;
import com.datastax.driver.mapping.annotations.Query;
import java.util.Date;
import com.licenta.freetime.data.domain.User;

@Accessor
public interface UserAccessor {

  @Query("select * FROM users WHERE email=:email")
  User getUserByEmail(@Param("email") String email);

  @Query("select * FROM users")
  Result<User> getAllUsers();

  @Query("delete FROM users WHERE email=:email")
  void deleteUserByEmail(@Param("email") String email);

  @Query("UPDATE users set password=:password, first_name=:firstName, last_name=:lastName WHERE email=:email")
  void updateUser(@Param("email") String email, @Param("password") String password, @Param("firstName") String firstName, @Param("lastName") String lastName);

}
