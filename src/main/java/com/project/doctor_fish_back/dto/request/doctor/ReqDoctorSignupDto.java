package com.project.doctor_fish_back.dto.request.doctor;

import com.project.doctor_fish_back.entity.User;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class ReqDoctorSignupDto {
    @NotBlank(message = "아이디는 공백일 수 없습니다.")
    private String username;
    @NotBlank(message = "이름은 공백일 수 없습니다.")
    private String name;
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[~!@#$%^&*?])[A-Za-z\\d~!@#$%^&*?]{8,16}$", message = "비밀번호는 8자이상 16자이하의 영대소문, 숫자, 특수문자(~!@#$%^&*?)를 포함하여합니다.")
    private String password;
    private String checkPassword;
    private String img;
    @NotBlank(message = "부서이름은 공백일 수 없습니다.")
    private String departName;

    public User toEntity(BCryptPasswordEncoder passwordEncoder) {
        return User.builder()
                .email(username)
                .name(name)
                .password(passwordEncoder.encode(password))
                .img(img)
                .build();
    }
}