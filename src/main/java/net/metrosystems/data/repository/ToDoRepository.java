package net.metrosystems.data.repository;

import java.util.List;
import java.util.Date;
import net.metrosystems.data.CassandraPersistenceService;
import net.metrosystems.data.accessors.ToDoAccessor;
import net.metrosystems.data.domain.ToDo;
import org.springframework.stereotype.Repository;
import com.datastax.driver.mapping.Mapper;

@Repository
public class ToDoRepository {
    private final CassandraPersistenceService persistenceService;
    private final ToDoAccessor accessor;

    public ToDoRepository(CassandraPersistenceService persistenceService) {
        this.persistenceService = persistenceService;
        this.accessor = persistenceService.getMappingManager().createAccessor(ToDoAccessor.class);
    }

    public void saveToDo(ToDo toDo) {
        Mapper<ToDo> mapper = persistenceService.getMappingManager().mapper(ToDo.class);
        mapper.save(toDo);
    }

    public void deleteToDoByTitle(String title) {
        accessor.deleteToDoByTitle(title);
    }

    public ToDo getToDoByTitle(String title) {
        return accessor.getToDoByTitle(title);
    }

    public List<ToDo> getAll() {
        return accessor.getAllToDos().all();
    }

    public void updateToDo(String title, String description, Boolean isDone, Date updatedOn) {
        accessor.updateToDo(title, description, isDone, updatedOn);
    }
}
