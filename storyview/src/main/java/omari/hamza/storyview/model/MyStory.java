package omari.hamza.storyview.model;

import java.io.Serializable;
import java.util.Date;

public class MyStory implements Serializable {

    private String url;

    private Date date;

    private String description;
    private String bottomHashTag;
    private String bottomTitle;
    private String bottomSubtitle;
    private String bottomDescription;
    private String bottomPicUrl;

    public String getBottomHashTag() {
        return bottomHashTag;
    }

    public void setBottomHashTag(String bottomHashTag) {
        this.bottomHashTag = bottomHashTag;
    }

    public String getBottomTitle() {
        return bottomTitle;
    }

    public void setBottomTitle(String bottomTitle) {
        this.bottomTitle = bottomTitle;
    }

    public String getBottomSubtitle() {
        return bottomSubtitle;
    }

    public void setBottomSubtitle(String bottomSubtitle) {
        this.bottomSubtitle = bottomSubtitle;
    }

    public String getBottomDescription() {
        return bottomDescription;
    }

    public void setBottomDescription(String bottomDescription) {
        this.bottomDescription = bottomDescription;
    }

    public String getBottomPicUrl() {
        return bottomPicUrl;
    }

    public void setBottomPicUrl(String bottomPicUrl) {
        this.bottomPicUrl = bottomPicUrl;
    }

    public MyStory(String url, Date date, String description, String bottomHashTag, String bottomTitle, String bottomSubtitle, String bottomDescription, String bottomPicUrl) {
        this.url = url;
        this.date = date;
        this.description = description;
        this.bottomHashTag = bottomHashTag;
        this.bottomTitle = bottomTitle;
        this.bottomSubtitle = bottomSubtitle;
        this.bottomDescription = bottomDescription;
        this.bottomPicUrl = bottomPicUrl;
    }

    public MyStory(String url, Date date, String description) {
        this.url = url;
        this.date = date;
        this.description = description;
    }

    public MyStory(String url, Date date) {
        this.url = url;
        this.date = date;
    }

    public MyStory(String url) {
        this.url = url;
    }

    public MyStory() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
