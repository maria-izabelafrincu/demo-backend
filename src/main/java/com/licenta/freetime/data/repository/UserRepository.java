package com.licenta.freetime.data.repository;

import java.util.List;
import java.util.Date;

import com.licenta.freetime.data.CassandraPersistenceService;
import com.licenta.freetime.data.accessors.UserAccessor;
import com.licenta.freetime.data.domain.User;
import org.springframework.stereotype.Repository;
import com.datastax.driver.mapping.Mapper;

@Repository
public class UserRepository {
    private final CassandraPersistenceService persistenceService;
    private final UserAccessor accessor;

    public UserRepository(CassandraPersistenceService persistenceService) {
        this.persistenceService = persistenceService;
        this.accessor = persistenceService.getMappingManager().createAccessor(UserAccessor.class);
    }

    public void saveUser(User user) {
        Mapper<User> mapper = persistenceService.getMappingManager().mapper(User.class);
        mapper.save(user);
    }

    public void deleteUserByEmail(String email) {
        accessor.deleteUserByEmail(email);
    }

    public User getUserByEmail(String email) {
        return accessor.getUserByEmail(email);
    }

    public List<User> getAllUsers() {
        return accessor.getAllUsers().all();
    }

    public void updateUser(String email, String password, String firstName, String lastName) {
        accessor.updateUser(email, password, firstName, lastName);
    }
}
