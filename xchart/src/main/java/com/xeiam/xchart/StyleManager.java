/**
 * Copyright (C) 2013 Xeiam LLC http://xeiam.com
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.xeiam.xchart;

import java.awt.Color;
import java.awt.Font;
import java.awt.Stroke;
import java.util.Locale;
import java.util.TimeZone;

import com.xeiam.xchart.internal.style.Theme;
import com.xeiam.xchart.internal.style.XChartTheme;

/**
 * The StyleManager is used to manage all things related to styling of the vast number of Chart components
 * 
 * @author timmolter
 */
public class StyleManager {

  public enum ChartType {

    Line, Scatter, Area, Bar
  }

  public enum LegendPosition {

    OutsideE, InsideNW, InsideNE, InsideSE, InsideSW
  }

  public enum ChartTheme {

    XChart, GGPlot2, Matlab
  }

  /** the default Theme */
  private Theme theme = new XChartTheme();

  // Chart Style ///////////////////////////////
  private ChartType chartType;
  private Color chartBackgroundColor;
  public Color chartFontColor;
  private int chartPadding;

  // Chart Title ///////////////////////////////
  private Font chartTitleFont;
  private boolean isChartTitleVisible;
  private boolean isChartTitleBoxVisible;
  private Color chartTitleBoxBackgroundColor;
  private Color chartTitleBoxBorderColor;
  private int chartTitlePadding;

  // Chart Legend ///////////////////////////////
  private boolean isLegendVisible;
  private Color legendBackgroundColor;
  private Color legendBorderColor;
  private Font legendFont;
  private int legendPadding;
  private LegendPosition legendPosition;

  // Chart Axes ///////////////////////////////
  private boolean xAxisTitleVisible;
  private boolean yAxisTitleVisible;
  private Font axisTitleFont;
  private boolean xAxisTicksVisible;
  private boolean yAxisTicksVisible;
  private Font axisTickLabelsFont;
  private int axisTickMarkLength;
  private int axisTickPadding;
  private Color axisTickMarksColor;
  private Stroke axisTickMarksStroke;
  private Color axisTickLabelsColor;
  private boolean isAxisTicksLineVisible;
  private boolean isAxisTicksMarksVisible;
  private int plotPadding;
  private int axisTitlePadding;
  private boolean isXAxisLogarithmic;
  private boolean isYAxisLogarithmic;
  private Double xAxisMin;
  private Double xAxisMax;
  private Double yAxisMin;
  private Double yAxisMax;

  // Chart Plot Area ///////////////////////////////
  private boolean isPlotGridLinesVisible;
  private Color plotBackgroundColor;
  private Color plotBorderColor;
  private boolean isPlotBorderVisible;
  private boolean isPlotTicksMarksVisible;
  private Color plotGridLinesColor;
  private Stroke plotGridLinesStroke;

  // Error Bars ///////////////////////////////
  private Color errorBarsColor;

  // Formatting ////////////////////////////////
  private String datePattern;
  private Locale locale;
  private TimeZone timezone;
  private String normalDecimalPattern;
  private String scientificDecimalPattern;

  /**
   * Constructor
   */
  public StyleManager() {

    setAllStyles();
  }

