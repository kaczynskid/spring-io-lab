package pl.com.sages.spring.io.deal.game.door

import pl.com.sages.spring.io.deal.game.InvalidAction

class Door {

    static enum Status {
        CLOSED, OPENED, SELECTED
    }

    static enum Content {
        LOOT, EMPTY, UNKNOWN
    }

    static Door withNothing() {
        return new Door(Content.EMPTY)
    }

    static Door withLoot() {
        return new Door(Content.LOOT)
    }

    Status status

    Content content

    Door() {
    }

    Door(Content content) {
        this.status = Status.CLOSED
        this.content = content
    }

    Content getContent() {
        return Status.OPENED.equals(status) ? content : Content.UNKNOWN
    }

    boolean canOpenAsHint() {
        return Status.CLOSED.equals(status) && Content.EMPTY.equals(content)
    }

    void select() {
        if (Status.CLOSED != status) {
            throw new InvalidAction(String.format("Cannot select %s doors!", status))
        }
        this.status = Status.SELECTED
    }

    void open() {
        if (Status.OPENED == status) {
            throw new InvalidAction(String.format("Cannot open %s doors!", status))
        }
        this.status = Status.OPENED
    }
}
