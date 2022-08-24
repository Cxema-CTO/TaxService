package com.example.taxservice.entity;

import java.util.Date;
import java.util.Objects;

public class Report {
    private int id;
    private String reportContent;
    private boolean isAccepted;
    private String reasonOfRefusal;
    private Date submissionDate;
    private int type;
    private String userName;
    private boolean isSend;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }

    public String getReasonOfRefusal() {
        return reasonOfRefusal;
    }

    public void setReasonOfRefusal(String reasonOfRefusal) {
        this.reasonOfRefusal = reasonOfRefusal;
    }

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isSend() {
        return isSend;
    }

    public void setSend(boolean send) {
        isSend = send;
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", reportContent='" + reportContent + '\'' +
                ", isAccepted=" + isAccepted +
                ", reasonOfRefusal='" + reasonOfRefusal + '\'' +
                ", submissionDate=" + submissionDate +
                ", type=" + type +
                ", userName='" + userName + '\'' +
                ", isSend=" + isSend +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Report report = (Report) o;
        return id == report.id && isAccepted == report.isAccepted && type == report.type && isSend == report.isSend && Objects.equals(reportContent, report.reportContent) && Objects.equals(reasonOfRefusal, report.reasonOfRefusal) && Objects.equals(submissionDate, report.submissionDate) && Objects.equals(userName, report.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, reportContent, isAccepted, reasonOfRefusal, submissionDate, type, userName, isSend);
    }
}
