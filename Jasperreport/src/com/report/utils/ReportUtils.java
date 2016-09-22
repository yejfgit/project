package com.report.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRBand;
import net.sf.jasperreports.engine.JRChild;
import net.sf.jasperreports.engine.JRElement;
import net.sf.jasperreports.engine.JRQuery;
import net.sf.jasperreports.engine.JRStaticText;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.base.JRBaseBand;
import net.sf.jasperreports.engine.design.JRDesignBand;
import net.sf.jasperreports.engine.design.JRDesignElement;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;

public class ReportUtils {
	
	/**
	 * 动态修改quuery'
	 * @param jdesign
	 * @param filterColArray
	 * @param filterConArray
	 * @param filterConValTypeArray
	 * @param filterConValArray
	 * @param relationshipArray
	 * @return
	 */
	public static JasperDesign modifyQuery(JasperDesign jdesign,String[] filterColArray,
			String[] filterConArray,String[] filterConValTypeArray,String[] filterConValArray,String[] relationshipArray){
		
		if(filterColArray==null||filterColArray.length==0){
			return null;
		}
				
		JRQuery jRQuery= jdesign.getQuery();
		
		String sql =jRQuery.getText();
		String[] str = sql.split("from");

		String modifySql = str[0]+"from" +"(" +sql+")"+" where 1=1 ";
		
		String modifySqlWhere ="";
		for(int i=0;i<filterColArray.length;i++){
			if(filterColArray[i]!=null&&!"".equals(filterColArray[i])){
				String  filterCol= filterColArray[i].toUpperCase();
				modifySqlWhere = "and "+ filterCol +filterConArray[i];
				if(filterConValTypeArray[i]!=null&& "char".equals(filterConValTypeArray[i])){
					modifySqlWhere = modifySqlWhere +"'"+filterConValArray[i]+"'";
				}		
				if(filterConValTypeArray[i]!=null&& "number".equals(filterConValTypeArray[i])){
					modifySqlWhere = modifySqlWhere +filterConValArray[i];
				}	
				if(filterConValTypeArray[i]!=null&& "Date".equals(filterConValTypeArray[i])){
					modifySqlWhere = modifySqlWhere +filterConValArray[i];
				}	
						
				if(relationshipArray[i] != null && "".equals(relationshipArray[i])){
					modifySqlWhere =modifySqlWhere+relationshipArray[i];				
				}
			}
		}
		
		modifySql = modifySql+modifySqlWhere;
		JRDesignQuery jRDesignQuery =new  JRDesignQuery();
		 		 
		jRDesignQuery.setText(modifySql);
		 		 						// jRQuery2
		jdesign.setQuery(jRDesignQuery);
						
		return jdesign;
		
	}
	 /**
     * 除去jrxml模板中不要显示列
     * 
     * @param jdesign
     * @param params
     * @return
     */
    public static JasperReport dynamiccolumn(JasperReport jdesign, Map params) {  
      
    	Collection dynamiccolumns = (Collection) params.get("dynamiccolumn");  
        if (dynamiccolumns != null) {  
            JRDesignBand cHeader = (JRDesignBand) jdesign.getColumnHeader();  
            JRBand cDetailBand = jdesign.getDetailSection().getBands()[0];  
            JRDesignBand cDetail = null;  
            if (cDetailBand != null && cDetailBand instanceof JRDesignBand) {  
                cDetail = (JRDesignBand) cDetailBand;  
            }  
            JRElement[] es_header = cHeader.getElements();  
           // cHeader.getElementByKey("ypbm00").g
            JRElement[] es_detail = cDetail.getElements();  
            for (int i = 0; i < es_header.length; i++) {  
                JRDesignElement e = (JRDesignElement) es_header[i];  
                String v = "";  
                /*String s ="";
                String id ="";*/
                if (e instanceof JRStaticText) {  
                    JRStaticText text = (JRStaticText) e;                                      
                   // v = text.getText();  
                     //s=((JRStaticText) e).getFontName();
                    v =  text.getKey();
                    if(v != null){
                    	v=v.toLowerCase();
                    }	                    		                     
                     //s= text.getFontName();
                   // [ypbm00,ypmc00,ypgg00,kcsl00,kcsx00,kcxx00] 
                } 
                if ((!"".equals(v))&&v!=null&&(!dynamiccolumns.contains(v))) { 
               // if (!dynamiccolumns.contains(v)) { 
                    for (int j = 0; j < es_detail.length; j++) {  
                        JRDesignElement ee = (JRDesignElement) es_detail[j];  
                       /* System.out.println(ee.getY());
                        System.out.println(ee.getX());*/
                      /*  if (ee.getY() == e.getY()) {  
                            cDetail.removeElement(ee);  
                        }  */
                        if (ee.getX() == e.getX()) {  
                            cDetail.removeElement(ee);  
                        }
                       //System.out.println("ee.getX():"+ee.getX());
                       // System.out.println("e.getX():"+e.getX());
                    }  
                    cHeader.removeElement(e);  
                }  
            }  
        }  
                                
        return jdesign;  
    }

