package task8.opt6;

// Context Class
class Context {
    private State state;

    public Context() {
        this.state = new ConcreteStateA(this); // Начальное состояние
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void request() {
        state.handle();
    }
}

// State interface
interface State {
    void handle();
}

// Concrete State A
class ConcreteStateA implements State {
    private Context context;

    public ConcreteStateA(Context context) {
        this.context = context;
    }

    @Override
    public void handle() {
        System.out.println("State A handling request and changing the state to B.");
        context.setState(new ConcreteStateB(context));
    }
}

// Concrete State B
class ConcreteStateB implements State {
    private Context context;

    public ConcreteStateB(Context context) {
        this.context = context;
    }

    @Override
    public void handle() {
        System.out.println("State B handling request and changing the state to A.");
        context.setState(new ConcreteStateA(context));
    }
}

// Client code
class StateClient {
    public static void main(String[] args) {
        Context context = new Context();

        context.request(); // Обработка в состоянии A и переключение в состояние B
        context.request(); // Обработка в состоянии B и переключение обратно в состояние A
    }
}
