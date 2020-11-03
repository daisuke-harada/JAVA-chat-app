package com.example.quizapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// API ・・・Application Programing Interfaceの略
@RestController
public class QuizApiController {
    // クラスQuiz
    private List<Quiz> quizzes = new ArrayList<>();
    private QuizFileDao quizFileDao = new QuizFileDao();

    @GetMapping("/quiz")
    public Quiz quiz(){
        int index = new Random().nextInt(quizzes.size()); // 引数が３の時 0〜2
        return quizzes.get(index);
    }

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
        // 回答が正しいかどうかのチェックして、結果を返却する
        // 指定されたquestionを登録済のクイズから検索する
        for (Quiz quiz: quizzes) {
            // もしクイズが見つかったら
            if (quiz.getQuestion().equals(question)) {

                // answerがbooleanのため、equalsは使えない何故なら booleanはプリミティブ型であるから
                if (quiz.isAnswer() == answer) {
                    // 登録されているanswerと回答として渡ってきたanswerが一致していたら正解と返却
                    return "正解";
                }else{
                    // もし一致していなければ不正解と返却する
                    return "不正解";
                }

            }
        }
           // もしクイズが見つからなかった場合は、問題がありませんとと返却する。
           return "問題がありません";
    }

    @PostMapping("/save")
    public String save() {
        try {
            quizFileDao.write(quizzes);
            return "ファイルに保存しました";
        } catch (IOException e) {
            e.printStackTrace();
            return "ファイルの保存に失敗しました。";
        }
    }

    @GetMapping("/load")
    public String load() {
        try {
            quizzes = quizFileDao.read();
            return "ファイルを読み込みました";
        } catch (IOException e) { // 例外 IoException 例外を受け止める catch
            e.printStackTrace();
            return "ファイルの読み込に失敗しました。";
        }
    }
}
