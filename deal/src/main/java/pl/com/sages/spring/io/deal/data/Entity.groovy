package pl.com.sages.spring.io.deal.data

import groovy.transform.TypeChecked;
import org.springframework.hateoas.Identifiable;

@TypeChecked
interface Entity extends Identifiable<Long> {

    Long getId();

    void setId(Long id);

}
