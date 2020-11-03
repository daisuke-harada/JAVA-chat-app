package com.example.quizapp;

// アクセス修飾子
// publicは他のクラスから参照できる
// privateだと他のクラスからは参照できない

// Objectという親クラスを持っている
public class Quiz {
    /**
     * 問題文
     */
    private String question;

    /**
     * 正解
     */
    private boolean answer;

    public Quiz(String question, boolean answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion(){
        return question;
    }

    public boolean isAnswer(){
        return answer;
    }

    @Override
    public String toString() {
        // 条件演算子 true:false
        String marubatsu = answer ? "○" : "×";
        return question + "" + marubatsu;
    }

    // line ・・・・
    // 問題文○
    // 問題文は文字数が決まっていない
    // lengthは文字列の長さを返してくれる
    // endsWith 引数で示した文字列で終わっていればtrueを返すし終わっていなければfalseを返す。
    // staticをついているからインスタンスを呼び出さずにすんだ

    public static Quiz fromString(String line) {
        String question = line.substring(0, line.length() - 1);
        boolean answer = line.endsWith("○");

        return new Quiz(question, answer);

    }
}
