package com.game.TestGame.Service;

import com.game.TestGame.Model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends MongoRepository<Student, String> {

}
