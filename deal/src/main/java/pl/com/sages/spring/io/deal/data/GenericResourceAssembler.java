package pl.com.sages.spring.io.deal.data;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.hateoas.Identifiable;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

import pl.com.sages.spring.io.deal.game.Game;

public abstract class GenericResourceAssembler<T extends Identifiable<?>> implements ResourceAssembler<T, Resource<T>> {

    private final Class<?> controllerClass;

    public GenericResourceAssembler(Class<?> controllerClass) {
        Assert.notNull(controllerClass);
        this.controllerClass = controllerClass;
    }

    public ResponseEntity<Void> respondCreated(T entity) {
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(selfLink(entity).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    public List<Resource<T>> toResources(Iterable<? extends T> entities) {
        Assert.notNull(entities);
        List<Resource<T>> result = new ArrayList<Resource<T>>();

        for (T entity : entities) {
            result.add(toResource(entity));
        }
        return result;
    }

    public Page<Resource<T>> toResourcesPage(Page<T> page) {
        Assert.notNull(page);
        return new PageImpl<>(
            toResources(page.getContent()),
            new PageRequest(page.getNumber(), page.getSize(), page.getSort()),
            page.getTotalElements());
    }

    protected Resource<T> createResourceWithId(T entity, Object... parameters) {
        Assert.notNull(entity);

        Resource<T> instance = instantiateResource(entity);
        instance.add(selfLink(entity).withSelfRel());
        return instance;
    }

    protected ControllerLinkBuilder selfLink(T entity) {
        return linkTo(controllerClass).slash(entity.getId());
    }

    protected Resource<T> instantiateResource(T entity) {
        return new Resource<T>(entity);
    }
}
