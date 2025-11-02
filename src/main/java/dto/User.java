package dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class User {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
}
