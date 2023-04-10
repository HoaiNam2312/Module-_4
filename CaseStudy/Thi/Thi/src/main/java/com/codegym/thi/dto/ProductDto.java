package com.codegym.thi.dto;

import com.codegym.thi.model.ProductType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ProductDto implements Validator {
    private int id;

    @NotBlank(message = "Vui lòng không để trống")
    @Size(min = 5,max = 50,message = "Tên sản phẩm phải từ 5 đến 50 ký tự")
    private String name;

    @Min(value = 100,message = "Giá thấp nhất là 100.000VND")
    private double price;

    @NotBlank(message = "Vui lòng không để trống")
    private String status;

    private ProductType productType;

    public ProductDto() {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ProductDto productDto = (ProductDto) target;
        if (productDto.productType == null) {
            errors.rejectValue("productType","null","Vui lòng chọn sản phẩm");
        }

        String price = productDto.getPrice() + "";
        if (price.trim().equals("0.0")) {
            errors.rejectValue("price", "null", "Vui lòng không để trống");
        }
    }
}
