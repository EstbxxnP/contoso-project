package com.contoso.contoso_springboot.DTO;


@Data
public class UsersByDepartamentAndCompanyDTO {

    private String departament;
    private String company;
    private Long numberOfUsers;


    public UsersByDepartamentAndCompanyDTO(String company, String departament, Long numberOfUsers) {
        this.company = company;
        this.departament = departament;
        this.numberOfUsers = numberOfUsers;
    }

    public String getDepartament() {
        return departament;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Long getNumberOfUsers() {
        return numberOfUsers;
    }

    public void setNumberOfUsers(Long numberOfUsers) {
        this.numberOfUsers = numberOfUsers;
    }

    @Override
    public String toString() {
        return "UsersByDepartamentAndCompanyDTO{" +
                "departament='" + departament + '\'' +
                ", company='" + company + '\'' +
                ", numberOfUsers=" + numberOfUsers +
                '}';
    }
}
