package com.blevast.motion.data.response.git;

import java.util.List;

public class Subscriptions {

    private String id;
    private String full_name;
    private String created_at;
    private int size;
    private String language;
    private boolean has_issues;
    private boolean has_projects;
    private boolean has_downloads;
    private boolean has_wiki;
    private String  default_branch;
    private String homepage;

    public Subscriptions(String id, String full_name, String created_at, int size, String language, boolean has_issues, boolean has_projects, boolean has_downloads, boolean has_wiki, String default_branch, String homepage) {
        this.id = id;
        this.full_name = full_name;
        this.created_at = created_at;
        this.size = size;
        this.language = language;
        this.has_issues = has_issues;
        this.has_projects = has_projects;
        this.has_downloads = has_downloads;
        this.has_wiki = has_wiki;
        this.default_branch = default_branch;
        this.homepage = homepage;
    }

    public int getSize() {
        return size;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getDefault_branch() {
        return default_branch;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getHomepage() {
        return homepage;
    }

    public String getId() {
        return id;
    }

    public String getLanguage() {
        return language;
    }

    public boolean isHas_downloads() {
        return has_downloads;
    }

    public boolean isHas_issues() {
        return has_issues;
    }

    public boolean isHas_projects() {
        return has_projects;
    }

    public boolean isHas_wiki() {
        return has_wiki;
    }

    public void setHas_issues(boolean has_issues) {
        this.has_issues = has_issues;
    }

}
