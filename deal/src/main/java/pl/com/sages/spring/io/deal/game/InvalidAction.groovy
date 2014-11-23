package pl.com.sages.spring.io.deal.game

import groovy.transform.TypeChecked

@TypeChecked
class InvalidAction extends RuntimeException {

    InvalidAction(String s) {
        super(s)
    }
}