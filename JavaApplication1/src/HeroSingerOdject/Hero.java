/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HeroSingerOdject;

/**
 *
 * @author User
 */
public class Hero {

    private String name;
    private double health;
    private String[] skills;
    private double[] attackDamage;
    private double armor;

    public Hero(String name, double health, String[] skills,
            double[] attackDamage, double armor) {
        this.name = name;
        this.health = health;
        this.skills = skills;
        this.attackDamage = attackDamage;
        this.armor = armor;
    }

    public double harm(double damage) {
        if (damage < 0) {
            return 0;
        }
        if (health < 0) {
            health = 0;
        }
        return damage - armor;
    }

    public String attack(Hero enemy, int skill) {
        String skillName = this.skills[skill];
        double skillDamage = this.attackDamage[skill];
        double affectedHealth = enemy.harm(skillDamage);
        enemy.setHealth(enemy.getHealth() - affectedHealth);
        
        return String.format("%s attacks %s -skill- %s: skill %.2f hit points - effect %.2f",
                this.name, enemy.getName(), skillName, skillDamage, affectedHealth);
    }

    ///////////////////////////////////////////////////////////////
    public void setName(String name) {
        this.name = name;
    }

    public void setSkill(String[] skills) {
        this.skills = skills;
    }

    public void setAttackDamage(double[] attackDamage) {
        this.attackDamage = attackDamage;
    }

    public void setArmor(double armor) {
        this.armor = armor;
    }

    public String getName() {
        return name;
    }

    public String[] getSkill() {
        return skills;
    }

    public double[] getAttackDamage() {
        return attackDamage;
    }

    public double getArmor() {
        return armor;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getHealth() {
        return health;
    }
///////////////////////////////////////////////////////////////

    @Override
    public String toString() {
        return "Hero{ " + "name= " + name + ", health= " + health + ", armor= "+ armor +" } ";
    }
    
        
        
        
        
        
        
        
    
}
