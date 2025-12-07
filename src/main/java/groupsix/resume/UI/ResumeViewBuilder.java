package groupsix.resume.UI;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;
import javafx.util.Builder;

import java.util.Map;

public class ResumeViewBuilder implements Builder<Region> {

    private final RSMSModel model;

    public ResumeViewBuilder(RSMSModel model) {
        this.model = model;
    }
    @Override
    public Region build() {
        TableView<Map.Entry<String, String>> results = new TableView<>();

        TableColumn<Map.Entry<String, String>, String> titleCol = new TableColumn<>("Heading");
        titleCol.setCellValueFactory(   // 'getValue()' gets the Map entry pair, 'getKey()' gets the actual text
                entry -> new SimpleStringProperty(entry.getValue().getKey()));
        results.getColumns().add(titleCol);

        TableColumn<Map.Entry<String, String>, String> dataCol = new TableColumn<>("Body");
        dataCol.setCellValueFactory(    // first 'getValue()' gets the Map entry pair, second gets the actual text
                data -> new SimpleStringProperty(data.getValue().getValue()));
        results.getColumns().add(dataCol);

        results.setItems(FXCollections.observableArrayList(model.getResume().getAllEntries()));

        return results;
    }
}
