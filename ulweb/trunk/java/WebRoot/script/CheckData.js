/*
 * JavaScript 公用数据校验模块 for taiping project
 */

/*
函数清单：

1.检查输入参数是否全为数字
CheckNumber

2.检查输入参数是否为整数
CheckInteger

3.检查输入参数是否为浮点数
CheckFloat

3.检查输入参数是否为合法的指定整数部分长度和小数部分长度的浮点数(主要用于检查金额数值是否合法)
CheckAmountFloat(str, intleng, fltleng)

4.检查输入参数是否为合法的日期
CheckDate
CheckDate2

5.检查输入参数是否为合法的email地址
CheckEmail

6.检查输入参数是否为合法的身份证号码
CheckID

7.检查电话号码是否正确
CheckTelephone

8.检查密码，只能为字母或数字
CheckPassword

9.检查BP机号码
CheckBp

10.检查电话号码
CheckAreaPhone

11.检查是否全为字母
IsLetter

12.检查年龄
CheckAge

13.检查是否全为空格
AllSpace

14.检查日期在给定日期之后
DateIsLargerThanNow2

15.检查日期在当前日期之后
DateIsLargerThanNow

16.将日期转化为标准格式（ from yyyymmdd to yyyy-mm-dd)
Date2StandardFmt(date_string)

17.将form中，日期文本对象转化为标准格式（ from yyyymmdd to yyyy-mm-dd)
DateObj2StandardFmt(date_obj)

18. 从合法身份证取生日
GetBirthdayFromID(id_value)

19. 从合法身份证取性别
GetGenderFromID(id_value)

20. 检查是否为当日以前的合法日期
IsByPastDate(str1)

21。 检查会计期间的合法性

23.检查保单号输入是否合法
CheckPolicyCode(obj)

24 检查投保单号输入是否合法
CheckApplyCode(obj)

25 判断一个字符串是否以指定字符串开头
   startWith(str,start)

26 判断一个字符串是否以指定字符串结尾
   endWith(str,end)

27 取得去除顺序号后的号码
   系统中，带有顺序号的号码格式为xxxxxx-xx，其中-xx为顺序号
   本方法返回"-"之前的部分，如果不含有"-"，则返回原值本身；
   getPureCode(code)

28 检查是否是团单保单号码
   检查规则：去除顺序号后以088结尾即认为是团单保单号码，否则不是
   isGroupPolicyCode(code)

29 检查是否是团单投保单号码
   检查规则：去除顺序号后以050结尾即认为是团单投保单号码，否则不是
   iGroupvSendCode(code)

30 检查是否是符合规则的个单投保单号码
   isValidIndvSendCode(code)

31 检查是否是符合规则的团单投保单号码
   isValidGroupSendCode(code)

32 检查是否是符合规则的投保单号码
   code:投保单号码  suffix:投保单号码后缀（个单:001　团单:050）
   isValidSendCode(code,suffix)

32 检查并返回录入项的字符长度
   getStrLengthB(strItem)
   
33 检查、截取录入项的前后空格，并返回截取后的字符
   getStrTrim(strItem)   
   
34 屏蔽浏览器"BackSpace"

35 检查是否存在全角字符
   boolean IsSBC(obj)

36 邮编校验
   checkPostCode(obj)   
*/


// 1.检查输入参数是否全为数字
function CheckNumber(str){
    var rc=true;
    if (str+"" == "undefined" || str == null){
        rc=false;
    } else if(str.length==0){
	rc=false;
    } else {
	for(i=0;i<str.length;i++){
	    if(str.charAt(i)<'0' || str.charAt(i)>'9'){
	        rc=false;
	        break;
	    }
	}
    }
    return rc;
}
function checkNumber(str){
    return CheckNumber(str);
}

// 2.检查输入参数是否为整数
function CheckInteger(str){
    var rc=true;
    if (str+"" == "undefined" || str == null){
	rc=false;
    } else{
	for(i=0;i<str.length;i++){
          // if(i==0 && str.charAt(i)=='-'){
          //      alert("请输入正整数!");
          //  }
            if(str.charAt(i)<'0' || str.charAt(i)>'9'){
                rc=false;
                break;
            }
	}
    }
    return rc;
}
function checkInteger(str){
    return CheckInteger(str);
}


