package groupsix.resume.UI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;
import javafx.util.Builder;

public class JobDescViewBuilder implements Builder<Region> {

    private final RSMSModel model;
    private final ObservableList<ParseTableRow> jobDescrTableItems;

    public JobDescViewBuilder(RSMSModel model) {
        this.model = model;
        jobDescrTableItems = FXCollections.observableArrayList();
        jobDescrTableItems.setAll(ParseTableRow.generateJobDescrList());
    }

    @Override
    public Region build() {
        TableView<ParseTableRow> results = new TableView<>();

        TableColumn<ParseTableRow, String> titleCol = new TableColumn<>("Heading");
        titleCol.setCellValueFactory(
                row -> row.getValue().headingProperty());
        results.getColumns().add(titleCol);

        TableColumn<ParseTableRow, String> dataCol = new TableColumn<>("Body");
        dataCol.setCellValueFactory(
                row -> row.getValue().bodyProperty());
        results.getColumns().add(dataCol);

        results.setItems(model.getJobDescriptionTable());

        return results;
    }
}
