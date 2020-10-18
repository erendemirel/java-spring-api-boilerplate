package constants;


/**
 * Contants related with domain. Enums were not used to
 * enable usage in switch-case statements
 *
 * @author Eren Demirel <eren.demirel@payten.com>
 */
public final class Constants {

    public final class User {
        public static final String MERCHANT_USER = "Merchant User";
        public static final String CUSTOM_USER = "Custom User";
    }

    public final class ThreeDModels {
        public static final String PAY = "PAY";
        public static final String PAY_HOSTING = "PAY HOSTING";
        public static final String ThreeD = "3D";
        public static final String ThreeD_HOSTING = "3D HOSTING";
        public static final String ThreeD_PAY = "3D PAY";
        public static final String ThreeD_PAY_HOSTING = "3D PAY HOSTING";
    }

    public final class TranType {
        public static final String PREAUTH = "PreAuth";
        public static final String SALE = "SALE";

    }
}