// 3.检查输入参数是否为浮点数
function CheckFloat(str){
    var rc=true;
    oneDecimal=false;
    if (str+"" == "undefined" || str == null){
	rc=false;
    } else{
	for(i=0;i<str.length;i++){
	    ch=str.charAt(i);
	    if(i==0 && ch=='-'){
		continue;
	    }
	    if(ch=="." && !oneDecimal){
		oneDecimal=true;
	        continue;
	    }
	    if ((ch< "0") || (ch >'9')){
	        rc=false;
	        break;
	    }
	}
    }
    return rc;
}
function checkFloat(str){
	return CheckFloat(str);
}

// 3.检查输入参数是否为合法的指定整数部分长度和小数部分长度的浮点数
function CheckAmountFloat(str, intleng, fltleng){
  if (CheckFloat(str)==false) {
   return false;
  }

  if(parseFloat(str)<0){ //?1??ooí
   if (str.length > intleng+fltleng+2) {
    return false;
   }
  }else{
   if (str.length > intleng+fltleng+1) {
    return false;
   }
  }


  var strArray = str.split(".");
  if (strArray.length > 2) {
   return false;
  }

  if(parseFloat(str)<0){ //?1??ooí
   if (strArray[0].length > intleng+1) {
    return false;
   }
  }else{
   if (strArray[0].length > intleng) {
    return false;
   }
  }

  if (strArray.length == 2) {
   if (strArray[1].length > fltleng) {
    return false;
   }
  }
  return true;
}

function checkAmountFloat(str, intleng, fltleng){
	return CheckAmountFloat(str, intleng, fltleng);
}

// 4.检查输入参数是否为合法的日期
// modified by rock, 2001-7
function CheckDate(year,month,day){
    if(!CheckNumber(year)){
        return false;
    }
    if(!CheckNumber(month)){
        return false;
    }
    if(!CheckNumber(day)){
        return false;
    }
//change by jason
//    var dat = new Date(year - 1900, month - 1, day);
    var dat = new Date(year, month - 1, day);
    if (dat.getMonth() == (month-1)) {
        return true;
    } else {
        return false;
    }
}
function checkDate(year,month,day){
    return CheckDate(year,month,day);
}
function CheckDate2(str1){
    if (str1 + "" == "undefined" || str1 == null){
        return false;
    }
    var y,m,d;
    var i;
    i = str1.indexOf("-");
    if (i == -1 || i == str1.length) { return false; }
    y = str1.substring(0, i);
    str1 = str1.substring(i + 1);

    i = str1.indexOf("-");
    if (i == -1 || i == str1.length) { return false; }
    m = str1.substring(0, i);

    d = str1.substring(i + 1);

    return CheckDate(y,m,d);
}
function checkDate2(str1) {
    return CheckDate2(str1);
}

