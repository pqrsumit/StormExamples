import org.apache.storm.topology.BasicOutputCollector;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseBasicBolt;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;

public class IntegerBolt extends BaseBasicBolt {

    public void execute(Tuple tuple, BasicOutputCollector basicOutputCollector) {
        Integer empID = tuple.getInteger(0);
        empID*=2;
        basicOutputCollector.emit(new Values(empID));
        System.out.println(empID);
    }

    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("EmployeeIdFrom-BaseBasicBolt"));

    }
}