  private void setAllStyles() {

    // Chart Style ///////////////////////////////
    chartType = ChartType.Line;
    chartBackgroundColor = theme.getChartBackgroundColor();
    chartFontColor = theme.getChartFontColor();
    chartPadding = theme.getChartPadding();

    // Chart Title ///////////////////////////////
    chartTitleFont = theme.getChartTitleFont();
    isChartTitleVisible = theme.isChartTitleVisible();
    isChartTitleBoxVisible = theme.isChartTitleBoxVisible();
    chartTitleBoxBackgroundColor = theme.getChartTitleBoxBackgroundColor();
    chartTitleBoxBorderColor = theme.getChartTitleBoxBorderColor();
    chartTitlePadding = theme.getChartTitlePadding();

    // legend
    isLegendVisible = theme.isLegendVisible();
    legendBackgroundColor = theme.getLegendBackgroundColor();
    legendBorderColor = theme.getLegendBorderColor();
    legendFont = theme.getLegendFont();
    legendPadding = theme.getLegendPadding();
    legendPosition = theme.getLegendPosition();

    // axes
    xAxisTitleVisible = theme.isXAxisTitleVisible();
    yAxisTitleVisible = theme.isYAxisTitleVisible();
    axisTitleFont = theme.getAxisTitleFont();
    xAxisTicksVisible = theme.isXAxisTicksVisible();
    yAxisTicksVisible = theme.isYAxisTicksVisible();
    axisTickLabelsFont = theme.getAxisTickLabelsFont();
    axisTickMarkLength = theme.getAxisTickMarkLength();
    axisTickPadding = theme.getAxisTickPadding();
    axisTickMarksColor = theme.getAxisTickMarksColor();
    axisTickMarksStroke = theme.getAxisTickMarksStroke();
    axisTickLabelsColor = theme.getAxisTickLabelsColor();
    isAxisTicksLineVisible = theme.isAxisTicksLineVisible();
    isAxisTicksMarksVisible = theme.isAxisTicksMarksVisible();
    plotPadding = theme.getPlotPadding();
    axisTitlePadding = theme.getAxisTitlePadding();
    isXAxisLogarithmic = false;
    isYAxisLogarithmic = false;
    xAxisMin = null;
    xAxisMax = null;
    yAxisMin = null;
    yAxisMax = null;

    // Chart Plot Area ///////////////////////////////
    isPlotGridLinesVisible = theme.isPlotGridLinesVisible();
    plotBackgroundColor = theme.getPlotBackgroundColor();
    plotBorderColor = theme.getPlotBorderColor();
    isPlotBorderVisible = theme.isPlotBorderVisible();
    isPlotTicksMarksVisible = theme.isPlotTicksMarksVisible();
    plotGridLinesColor = theme.getPlotGridLinesColor();
    plotGridLinesStroke = theme.getPlotGridLinesStroke();

    // Error Bars ///////////////////////////////
    errorBarsColor = theme.getErrorBarsColor();

    // Formatting ////////////////////////////////
    datePattern = null; // if not null, this override pattern will be used
    locale = Locale.getDefault();
    timezone = TimeZone.getDefault();
    normalDecimalPattern = "#.####";
    scientificDecimalPattern = "0.##E0";
  }

  /**
   * Set the theme the style manager should use
   * 
   * @param theme
   */
  protected void setTheme(Theme theme) {

    this.theme = theme;
    setAllStyles();
  }

  public Theme getTheme() {

    return theme;
  }

  // Chart Style ///////////////////////////////

  /**
   * sets the Chart Type
   * 
   * @param chartType
   */
  public void setChartType(ChartType chartType) {

    this.chartType = chartType;
  }

  public ChartType getChartType() {

    return chartType;
  }

  /**
   * Set the chart background color - the part around the edge of the chart
   * 
   * @param color
   */
  public void setChartBackgroundColor(Color color) {

    this.chartBackgroundColor = color;
  }

  public Color getChartBackgroundColor() {

    return chartBackgroundColor;
  }

  /**
   * Set the chart font color. includes: Chart title, axes label, legend
   * 
   * @param color
   */
  public void setChartFontColor(Color color) {

    this.chartFontColor = color;
  }

  public Color getChartFontColor() {

    return chartFontColor;
  }

  /**
   * Set the chart padding
   * 
   * @param chartPadding
   */
  public void setChartPadding(int chartPadding) {

    this.chartPadding = chartPadding;
  }

  public int getChartPadding() {

    return chartPadding;
  }

  // Chart Title ///////////////////////////////

  /**
   * Set the chart title font
   * 
   * @param font
   */
  public void setChartTitleFont(Font chartTitleFont) {

    this.chartTitleFont = chartTitleFont;
  }

  public Font getChartTitleFont() {

    return chartTitleFont;
  }

  /**
   * Set the chart title visibility
   * 
   * @param isChartTitleVisible
   */
  public void setChartTitleVisible(boolean isChartTitleVisible) {

    this.isChartTitleVisible = isChartTitleVisible;
  }

  public boolean isChartTitleVisible() {

    return isChartTitleVisible;
  }

  /**
   * Set the chart title box visibility
   * 
   * @param isChartTitleBoxVisible
   */
  public void setChartTitleBoxVisible(boolean isChartTitleBoxVisible) {

    this.isChartTitleBoxVisible = isChartTitleBoxVisible;
  }

  public boolean isChartTitleBoxVisible() {

    return isChartTitleBoxVisible;
  }

  /**
   * set the chart title box background color
   * 
   * @param chartTitleBoxBackgroundColor
   */
  public void setChartTitleBoxBackgroundColor(Color chartTitleBoxBackgroundColor) {

    this.chartTitleBoxBackgroundColor = chartTitleBoxBackgroundColor;
  }

  public Color getChartTitleBoxBackgroundColor() {

    return chartTitleBoxBackgroundColor;
  }

