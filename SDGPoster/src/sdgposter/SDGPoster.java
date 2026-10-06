import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        VBox root = new VBox(15);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(25));

        // SDG 6 water-themed background
        root.setStyle(
            "-fx-background-color: linear-gradient(to bottom, #DFF6FF, #87CEEB, #1E90FF);"
        );

        // Heading
        Label title = new Label("SDG 6");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 42));
        title.setTextFill(Color.DARKBLUE);

        Label subtitle = new Label("CLEAN WATER AND SANITATION");
        subtitle.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        subtitle.setTextFill(Color.WHITE);

        Label description = new Label(
            "Ensure availability and sustainable management of water\n"
            + "and sanitation for all."
        );
        description.setFont(Font.font("Arial", 17));
        description.setTextFill(Color.DARKBLUE);
        description.setAlignment(Pos.CENTER);

        // Information box
        VBox infoBox = new VBox(10);
        infoBox.setAlignment(Pos.CENTER);
        infoBox.setPadding(new Insets(18));
        infoBox.setMaxWidth(600);

        infoBox.setStyle(
            "-fx-background-color: white;"
            + "-fx-background-radius: 15;"
            + "-fx-border-color: #006994;"
            + "-fx-border-width: 2;"
            + "-fx-border-radius: 15;"
        );

        Label infoTitle = new Label("WHY IS CLEAN WATER IMPORTANT?");
        infoTitle.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        infoTitle.setTextFill(Color.DARKBLUE);

        Label info = new Label(
            "• Safe drinking water protects human health.\n"
            + "• Proper sanitation prevents diseases.\n"
            + "• Water conservation protects our future.\n"
            + "• Everyone deserves access to clean water."
        );

        info.setFont(Font.font("Arial", 15));

        infoBox.getChildren().addAll(infoTitle, info);

        // Buttons
        Button learnButton = new Button("Learn More");
        Button tipsButton = new Button("Water Saving Tips");
        Button goalButton = new Button("Our Goal");

        Button[] buttons = {
            learnButton, tipsButton, goalButton
        };

        for (Button button : buttons) {
            button.setFont(Font.font("Arial", FontWeight.BOLD, 14));
            button.setPrefWidth(180);
            button.setPrefHeight(40);

            button.setStyle(
                "-fx-background-color: #006994;"
                + "-fx-text-fill: white;"
                + "-fx-background-radius: 20;"
            );
        }

        HBox buttonBox = new HBox(15);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(
            learnButton,
            tipsButton,
            goalButton
        );

        // Event handling
        learnButton.setOnAction(e -> {
            showMessage(
                "SDG 6",
                "SDG 6 aims to ensure clean water and sanitation for everyone."
            );
        });

        tipsButton.setOnAction(e -> {
            showMessage(
                "Water Saving Tips",
                "• Turn off taps when not needed.\n"
                + "• Repair leaking taps.\n"
                + "• Reuse water whenever possible.\n"
                + "• Avoid water pollution."
            );
        });

        goalButton.setOnAction(e -> {
            showMessage(
                "Our Goal",
                "Save water today for a healthier and sustainable tomorrow!"
            );
        });

        // Footer
        Label footer = new Label(
            "EVERY DROP COUNTS • SAVE WATER • SAVE LIFE"
        );

        footer.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        footer.setTextFill(Color.WHITE);

        root.getChildren().addAll(
            title,
            subtitle,
            description,
            infoBox,
            buttonBox,
            footer
        );

        Scene scene = new Scene(root, 800, 650);

        stage.setTitle("SDG 6 - Clean Water and Sanitation");
        stage.setScene(scene);
        stage.show();
    }

    // Display message when buttons are clicked
    private void showMessage(String title, String message) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}