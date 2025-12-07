package groupsix.resume.UI;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;
import javafx.util.Builder;

public class ResumeViewBuilder implements Builder<Region> {

    private final RSMSModel model;

    public ResumeViewBuilder(RSMSModel model) {
        this.model = model;
    }
    @Override
    public Region build() {
        TableView<ParseTableRow> results = new TableView<>();

        TableColumn<ParseTableRow, String> titleCol = new TableColumn<>("Section Title");
        titleCol.setCellValueFactory(
                row -> row.getValue().headingProperty());
        titleCol.prefWidthProperty().bind(results.widthProperty().multiply(0.2));
        results.getColumns().add(titleCol);

        TableColumn<ParseTableRow, String> dataCol = new TableColumn<>("Body");
        dataCol.setCellValueFactory(
                row -> row.getValue().bodyProperty());
        dataCol.prefWidthProperty().bind(results.widthProperty().multiply(0.8));
        results.getColumns().add(dataCol);

        results.setItems(model.getResumeTable());

        return results;
    }
}
