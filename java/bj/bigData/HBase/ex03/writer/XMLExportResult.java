package bj.bigData.HBase.ex03.writer;

import java.util.ArrayList;
import java.util.List;

public class XMLExportResult {

	private String commanId;
	private String idc_id;
	private boolean succeed = true;
	private List< String > metadata;
	private ArrayList< List< String > > datas = new ArrayList< List< String > >();
	
	public XMLExportResult() {
		
	}
	
	public XMLExportResult( String commanId, String idc_id ) {

		this.commanId = commanId;
		this.idc_id = idc_id;
	}

	public String getIdc_id() {

		return idc_id;
	}

	public void setIdc_id( String idc_id ) {

		this.idc_id = idc_id;
	}

	public XMLExportResult( String commanId, List< String > metadata, ArrayList< List< String > > datas ) {

		this.commanId = commanId;
		this.metadata = metadata;
		this.datas = datas;
	}

	public boolean isSucceed() {

		return succeed;
	}

	public void setSucceed( boolean succeed ) {

		this.succeed = succeed;
	}

	public int getSize() {

		return datas.size();
	}

	public List< String > getMetadata() {

		return metadata;
	}

	public void setMetadata( List< String > metadata ) {

		this.metadata = metadata;
	}

	public ArrayList< List< String > > getDatas() {

		return datas;
	}

	public void setDatas( ArrayList< List< String > > datas ) {

		this.datas = datas;
	}
	
	public void addData( List< String > data ) {

		datas.add( data );
	}
	
	public String getCommanId() {

		return commanId;
	}

	public void setCommanId( String commanId ) {

		this.commanId = commanId;
	}
}
