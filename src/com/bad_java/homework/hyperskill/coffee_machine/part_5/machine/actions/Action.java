package com.bad_java.homework.hyperskill.coffee_machine.part_5.machine.actions;

import com.bad_java.homework.hyperskill.coffee_machine.part_5.machine.IOHandler;
import com.bad_java.homework.hyperskill.coffee_machine.part_5.machine.Resources;

public abstract class Action {

    protected final IOHandler io;

    protected Action(IOHandler io) {
        this.io = io;
    }

    /**
     * @param resources current resources
     * @return resources after action
     */
    public abstract Resources act(Resources resources);
}
