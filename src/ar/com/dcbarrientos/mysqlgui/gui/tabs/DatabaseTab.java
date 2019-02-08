/*
 *  Copyright (C) 2019 Diego Barrientos <dc_barrientos@yahoo.com.ar>
 * 
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 * 
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 * 
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/** 
 * DatabaseTab.java
 *
 * Description:	    <Descripcion>
 * @author			Diego Barrientos <dc_barrientos@yahoo.com.ar>
 *
 * Created on 6 feb. 2019, 11:30:29 
 */

package ar.com.dcbarrientos.mysqlgui.gui.tabs;

import java.awt.BorderLayout;

import javax.swing.JTabbedPane;

import ar.com.dcbarrientos.mysqlgui.db.Database;
import ar.com.dcbarrientos.mysqlgui.gui.DatabaseElement;
import ar.com.dcbarrientos.mysqlgui.gui.Ventana;
import ar.com.dcbarrientos.mysqlgui.gui.tabs.databasetab.TablesPanel;

/**
 * @author Diego Barrientos <dc_barrientos@yahoo.com.ar>
 *
 */
public class DatabaseTab extends DatabaseElement{
	private static final long serialVersionUID = 1L;
	
	public String title = resource.getString("DatabaseTab.title");
	
	private final int TABLES_INDEX 				= 0;
	private final int INDEXES_INDEX				= 1;
	private final int TRIGGERS_INDEX 			= 2;
	private final int VIEWS_INDEX 				= 3;
	private final int STOREDPROCEDURES_INDEX 	= 4;
	private final int FUNCTIONS_INDEX 			= 5;
	private final int GRANTS_INDEX 				= 6;
	private final int EVENTS_INDEX 				= 7;
	
	private String selectedDB;
	
	private JTabbedPane tabPane;
	private TablesPanel databasePanel;
	
	public DatabaseTab(Ventana ventana, Database database) {
		super(ventana, database);
		
		initComponents();
	}

	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		
		tabPane = new JTabbedPane();
		add(tabPane, BorderLayout.CENTER);
		
		databasePanel = new TablesPanel(ventana, database);
		tabPane.insertTab(resource.getString("TablesPanel.title"), null, databasePanel, null, TABLES_INDEX);
	}
	
	public void setSelectedDatabase(String databaseName) {
		this.selectedDB = databaseName;
		
		databasePanel.setSelectedDatabase(selectedDB);
		
		refresh();
	}

	@Override
	public void refresh() {
		//loadData();
		this.revalidate();
		this.repaint();
	}

}