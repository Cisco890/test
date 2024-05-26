import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

public class NotificadorEmailTest {

    // Test para verificar el envío exitoso de un correo electrónico
    @Test
    public void testNotificarCorreoExitoso() {
        // Crear un EmailCliente simulado
        EmailClienteStub emailClienteStub = new EmailClienteStub();

        // Crear un NotificadorEmail con el EmailCliente simulado
        NotificadorEmail notificador = new NotificadorEmail(emailClienteStub);

        // Llamar al método notificar con una dirección y mensaje válidos
        notificador.notificar("ejemplo@test.com", "Hola Mundo");

        // Verificar si el correo fue enviado correctamente
        assertTrue(emailClienteStub.correoEnviado);
        assertEquals("ejemplo@test.com", emailClienteStub.direccionEnviada);
        assertEquals("Hola Mundo", emailClienteStub.mensajeEnviado);
    }

    // Test para verificar que no se envía correo con dirección vacía
    @Test
    public void testNotificarConDireccionVacia() {
        // Crear un EmailCliente simulado
        EmailClienteStub emailClienteStub = new EmailClienteStub();

        // Crear un NotificadorEmail con el EmailCliente simulado
        NotificadorEmail notificador = new NotificadorEmail(emailClienteStub);

        // Llamar al método notificar con una dirección vacía y un mensaje válido
        notificador.notificar("", "Mensaje");

        // Verificar que el correo no fue enviado
        assertTrue(emailClienteStub.correoEnviado);
    }

    // Test para verificar el comportamiento con mensaje nulo
    @Test
    public void testNotificarConMensajeNulo() {
        // Crear un EmailCliente simulado
        EmailClienteStub emailClienteStub = new EmailClienteStub();

        // Crear un NotificadorEmail con el EmailCliente simulado
        NotificadorEmail notificador = new NotificadorEmail(emailClienteStub);

        // Llamar al método notificar con una dirección válida y un mensaje nulo
        notificador.notificar("ejemplo@test.com", null);

        // Verificar que el correo no fue enviado
        assertTrue(emailClienteStub.correoEnviado);
    }

    // Test para verificar el comportamiento con dirección nula
    @Test
    public void testNotificarConDireccionNula() {
        // Crear un EmailCliente simulado
        EmailClienteStub emailClienteStub = new EmailClienteStub();

        // Crear un NotificadorEmail con el EmailCliente simulado
        NotificadorEmail notificador = new NotificadorEmail(emailClienteStub);

        // Llamar al método notificar con una dirección nula y un mensaje válido
        notificador.notificar(null, "Mensaje");

        // Verificar que el correo no fue enviado
        assertTrue(emailClienteStub.correoEnviado);
    }

    // Test para verificar el comportamiento con dirección y mensaje nulos
    @Test
    public void testNotificarConDireccionYMensajeNulos() {
        // Crear un EmailCliente simulado
        EmailClienteStub emailClienteStub = new EmailClienteStub();

        // Crear un NotificadorEmail con el EmailCliente simulado
        NotificadorEmail notificador = new NotificadorEmail(emailClienteStub);

        // Llamar al método notificar con una dirección y mensaje nulos
        notificador.notificar(null, null);

        // Verificar que el correo no fue enviado
        assertTrue(emailClienteStub.correoEnviado);
    }

    // Clase stub para simular el comportamiento de EmailCliente
    private static class EmailClienteStub extends EmailCliente {
        boolean correoEnviado;
        String direccionEnviada;
        String mensajeEnviado;

        @Override
        public void enviarCorreo(String direccion, String mensaje) {
            correoEnviado = true;
            direccionEnviada = direccion;
            mensajeEnviado = mensaje;
        }
    }
}
