package com.example.lanshiliang.calculator;

import java.util.ArrayList;

/**
 * Created by lanshiliang on 2015/12/23.
 */
public class Data {
    private ArrayList<Character> arrayList=new ArrayList<>();
    private ArrayList<Character> test=new ArrayList<>();

    Data(){
        test.add('+');
        test.add('-');
        test.add('*');
        test.add('/');
        test.add('.');
    }

    public double compute(){
        if (arrayList.isEmpty()){
            return 0;
        }
        double result=0,a=1;
        if(arrayList.get(0)=='+'){
            arrayList.remove(0);
        }
        if(arrayList.get(0)=='-'){
            arrayList.remove(0);
            a=-1;
        }
        String[] s=this.toString().split("\\+|-|\\*|/");
        int flag=0;
        result=a* Double.parseDouble(s[flag]);

        for (char c:arrayList){
            System.out.println(result);
            if(flag>s.length-2) break;
            switch (c){
                case '+':
                    result+= Double.parseDouble(s[flag+1]);
                    flag++;
                    break;
                case '-':
                    result-= Double.parseDouble(s[flag+1]);
                    flag++;
                    break;
                case '*':
                    result*= Double.parseDouble(s[flag+1]);
                    flag++;
                    break;
                case '/':
                    result/= Double.parseDouble(s[flag+1]);
                    flag++;
                    break;
            }

        }
        return result;
    }
    public  void reMoveAll(){
        arrayList.removeAll(arrayList);
    }
    public boolean add(char c){
        if (arrayList.isEmpty()){
            if(c=='.') {
                arrayList.add('0');
                arrayList.add('.');
            }
             else if(c!='/'||c!='*'||c!='='){
                arrayList.add(c);
            }
            return true;
        }
        char last=arrayList.get(arrayList.size()-1);
        if (test.contains(last)&&test.contains(c)){
            return false;
        }
        arrayList.add(c);
        return true;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer=new StringBuffer();
        for(char c:arrayList){
            stringBuffer.append(c);
        }
        return stringBuffer.toString();
    }
}
