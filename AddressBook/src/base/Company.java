/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import java.util.Objects;

/**
 *
 * @author User
 */
public class Company {
    private String name;

    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    @Override
    public boolean equals(Object obj) {
        Company other = (Company) obj;
        return name.equals(other.getName());
    }

    @Override
    public String toString() {
        return "Company{" + "name=" + name + '}';
    }
    
    
}