// 5.检查输入参数是否为合法的email地址
function CheckEmail(str){
    var CHAR_LETTER_NUMERIC=1;
    var CHAR_UNDERLINE=2;
    var CHAR_DOT=3;
    var CHAR_AT=4;
    var CHAR_DIVIDE=5;
    var CHAR_END=6;
    var CHAR_OTHER=7;
    var DIV_CHAR=',';

    var rc=true;
    if (str+"" == "undefined" || str == null){
        rc=false;
        return rc;
    } else if(str.length==0){
        rc=true;
        return rc;
    }

    var exit_flag=false;
    var total_char=str.length;
    var pos=0;
    var cur_char;
    var cur_status=0;
    while((pos<=total_char) && (!exit_flag)){
        if(pos==total_char){
          cur_char=CHAR_END;
        }
        else if (str.charAt(pos)=='.'){
          cur_char=CHAR_DOT;
        }
        else if (str.charAt(pos)==DIV_CHAR){
          cur_char=CHAR_DIVIDE;
        }
        else if(str.charAt(pos)=='_'){
          cur_char=CHAR_UNDERLINE;
        }
        else if(str.charAt(pos)=='@'){
          cur_char=CHAR_AT;
        }
        else if(((str.charAt(pos)>='a')&&(str.charAt(pos)<='z'))||((str.charAt(pos)>='A')&&(str.charAt(pos)<='Z'))||((str.charAt(pos)>='0')&&(str.charAt(pos)<='9'))||(str.charAt(pos)=='-')){
          cur_char=CHAR_LETTER_NUMERIC;
        }
        else{
          cur_char=CHAR_OTHER;
        }
        switch (cur_status){
          case -1://error
            rc=false;
            exit_flag=true;
            break;

          case 0://初始状态
            if((cur_char==CHAR_LETTER_NUMERIC)||(cur_char==CHAR_UNDERLINE)||(cur_char==CHAR_DOT)){
              cur_status=1;
            }
            else{
              rc=false;
              cur_status=-1;
            }
            break;
          case 1://用户名
            if((cur_char==CHAR_LETTER_NUMERIC)||(cur_char==CHAR_UNDERLINE)||(cur_char==CHAR_DOT)){
              cur_status=1;
            }
            else if(cur_char==CHAR_AT){
              cur_status=2;
            }
            else{
              rc=false;
              cur_status=-1;
            }
            break;
          case 2://@
            if(cur_char==CHAR_LETTER_NUMERIC){
              cur_status=6;
            }
            else{
              rc=false;
              cur_status=-1;
            }
            break;

          case 6://"."
            if(cur_char==CHAR_LETTER_NUMERIC){
              cur_status=6;
            }
            else if(cur_char==CHAR_DOT){
              cur_status=3;
            }
            else{
              rc=false;
              cur_status=-1;
            }
            break;

          case 3://fisrt domain name
            if(cur_char==CHAR_LETTER_NUMERIC){
              cur_status=4;
            }
            else{
              rc=false;
              cur_status=-1;
            }
            break;
          case 4://not first domain name
            if(cur_char==CHAR_LETTER_NUMERIC){
              cur_status=4;
            }
            else if(cur_char==CHAR_DOT){
              cur_status=3;
            }
            else if(cur_char==CHAR_DIVIDE){
              cur_status=0;
            }
            else if(cur_char==CHAR_END){
              cur_status=5;
            }
            else{
              rc=false;
              cur_status=-1;
            }
            break;
          case 5://ok
            rc=true;
            exit_flag=true;
            break;
          default:
            rc=false;
            exit_flag=true;
            break;
        }
        pos++;
    }
    return rc;
}
function checkEmail(str){
  return CheckEmail(str);
}

// 6.检查输入参数是否为合法的身份证号码
// 18位身份证号码参考 GB 11643

function CheckID(sID){
  var rc=false;
  if (sID+"" == "undefined" || sID == null || sID == ''){
    rc=true;
  } else if (CheckCertiCode(sID)==0) {
    rc=true;
  }

  return rc;
}

//检查身份证校验位
function CheckIDParityBit(sID){
  var W=new Array(7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2,1);
  var rc=false;
  if (sID+"" == "undefined" || sID == null || sID == ''){
    rc=true;
  }
  if(sID.length==18){
    var nCount=0;
    var nIdNum=0;
    for (var i=0;i<18;i++) {
      var c=sID.charAt(i);
      if((c=='X')||(c=='x')){
         nIdNum=10;
      } else if((c<='9')||(c>='0')) {
         nIdNum=c-'0';
      } else {
         return rc;
      }
      nCount+=nIdNum*W[i];
    }
    if((nCount%11)==1){
      rc=true;
    }
  }
  return rc;
}

