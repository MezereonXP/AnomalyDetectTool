package com.anomalydetect.ReadJson;

public class Data {
    private String caiji_shijian;
    private double caiji_zhi;

    public Data() {}

    public Data(String caiji_shijian, double caiji_zhi) {
        this.caiji_shijian = caiji_shijian;
        this.caiji_zhi = caiji_zhi;
    }

    public double getCaiji_zhi() {
        return caiji_zhi;
    }

    public void setCaiji_zhi(double caiji_zhi) {
        this.caiji_zhi = caiji_zhi;
    }

    public String getCaiji_shijian() {
        return caiji_shijian;
    }

    public void setCaiji_shijian(String caiji_shijian) {
        this.caiji_shijian = caiji_shijian;
    }
}
