package model;

import java.util.Date;

public class AssistiveDeviceInstance {
    private int id;
    private String barcode;
    private Date registeredDate;
    private String note;

    public AssistiveDeviceInstance(String barcode, Date registeredDate, String note) {
        this.barcode = barcode;
        this.registeredDate = registeredDate;
        this.note = note;
    }
    
    public AssistiveDeviceInstance(int id, String barcode, Date registeredDate, String note) {
        this(barcode, registeredDate, note);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    @Override
    public String toString() {
    	String res = getBarcode() + " - " + getRegisteredDate() + " - " + getNote();
    	return res;
    }

}