//修改为新加坡身份征校验规则（传入的参数必须先全部是大写，并且保证页面参数全部大写）
/*function CheckID(sID){
  var rc=true;
  var values = new Array(7);
  if (sID+"" == "undefined" || sID == null || sID == ''){
    return true;
	} else if (sID.charAt(0)=='M' || sID.charAt(0)=='O' || sID.charAt(0)=='F' || sID.charAt(0)=='G') {
		return true;
	} else if (sID.length!=9) {
		rc=false;
	} else {
		for(i=0; i < sID.length - 1; i++){
			if(i==0){
				if (sID.charAt(i)!='S' && sID.charAt(i)!='T') {
					rc=false;
					break;
				}
			} else if (i==sID.length-1) {
				if (!((sID.charAt(i)>='A' && sID.charAt(i)<='J') || sID.charAt(i)!='Z')) {
					rc=false;
					break;
				}
			} else {
				values[i-1] = sID.charAt(i);
				if (sID.charAt(i)<'0' || sID.charAt(i)>'9'){
					rc=false;
					break;
				}
			}
		}
	}
	if (rc) {
		var result;
		if (sID.charAt(0)=='S') {
			result = 11 - ((values[0]*2+values[1]*7+values[2]*6+values[3]*5+values[4]*4+values[5]*3+values[6]*2) % 11);
		} else if (sID.charAt(0)=='T') {
			result = 11 - ((values[0]*2+values[1]*7+values[2]*6+values[3]*5+values[4]*4+values[5]*3+values[6]*2 + 4) % 11);
		}
		switch (result) {
			case (1):
				if (sID.charAt(8) != 'A')
					rc = false;
				break;
			case (2):
				if (sID.charAt(8) != 'B')
					rc = false;
				break;
			case (3):
				if (sID.charAt(8) != 'C')
					rc = false;
				break;
			case (4):
				if (sID.charAt(8) != 'D')
					rc = false;
				break;
			case (5):
				if (sID.charAt(8) != 'E')
					rc = false;
				break;
			case (6):
				if (sID.charAt(8) != 'F')
					rc = false;
				break;
			case (7):
				if (sID.charAt(8) != 'G')
					rc = false;
				break;
			case (8):
				if (sID.charAt(8) != 'H')
					rc = false;
				break;
			case (9):
				if (sID.charAt(8) != 'I')
					rc = false;
				break;
			case (10):
				if (sID.charAt(8) != 'Z')
					rc = false;
				break;
			case (11):
				if (sID.charAt(8) != 'J')
					rc = false;
				break;
		}
	}
  return rc;
}
*/
function checkID(str){
    return CheckID(str);
}
//新加坡身份证首位与生日关系校验
function CheckIdBirth(sID, bYear, bMonth, bDay){
	var checkDate = new Date(2000, 0, 1);
	var birthDate = new Date(bYear, bMonth-1, bDay);
	var rc = false;
	if ( sID.charAt(0) == 'M' || sID.charAt(0) == 'O' || sID.charAt(0) == 'F' || sID.charAt(0) == 'G' || (birthDate < checkDate && sID.charAt(0) == 'S') || (birthDate >= checkDate && sID.charAt(0) == 'T')) {
		rc = true;
	}
	return rc;
}

// 7.检查电话号码是否正确
function CheckTelephone(str) {
    var rc=true;
    if (str+"" == "undefined" || str == null){
        rc=false;
    } else {
        for(i=0;i<str.length;i++) {
            if(!(str.charAt(i)>='0' && str.charAt(i)<='9')&& str.charAt(i)!='*' && str.charAt(i)!='('&& str.charAt(i)!=')'&& str.charAt(i)!='-'){
                rc= false;
                break;
            }
         }
    }
    return rc;
}
function checkTelephone(phone){
    return CheckTelephone(phone);
}

// 8.检查密码，只能为字母或数字
function CheckPassword(str) {
    var rc=true;
    if (str+"" == "undefined" || str == null){
        rc=false;
    } else {
        for(i=0;i<str.length;i++) {
            if(str.charAt(i)<'0'||(str.charAt(i)>'9' && str.charAt(i)<'A')||(str.charAt(i)>'Z' && str.charAt(i)<'a')||str.charAt(i)>'z'){
                rc= false;
                break;
            }
        }
    }
    return rc;
}
function checkPassword(str){
    return CheckPassword(str);
}

// 9.检查BP机号码
function CheckBp(str) {
    var rc=true;
    if (str+"" == "undefined" || str == null){
        rc=false;
    } else {
        for(i=0;i<str.length;i++) {
            if((str.charAt(i)<'0' || str.charAt(i)>'9')&&(str.charAt(i)!='-'||str.charAt(i)!='*')){
                rc= false;
                break;
            }
        }
    }
    return rc;
}
function checkBp(str){
    return CheckBp(str);
}

// 10.检查电话号码
function CheckAreaPhone(str) {
    var rc=true;
    if (str+"" == "undefined" || str == null){
        rc=false;
    } else {
        for(i=0;i<str.length;i++) {
            if((str.charAt(i)<'0' || str.charAt(i)>'9')&&str.charAt(i)!='-'&&str.charAt(i)!='*'){
                    rc= false;
                    break;
            }
        }
    }
    return rc;
}
function checkAreaPhone(str){
    return CheckAreaPhone(str)
}

// 11.检查是否全为字母
function IsLetter(str){
    var rc=true;
    if (str+"" == "undefined" || str == null){
            rc=false;
    } else {
        for(i=0;i<str.length;i++) {
            if((str.charAt(i)>'Z' && str.charAt(i)<'a')||str.charAt(i)<'A' || str.charAt(i)>'z'){
                    rc=false;
                    break;
            }
        }
    }
    return rc;
}
function isLetter(str){
    return IsLetter(str);
}

// 12.检查年龄
function CheckAge(age){
    var rc=true;
    if(CheckNumber(age)==false) {
        rc= false;
    } else if(age>=200) {
        rc= false;
    } else if(age<0){
        rc=false;
    }
    return rc;
}
function checkAge(age){
    return CheckAge(age);
}

