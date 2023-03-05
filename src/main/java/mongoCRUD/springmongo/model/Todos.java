package mongoCRUD.springmongo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "todos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Todos {
@Id
    private String todoId;
    private String title;
    private String description;
    private Boolean isComplete;

}
