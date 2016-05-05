package huan;

import org.easyrules.api.JmxRulesEngine;


import java.util.Scanner;

import static org.easyrules.core.JmxRulesEngineBuilder.aNewJmxRulesEngine;


public class Launcher {

    public static void main(String[] args) {

        //create a person instance
        Person tom = new Person("Tom", 14);
        System.out.println("Tom:  Hi! can I have some Vodka please?");

        //create a Jmx rules engine
        JmxRulesEngine rulesEngine = aNewJmxRulesEngine()
                .named("shop rules engine")
                .build();

        //register rules
        rulesEngine.registerJmxRule(new AgeRule(tom));
        rulesEngine.registerRule(new AlcoholRule(tom));

        //fire rules
        rulesEngine.fireRules();

        // Update adult age via a JMX client.
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
        System.out.println("Change adult age via a JMX client and then press enter");
        scanner.nextLine();

        System.out.println("Re fire rules after updating adult age...");

        rulesEngine.fireRules();
    }

}

/**
 * Launcher class of the Hello World sample.
 */
//public class Launcher {
//
//    @SuppressWarnings("resource")
//	public static void main(String[] args) {
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Are you a friend of duke? [yes/no]:");
//        String input = scanner.nextLine();
//
//        /**
//         * Declare the rule
//         */
//        HelloWorldRule helloWorldRule = new HelloWorldRule();
//
//        /**
//         * Set business data to operate on
//         */
//        helloWorldRule.setInput(input.trim());
//
//        /**
//         * Create a rules engine and register the business rule
//         */
//        RulesEngine rulesEngine = aNewRulesEngine()
//                .named("Hello world rules engine")
//                .build();
//
//        rulesEngine.registerRule(helloWorldRule);
//
//        /**
//         * Fire rules
//         */
//        rulesEngine.fireRules();
//
//    }
//}
