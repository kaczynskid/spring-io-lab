package pl.com.sages.spring.io.deal.game;

import java.util.List;

import lombok.Data;
import pl.com.sages.spring.io.deal.data.Entity;
import pl.com.sages.spring.io.deal.game.door.Door;

@Data
public class Game implements Entity {

    public static enum Status {

        AWAITING_PRIMARY_SELECTION() {
            @Override
            public Door.Status allowed(Door.Status action) {
                return Door.Status.SELECTED.equals(action) ? action : super.allowed(action);
            }
        },

        AWAITING_SECONDARY_SELECTION() {
            @Override
            public Door.Status allowed(Door.Status action) {
                return Door.Status.OPENED.equals(action) ? action : super.allowed(action);
            }
        },

        WON,

        LOST;

        public Door.Status allowed(Door.Status action) {
            throw new InvalidAction(String.format("Door cannot be %s when %s!", action, this));
        }

    }

    public static final int MAX_EMPTY_DOORS = 2;

    private Long id;

    private Status status;

    private List<Door> doors;

    public Door getDoor(int idx) {
        return doors.get(idx);
    }

    public void takeAction(int doorIdx, Door.Status action) {
        switch (status.allowed(action)) {
            case SELECTED:
                getDoor(doorIdx).select();
                doors.stream().filter(Door::canOpenAsHint).findAny();
                status = Status.AWAITING_SECONDARY_SELECTION;
                break;
            case OPENED:
                Door door = getDoor(doorIdx);
                door.open();
                status = Door.Content.LOOT.equals(door.getContent()) ? Status.WON : Status.LOST;
                break;
        }
    }

// Java 8... they tried ;)

//    public static final Random RANDOM = new Random();
//
//    public Game() {
//        this.status = Status.AWAITING_PRIMARY_SELECTION;
//
//        // this is ugly
//        this.doors = Stream.generate(Door::withNothing).limit(MAX_EMPTY_DOORS).collect(toList());
//        this.doors.add(RANDOM.nextInt(MAX_EMPTY_DOORS + 1), Door.withLoot());
//
//
//        // this is even move ugly
//        this.doors = Stream.generate(Door::withNothing).limit(MAX_EMPTY_DOORS).collect(
//                () -> {
//                    List<Door> l = new LinkedList<>();
//                    l.add(Door.withLoot());
//                    return l;
//                },
//                (doors, door) -> {
//                    if (RANDOM.nextBoolean()) {
//                        doors.add(0, door);
//                    } else {
//                        doors.add(door);
//                    }
//                },
//                (p, q) -> p.addAll(q)
//        );
//    }
}
