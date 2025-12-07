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
        TableView<ParseRow> results = new TableView<>();

        TableColumn<ParseRow, String> titleCol = new TableColumn<>("Heading");
        titleCol.setCellValueFactory(
                row -> row.getValue().headingProperty());
        results.getColumns().add(titleCol);

        TableColumn<ParseRow, String> dataCol = new TableColumn<>("Body");
        dataCol.setCellValueFactory(
                row -> row.getValue().bodyProperty());
        results.getColumns().add(dataCol);

        results.setItems(model.getResumeTable());

        return results;
    }
}
