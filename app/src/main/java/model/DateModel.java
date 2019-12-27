package model;

public class DateModel {
    String date,day;
    Boolean selected;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public DateModel(String date, Boolean selected,String day) {
        this.day = day;
        this.date = date;
        this.selected = selected;
    }
}
