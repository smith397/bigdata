package com.zj.data.Enum;

public enum Status {

    yanzhongyongdu("严重拥堵",4),
    yongdu("拥堵",3),
    huanxing("缓行",2),
    changtong("畅通",1);

    private String Status;
    private int num;
    // 构造方法
    private Status(String Status, int num) {
        this.Status = Status;
        this.num = num;
    }

    public String getStatus () {
        return Status;
    }

    public void setStatus (String status) {
        Status = status;
    }

    public int getNum () {
        return num;
    }

    public void setNum (int num) {
        this.num = num;
    }
}
