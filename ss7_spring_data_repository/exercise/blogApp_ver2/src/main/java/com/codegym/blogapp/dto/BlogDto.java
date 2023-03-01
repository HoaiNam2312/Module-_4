package com.codegym.blogapp.dto;

import com.codegym.blogapp.model.Category;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class BlogDto {
    private int id;

    @NotBlank(message = "Không được để trống !")
    @Pattern(regexp = "^([A-Z][aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆ\n" +
            "fFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTu\n" +
            "UùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ]+|\\s)+$", message = "Vui lòng viết hoa chữ cái đầu tiên và chữ có dấu")
    private String name;

    @NotBlank(message = "Không được để trống !")
//    @Pattern(regexp = "^\\d{1,2}[-]\\d{1,2}[-]\\d{4}$",message = "Phải  có dạng 'dd/MM/yyyy'")
    private String postTime;

    @NotBlank(message = "Không được để trống !")
    @Pattern(regexp = "^([A-Z][aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆ\n" +
            "fFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTu\n" +
            "UùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ]+|\\s)+$", message = "Vui lòng viết hoa chữ cái đầu tiên và chữ có dấu")
    private String author;

    @NotBlank(message = "Không được để trống !")
    private String content;

    private Category category;

    public BlogDto() {
    }

    public BlogDto(int id, String name, String postTime, String author, String content, Category category) {
        this.id = id;
        this.name = name;
        this.postTime = postTime;
        this.author = author;
        this.content = content;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
