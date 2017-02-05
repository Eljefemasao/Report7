package jp.ac.uryukyu.ie.e145165;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.activation.ActivationGroup_Stub;

/**
 * Created by masaaki on 2017/02/05.
 */
public class Report7 {
    public static void main(String args[]){


        int count=0;

        //答えの配列を用意
        int[] Answer = new int[3];
        //あらかじめAnswerを作成,今回は1~５までのランダムな数字を用意
        for(int i=0;i<Answer.length;i++){
            Answer[i] = (int)(Math.random()*5+1);
        }
        //C言語だとプレイヤーの入力はscanfを使いたいが、javaだと何を使うのか確認
        //配列をバッファリングすることで効率よく文字型入力ストリームからテキストを読み込める
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        //プレイヤーが入力した数字を格納する配列を用意
        int[] input = new int[3];
        //Gameの導入
        while(true){
            count++;
            System.out.println(count+"round");
            for(int i=0;i<Answer.length;i++) {
                System.out.println((i + 1) + "桁目:");
                try {
                    input[i] = Integer.parseInt(read.readLine()); //読み込みがstring型なのでintに修正

                } catch (IOException e) {
                    System.err.println("IOExceptionです。もう１度入力してください");
                    i--; //カウントを戻します

                }catch(NumberFormatException e) {
                    System.out.println("数字を入力してください");
                    i--;//カウントを戻します
                }
            }


        /* プレイヤーが入力した数値が答えと照らし合わせて
         * 桁と数字があっているのかどうかをhit(桁と数字があっている)とball(答えに同じ数字がある)を用いて表示
         */

            //Answerとplayerの入力とを比較確認しhit,ballでヒントを与えます
           int hit=0; int ball=0;
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
            //プレイヤーの入力がhit==3になればgameclearとする
            System.out.println("hit="+hit+"\tball="+ball);
            if(hit==3){
                System.out.println("ビンゴ！！！！");
                break;
            }else if(hit==2){
                System.out.println("惜しいなあ。。あと少しだ！頑張って！！");
            }else if(hit<=1){
                System.out.println("君は頑張りが足りない！よく考えて");


            }
        }
    }
}
