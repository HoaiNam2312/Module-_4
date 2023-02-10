package com.codegym.model;

public class Email {
    private String languages;
    private int pageSize;
    private boolean spamsFillter;
    private String signature;

    public Email() {
    }

    public Email(String languages, int pageSize, boolean spamsFillter, String signature) {
        this.languages = languages;
        this.pageSize = pageSize;
        this.spamsFillter = spamsFillter;
        this.signature = signature;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isSpamsFillter() {
        return spamsFillter;
    }

    public void setSpamsFillter(boolean spamsFillter) {
        this.spamsFillter = spamsFillter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
