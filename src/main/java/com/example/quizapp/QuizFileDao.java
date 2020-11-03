package com.example.quizapp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

// Dao ・・・Data access objectの略
public class QuizFileDao {

    // 再代入できない
    // 定数 fieldに定数を作る場合はstaticのみではなくfinalも必要
    // 定数は大文字と_をつける
    private static final String FILE_PATH = "quizzes.txt";

    public void write(List<Quiz> quizzes) throws IOException {
        List<String> lines = new ArrayList<>();
        for (Quiz quiz: quizzes) {
            lines.add(quiz.toString());
        }

        Path path = Paths.get(FILE_PATH);
        // 第一引数・・・書き込み先のファイルパス（場所）
        // 第二引数・・・書き込むデータ List<String>
        Files.write(path, lines);
    }

    public List<Quiz> read() throws IOException {
        Path path = Paths.get(FILE_PATH);
        // １行１行読み込んで List Stringで返してくれる
        List<String> lines = Files.readAllLines(path); // 例外が発生すると throw例外を投げる

        List<Quiz> quizzes = new ArrayList<>();
        for (String line: lines) {
            quizzes.add(Quiz.fromString(line));
        }

        return quizzes;
    }
}