  /**
   * set the chart title box border color
   * 
   * @param chartTitleBoxBorderColor
   */
  public void setChartTitleBoxBorderColor(Color chartTitleBoxBorderColor) {

    this.chartTitleBoxBorderColor = chartTitleBoxBorderColor;
  }

  public Color getChartTitleBoxBorderColor() {

    return chartTitleBoxBorderColor;
  }

  /**
   * set the chart title padding; the space between the chart title and the plot area
   * 
   * @param chartTitlePadding
   */
  public void setChartTitlePadding(int chartTitlePadding) {

    this.chartTitlePadding = chartTitlePadding;
  }

  public int getChartTitlePadding() {

    return chartTitlePadding;
  }

  // Chart Legend ///////////////////////////////

  /**
   * Set the chart legend background color
   * 
   * @param color
   */
  public void setLegendBackgroundColor(Color color) {

    this.legendBackgroundColor = color;
  }

  public Color getLegendBackgroundColor() {

    return legendBackgroundColor;
  }

  /**
   * Set the chart legend border color
   * 
   * @return
   */
  public Color getLegendBorderColor() {

    return legendBorderColor;
  }

  public void setLegendBorderColor(Color legendBorderColor) {

    this.legendBorderColor = legendBorderColor;
  }

  /**
   * Set the chart legend font
   * 
   * @param font
   */
  public void setLegendFont(Font font) {

    this.legendFont = font;
  }

  public Font getLegendFont() {

    return legendFont;
  }

  /**
   * Set the chart legend visibility
   * 
   * @param isLegendVisible
   */
  public void setLegendVisible(boolean isLegendVisible) {

    this.isLegendVisible = isLegendVisible;
  }

  public boolean isLegendVisible() {

    return isLegendVisible;
  }

  /**
   * Set the chart legend padding
   * 
   * @param legendPadding
   */
  public void setLegendPadding(int legendPadding) {

    this.legendPadding = legendPadding;
  }

  public int getLegendPadding() {

    return legendPadding;
  }

  /**
   * sets the legend position
   * 
   * @param legendPosition
   */
  public void setLegendPosition(LegendPosition legendPosition) {

    this.legendPosition = legendPosition;
  }

  public LegendPosition getLegendPosition() {

    return legendPosition;
  }

  // Chart Axes ///////////////////////////////

  /**
   * Set the x-axis title visibility
   * 
   * @param isVisible
   */
  public void setXAxisTitleVisible(boolean xAxisTitleVisible) {

    this.xAxisTitleVisible = xAxisTitleVisible;
  }

  public boolean isXAxisTitleVisible() {

    return xAxisTitleVisible;
  }

  /**
   * Set the y-axis title visibility
   * 
   * @param isVisible
   */
  public void setYAxisTitleVisible(boolean yAxisTitleVisible) {

    this.yAxisTitleVisible = yAxisTitleVisible;
  }

  public boolean isYAxisTitleVisible() {

    return yAxisTitleVisible;
  }

  /**
   * Set the x- and y-axis titles visibility
   * 
   * @param isVisible
   */
  public void setAxisTitlesVisible(boolean isVisible) {

    this.xAxisTitleVisible = isVisible;
    this.yAxisTitleVisible = isVisible;
  }

  /**
   * Set the x- and y-axis title font
   * 
   * @param axisTitleFont
   */
  public void setAxisTitleFont(Font axisTitleFont) {

    this.axisTitleFont = axisTitleFont;
  }

  public Font getAxisTitleFont() {

    return axisTitleFont;
  }

  /**
   * Set the x-axis tick marks and labels visibility
   * 
   * @param isVisible
   */

  public void setXAxisTicksVisible(boolean xAxisTicksVisible) {

    this.xAxisTicksVisible = xAxisTicksVisible;
  }

  public boolean isXAxisTicksVisible() {

    return xAxisTicksVisible;
  }

  /**
   * Set the y-axis tick marks and labels visibility
   * 
   * @param isVisible
   */

  public void setYAxisTicksVisible(boolean yAxisTicksVisible) {

    this.yAxisTicksVisible = yAxisTicksVisible;
  }

  public boolean isYAxisTicksVisible() {

    return yAxisTicksVisible;
  }

  /**
   * Set the x- and y-axis tick marks and labels visibility
   * 
   * @param isVisible
   */
  public void setAxisTicksVisible(boolean isVisible) {

    this.xAxisTicksVisible = isVisible;
    this.yAxisTicksVisible = isVisible;
  }

