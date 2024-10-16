package com.contoso.contoso_springboot.DTO;

public class SalaryByDepartamentAndCompanyDTO {

    private String company;
    private String departament;
    private Double salary;

    public SalaryByDepartamentAndCompanyDTO(String company, String departament, Double salary) {
        this.company = company;
        this.departament = departament;
        this.salary = salary;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDepartament() {
        return departament;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "SalaryByDepartamentAndCompanyDTO{" +
                "company='" + company + '\'' +
                ", departament='" + departament + '\'' +
                ", salary=" + salary +
                '}';
    }
}
