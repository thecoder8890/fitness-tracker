package model;

import android.widget.FrameLayout;
import android.widget.ImageView;

public class Home_model {

    Integer full_body;
    String text_body;

    public Integer getFull_body() {
        return full_body;
    }

    public void setFull_body(Integer full_body) {
        this.full_body = full_body;
    }

    public String getText_body() {
        return text_body;
    }

    public void setText_body(String text_body) {
        this.text_body = text_body;
    }

    public Home_model(Integer full_body, String text_body) {
        this.full_body = full_body;
        this.text_body = text_body;
    }
}
