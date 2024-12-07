package phenrique.com.hoteliza.demo.domain.dto.User;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInputDTO {

    private static final int TAMANHO_MINIMO_NAME = 4;
    private static final int TAMANHO_MAXIMO_NAME = 40;
    private static final int TAMANHO_MINIMO_SENHA = 6;
    private static final int TAMANHO_MAXIMO_SENHA = 100;
    
    @NotNull
    @Size(min = TAMANHO_MINIMO_NAME, max = TAMANHO_MAXIMO_NAME)
    private String name;

    private String email;

    @NotNull
    @Size(min = TAMANHO_MINIMO_SENHA, max = TAMANHO_MAXIMO_SENHA)
    private String password;

}
