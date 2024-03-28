package task7.opt6;

// Интерфейс, представляющий функциональность сервиса
interface ServiceInterface {
    void performAction();
}

// Реальный сервис, который выполняет некоторую полезную работу
class RealService implements ServiceInterface {
    @Override
    public void performAction() {
        System.out.println("RealService: Performing action");
    }
}

// Заместитель (Proxy), который контролирует доступ к реальному сервису
class ProxyService implements ServiceInterface {
    private RealService realService;
    private boolean hasAccess;

    public ProxyService(boolean hasAccess) {
        this.hasAccess = hasAccess;
    }

    // Ленивая инициализация: создаем RealService только при необходимости
    private RealService getRealService() {
        if (realService == null) {
            realService = new RealService();
        }
        return realService;
    }

    @Override
    public void performAction() {
        if (hasAccess) {
            getRealService().performAction();
        } else {
            System.out.println("ProxyService: Access denied");
        }
    }
}

// Клиентский код, который работает с сервисом через заместителя
class ProxyClient {
    public static void main(String[] args) {
        ServiceInterface service = new ProxyService(true);
        service.performAction(); // Будет выполняться действие, так как доступ есть

        ServiceInterface serviceWithoutAccess = new ProxyService(false);
        serviceWithoutAccess.performAction(); // Доступа нет, действие не будет выполнено
    }
}
