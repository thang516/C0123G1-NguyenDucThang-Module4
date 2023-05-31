package com.example.validate_form_sign.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class UserDTO implements Validator {


    private Integer id;


    @Size(max = 45, message = "Tên Không Được Dài hơn 45 ký tự")
    private String firstName;

    @Size(max = 45, message = "Tên Không Được Dài hơn 45 ký tự")

    private String lastName;

    @Pattern(regexp = "^0[0-9]{9,10}$", message = "SỐ điện thoại không đúng định dạng ")
    private String phone;

    @Min(value = 18, message = "Tuổi không được nhỏ hơn 18 ")
    @NotNull
    private Integer age;
    @Email(message = "Bạn cần nhập gmail abc@gmail.com để đúng định dạng")
    private String email;

    public UserDTO() {
    }

    public UserDTO(Integer id, String firstName, String lastName, String phone, Integer age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.age = age;
        this.email = email;
    }

    public UserDTO(String firstName, String lastName, String phone, Integer age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.age = age;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
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
        UserDTO userDTO = (UserDTO) target;
        String regex = "^([A-Z])([a-z])*((\\s)[A-Z]([a-z]*)){0,4}$";
        if (!userDTO.firstName.matches(regex)) {
            errors.rejectValue("firstName", "", "tên không hợp lệ ");
        }
    }
}