// 13.检查是否全为空格
function AllSpace(str) {
    for(i=0;i<str.length-1;i++) {
        if(str.charAt(i)!=' ') {
            if(str.charAt(i)!=0xa1||str.chatAt(i+1)!=0xa1)
                return false;
            else
                i++;
        }
    }
    if(str.charAt(i)!=' ')
        return false;
    return true;
}
function allSpace(str) {
    return AllSpace(str);
}

// 14.检查日期在给定日期之后
function DateIsLargerThanNow2(year, month, day, nowdate){
    var rc=false;
    if(!CheckDate(year,month,day)){
        rc=true;
    } else{
        var d1=new Date(Eear,month-1,day);
        var d0=new Date();
        if(d1.getTime()>d0.getTime()){
            rc=true;
        }
    }
    return rc;
}
function dateIsLargerThanNow2(year, month, day, nowdate){
    return DateIsLargerThanNow2(year, month, day, nowdate);
}

// 15.检查日期在当前日期之后
function DateIsLargerThanNow(year, month, day){
    return DateIsLargerThanNow2(year,month,day,(new Date()));
}
function dateIsLargerThanNow(year, month, day){
    return DateIsLargerThanNow(year,month,day);
}

// 16.检查身份证
function CheckCertiCode(id) {
   // check length
  try {
   if (id.length!=15 && id.length!=18) {
     alert("身份证长度非法！");
     return 1;
   }
   // check birth
   if (id.length == 15) {
      var birthday_year = "19" + id.substring(6, 8);
      var birthday_month = id.substring(8, 10);
      var birthday_day = id.substring(10, 12);
      if ( CheckDate(birthday_year, birthday_month, birthday_day)==false ) {
        alert("身份证出生日期非法！");
        return 2;
      }
   }
   if (id.length == 18) {
      var birthday_year = id.substring(6, 10);
      var birthday_month = id.substring(10, 12);
      var birthday_day = id.substring(12, 14);
      if ( CheckDate(birthday_year, birthday_month, birthday_day)==false ) {
        alert("身份证出生日期非法！");
        return 3;
      }
      // check parity bit
      if (!CheckIDParityBit(id)) {
        alert("身份证号码错误！");
        return 5;
      }
   }
  } // end of try
  catch(e){
  	window.alert ("校验身份证出错"+e.description);
  	return 4;
  }
  return 0;
}

// 17.检查身份证与生日、性别 (M:male;F:female)
function CheckIDBirthGender(id, birth, gender) {
   // check birth
  try {
   if (id.length == 15) {
      var id_birthday = "19" + id.substring(6, 8) +"-"+ id.substring(8, 10) +"-"+ id.substring(10, 12);
      var id_gender = id.substring(14);
   }
   else {
      var id_birthday = id.substring(6, 10) +"-"+ id.substring(10, 12) +"-"+ id.substring(12, 14);
      var id_gender = id.substring(16, 17);
   }
   if ( birth!=id_birthday ) {
      alert("生日与身份证不符！");
      return 1;
   }
   if (gender=="M" || gender=="m") {
       if ( id_gender!="1" && id_gender!="3" && id_gender!="5" && id_gender!="7" && id_gender!="9" ) {
            alert("性别与身份证不符！");
            return 2;
       }
   }
   else {
       if ( id_gender!="2" && id_gender!="4" && id_gender!="6" && id_gender!="8" && id_gender!="0" ) {
            alert("性别与身份证不符！");
            return 2;
       }
   }
  } // end of try
  catch(e){
	window.alert ("校验身份证出错"+e.description);
	return 3;
  }
  return 0;
}

// if date is error, the input date_string will be returned
// else return the date string with stardard format
function Date2StandardFmt( date_string ) {
    if (date_string == "")
        return;
    var date_src_string = date_string
    if ((date_string.length!=8 && date_string.length!=10)
        || (date_string.length==10 && date_string.indexOf("-")<0) ) {
        return date_src_string;
    }

    // no split character
    if ( date_string.indexOf("-")<0 ) {
        date_string = date_string.substring(0, 4) +"-"+date_string.substring(4, 6)+"-"+date_string.substring(6);
    }

    var date_year = date_string.substring(0, 4);
    var date_month = date_string.substring(5, 7);
    var date_day = date_string.substring(8);
    if ( CheckDate(date_year, date_month, date_day)==false ) {
        return date_src_string;
    }
    return date_string;

}

