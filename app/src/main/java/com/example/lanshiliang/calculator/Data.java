package com.example.lanshiliang.calculator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public void multiply(){

    }

    public double compute(){
        if (arrayList.isEmpty()){
            return 0;
        }
        double result=0,a=1; //a用来记录正负
        if(arrayList.get(0)=='+'){
            arrayList.remove(0);
        }
        if(arrayList.get(0)=='-'){
            arrayList.remove(0);
            a=-1;
        }
        if (arrayList.isEmpty()){  //remove之后重新判读是否为空
            return 0;
        }
        String[] s=this.toString().split("\\+|-|\\*|/");
        ArrayList<Double> list=new ArrayList<>();//用来存储计算乘除后的所有数字
        System.out.println(list.toString());
        int flag=0;
        list.add(Double.parseDouble(s[0]));

        for (char c:arrayList){
            //遍历集合，对乘除优先计算，其次吧剩余数字加入list内
           // System.out.println(list);
            if(flag>s.length-2) break;
            switch (c){
                case '+':
                    list.add(Double.parseDouble(s[flag+1]));
                    //result+= Double.parseDouble(s[flag+1]);
                    flag++;
                    break;
                case '-':
                    list.add(Double.parseDouble(s[flag+1]));
                    //result-= Double.parseDouble(s[flag+1]);
                    flag++;
                    break;
                case '*':
                    list.set(list.size() - 1, list.get(list.size() - 1) * Double.parseDouble(s[flag + 1]));
                   // System.out.println(list);
                    flag++;
                    break;
                case '/':
                    list.set(list.size() - 1, list.get(list.size() - 1) / Double.parseDouble(s[flag + 1]));
                   // System.out.println(list);
                    flag++;
                    break;
            }

        }
        flag=0;
        result=a* list.get(0);
        for (char c:arrayList){
            //对list内的所有数字进行加减计算
            System.out.println(list);
            if(flag>(list.size()-2)) break;
            switch (c){
                case '+':
                    result+= list.get(flag + 1);
                    flag++;
                    break;
                case '-':
                    result-= list.get(flag+1);
                    flag++;
                    break;
            }

        }
        return result;
    }
    public  void reMoveAll(){ //用来清空list
        arrayList.removeAll(arrayList);
    }
    //添加元素，规则：1,为空的时候.变成0.
    //                  2,为空的时候不能添加*/=
    //                      3，不能添加两个-+*/.
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
