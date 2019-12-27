package model;

public class Workout_detailmodel {

    Integer image_1;
    String jump,number;

    public Integer getImage_1() {
        return image_1;
    }

    public void setImage_1(Integer image_1) {
        this.image_1 = image_1;
    }

    public String getJump() {
        return jump;
    }

    public void setJump(String jump) {
        this.jump = jump;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Workout_detailmodel(Integer image_1, String jump, String number) {
        this.image_1 = image_1;
        this.jump = jump;
        this.number = number;
    }
}
