package airganizer.logic;

import airganizer.dba.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

/**
 *
 * @author pat
 */
public class FlugSuchen {
    
    
    
    public static void load(TableView table){
        
        Connection con = null;
        Statement sta = null;
        ResultSet result = null;
        ObservableList<ObservableList> data;
        
        data = FXCollections.observableArrayList();
        
        // Alte Einträge löschen
        table.getColumns().clear();
        
        try{
            
            // Verbindung aufbauen, Statement erzeugen
            con = DBConnection.connect();
            sta = con.createStatement();
            
            // Query abschicken, Ergebnis auswerten
            result = sta.executeQuery("SELECT * FROM Flug;");
            

            if(result!=null){
                
                
                ResultSetMetaData rsmd = result.getMetaData();
            
                for(int column=0; column<rsmd.getColumnCount(); column++) {
                        
                        final int j = column;
                        
                        TableColumn col = new TableColumn(result.getMetaData().getColumnName(column+1));
                        col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                            
                            @Override
                            public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param){
                                return new SimpleStringProperty(param.getValue().get(j).toString());
                            }
                            
                            
                            
                        });
                        
                        table.getColumns().addAll(col);
                        System.out.println("Column ["+column+"] ");
                        
                        
                }
                
                    
                while(result.next()) {
                     
                    ObservableList<String> row = FXCollections.observableArrayList();
                    
                    for(int i = 1; i<=result.getMetaData().getColumnCount(); i++){
                        
                        System.out.println(result.getString(i));
                        row.add(result.getString(i));
                        
                    }
                    
                    data.add(row);
                   
                }
                
                table.setItems(data);
                result.close();

                  

                } else {

                        System.out.println("NOTHING FOUND...");

                    }
            
                
        } catch (Exception e){
            
            System.err.println(e);
            
        } finally {
            
            // Abfrage beenden
            if(sta!=null){
                
                try {sta.close();} catch(Exception e) {}
                
            }
            
            DBConnection.disconnect(con);
        }
        
        
        
    }
    
}
