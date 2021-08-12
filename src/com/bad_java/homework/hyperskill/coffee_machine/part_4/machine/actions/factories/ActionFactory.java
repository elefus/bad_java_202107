package com.bad_java.homework.hyperskill.coffee_machine.part_4.machine.actions.factories;

import com.bad_java.homework.hyperskill.coffee_machine.part_4.machine.actions.Action;

public interface ActionFactory {

    Action create(String type);
}
