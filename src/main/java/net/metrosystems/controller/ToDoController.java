package net.metrosystems.controller;

import net.metrosystems.data.domain.ToDo;
import net.metrosystems.data.repository.ToDoRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@CrossOrigin(allowedHeaders = "*")
@RestController("to_do")
public class ToDoController {

  private final ToDoRepository toDoRepository;

  public ToDoController(ToDoRepository toDoRepository) {
    this.toDoRepository = toDoRepository;
  }

  @GetMapping(value = "to_do/{title}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ToDo getToDoByTitle(@PathVariable("title") String title) {
    return toDoRepository.getToDoByTitle(title);
  }

  @GetMapping(value = "to_do", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public List<ToDo> getAll() {
    return toDoRepository.getAll();
  }

  @PostMapping(value = "to_do", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ToDo createToDo(@RequestBody ToDo toDo) {
    toDo.setCreatedOn(new Date());
    toDo.setIsDone(false);
    toDoRepository.saveToDo(toDo);
    return toDo;
  }

  @PutMapping(value = "to_do/{title}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ToDo updateToDo(@RequestBody ToDo toDo) {

    if(toDoRepository.getToDoByTitle(toDo.getTitle())!=null) {
      toDo.setUpdatedOn(new Date());
      toDo.setCreatedOn(toDo.getCreatedOn());
      toDoRepository.updateToDo(toDo.getTitle(), toDo.getDescription(), toDo.getIsDone(), toDo.getUpdatedOn());
    }
    return toDoRepository.getToDoByTitle(toDo.getTitle());
  }

  @DeleteMapping(value = "to_do/{title}")
  public void deleteToDo(@PathVariable("title") String title) {
    toDoRepository.deleteToDoByTitle(title);
  }
}
