package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label label_field;

    @FXML
    private Button but_clear;

    @FXML
    private Button but_plus_minus;

    @FXML
    private Button but_percent;

    @FXML
    private Button but_del;

    @FXML
    private Button but_7;

    @FXML
    private Button but_8;

    @FXML
    private Button but_9;

    @FXML
    private Button but_mult;

    @FXML
    private Button but_4;

    @FXML
    private Button but_5;

    @FXML
    private Button but_6;

    @FXML
    private Button but_minus;

    @FXML
    private Button but_1;

    @FXML
    private Button but_2;

    @FXML
    private Button but_0;

    @FXML
    private Button but_3;

    @FXML
    private Button but_comma;

    @FXML
    private Button but_plus;

    @FXML
    private Button but_equal;

    private String str_num = "";
    private float first_num;
    private char operation;

    @FXML
    void initialize() {
        but_0.setOnAction(event -> {
            addNumber(0);
        });
        but_1.setOnAction(event -> {
            addNumber(1);
        });
        but_2.setOnAction(event -> {
            addNumber(2);
        });
        but_3.setOnAction(event -> {
            addNumber(3);
        });
        but_4.setOnAction(event -> {
            addNumber(4);
        });
        but_5.setOnAction(event -> {
            addNumber(5);
        });
        but_6.setOnAction(event -> {
            addNumber(6);
        });
        but_7.setOnAction(event -> {
            addNumber(7);
        });
        but_8.setOnAction(event -> {
            addNumber(8);
        });
        but_9.setOnAction(event -> {
            addNumber(9);
        });
        but_plus.setOnAction(event -> {
            mathAction('+');
        });
        but_minus.setOnAction(event -> {
            mathAction('-');
        });
        but_del.setOnAction(event -> {
            mathAction('/');
        });
        but_mult.setOnAction(event -> {
            mathAction('*');
        });
        but_equal.setOnAction(event -> {
            if (this.operation == '+' || this.operation == '-' ||
                    this.operation == '/' || this.operation == '*')
                equalMethod();
        });
        but_comma.setOnAction(event -> {
            if(!this.str_num.contains(".")) {
                this.str_num += ".";
                label_field.setText(str_num);
            }
        });
        but_percent.setOnAction(event -> {
            if(this.str_num != "") {
                float num = Float.parseFloat(this.str_num) * 0.1f;
                this.str_num = Float.toString(num);
                label_field.setText(str_num);
            }
        });
        but_plus_minus.setOnAction(event -> {
            if(this.str_num != "") {
                float num = Float.parseFloat(this.str_num) * -1;
                this.str_num = Float.toString(num);
                label_field.setText(str_num);
            }
        });
        but_clear.setOnAction(event -> {
            label_field.setText("0");
            this.str_num = "";
            this.first_num = 0;
            this.operation = 'A';
        });
    }

    void equalMethod() {
        float res = 0;
        switch (this.operation){
            case '+':
                res = this.first_num + Float.parseFloat(this.str_num);
                break;
            case '-':
                res = this.first_num - Float.parseFloat(this.str_num);
                break;
            case '/':
                if(Integer.parseInt(this.str_num) != 0)
                    res = this.first_num / Float.parseFloat(this.str_num);
                else
                    res = 0;
                break;
            case '*':
                res = this.first_num * Float.parseFloat(this.str_num);
                break;
        }
        label_field.setText(Float.toString(res));
        this.str_num = "";
        this.operation = 'A';
        this.first_num = 0;
    }

    void mathAction(char operation) {
        if (this.operation != '+' && this.operation != '-' &&
                this.operation != '/' && this.operation != '*') {
            this.first_num = Integer.parseInt(this.str_num);
            label_field.setText(String.valueOf(operation));
            this.str_num = "";
            this.operation = operation;
        }
    }

    void addNumber(int number) {
        this.str_num += Integer.toString(number);
        label_field.setText(str_num);
    }
}

