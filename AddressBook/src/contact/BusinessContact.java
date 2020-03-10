/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contact;

import base.Address;
import base.Company;

/**
 *
 * @author User
 */
public class BusinessContact extends Contact 
        implements Comparable<BusinessContact>{
    private Company company;
    private String jobTitle;

    public BusinessContact(Company company, String jobTitle, Address address, String email, String phone, ContactType type) {
        super(address, email, phone, type);
        this.company = company;
        this.jobTitle = jobTitle;
    }

    public Company getCompany() {
        return company;
    }

    public String getJobTitle() {
        return jobTitle;
    }
    
    @Override
    public int compareTo(BusinessContact o){
        return company.getName().compareTo(o.getCompany().getName());
    }

    @Override
    public String toString() {
        return "BusinessContact{" + "company=" + company + ", jobTitle=" + jobTitle + '}';
    }
    
}
