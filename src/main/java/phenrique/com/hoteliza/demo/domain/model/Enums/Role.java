package phenrique.com.hoteliza.demo.domain.model.Enums;

public enum Role {
    
    USER("user");

    private String role;

    Role(String role){

        this.role=role;

    }

    public String getRole(){

        return role;

    }

}
