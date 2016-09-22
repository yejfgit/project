package com.tools.gen.extdto;


/**
 * 扩展的属性和值比对
 * @author zhengliexin 2011-12-28
 *
 */
public class ExtDTOPropertyAndType {
	
	private final static String S = "String";
	private final static String I = "Integer";
	private final static String L = "Long";
	private final static String D = "Double";
	private final static String B = "byte[]";
	private final static String BOOLEAN = "boolean";

	static Object[][] View_bq_yzzxmx_singleExtDTO = {
			
			{"View_bq_yzzxmx_singleExtDTO" , "View_bq_yzzxmx_singleDTO",""}, // 要生成的扩展DTO名称  ：要继承的对象的DTO名称
			
			{S,"stringTest",""},	                                          //  类型      ： 属性名  : 注释
			{L,"longTest",""}
	};
	//病人挂号存储过程实体ExtDto生成
	static Object[][] SPSFBRGHEXTDTO = {
		
		{"SpsfbrghprdExtDTO" , "",""}, // 要生成的扩展DTO名称  ：要继承的对象的DTO名称
		
		{S, "brblh0","门诊病历号"},
	    {S, "ybghh0","医保程序生成的挂号流水号,默认值为0"},
	    {S, "ghlbmc","挂号类别名称"},
	    {L, "brid00","病人ID号,若=0,说明是现金病人"},
	    {S, "sfcz00","是否初诊,'0':初诊病人,'1':复诊病人"},
	    {S, "xm0000","姓名"},
	    {S, "xb0000","性别"},
	    {S, "csrq00","出生日期"},
	    {S, "fbmc00","病人费别"},
	    {S, "gfzh00","公费证号,Add at GZ, on 2002-12-28"},
	    {S, "brdh00","电话,Add at GZ,on 2002-12-31"},
	    {S, "brhyzk","婚姻状况,Add at GZ, on 2002-12-31"},
	    {S, "ghy000","挂号员编号、或操作员编号"},
	    {S, "ghyxm0","挂号员姓名"},
	    {L, "czyks0","操作员的科室,或挂号员的科室"},
	    {L, "ghks00","挂号科室编号"},
	    {L, "jzys00","就诊医生编号"},
	    {S, "jzysxm","就诊医生姓名"},
	    {L, "ghhbid","挂号号表流水号"},
	    {S, "yjjxh0","打印在挂号单的外部序列号"},
	    {S, "fpxh00","打印在发票上的序号"},
	    {L, "ghf000","挂号费总金额(挂号费+挂号附加费)+病历工本费(若在窗体有打勾收病历费)"},
	    {L, "grzhzf","医保个人医疗账户支付"},
	    {L, "tcjjzf","医保统筹基金支付"},
	    {L, "zfje00","医保自付金额,若是现金病人，与挂号费总金额相同"},
	    {S, "zpzh00","对应的医保中心的编号"},
	    {S, "ybid00","病人医疗保险号(医保Id),非医保病人='0'"},
	    {S, "ybkh00","病人医保卡号"},
	    {S, "ghrq00","挂号日期,只是在预约挂号时使用"},
	    {S, "sfyygh","是否预约挂号,'Y':预约挂号,'N':正常挂号"},
	    {S, "czbz00","挂号标志,'0':持卡病人,'1':现金病人"},
	    {S, "sfsblf","是否收取病人的病历费,'Y':收病历费,'N':不收病历费"},
	    {S, "brzy00","职业(考虑现金病人时,这些信息的填写)"},
	    {S, "brmz00","民族"},
	    {S, "brzjlx","证件类型"},
	    {S, "brzjbh","证件编号"},
	    {S, "tydwmc","单位名称"},
	    {S, "sfnlyd","老年优待,Add at GuangZhou on 2002-11-25"},
	    {S, "hzlb00","优先级别,Add at GuangZhou on 2002-11-25"},
	    {S, "ickh00","就诊卡号,若没有卡号(='0'),现金病人挂号时,同时分配卡号 ,Add at GuangZhou  on 2002-12-28"},
	    {S, "brjtdz","家庭地址/通信地址"},
	    {L, "fjjzdh","除了挂号费外的附加费的结算单号(供医保接口使用) --NEW!"},
	    {L, "zfdjh0","自费金额对应的单据号"},
	    {L, "tjdjh0","医保的统筹基金对应的单据号"},
	    {L, "grdjh0","医保的个人账户对应的单据号"},
	    {L, "sbzhdh","商保个人帐户单据流水号"},
	    {L, "sbtjdh","商保统筹基金单据流水号"},
	    {S, "ghh000","门诊挂号号,供前台程序打印挂号单时使用"},
	    {S, "yhmsg0","存储过程提示的中文错误信息"},
	    {S, "sysmsg","系统提示的错误信息"},
	    {S, "jzsj00","计划就诊时间"},
	    {S, "ghxzqk","挂号限制情况 'Y':预约挂号即广东的那种情况,'N':正常挂号 'Z' :预约转正式挂号"},
	    {L, "ybzhye","医保账户余额"},
	    {S, "sfhsgh","是否护士站挂号(医技系统挂号员和结诊医生不同时也采用这种方式) 默认为N"},
	    {L, "jjdjh0","保健基金单据号"},
	    {S, "ghsjd0","预约时间段"},
	    {L, "hzxh00","候诊时间"},
	    {S, "zsqgff","是否只收取挂号费"}
   };
	
