namespace java com.boco.DataPlatform.hbase.query.thrift
namespace csharp com.boco.idcisp.hbase.query.thrift

struct ResultData {
  1:i32 count,
  2:list<string> metadata,
  3:list<list<string>> datas
}
struct Result {
  1:string session,
  2:i32 errorcode,
  3:string errormsg,
  4:ResultData datas
}
struct CommonCondition {
  1:i32 pageNo,
  2:i32 pageSize,
  3:i32 timeout
}
struct CountCondition {
  1:string table,
  2:map<string,string> attributes,
  3:i32 timeout
}
enum MatchType{
	EQUAL=1,
	LIKE=2,
	IPREGEX=3,
	IPRANGE=4
}
struct Filter {
  1:string field,
  2:MatchType matchType,
  3:string value
}
struct MainCondition {
  1:string starttime,
  2:string endtime,
  3:list<Filter> filters,
  4:map<string,string> attributes
}
service QueryService {

    Result count(1:CountCondition condition),
    Result queryAccessLog(1:CommonCondition commonCondition,2:MainCondition condition), 
    Result queryMonitorLog(1:CommonCondition commonCondition,2:MainCondition condition), 
    Result queryFilterLog(1:CommonCondition commonCondition,2:MainCondition condition), 
	Result queryMonitorIpInfo(1:CommonCondition commonCondition,2:MainCondition condition), 
	Result queryIllegalInfo(1:CommonCondition commonCondition,2:MainCondition condition), 
}