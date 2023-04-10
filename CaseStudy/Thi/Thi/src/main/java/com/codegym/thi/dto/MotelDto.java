package com.codegym.thi.dto;

import com.codegym.thi.model.Payment;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class MotelDto implements Validator {

    private int id;

    @NotBlank(message = " Vui lòng không để trống!")
    @Pattern(regexp = "^([AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚƯỪỬỤỮỨỰVWXYỲỶỸÝỴZ]" +
            "[aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]+|\\s)+$",
            message = "Vui lòng nhập tên của bạn theo mẫu như sau: 'Nguyễn Văn A")
    private String name;

    @NotBlank(message = " Vui lòng không để trống!")
    @Pattern(regexp = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$", message = "Số điện thoại chưa đúng vui lòng nhập lại!")
    private String phone;

    @NotBlank(message = "Vui lòng không để trống!")
    @Pattern(regexp = "^([0-9]{4}[-/]?((0[13-9]|1[012])[-/]?(0[1-9]|[12][0-9]|30)|(0[13578]|1[02])[-/]?31|02[-/]?(0[1-9]|1[0-9]|2[0-8]))|([0-9]{2}(([2468][048]|[02468][48])|[13579][26])|([13579][26]|[02468][048]|0[0-9]|1[0-6])00)[-/]?02[-/]?29)$",
            message = "Ngày bắt đầu phải có dạng 'yyyy/MM/dd'")
    private String startDay;

    private String note;

    private Payment payment;

    public MotelDto() {
    }

    public MotelDto(int id, String name, String phone, String startDay, String note, Payment payment) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.startDay = startDay;
        this.note = note;
        this.payment = payment;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        MotelDto motelDto = (MotelDto) target;
        if (motelDto.payment == null) {
            errors.rejectValue("payment","null","Vui lòng chọn kiểu thanh toán");
        }
    }
}
