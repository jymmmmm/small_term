package teleDemo.entities;

import java.io.Serializable;
import java.sql.Date;

public class tbInfo implements Serializable{
    private int id;
    private int asu;
    private String cid;
    private Date dateTime;
    private int dbm;
    private String lac;
    private double lat;
    private double lon;
    private int userId;
    private String netSpeed;
    private  int unreadSms;
    private  int wifiCount;
    private String wifiInfo;

    public tbInfo(int id, int asu, String cid, Date dateTime, int dbm, String lac, double lat, double lon, int userId, String netSpeed, int unreadSms, int wifiCount, String wifiInfo){
        this.id=id;
        this.asu=asu;
        this.cid=cid;
        this.dateTime=dateTime;
        this.dbm=dbm;
        this.lac=lac;
        this.lat=lat;
        this.lon=lon;
        this.userId=userId;
        this.netSpeed=netSpeed;
        this.unreadSms=unreadSms;
        this.wifiCount=wifiCount;
        this.wifiInfo=wifiInfo;
    }
    public tbInfo(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAsu() {
        return asu;
    }

    public void setAsu(int asu) {
        this.asu = asu;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public int getDbm() {
        return dbm;
    }

    public void setDbm(int dbm) {
        this.dbm = dbm;
    }

    public String getLac() {
        return lac;
    }

    public void setLac(String lac) {
        this.lac = lac;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getNetSpeed() {
        return netSpeed;
    }

    public void setNetSpeed(String netSpeed) {
        this.netSpeed = netSpeed;
    }

    public int getUnreadSms() {
        return unreadSms;
    }

    public void setUnreadSms(int unreadSms) {
        this.unreadSms = unreadSms;
    }

    public int getWifiCount() {
        return wifiCount;
    }

    public void setWifiCount(int wifiCount) {
        this.wifiCount = wifiCount;
    }

    public String getWifiInfo() {
        return wifiInfo;
    }

    public void setWifiInfo(String wifiInfo) {
        this.wifiInfo = wifiInfo;
    }
}
