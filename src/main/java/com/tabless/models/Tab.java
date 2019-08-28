package com.tabless.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@ApiModel(value = "Tab", description = "The Tab Entity")
@Entity
@Table(name = "tabs")
public class Tab {

    @ApiModelProperty(name = "tabid", value = "primary key for the tab", required = true, example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tabid", nullable = false)
    private long tabid;

    @ApiModelProperty(name = "tabname", value = "User-assigned name for the tab", required = true, example = "Google")
    @Column(name = "tabname", nullable = false)
    private String tabname;

    @ApiModelProperty(name = "taburl", value = "User-assigned URL for the tab", required = true, example = "google.com")
    @Column(name = "taburl", nullable = false)
    private String taburl;

    @ApiModelProperty(name = "tabdesc", value = "User-assigned description for the tab", example = "Quick Google Search tab")
    @Column(name = "tabdesc")
    private String tabdesc;

    @ApiModelProperty(name = "tabcat", value = "User-assigned category for the tab (Defaults to 'None')", required = true, example = "Search Engines")
    @Column(name = "tabcategory", nullable = false)
    private String tabcat = "None";

    @ApiModelProperty(name = "tabprivate", value = "User assigned privacy boolean", required = true, example = "true")
    @Column(name = "tabprivate", nullable = false)
    private boolean tabprivate;

    @ManyToOne
    @JoinColumn(name = "userid")
    @JsonIgnoreProperties("tabs")
    private User user;

    public Tab(String tabname, String taburl, String tabdesc, String tabcat, boolean tabprivate) {
        this.tabname = tabname;
        this.taburl = taburl;
        this.tabdesc = tabdesc;
        this.tabcat = tabcat;
        this.tabprivate = tabprivate;
    }

    public Tab(){
    }

    public long getTabid() {
        return tabid;
    }

    public void setTabid(long tabid) {
        this.tabid = tabid;
    }

    public String getTabname() {
        return tabname;
    }

    public void setTabname(String tabname) {
        this.tabname = tabname;
    }

    public String getTaburl() {
        return taburl;
    }

    public void setTaburl(String taburl) {
        this.taburl = taburl;
    }

    public String getTabdesc() {
        return tabdesc;
    }

    public void setTabdesc(String tabdesc) {
        this.tabdesc = tabdesc;
    }

    public String getTabcat() {
        return tabcat;
    }

    public void setTabcat(String tabcat) {
        this.tabcat = tabcat;
    }

    public boolean isTabprivate() {
        return tabprivate;
    }

    public void setTabprivate(boolean tabprivate) {
        this.tabprivate = tabprivate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