  /**
   * Set the x- and y-axis tick label font
   * 
   * @param foxAxisTicksFontnt
   */
  public void setAxisTickLabelsFont(Font axisTicksFont) {

    this.axisTickLabelsFont = axisTicksFont;
  }

  public Font getAxisTickLabelsFont() {

    return axisTickLabelsFont;
  }

  /**
   * set the axis tick mark length
   * 
   * @param axisTickMarkLength
   */
  public void setAxisTickMarkLength(int axisTickMarkLength) {

    this.axisTickMarkLength = axisTickMarkLength;
  }

  public int getAxisTickMarkLength() {

    return axisTickMarkLength;
  }

  /**
   * sets the padding between the tick labels and the tick marks
   * 
   * @param axisTickPadding
   */
  public void setAxisTickPadding(int axisTickPadding) {

    this.axisTickPadding = axisTickPadding;
  }

  public int getAxisTickPadding() {

    return axisTickPadding;
  }

  /**
   * sets the axis tick mark color
   * 
   * @param axisTickColor
   */
  public void setAxisTickMarksColor(Color axisTickColor) {

    this.axisTickMarksColor = axisTickColor;
  }

  public Color getAxisTickMarksColor() {

    return axisTickMarksColor;
  }

  /**
   * sets the axis tick marks Stroke
   * 
   * @param axisTickMarksStroke
   */
  public void setAxisTickMarksStroke(Stroke axisTickMarksStroke) {

    this.axisTickMarksStroke = axisTickMarksStroke;
  }

  public Stroke getAxisTickMarksStroke() {

    return axisTickMarksStroke;
  }

  /**
   * sets the axis tick label color
   * 
   * @param axisTickLabelsColor
   */
  public void setAxisTickLabelsColor(Color axisTickLabelsColor) {

    this.axisTickLabelsColor = axisTickLabelsColor;
  }

  public Color getAxisTickLabelsColor() {

    return axisTickLabelsColor;
  }

  /**
   * sets the visibility of the line parallel to the plot edges that go along with the tick marks
   * 
   * @param isAxisTicksLineVisible
   */
  public void setAxisTicksLineVisible(boolean isAxisTicksLineVisible) {

    this.isAxisTicksLineVisible = isAxisTicksLineVisible;
  }

  public boolean isAxisTicksLineVisible() {

    return isAxisTicksLineVisible;
  }

  /**
   * sets the visibility of the tick marks
   * 
   * @param isAxisTicksMarksVisible
   */
  public void setAxisTicksMarksVisible(boolean isAxisTicksMarksVisible) {

    this.isAxisTicksMarksVisible = isAxisTicksMarksVisible;
  }

  public boolean isAxisTicksMarksVisible() {

    return isAxisTicksMarksVisible;
  }

  /**
   * sets the padding between the tick marks and the plot area
   * 
   * @param plotPadding
   */
  public void setPlotPadding(int plotPadding) {

    this.plotPadding = plotPadding;
  }

  public int getPlotPadding() {

    return plotPadding;
  }

  /**
   * sets the padding between the axis title and the tick labels
   * 
   * @param axisTitlePadding
   */
  public void setAxisTitlePadding(int axisTitlePadding) {

    this.axisTitlePadding = axisTitlePadding;
  }

  public int getAxisTitlePadding() {

    return axisTitlePadding;
  }

  /**
   * sets the X-Axis to be rendered with a logarithmic scale or not
   * 
   * @param isxAxisLogarithmic
   */
  public void setXAxisLogarithmic(boolean isXAxisLogarithmic) {

    this.isXAxisLogarithmic = isXAxisLogarithmic;
  }

  public boolean isXAxisLogarithmic() {

    return isXAxisLogarithmic;
  }

  /**
   * sets the Y-Axis to be rendered with a logarithmic scale or not
   * 
   * @param isyAxisLogarithmic
   */
  public void setYAxisLogarithmic(boolean isYAxisLogarithmic) {

    this.isYAxisLogarithmic = isYAxisLogarithmic;
  }

  public boolean isYAxisLogarithmic() {

    return isYAxisLogarithmic;
  }

  public void setXAxisMin(double xAxisMin) {

    this.xAxisMin = xAxisMin;
  }

  public Double getXAxisMin() {

    return xAxisMin;
  }

  public void setXAxisMax(double xAxisMax) {

    this.xAxisMax = xAxisMax;
  }

  public Double getXAxisMax() {

    return xAxisMax;
  }

  public void setYAxisMin(double yAxisMin) {

    this.yAxisMin = yAxisMin;
  }

  public Double getYAxisMin() {

    return yAxisMin;
  }

