package groupsix.resume.UI;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;
import javafx.util.Builder;

/**
 * Creates a Region for displaying the contents of a ParseTable of the type specified
 * (resume or job description)
 */
public class TableViewBuilder implements Builder<Region> {

    public enum Type {RESUME, JOB_DESCRIPTION}

    private final RSMSModel model;
    private final Type type;


    public TableViewBuilder(RSMSModel model, Type type) {
        this.model = model;
        this.type = type;
    }

    @Override
    public Region build() {
        if(type == Type.JOB_DESCRIPTION) {
            return build(model.getJobDescriptionTable());
        }else{
            return build(model.getResumeTable());
        }
    }

    private Region build(ObservableList<ParseTableRow> list) {
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

        results.setItems(list);

        return results;
    }
}
