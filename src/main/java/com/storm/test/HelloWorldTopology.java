package com.storm.test;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.StormSubmitter;
import org.apache.storm.generated.AlreadyAliveException;
import org.apache.storm.generated.AuthorizationException;
import org.apache.storm.generated.InvalidTopologyException;
import org.apache.storm.topology.TopologyBuilder;
import org.apache.storm.utils.Utils;

/**
 * Created by liubo16 on 2017/3/15.
 */
public class HelloWorldTopology {
    public static void main(String[] args) throws InvalidTopologyException, AuthorizationException, AlreadyAliveException {
        TopologyBuilder topologyBuilder = new TopologyBuilder();
        topologyBuilder.setSpout("randomHelloWorld",new HelloWorldSpout(),10);
        topologyBuilder.setBolt("HelloWorldBolt",new HelloWorldBolt(),1).shuffleGrouping("randomHelloWorld");
        Config config = new Config();
        config.setDebug(true);
        if (args != null && args.length>0) {
            StormSubmitter.submitTopology(args[0],config,topologyBuilder.createTopology());
        }else {
            LocalCluster localCluster = new LocalCluster();
            localCluster.submitTopology("test",config,topologyBuilder.createTopology());
            Utils.sleep(1000);
            localCluster.killTopology("test");
            localCluster.shutdown();
        }
    }
}
