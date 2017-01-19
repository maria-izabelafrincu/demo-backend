package net.metrosystems.data.accessors;

import com.datastax.driver.mapping.Result;
import com.datastax.driver.mapping.annotations.Accessor;
import com.datastax.driver.mapping.annotations.Param;
import com.datastax.driver.mapping.annotations.Query;

import net.metrosystems.data.domain.ToDo;

@Accessor
public interface ToDoAccessor {

  @Query("select * FROM to_do WHERE title=:title")
  ToDo getToDoByTitle(@Param("title") String title);

  @Query("select * FROM to_do")
  Result<ToDo> getAllToDos();

  @Query("delete FROM to_do WHERE title=:title")
  void deleteToDoByTitle(@Param("title") String title);

  @Query("update to_do Set description=:description WHERE title=:title")
  void updateDescription(@Param("title") String title, @Param("description") String description);

  @Query("update to_do Set is_done=:is_done WHERE title=:title")
  void updateIsDone(@Param("title") String title, @Param("is_done") Boolean isDone);


}
