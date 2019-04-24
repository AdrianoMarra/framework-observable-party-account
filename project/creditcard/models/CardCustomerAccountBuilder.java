package creditcard.models;

import framework.models.AccountBuilder;
import framework.models.IFactory;

public class CardCustomerAccountBuilder extends AccountBuilder {

    public static CreditCardFactory getFactoryAccount(String string)
    {
    	CreditCardFactory factory = null;

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
