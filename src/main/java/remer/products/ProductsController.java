package remer.products;

import io.reactivex.rxjava3.annotations.NonNull;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;

public class ProductsController
{
    private final ProductsService service;
    private final JLabel[] imageLabels;
    private @NonNull ProductsResponse products;

    public ProductsController(ProductsService service, JLabel[] images)
    {
        this.service = service;
        this.imageLabels = images;
    }

    public void display()
    {
        // get the response object
        ProductsResponse products = service.getProducts().blockingGet();
        this.products = service.getProducts().blockingGet();

        for (int i = 0; i < 9; i++)
        {
            Product product = products.products[i];
            try
            {
                URL url = new URL(product.thumbnail);
                Image image = ImageIO.read(url);
                ImageIcon imageIcon = new ImageIcon(image);
                imageLabels[i].setIcon(imageIcon);
            } catch (IOException e)
            {
                throw new RuntimeException(e);
            }

            final int index = i;
            imageLabels[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
            imageLabels[i].addMouseListener(new MouseAdapter()
            {
                @Override
                public void mouseClicked(MouseEvent e)
                {
                    new ProductDetailFrame(products.products[index]).setVisible(true);
                }
            });

        }

    }

}
