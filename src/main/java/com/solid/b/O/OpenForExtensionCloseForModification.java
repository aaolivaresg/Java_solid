package com.solid.b.O;

/**
 * Open for extension, close for modification.
 * Esta clase es un ejemplo de como no hacerlo.
 */
public class OpenForExtensionCloseForModification {


}

/**
 * Esta clase es un ejemplo de como no hacerlo.
 * Si se quiere agregar un nuevo método de pago, se debe modificar la clase PayAmount.
 * Esto viola el principio de Open for extension, close for modification.
 * Para resolver este problema, debemos crear una interfaz PaymentMethod y crear una clase para cada método de pago.
 * Luego, la clase PayAmount debe tener una referencia a la interfaz PaymentMethod.
 * De esta manera, si se quiere agregar un nuevo método de pago, no se debe modificar la clase PayAmount.
 * Solo se debe crear una nueva clase que implemente la interfaz PaymentMethod.
 * La clase PayAmount no se ve afectada por este cambio.
 * La clase PayAmount solo se modifica cuando se agrega un nuevo método de pago.
 * Por lo tanto, la clase PayAmount tiene una sola razón para cambiar.
 * La clase PayAmount tiene una razón para cambiar cuando se agrega un nuevo método de pago.
 * La clase PayAmount no tiene una razón para cambiar cuando se agrega un nuevo tipo de producto.
 *
 */



class  PayAmount(){
    public void pay(String typeOFCard){

        if(typeOFCard.equals("MASTER")) {
            //logic to pay with credit card
        } else if(typeOFCard.equals("VISA")) {
            //logic to pay with credit card
        } else if(typeOFCard.equals("AMEX")) {
            //logic to pay with credit card
        } else if(typeOFCard.equals("PAYPAL")) {
            //logic to pay with paypal
        } else if(typeOFCard.equals("CASH")) {
            //logic to pay with cash
        } else if(typeOFCard.equals("OTHER")) {
            //logic to pay with other method
        }
    }
}





interface PaymentMethod{
    void pay();
}

class MasterCardPayment implements PaymentMethod{
    @Override
    public void pay() {
        //logic to pay with credit card
    }
}

class VisaPayment implements PaymentMethod{
    @Override
    public void pay() {
        //logic to pay with credit card
    }
}

class AmexPayment implements PaymentMethod{
    @Override
    public void pay() {
        //logic to pay with credit card
    }
}

class PaypalPayment implements PaymentMethod{
    @Override
    public void pay() {
        //logic to pay with paypal
    }
}

class CashPayment implements PaymentMethod{
    @Override
    public void pay() {
        //logic to pay with cash
    }
}

class OtherPayment implements PaymentMethod{
    @Override
    public void pay() {
        //logic to pay with other method
    }
}


class PayAmountFixed{

    private PaymentMethod paymentMethod;

    public void pay(){
        paymentMethod.pay();
    }

    public void setPaymentMethod(PaymentMethod paymentMethod){
        this.paymentMethod = paymentMethod;
    }
}

class UsePayAmountFixed{
    public static void main(String[] args) {
        PayAmountFixed payAmountFixed = new PayAmountFixed();

        payAmountFixed.setPaymentMethod(new CashPayment());

        payAmountFixed.setPaymentMethod(new MasterCardPayment());
        payAmountFixed.pay();
    }
}
