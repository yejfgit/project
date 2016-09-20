/*	SophyCalendar.js
    Javascript Calendar

    Author:		            Ge.shaofei(2005.7.10 --- 2005.7.12)
    	
    Description:
                            A.	totally object oriented program architecture,be conveniet to read and use。
                            B.	provide two languague version:Simple Chinese and English,it can select the right language according to the browser.
                            C.  use the exposed fields U can custom the outlooking of the calendar.
                            D.  Detach body onclick event when calendar hide to improve the responsity content of the body click event.
                            E.  To be modify to adapter more requirement.

    Design Roadmap:         when finished download from the net and the browser will initialize a instance of this calendar,when show event happen,
                            it will be call.Also the outlooking Settings will be done in this process.

    Version Specification:  V1.0 ;In the future will provide htc and server control of asp.net Version.

    Use Method:             Assume the instance name of the calendar in memory is 'calendar',you can use form element event to call its show,just
                            give the date container element name;for example:
                            <srcipt language=javascript>var calendar = new SophyCalendar();</script>
                            <input name='date1' readonly><input type=button value='getDate' onclick=calendar.show('date1')>
                            
    Use Attention:          this js file should be quoted in the element form,and the charset should be 'UTF-8' because in this file using chinese 
                            charset.
*/

function SophyCalendar()
{
    var dayOfTheFirstDate,lastDate,dayOfTheLastDate,weekNumber,selectedDate,lastDateOfTheFirstWeekRow;
    this.weekName = new Array('Sun','Mon','Tue','Wed','Thu','Fri','Sat');
    this.monthName = new Array('January','Feburary','March','April','May','June','July','August','September','October','November','December');
    this.todayName = "Today:";
    this.weekChineseName = new Array('日','一','二','三','四','五','六');
    this.monthChineseName = new Array('一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月');
    this.todayChineseName = "今天:";
    var calendarLeftTopX,calendarLeftTopY,calendarRightDownX,calendarRightDownY;
    var dateClicked;
    var firstShow = false;
    var initialized = false;
    var controlClientRect,wrapperRect;
  
    var calendar = this;
    var today = new Date();
    var currentYear = today.getFullYear();
    var currentMonth = today.getMonth();
    var currentDate = today.getDate();
    var year = currentYear;
    var month = currentMonth;
    var date = currentDate;
    this.control = null;
    this.selectedMonth = null;
    this.selectedYear = null;
    this.selectedDate = null;

    this.wrapper = document.createElement('div');
    this.wrapper.style.position = 'absolute';
    this.wrapper.style.display = 'none';
    document.forms[0].insertAdjacentElement('beforeEnd',this.wrapper);
    this.iframe = document.createElement('iframe');
    this.wrapper.insertAdjacentElement('beforeEnd',this.iframe);
    this.container = document.createElement('table');
    this.container.cellPadding = 0;
    this.container.cellSpacing = 0;
    this.container.border = 0;
    this.container.style.position = 'absolute';
    this.container.style.zIndex = 1000;
    this.container.style.height = '100%';
    this.container.style.width = '100%';
    this.wrapper.insertAdjacentElement('afterBegin',this.container);
    this.header = document.createElement('table');
    this.header.style.width = '100%';
    this.header.style.height = '100%';
    var row = this.container.insertRow();
    var cell = row.insertCell();
    cell.insertAdjacentElement('beforeEnd',this.header);
    this.weekNameTable = document.createElement('table');
    this.weekNameTable.style.width = '100%';
    this.weekNameTable.style.height = '100%';
    this.weekNameTable.style.textAlign = 'center';
    row = this.container.insertRow();
    cell = row.insertCell();
    cell.insertAdjacentElement('beforeEnd',this.weekNameTable);
    this.calendarBody = document.createElement('table');
    this.calendarBody.style.textAlign = 'center';
    this.calendarBody.border = 0;
    this.calendarBody.style.width = '100%';
    this.calendarBody.style.height = '100%';
    row = this.container.insertRow();
    row.style.height = '60%';
    cell = row.insertCell();
    cell.insertAdjacentElement('beforeEnd',this.calendarBody);
    this.footer = document.createElement('table');
    this.footer.style.width = '100%';
    this.footer.style.height = '100%';
    row = this.container.insertRow();
    cell = row.insertCell();
    cell.insertAdjacentElement('beforeEnd',this.footer);
    
    this.monthSelect = document.createElement('select');
    this.yearSelect = document.createElement('select');;

    this.show = function(controlName)
    {
    	
        if(!initialized)
            calendar.initialize();
        dateClicked = false;
        calendar.control = document.getElementById(controlName);
        if(calendar.control.value != "")
        {
            var YMD = calendar.control.value.split('-');
            year = new Number(YMD[0]);
            month = (new Number(YMD[1])) - 1;
            date = new Number(YMD[2]);
            calendar.selectedYear = new Number(year);
            calendar.selectedMonth = new Number(month);
            calendar.selectedDate = new Number(date);
        }
        else
        {
            year = currentYear;
            month = currentMonth;
            date = currentDate;
        }
        var clientWidth=document.body.clientWidth;
        var clientHeight=document.body.clientHeight;
        controlClientRect = calendar.control.getBoundingClientRect();
        var posX=controlClientRect.left-3;
        var posY=controlClientRect.top;
        var showPosX = posX + document.body.scrollLeft;
        var showPosY = posY + document.body.scrollTop;
        if(clientHeight-posY>calendar.height+15) 
            showPosY += calendar.control.clientHeight-3;
        else if(posY>calendar.height)
            showPosY -= calendar.height+4;
        var controlRightPosX = controlClientRect.right + 16;
        if((clientWidth-controlRightPosX)<calendar.width && controlRightPosX>calendar.width)
            showPosX = controlRightPosX - calendar.width + document.body.scrollLeft;
        calendar.wrapper.style.top = showPosY;
        calendar.wrapper.style.left = showPosX;
        calendar.wrapper.style.display = '';
        wrapperRect = calendar.wrapper.getBoundingClientRect();
        calendar.render(year,month,date);
        firstShow = true;
        
        document.body.detachEvent("onclick" , calendar.hide);
        document.body.attachEvent("onclick" , calendar.hide);
    };
    this.hide = function() 
    {
        if(dateClicked)
        {
            calendar.wrapper.style.display = 'none';
         if((parseInt(month)+1)<10&&date<10){
            calendar.control.value = year.toString() + '-0' + (parseInt(month)+1).toString() + '-0' + date.toString();
          }
        else if((parseInt(month)+1)>9&&date<10){
        	calendar.control.value = year.toString() + '-' + (parseInt(month)+1).toString() + '-0' + date.toString();
        }
        else if((parseInt(month)+1)<10&&date>9){
        	calendar.control.value = year.toString() + '-0' + (parseInt(month)+1).toString() + '-' + date.toString();
        }
        else {
        	calendar.control.value = year.toString() + '-' + (parseInt(month)+1).toString() + '-' + date.toString();
        }
            document.body.detachEvent("onclick" , calendar.hide);
        }
        if((window.event.x<wrapperRect.left | window.event.x>wrapperRect.right | window.event.y<wrapperRect.top | window.event.y>wrapperRect.bottom) && window.event.srcElement != calendar.yearSelect && window.event.srcElement != calendar.monthSelect)
        {
            if(!firstShow)
            {
                calendar.wrapper.style.display = 'none';
                document.body.detachEvent("onclick" , calendar.hide);
            }
            firstShow = false;
        }
    };
    this.render = function(selectedYear,selectedMonth,selectedDate)
    {
        year = selectedYear;
        month = selectedMonth;
        date = selectedDate;
        if(month < 0)
        {
            month = 11;
            year--;
        }
        if(month > 11)
        {
            month = 0;
            year++;
        }
        dayOfTheFirstDate = new Date(year,month,1).getDay();
        lastDate = new Date(year,parseInt(month)+1,0).getDate();
        dayOfTheLastDate = new Date(year,month,lastDate).getDay();
        weekNumber = Math.ceil(lastDate/7);
        lastDateOfTheFirstWeekRow = 7 - dayOfTheFirstDate;
        firstDateOfLastWeekRow = lastDate - dayOfTheLastDate;
        calendar.calendarBody.clearRows();
        
        calendar.calendarBody.insertTheFirstWeekRow();
        calendar.calendarBody.insertMiddleWeekRows();
        calendar.calendarBody.insertTheLastWeekRow();
        calendar.container.yearSelectAdjust();
        calendar.container.monthSelectAdjust();

    };
    this.calendarBody.clearRows = function()
    {
        while(calendar.calendarBody.rows.length > 0)
            calendar.calendarBody.deleteRow(0);
    };
    this.container.insertHeader = function()
    {
        var row = calendar.header.insertRow();
        var cell = row.insertCell();
        cell.innerText = '<';
        cell.style.cursor = 'hand';
        cell.onclick = function(){calendar.render(year,month-1,date);};
        
        cell = row.insertCell();
        cell.align = 'center';
        cell.insertAdjacentElement('beforeEnd',calendar.container.monthSelect());
        cell.insertAdjacentHTML('beforeEnd','&nbsp;');
        cell.insertAdjacentElement('beforeEnd',calendar.container.yearSelect());
        
        cell = row.insertCell();
        cell.innerText = '>';
        cell.style.cursor = 'hand';
        cell.onclick = function(){calendar.render(year,parseInt(month)+1,date);};
    };
    this.container.insertWeekNameTable = function()
    {
        var row = calendar.weekNameTable.insertRow();
        for(i=0;i<7;i++)
        {
            cell = row.insertCell();
            cell.innerText = calendar.weekName[i];
            cell.style.width = '14.2857%';
            
        }       
    };
    this.calendarBody.insertTheFirstWeekRow = function()
    {
        var lastDateOfLastMonth = new Date(year,month,0).getDate();
        var lastMonthFirstDateOfTheFirstWeek = lastDateOfLastMonth - dayOfTheFirstDate + 1;
        var row = calendar.calendarBody.insertRow();
        var weekEnd = false;
        var count = 1;
        for(i = lastMonthFirstDateOfTheFirstWeek; i <= lastDateOfLastMonth; i++)
        {
            weekEnd = (count == 1)?true:false;
            count++;
            calendar.calendarBody.insertCell(row,month-1,i,false,weekEnd);
        }
        for(i = 1; i <= lastDateOfTheFirstWeekRow; i++)
        {
            weekEnd = (count == 1 | count == 7)?true:false;
            count++;
            calendar.calendarBody.insertCell(row,month,i,true,weekEnd);
        }
    };
    this.calendarBody.insertTheLastWeekRow = function()
    {
        var row = calendar.calendarBody.insertRow();
        var weekEnd = false;
        var count = 1;
        for(i = firstDateOfLastWeekRow; i <= lastDate; i++)
        {
            weekEnd = (count == 1 | count == 7)?true:false;
            count++;
            calendar.calendarBody.insertCell(row,month,i,true,weekEnd);
        }
        var nextMonthLastDateOfTheLastWeekRow = 6 - dayOfTheLastDate
        for(i=1; i <= nextMonthLastDateOfTheLastWeekRow; i++)
        {
            weekEnd = (count == 7)?true:false;
            count++;
            calendar.calendarBody.insertCell(row,parseInt(month)+1,i,false,weekEnd);
        }
    };
    this.calendarBody.insertMiddleWeekRows = function()
    {
        var count=0;
        var row = calendar.calendarBody.insertRow();
        var weekEnd = false;
        for(i=parseInt(lastDateOfTheFirstWeekRow) + 1;i < firstDateOfLastWeekRow; i++)
        {
            count++;
            if(count > 7)
            {
                row = calendar.calendarBody.insertRow();
                count = 1;
            }
            weekEnd = (count == 1 | count == 7)?true:false;
            calendar.calendarBody.insertCell(row,month,i,true,weekEnd);
        }
    };
    this.container.insertFooter = function()
    {
        var row = calendar.footer.insertRow();
        var cell = row.insertCell();
        cell.innerText = calendar.todayName + currentYear.toString() + '-' + (parseInt(currentMonth) + 1).toString() + '-' + currentDate.toString();
        cell.style.cursor = 'hand';
        cell.onclick = function()
        {
            dateClicked = true;
            year = currentYear;
            month = currentMonth;
            date = currentDate;
            calendar.hide();
        };
    };
    this.calendarBody.insertCell = function(row,cellMonth,cellDate,isDateInMonth,weekEnd)
    {
        var cellYear = year;
        if(cellMonth > 11)
        {
            cellMonth = 0;
            cellYear++;
        }
        if(cellMonth < 0)
        {
            cellMonth = 0;
            cellYear--;
        }
        var cell = row.insertCell();
        cell.innerText = cellDate;
        cell.style.cursor = 'hand';
        if(isDateInMonth)
        {
            cell.style.color = calendar.dayStyle_foreColor;
            cell.style.backgroundColor = calendar.dayStyle_backColor;        
        }
        else
        {
            cell.style.color = calendar.otherMonthDayStyle_foreColor;
            cell.style.backgroundColor = calendar.otherMonthDayStyle_backColor;        
        }
        if(weekEnd)
        {
            cell.style.color = calendar.weekendStyle_foreColor;
            cell.style.backgroundColor = calendar.weekendStyle_backColor;
        }
        if(cellDate == currentDate && cellMonth == currentMonth && year.toString() == currentYear.toString())
        {
            cell.style.color = calendar.todayStyle_foreColor;
            cell.style.backgroundColor = calendar.todayStyle_backColor;
        }
        if(cellDate == calendar.selectedDate && cellMonth == calendar.selectedMonth && year.toString() == calendar.selectedYear.toString())
        {
            cell.style.color = calendar.selectedDayStyle_foreColor;
            cell.style.backgroundColor = calendar.selectedDayStyle_backColor;
        }
        cell.onclick = function()
        {
            dateClicked = true;
            year = cellYear;
            month = cellMonth;
            date = cellDate;
            calendar.hide();
        };
    };
    this.container.monthSelect = function()
    {
        calendar.monthSelect.onchange = function(){calendar.render(year,calendar.monthSelect.value,date);};
        for(i=0;i<12;i++)
        {
            var option = document.createElement('option');
            option.text = calendar.monthName[i];
            option.value = i;
            calendar.monthSelect.options.add(option);            
        }
        return calendar.monthSelect;
    };
    this.container.yearSelect = function()
    {
        calendar.yearSelect.onchange = function(){calendar.render(calendar.yearSelect.value,month,date);};
        for(i=(parseInt(year)-10);i <= (parseInt(year)+10);i++)
        {
            var option = document.createElement('option');
            option.text = i;
            option.value = i;
            calendar.yearSelect.options.add(option);
        }
        return calendar.yearSelect;
    };
    this.container.yearSelectAdjust = function()
    {
        var y = parseInt(year) - 10;
        var o;
        for(i=0;i<calendar.yearSelect.options.length;i++)
        {
            o = calendar.yearSelect.options[i];
            o.text = y;
            o.value = y;
            if(y == year) o.selected = true;
            y++;
        }   
    };
    this.container.monthSelectAdjust = function()
    {
        calendar.monthSelect.options[parseInt(month)].selected = true;
    };
    this.initialize = function()
    {
        initialized = true;
        if(calendar.width < 200) calendar.width = 200;
        if(calendar.height < 200) calendar.height = 200;
        calendar.wrapper.style.posWidth = calendar.width;
        calendar.wrapper.style.posHeight = calendar.height;
        calendar.iframe.width = calendar.width;
        calendar.iframe.height = calendar.height;

        calendar.container.bgColor = calendar.gridStyle_lineColor;
        calendar.header.style.color = calendar.headerStyle_foreColor;
        calendar.header.style.backgroundColor = calendar.headerStyle_backColor;
        calendar.header.style.fontSize = calendar.headerStyle_fontSize;
        calendar.weekNameTable.style.color = calendar.weekNameStyle_foreColor;
        calendar.weekNameTable.style.backgroundColor = calendar.weekNameStyle_backColor;
        calendar.weekNameTable.style.fontSize = calendar.weekNameStyle_fontSize;
        calendar.calendarBody.style.fontSize = calendar.dateStyle_fontSize;
        calendar.calendarBody.cellSpacing = calendar.gridStyle_lineWidth;
        calendar.footer.style.color = calendar.footerStyle_foreColor;
        calendar.footer.style.backgroundColor = calendar.footerStyle_backColor;
        calendar.footer.style.fontSize = calendar.footerStyle_fontSize;
        calendar.monthSelect.style.color = calendar.dropDownListStyle_foreColor;
        calendar.monthSelect.style.backgroundColor = calendar.dropDownListStyle_backColor;
        calendar.monthSelect.style.fontSize = calendar.dropDownListStyle_fontSize;
        calendar.yearSelect.style.color = calendar.dropDownListStyle_foreColor;
        calendar.yearSelect.style.backgroundColor = calendar.dropDownListStyle_backColor;
        calendar.yearSelect.style.fontSize = calendar.dropDownListStyle_fontSize;

        if(navigator.browserLanguage.indexOf('zh') > -1)
        {
            calendar.weekName = calendar.weekChineseName;
            calendar.monthName = calendar.monthChineseName;
            calendar.todayName = calendar.todayChineseName;
        }
        
        calendar.container.insertHeader();
        calendar.container.insertFooter();
        calendar.container.insertWeekNameTable();
    };
}

