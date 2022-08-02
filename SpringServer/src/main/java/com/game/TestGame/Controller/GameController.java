package com.game.TestGame.Controller;

import com.game.TestGame.Model.Address;
import com.game.TestGame.Model.Student;
import com.game.TestGame.MyButton;
import com.game.TestGame.CreateButton;
import com.game.TestGame.Request;
import com.game.TestGame.Response;
import com.game.TestGame.Service.TestRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("http://localhost:9090")
@RestController
@Slf4j
@AllArgsConstructor
public class GameController {
    @Autowired
    TestRepository repo;

    @GetMapping("/")
    public String def() {
        log.info("posttt shit");

        Student student = new Student("andrasi2",
                "benedek",
                new Address("hungary",
                        "nyiregyhaza"),
                List.of("sut the", "fuck up"));
        repo.save(student);


        return "mukodj";
    }

    @PostMapping("/test")
    public ResponseEntity<MyButton> start(@RequestBody MyButton btn) {
        log.info("start test request: {}", btn);
        btn.setButtonString(btn.getButtonString() + " yeee");
        return ResponseEntity.ok(btn);
    }


    @PostMapping("/create")
    public ResponseEntity<CreateButton> create(@RequestBody CreateButton btn) {
        log.info("start test create quest: {}  {}", btn,1);
        return ResponseEntity.ok(btn);
    }

    @PostMapping("/fetch")
    public ResponseEntity<List<Student>> fetch(@RequestBody Request req) {
        if(req.getMethod().equals("FETCH")){
            log.info("fetch shit");
            ArrayList<Student> students = (ArrayList<Student>) repo.findAll();
            return ResponseEntity.ok(students);
        }
        return ResponseEntity.ok(new ArrayList<>());
    }



    /// fix the request, because it can not convert from json
    /// Cannot deserialize value of type `com.game.TestGame.Request` from Array value (token `JsonToken.START_ARRAY`)
    @PostMapping("/update")
    public ResponseEntity<Response> update(@RequestBody Request req) {
        if(req.getMethod().equals("UPDATE")){
            log.info("update shit");
            repo.save(
                    new Student("andrasi3",
                            "benedek",
                            new Address("hungary",
                                    "nyiregyhaza"),
                            List.of("sut the", "fuck up")));
            return ResponseEntity.ok(new Response("SUCCESSFUL UPDATE"));
        }

        return ResponseEntity.ok(new Response("FAILED TO UPDATE"));
    }
}
