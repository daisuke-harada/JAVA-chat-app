package com.example.quizapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class QuizAppController {
    // クラスQuiz
    private List<Quiz> quizzes = new ArrayList<>();

    // showメソッド
    // 戻り値 List<Quiz>型
    // 引数はない
    @GetMapping("/show")
    public List<Quiz> show() {
        return quizzes;
    }

    //createメソッド
    // 戻り値はない
    // 引数はString型のquestion,boolean型のAnswer(問題の正解)
    @PostMapping("/create")
    public void create(@RequestParam String question, @RequestParam boolean answer) {
        Quiz quiz = new Quiz(question, answer);
        quizzes.add(quiz);
    }

    // checkメソッド
    // 引数はString型のquestion, boolean型のanswer(回答)
    // 戻り値 正解・不正解かを文字列で返却
    @GetMapping("/check")
    public String check(@RequestParam String question,@RequestParam boolean answer){
        // TODO: 回答が正しいかどうかのチェックして、結果を返却する
        String
    }

}
