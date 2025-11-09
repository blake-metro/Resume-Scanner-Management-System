package groupsix.resume;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;
import javafx.util.Builder;

public class ResumeViewBuilder implements Builder<Region> {

    private final ObservableList<ParseModel> model;

    public ResumeViewBuilder(ObservableList<ParseModel> model) {
        this.model = model;
    }
    @Override
    public Region build() {
        // TODO:
        TableView<ParseModel> results = new TableView<>();

        TableColumn<ParseModel, String> titleCol = new TableColumn<>("Title");
        titleCol.setCellValueFactory(title -> title.getValue().titleProperty());
        results.getColumns().add(titleCol);

        TableColumn<ParseModel, String> dataCol = new TableColumn<>("Data");
        dataCol.setCellValueFactory(data -> data.getValue().dataProperty());
        results.getColumns().add(dataCol);

        results.setItems(model);

        return results;
    }
}
