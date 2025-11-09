package groupsix.resume.UI;

import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.util.Builder;

public class JobDescViewBuilder implements Builder<Region> {

    @Override
    public Region build() {
        // TODO:
        Label results = new Label("Job Description View");
        return results;
    }
}
