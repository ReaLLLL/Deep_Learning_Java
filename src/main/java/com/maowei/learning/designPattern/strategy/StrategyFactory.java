package com.maowei.learning.designPattern.strategy;

import java.io.File;
import java.io.FileFilter;
import java.lang.annotation.Annotation;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class StrategyFactory {

    private static final String STRATEGY_PACKAGE = "com.maowei.learning.designPattern.strategy.impl";
    private ClassLoader classLoader = getClass().getClassLoader();
    private List<Class<? extends DiscountStrategy>> strategies;

    public DiscountStrategy getStrategy(Consumer consumer){
        for(Class<? extends DiscountStrategy> clazz : this.strategies){
            PriceRegion region = this.handleAnnotation(clazz);
            if(consumer.getTotalAmount().compareTo(new BigDecimal(region.min())) > -1
                    && consumer.getTotalAmount().compareTo(new BigDecimal(region.max()))<1){
                try {
                    return clazz.newInstance();
                }catch (Exception e){
                    throw new RuntimeException("策略获得失败");
                }
            }
        }
        return null;
    }

    private PriceRegion handleAnnotation(Class<? extends DiscountStrategy> clazz){
        Annotation[] annotations = clazz.getDeclaredAnnotations();
        if(annotations == null || annotations.length == 0)
            return null;

        for(int i = 0; i< annotations.length;i++){
            if(annotations[i] instanceof PriceRegion)
                return (PriceRegion)annotations[i];
        }
        return null;
    }

    private StrategyFactory(){
        init();
    }

    private void init(){
        this.strategies = new ArrayList<Class<? extends DiscountStrategy>>();
        File[] resources = getResources();//获取到包下所有的class文件
        Class<DiscountStrategy> strategyClazz = null;
        try {
            strategyClazz = (Class<DiscountStrategy>) classLoader.loadClass(DiscountStrategy.class.getName());//使用相同的加载器加载策略接口
        } catch (ClassNotFoundException e1) {
            throw new RuntimeException("未找到策略接口");
        }
        for (int i = 0; i < resources.length; i++) {
            try {
                //载入包下的类
                Class<?> clazz = classLoader.loadClass(STRATEGY_PACKAGE + "." + resources[i].getName().replace(".class", ""));
                //判断是否是CalPrice的实现类并且不是CalPrice它本身，满足的话加入到策略列表
                if (DiscountStrategy.class.isAssignableFrom(clazz) && clazz != strategyClazz) {
                    this.strategies.add((Class<? extends DiscountStrategy>) clazz);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private File[] getResources() {
        try {
            File file = new File(classLoader.getResource(STRATEGY_PACKAGE.replace(".", "/")).toURI());
            return file.listFiles(new FileFilter() {
                public boolean accept(File pathname) {
                    if (pathname.getName().endsWith(".class")) {//我们只扫描class文件
                        return true;
                    }
                    return false;
                }
            });
        } catch (URISyntaxException e) {
            throw new RuntimeException("未找到策略资源");
        }
    }

    public static StrategyFactory getInstance() {
        return StrategyFactoryInstance.instance;
    }

    private static class StrategyFactoryInstance {

        private static StrategyFactory instance = new StrategyFactory();
    }

}
