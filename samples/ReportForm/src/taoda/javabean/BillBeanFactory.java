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

import java.util.Arrays;
import java.util.Collection;


/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 */
public class BillBeanFactory
{


	/**
	 *
	 */
	private static Bill[] data =
		{
			new Bill("1001", "15", "02", "01","18658822615","Àî°×",1300.00,"Ò¼ÇªÈþ°ÛÔªÕû","100861112")
			
		};  
			

	/**
	 *
	 */
	public static Object[] getBeanArray()
	{
		return data;
	}


	/**
	 *
	 */
	public static Collection<Bill> createBeanCollection()
	{
		return Arrays.asList(data);
	}


}
