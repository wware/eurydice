package net.willware.eurydice.core;

import java.util.HashMap;

/**
 * An extensible representation of colors, adaptable to the needs of whatever
 * graphics or display system is being used for visualization.
 */
public class Color {

    private int red;
    private int green;
    private int blue;

    private static ColorFactory factory;

    /**
     * A factory for creating Color objects.
     */
    public interface ColorFactory {
        Color getColor(int red, int green, int blue);
    }

    private static HashMap<Integer,Color> colorCache = new HashMap<Integer,Color>();

    /**
     * Returns a color, given red, green, and blue values, returning a color type
     * friendly to the graphics system if the color factory has been set.
     *
     * @param red the red value, between 0 and 255 inclusive
     * @param green the green value, between 0 and 255 inclusive
     * @param blue the blue value, between 0 and 255 inclusive
     * @return the color
     */
    public static Color getColor(int red, int green, int blue) {
        Color c;
        if (red < 0 || red > 255 || green < 0 || green > 255 || blue < 0 || blue > 255)
            throw new IllegalArgumentException();
        int hashkey = (red << 16) | (green << 8) | blue;
        if (colorCache.containsKey(hashkey))
            return colorCache.get(hashkey);
        if (factory != null)
            c = factory.getColor(red, green, blue);
        else
            c = new Color();
        c.setRed(red);
        c.setGreen(green);
        c.setBlue(blue);
        colorCache.put(hashkey, c);
        return c;
    }

    public static Color getColor(String colorname) {
        if ("Black".equals(colorname) || "black".equals(colorname))
            return getColor(0, 0, 0);
        else if ("Gray10".equals(colorname) || "gray10".equals(colorname))
            return getColor(26, 26, 26);
        else if ("Gray20".equals(colorname) || "gray20".equals(colorname))
            return getColor(51, 51, 51);
        else if ("Gray30".equals(colorname) || "gray30".equals(colorname))
            return getColor(77, 77, 77);
        else if ("Gray40".equals(colorname) || "gray40".equals(colorname))
            return getColor(102, 102, 102);
        else if ("Gray50".equals(colorname) || "gray50".equals(colorname))
            return getColor(128, 128, 128);
        else if ("Gray60".equals(colorname) || "gray60".equals(colorname))
            return getColor(154, 154, 154);
        else if ("Gray70".equals(colorname) || "gray70".equals(colorname))
            return getColor(179, 179, 179);
        else if ("Gray80".equals(colorname) || "gray80".equals(colorname))
            return getColor(204, 204, 204);
        else if ("Gray90".equals(colorname) || "gray90".equals(colorname))
            return getColor(230, 230, 230);
        else if ("White".equals(colorname) || "white".equals(colorname))
            return getColor(255, 255, 255);

        else if ("Red".equals(colorname) || "red".equals(colorname))
            return getColor(255, 0, 0);
        else if ("Green".equals(colorname) || "green".equals(colorname))
            return getColor(0, 255, 0);
        else if ("Blue".equals(colorname) || "blue".equals(colorname))
            return getColor(0, 0, 255);
        else if ("Cyan".equals(colorname) || "cyan".equals(colorname))
            return getColor(0, 255, 255);
        else if ("Magenta".equals(colorname) || "magenta".equals(colorname))
            return getColor(255, 0, 255);
        else if ("Yellow".equals(colorname) || "yellow".equals(colorname))
            return getColor(255, 255, 0);

        else if ("Orange".equals(colorname) || "orange".equals(colorname))
            return getColor(255, 132, 0);
        else if ("Purple".equals(colorname) || "purple".equals(colorname))
            return getColor(162, 0, 255);

        throw new IllegalArgumentException(colorname);
    }

    /**
     * Sets the color factory. Typical usage will be something like this.
     * <pre>
     * public class WhateverGraphicsSystem implements Color.ColorFactory {
     *     class MyColor extends Color {
     *         public MyColor(int red, int green, int blue) {
     *             ...map RGB to a graphics system native color...
     *         }
     *     };
     *     public Color getColor(int red, int green, int blue) {
     *         return new MyColor(red, green, blue);
     *     }
     *     public WhateverGraphicsSystem() {
     *         Color.setFactory(this);
     *         ....
     *     }
     * }
     * </pre>
     * You should set up the color factory before instantiating any atoms. Atoms
     * instantiated before the color factory is set will be assigned colors that
     * are instances of this base class, not the graphics system native color class.
     *
     * @param f the new color type
     */
    public static void setFactory(ColorFactory f) {
        factory = f;
    }

    /**
     * Sets the red value.
     *
     * @param red the new red value, between 0 and 255 inclusive
     */
    public void setRed(int red) {
        if (red < 0 || red > 255)
            throw new IllegalArgumentException("" + red);
        this.red = red;
    }

    /**
     * Gets the red value.
     *
     * @return the red value
     */
    public int getRed() {
        return red;
    }

    /**
     * Sets the green value.
     *
     * @param green the new green value, between 0 and 255 inclusive
     */
    public void setGreen(int green) {
        if (green < 0 || green > 255)
            throw new IllegalArgumentException("" + green);
        this.green = green;
    }

    /**
     * Gets the green value.
     *
     * @return the green value
     */
    public int getGreen() {
        return green;
    }

    /**
     * Sets the blue value.
     *
     * @param blue the new blue value, between 0 and 255 inclusive
     */
    public void setBlue(int blue) {
        if (blue < 0 || blue > 255)
            throw new IllegalArgumentException("" + blue);
        this.blue = blue;
    }

    /**
     * Gets the blue value.
     *
     * @return the blue value
     */
    public int getBlue() {
        return blue;
    }

}
