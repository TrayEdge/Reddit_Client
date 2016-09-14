
package app.st1ch.redditclient.data.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Created by st1ch on 14.09.2016.
 */
public class RedditPost {

    private String domain;
    private Object bannedBy;
    private MediaEmbed mediaEmbed;
    private String subreddit;
    private String selftextHtml;
    private String selftext;
    private Object likes;
    private Object suggestedSort;
    private List<Object> userReports = new ArrayList<Object>();
    private Object secureMedia;
    private Boolean saved;
    private String id;
    private Integer gilded;
    private SecureMediaEmbed secureMediaEmbed;
    private Boolean clicked;
    private Object reportReasons;
    private String author;
    private Integer numComments;
    private String name;
    private Integer score;
    private Object approvedBy;
    private Boolean over18;
    private Boolean hidden;
    private String thumbnail;
    private String subredditId;
    private String edited;
    private Object linkFlairCssClass;
    private Object authorFlairCssClass;
    private Integer downs;
    private List<Object> modReports = new ArrayList<Object>();
    private Boolean archived;
    private Object removalReason;
    private Boolean isSelf;
    private Boolean hideScore;
    private String permalink;
    private Boolean locked;
    private Boolean stickied;
    private String created;
    private String url;
    private Object authorFlairText;
    private Boolean quarantine;
    private String title;
    private String createdUtc;
    private Object linkFlairText;
    private Object distinguished;
    private Object media;
    private Boolean visited;
    private Object numReports;
    private Integer ups;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public Object getBannedBy() {
        return bannedBy;
    }

    public void setBannedBy(Object bannedBy) {
        this.bannedBy = bannedBy;
    }

    public MediaEmbed getMediaEmbed() {
        return mediaEmbed;
    }

    public void setMediaEmbed(MediaEmbed mediaEmbed) {
        this.mediaEmbed = mediaEmbed;
    }

    public String getSubreddit() {
        return subreddit;
    }

    public void setSubreddit(String subreddit) {
        this.subreddit = subreddit;
    }

    public String getSelftextHtml() {
        return selftextHtml;
    }

    public void setSelftextHtml(String selftextHtml) {
        this.selftextHtml = selftextHtml;
    }

    public String getSelftext() {
        return selftext;
    }

    public void setSelftext(String selftext) {
        this.selftext = selftext;
    }

    public Object getLikes() {
        return likes;
    }

    public void setLikes(Object likes) {
        this.likes = likes;
    }

    public Object getSuggestedSort() {
        return suggestedSort;
    }

    public void setSuggestedSort(Object suggestedSort) {
        this.suggestedSort = suggestedSort;
    }

    public List<Object> getUserReports() {
        return userReports;
    }

    public void setUserReports(List<Object> userReports) {
        this.userReports = userReports;
    }

    public Object getSecureMedia() {
        return secureMedia;
    }

    public void setSecureMedia(Object secureMedia) {
        this.secureMedia = secureMedia;
    }

    public Boolean getSaved() {
        return saved;
    }

