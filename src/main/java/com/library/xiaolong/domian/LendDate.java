package com.library.xiaolong.domian;

public class LendDate extends Lend {
    private String lendDateStr;
    private String backDateStr;

    public String getLendDateStr() {
        return lendDateStr;
    }

    public void setLendDateStr(String lendDateStr) {
        this.lendDateStr = lendDateStr;
    }

    public String getBackDateStr() {
        return backDateStr;
    }

    public void setBackDateStr(String backDateStr) {
        this.backDateStr = backDateStr;
    }

    @Override
    public String toString() {
        return "LendDate{" +
                "lendDateStr='" + lendDateStr + '\'' +
                ", backDateStr='" + backDateStr + '\'' +
                '}';
    }
}