    /**
     * 除去jrxml模板中不要显示列
     * 
     * @param jdesign
     * @param params
     * @return
     */
    public static JasperDesign dynamiccolumn(JasperDesign jdesign, Map params) {  
      
    	Collection dynamiccolumns = (Collection) params.get("dynamiccolumn");  
        if (dynamiccolumns != null) {  
            JRDesignBand cHeader = (JRDesignBand) jdesign.getColumnHeader();  
            JRBand cDetailBand = jdesign.getDetailSection().getBands()[0];  
            JRDesignBand cDetail = null;  
            if (cDetailBand != null && cDetailBand instanceof JRDesignBand) {  
                cDetail = (JRDesignBand) cDetailBand;  
            }  
            JRElement[] es_header = cHeader.getElements();  
           // cHeader.getElementByKey("ypbm00").g
            JRElement[] es_detail = cDetail.getElements();  
            for (int i = 0; i < es_header.length; i++) {  
                JRDesignElement e = (JRDesignElement) es_header[i];  
                String v = "";  
                /*String s ="";
                String id ="";*/
                if (e instanceof JRStaticText) {  
                    JRStaticText text = (JRStaticText) e;                                      
                   // v = text.getText();  
                     //s=((JRStaticText) e).getFontName();
                    v =  text.getKey();
                    if(v != null){
                    	v=v.toLowerCase();
                    }	                    		                     
                     //s= text.getFontName();
                   // [ypbm00,ypmc00,ypgg00,kcsl00,kcsx00,kcxx00] 
                } 
                if ((!"".equals(v))&&v!=null&&(!dynamiccolumns.contains(v))) { 
               // if (!dynamiccolumns.contains(v)) { 
                    for (int j = 0; j < es_detail.length; j++) {  
                        JRDesignElement ee = (JRDesignElement) es_detail[j];  
                       /* System.out.println(ee.getY());
                        System.out.println(ee.getX());*/
                      /*  if (ee.getY() == e.getY()) {  
                            cDetail.removeElement(ee);  
                        }  */
                        if (ee.getX() == e.getX()) {  
                            cDetail.removeElement(ee);  
                        }
                       //System.out.println("ee.getX():"+ee.getX());
                       // System.out.println("e.getX():"+e.getX());
                    }  
                    cHeader.removeElement(e);  
                }  
            }  
        }  
                                
        return jdesign;  
    }
    
    
   

    
    /**
     * 	修改后的jJasper进行格式整理
     * @param jdesign
     * @return
     */
    public static JasperDesign setStyle(JasperDesign jdesign){
    	  JRDesignBand cHeader = (JRDesignBand) jdesign.getColumnHeader();
          JRBand cDetailBand = jdesign.getDetailSection().getBands()[0];  
          JRDesignBand cDetail = null;  
          if (cDetailBand != null && cDetailBand instanceof JRDesignBand) {  
              cDetail = (JRDesignBand) cDetailBand;  
          }  
    	
          JRElement[] es_header = cHeader.getElements();  
          JRElement[] es_detail = cDetail.getElements(); 
          int columnWidth=jdesign.getPageWidth();
          //int columnWidth =jdesign.getColumnWidth();
          
          int num =es_header.length;
          
          int avgWidth1 = columnWidth/num;
          int avgWidth2 =  columnWidth%num;
          int avgWidth = avgWidth1 +avgWidth2/num;
          
          int xWidth=0;
          
          for (int i = 0; i < es_header.length; i++) {          	  
        	    JRDesignElement e = (JRDesignElement) es_header[i];
        	    JRDesignElement ee = (JRDesignElement) es_detail[i];
        	    e.setX(xWidth);
        	    e.setWidth(avgWidth);
        	    ee.setX(xWidth);
        	    ee.setWidth(avgWidth);
        	    //e.setX(1);        	    
        	    xWidth = xWidth+avgWidth;        	              
          }     
          
          return jdesign;
    	
    }
    
    
	/**
	 * 动态修改JasperReport
	 * @param jdesign
	 * @param filterColArray
	 * @param filterConArray
	 * @param filterConValTypeArray
	 * @param filterConValArray
	 * @param relationshipArray
	 * @return
	 */
	public static String modifyQueryJasperString(JasperReport jasperReport,String[] filterColArray,
			String[] filterConArray,String[] filterConValTypeArray,String[] filterConValArray,String[] relationshipArray){
		
		//if(filterColArray==null||filterColArray.length==0){
		//	return  " and 1=1 ";
		//}
		JRQuery jRQuery= jasperReport.getQuery();
		String sql =jRQuery.getText();
		sql = sql.toUpperCase();
		//String modifySql =" 1=1 ";
		String modifySqlWhere ="";
		
		//sql.indexOf(WHERE);
		if(sql.split("WHERE").length>1){
			modifySqlWhere = " and 1=1 ";
															
		}else{			
			modifySqlWhere = " WHERE 1=1 ";
		}	
		if(filterColArray!=null&&filterColArray.length>0){
			for(int i=0;i<filterColArray.length;i++){
				if(filterColArray[i]!=null&&!"".equals(filterColArray[i])){
					String  filterCol= filterColArray[i].toUpperCase();
					//只有第一个条件前面才自动加AND 后面的不加
					if(i==0){
						modifySqlWhere = modifySqlWhere + " and "+ filterCol +" " +filterConArray[i];
					}else{
						modifySqlWhere = modifySqlWhere + filterCol +" " +filterConArray[i];
					}
					if(filterConValTypeArray[i]!=null&& "char".equals(filterConValTypeArray[i])){
						String con =filterConValArray[i];
						if(con!=null&&"IN".equals(filterConArray[i].toUpperCase())){											
							modifySqlWhere = modifySqlWhere +dealSqlIn(con,"char");
						}else{
							modifySqlWhere = modifySqlWhere +" '"+filterConValArray[i]+"' ";
						}
					}		
					if(filterConValTypeArray[i]!=null&& "number".equals(filterConValTypeArray[i])){
						String con =filterConValArray[i];
						if(con!=null&&"IN".equals(filterConArray[i].toUpperCase())){
													
							modifySqlWhere = modifySqlWhere +dealSqlIn(con,"number");
						}else{
							modifySqlWhere = modifySqlWhere +filterConValArray[i];
						}
					}	
					if(filterConValTypeArray[i]!=null&& "Date".equals(filterConValTypeArray[i])){
						modifySqlWhere = modifySqlWhere +filterConValArray[i];
					}	
					//排除掉最后一个没有加AND的情况		
					if(null!=relationshipArray&&i<relationshipArray.length &&relationshipArray[i] != null &&! "".equals(relationshipArray[i])){
						modifySqlWhere =modifySqlWhere+relationshipArray[i]+" ";				
					}
				}
			}
		}
		
		System.out.println("modifySqlWhere:"+modifySqlWhere);
		return modifySqlWhere;
												
	}
	 /**
     * 处理sql中有IN条件的
     * 
     * @param jdesign
     * @param params
     * @return
     */
    public static String dealSqlIn(String inVal,String type) {  
    	//去处理in的字符串
		String[] rckdhArry =inVal.split("\\?");
		String rckdh0Str ="(";
		for(int j=0;j<rckdhArry.length;j++){	
			if("char".equals(type)){
				if(j<rckdhArry.length-1){
					rckdh0Str = rckdh0Str+"'"+rckdhArry[j]+"',";					
				}else{
					rckdh0Str = rckdh0Str+"'"+rckdhArry[j]+"'";
				}	
			}else if("number".equals(type)){
				rckdh0Str =inVal;				
			}			
		}
		rckdh0Str = rckdh0Str+")";
	    return rckdh0Str;
    	
    }
    	
    	

