package com.bad_java.homework.hyperskill.coffee_machine.part4.actions.factories;

import com.bad_java.homework.hyperskill.coffee_machine.part4.actions.Action;
import com.bad_java.homework.hyperskill.coffee_machine.part4.actions.Buy;
import com.bad_java.homework.hyperskill.coffee_machine.part4.actions.Fill;
import com.bad_java.homework.hyperskill.coffee_machine.part4.actions.Take;
import com.bad_java.homework.hyperskill.coffee_machine.part4.actions.Wait;

public class FactoryAction {

    public Action create(String action) {
        switch (action) {
            case "buy":
                return new Buy();
            case "fill":
                return new Fill();
            case "take":
                return new Take();
            default:
                return new Wait();
        }
    }
}
