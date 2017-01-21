package net.metrosystems.data.accessors;

import com.datastax.driver.mapping.Result;
import com.datastax.driver.mapping.annotations.Accessor;
import com.datastax.driver.mapping.annotations.Param;
import com.datastax.driver.mapping.annotations.Query;
import java.util.Date;
import net.metrosystems.data.domain.ToDo;

@Accessor
public interface ToDoAccessor {

  @Query("select * FROM to_do WHERE title=:title")
  ToDo getToDoByTitle(@Param("title") String title);

  @Query("select * FROM to_do")
  Result<ToDo> getAllToDos();

  @Query("delete FROM to_do WHERE title=:title")
  void deleteToDoByTitle(@Param("title") String title);

  @Query("UPDATE to_do set is_done=:isDone, description=:description, updated_on=: updatedOn WHERE title=:title")
  void updateToDo(@Param("title") String title, @Param("description") String description, @Param("isDone") Boolean isDone, @Param("updatedOn") Date updatedOn);

}
