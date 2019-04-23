package card.Model;

import framework.AccountBuilder;
import framework.IFactory;

public class CardCustomerAccountBuilder extends AccountBuilder {

    public static IFactory getFactoryAccount(String string)
    {
        IFactory factory = null;

        switch (string) {
            case "creditCardGold":
                factory = new GoldFactory();
            case "creditCardSilver":
                factory = new SilverFactory();
            case "creditCardBronze":
                factory = new BronzeFactory();
            default:
                break;
        }

        return factory;
    }

}
