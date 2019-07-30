import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.topology.TopologyBuilder;

import java.util.logging.Logger;

public class HelloWorldTopoloogy   {

    private static Logger toLog = Logger.getLogger(HelloWorldTopoloogy.class.getName());
    public static void main(String[] args) {

        toLog.info("Creating a topology builder");
        TopologyBuilder builder = new TopologyBuilder();

        //Set Soput & Bolts
        toLog.info("Setting up Spouts & Bolts in Topology Builder");
        builder.setSpout("IntegerSpout",new IntegerSpout());
        builder.setBolt("IntegerBolt",new IntegerBolt()).shuffleGrouping("IntegerSpout");

        //Create empty Config
        Config conf = new Config();
        conf.setDebug(true);



        //Create a local cluster & submit topology
        LocalCluster localCluster = new LocalCluster();

            localCluster.submitTopology("Hello-First-Topology", conf, builder.createTopology());
            //Thread.sleep(1000);

          localCluster.shutdown();


    }
}
