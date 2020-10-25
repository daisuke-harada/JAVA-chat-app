package com.example.quizapp;

// アクセス修飾子
// publicは他のクラスから参照できる
// privateだと他のクラスからは参照できない
public class Quiz{
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
    //
    @Override
    public String toString() {
        // 条件演算子 true:false
        String marubatsu = answer ? "○" : "×";
        return question + "" + marubatsu;
    }
}
