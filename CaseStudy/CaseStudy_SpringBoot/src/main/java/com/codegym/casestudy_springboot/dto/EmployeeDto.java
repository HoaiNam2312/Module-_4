package com.codegym.casestudy_springboot.dto;

import com.codegym.casestudy_springboot.model.employee.Division;
import com.codegym.casestudy_springboot.model.employee.EducationDegree;
import com.codegym.casestudy_springboot.model.employee.Position;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.regex.Matcher;


public class EmployeeDto implements Validator {
    private int id;


    @NotBlank(message = "Vui lòng không để trống!")
    @Pattern(regexp = "^([AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚƯỪỬỤỮỨỰVWXYỲỶỸÝỴZ]" +
            "[aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]+|\\s)+$",
            message = "Vui lòng nhập tên của bạn theo mẫu như sau: 'Nguyễn Văn A")
    private String name;

    //    @NotBlank(message = "Vui lòng không để trống!")
//    @Pattern(regexp = "^([0-9]{4}[-/]?((0[13-9]|1[012])[-/]?(0[1-9]|[12][0-9]|30)|(0[13578]|1[02])[-/]?31|02[-/]?(0[1-9]|1[0-9]|2[0-8]))|([0-9]{2}(([2468][048]|[02468][48])|[13579][26])|([13579][26]|[02468][048]|0[0-9]|1[0-6])00)[-/]?02[-/]?29)$",
//            message = "Ngày sinh phải có dạng 'yyyy/MM/dd'")
    private String birthday;

    @NotBlank(message = "Vui lòng không để trống!")
    private String idCard;

    //    NotBlank là validate cho kiểu dữ liệu là String
    @Min(value=0, message="must be equal or greater than 0")
    @Max(value=10, message="must be equal or less than 10")
    private double salary;

    @NotBlank(message = "Vui lòng không để trống!")
    @Pattern(regexp = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$", message = "Số điện thoại chưa đúng vui lòng nhập lại!")
    private String phone;

    @NotBlank(message = "Vui lòng không để trống!")
    @Email(message = "Email chưa đúng định dạng vui lòng nhập lại!")
    private String email;

    @NotBlank(message = "Vui lòng không để trống!")
    private String address;

    private Division division;

    private Position position;

    private EducationDegree educationDegree;

    public EmployeeDto() {
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
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

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
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

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    @Override
    public void validate(Object target, Errors errors) {
        EmployeeDto employeeDto = (EmployeeDto) target;
        if (employeeDto.division == null) {
            errors.rejectValue("division", "null", "Vui lòng chọn Chức vụ của nhân viên");
        }
        if (employeeDto.position == null) {
            errors.rejectValue("position", "null", "Vui lòng chọn Vị trí của nhân viên");
        }
        if (employeeDto.educationDegree == null) {
            errors.rejectValue("educationDegree", "null", "Vui lòng chọn Trình độ của nhân viên");
        }

//        Validate date
        String birthday = employeeDto.getBirthday();
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("^([0-9]{4}[-/]?((0[13-9]|1[012])[-/]?(0[1-9]|[12][0-9]|30)|(0[13578]|1[02])[-/]?31|02[-/]?(0[1-9]|1[0-9]|2[0-8]))|([0-9]{2}(([2468][048]|[02468][48])|[13579][26])|([13579][26]|[02468][048]|0[0-9]|1[0-6])00)[-/]?02[-/]?29)$");
        Matcher matcher = pattern.matcher(birthday);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (birthday.isEmpty()) {
            errors.rejectValue("birthday", "null", "Vui lòng không để trống");
        } else if (!matcher.matches()) {
            errors.rejectValue("birthday", "null", "Ngày sinh phải có dạng 'yyyy-MM-dd'");
        } else {
            LocalDate currentTime = LocalDate.now();
            try {
//                Date currentDate = dateFormat.parse(String.valueOf(currentTime));
                Date birthdayDate = dateFormat.parse(birthday);
//                long currentDateValue = currentDate.getTime();
                long birthdayDateValue = birthdayDate.getTime();
                long result = (((Math.abs(System.currentTimeMillis() - birthdayDateValue)) / (24 * 60 * 60 * 1000)) / 365);
                if (result < 18) {
                    errors.rejectValue("birthday", "null", "Bạn chưa đủ 18 tuổi. Vui lòng thử lại!");
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }


        String salary = employeeDto.getSalary() + "";
        if (salary.trim().equals("0.0")) {
            errors.rejectValue("salary", "null", "Vui lòng không để trống");
        }
    }
}
