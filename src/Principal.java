import javax.swing.*;
import java.io.IOException;

public class Principal {
    public static void main(String[] args) throws IOException {

        try {
            String monedaBase = JOptionPane.showInputDialog(null,
                    "Seleccione la moneda base:\n" + "Ejemplo USD, CRC, EUR..ETC",
                    "Moneda base", JOptionPane.QUESTION_MESSAGE);

            String monedaDestino = JOptionPane.showInputDialog(null,
                    "Seleccione la moneda destino:\n" + "Ejemplo USD, CRC, EUR..ETC",
                    "Moneda destino", JOptionPane.QUESTION_MESSAGE);

            double cantidad = Double.parseDouble(JOptionPane.showInputDialog(null,
                    "Digite la cantidad para ser la convesion:\n" + "Ejemplo 200, 159.32, 313.2",
                    "Cantidad", JOptionPane.QUESTION_MESSAGE));

            ConsultaMonedas consultaMonedas = new ConsultaMonedas();
            Conversion conversion = consultaMonedas.FactoryConversionMoneda(monedaBase, monedaDestino, cantidad);

            new GeneradorDeArchivos().guardarArchivoJson(conversion);

            // Mostrar número de opción seleccionada
            JOptionPane.showMessageDialog(null, "El resultado de su conversion es: " + conversion.toString(),
                    "Resultado de la conversion", JOptionPane.INFORMATION_MESSAGE);

        }catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Recuerda verificar si nombro bien la " +
                    "moneda y puso de forma numerica la cantidad");
        }
    }
}
