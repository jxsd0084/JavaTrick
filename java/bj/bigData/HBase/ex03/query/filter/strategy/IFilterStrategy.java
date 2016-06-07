package bj.bigData.HBase.ex03.query.filter.strategy;

import java.io.Serializable;


public interface IFilterStrategy extends Serializable {

	public boolean check( String value );
}