  public void setYAxisMax(double yAxisMax) {

    this.yAxisMax = yAxisMax;
  }

  public Double getYAxisMax() {

    return yAxisMax;
  }

  // Chart Plot Area ///////////////////////////////

  /**
   * sets the visibility of the gridlines on the plot area
   * 
   * @param isPlotGridLinesVisible
   */
  public void setPlotGridLinesVisible(boolean isPlotGridLinesVisible) {

    this.isPlotGridLinesVisible = isPlotGridLinesVisible;
  }

  public boolean isPlotGridLinesVisible() {

    return isPlotGridLinesVisible;
  }

  /**
   * set the plot area's background color
   * 
   * @param plotBackgroundColor
   */
  public void setPlotBackgroundColor(Color plotBackgroundColor) {

    this.plotBackgroundColor = plotBackgroundColor;
  }

  public Color getPlotBackgroundColor() {

    return plotBackgroundColor;
  }

  /**
   * set the plot area's border color
   * 
   * @param plotBorderColor
   */
  public void setPlotBorderColor(Color plotBorderColor) {

    this.plotBorderColor = plotBorderColor;
  }

  public Color getPlotBorderColor() {

    return plotBorderColor;
  }

  /**
   * sets the visibility of the border around the plot area
   * 
   * @param isPlotBorderVisible
   */
  public void setPlotBorderVisible(boolean isPlotBorderVisible) {

    this.isPlotBorderVisible = isPlotBorderVisible;
  }

  public boolean isPlotBorderVisible() {

    return isPlotBorderVisible;
  }

  /**
   * sets the visibility of the ticks marks inside the plot area
   * 
   * @param isPlotTicksMarksVisible
   */
  public void setPlotTicksMarksVisible(boolean isPlotTicksMarksVisible) {

    this.isPlotTicksMarksVisible = isPlotTicksMarksVisible;
  }

  public boolean isPlotTicksMarksVisible() {

    return isPlotTicksMarksVisible;
  }

  /**
   * set the plot area's grid lines color
   * 
   * @param plotGridLinesColor
   */
  public void setPlotGridLinesColor(Color plotGridLinesColor) {

    this.plotGridLinesColor = plotGridLinesColor;
  }

  public Color getPlotGridLinesColor() {

    return plotGridLinesColor;
  }

  /**
   * set the plot area's grid lines Stroke
   * 
   * @param plotGridLinesStroke
   */
  public void setPlotGridLinesStroke(Stroke plotGridLinesStroke) {

    this.plotGridLinesStroke = plotGridLinesStroke;
  }

  public Stroke getPlotGridLinesStroke() {

    return plotGridLinesStroke;
  }

  // Error Bars ///////////////////////////////

  /**
   * Sets the color of the error bars
   * 
   * @param errorBarsColor
   */
  public void setErrorBarsColor(Color errorBarsColor) {

    this.errorBarsColor = errorBarsColor;
  }

  public Color getErrorBarsColor() {

    return errorBarsColor;
  }

  // Formatting ////////////////////////////////

  /**
   * Set the String formatter for Data x-axis
   * 
   * @param pattern - the pattern describing the date and time format
   */
  public void setDatePattern(String datePattern) {

    this.datePattern = datePattern;
  }

  public String getDatePattern() {

    return datePattern;
  }

  /**
   * Set the locale to use for rendering the chart
   * 
   * @param locale - the locale to use when formatting Strings and dates for the axis tick labels
   */
  public void setLocale(Locale locale) {

    this.locale = locale;
  }

  public Locale getLocale() {

    return locale;
  }

  /**
   * Set the timezone to use for formatting Date axis tick labels
   * 
   * @param timezone the timezone to use when formatting date data
   */
  public void setTimezone(TimeZone timezone) {

    this.timezone = timezone;
  }

  public TimeZone getTimezone() {

    return timezone;
  }

  /**
   * Set the decimal formatter for all tick labels
   * 
   * @param pattern - the pattern describing the decimal format
   */
  public void setNormalDecimalPattern(String normalDecimalPattern) {

    this.normalDecimalPattern = normalDecimalPattern;
  }

  public String getNormalDecimalPattern() {

    return normalDecimalPattern;
  }

  /**
   * Set the scientific notation formatter for all tick labels
   * 
   * @param pattern - the pattern describing the scientific notation format
   */
  public void setScientificDecimalPattern(String scientificDecimalPattern) {

    this.scientificDecimalPattern = scientificDecimalPattern;
  }

  public String getScientificDecimalPattern() {

    return scientificDecimalPattern;
  }
}