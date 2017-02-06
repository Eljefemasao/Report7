package jp.ac.uryukyu.ie.e145165;


/**
 * Created by masaaki on 2017/02/06.
 */
public class newReport7 {

    //答えの配列を用意
    int[] Answer = new int[3];

    //プレイヤーが入力した数字を格納する配列を用意
    int[] input = new int[3];

    int hit; int ball;

    //機能ごとのメソッド化
    //Answerを作成します
    public int[] makeAnswer() {
        //あらかじめAnswerを作成,今回は1~５までのランダムな数字を用意
        for (int i = 0; i < Answer.length; i++) {
            Answer[i] = (int) (Math.random() * 5 + 1);
        }
        return Answer;
    }

    /* プレイヤーが入力した数値が答えと照らし合わせて
     * 桁と数字があっているのかどうかをhit(桁と数字があっている)とball(答えに同じ数字がある)を用いて表示
     */
    //上記をメソッド化
     public void chackAnswer(){
         hit=0; ball=0;
         //Answerとplayerの入力とを比較確認しhit,ballでヒントを与えます
         for(int i=0;i<Answer.length;i++){

            for(int j=0; j<Answer.length;j++){
                //桁と数字を確認
                if(input[i]==Answer[j]&&i==j){
                    hit++;
                    //数字のみを確認
                }else if(input[i]==Answer[j]){
                    ball++;
                }
            }
        }
    }
}
