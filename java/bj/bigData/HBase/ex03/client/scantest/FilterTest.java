package bj.bigData.HBase.ex03.client.scantest;

import com.boco.DataPlatform.hbase.common.constants.TableConstants;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.*;

import java.io.IOException;
import java.util.Iterator;

public class FilterTest {
	public static void main(String[] args) throws IOException {
		Configuration conf = HBaseConfiguration.create();
		conf.set("hbase.zookeeper.quorum", "10.0.7.216");
		conf.set("hbase.zookeeper.property.clientPort", "2181");
		
		HBaseAdmin admin = new HBaseAdmin(conf);
		System.out.println(admin.tableExists("TO_NET_ODS_ACCESSLOGS_2013072010"));
		
		int count = 0;
		try {
			HTable ht = new HTable(conf,"TO_NET_ODS_ACCESSLOGS_2013072010");
			Scan scan = new Scan();
			scan.addFamily(TableConstants.COMMON_COLUMN_FAMILY);
//			scan.setStartRow("000221272497102013072000320962161".getBytes());
//			scan.setStopRow("000221272497102013072090320962161".getBytes());
			
//			ValueFilter vf = new ValueFilter(CompareOp.EQUAL,);
//			scan.setFilter(filter)
			
			ResultScanner scnner = ht.getScanner(scan);
			Iterator<Result> it = scnner.iterator();
			while(it.hasNext()){
				Result rs = it.next();
				byte[] key = rs.getRow();
				byte[] c =rs.getValue(TableConstants.COMMON_COLUMN_FAMILY, "c".getBytes());
				byte[] d = rs.getValue(TableConstants.COMMON_COLUMN_FAMILY, "d".getBytes());
				
				System.out.println("key:"+new String(key));
				System.out.println("c:"+new String(c));
				System.out.println("d:"+new String(d));
				System.out.println("============================");
				if(count++>10){
					break;
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void query(){
		
		
		
		
	}

}
