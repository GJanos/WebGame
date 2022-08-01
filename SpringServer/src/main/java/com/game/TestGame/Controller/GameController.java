package com.game.TestGame.Controller;

import com.game.TestGame.Model.Address;
import com.game.TestGame.Model.Student;
import com.game.TestGame.MyButton;
import com.game.TestGame.CreateButton;
import com.game.TestGame.Service.TestRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<MyButton> fetch(@RequestBody MyButton btn) {
        log.info("start test request: {}", btn);
        btn.setButtonString(btn.getButtonString() + " yeee");
        return ResponseEntity.ok(btn);
    }
    @PostMapping("/update")
    public void update() {
        log.info("update shit");
        repo.save(
                new Student("andrasi3",
                            "benedek",
                        new Address("hungary",
                                "nyiregyhaza"),
                        List.of("sut the", "fuck up")));
    }
}
