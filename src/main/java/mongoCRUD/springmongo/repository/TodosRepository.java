package mongoCRUD.springmongo.repository;

import mongoCRUD.springmongo.model.Todos;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TodosRepository extends MongoRepository<Todos,String> {
    List<Todos> findByTitle(String title);

    @Query("isComplete: ?0")
    List<Todos> findByStatus(Boolean status);
}
