package net.metrosystems.data.domain;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;
import java.util.Date;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "to_do")
@Builder
public class ToDo {

  @Column(name = "title")
  @PartitionKey // echivaleaza aproximativ cu primary key din sql
  String title;

  @Column(name = "description")
  String description;

  @Column(name = "created_on")
  Date createdOn;

  @Column(name = "updated_on")
  Date updatedOn;

  @Column(name = "is_done")
  Boolean isDone;
}
