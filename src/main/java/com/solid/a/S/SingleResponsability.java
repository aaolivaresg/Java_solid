package com.solid.a.S;

/**
 * Una clase debe tener una una razón para cambiar.
 * Cada clase debe tener una sola responsabilidad, y esa responsabilidad debe estar encapsulada en su totalidad por la clase.
 * Todas sus servicios deben estar estrechamente alineados con esa responsabilidad.
 * No debe haber más de una razón para cambiar una clase.
 * Si una clase tiene más de una responsabilidad, se convierte en dependiente de las otras responsabilidades.
 * Los cambios en otras responsabilidades pueden afectar negativamente la funcionalidad de la clase.
 *
 */

public class SingleResponsability {
    public static void main(String[] args) {
        System.out.println("Single Responsability Principle");
    }
}

/**
 * En este ejemplo, la clase OrderService tiene dos responsabilidades:
 * 1. Insertar una orden en la base de datos.
 * 2. Enviar una factura por correo electrónico.
 * Si la lógica de envío de correo electrónico cambia, la clase OrderService también debe cambiar.
 * Por lo tanto, la clase OrderService tiene más de una razón para cambiar.
 * Para resolver este problema, debemos dividir la clase OrderService en dos clases.
 */
class OrderService {
    public void saveOrder(){
        insertOrder(new Order());
        emailInvoice(new Invoice());
    }

    public boolean insertOrder(Order order){
        System.out.println("Order inserted");
        return true;
    }

    public void emailInvoice(Invoice invoice){
        System.out.println("Invoice emailed");
    }
}


/**
 * La clase OrderService se divide en dos clases: OrderRepository y InvoiceService.
 * La clase OrderRepository es responsable de insertar una orden en la base de datos.
 * La clase InvoiceService es responsable de enviar una factura por correo electrónico.
 * Si la lógica de envío de correo electrónico cambia, solo la clase InvoiceService debe cambiar.
 * Por lo tanto, la clase InvoiceService tiene una sola razón para cambiar.
 */
class OrderServiceFixed {

    private OrderRepository orderRepository;
    private InvoiceService invoiceService;

    public void saveOrder(){
        orderRepository.insertOrder(new Order());
        invoiceService.emailInvoice(new Invoice());
    }


}
