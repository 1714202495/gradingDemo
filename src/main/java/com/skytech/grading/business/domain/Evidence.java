package com.skytech.grading.business.domain;

public class Evidence {
    private String evidenceId;
    private String evidenceName;
    private String evidenceUploader;
    private String evidenceUrl;

    public String getEvidenceId() {
        return evidenceId;
    }

    public void setEvidenceId(String evidenceId) {
        this.evidenceId = evidenceId;
    }

    public String getEvidenceName() {
        return evidenceName;
    }

    public void setEvidenceName(String evidenceName) {
        this.evidenceName = evidenceName;
    }

    public String getEvidenceUploader() {
        return evidenceUploader;
    }

    public void setEvidenceUploader(String evidenceUploader) {
        this.evidenceUploader = evidenceUploader;
    }

    public String getEvidenceUrl() {
        return evidenceUrl;
    }

    public void setEvidenceUrl(String evidenceUrl) {
        this.evidenceUrl = evidenceUrl;
    }
}