    /**
     * 除去Jasper模板中不要显示列
     * 
     * @param jdesign
     * @param params
     * @return
     */
    public static JasperReport dynamiccolumnJasper(JasperReport jasperReport, String[] dataIndexArray) {  
    	
    	Collection dynamiccolumns= Arrays.asList(dataIndexArray);
      
    	//Collection dynamiccolumns = (Collection) params.get("dynamiccolumn");  
        if (dynamiccolumns != null) {          
        	JRBaseBand cHeader = (JRBaseBand) jasperReport.getColumnHeader();         	           
            JRBand cDetailBand = jasperReport.getDetailSection().getBands()[0];  
                                                                   
            List<JRChild> es_header = cHeader.getChildren();
            List<JRChild> es_detail = cDetailBand.getChildren();
            //没有删除的列返回
            /*if( es_header.size()==dynamiccolumns.size()){
            	return jasperReport;
            }*/
            //System.out.println("es_header.size():"+es_header.size()+"dynamiccolumns.size():"+dynamiccolumns.size());
            
            
            for(int i = 0; i < es_header.size(); i++){
            	//System.out.println("es_header.size():"+es_header.size());
            	          	           	
            	JRChild e = (JRChild) es_header.get(i);  
            	if (e instanceof JRStaticText) {              		
            		String v = "";                 	
                    JRStaticText hearderCol = (JRStaticText) e;                   
                    v =  hearderCol.getKey();
                    if(v != null){
                    	v=v.toLowerCase();
                    }	
                    
                    if ((!"".equals(v))&&v!=null&&(dynamiccolumns.contains(v))) {   
                    	//System.out.println("v!!!!!!!!!!!!:"+v);
                    	//;
                    	es_detail.remove(cDetailBand.getElementByKey(v.toUpperCase()));
                            /* for (int j = 0; j < es_detail.size(); j++) {  
                            	 JRChild ee = (JRChild) es_detail.get(j);  
                            	 if(ee instanceof JRElement){                           		
                            		 JRElement dtailField = (JRElement)ee;                              
                            		 if (dtailField.getX() == hearderCol.getX()) {  
                            			 System.out.println("111:"+dtailField.getX());
                            			 System.out.println("222:"+hearderCol.getX());
                            			  if( dtailField.getKey()==hearderCol.getKey()){
	                                	 es_detail.remove(ee);
	                                	 
	                                 }
                            		 if(dtailField.getKey().equals(hearderCol.getKey())){
                            			 es_detail
                            		 }                           		                            		                               	 
                            	 }                             
                             }  */
                            // es_header.removeElement(e);                      			
                             es_header.remove(e);
                             i=i-1;
                            // cHeader
                       }  
                              	           		           		
            	}
            	
                }            	            	            	           	           	
            }                                                                          
        return jasperReport;  
    }
    
    
   

    
    /**
     * 	修改后的Jasper进行格式整理
     * @param jdesign
     * @return
     */
    public static JasperReport setStyleJasper(JasperReport jasperReport, String[] array){
    	
        	
    	  JRBaseBand cHeader = (JRBaseBand) jasperReport.getColumnHeader();         	           
          JRBand cDetail= jasperReport.getDetailSection().getBands()[0];  
    	
    	 /* JRDesignBand cHeader = (JRDesignBand) jdesign.getColumnHeader();
          JRBand cDetailBand = jdesign.getDetailSection().getBands()[0];  
          JRDesignBand cDetail = null;  
          if (cDetailBand != null && cDetailBand instanceof JRDesignBand) {  
              cDetail = (JRDesignBand) cDetailBand;  
          }  */
          
         
    	
          JRElement[] es_header = cHeader.getElements();  
          //没有删除列表的
          /*if(array.length ==es_header.length){
        	  return jasperReport;
          }       */            
          JRElement[] es_detail = cDetail.getElements(); 
          int columnWidth=jasperReport.getPageWidth();
          //int columnWidth =jdesign.getColumnWidth();
         // es_header
          
          
          int num =es_header.length;
          
          int avgWidth1 = columnWidth/num;
          int avgWidth2 =  columnWidth%num;
          int avgWidth = avgWidth1 +avgWidth2/num;
          
          int xWidth=0;
          
          for (int i = 0; i < es_header.length; i++) {          	  
        	    JRElement e = (JRElement) es_header[i];
        	    JRElement ee = (JRElement) es_detail[i];
        	    e.setX(xWidth);
        	    e.setWidth(avgWidth);
        	    ee.setX(xWidth);
        	    ee.setWidth(avgWidth);
        	    //e.setX(1);        	    
        	    xWidth = xWidth+avgWidth;        	              
          }     
          
          return jasperReport;
    	
    }
    
  
 /**
  * 得到str的第一个数组
 * @param str
 * @return
 */
public static String[] getStringArr(String[] str){
	
		if(str.length==0){
			return null;
		}
		String[] stringArray =null;	 
    	String strAr = str[0];
    	if(strAr!=null&&!"".equals(strAr)){
    		 stringArray = strAr.split(",");    
    	}
    	
    	return stringArray;
    	
    	
    } 
 /**
  * 将key和value数组一对对放入到map中
 * @param map
 * @param key
 * @param value
 * @return
 * @throws UnsupportedEncodingException 
 */
public static Map putValueInParamsMap(Map map,String[] key,String[] value) throws UnsupportedEncodingException{
	 
	 if(key!=null&&value!=null&& key.length>0&&key.length ==value.length){
		 for(int i=0;i<key.length;i++){
			//String str= key[i].toUpperCase();
			 String str= key[i].toString();
			//String valueS =URLDecoder.decode(value[i], "UTF-8");
			 map.put(str, value[i]);
		 }		 		 
	 }
	 return map;
 }
 public static boolean stringNoValue(String s){
	 
	 if(s==null||"".isEmpty()){
		 return true;
	 }
	 return false;		 		 
	 }
	 
public static boolean listNoValue(List list){
	 
	 if(list==null||list.size()==0){
		 return true;
	 }
	 return false;		 		 
	 }	 
	 
 

}
