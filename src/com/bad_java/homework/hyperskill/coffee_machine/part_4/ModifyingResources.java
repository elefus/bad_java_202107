package com.bad_java.homework.hyperskill.coffee_machine.part_4;

import com.bad_java.homework.hyperskill.coffee_machine.part_4.ingredients.Ingredient;

public interface ModifyingResources {
    void modifyResources(int water, int milk, int beans, int cups, int money);

    Ingredient gettingRidOfMoney();
}
