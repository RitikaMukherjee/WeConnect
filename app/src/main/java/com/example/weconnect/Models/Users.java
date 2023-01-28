package com.example.weconnect.Models;

public class Users {
    String userId,userName,profilePic,email,password,college,course,stream,yoa,yop,company,linkedin,about;

    public Users() {
    }
    public Users(String userId, String userName, String profilePic, String email, String password, String college, String course, String stream, String yoa, String yop, String company, String linkedin,String about) {
        this.userId = userId;
        this.userName = userName;
        this.profilePic = profilePic;
        this.email = email;
        this.password = password;
        this.college = college;
        this.course = course;
        this.stream = stream;
        this.yoa = yoa;
        this.yop = yop;
        this.company = company;
        this.linkedin = linkedin;
        this.about = about;
    }
    public Users(String userName, String email, String password, String college, String course, String stream, String yoa, String yop, String company, String linkedin) {
        this.userId = userId;
        this.userName = userName;
        this.profilePic = profilePic;
        this.email = email;
        this.password = password;
        this.college = college;
        this.course = course;
        this.stream = stream;
        this.yoa = yoa;
        this.yop = yop;
        this.company = company;
        this.linkedin = linkedin;
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getYoa() {
        return yoa;
    }

    public void setYoa(String yoa) {
        this.yoa = yoa;
    }

    public String getYop() {
        return yop;
    }

    public void setYop(String yop) {
        this.yop = yop;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }
    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
