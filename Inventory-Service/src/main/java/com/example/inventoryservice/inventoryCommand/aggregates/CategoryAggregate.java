package com.example.inventoryservice.inventoryCommand.aggregates;



import com.example.commonapi.commands.CreateCategorieCommand;
import com.example.commonapi.commands.UpdateCategorieCommand;
import com.example.commonapi.events.CategorieCreatedEvent;
import com.example.commonapi.events.CategorieUpdatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class CategoryAggregate {
    @AggregateIdentifier
    private String id;
    private String nom ;
    private String description ;

    public CategoryAggregate() {
    }

    @CommandHandler
    public CategoryAggregate(CreateCategorieCommand command) {
        AggregateLifecycle.apply(
                new CategorieCreatedEvent(
                        command.getId(),
                        command.getNom(),
                        command.getDescription()

                )
        );
    }

    @EventSourcingHandler
    public void on(CategorieCreatedEvent event) {
        this.id = event.getId();
        this.nom = event.getNom();
        this.description = event.getDescription();
    }

    @CommandHandler
    public void handle(UpdateCategorieCommand command) {
        AggregateLifecycle.apply(
                new CategorieUpdatedEvent(
                        command.getId(),
                        command.getNom(),
                        command.getDescription()
                )
        );
    }

    @EventSourcingHandler
    public void on(CategorieUpdatedEvent event) {
        this.id = event.getId();
        this.nom = event.getNom();
        this.description = event.getDescription();
    }
}
