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
package com.report.scriptlets;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;


/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 */
public class WebappDataSource implements JRDataSource
{


	/**
	 *
	 */
	private Object[][] data =
		{
			{ new Integer(1), "Àî°×1", "ÄÐ","1988-02-1"},
			{ new Integer(2), "Àî°×2", "ÄÐ","1988-02-1"},
			{ new Integer(3), "Àî°×3", "ÄÐ","1988-02-1"},
			{ new Integer(4), "Àî°×4", "ÄÐ","1988-02-1"},
			{ new Integer(5), "Àî°×2", "ÄÐ","1988-02-1"},
			{ new Integer(6), "Àî°×", "ÄÐ","1988-02-1"},
			{ new Integer(7), "Àî°×", "ÄÐ","1988-02-1"},
			{ new Integer(8), "Àî°×", "ÄÐ","1988-02-1"},
			{ new Integer(9), "Àî°×", "ÄÐ","1988-02-1"},
			{ new Integer(10), "Àî°×", "ÄÐ","1988-02-1"},
			{ new Integer(11), "Àî°×", "ÄÐ","1988-02-1"},
			{ new Integer(12), "Àî°×", "ÄÐ","1988-02-1"},
			{ new Integer(13), "Àî°×", "ÄÐ","1988-02-1"},
			{ new Integer(14), "Àî°×", "ÄÐ","1988-02-1"},
			{ new Integer(15), "Àî°×", "ÄÐ","1988-02-1"},
			{ new Integer(16), "Àî°×", "ÄÐ","1988-02-1"},
			{ new Integer(17), "Àî°×", "ÄÐ","1988-02-1"},
			{ new Integer(18), "Àî°×", "ÄÐ","1988-02-1"},
			{ new Integer(19), "Àî°×", "ÄÐ","1988-02-1"},
			{ new Integer(20), "Àî°×", "ÄÐ","1988-02-1"},
			{ new Integer(21), "Àî°×", "ÄÐ","1988-02-1"},
			{ new Integer(22), "Àî°×", "ÄÐ","1988-02-1"},
			{ new Integer(23), "Àî°×", "ÄÐ","1988-02-1"},
			{ new Integer(24), "Àî°×", "ÄÐ","1988-02-1"},
			{ new Integer(25), "Àî°×", "ÄÐ","1988-02-1"},
			{ new Integer(26), "Àî°×", "ÄÐ","1988-02-1"},
			{ new Integer(27), "Àî°×", "ÄÐ","1988-02-1"},
			{ new Integer(28), "Àî°×", "ÄÐ","1988-02-1"}
		};

	private int index = -1;
	

	/**
	 *
	 */
	public WebappDataSource()
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
		
		if ("id".equals(fieldName))
		{
			value = data[index][0];
		}
		else if ("name".equals(fieldName))
		{
			value = data[index][1];
		}
		else if ("gender".equals(fieldName))
		{
			value = data[index][2];
		}
		else if ("birthday".equals(fieldName))
		{
			value = data[index][3];
		}
		
		return value;
	}


}
