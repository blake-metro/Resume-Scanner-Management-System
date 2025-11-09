package groupsix.resume.UI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Window;
import javafx.util.Builder;

import java.util.function.Consumer;

public class ScoreViewBuilder implements Builder<Region> {

    //private final ResumeModel viewModel;

    public ScoreViewBuilder() {
        //this.viewModel = viewModel;
    }

    @Override
    public Region build() {
        // Displays score info
        Label score = new Label("00");
        TableView scoreBreakdown = new TableView<String>();
        HBox scoreBox = new HBox(new Label("Score: "), score);
        scoreBox.setAlignment(Pos.CENTER);
        VBox results = new VBox(10, scoreBox, scoreBreakdown);
        results.setPadding(new Insets(6));
        return results;
    }
}
