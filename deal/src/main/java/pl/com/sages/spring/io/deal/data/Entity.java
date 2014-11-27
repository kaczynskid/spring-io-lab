package pl.com.sages.spring.io.deal.data;

import org.springframework.hateoas.Identifiable;

public interface Entity extends Identifiable<Long> {

    Long getId();

    void setId(Long id);

}
