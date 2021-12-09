package com.example.lec5demo;

public class SiteAttraction {
    private String SiteName;
    private int SitePic;

    public SiteAttraction(String siteName, int sitePic) {
        SiteName = siteName;
        SitePic = sitePic;
    }

    public String getSiteName() {
        return SiteName;
    }

    public void setSiteName(String siteName) {
        SiteName = siteName;
    }

    public int getSitePic() {
        return SitePic;
    }

    public void setSitePic(int sitePic) {
        SitePic = sitePic;
    }
}
