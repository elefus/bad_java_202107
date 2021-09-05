package com.bad_java.homework.hyperskill.coffee_machine.part5.actions.factories;

import com.bad_java.homework.hyperskill.coffee_machine.part5.actions.Action;
import com.bad_java.homework.hyperskill.coffee_machine.part5.actions.Buy;
import com.bad_java.homework.hyperskill.coffee_machine.part5.actions.Exit;
import com.bad_java.homework.hyperskill.coffee_machine.part5.actions.Fill;
import com.bad_java.homework.hyperskill.coffee_machine.part5.actions.Take;
import com.bad_java.homework.hyperskill.coffee_machine.part5.actions.Wait;

public class FactoryAction {

    public Action create(String action) {
        switch (action) {
            case "buy":
                return new Buy();
            case "fill":
                return new Fill();
            case "take":
                return new Take();
            case "exit":
                return new Exit();
            default:
                return new Wait();
        }
    }
}
