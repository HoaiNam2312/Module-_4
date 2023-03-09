package com.codegym.casestudy_springboot.dto;

import com.codegym.casestudy_springboot.model.customer.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class CustomerDto implements Validator {
    private int id;

    @NotBlank(message = "Vui lòng không để trống!")
    @Pattern(regexp = "^([ÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚƯỪỬỤỮỨỰVWXYỲỶỸÝỴZ]" +
            "[aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]+|\\s)+$",
            message = "Vui lòng nhập tên của bạn theo mẫu như sau: 'Nguyễn Văn A")
    private String name;

    @NotBlank(message = "Vui lòng không để trống!")
    @Pattern(regexp = "^(((0[1-9]|[12]\\d|3[01])\\/|\\-(0[13578]|1[02])\\/|\\-((19|[2-9]\\d)\\d{2}))|((0[1-9]|[12]\\d|30)\\/|\\-(0[13456789]|1[012])\\/|\\-((19|[2-9]\\d)\\d{2}))|((0[1-9]|1\\d|2[0-8])\\/|\\-02\\/|\\-((19|[2-9]\\d)\\d{2}))|(29\\/02\\/((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))))$",
            message = "Ngày sinh phải có dạng 'dd/MM/yyyy'")
    private String birthday;

    private boolean gender;

    @NotBlank(message = "Vui lòng không để trống!")
    private String idCard;

    @NotBlank(message = "Vui lòng không để trống!")
    @Pattern(regexp = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$", message = "Số điện thoại chưa đúng vui lòng nhập lại!")
    private String phone;


    @NotBlank(message = "Vui lòng không để trống!")
    @Email(message = "Email chưa đúng định dạng vui lòng nhập lại!")
    private String email;


    @NotBlank(message = "Vui lòng không để trống!")
    private String address;

    private CustomerType customerType;

    public CustomerDto() {
    }

    public CustomerDto(int id, String name, String birthday, boolean gender, String idCard, String phone, String email, String address, CustomerType customerType) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.customerType = customerType;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;

        if (customerDto.customerType == null) {
            errors.rejectValue("customerType", "null", "Vui lòng chọn loại khách hàng");
        }
    }
}
