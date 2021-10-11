package HomeWork07.classes;

/**
 * Класс лист для ответа сервера
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 11.10.2021
 */

public class List {
    private float dt;
    Main MainObject;
//    ArrayList < Object > weather = new ArrayList < Object > ();
//    Clouds CloudsObject;
//    Wind WindObject;
    private float visibility;
    private float pop;
//    Sys SysObject;
    private String dt_txt;


    // Getter Methods

    public float getDt() {
        return dt;
    }

    public Main getMain() {
        return MainObject;
    }

//    public Clouds getClouds() {
//        return CloudsObject;
//    }

//    public Wind getWind() {
//        return WindObject;
//    }

    public float getVisibility() {
        return visibility;
    }

    public float getPop() {
        return pop;
    }

//    public Sys getSys() {
//        return SysObject;
//    }

    public String getDt_txt() {
        return dt_txt;
    }

    // Setter Methods

    public void setDt(float dt) {
        this.dt = dt;
    }

    public void setMain(Main mainObject) {
        this.MainObject = mainObject;
    }

//    public void setClouds(Clouds cloudsObject) {
//        this.CloudsObject = cloudsObject;
//    }
//
//    public void setWind(Wind windObject) {
//        this.WindObject = windObject;
//    }

    public void setVisibility(float visibility) {
        this.visibility = visibility;
    }

    public void setPop(float pop) {
        this.pop = pop;
    }

//    public void setSys(Sys sysObject) {
//        this.SysObject = sysObject;
//    }

    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
    }
}
