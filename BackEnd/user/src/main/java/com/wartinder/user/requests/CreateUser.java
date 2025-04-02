package com.wartinder.user.requests;

import com.wartinder.user.entity.User;
import com.wartinder.user.enums.USERROLE;
import jakarta.validation.constraints.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.UUID;
@Data
public class CreateUser {
    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    private String name;

    @NotBlank(message = "El correo electrónico no puede estar vacío")
    @Email(message = "El correo electrónico no es válido")
    private String email;

    @NotBlank(message = "El número de teléfono no puede estar vacío")
    @Pattern(regexp = "^\\+?[0-9]{7,15}$", message = "El número de teléfono no es válido")
    private String phone;

    //@NotBlank(message = "La imagen de perfil no puede estar vacía")
    private String imgProfile;

    //@NotBlank(message = "La imagen de portada no puede estar vacía")
    private String imgFrontpage;

    //@Size(max = 500, message = "La descripción no puede tener más de 500 caracteres")
    private String description;

    @NotBlank(message = "El género no puede estar vacío")
    private String gender;

    public static User to (CreateUser createUser) {
        return User.builder()
                .publicId(UUID.randomUUID())
                .name(createUser.getName())
                .email(createUser.getEmail())
                .phone(createUser.getPhone())
                .imgProfile(createUser.getImgProfile())
                .imgFrontpage(createUser.getImgFrontpage())
                .description(createUser.getDescription())
                .gender(createUser.getGender())
                .role(USERROLE.USER)
                .build();
    }
}
