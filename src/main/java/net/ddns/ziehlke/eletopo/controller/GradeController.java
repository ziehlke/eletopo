package net.ddns.ziehlke.eletopo.controller;

import net.ddns.ziehlke.eletopo.entity.Grade;
import net.ddns.ziehlke.eletopo.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/grade")
public class GradeController {
    private final GradeRepository gradeRepository;

    @Autowired
    public GradeController(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    @GetMapping("/add")
    public @ResponseBody String addNewGrade(@RequestParam String name, @RequestParam float value){

        Grade grade = new Grade();
        grade.setName(name);
        grade.setValue(value);

        gradeRepository.save(grade);
        return "Saved.";
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<Grade> getAllGrades(){
        return gradeRepository.findAll();
    }


}
