package pl.com.sages.spring.io.deal.game

import pl.com.sages.spring.io.deal.data.Entity
import pl.com.sages.spring.io.deal.game.door.Door

class Game implements Entity {

    static enum Status {

        AWAITING_PRIMARY_SELECTION() {
            Door.Status allowed(Door.Status action) {
                return Door.Status.SELECTED.equals(action) ? action : super.allowed(action)
            }
        },

        AWAITING_SECONDARY_SELECTION() {
            Door.Status allowed(Door.Status action) {
                return Door.Status.OPENED.equals(action) ? action : super.allowed(action)
            }
        },

        WON,

        LOST;

        Door.Status allowed(Door.Status action) {
            throw new InvalidAction(String.format("Door cannot be %s when %s!", action, this))
        }

    }

    static final int MAX_EMPTY_DOORS = 2

    Long id

    Status status

    List<Door> doors

    Door getDoor(int idx) {
        return doors.get(idx)
    }

    void takeAction(int doorIdx, Door.Status action) {
        switch (status.allowed(action)) {
            case Door.Status.SELECTED:
                getDoor(doorIdx).select()
                doors.findAll { Door d -> d.canOpenAsHint()} [0].open()
                status = Status.AWAITING_SECONDARY_SELECTION
                break;
            case Door.Status.OPENED:
                Door door = getDoor(doorIdx)
                door.open()
                status = Door.Content.LOOT.equals(door.getContent()) ? Status.WON : Status.LOST
                break;
        }
    }
}
