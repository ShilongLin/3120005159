package com.comparator;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.corpus.tag.Nature;
import com.hankcs.hanlp.seg.common.Term;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Comparator {
    public static Double getConsineSimilarity(String textA,String textB){
        // 从文本中提取出关键词数组
        List<String> wordListA = Comparator.extractWordFromText(textA);
        List<String> wordListB = Comparator.extractWordFromText(textB);

        List<Double> vectorA=new ArrayList<>();
        List<Double> vectorB=new ArrayList<>();

        // 将关键词数组转化为词向量并保存至vertorA和vertorB中
        Comparator.convertWordList2Vector(wordListA,wordListB,vectorA,vectorB);

        // 计算向量夹角的余弦值
        double cosine=Double.parseDouble(String.format("%.4f",Comparator.countCosine(vectorA,vectorB)));
        return cosine;
    }

    /*
    * 将文本根据词语分成字符串队列（引用hanlp）
    * */
    public static List<String> extractWordFromText(String text){
        // resultList 作为结果返回
        List<String> resultList=new ArrayList<>();

        // 判断text为空
        if(text==null){
            return resultList;
        }

        // 引用HanLP
        List<Term> termList = HanLP.segment(text);
        // 提取重要对比词汇
        // - 名词 - 动词 - 形容词 - 动名词
        for (Term term:termList){
            if(term.nature== Nature.n||term.nature==Nature.v||term.nature==Nature.a||term.nature==Nature.vn){
                resultList.add(term.word);
            }
        }

        // 返回提取后的重要词汇队列
        return resultList;
    }

    public static Map<String,Double> buildFrequencyTable(List<String> wordList,List<String> vocabulary){
        // 建立频数表
        Map<String,Integer> countTable = new HashMap<>();
        for(String word:wordList){
            if(countTable.containsKey(word)){
                countTable.put(word,countTable.get(word)+1);
            }else {
                countTable.put(word,1);
            }
            // 出现不同于遍历途中之前的元素时，往vocabulary中添加
            if(!vocabulary.contains(word)){
                vocabulary.add(word);
            }
        }

        // totalCount用于记录词的出现总次数
        int totalCount=wordList.size();

        // 将频数转化为频率表
        Map<String,Double> frequencyTable=new HashMap<>();
        for (String key:countTable.keySet()){
            frequencyTable.put(key,(double)countTable.get(key)/totalCount);
        }
        return frequencyTable;
    }

    private static void getWordVectorFromFrequencyTable(Map<String,Double> frequencyTable,List<Double> wordVector,List<String> vocabulary){
        for (String word : vocabulary) {
            double value = 0.0;
            if(frequencyTable.containsKey(word)){
                value = frequencyTable.get(word);
            }
            wordVector.add(value);
        }
    }

    public static List<String> convertWordList2Vector(List<String> wordListA,List<String> wordListB,List<Double> vectorA,List<Double> vectorB){
        // 词汇表
        List<String> vocabulary = new ArrayList<>();

        // 获取词汇表 wordListA 的频率表，并同时建立词汇表
        Map<String,Double> frequencyTableA = buildFrequencyTable(wordListA, vocabulary);

        // 获取词汇表 wordListB 的频率表，并同时建立词汇表
        Map<String,Double> frequencyTableB = buildFrequencyTable(wordListB, vocabulary);

        // 根据频率表得到向量
        getWordVectorFromFrequencyTable(frequencyTableA,vectorA,vocabulary);
        getWordVectorFromFrequencyTable(frequencyTableB,vectorB,vocabulary);

        return vocabulary;
    }

    // 计算向量平方和的开方
    public static double countSquareSum(List<Double> vector){
        double result = 0.0;
        for (Double value : vector) {
            result += value*value;
        }
        return Math.sqrt(result);
    }

    /**
     * @Description 计算向量 A 和向量 B 的夹角余弦值
     * @param vectorA   : 词向量 A
     * @param vectorB   : 词向量 B
     * @return
     */
    public static double countCosine(List<Double> vectorA,List<Double> vectorB){
        // 分别计算向量的平方和
        double sqrtA = countSquareSum(vectorA);
        double sqrtB = countSquareSum(vectorB);

        // 计算向量的点积
        double dotProductResult = 0.0;
        for(int i = 0;i < vectorA.size();i++){
            dotProductResult += vectorA.get(i) * vectorB.get(i);
        }

        return dotProductResult/(sqrtA*sqrtB);
    }

//    public static void main(String[] args) {
//        List<String> xxList=extractWordFromText("Baby,baby,是不是爱给的不够你要怀疑！");
//        for(String x:xxList){
//            System.out.print(x+"+");
//        }
//    }
}
