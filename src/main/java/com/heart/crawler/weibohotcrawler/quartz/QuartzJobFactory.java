package com.heart.crawler.weibohotcrawler.quartz;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

/**
 * @ClassName: QuartzJobFactory
 * @Description: 创建job实例工厂，解决spring注入问题。如果不进行配置，使用默认配置的话，会导致spring的@Autowired无法注入bean
 * @Author: jayhe
 * @Date: 2019/9/18 14:10
 * @Version: v1.0
 */
@Component
public class QuartzJobFactory extends AdaptableJobFactory {

    @Autowired
    private AutowireCapableBeanFactory autowireCapableBeanFactory;

    @Override
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
        //调用父类的方法，创建job实例
        Object jobInstance = super.createJobInstance(bundle);
        //进行注入
        autowireCapableBeanFactory.autowireBean(jobInstance);
        return jobInstance;
    }
}
