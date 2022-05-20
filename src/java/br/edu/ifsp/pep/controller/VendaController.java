/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.VendaDAO;
import br.edu.ifsp.pep.model.Venda;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.axes.cartesian.CartesianScales;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearAxes;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearTicks;
import org.primefaces.model.charts.bar.BarChartDataSet;
import org.primefaces.model.charts.bar.BarChartModel;
import org.primefaces.model.charts.bar.BarChartOptions;
import org.primefaces.model.charts.optionconfig.animation.Animation;
import org.primefaces.model.charts.optionconfig.legend.Legend;
import org.primefaces.model.charts.optionconfig.legend.LegendLabel;
import org.primefaces.model.charts.optionconfig.title.Title;

/**
 *
 * @author aluno
 */
@Named
@RequestScoped
public class VendaController {
    
    private BarChartModel barModel;
    
    @Inject
    private VendaDAO vendaDAO;
    
    
    
    

    public BarChartModel getBarModel() {
        return barModel;
    }
    
    
    public void lista(){
        
        for(Venda venda : vendaDAO.findAll()){
            System.out.println(venda);
        }
    }
    
    public void gerarGraficoVendaPorMes(){
        
        // cria um dataset
        barModel = new BarChartModel();
        ChartData data = new ChartData();

        BarChartDataSet barDataSet = new BarChartDataSet();
        
        // Label da legenda
        barDataSet.setLabel("Vendas Por Mes");

        // Valores de vendas pra cada mês.
        List<Number> values = new ArrayList<>();
        values.add(65);
        values.add(59);
        values.add(80);
        values.add(81);
        values.add(56);
        values.add(55);
        values.add(40);
        
        // Atribui os valores de vendas ao dataset
        barDataSet.setData(values);

        
        List<String> bgColor = new ArrayList<>();
        bgColor.add("rgb(255, 99, 132)");

        
        barDataSet.setBackgroundColor(bgColor);

        List<String> borderColor = new ArrayList<>();
        borderColor.add("rgb(255, 99, 132)");
        
        barDataSet.setBorderColor(borderColor);
        barDataSet.setBorderWidth(1);


        // Atribui o dataset aos dados do grafico
        data.addChartDataSet(barDataSet);
        
        barDataSet = new BarChartDataSet();
        
        // Label da legenda
        barDataSet.setLabel("Despesas");

        // Valores de vendas pra cada mês.
        values = new ArrayList<>();
        values.add(35);
        values.add(79);
        values.add(10);
        values.add(71);
        values.add(36);
        values.add(45);
        values.add(30);
        
        // Atribui os valores de vendas ao dataset
        barDataSet.setData(values);

        
        bgColor = new ArrayList<>();
        bgColor.add("rgb(255, 159, 64)");
        
        barDataSet.setBackgroundColor(bgColor);

        borderColor = new ArrayList<>();
        borderColor.add("rgb(255, 159, 64)");
        
        barDataSet.setBorderColor(borderColor);
        barDataSet.setBorderWidth(1);


        // Atribui o dataset aos dados do grafico
        data.addChartDataSet(barDataSet);

        List<String> labels = new ArrayList<>();
        labels.add("Janeiro");
        labels.add("Fevereiro");
        labels.add("Março");
        labels.add("Abril");
        labels.add("Maio");
        labels.add("Junho");
        labels.add("Julho");
        
        data.setLabels(labels);
        
        // Atribui os dados ao gráfico
        barModel.setData(data);
        
         //Options
        BarChartOptions options = new BarChartOptions();
        CartesianScales cScales = new CartesianScales();
        CartesianLinearAxes linearAxes = new CartesianLinearAxes();
        linearAxes.setOffset(true);
        CartesianLinearTicks ticks = new CartesianLinearTicks();
        ticks.setBeginAtZero(true);
        linearAxes.setTicks(ticks);
        cScales.addYAxesData(linearAxes);
        options.setScales(cScales);

        Title title = new Title();
        title.setDisplay(true);
        title.setText("Venda Mes");
        options.setTitle(title);

        Legend legend = new Legend();
        legend.setDisplay(true);
        legend.setPosition("right");
        LegendLabel legendLabels = new LegendLabel();
        legendLabels.setFontStyle("bold");
        legendLabels.setFontColor("#111111");
        legendLabels.setFontSize(22);
        legend.setLabels(legendLabels);
        options.setLegend(legend);

        // disable animation
//        Animation animation = new Animation();
//        animation.setDuration(0);
//        options.setAnimation(animation);

        barModel.setOptions(options);
        
    }

    
    
    public VendaController() {
        vendaDAO = new VendaDAO();
        
        this.gerarGraficoVendaPorMes();
        
        
        
    }
    
    
    
    
}
