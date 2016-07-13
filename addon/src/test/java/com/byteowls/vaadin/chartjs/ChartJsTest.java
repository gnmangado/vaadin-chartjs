package com.byteowls.vaadin.chartjs;

import org.junit.Assert;
import org.junit.Test;

import com.byteowls.vaadin.chartjs.config.LineChartConfig;
import com.byteowls.vaadin.chartjs.data.LineDataset;
import com.byteowls.vaadin.chartjs.options.AnimationEasing;
import com.byteowls.vaadin.chartjs.options.HoverOptions;
import com.byteowls.vaadin.chartjs.options.TitleOptions;
import com.byteowls.vaadin.chartjs.options.TooltipsOptions;
import com.byteowls.vaadin.chartjs.options.scale.Axis;
import com.byteowls.vaadin.chartjs.options.scale.BaseScale;
import com.byteowls.vaadin.chartjs.options.scale.LinearScale;
import com.byteowls.vaadin.chartjs.options.scale.LogarithmicScale;

import elemental.json.JsonValue;

/**
 * @author michael@team-conductor.com
 */
public class ChartJsTest {

    @Test
    public void testConfigGeneral() {

        LineChartConfig config = new LineChartConfig();
        config
            .data()
                .labels("A", "B", "C")
                .addDataset(new LineDataset().fill(true).label("Dataset 1").data(1D, 2D, 3D))
                .addDataset(new LineDataset().label("Set 2").data(3.3, 1.3, 2.9))
              .and()
            .options()
                .events("test", "test1")
                .showLines(true)
                .responsive(true)
                .hover()
                .mode(HoverOptions.Mode.SINGLE)
                .and()
            .title()
                .display(true)
                .position(TitleOptions.Position.TOP)
                .text("Hello World")
                .and()
            .animation()
                .easing(AnimationEasing.easeOutQuart)
                .and()
            .tooltips()
                .mode(TooltipsOptions.Mode.LABEL)
                .and()
            .scales()
                .add(Axis.X, new LinearScale().position(BaseScale.Position.TOP))
                .add(Axis.Y, new LogarithmicScale().position(BaseScale.Position.LEFT))
                .and()
            .tooltips()
                .mode(TooltipsOptions.Mode.LABEL)
                .and()
            .done();

        JsonValue jsonValue = config.buildJson();
        Assert.assertNotNull(jsonValue);
    }

}