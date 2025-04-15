package com.adv_investor.auth_module.domain.user;

public enum UserProfile {

    CONSERVATIVE("conservative");

    private String profile;

    UserProfile(String profile) {
        this.profile = profile;
    }

    public String getProfile() {
        return profile;
    }
}
