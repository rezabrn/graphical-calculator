package ir.ac.kntu;

import java.util.HashMap;
import java.io.File;
import ir.ac.kntu.logic.numberWraper;
import ir.ac.kntu.logic.Calculator;

import javafx.application.Application;
import javafx.beans.property.adapter.ReadOnlyJavaBeanBooleanProperty;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Path;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private HashMap<Key, Image> images = new HashMap<>();

    private HashMap<Key, Button> buttons = new HashMap<>();

    private HashMap<Key, ImageView> views = new HashMap<>();

    private numberWraper number = new numberWraper();

    private numberWraper number2 = new numberWraper();

    private Boolean secondOperand;

    private Label text = new Label();

    private StringBuilder operator = new StringBuilder();

    private GridPane root = new GridPane();

    public void start(Stage stage) throws Exception {
        secondOperand = false;
        setImages();
        setView1();
        setView2();
        setButton1();
        setButton2();
        action();
        keyMaker();
        root.setVgap(5);
        root.setHgap(5);
        root.add(text, 0, 0, 4, 1);
        Scene scene = new Scene(root, 280, 270);
        stage.setTitle("Image");
        stage.setScene(scene);
        stage.show();
    }

    public void keyMaker() {
        root.add(buttons.get(Key.SEVEN), 0, 1);
        root.add(buttons.get(Key.FOUR), 0, 2);
        root.add(buttons.get(Key.ONE), 0, 3);
        root.add(buttons.get(Key.CLEAR), 0, 4);
        root.add(buttons.get(Key.EIGHT), 1, 1);
        root.add(buttons.get(Key.FIVE), 1, 2);
        root.add(buttons.get(Key.TWO), 1, 3);
        root.add(buttons.get(Key.ZERO), 1, 4);
        root.add(buttons.get(Key.NINE), 2, 1);
        root.add(buttons.get(Key.SIX), 2, 2);
        root.add(buttons.get(Key.THREE), 2, 3);
        root.add(buttons.get(Key.EQUAL), 2, 4);
        root.add(buttons.get(Key.PLUS), 3, 1);
        root.add(buttons.get(Key.MINUS), 3, 2);
        root.add(buttons.get(Key.DIVIDE), 3, 3);
        root.add(buttons.get(Key.MULTIPLY), 3, 4);
    }

    public void setImages() {
        images.put(Key.ZERO, new Image("./resources/buttons/0.jpg"));
        images.put(Key.ONE, new Image("./resources/buttons/1.jpg"));
        images.put(Key.TWO, new Image("./resources/buttons/2.jpg"));
        images.put(Key.THREE, new Image("./resources/buttons/3.jpg"));
        images.put(Key.FOUR, new Image("./resources/buttons/4.jpg"));
        images.put(Key.FIVE, new Image("./resources/buttons/5.jpg"));
        images.put(Key.SIX, new Image("./resources/buttons/6.jpg"));
        images.put(Key.SEVEN, new Image("./resources/buttons/7.jpg"));
        images.put(Key.EIGHT, new Image("./resources/buttons/8.jpg"));
        images.put(Key.NINE, new Image("./resources/buttons/9.jpg"));
        images.put(Key.CLEAR, new Image("./resources/buttons/clear.jpg"));
        images.put(Key.DIVIDE, new Image("./resources/buttons/divide.jpg"));
        images.put(Key.EQUAL, new Image("./resources/buttons/equal.jpg"));
        images.put(Key.MINUS, new Image("./resources/buttons/minus.jpg"));
        images.put(Key.MULTIPLY, new Image("./resources/buttons/multiply.jpg"));
        images.put(Key.PLUS, new Image("./resources/buttons/plus.jpg"));
    }

    public void setButton1() {
        buttons.put(Key.ZERO, new Button());
        buttons.get(Key.ZERO).setGraphic(views.get(Key.ZERO));
        buttons.put(Key.ONE, new Button());
        buttons.get(Key.ONE).setGraphic(views.get(Key.ONE));
        buttons.put(Key.TWO, new Button());
        buttons.get(Key.TWO).setGraphic(views.get(Key.TWO));
        buttons.put(Key.THREE, new Button());
        buttons.get(Key.THREE).setGraphic(views.get(Key.THREE));
        buttons.put(Key.FOUR, new Button());
        buttons.get(Key.FOUR).setGraphic(views.get(Key.FOUR));
        buttons.put(Key.FIVE, new Button());
        buttons.get(Key.FIVE).setGraphic(views.get(Key.FIVE));
        buttons.put(Key.SIX, new Button());
        buttons.get(Key.SIX).setGraphic(views.get(Key.SIX));
        buttons.put(Key.SEVEN, new Button());
        buttons.get(Key.SEVEN).setGraphic(views.get(Key.SEVEN));
    }

    public void setButton2() {
        buttons.put(Key.EIGHT, new Button());
        buttons.get(Key.EIGHT).setGraphic(views.get(Key.EIGHT));
        buttons.put(Key.NINE, new Button());
        buttons.get(Key.NINE).setGraphic(views.get(Key.NINE));
        buttons.put(Key.CLEAR, new Button());
        buttons.get(Key.CLEAR).setGraphic(views.get(Key.CLEAR));
        buttons.put(Key.DIVIDE, new Button());
        buttons.get(Key.DIVIDE).setGraphic(views.get(Key.DIVIDE));
        buttons.put(Key.EQUAL, new Button());
        buttons.get(Key.EQUAL).setGraphic(views.get(Key.EQUAL));
        buttons.put(Key.MINUS, new Button());
        buttons.get(Key.MINUS).setGraphic(views.get(Key.MINUS));
        buttons.put(Key.MULTIPLY, new Button());
        buttons.get(Key.MULTIPLY).setGraphic(views.get(Key.MULTIPLY));
        buttons.put(Key.PLUS, new Button());
        buttons.get(Key.PLUS).setGraphic(views.get(Key.PLUS));
    }

    public void setView1() {
        views.put(Key.ZERO, new ImageView(images.get(Key.ZERO)));
        views.get(Key.ZERO).setFitHeight(50);
        views.get(Key.ZERO).setFitWidth(50);
        views.put(Key.ONE, new ImageView(images.get(Key.ONE)));
        views.get(Key.ONE).setFitHeight(50);
        views.get(Key.ONE).setFitWidth(50);
        views.put(Key.TWO, new ImageView(images.get(Key.TWO)));
        views.get(Key.TWO).setFitHeight(50);
        views.get(Key.TWO).setFitWidth(50);
        views.put(Key.THREE, new ImageView(images.get(Key.THREE)));
        views.get(Key.THREE).setFitHeight(50);
        views.get(Key.THREE).setFitWidth(50);
        views.put(Key.FOUR, new ImageView(images.get(Key.FOUR)));
        views.get(Key.FOUR).setFitHeight(50);
        views.get(Key.FOUR).setFitWidth(50);
        views.put(Key.FIVE, new ImageView(images.get(Key.FIVE)));
        views.get(Key.FIVE).setFitHeight(50);
        views.get(Key.FIVE).setFitWidth(50);
        views.put(Key.SIX, new ImageView(images.get(Key.SIX)));
        views.get(Key.SIX).setFitHeight(50);
        views.get(Key.SIX).setFitWidth(50);
        views.put(Key.SEVEN, new ImageView(images.get(Key.SEVEN)));
        views.get(Key.SEVEN).setFitHeight(50);
        views.get(Key.SEVEN).setFitWidth(50);
    }

    public void setView2() {
        views.put(Key.EIGHT, new ImageView(images.get(Key.EIGHT)));
        views.get(Key.EIGHT).setFitHeight(50);
        views.get(Key.EIGHT).setFitWidth(50);
        views.put(Key.NINE, new ImageView(images.get(Key.NINE)));
        views.get(Key.NINE).setFitHeight(50);
        views.get(Key.NINE).setFitWidth(50);
        views.put(Key.CLEAR, new ImageView(images.get(Key.CLEAR)));
        views.get(Key.CLEAR).setFitHeight(50);
        views.get(Key.CLEAR).setFitWidth(50);
        views.put(Key.DIVIDE, new ImageView(images.get(Key.DIVIDE)));
        views.get(Key.DIVIDE).setFitHeight(50);
        views.get(Key.DIVIDE).setFitWidth(50);
        views.put(Key.EQUAL, new ImageView(images.get(Key.EQUAL)));
        views.get(Key.EQUAL).setFitHeight(50);
        views.get(Key.EQUAL).setFitWidth(50);
        views.put(Key.MINUS, new ImageView(images.get(Key.MINUS)));
        views.get(Key.MINUS).setFitHeight(50);
        views.get(Key.MINUS).setFitWidth(50);
        views.put(Key.MULTIPLY, new ImageView(images.get(Key.MULTIPLY)));
        views.get(Key.MULTIPLY).setFitHeight(50);
        views.get(Key.MULTIPLY).setFitWidth(50);
        views.put(Key.PLUS, new ImageView(images.get(Key.PLUS)));
        views.get(Key.PLUS).setFitHeight(50);
        views.get(Key.PLUS).setFitWidth(50);
    }

    public void operationAction1() {
        buttons.get(Key.ZERO).setOnAction(actionEvent -> {
            if (secondOperand == true) {
                number2.setNumber(0);
                text.setText(text.getText() + number2.toString());
            } else {
                number.setNumber(0);
                text.setText(text.getText() + number.toString());
            }
        });
        buttons.get(Key.ONE).setOnAction(actionEvent -> {
            if (secondOperand == true) {
                number2.setNumber(1);
                text.setText(text.getText() + number2.toString());
            } else {
                number.setNumber(1);
                text.setText(text.getText() + number.toString());
            }
        });
    }

    public void operationAction2() {
        buttons.get(Key.TWO).setOnAction(actionEvent -> {
            if (secondOperand == true) {
                number2.setNumber(2);
                text.setText(text.getText() + number2.toString());
            } else {
                number.setNumber(2);
                text.setText(text.getText() + number.toString());
            }
        });
        buttons.get(Key.THREE).setOnAction(actionEvent -> {
            if (secondOperand == true) {
                number2.setNumber(3);
                text.setText(text.getText() + number2.toString());
            } else {
                number.setNumber(3);
                text.setText(text.getText() + number.toString());
            }
        });
    }

    public void operationAction3() {
        buttons.get(Key.CLEAR).setOnAction(actionEvent -> {
            text.setText(text.getText().substring(0, text.getText().length() - 1));
        });
        buttons.get(Key.MINUS).setOnAction(actionEvent -> {
            if (secondOperand == true) {
                secondOperand = false;
            } else {
                secondOperand = true;
            }
            operator = new StringBuilder("MINUS");
            number.setNumber(Integer.parseInt(text.getText() == null ? "0" : text.getText()));
            text.setText("");
        });
        buttons.get(Key.MULTIPLY).setOnAction(actionEvent -> {
            if (secondOperand == true) {
                secondOperand = false;
            } else {
                secondOperand = true;
            }
            operator = new StringBuilder("MULTIPLY");
            number.setNumber(Integer.parseInt(text.getText() == null ? "0" : text.getText()));
            text.setText("");
        });
    }

    public void operationAction7() {
        buttons.get(Key.PLUS).setOnAction(actionEvent -> {
            if (secondOperand == true) {
                secondOperand = false;
            } else {
                secondOperand = true;
            }
            operator = new StringBuilder("PLUS");
            number.setNumber(Integer.parseInt(text.getText() == null ? "0" : text.getText()));
            text.setText("");
        });
    }

    public void operationAction4() {
        buttons.get(Key.DIVIDE).setOnAction(actionEvent -> {
            if (secondOperand == true) {
                secondOperand = false;
            } else {
                secondOperand = true;
            }
            operator = new StringBuilder("DIVIDE");
            number.setNumber(Integer.parseInt(text.getText() == null ? "0" : text.getText()));
            text.setText("");
        });
        buttons.get(Key.EQUAL).setOnAction(actionEvent -> {
            StringBuilder operand1 = new StringBuilder((number.getNumber()) + "");
            StringBuilder operand2 = new StringBuilder(
                    (text.getText().substring(0)) == null ? "0" : (text.getText().substring(0)) + "");
            String answer = (Calculator.calculate(operand1, operand2, operator)) + "";
            text.setText(answer);
            secondOperand = false;
        });
    }

    public void operationAction5() {
        buttons.get(Key.SEVEN).setOnAction(actionEvent -> {
            if (secondOperand == true) {
                number2.setNumber(7);
                text.setText(text.getText() + number2.toString());
            } else {
                number.setNumber(7);
                text.setText(text.getText() + number.toString());
            }
        });
        buttons.get(Key.EIGHT).setOnAction(actionEvent -> {
            if (secondOperand == true) {
                number2.setNumber(8);
                text.setText(text.getText() + number2.toString());
            } else {
                number.setNumber(8);
                text.setText(text.getText() + number.toString());
            }
        });
        buttons.get(Key.NINE).setOnAction(actionEvent -> {
            if (secondOperand == true) {
                number2.setNumber(9);
                text.setText(text.getText() + number2.toString());
            } else {
                number.setNumber(9);
                text.setText(text.getText() + number.toString());
            }
        });
    }

    public void operationAction6() {
        buttons.get(Key.FOUR).setOnAction(actionEvent -> {
            if (secondOperand == true) {
                number2.setNumber(4);
                text.setText(text.getText() + number2.toString());
            } else {
                number.setNumber(4);
                text.setText(text.getText() + number.toString());
            }
        });
        buttons.get(Key.FIVE).setOnAction(actionEvent -> {
            if (secondOperand == true) {
                number2.setNumber(5);
                text.setText(text.getText() + number2.toString());
            } else {
                number.setNumber(5);
                text.setText(text.getText() + number.toString());
            }
        });
        buttons.get(Key.SIX).setOnAction(actionEvent -> {
            if (secondOperand == true) {
                number2.setNumber(6);
                text.setText(text.getText() + number2.toString());
            } else {
                number.setNumber(6);
                text.setText(text.getText() + number.toString());
            }
        });
    }

    public void action() {
        operationAction1();
        operationAction2();
        operationAction3();
        operationAction4();
        operationAction5();
        operationAction6();
        operationAction7();
    }

    enum Key {
        ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, CLEAR, DIVIDE, EQUAL, MINUS, MULTIPLY, PLUS
    }
}