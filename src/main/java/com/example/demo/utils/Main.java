package com.example.demo.utils;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;


import org.apache.mahout.cf.taste.impl.similarity.EuclideanDistanceSimilarity;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.recommender.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    final static int NEIGHBORHOOD_NUM = 10;   //用户邻居数量
    final static int RECOMMENDER_NUM = 20;    //推荐结果个数

    public static List<Integer> main(Integer uid) throws IOException, TasteException {

        String file = "./data.csv";   //数据集，其中第一列表示用户id；第二列表示电影id；第三列表示评分
        DataModel model = new FileDataModel(new File(file));  //基于文件的model，通过文件形式来读入

        //基于项目的协同过滤算法
        UserSimilarity user = new EuclideanDistanceSimilarity(model);  //计算欧几里德距离，欧几里德距离来定义相似性，用s=1/(1+d)来表示，范围在[0,1]之间，值越大，表明d越小，距离越近，则表示相似性越大
        NearestNUserNeighborhood neighbor = new NearestNUserNeighborhood(NEIGHBORHOOD_NUM, user, model);

        //构建基于用户的推荐系统
        Recommender r = new GenericUserBasedRecommender(model, neighbor, user);

        //得到所有用户的id集合
        LongPrimitiveIterator iter = model.getUserIDs();

        List<RecommendedItem> list = r.recommend(uid, RECOMMENDER_NUM);  //获取推荐结果集合
        //遍历推荐结果
        List<Integer> ids = new ArrayList<>();
        for (RecommendedItem ritem : list) {
            ids.add(Integer.parseInt(String.valueOf(ritem.getItemID())));
        }
        return ids;
    }
}
