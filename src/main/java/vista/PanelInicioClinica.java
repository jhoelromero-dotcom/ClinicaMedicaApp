package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/** Maqueta visual de las opciones de la clínica. */
public class PanelInicioClinica extends JPanel {
    private static final Color TINTA = new Color(25, 47, 70);
    private static final Color GRIS = new Color(101, 119, 139);
    private static final Color VERDE = new Color(0, 126, 119);

    public PanelInicioClinica() {
        super(new BorderLayout());
        setBackground(new Color(242, 247, 248));

        JPanel lateral = new JPanel(new BorderLayout());
        lateral.setBackground(new Color(18, 48, 58));
        lateral.setBorder(new EmptyBorder(30, 24, 28, 24));
        lateral.setPreferredSize(new Dimension(210, 0));
        JPanel marca = columna();
        marca.add(etiqueta("✚", 34, new Color(93, 221, 192), true));
        marca.add(Box.createVerticalStrut(12));
        marca.add(etiqueta("Clínica médica", 20, Color.WHITE, true));
        marca.add(etiqueta("PANEL DE GESTIÓN", 10, new Color(159, 195, 192), true));
        marca.add(Box.createVerticalStrut(55));
        marca.add(etiqueta("●  Inicio", 14, new Color(100, 225, 197), true));
        marca.add(Box.createVerticalStrut(25));
        marca.add(etiqueta("Pacientes", 14, new Color(192, 213, 211), false));
        marca.add(Box.createVerticalStrut(20));
        marca.add(etiqueta("Médicos", 14, new Color(192, 213, 211), false));
        marca.add(Box.createVerticalStrut(20));
        marca.add(etiqueta("Citas", 14, new Color(192, 213, 211), false));
        lateral.add(marca, BorderLayout.NORTH);
        lateral.add(etiqueta("Cuidado en cada detalle", 11, new Color(159, 195, 192), false), BorderLayout.SOUTH);
        add(lateral, BorderLayout.WEST);

        JPanel contenido = columna();
        contenido.setBorder(new EmptyBorder(35, 38, 35, 38));
        contenido.add(etiqueta("INICIO  /  RESUMEN", 11, VERDE, true));
        contenido.add(Box.createVerticalStrut(12));
        contenido.add(etiqueta("Bienvenido a tu clínica", 30, TINTA, true));
        contenido.add(Box.createVerticalStrut(8));
        contenido.add(etiqueta("Todo lo que necesitas para organizar la atención, en un solo lugar.", 14, GRIS, false));
        contenido.add(Box.createVerticalStrut(26));

        JPanel bienvenida = tarjeta(new Color(218, 244, 237));
        bienvenida.setLayout(new BorderLayout(20, 0));
        JPanel texto = columna();
        texto.add(etiqueta("GESTIÓN DE LA CLÍNICA", 11, VERDE, true));
        texto.add(Box.createVerticalStrut(10));
        texto.add(etiqueta("Una mejor atención comienza aquí", 21, TINTA, true));
        texto.add(Box.createVerticalStrut(6));
        texto.add(etiqueta("Pacientes, profesionales y citas en un mismo espacio.", 13, GRIS, false));
        bienvenida.add(texto, BorderLayout.CENTER);
        JLabel cruz = etiqueta("✚", 52, new Color(0, 126, 119, 100), true);
        bienvenida.add(cruz, BorderLayout.EAST);
        bienvenida.setMaximumSize(new Dimension(Integer.MAX_VALUE, 150));
        bienvenida.setAlignmentX(LEFT_ALIGNMENT);
        contenido.add(bienvenida);
        contenido.add(Box.createVerticalStrut(27));
        contenido.add(etiqueta("Áreas de trabajo", 20, TINTA, true));
        contenido.add(Box.createVerticalStrut(6));
        contenido.add(etiqueta("Explora las opciones disponibles para la gestión diaria.", 13, GRIS, false));
        contenido.add(Box.createVerticalStrut(16));

        JPanel tarjetas = new JPanel(new GridLayout(1, 3, 16, 0));
        tarjetas.setOpaque(false);
        tarjetas.add(area("01", "Pacientes", "Información de pacientes", "Registrar paciente", "Listar pacientes"));
        tarjetas.add(area("02", "Médicos", "Equipo médico de la clínica", "Registrar médico", "Listar médicos"));
        tarjetas.add(area("03", "Citas", "Organización de la atención", "Programar cita", "Listar citas", "Cambiar estado de cita"));
        tarjetas.setMaximumSize(new Dimension(Integer.MAX_VALUE, 230));
        tarjetas.setAlignmentX(LEFT_ALIGNMENT);
        contenido.add(tarjetas);
        contenido.add(Box.createVerticalStrut(25));
        contenido.add(etiqueta("Vista de presentación · Funciones pendientes de implementar", 12, GRIS, false));

        JScrollPane scroll = new JScrollPane(contenido);
        scroll.setBorder(BorderFactory.createEmptyBorder());
        scroll.getViewport().setBackground(new Color(242, 247, 248));
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        add(scroll, BorderLayout.CENTER);
    }

    private static JPanel area(String numero, String nombre, String descripcion, String... opciones) {
        JPanel panel = tarjeta(Color.WHITE);
        panel.setLayout(new BorderLayout(0, 12));
        JPanel titulo = columna();
        titulo.add(etiqueta(numero + "  /  " + nombre.toUpperCase(java.util.Locale.ROOT), 10, VERDE, true));
        titulo.add(Box.createVerticalStrut(12));
        titulo.add(etiqueta(nombre, 20, TINTA, true));
        titulo.add(Box.createVerticalStrut(5));
        titulo.add(etiqueta(descripcion, 12, GRIS, false));
        panel.add(titulo, BorderLayout.NORTH);
        JPanel lista = columna();
        for (String opcion : opciones) {
            lista.add(etiqueta("›   " + opcion, 13, TINTA, false));
            lista.add(Box.createVerticalStrut(10));
        }
        panel.add(lista, BorderLayout.CENTER);
        return panel;
    }

    private static JLabel etiqueta(String texto, int tamaño, Color color, boolean negrita) {
        JLabel etiqueta = new JLabel(texto, SwingConstants.LEFT);
        etiqueta.setFont(new Font("Segoe UI", negrita ? Font.BOLD : Font.PLAIN, tamaño));
        etiqueta.setForeground(color);
        etiqueta.setAlignmentX(LEFT_ALIGNMENT);
        return etiqueta;
    }

    private static JPanel columna() {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        return panel;
    }

    private static JPanel tarjeta(Color color) {
        JPanel panel = new JPanel() {
            @Override protected void paintComponent(Graphics graphics) {
                super.paintComponent(graphics);
                Graphics2D g = (Graphics2D) graphics.create();
                g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g.setColor(color);
                g.fillRoundRect(0, 0, getWidth(), getHeight(), 22, 22);
                g.dispose();
            }
        };
        panel.setOpaque(false);
        panel.setBorder(new EmptyBorder(22, 22, 22, 22));
        return panel;
    }
}
