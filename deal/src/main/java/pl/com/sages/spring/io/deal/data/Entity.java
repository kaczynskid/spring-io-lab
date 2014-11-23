package pl.com.sages.spring.io.deal.data;

import org.springframework.hateoas.Identifiable;

public interface Entity extends Identifiable<Long> {

    public Long getId();

    public void setId(Long id);

}