// if date is error, error msg will be alerted
// else upt the date obj's value to standard format
function DateObj2StandardFmt( date_obj ) {
    var date_string = date_obj.value;
    if (date_string == "")
        return false;
//    if ((date_string.length!=8 && date_string.length!=10)
//        || (date_string.length==10 && date_string.indexOf("-")<0) ) {
//        date_obj.focus();
//        alert("请依【YYYY-MM-DD】格式输入，例：2008-08-08！");
//        return;
//    }
    // no split character
    if ( date_string.indexOf("-")<0 ) {
        date_string = date_string.substring(0, 4) +"-"+date_string.substring(4, 6)+"-"+date_string.substring(6);
    }
    var date_arr = new Array();
    date_arr = date_string.split("-");
    var date_year = date_arr[0];
    var date_month = date_arr[1];
    var date_day = date_arr[2];

    //var date_year = date_string.substring(0, 4);
    //var date_month = date_string.substring(5, 7);
    //var date_day = date_string.substring(8);
    if ( CheckDate(date_year, date_month, date_day)==false ) {
        date_obj.focus();
        alert("无效日期格式! 请依【YYYY-MM-DD】格式输入，例：2008-08-08！");
        return false;
    }

    date_obj.value =  date_string;
    return true;

}
// if date is error, error msg will be alerted
// else upt the date obj's value to format
//add by wencai.yan 2001-11-09
function DateObj2Fmt( date_obj ) {
    var date_string = date_obj.value;
    if (date_string == "")
        return;
    if (
    		(		date_string.length!=4 && date_string.length!=6 && date_string.length!=7
    			&& date_string.length!=8 && date_string.length!=10
    		)
        || (date_string.length==7 && date_string.indexOf("-")<0)
        || (date_string.length==10 && date_string.indexOf("-")<0)
       ) {
        date_obj.focus();
        alert("日期长度不对!");
        return;
    }
    // no split character
    if ( date_string.indexOf("-")<0 && date_string.length==8 ) {
        date_string = date_string.substring(0, 4) +"-"+date_string.substring(4, 6)+"-"+date_string.substring(6);
    }
		if ( date_string.indexOf("-")<0 && date_string.length==6 ) {
        date_string = date_string.substring(0, 4) +"-"+date_string.substring(4);
    }
    if(date_string.length>=8){
		    var date_year = date_string.substring(0, 4);
		    var date_month = date_string.substring(5, 7);
		    var date_day = date_string.substring(8);
		    if ( CheckDate(date_year, date_month, date_day)==false ) {
		        date_obj.focus();
		        alert("无效日期格式!");
		        return ;
		    }
    }
		if(date_string.length<8 && date_string.length>4){
		    var date_year = date_string.substring(0, 4);
		    var date_month = date_string.substring(5, 7);
		    var date_day = "01";
		    if ( CheckDate(date_year, date_month,date_day)==false ) {
		        date_obj.focus();
		        alert("无效日期格式!");
		        return ;
		    }
    }
    if(date_string.length=4){
		    var date_year = date_string.substring(0, 4);
		    var date_month = "01"
		    var date_day = "01";
		    if ( CheckDate(date_year, date_month,date_day)==false ) {
		        date_obj.focus();
		        alert("无效日期格式!");
		        return ;
		    }
    }
    date_obj.value =  date_string;

}

// return value : M 男 F 女
function GetGenderFromID( id_value ) {
   var gender;
   var id_gender;
   if ( id_value.length==15 )
      id_gender = id_value.substring(14);
   else if ( id_value.length==18 )
      id_gender = id_value.substring(16, 17);
   else
       return "";
   if ( id_gender=="1" || id_gender=="3" || id_gender=="5" || id_gender=="7" || id_gender=="9" ) {
            gender = "M";
   }
   else  {
   	  gender = "F";
   }
   return gender;
}

// return value : yyyy-mm-dd
function GetBirthdayFromID( id ) {
  try {
   var birthday;
   if ( id.length==15 )
      birthday = "19" + id.substring(6, 8)+"-"+id.substring(8, 10)+"-"+id.substring(10, 12);
   else if ( id.length==18 )
      birthday = id.substring(6, 10)+"-"+id.substring(10, 12)+"-"+id.substring(12, 14);
   else
      birthday = "";
   return birthday
  }
  catch(e){
	window.alert ("解析身份证出错"+e.description);
	return "";
  }
}