    public void setSaved(Boolean saved) {
        this.saved = saved;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getGilded() {
        return gilded;
    }

    public void setGilded(Integer gilded) {
        this.gilded = gilded;
    }

    public SecureMediaEmbed getSecureMediaEmbed() {
        return secureMediaEmbed;
    }

    public void setSecureMediaEmbed(SecureMediaEmbed secureMediaEmbed) {
        this.secureMediaEmbed = secureMediaEmbed;
    }

    public Boolean getClicked() {
        return clicked;
    }

    public void setClicked(Boolean clicked) {
        this.clicked = clicked;
    }

    public Object getReportReasons() {
        return reportReasons;
    }

    public void setReportReasons(Object reportReasons) {
        this.reportReasons = reportReasons;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getNumComments() {
        return numComments;
    }

    public void setNumComments(Integer numComments) {
        this.numComments = numComments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Object getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(Object approvedBy) {
        this.approvedBy = approvedBy;
    }

    public Boolean getOver18() {
        return over18;
    }

    public void setOver18(Boolean over18) {
        this.over18 = over18;
    }

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getSubredditId() {
        return subredditId;
    }

    public void setSubredditId(String subredditId) {
        this.subredditId = subredditId;
    }

    public String getEdited() {
        return edited;
    }

    public void setEdited(String edited) {
        this.edited = edited;
    }

    public Object getLinkFlairCssClass() {
        return linkFlairCssClass;
    }

    public void setLinkFlairCssClass(Object linkFlairCssClass) {
        this.linkFlairCssClass = linkFlairCssClass;
    }

    public Object getAuthorFlairCssClass() {
        return authorFlairCssClass;
    }

    public void setAuthorFlairCssClass(Object authorFlairCssClass) {
        this.authorFlairCssClass = authorFlairCssClass;
    }

    public Integer getDowns() {
        return downs;
    }

    public void setDowns(Integer downs) {
        this.downs = downs;
    }

    public List<Object> getModReports() {
        return modReports;
    }

    public void setModReports(List<Object> modReports) {
        this.modReports = modReports;
    }

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    public Object getRemovalReason() {
        return removalReason;
    }

    public void setRemovalReason(Object removalReason) {
        this.removalReason = removalReason;
    }

    public Boolean getIsSelf() {
        return isSelf;
    }

    public void setIsSelf(Boolean isSelf) {
        this.isSelf = isSelf;
    }

    public Boolean getHideScore() {
        return hideScore;
    }

    public void setHideScore(Boolean hideScore) {
        this.hideScore = hideScore;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Boolean getStickied() {
        return stickied;
    }

    public void setStickied(Boolean stickied) {
        this.stickied = stickied;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Object getAuthorFlairText() {
        return authorFlairText;
    }

    public void setAuthorFlairText(Object authorFlairText) {
        this.authorFlairText = authorFlairText;
    }

    public Boolean getQuarantine() {
        return quarantine;
    }

    public void setQuarantine(Boolean quarantine) {
        this.quarantine = quarantine;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreatedUtc() {
        return createdUtc;
    }

    public void setCreatedUtc(String createdUtc) {
        this.createdUtc = createdUtc;
    }

    public Object getLinkFlairText() {
        return linkFlairText;
    }

    public void setLinkFlairText(Object linkFlairText) {
        this.linkFlairText = linkFlairText;
    }

    public Object getDistinguished() {
        return distinguished;
    }

    public void setDistinguished(Object distinguished) {
        this.distinguished = distinguished;
    }

    public Object getMedia() {
        return media;
    }

    public void setMedia(Object media) {
        this.media = media;
    }

    public Boolean getVisited() {
        return visited;
    }

    public void setVisited(Boolean visited) {
        this.visited = visited;
    }

    public Object getNumReports() {
        return numReports;
    }

    public void setNumReports(Object numReports) {
        this.numReports = numReports;
    }

    public Integer getUps() {
        return ups;
    }

    public void setUps(Integer ups) {
        this.ups = ups;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "RedditPost{" +
                "domain='" + domain + '\'' +
                ", bannedBy=" + bannedBy +
                ", mediaEmbed=" + mediaEmbed +
                ", subreddit='" + subreddit + '\'' +
                ", selftextHtml='" + selftextHtml + '\'' +
                ", selftext='" + selftext + '\'' +
                ", likes=" + likes +
                ", suggestedSort=" + suggestedSort +
                ", userReports=" + userReports +
                ", secureMedia=" + secureMedia +
                ", saved=" + saved +
                ", id='" + id + '\'' +
                ", gilded=" + gilded +
                ", secureMediaEmbed=" + secureMediaEmbed +
                ", clicked=" + clicked +
                ", reportReasons=" + reportReasons +
                ", author='" + author + '\'' +
                ", numComments=" + numComments +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", approvedBy=" + approvedBy +
                ", over18=" + over18 +
                ", hidden=" + hidden +
                ", thumbnail='" + thumbnail + '\'' +
                ", subredditId='" + subredditId + '\'' +
                ", edited=" + edited +
                ", linkFlairCssClass=" + linkFlairCssClass +
                ", authorFlairCssClass=" + authorFlairCssClass +
                ", downs=" + downs +
                ", modReports=" + modReports +
                ", archived=" + archived +
                ", removalReason=" + removalReason +
                ", isSelf=" + isSelf +
                ", hideScore=" + hideScore +
                ", permalink='" + permalink + '\'' +
                ", locked=" + locked +
                ", stickied=" + stickied +
                ", created=" + created +
                ", url='" + url + '\'' +
                ", authorFlairText=" + authorFlairText +
                ", quarantine=" + quarantine +
                ", title='" + title + '\'' +
                ", createdUtc=" + createdUtc +
                ", linkFlairText=" + linkFlairText +
                ", distinguished=" + distinguished +
                ", media=" + media +
                ", visited=" + visited +
                ", numReports=" + numReports +
                ", ups=" + ups +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
