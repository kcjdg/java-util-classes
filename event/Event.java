import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Event <T>{
    //Using CopyOnWriteArrayList for thread safety during iteration
    private final List<EventHandler<T>> handlers = new CopyOnWriteArrayList<>();

    //Add (subscribe) an event handler
    public void addHandler(EventHandler<T> handler){
        handlers.add(handler);
    }

    //Remove (unsubscribe) an event handler
    public void removeHandlers(EventHandler<T> handler){
        handlers.remove(handler);
    }

    //Clear all event handlers
    public void clearHandlers(){
        handlers.clear();
    }

    //Check if the event has any handlers
    public boolean hasHandlers(){
        return !handlers.isEmpty();
    }

    //Get the number of handlers
    public int handlersCount(){
        return handlers.size();
    }

    //Fire (trigger) an event for all handlers
    public void fire(T args){
        for(EventHandler<T> handler: handlers){
            handler.handle(args);
        }
    }
}