// 20. 检查是否为当日以前的合法日期
// add by rock
function IsByPastDate(str1) {
    if (str1 + "" == "undefined" || str1 == null){
        return false;
    }
    var y,m,d;
    var i;
    i = str1.indexOf("-");
    if (i == -1 || i == str1.length) { return false; }
    y = str1.substring(0, i);
    str1 = str1.substring(i + 1);

    i = str1.indexOf("-");
    if (i == -1 || i == str1.length) { return false; }
    m = str1.substring(0, i);

    d = str1.substring(i + 1);

    return !DateIsLargerThanNow(y,m,d);
}
// 21。检查会计期间的合法性
//Add by Jack
function Period2StandardFmt( date_obj ) {
    var date_string = date_obj.value;
    if (date_string == "")
        return;
    if ((date_string.length!=6 && date_string.length!=7)
        || (date_string.length==7 && date_string.indexOf("-")<0) ) {
        date_obj.focus();
        alert("Illegal Length of Account Period！");
        return;
    }
    // no split character
    if ( date_string.indexOf("-")<0 ) {
        date_string = date_string.substring(0, 4) +"-"+date_string.substring(4, 6);
    }

    var date_year = date_string.substring(0, 4);
    var date_month = date_string.substring(5, 7);
		var date_day = "01";
    if ( CheckDate(date_year, date_month, date_day)==false ) {
        date_obj.focus();
        alert("Illegal Account Period！");
        return ;
    }

    date_obj.value =  date_string;

}

// 22. 把两个数值相加, 结果为指定精度的相加结果
// num1: 被加数
// num2: 加数
// float_length:  结果精度(>=0的整数)
// added by Kevin
function addNumber(num1, num2, float_length) {
   var nTemp = 10;
   if (float_length==0) {
     nTemp = 1;
   }
  else {
  	nTemp = 10*float_length;
  }

	var nSum = new Number(num1)*nTemp + new Number(num2)*nTemp;
  nSum = nSum/nTemp;

	var sSum = new String(nSum);
	var j = sSum.indexOf(".");
	if (j>=0) {
		sSum = sSum.substring(0, j+float_length+1);
		nSum = new Number(sSum);
	}

	return nSum;
}

//23 检测输入的保单号是否合法
// obj:输入保单号的textField对象
function CheckPolicyCode(obj){

//进行其他的检测
  // write code here

//对输入保单号码进行补零处理
  if(obj!=""){
	var str = obj.value;
	var len = str.length;
	var idx = obj.value.indexOf("-");
	if(	idx<0){
	//如果输入中没有符号"-"
		len = 15 - len;
	}else{
		len = 15 - idx;
	}
	//补零
	for(l=0;l<len;l++)
		str = "0" + str;
	obj.value = str;
  }
  return true;
}

