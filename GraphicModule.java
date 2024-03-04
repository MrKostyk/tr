vpackage com.example.keytyper.Modules.Graphic;

import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.ArrayList;

public class GraphicModule {
    private final ArrayList<PointModule> pointList = new ArrayList<>();

    public void createGraphic() {

        Stage stage = new Stage();
        stage.setTitle("Mistakes");

        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Time");
        yAxis.setLabel("Mistakes");

        final LineChart <Number, Number> mistakesGraph = new LineChart<>(xAxis, yAxis);
        mistakesGraph.setTitle("Mistakes statistics");

        XYChart.Series series = new XYChart.Series();
        series.setName("Mistakes");

        for (PointModule point:pointList) {
            series.getData().add(new XYChart.Data(point.getMistTime(), point.getMistakes()));
        }

        Scene scene = new Scene(mistakesGraph, 800, 600);
        mistakesGraph.getData().add(series);

        stage.setScene(scene);
        stage.show();
    }

    public void addPointToList(PointModule point) {
        pointList.add(point);
    }
}