/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goran.util;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import java.awt.Color;
import java.time.LocalDate;
import java.util.Locale;

/**
 *
 * @author Goran
 */
public class MyDatePicker extends DatePicker {

    public MyDatePicker() {

        this.setLocale(new Locale("hr"));
        this.getSettings().setFormatForDatesCommonEra("dd.MM.yyyy");
        this.getSettings().setDateRangeLimits(LocalDate.now(), LocalDate.MAX);
        this.setDateToToday();

        this.getComponentToggleCalendarButton().setText("");
        this.getComponentToggleCalendarButton()
                .setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/btn_calendar.png")));

        applyTheme();

    }

    public void applyTheme() {

        this.setBackground(Theme.color2);

        this.getSettings().setColor(DatePickerSettings.DateArea.TextFieldBackgroundValidDate, Theme.color4);
        this.getSettings().setColor(DatePickerSettings.DateArea.BackgroundOverallCalendarPanel, Theme.color2);
        this.getSettings().setColor(DatePickerSettings.DateArea.CalendarTextNormalDates, Theme.font1);
        this.getSettings().setColor(DatePickerSettings.DateArea.BackgroundMonthAndYearNavigationButtons, Theme.color3);
        this.getSettings().setColor(DatePickerSettings.DateArea.CalendarBackgroundNormalDates, Theme.color4);
        this.getSettings().setColor(DatePickerSettings.DateArea.TextMonthAndYearMenuLabels, Color.WHITE);
        this.getSettings().setColor(DatePickerSettings.DateArea.TextMonthAndYearNavigationButtons, Color.WHITE);
        this.getSettings().setColor(DatePickerSettings.DateArea.TextTodayLabel, Color.WHITE);
        this.getSettings().setColor(DatePickerSettings.DateArea.BackgroundMonthAndYearMenuLabels, Theme.color2);
        this.getSettings().setColor(DatePickerSettings.DateArea.BackgroundTopLeftLabelAboveWeekNumbers, Theme.color2);
        this.getSettings().setColor(DatePickerSettings.DateArea.BackgroundTodayLabel, Theme.color2);
        this.getSettings().setColor(DatePickerSettings.DateArea.TextClearLabel, Color.WHITE);
        this.getSettings().setColor(DatePickerSettings.DateArea.BackgroundClearLabel, Theme.color2);
        this.getSettings().setColorBackgroundWeekNumberLabels(Theme.color2, false);
        this.getSettings().setColorBackgroundWeekdayLabels(Theme.color2, false);

        this.getSettings().setColor(DatePickerSettings.DateArea.DatePickerTextValidDate, Theme.font1);
        this.getSettings().setColor(DatePickerSettings.DateArea.CalendarTextWeekdays, Color.WHITE);
        this.getSettings().setFontValidDate(new java.awt.Font("Lucida Sans", 0, 15));
        this.getSettings().setFontCalendarDateLabels(new java.awt.Font("Lucida Sans", 0, 15));
        this.getSettings().setFontCalendarWeekNumberLabels(new java.awt.Font("Lucida Sans", 0, 15));
        this.getSettings().setFontCalendarWeekdayLabels(new java.awt.Font("Lucida Sans", 0, 15));
        this.getSettings().setFontClearLabel(new java.awt.Font("Lucida Sans", 0, 15));
        this.getSettings().setFontMonthAndYearMenuLabels(new java.awt.Font("Lucida Sans", 0, 15));
        this.getSettings().setFontTodayLabel(new java.awt.Font("Lucida Sans", 0, 15));
        this.getSettings().setColorBackgroundWeekNumberLabels(Theme.color2, false);
        this.getSettings().setColorBackgroundWeekdayLabels(Theme.color2, false);

        this.getComponentToggleCalendarButton().setBackground(Theme.color3);

    }

}
