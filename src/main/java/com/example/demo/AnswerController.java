package com.example.demo;

import org.springframework.web.bind.annotation.*;
import parseo.AnswerGenerator;

import java.text.Normalizer;
import java.util.Date;
import java.util.List;

@RestController
class AnswerController {
    private final AnswerRepository repository;
    private final AnswerGenerator generator;
    AnswerController(AnswerRepository repository){
        this.repository=repository;
        this.generator=new AnswerGenerator();
    }
    @GetMapping("/historial")
    List<Answer> all(){
        return repository.findAll();
    }
    @PostMapping("/historial")
    Answer newAnswer(@RequestBody Answer newAnswer){
        return repository.save(newAnswer);
    }
    @GetMapping("historial/{id}")
    Answer one(@PathVariable Long id){
        return repository.findById(id).orElseThrow(()->new AnswerNotFoundException(id));
    }
    @PutMapping("/historial/{id}")
    Answer replaceAnswer(@RequestBody Answer newAnswer, @PathVariable Long id){
        return repository.findById(id)
                .map(answer -> {
            answer.setReconocido(newAnswer.getReconocido());
            answer.setAccion(newAnswer.getAccion());
            answer.setCreado(new Date());
            return repository.save(answer);
        }).orElseGet(()->{
                    newAnswer.setId(id);
                    return repository.save(newAnswer);
                });
    }
    @DeleteMapping("/historial/{id}")
    void deleteAnswer(@PathVariable Long id){
        repository.deleteById(id);
    }
    @CrossOrigin
    @GetMapping("/new/{recon}")
    Answer newAnswer(@PathVariable String recon){
        recon=Normalizer.normalize(recon, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
        return repository.save(generator.parseRecognized(recon));
    }
}
