/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compare;

import java.util.Comparator;

/**
 *
 * @author User
 */
class NameCompare implements Comparator<Movie> 
{ 
    @Override
    public int compare(Movie m1, Movie m2) 
    { 
        return m1.getName().compareTo(m2.getName()); 
    } 

}

