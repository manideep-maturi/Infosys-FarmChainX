package com.infosys.farmchainx.dto;

public class AdminDashboardDTO {

    private long pending;
    private long approved;
    private long rejected;

    public AdminDashboardDTO(long pending, long approved, long rejected) {
        this.pending = pending;
        this.approved = approved;
        this.rejected = rejected;
    }

    public long getPending() {
        return pending;
    }

    public long getApproved() {
        return approved;
    }

    public long getRejected() {
        return rejected;
    }
}
