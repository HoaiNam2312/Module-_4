package com.example.validating_form_input.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;


public class User implements Validator {

    @NotBlank(message = "Không được để trống")
    @Pattern(regexp = "^([A-Z][aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆ\n" +
            "fFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTu\n" +
            "UùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ]+|\\s)+$", message = "Vui lòng viết hoa chữ cái đầu tiên và chữ có dấu")
    private String firstName;

    @NotBlank(message = "Không được để trống")
    @Size(min = 5, max = 45,message = "Có độ dài tối thiểu 5, tối đa 45 ký tự")
    private String lastName;

    private String phoneNumber;

    @Min(value = 18,message = "Tuổi phải lớn hơn hoặc bằng 18.")
    @Max(value = 120,message = "Tuổi của bạn quá lớn! Vui lòng nhập lại.")
    private int age;

    @Email(message = "Email chưa đúng")
    private String email;

    public User() {
    }

    public User(String firstName, String lastName, String phoneNumber, int age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        String phoneNumber = user.getPhoneNumber();
//        ValidationUtils.rejectIfEmpty(errors, "phoneNumber", "null", "Không để trống SĐT");
        if (phoneNumber.isEmpty()) {
            errors.rejectValue("phoneNumber", "null", "Không để trống SĐT");
        } else if (!phoneNumber.matches("^\\d+$")) {
            errors.rejectValue("phoneNumber", "null", "Phải là số");
        } else if (!phoneNumber.startsWith("0")) {
            errors.rejectValue("phoneNumber", "null", "Phải bắt đầu bằng số 0");
        }
        else if (phoneNumber.length() < 10 || phoneNumber.length() > 11) {
            errors.rejectValue("phoneNumber","null","SĐT phải dài bằng 10 hoặc 11 số");
        }
    }
}
