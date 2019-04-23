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
                break;
            case "creditCardSilver":
                factory = new SilverFactory();
                break;
            case "creditCardBronze":
                factory = new BronzeFactory();
                break;
            default:
                break;
        }

        return factory;
    }

}
