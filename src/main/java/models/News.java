package models;

public class News {

    private int id;
    private String content;
    private int departmentId;
    private String newsName;

    public News(String content, int departmentId, String newsName) {
        this.content = content;
        this.departmentId = departmentId;
        this.newsName = newsName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getNewsName() {
        return newsName;
    }

    public void setNewsName(String newsName) {
        this.newsName = newsName;
    }
}
