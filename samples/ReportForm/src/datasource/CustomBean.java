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

package datasource;
/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 */
public class CustomBean
{


	/**
	 *
	 */
	private String City;
	private Integer Id;
	private String Name;
	private String Street;
	public String getCity() {
		return City;
	}
	public void setCity(String City) {
		this.City = City;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer Id) {
		this.Id = Id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	public String getStreet() {
		return Street;
	}
	public void setStreet(String Street) {
		this.Street = Street;
	}
	public CustomBean(String City, Integer Id, String Name, String Street) {
		super();
		this.City = City;
		this.Id = Id;
		this.Name = Name;
		this.Street = Street;
	}
	

}
