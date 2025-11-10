package groupsix.resume.UI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;
import javafx.util.Builder;

public class JobDescViewBuilder implements Builder<Region> {

    private final RSMSModel model;
    private final ObservableList<ParseModel> jobDescrTableItems;

    public JobDescViewBuilder(RSMSModel model) {
        this.model = model;
        jobDescrTableItems = FXCollections.observableArrayList();
        jobDescrTableItems.setAll(ParseModel.generateJobDescrList());
    }

    @Override
    public Region build() {
        // TODO:
        TableView<ParseModel> results = new TableView<>();

        TableColumn<ParseModel, String> titleCol = new TableColumn<>("Tag");
        titleCol.setCellValueFactory(title -> title.getValue().titleProperty());
        results.getColumns().add(titleCol);

        TableColumn<ParseModel, String> dataCol = new TableColumn<>("Data");
        dataCol.setCellValueFactory(data -> data.getValue().dataProperty());
        results.getColumns().add(dataCol);

        results.setItems(jobDescrTableItems);

        return results;
    }
}
