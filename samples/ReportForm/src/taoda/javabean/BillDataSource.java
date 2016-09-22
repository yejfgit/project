/*
 * JasperReports - Free Java Reporting Library.
 * Copyright (C) 2001 - 2014 TIBCO Software Inc. All rights reserved.
 * http://www.jaspersoft.com
 *
 * Unless you have purchased a commercial license agreement from Jaspersoft,
 * the following license terms apply:
 *
 * This program is part of JasperReports.
 *
 * JasperReports is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JasperReports is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with JasperReports. If not, see <http://www.gnu.org/licenses/>.
 */
package taoda.javabean;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;


/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 */
public class BillDataSource implements JRDataSource
{


	/**
	 *
	 */
	private Object[][] data =
		{
			{"1001", "15", "02", "01","18658822615","Àî°×",1300.00,"Ò¼ÇªÈþ°ÛÔªÕû","100861112"}
			
		};

	private int index = -1;
	

	/**
	 *
	 */
	public BillDataSource()
	{
		
	}


	/**
	 *
	 */
	public boolean next() throws JRException
	{
		index++;

		return (index < data.length);
	}


	/**
	 *
	 */
	public Object getFieldValue(JRField field) throws JRException
	{
		Object value = null;
		
		String fieldName = field.getName();
		
		if ("numberId".equals(fieldName))
		{
			value = data[index][0];
		}
		else if ("year".equals(fieldName))
		{
			value = data[index][1];
		}
		else if ("mon".equals(fieldName))
		{
			value = data[index][2];
		}
		else if ("day".equals(fieldName))
		{
			value = data[index][3];
		}
		else if ("cumNumb".equals(fieldName))
		{
			value = data[index][4];
		}
		else if ("cumName".equals(fieldName))
		{
			value = data[index][5];
		}
		
		else if ("money".equals(fieldName))
		{
			value = data[index][6];
		}
		else if ("capitalMoney".equals(fieldName))
		{
			value = data[index][7];
		}
		else if ("shopNum".equals(fieldName))
		{
			value = data[index][8];
		}
		return value;
	}


}
