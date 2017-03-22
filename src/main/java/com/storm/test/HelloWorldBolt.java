package com.storm.test;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Tuple;

import java.util.Map;

/**
 * Created by liubo16 on 2017/3/15.
 */
public class HelloWorldBolt extends BaseRichBolt {
    int myCount = 0;

    @Override
    public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {

    }

    @Override
    public void execute(Tuple input) {
        String sentence = input.getStringByField("sentence");
        if (sentence.equals("Hello world")){
            myCount++;
            System.out.println("Found a Hello World! My Count is now: " + Integer.toString(myCount));
        }
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {

    }
}
