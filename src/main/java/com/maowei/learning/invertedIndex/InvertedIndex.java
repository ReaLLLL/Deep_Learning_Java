package com.maowei.learning.invertedIndex;

import java.util.*;

public class InvertedIndex {

    /**
     * 倒排索引表
     */
    Map<String, IndexTable> keywordsIndexTableMap = new HashMap<String, IndexTable>();

    /**
     * 停顿词
     */
    Set<String> stopwords = new HashSet<String>();

    /**
     * 存储文档
     */
    List<String> store;

    public InvertedIndex(List<String> list) {
        store = list;
        for (int i = 0; i < list.size(); i++) {
            String li = keywordsHandler(list.get(i));
            String[] array = li.split(" ");
            for (int j = 0; j < array.length; j++) {
                addKeyWords(array[j], i, j);
            }
        }
        //停顿词 非关键词
        stopwords.add("is");
        stopwords.add("and");
        stopwords.add("or");
        stopwords.add("the");
    }

    /**
     * 建立索引 建立倒排索引表
     */
    public void addKeyWords(String keywords, Integer i, Integer j) {
        //去空
        if ("".equals(keywords)) {
            return;
        }
        IndexTable indexTable = keywordsIndexTableMap.get(keywords);
        if (indexTable == null) {
            //插入关键词信息
            indexTable = new IndexTable();
            indexTable.keywords = keywords;
            //插入关键词出现的文档Id,次数为1（首次出现）
            indexTable.docTimes.put(i, 1);
            //插入关键词出现的文档Id,在文档中位置
            indexTable.docIndex.put(i, " "+j);
            keywordsIndexTableMap.put(keywords, indexTable);
        } else {
            //更新关键词出现的文档、频率
            indexTable.docTimes.put(i, indexTable.docTimes.get(i) == null ? 1 : indexTable.docTimes.get(i) + 1);
            //更新关键词出现的文档、位置
            indexTable.docIndex.put(i, (indexTable.docIndex.get(i) == null ? "" : indexTable.docIndex.get(i)) + " " + j);
            keywordsIndexTableMap.put(keywords, indexTable);
        }
    }


    //去除无关词，统一大小写
    private String keywordsHandler(String doc) {
        doc = doc.replaceAll(",|:|\\.", " ");
        doc = doc.toLowerCase();
        return doc;
    }

    /**
     * 查询
     * @param keywords
     * @return
     */
    public List<String> search(String keywords) {
        keywords = keywordsHandler(keywords);

        //用Set可以去重
        String[] kewordsArray = keywords.split(" ");

        List<String> result = new ArrayList<String>();

        //<文档，出现次数>
        Map<Integer, DocTemp> docSortTimes = new HashMap();

        for (int i = 0; i < kewordsArray.length; i++) {
            String key = kewordsArray[i];
            IndexTable indexTable = keywordsIndexTableMap.get(key);
            if (indexTable == null) {
                continue;
            }
            //找到关键词，统计出现的文档，频率，出现的文档数
            for (Integer integer : indexTable.docTimes.keySet()) {
                if (docSortTimes.get(integer) == null) {
                    DocTemp docTemp = new DocTemp();
                    docTemp.docId = integer;
                    docTemp.times = 1;
                    docTemp.allTimes = indexTable.docTimes.get(integer);
                    docSortTimes.put(integer, docTemp);
                } else {
                    DocTemp docTemp = docSortTimes.get(integer);
                    docTemp.times++;
                    docTemp.allTimes += indexTable.docTimes.get(integer);
                }
            }
        }

        List<DocTemp> docTemps = new ArrayList<DocTemp>();
        //转化List 排序
        for (Integer docId : docSortTimes.keySet()) {
            DocTemp docTemp = docSortTimes.get(docId);
            docTemps.add(docTemp);
        }

        //对结果排序，一个Doc包含关键词越多，排名越前。如相等，则比较出现总次数  \\这个规则可以自定义
        docTemps.sort(new Comparator<DocTemp>() {
            @Override
            public int compare(DocTemp o1, DocTemp o2) {
                if(o1.times.equals(o2.times)){
                    return o2.allTimes - o1.times;
                }
                return o2.times-o1.times;
            }
        });

        //包装结果
        for (int i = 0; i < docTemps.size(); i++) {
            result.add(store.get(docTemps.get(i).docId));
        }

        return result;
    }

    public static void main(String[] args) {
        List<String> docs = new ArrayList<String>();
        //docId = 0
        String doc = "Inverted index comes from the actual application, it needs to find the record according to the value of the attribute.";
        docs.add(doc);
        //docId = 1
        doc = "Each item Each in the index table includes an attribute value and the address of each record with the attribute value";
        docs.add(doc);
        //docId = 2
        doc = "Attribute values are not determined by records";
        docs.add(doc);
        //docId = 3
        doc = "Rather, the location of the record is determined by the attribute value";
        docs.add(doc);
        //docId = 4
        doc = "It is called inverted index";
        docs.add(doc);
        //docId = 5
        doc = "The data operation is simple: the data used by the search engine is easy to operate, generally speaking, only need to add, delete, change, check several functions";
        docs.add(doc);
        //docId = 6
        doc = "And data has a specific format, you can design simple and efficient applications for these applications";
        docs.add(doc);
        //建立索引
        InvertedIndex invertedIndex = new InvertedIndex(docs);

        //查看倒排索引表
        System.out.println("关键词 出现doc[次数],{位置}");
        for (String key : invertedIndex.keywordsIndexTableMap.keySet()) {
            System.out.print(key + " ");
            IndexTable indexTable = invertedIndex.keywordsIndexTableMap.get(key);
            for (Integer integer : indexTable.docTimes.keySet()) {
                System.out.print(integer + "[" + indexTable.docTimes.get(integer) + "],");
                System.out.print("{" + indexTable.docIndex.get(integer) + "} ");
            }
            System.out.println("");
        }


        //执行查询
        List<String> results = invertedIndex.search("specific format location determined attribute");

        System.out.println("=========== 查询结果 ==========");
        for (String result : results) {
            System.out.println(result);
        }
    }
}

/**
 * 倒排索引表
 */
class IndexTable{
    /**
     * 关键词
     */
    String keywords;

    /**
     * 出现频率
     */
    Map<Integer, Integer> docTimes = new HashMap<Integer, Integer>();

    /**
     * 出现位置
     */
    Map<Integer, String> docIndex = new HashMap<Integer, String>();
}

/**
 * 用于排序
 */
class DocTemp {
    Integer docId;
    Integer times;  //出现在多少Doc中
    Integer allTimes;  //出现总次数
}
