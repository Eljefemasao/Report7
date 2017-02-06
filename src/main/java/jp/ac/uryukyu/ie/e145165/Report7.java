package jp.ac.uryukyu.ie.e145165;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Created by masaaki on 2017/02/05.
 */
public class Report7 {
    public static void main(String args[]){


        int count=0;

       //newReport7のオブジェクト
        newReport7 newone = new newReport7();


        //C言語だとプレイヤーの入力はscanfを使いたいが、javaだと何を使うのか確認
        //配列をバッファリングすることで効率よく文字型入力ストリームからテキストを読み込める
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        //Answerの作成
        newone.makeAnswer();

        //Gameの導入
        while(true){
            count++;
            System.out.println(count+"round");
            for(int i=0;i<newone.Answer.length;i++) {
                System.out.println((i + 1) + "桁目:");
                try {
                    newone.input[i] = Integer.parseInt(read.readLine()); //読み込みがstring型なのでintに修正

                } catch (IOException e) {
                    System.err.println("IOExceptionです。もう１度入力してください");
                    i--; //カウントを戻します

                }catch(NumberFormatException e) {
                    System.out.println("数字を入力してください");
                    i--;//カウントを戻します
                }
            }

            //Answerの確認
            newone.chackAnswer();

            //プレイヤーの入力がhit==3になればgameclearとする
            System.out.println("hit="+newone.hit+"\tball="+newone.ball);
            if(newone.hit==3){
                System.out.println("ビンゴ！！！！");
                break;
            }else if(newone.hit==2){
                System.out.println("惜しいなあ。。あと少しだ！頑張って！！");
            }else if(newone.hit<=1){
                System.out.println("君は頑張りが足りない！よく考えて");


            }
        }
    }
}
