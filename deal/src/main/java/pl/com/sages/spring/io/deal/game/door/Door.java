package pl.com.sages.spring.io.deal.game.door;

import lombok.Data;
import pl.com.sages.spring.io.deal.data.Entity;
import pl.com.sages.spring.io.deal.game.InvalidAction;

@Data
public class Door implements Entity {

    public static enum Status {
        CLOSED, OPENED, SELECTED
    }

    public static enum Content {
        LOOT, EMPTY, UNKNOWN
    }

    public static Door withNothing() {
        return new Door(Content.EMPTY);
    }

    public static Door withLoot() {
        return new Door(Content.LOOT);
    }

    private Long id;

    private Status status;

    private Content content;

    public Door() {
    }

    public Door(Content content) {
        this.status = Status.CLOSED;
        this.content = content;
    }

    public Content getContent() {
        return Status.OPENED.equals(status) ? content : Content.UNKNOWN;
    }

    public boolean canOpenAsHint() {
        return Status.CLOSED.equals(status) && Content.EMPTY.equals(content);
    }

    public void select() {
        if (Status.CLOSED != status) {
            throw new InvalidAction(String.format("Cannot select %s doors!", status));
        }
        this.status = Status.SELECTED;
    }

    public void open() {
        if (Status.OPENED == status) {
            throw new InvalidAction(String.format("Cannot open %s doors!", status));
        }
        this.status = Status.OPENED;
    }
}
