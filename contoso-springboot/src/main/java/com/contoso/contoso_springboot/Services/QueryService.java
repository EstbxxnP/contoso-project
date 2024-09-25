package com.contoso.contoso_springboot.Services;

import com.contoso.contoso_springboot.Models.Company;
import com.contoso.contoso_springboot.Models.Departament;
import com.contoso.contoso_springboot.Models.User;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QueryService {
    public Map<String, Long> queryUsersByDepartament(List<Departament> departaments) {
        Map<String, Long> usersAmount = new HashMap<>();
        for (Departament dp : departaments) {
            usersAmount.put(dp.getDescription(), (long) dp.getUsers().size());
        }
        return usersAmount;}

    public Map<String, Long> queryDepartamentsByCompany(List<Company> companys) {
        Map<String, Long> departamentsAmount = new HashMap<>();
        for (Company comp : companys) {
            departamentsAmount.put(comp.getName(), (long) comp.getDepartaments().size());
        }
        return departamentsAmount;}

    public Map<String, Double> getExpensesByDepartament(List<Departament> departaments) {
        Map<String, Double> expensesDepartament = new HashMap<>();
        for (Departament dp : departaments) {
            double totalExpenses = 0;
            for (User usr : dp.getUsers()) {
                totalExpenses += usr.getSalary();
            }
            expensesDepartament.put(dp.getDescription(),totalExpenses);
        }
        return expensesDepartament;}

    public Map<String, Double> getExpensesByCompany(List<Company> company) {
        Map<String, Double> expensesCompany = new HashMap<>();
        for (Company comp : company) {
            double totalExpenses = 0;
            for (Departament dp : comp.getDepartaments()) {
                for (User usr : dp.getUsers()) {
                    totalExpenses += usr.getSalary();
                }
            }
            expensesCompany.put(comp.getName(), totalExpenses);
        }
        return expensesCompany;}
}
