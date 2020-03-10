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
public class Battle {

    public static void main(String[] args) {
        Hero[] hero = new Hero[2];

        hero[0] = new Hero("Genji", 200,
                new String[]{"Fan of Blades", "Shuriken", "Dragonblade"},
                new double[]{28, 50, 120}, 24);
        hero[1] = new Hero("Hanzo", 200,
                new String[]{"Sonic Arrow", "Scatter Arrow", "Dragonstrike"},
                new double[]{29, 75, 200}, 20);

        int ind1, ind2, skill;
        String result;

        while (hero[0].getHealth() > 0 && hero[1].getHealth() > 0) {
            ind1 = (int) (Math.random() * 2);
            ind2 = (ind1 + 1) % 2;
            skill = (int) (Math.random() * 3);

            result = hero[ind1].attack(hero[ind2], skill);
            System.out.println(result);
            System.out.println(hero[0].toString() + "\n"
                    + hero[1].toString() + "\n");
        }
    }

}
