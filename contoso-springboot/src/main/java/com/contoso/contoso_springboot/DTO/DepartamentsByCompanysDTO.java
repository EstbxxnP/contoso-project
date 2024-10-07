package com.contoso.contoso_springboot.DTO;

public class DepartamentsByCompanysDTO {

    private String company;
    private Long numberOfDepartaments;

    // Constructor
    public DepartamentsByCompanysDTO(String company, Long numberOfDepartaments) {
        this.company = company;
        this.numberOfDepartaments = numberOfDepartaments;
    }

    // Getters y Setters
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Long getNumberOfDepartaments() {
        return numberOfDepartaments;
    }

    public void setNumberOfDepartaments(Long numberOfDepartaments) {
        this.numberOfDepartaments = numberOfDepartaments;
    }

    @Override
    public String toString() {
        return "CompanyDepartamentDTO{" +
                "company='" + company + '\'' +
                ", numberOfDepartaments=" + numberOfDepartaments +
                '}';
    }
}