	static Object[][] View_tzmb_with_fl_mx_lbExtDTO = {
		
		{"View_tzmb_with_fl_mx_lbExtDTO" , "View_tzmb_with_fl_mx_lbDTO"},
		
		{S,"BQ_TZMBMX_TW","体温0"},
		{S,"BQ_TZMBMX_JWHTW","降温后体温20"},
		{S,"BQ_TZMBMX_MB","脉搏1"},
		{S,"BQ_TZMBMX_HX","呼吸2"},
		{S,"BQ_TZMBMX_XL","心率14"},
		{S,"BQ_TZMBMX_XY","血压16"},
		{S,"BQ_TZMBMX_TZ","体重9"},
		{S,"BQ_TZMBMX_DB","大便3"},
		{S,"BQ_TZMBMX_SG","身高10"},
		{S,"BQ_TZMBMX_XB","小便4"},
		{S,"BQ_TZMBMX_RSL","入水量6"},
		{S,"BQ_TZMBMX_QTPCW","其它排出物5"},
		{S,"BQ_TZMBMX_SRYL","输入液量21"},
		{S,"BQ_TZMBMX_SZ","神志17"},
		{S,"BQ_TZMBMX_SZY","舒张压7"},
		{S,"BQ_TZMBMX_SSY","收缩压8"},
		{S,"BQ_TZMBMX_SS","巡视18"},
		{S,"BQ_TZMBMX_FS","翻身19"},
		{S,"BQ_TZMBMX_YWGM","药物过敏11"},
		{S,"BQ_TZMBMX_BQJHLCS","病情及护理措施e29fd257"},
	};
	
	
	static Object[][] View_yw_bmbm_zlzdExtDTO = {
		
		{"View_yw_bmbm_zlzdExtDTO" , "View_yw_bmbm_zlzdDTO"},
		
		{BOOLEAN,"isExecuted","是否执行 true:已执行 false 未执行"},
	};
	
	static Object[][] Vw_ys_ywmxxmExtDTO = {
		
		{"Vw_ys_ywmxxmExtDTO" , "Vw_ys_ywmxxmDTO"},
		
		{S,"gdxmbz",""},
		{S,"jgms00",""},
		{S,"jgdw00",""},
		{S,"ckz000",""},
		{L,"yjdjh0",""},
	};
	
	
	static Object[][]  Vw_yj_yw0000_wzxExtDTO = {
		
		{"Vw_yj_yw0000_wzxExtDTO" , "Vw_yj_yw0000_wzxDTO"},
		
		{S,"kdrq01","日期开始"},
		{S,"kdrq02","日期结束"},
	};
	
	static Object[][]  Bm_hzlb00ExtDTO = {
		
		{"Bm_hzlb00ExtDTO" , "Bm_hzlb00DTO"},
		
		{L,"total","统计"},
	};
	
	static Object[][]  Vw_ys_hzbr00ExtDTO = {
		
		{"Vw_ys_hzbr00ExtDTO" , "Vw_ys_hzbr00DTO"},
		
		{I,"rownum","序号"},
	};
	
	
	static Object[][]  Vw_yy_bryyxxcx_gdExtDTO = {
		
		{"Vw_yy_bryyxxcx_gdExtDTO" , "Vw_yy_bryyxxcx_gdDTO"},
		
		{S,"yysdmc",""},
		{S,"sl0000",""},
	};
	
	
	static Object[][]  Sp_Ys_hzdlwhExtDTO = {
		
		{"Sp_Ys_hzdlwhExtDTO" , ""},
		
		{L,"psoid00","源ID0000"},
		{L,"pdeid00","目标ID0000"},
		{L,"pczy000","操作员id号"},
		{S,"pzxjg00","执行结果提示"},
		{L,"pzxbz00","传出参数说明"},
		{L,"pcommit","是否提交"},
	};
	
	static Object[][]  ChargeStatisticsExtDTO = {
		
		{"ChargeStatisticsExtDTO" , ""},
		
		{L,"sfxmid",""},
		{S,"xmmc00",""},
		{D,"je0000",""},
		{L,"sl0000",""},
	}; 
	
	
	static Object[][]  SP_SF_YJGZ00_YJD000ExtDTO = {
		
		{"SP_SF_YJGZ00_YJD000ExtDTO" , ""},
		
		{L,"ad_CXDJH0","被冲销的医技单据号"},
		{I,"ad_CZY000","操作员"},
		{S,"as_CZYXM0","操作员姓名"},
		{I,"ad_CZYKS0","操作员所在科室名称"},
		{S,"as_SHRXM0","审核人"},
		{S,"as_SHRYY0","审核原因"},
		{S,"as_YHMSG0","存储过程提示的错误信息"},
		{S,"as_SYSMSG","系统提示的错误信息"},
	}; 
	
}
