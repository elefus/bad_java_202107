package com.bad_java.homework.hyperskill.coffee_machine.part_5.machine.actions.factories;

import com.bad_java.homework.hyperskill.coffee_machine.part_5.machine.IOHandler;
import com.bad_java.homework.hyperskill.coffee_machine.part_5.machine.actions.Action;

public interface ActionFactory {

    Action create(String type, IOHandler io);
}