//24 检测输入的投保单号是否合法
// obj:输入投保单号的textField对象
function CheckApplyCode(obj){
	return CheckPolicyCode(obj);
}

  //25 判断一个字符串是否以指定字符串开头
  //2003-04-04 add by tairs
  function startWith(str,start){
    try{
      return (str.substring(0,start.length)==start);
    }catch(ex){
      return false;
    }
  }

  //26 判断一个字符串是否以指定字符串结尾
  //2003-04-04 add by tairs
  function endWith(str,end){
    try{
      return (str.substring(str.length-end.length)==end);
    }catch(ex){
      return false;
    }
  }

  //27 取得去除顺序号后的号码
  //系统中，带有顺序号的号码格式为xxxxxx-xx，其中-xx为顺序号
  //本方法返回"-"之前的部分，如果不含有"-"，则返回原值本身；
  //2003-04-04 add by tairs
  function getPureCode(code){
    var pureCode;
    if(code.indexOf("-")>=0){
      pureCode = code.substring(0,code.indexOf("-"))
    }else{pureCode = code;}
    return pureCode;
  }

  //28 检查是否是团单保单号码
  //检查规则：去除顺序号后以088结尾即认为是团单保单号码，否则不是
  //2003-04-04 add by tairs
  function isGroupPolicyCode(code){
    return endWith(getPureCode(code),"088");
  }

  //29 检查是否是团单投保单号码
  //检查规则：去除顺序号后以050结尾即认为是团单投保单号码，否则不是
  //2003-04-04 add by tairs
  function isGroupSendCode(code){
    return endWith(getPureCode(code),"050");
  }

  //30 检查是否是符合规则的个单投保单号码
  //检查规则：去除顺序号后以001结尾即认为是个单投保单号码，否则不是
  //2003-09-18 add by xiaoyuan.he
  function isValidIndvSendCode(code) {
  	return isValidSendCode(code,"001");
  }

  //31 检查是否是符合规则的团单投保单号码
  //检查规则：去除顺序号后以050结尾即认为是团单投保单号码，否则不是
  //2003-09-18 add by xiaoyuan.he
  function isValidGroupSendCode(code) {
  	return isValidSendCode(code,"050");
  }

  //32 检查是否是符合规则的投保单号码
  //code:投保单号码  suffix:投保单号码后缀（个单:001　团单:050）
  //检查规则：
  //    个单：去除顺序号后以001结尾即认为是个单投保单号码，否则不是
  //    团单：去除顺序号后以050结尾即认为是团单投保单号码，否则不是
  //2003-09-18 add by xiaoyuan.he
  function isValidSendCode(code,suffix) {
  	var result = false;
  	//截取续保的投保单号码前面的部分
  	//var pureCode = getPureCode(code);
  	//太平的投保单不存在后面有序号
  	var pureCode = code;
  	//是否是15位
  	result = pureCode.length == 15;
  	if (result == false) return false;
		//检查是否全部是数字
		for(i=0; i < pureCode.length - 1; i++) {
			if (pureCode.charAt(i)<'0' || pureCode.charAt(i)>'9'){
				result = false;
				break;
			}
		}
		if (result == false) return false;
		//如果是老保单，则返回
		//if (startWith(pureCode,"00")) return true;  //太平不处理老保单
  	//是否以(个单：001 团单：050)结尾
  	result = endWith(pureCode,suffix);
  	if (result == false) return false;
  	//检查校验码
  	//检查重新组合后的数字除以97余数是否为1
  	var crc = (parseInt('1'+pureCode.substring(0,10)) - 10000000000) + pureCode.substring(12,15) + pureCode.substring(10,12);
  	result = (parseInt(crc) % 97) == 1;

    return result;
  }


  //32 检查并返回录入项的字符长度
  //检查规则：每个汉字长度为3，字母及数字等长度长度为1
  //2007-07-11 

  function  getStrLengthB(strItem){
    var len = 0;   
    for (var i=0; i<strItem.length; i++) {   
        if (strItem.charCodeAt(i)>127 || strItem.charCodeAt(i)==94) {   
            len += 3;   
        } else {   
            len ++;   
        }   
    }   
    return len;   
}

  //33 检查是否是符合规则的团单投保单号码
  //检查规则：检查、截取录入项的前后空格，并返回截取后的字符
  //2007-07-11 
  function  getStrTrim(strItem){
	for(var i=0;  i<strItem.length  &&  strItem.charAt(i)==" ";  i++  )  ;
        for(var  j  =strItem.length;  j>0  &&  strItem.charAt(j-1)==" "  ;  j--)  ;
        if(i>j)  return  "";  
        return  strItem.substring(i,j);  
  }

  //34 屏蔽浏览器"BackSpace"
  document.onkeydown   =   function(){   
  if(event.keyCode   ==   8)   
  {   
	  if(event.srcElement.tagName.toLowerCase()   !=   "input" && event.srcElement.tagName.toLowerCase()   !=   "textarea") 
	  event.returnValue   =   false;   
	  else   if   (event.srcElement.type.toLowerCase()   !=   "text" && event.srcElement.type.toLowerCase()   !=   "password" && event.srcElement.type.toLowerCase()   !=   "textarea")  
	  event.returnValue   =   false;
  }  
  } 
 /* 
  35 检查是否存在全角字符
   boolean IsSBC(obj)
*/

  function IsSBC(str){
  

      for (var i=0; i<str.length; i++) {   
        if (str.charCodeAt(i)>127 || str.charCodeAt(i)==94) {   
            return false;   
            break;
        }   
    }   
    return true;   
  }
 /* 
  36 邮编校验
   checkPostCode(obj)   
*/
   function checkPostCode(obj){
   
   var str=obj.value;
   
   if (str!=""){
   if (str.length!=6){
   	        alert('邮编长度为6');
	        obj.focus();
   }
   
	for(i=0;i<str.length;i++){
	    if(str.charAt(i)<'0' || str.charAt(i)>'9'){
	        alert('邮编必须全部为数字');
	        obj.focus();
	        break;
	    }
	}
   }
   }
   
   