package remer.products;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class ProductDetailFrame extends JFrame
{

    public ProductDetailFrame(Product product)
    {
        setTitle(product.title);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 300);
        setLayout(new BorderLayout(10, 10));

        // Larger image
        JLabel imageLabel = new JLabel();
        try
        {
            URL url = new URL(product.thumbnail);
            Image image = ImageIO.read(url);
            if (image != null)
            {
                Image scaledImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                imageLabel.setIcon(new ImageIcon(scaledImage));
            }
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }

        // For the text panel
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.add(new JLabel("<html><b>" + product.title + "</b></html>"));
        textPanel.add(Box.createVerticalStrut(10));
        JTextArea descriptionArea = new JTextArea(product.description);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setEditable(false);
        descriptionArea.setOpaque(false);
        textPanel.add(descriptionArea);
        textPanel.add(Box.createVerticalStrut(10));
        textPanel.add(new JLabel(String.format("Price: " + product.price)));

        add(imageLabel, BorderLayout.WEST);
        add(textPanel, BorderLayout.CENTER);
    }

}
