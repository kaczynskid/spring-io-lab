package pl.com.sages.spring.io.deal.data

import com.fasterxml.jackson.annotation.JsonIgnore
import groovy.transform.TypeChecked
import org.springframework.data.jpa.domain.AbstractPersistable

@TypeChecked
abstract class BasePersistable<PK extends Serializable> extends AbstractPersistable<PK> {

    @JsonIgnore
    PK getId() {
        return super.getId()
    }

    @JsonIgnore
    boolean isNew() {
        return super.isNew()
    }
}