var calendar = new SophyCalendar();
calendar.headerStyle_foreColor = 'white';
calendar.headerStyle_backColor = '#929abb';
calendar.headerStyle_fontSize = '10pt';
calendar.footerStyle_foreColor = 'white';
calendar.footerStyle_backColor = '#929abb';
calendar.footerStyle_fontSize = '10pt';
calendar.weekNameStyle_foreColor = 'white';
calendar.weekNameStyle_backColor = '#929abb';
calendar.weekNameStyle_fontSize = '10pt';
calendar.dateStyle_fontSize = '10pt';
calendar.weekendStyle_foreColor = '#CF6E06';
calendar.weekendStyle_backColor = 'white';
calendar.todayStyle_foreColor = 'white';
calendar.todayStyle_backColor = '#CF6E06';
calendar.otherMonthDayStyle_foreColor = '#8DB8EA';
calendar.otherMonthDayStyle_backColor = 'White';
calendar.dayStyle_foreColor = 'navy';
calendar.dayStyle_backColor = '#F3F9FF';
calendar.selectedDayStyle_foreColor = 'white';
calendar.selectedDayStyle_backColor = '#8DB8EA';
calendar.dropDownListStyle_foreColor = 'navy';
calendar.dropDownListStyle_backColor = '#F3F9FF';
calendar.dropDownListStyle_fontSize = '10pt';
calendar.gridStyle_lineColor = '#8DB8EA';
calendar.gridStyle_lineWidth = 1;
calendar.width = 200;
calendar.height = 200;