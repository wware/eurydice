/**
 * FineMotionController.java
 * Copyright (c) 1997,2011 Will Ware, all rights reserved.
 */

package net.willware.eurydice.library;

import net.willware.eurydice.core.Atom;
import net.willware.eurydice.elements.Carbon;
import net.willware.eurydice.elements.Hydrogen;
import net.willware.eurydice.elements.Oxygen;
import net.willware.eurydice.elements.Nitrogen;
import net.willware.eurydice.elements.Fluorine;
import net.willware.eurydice.elements.Sulfur;
import net.willware.eurydice.elements.Silicon;
import net.willware.eurydice.math.Vector;
import net.willware.eurydice.nanocad.NanocadStyleStructure;

/**
 * Eric Drexler's fine motion controller design.
 */
public class FineMotionController extends NanocadStyleStructure {

    /**
     * Constructor needs a helper method because it would exceed the maximum compiled
     * Java method size of 65536 bytes.
     */
    public FineMotionController() {
        addAtom(new Hydrogen(),
                new Vector(9.699000, 21.971000, -15.576000));
        addAtom(new Hydrogen(),
                new Vector(9.831000, 20.715000, -17.431000));
        addAtom(new Hydrogen(),
                new Vector(10.612000, 20.785000, -20.971000));
        addAtom(new Hydrogen(),
                new Vector(10.188000, 20.691000, -23.195000));
        addAtom(new Hydrogen(),
                new Vector(-12.909000, -9.555000, -1.958000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-13.118000, 5.296000, -6.896000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.236000, 7.728000, -7.151000));
        addAtom(new Hydrogen(),
                new Vector(11.425000, 22.645000, -22.011000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(5.083000, 21.438000, -5.785000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-11.110000, 9.545000, 2.665000));
        addAtom(new Hydrogen(),
                new Vector(9.463000, 24.512000, -25.399000));
        addAtom(new Hydrogen(),
                new Vector(7.454000, 24.518000, -26.370000));
        addAtom(new Hydrogen(),
                new Vector(10.735000, 26.604000, -23.584000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.766000, 24.407000, -25.359000));
        addAtom(new Hydrogen(),
                new Vector(8.892000, 26.681000, -24.987000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(3.957000, 20.688000, -16.293000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-12.669000, 9.550000, 2.648000));
        addAtom(new Hydrogen(),
                new Vector(0.056000, 26.511000, -22.601000));
        addAtom(new Hydrogen(),
                new Vector(2.962000, 27.310000, -24.877000));
        addAtom(new Hydrogen(),
                new Vector(5.238000, 27.595000, -25.318000));
        addAtom(new Sulfur(Atom.SP3),
                new Vector(10.345000, 27.609000, -17.470000));
        addAtom(new Hydrogen(),
                new Vector(-13.180000, 9.119000, 4.670000));
        addAtom(new Hydrogen(),
                new Vector(6.781000, 29.566000, -23.767000));
        addAtom(new Hydrogen(),
                new Vector(4.492000, 29.167000, -23.785000));
        addAtom(new Hydrogen(),
                new Vector(-10.645000, 9.129000, 4.695000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(1.186000, 23.296000, -14.391000));
        addAtom(new Hydrogen(),
                new Vector(-10.622000, 10.516000, 2.905000));
        addAtom(new Hydrogen(),
                new Vector(-13.157000, 10.523000, 2.877000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-13.243000, 4.967000, 1.482000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.289000, 6.278000, 1.007000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.114000, 3.527000, -1.472000));
        addAtom(new Hydrogen(),
                new Vector(-18.963000, -0.664000, -3.278000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.849000, 2.562000, -0.680000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.102000, 1.334000, -0.555000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-10.172000, 4.967000, 1.534000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.824000, 0.165000, -1.011000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.173000, 6.277000, 1.053000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.072000, -0.532000, -2.029000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.799000, -0.741000, -3.264000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.465000, 9.333000, 0.318000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.064000, -0.207000, -4.387000));
        addAtom(new Hydrogen(),
                new Vector(18.811000, -0.411000, -1.797000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-10.241000, -1.688000, 2.122000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.804000, 0.751000, -5.177000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.081000, 2.000000, -5.278000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.833000, 3.154000, -4.844000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.245000, -4.031000, 2.884000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.113000, 3.882000, -3.825000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.853000, 4.053000, -2.596000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(3.749000, 18.741000, -18.441000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.128000, 7.736000, -7.126000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(3.624000, 24.436000, -9.132000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.226000, 9.349000, 0.280000));
        addAtom(new Hydrogen(),
                new Vector(-18.313000, -1.993000, -11.126000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(-18.389000, -3.226000, -9.580000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-17.911000, -2.090000, -10.120000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(2.757000, 19.723000, -20.839000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(-18.360000, -4.592000, -7.810000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-17.887000, -3.449000, -8.347000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-9.386000, 4.065000, -2.599000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-8.610000, -0.135000, -4.340000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-13.229000, -1.710000, 2.041000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(-18.368000, -5.989000, -6.064000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-17.878000, -4.840000, -6.575000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-8.629000, 2.054000, -5.257000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.339000, -4.048000, 2.815000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-8.646000, 3.580000, -1.474000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-8.651000, 3.941000, -3.825000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.410000, -5.408000, 2.717000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-9.959000, 5.310000, -6.882000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.183000, -5.428000, 2.664000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(5.446000, 19.922000, -4.000000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.036000, 15.873000, -8.728000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(4.321000, 14.407000, -6.907000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-10.928000, 9.921000, -7.750000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(1.827000, 22.922000, -13.225000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.141000, -4.239000, -5.328000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-13.208000, 6.432000, -0.374000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-10.075000, 6.427000, -0.331000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-12.486000, 9.921000, -7.768000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.233000, 8.806000, -0.950000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-11.059000, 10.722000, 0.264000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.233000, -3.051000, 1.860000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.330000, 8.810000, -0.997000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-12.616000, 10.733000, 0.242000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.268000, -3.076000, 1.783000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.395000, -6.189000, 1.577000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.173000, -6.220000, 1.528000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(2.875000, 17.661000, -11.687000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(1.977000, 19.235000, -13.253000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.160000, -4.344000, -5.389000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.235000, -6.784000, -5.392000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(3.570000, 16.119000, -9.995000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-1.345000, 21.558000, -13.366000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-17.886000, -6.238000, -4.834000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-18.214000, -5.226000, -3.937000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.238000, 7.438000, -1.336000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.070000, 7.438000, -1.292000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-17.739000, -4.000000, -4.420000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-18.148000, -3.769000, -5.720000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.403000, 9.881000, -1.825000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-17.692000, -2.563000, -6.223000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-18.153000, -2.363000, -7.511000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-17.749000, -1.154000, -8.048000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-18.232000, -0.978000, -9.350000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-11.028000, 11.080000, -1.140000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-17.828000, 0.241000, -9.859000));
        addAtom(new Hydrogen(),
                new Vector(-18.223000, 0.378000, -10.866000));
        addAtom(new Hydrogen(),
                new Vector(-18.279000, -7.194000, -4.497000));
        addAtom(new Hydrogen(),
                new Vector(-18.192000, -6.373000, -2.256000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-17.804000, -5.426000, -2.633000));
        addAtom(new Hydrogen(),
                new Vector(-18.213000, 2.682000, -10.549000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-17.816000, 2.546000, -9.540000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-18.171000, 1.308000, -9.045000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(5.028000, 17.796000, -5.695000));
        addAtom(new Hydrogen(),
                new Vector(-10.578000, 11.501000, 0.897000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-17.658000, 1.129000, -7.750000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-10.234000, -3.391000, 0.522000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-18.009000, -0.092000, -7.208000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-17.496000, -0.297000, -5.928000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.575000, 20.610000, -7.982000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-17.933000, -1.499000, -5.389000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.166000, 9.889000, -1.868000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-17.492000, -1.733000, -4.096000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-18.000000, -2.930000, -3.589000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-1.505000, 8.491000, 1.009000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(4.279000, 19.587000, -22.981000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-17.644000, -3.163000, -2.275000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-18.149000, -4.382000, -1.790000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-12.586000, 11.087000, -1.164000));
        addAtom(new Hydrogen(),
                new Vector(-18.180000, -5.511000, -0.094000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-17.786000, -4.566000, -0.471000));
        addAtom(new Hydrogen(),
                new Vector(-13.108000, 11.519000, 0.857000));
        addAtom(new Hydrogen(),
                new Vector(-18.274000, 4.992000, -10.212000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-17.877000, 4.852000, -9.205000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-13.205000, -3.433000, 0.447000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-18.194000, 3.591000, -8.722000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.216000, -5.833000, 0.245000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-17.686000, 3.413000, -7.424000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-17.963000, 2.170000, -6.898000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-17.430000, 1.995000, -5.622000));
        addAtom(new Hydrogen(),
                new Vector(-10.337000, -9.380000, -4.212000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-8.618000, -0.497000, -1.995000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-9.357000, 0.239000, -1.016000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-17.865000, 0.758000, -5.090000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-10.993000, -7.572000, 1.711000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-17.343000, 0.554000, -3.783000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-17.862000, -0.668000, -3.272000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-1.716000, 17.653000, -14.908000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-17.951000, -2.089000, -1.469000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-12.998000, -6.880000, -5.451000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-17.423000, -0.888000, -1.945000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-18.175000, -3.522000, 0.346000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-17.669000, -2.303000, -0.138000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-17.857000, -3.687000, 1.683000));
        addAtom(new Hydrogen(),
                new Vector(-18.247000, -4.633000, 2.060000));
        addAtom(new Hydrogen(),
                new Vector(-0.011000, 27.118000, -20.486000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(-18.484000, 8.100000, -7.973000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-17.988000, 7.976000, -6.727000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(7.576000, 19.546000, -18.683000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-18.242000, 6.697000, -6.227000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(5.058000, 19.323000, -18.170000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-17.781000, 6.537000, -4.933000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-18.002000, 5.277000, -4.428000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(0.558000, 25.753000, -21.952000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.319000, -5.880000, 0.185000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-17.563000, 5.150000, -3.120000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-15.795000, 6.349000, -2.271000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-17.911000, 3.890000, -2.627000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(-15.988000, -6.135000, -6.145000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-17.474000, 3.741000, -1.290000));
        addAtom(new Silicon(Atom.SP3),
                new Vector(-1.760000, 21.639000, -17.144000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(2.448000, 19.476000, -3.433000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-12.553000, -7.591000, 1.686000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-13.156000, 7.017000, -2.655000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-0.932000, 15.643000, -11.989000));
        addAtom(new Silicon(Atom.SP3),
                new Vector(1.404000, 25.029000, -14.465000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-0.472000, 15.810000, -10.704000));
        addAtom(new Hydrogen(),
                new Vector(-12.864000, -9.452000, -4.260000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.162000, 4.672000, -8.130000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.078000, 7.784000, -8.535000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-9.967000, 7.024000, -2.616000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.313000, 7.786000, -8.510000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.352000, 9.941000, -3.205000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-16.350000, 0.217000, -9.959000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-17.913000, 2.476000, -0.827000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-16.532000, 7.272000, -8.874000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(8.457000, 0.274000, -0.936000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-17.572000, 2.297000, 0.514000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-16.011000, 6.028000, -8.503000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-18.010000, 1.053000, 0.948000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-15.651000, -2.222000, -1.388000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-17.797000, 0.865000, 2.291000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-16.000000, -0.027000, 0.292000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-18.011000, -0.535000, 4.119000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-18.251000, -0.357000, 2.754000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-16.339000, 2.578000, -9.642000));
        addAtom(new Hydrogen(),
                new Vector(-10.537000, 12.065000, -1.306000));
        addAtom(new Hydrogen(),
                new Vector(-18.398000, 7.345000, -9.802000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-17.997000, 7.165000, -8.808000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-8.631000, 1.384000, -0.551000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-9.375000, 2.596000, -0.723000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(12.953000, 0.764000, -4.958000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(13.680000, -0.251000, -4.226000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(12.932000, -0.681000, -3.070000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(13.650000, -0.539000, -1.823000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(12.904000, 0.271000, -0.889000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(13.636000, 1.408000, -0.374000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(12.910000, 2.633000, -0.601000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(13.653000, 3.634000, -1.328000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(12.934000, 4.053000, -2.508000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(13.684000, 3.923000, -3.735000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(12.963000, 3.129000, -4.698000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(13.696000, 1.981000, -5.179000));
        addAtom(new Hydrogen(),
                new Vector(3.357000, 30.231000, -19.923000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-18.303000, 5.875000, -8.379000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.735000, 1.997000, -5.169000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(11.459000, 0.774000, -4.978000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.713000, -0.193000, -4.235000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-15.712000, 1.053000, 1.162000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(11.433000, -0.669000, -3.089000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.689000, -0.495000, -1.880000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(11.412000, 0.271000, -0.909000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.679000, 1.415000, -0.464000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(11.416000, 2.631000, -0.628000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.220000, -4.517000, -0.280000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.697000, 3.599000, -1.399000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-17.821000, 5.689000, -7.077000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(11.444000, 4.060000, -2.527000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-15.932000, 3.814000, -1.231000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(7.514000, 19.536000, -21.249000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.730000, 3.903000, -3.756000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(11.468000, 3.137000, -4.714000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-18.061000, 4.428000, -6.564000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.123000, 9.942000, -3.246000));
        addAtom(new Hydrogen(),
                new Vector(-16.128000, -7.331000, -4.564000));
        addAtom(new Hydrogen(),
                new Vector(-13.070000, 12.070000, -1.356000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.244000, -4.569000, -0.347000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-0.431000, 3.250000, -4.829000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(0.307000, 2.098000, -5.257000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-0.429000, 0.894000, -5.043000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.359000, -7.015000, -0.480000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-0.434000, -0.586000, -3.189000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(0.291000, -0.477000, -1.964000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-17.546000, 4.280000, -5.277000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-11.601000, 1.353000, -0.553000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-11.578000, -0.514000, -2.016000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.875000, 2.580000, -0.721000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(0.303000, -0.089000, -4.306000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(-16.017000, -3.339000, -9.722000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-11.617000, 3.546000, -1.470000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-17.891000, 3.026000, -4.768000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-11.588000, 2.021000, -5.270000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.886000, 4.046000, -2.598000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-0.444000, 0.272000, -0.994000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.872000, 3.169000, -4.803000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-15.818000, 3.411000, 1.486000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(0.284000, 1.426000, -0.578000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-11.616000, 3.899000, -3.821000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-15.756000, -1.305000, 0.814000));
        addAtom(new Hydrogen(),
                new Vector(-18.939000, 1.601000, -2.963000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-11.569000, -0.178000, -4.368000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.843000, 0.812000, -5.102000));
        addAtom(new Hydrogen(),
                new Vector(18.796000, 1.414000, -0.438000));
        addAtom(new Hydrogen(),
                new Vector(-19.013000, 2.458000, -0.852000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.838000, -0.647000, -3.230000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-16.029000, 2.324000, 0.626000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.856000, 0.226000, -1.023000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(9.235000, 3.917000, -3.773000));
        addAtom(new Hydrogen(),
                new Vector(1.480000, 28.580000, -21.834000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-17.368000, 2.869000, -3.455000));
        addAtom(new Hydrogen(),
                new Vector(-16.167000, -2.087000, -11.259000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-16.020000, 5.259000, -3.124000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-17.833000, 1.612000, -2.955000));
        addAtom(new Hydrogen(),
                new Vector(-16.106000, 2.726000, -10.696000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(7.344000, 24.144000, -25.325000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-17.367000, 1.427000, -1.617000));
        addAtom(new Hydrogen(),
                new Vector(-16.251000, 7.507000, -9.897000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-10.965000, -8.117000, 0.360000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-17.543000, -0.008000, 0.188000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-15.905000, 3.683000, -8.882000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-17.886000, 0.186000, -1.150000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(-16.121000, 8.282000, -8.069000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-15.969000, 6.885000, -6.319000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(7.505000, 21.654000, -24.235000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-17.816000, -1.421000, 1.985000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-18.051000, -1.227000, 0.641000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-15.310000, -0.747000, -3.267000));
        addAtom(new Sulfur(Atom.SP3),
                new Vector(11.185000, 25.350000, -20.539000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-18.291000, -2.643000, 2.476000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-15.806000, 0.559000, -3.783000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(0.202000, 14.931000, -8.612000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-17.994000, -2.750000, 3.830000));
        addAtom(new Hydrogen(),
                new Vector(-10.512000, -8.256000, 2.445000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(9.239000, 2.011000, -5.187000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(8.510000, 3.167000, -4.751000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(-18.502000, -1.722000, 4.534000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-15.998000, 5.742000, 1.810000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(9.216000, -0.179000, -4.253000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-15.731000, 4.903000, -0.372000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(8.495000, 0.803000, -5.014000));
        addAtom(new Hydrogen(),
                new Vector(18.852000, 1.953000, -4.988000));
        addAtom(new Hydrogen(),
                new Vector(18.843000, -0.139000, -4.078000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-0.442000, 4.117000, -2.634000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(-18.573000, 2.705000, 5.157000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(0.299000, 3.996000, -3.854000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-18.046000, 1.695000, 4.433000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.134000, -7.070000, -0.530000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-12.524000, -8.144000, 0.337000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.008000, 4.690000, -8.121000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(-18.517000, 0.495000, 4.827000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(2.123000, 20.219000, -5.638000));
        addAtom(new Hydrogen(),
                new Vector(-13.041000, -8.281000, 2.410000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-16.163000, -2.649000, -6.295000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.185000, 7.543000, -3.939000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-16.215000, 4.664000, 0.944000));
        addAtom(new Hydrogen(),
                new Vector(-18.444000, 10.494000, -1.990000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-18.035000, 9.675000, -2.578000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(-18.511000, 9.772000, -3.832000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-15.951000, -0.340000, -5.996000));
        addAtom(new Hydrogen(),
                new Vector(-18.345000, 9.079000, -0.064000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-17.944000, 8.281000, -0.691000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-15.315000, 0.746000, -5.177000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(1.787000, 3.591000, -1.524000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(2.515000, 2.636000, -0.760000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(2.523000, -0.597000, -3.172000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(2.544000, 3.236000, -4.814000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(2.538000, 0.876000, -5.039000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.778000, 2.069000, -5.210000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(2.531000, 4.108000, -2.624000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-18.346000, 8.448000, -2.002000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(1.807000, 2.090000, -5.252000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.775000, 3.972000, -3.818000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.030000, 4.113000, -2.605000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-9.982000, 7.552000, -3.904000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(1.797000, -0.098000, -4.301000));
        addAtom(new Hydrogen(),
                new Vector(-18.338000, 7.647000, 1.766000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-17.920000, 6.852000, 1.145000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.750000, 3.618000, -1.470000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.743000, -0.460000, -1.931000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.008000, 2.645000, -0.728000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-15.872000, -3.920000, -5.809000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.137000, 8.940000, -4.152000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.018000, -0.583000, -3.153000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(1.590000, 20.047000, -6.874000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.760000, -0.098000, -4.263000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(3.256000, 27.644000, -17.438000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(1.788000, -0.476000, -1.957000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.047000, 3.223000, -4.792000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(6.994000, 4.084000, -2.579000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.034000, 0.874000, -5.009000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-18.271000, 7.038000, -0.176000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.736000, 1.432000, -0.519000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-15.362000, 4.020000, -2.593000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(6.245000, 3.608000, -1.458000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-10.949000, 11.186000, -3.823000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(6.967000, 2.637000, -0.698000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-15.831000, 2.898000, -3.452000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(6.230000, 1.428000, -0.511000));
        addAtom(new Hydrogen(),
                new Vector(-18.396000, 6.200000, 3.590000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(6.962000, 0.281000, -0.950000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-17.981000, 5.406000, 2.968000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(6.237000, -0.474000, -1.922000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(0.217000, 22.057000, -9.580000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(6.253000, -0.132000, -4.269000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(6.999000, 0.823000, -5.024000));
        addAtom(new Hydrogen(),
                new Vector(18.834000, 3.797000, -3.619000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(6.276000, 2.048000, -5.214000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-15.362000, 2.545000, -0.705000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.008000, 0.284000, -0.964000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-10.917000, 9.099000, -8.951000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-18.289000, 5.614000, 1.634000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(7.013000, 3.185000, -4.767000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(8.489000, 4.078000, -2.562000));
        addAtom(new Hydrogen(),
                new Vector(18.778000, 1.689000, -2.712000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(1.805000, 3.988000, -3.848000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-16.418000, -6.331000, -4.874000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(6.275000, 3.950000, -3.805000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(9.204000, 3.603000, -1.419000));
        addAtom(new Hydrogen(),
                new Vector(-16.244000, -3.711000, 4.432000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(8.460000, 2.635000, -0.676000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(6.975000, -0.630000, -3.137000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-18.393000, 4.171000, 3.436000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(9.186000, 1.418000, -0.483000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-16.003000, 4.372000, -5.330000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(9.193000, -0.490000, -1.897000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(8.471000, -0.647000, -3.125000));
        addAtom(new Hydrogen(),
                new Vector(18.167000, 8.672000, 2.839000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(18.235000, 6.863000, 3.638000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(17.762000, 7.677000, 2.676000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(18.195000, 4.802000, 4.510000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(17.727000, 5.616000, 3.540000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-10.214000, -4.262000, -1.635000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(18.188000, 2.758000, 5.418000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(17.705000, 3.547000, 4.436000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.254000, 8.933000, -4.190000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(17.697000, 1.507000, 5.345000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(18.024000, 0.894000, 4.139000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-12.508000, 11.188000, -3.845000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(17.558000, 1.676000, 3.075000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(17.974000, 2.991000, 3.184000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(17.527000, 3.788000, 2.143000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-13.181000, -4.334000, -1.704000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(17.993000, 5.083000, 2.278000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.325000, -7.245000, -1.843000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(17.594000, 5.912000, 1.244000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(18.080000, 7.215000, 1.405000));
        addAtom(new Hydrogen(),
                new Vector(-10.462000, -9.110000, 0.322000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(17.675000, 8.020000, 0.355000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.095000, -7.315000, -1.895000));
        addAtom(new Hydrogen(),
                new Vector(18.079000, 9.026000, 0.482000));
        addAtom(new Hydrogen(),
                new Vector(18.085000, 0.937000, 6.186000));
        addAtom(new Hydrogen(),
                new Vector(17.986000, -1.023000, 4.823000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(17.604000, -0.415000, 4.000000));
        addAtom(new Hydrogen(),
                new Vector(-12.991000, -9.152000, 0.286000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-13.131000, 6.617000, -4.967000));
        addAtom(new Hydrogen(),
                new Vector(17.986000, 9.327000, -1.829000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(17.604000, 8.312000, -1.958000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(17.991000, 7.514000, -0.891000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-9.931000, 6.626000, -4.938000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(17.490000, 6.211000, -1.044000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.323000, 9.559000, -5.393000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(17.855000, 5.370000, 0.004000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(17.340000, 4.080000, -0.124000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-10.931000, 10.934000, -5.254000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(17.770000, 3.251000, 0.904000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(17.323000, 1.942000, 0.800000));
        addAtom(new Hydrogen(),
                new Vector(-10.463000, 12.153000, -3.564000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(17.821000, 1.143000, 1.831000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.182000, -4.939000, -2.835000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(17.455000, -0.185000, 1.721000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(17.950000, -0.969000, 2.778000));
        addAtom(new Sulfur(Atom.SP3),
                new Vector(3.185000, 10.867000, -25.059000));
        addAtom(new Hydrogen(),
                new Vector(17.964000, -2.896000, 3.439000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(17.577000, -2.289000, 2.618000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.092000, 9.559000, -5.425000));
        addAtom(new Hydrogen(),
                new Vector(18.016000, 9.600000, -4.148000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(17.646000, 8.581000, -4.270000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(17.983000, 7.797000, -3.177000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-12.489000, 10.936000, -5.275000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(17.493000, 6.487000, -3.336000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-17.883000, 3.145000, 2.630000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(17.793000, 5.661000, -2.266000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-15.704000, 5.472000, -4.489000));
        addAtom(new Hydrogen(),
                new Vector(-12.998000, 12.158000, -3.603000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(17.273000, 4.375000, -2.420000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-18.111000, 3.329000, 1.283000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(17.711000, 3.538000, -1.357000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-15.829000, 1.442000, -1.590000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.208000, -5.025000, -2.900000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(17.183000, 2.223000, -1.492000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-16.402000, 4.932000, -9.291000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(17.695000, 1.413000, -0.438000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-17.754000, 4.589000, 0.837000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(17.764000, -0.695000, 0.478000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(17.247000, 0.076000, -0.564000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.161000, -6.360000, -2.909000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-16.054000, 8.648000, -1.981000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(17.965000, -2.816000, 1.402000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(17.470000, -2.035000, 0.345000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-10.884000, -8.573000, -2.300000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(17.637000, -4.149000, 1.220000));
        addAtom(new Hydrogen(),
                new Vector(18.021000, -4.758000, 2.040000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(18.282000, 8.225000, -7.718000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(17.806000, 6.975000, -7.919000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(18.059000, 6.170000, -6.806000));
        addAtom(new Hydrogen(),
                new Vector(-16.125000, -4.710000, 2.210000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(17.615000, 4.870000, -6.985000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-18.028000, 4.750000, -0.503000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(17.838000, 4.060000, -5.898000));
        addAtom(new Hydrogen(),
                new Vector(-16.054000, -5.629000, -0.022000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(17.404000, 2.753000, -6.107000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(17.752000, 1.952000, -5.014000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-15.854000, -4.536000, -1.752000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(17.309000, 0.622000, -5.208000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(17.742000, -0.152000, -4.103000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-17.740000, 6.013000, -0.976000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(17.389000, -1.493000, -4.271000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(17.818000, -2.234000, -3.178000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-16.445000, -2.150000, -10.210000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(17.592000, -3.579000, -3.339000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(17.784000, -5.704000, -2.450000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(18.037000, -4.342000, -2.274000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-18.091000, 6.150000, -2.304000));
        addAtom(new Hydrogen(),
                new Vector(18.143000, 9.806000, -6.529000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(17.771000, 8.787000, -6.606000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(-16.136000, 9.975000, -3.857000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(18.083000, 8.050000, -5.467000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(17.624000, 6.734000, -5.623000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-17.849000, 7.413000, -2.803000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(17.874000, 5.922000, -4.532000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-16.491000, 8.952000, -4.669000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(17.380000, 4.628000, -4.718000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-15.887000, 2.022000, -5.689000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-18.254000, 7.548000, -4.118000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(17.734000, 3.813000, -3.634000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-16.145000, 3.476000, -7.519000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(17.211000, 2.498000, -3.815000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-18.000000, 8.820000, -4.640000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(17.673000, 1.690000, -2.725000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(17.198000, 0.349000, -2.887000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(2.929000, 26.270000, -23.056000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(17.354000, -1.765000, -1.958000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(17.710000, -0.423000, -1.805000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.245000, -6.444000, -2.972000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(-18.473000, 8.918000, -5.898000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(17.604000, -3.865000, -1.049000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(17.851000, -2.518000, -0.893000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-12.443000, -8.614000, -2.327000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-16.128000, -2.369000, -0.056000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(18.070000, -4.654000, 0.009000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-16.200000, -4.100000, -4.453000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(17.763000, -5.988000, -0.234000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(18.268000, -6.411000, -1.407000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(-15.991000, -4.731000, -7.929000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(18.349000, -5.888000, -5.848000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(17.825000, -5.441000, -4.687000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(18.288000, -6.131000, -3.625000));
        addAtom(new Hydrogen(),
                new Vector(18.281000, 3.017000, -11.560000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(17.872000, 3.378000, -10.620000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.167000, 6.565000, -6.350000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(18.351000, 4.614000, -10.396000));
        addAtom(new Hydrogen(),
                new Vector(18.188000, 0.798000, -10.681000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(17.779000, 1.198000, -9.752000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(18.179000, 2.508000, -9.578000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-9.987000, 6.577000, -6.326000));
        addAtom(new Hydrogen(),
                new Vector(18.159000, -1.344000, -9.764000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(17.743000, -0.943000, -8.837000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(18.102000, 0.380000, -8.681000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.328000, 9.038000, -6.675000));
        addAtom(new Hydrogen(),
                new Vector(18.199000, -3.480000, -8.829000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(17.786000, -3.077000, -7.902000));
        addAtom(new Hydrogen(),
                new Vector(-18.518000, 4.666000, 5.419000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(18.106000, -1.737000, -7.764000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-18.098000, 3.903000, 4.769000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(18.189000, -3.849000, -6.827000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(17.683000, -3.325000, -5.630000));
        addAtom(new Hydrogen(),
                new Vector(-16.148000, 5.113000, -10.335000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(17.924000, -1.978000, -5.465000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(17.574000, -1.221000, -6.570000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-15.976000, 7.219000, -0.076000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(17.858000, 0.114000, -6.385000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-18.286000, 1.897000, 3.071000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(17.574000, 0.896000, -7.486000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(17.929000, 2.215000, -7.282000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-16.310000, 7.547000, -2.800000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(17.686000, 3.021000, -8.375000));
        addAtom(new Hydrogen(),
                new Vector(-10.436000, 11.758000, -5.815000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(18.084000, 4.332000, -8.168000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(17.839000, 5.157000, -9.266000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-0.748000, 22.965000, -11.562000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-10.185000, -4.126000, -3.955000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(18.313000, 6.404000, -9.035000));
        addAtom(new Hydrogen(),
                new Vector(-10.440000, 10.907000, -7.916000));
        addAtom(new Hydrogen(),
                new Vector(18.300000, -5.641000, -7.810000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(17.881000, -5.204000, -6.907000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(4.367000, 10.983000, 1.428000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(18.077000, -4.075000, -4.535000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-10.163000, -3.033000, -6.036000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.092000, 9.039000, -6.705000));
        addAtom(new Hydrogen(),
                new Vector(18.153000, -6.625000, 0.557000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-16.326000, -5.521000, -2.637000));
        addAtom(new Hydrogen(),
                new Vector(16.154000, -5.812000, -7.906000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(16.417000, -5.318000, -6.974000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(16.311000, -3.170000, -7.993000));
        addAtom(new Hydrogen(),
                new Vector(16.075000, -3.618000, -8.957000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.110000, -5.510000, -5.964000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(16.267000, -0.992000, -8.951000));
        addAtom(new Hydrogen(),
                new Vector(-18.389000, -3.675000, 4.241000));
        addAtom(new Hydrogen(),
                new Vector(16.040000, -1.413000, -9.929000));
        addAtom(new Hydrogen(),
                new Vector(16.068000, 0.809000, -10.865000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(16.304000, 1.202000, -9.877000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-2.148000, 11.652000, -1.140000));
        addAtom(new Hydrogen(),
                new Vector(16.135000, 3.084000, -11.737000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(16.407000, 3.419000, -10.740000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-12.475000, 9.099000, -8.968000));
        addAtom(new Hydrogen(),
                new Vector(-12.969000, 11.760000, -5.849000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(15.900000, -4.018000, -6.953000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-1.187000, 22.800000, -12.819000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(15.974000, -6.080000, -5.945000));
        addAtom(new Hydrogen(),
                new Vector(-12.972000, 10.907000, -7.942000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(16.316000, -5.569000, -4.740000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-13.154000, -4.225000, -4.019000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(15.804000, -4.271000, -4.625000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(16.146000, -3.441000, -5.706000));
        addAtom(new Fluorine(Atom.SP3),
                new Vector(5.920000, 11.690000, -3.932000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(15.918000, -6.336000, -3.690000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(16.275000, -5.834000, -2.478000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(15.762000, -4.541000, -2.307000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.173000, -5.620000, -6.028000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(16.065000, -3.707000, -3.379000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-15.981000, 7.755000, -4.152000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(15.895000, -6.608000, -1.436000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-13.113000, -3.133000, -6.082000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(16.297000, -6.105000, -0.243000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(15.774000, -4.832000, 0.023000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(16.065000, -3.985000, -1.050000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-10.760000, -7.818000, -6.392000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(16.160000, -4.248000, 1.243000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(15.668000, -2.950000, 1.480000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(5.072000, 19.085000, -6.201000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(15.927000, -2.118000, 0.384000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-15.921000, -5.382000, -3.975000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(15.553000, -2.686000, -0.867000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(3.155000, 24.697000, -10.351000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(15.810000, -1.859000, -1.969000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-12.338000, -7.881000, -6.423000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.275000, -7.143000, -4.059000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(15.519000, -2.421000, -3.236000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(15.845000, -1.583000, -4.328000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(15.628000, -2.135000, -5.598000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(5.141000, 17.606000, -4.306000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.959000, 16.316000, -3.796000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(16.034000, -1.297000, -6.671000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.215000, 5.398000, -9.344000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(15.814000, -1.856000, -7.934000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.813000, 15.247000, -4.695000));
        addAtom(new Hydrogen(),
                new Vector(16.006000, -6.801000, 0.540000));
        addAtom(new Hydrogen(),
                new Vector(15.897000, -4.905000, 2.072000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-13.120000, 3.288000, -8.091000));
        addAtom(new Hydrogen(),
                new Vector(15.836000, -2.980000, 3.527000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(16.097000, -2.347000, 2.680000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.067000, 6.777000, -9.483000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(15.808000, 0.340000, -8.881000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(16.034000, 0.879000, -7.609000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.299000, 6.784000, -9.466000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(15.561000, 0.040000, -6.567000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(15.766000, 0.591000, -5.295000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.736000, 16.719000, -6.561000));
        addAtom(new Hydrogen(),
                new Vector(-16.374000, 4.707000, 5.627000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(15.192000, -0.236000, -4.203000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-10.855000, -8.506000, -3.758000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(15.661000, 0.335000, -2.910000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(15.160000, -0.518000, -1.799000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.098000, 5.411000, -9.337000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(15.703000, 0.034000, -0.528000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.442000, 16.938000, -7.908000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(15.462000, -0.790000, 0.580000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(15.912000, -0.216000, 1.799000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-10.006000, 3.310000, -8.086000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(15.652000, -1.028000, 2.909000));
        addAtom(new Hydrogen(),
                new Vector(-10.422000, 9.615000, -9.804000));
        addAtom(new Hydrogen(),
                new Vector(15.854000, -1.032000, 4.953000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(16.126000, -0.425000, 4.089000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.135000, -2.591000, -7.359000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(15.890000, 2.543000, -9.777000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-1.182000, 16.728000, -12.798000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.234000, -5.726000, -7.313000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(16.148000, 3.056000, -8.505000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(15.633000, 2.240000, -7.482000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(15.861000, 2.787000, -6.210000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(15.204000, 1.963000, -5.147000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(0.925000, 16.405000, -6.791000));
        addAtom(new Hydrogen(),
                new Vector(-12.954000, 9.612000, -9.831000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(15.675000, 2.505000, -3.844000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-16.634000, 3.933000, 4.909000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(15.279000, 1.691000, -2.756000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-12.994000, -5.847000, -7.369000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(15.647000, 2.230000, -1.499000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(15.144000, 1.402000, -0.368000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.138000, -2.690000, -7.397000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(15.521000, 1.140000, 1.981000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(15.778000, 1.960000, 0.873000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-10.772000, -7.072000, -7.652000));
        addAtom(new Hydrogen(),
                new Vector(-10.381000, -9.487000, -1.915000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(15.729000, 0.907000, 4.293000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(16.018000, 1.693000, 3.176000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.040000, -7.228000, -4.117000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(16.229000, 1.532000, 5.441000));
        addAtom(new Hydrogen(),
                new Vector(15.934000, 0.979000, 6.329000));
        addAtom(new Hydrogen(),
                new Vector(-10.219000, -8.787000, -6.463000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(15.951000, 6.515000, -9.224000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(16.296000, 7.046000, -8.027000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-16.200000, 6.126000, -0.922000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(15.783000, 6.283000, -6.973000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(16.083000, 6.815000, -5.703000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-16.378000, -3.529000, -8.432000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(15.571000, 6.057000, -4.638000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-0.218000, 17.096000, -10.226000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(15.949000, 6.578000, -3.361000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-16.507000, 5.465000, 3.092000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(15.489000, 5.810000, -2.266000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(15.946000, 6.306000, -1.011000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(15.557000, 5.514000, 0.094000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(16.055000, 5.998000, 1.320000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-12.324000, -7.145000, -7.687000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-12.413000, -8.552000, -3.785000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(15.716000, 5.194000, 2.424000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(16.219000, 5.685000, 3.637000));
        addAtom(new Hydrogen(),
                new Vector(-12.798000, -8.889000, -6.514000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(15.827000, 4.895000, 4.671000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(15.977000, 4.696000, -10.585000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.051000, 4.875000, -10.626000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(16.333000, 5.220000, -9.390000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-0.537000, 18.204000, -11.005000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(15.819000, 4.418000, -8.363000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(16.096000, 4.935000, -7.101000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-0.598000, 11.480000, -1.299000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(15.547000, 4.161000, -6.068000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-1.614000, -6.708000, -2.877000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-1.579000, -3.877000, -2.200000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(15.838000, 4.692000, -4.790000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.155000, 2.205000, -8.951000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(15.186000, 3.900000, -3.699000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(1.098000, 16.773000, -1.583000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-1.679000, 20.065000, -15.276000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(15.730000, 4.442000, -2.425000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(13.036000, 21.301000, -20.378000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(15.161000, 3.627000, -1.325000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-0.427000, 21.897000, -10.779000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(15.796000, 4.141000, -0.067000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-1.592000, 18.933000, -14.442000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-1.846000, 12.167000, 1.277000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(15.998000, 3.843000, 2.242000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(15.469000, 3.331000, 1.046000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-1.588000, 5.692000, 2.475000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(16.195000, 3.593000, 4.539000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(12.971000, 20.321000, -19.385000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(15.698000, 3.052000, 3.346000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-1.560000, -6.246000, -5.018000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(0.279000, 15.712000, -1.407000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(15.807000, 2.813000, 5.574000));
        addAtom(new Hydrogen(),
                new Vector(15.995000, 9.897000, -6.657000));
        addAtom(new Hydrogen(),
                new Vector(15.883000, 9.708000, -4.233000));
        addAtom(new Hydrogen(),
                new Vector(15.856000, 9.452000, -1.835000));
        addAtom(new Hydrogen(),
                new Vector(15.984000, 9.171000, 0.565000));
        addAtom(new Hydrogen(),
                new Vector(16.023000, 8.786000, 2.961000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(16.296000, 7.754000, 2.755000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(15.784000, 7.355000, 1.512000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-1.582000, -5.727000, -3.786000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(16.197000, 8.113000, 0.404000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-1.530000, -5.716000, -6.219000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(15.689000, 7.669000, -0.837000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(-1.208000, 14.023000, -2.130000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(16.123000, 8.401000, -1.954000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-1.642000, 1.766000, 6.287000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(15.682000, 7.940000, -3.217000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-1.528000, -3.385000, -4.473000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(16.166000, 8.659000, -4.320000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-15.663000, 2.219000, -7.060000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(15.788000, 8.172000, -5.585000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(16.302000, 8.854000, -6.691000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(15.901000, 8.331000, -7.874000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-1.480000, -3.484000, -8.902000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(15.865000, 6.982000, 3.781000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-1.490000, -4.444000, -8.005000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-6.410000, 3.217000, -4.813000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-1.936000, 3.249000, -4.826000));
        addAtom(new Silicon(Atom.SP3),
                new Vector(12.650000, 22.775000, -19.536000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-1.928000, 0.901000, -5.034000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(13.001000, 18.943000, -19.674000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(12.696000, 20.769000, -18.078000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-6.415000, 4.085000, -2.616000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-9.375000, 3.188000, -4.802000));
        addAtom(new Hydrogen(),
                new Vector(-19.012000, 3.866000, -2.638000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(12.563000, 22.147000, -17.914000));
        addAtom(new Hydrogen(),
                new Vector(13.748000, 23.743000, -19.657000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-6.404000, 2.610000, -0.754000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-7.146000, 3.588000, -1.485000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-1.515000, -4.457000, -6.666000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-2.676000, 3.992000, -3.854000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-1.507000, -3.312000, -5.849000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-7.121000, -0.489000, -1.993000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-9.349000, 0.831000, -5.091000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-6.395000, 0.254000, -1.013000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-6.384000, -0.618000, -3.212000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-1.476000, -2.041000, -6.372000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-1.943000, 4.117000, -2.632000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-7.133000, 1.394000, -0.558000));
        addAtom(new Hydrogen(),
                new Vector(-16.273000, 6.282000, 3.773000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-9.343000, -0.633000, -3.220000));
        addAtom(new Hydrogen(),
                new Vector(18.811000, 3.523000, -1.350000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-16.308000, -4.648000, -0.420000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-16.444000, 6.947000, 1.228000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-7.116000, -0.117000, -4.330000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-15.342000, 3.117000, -4.843000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-1.644000, 5.167000, 5.488000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-6.387000, 0.861000, -5.070000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(12.668000, 18.031000, -18.661000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(0.288000, 3.598000, -1.524000));
        addAtom(new Hydrogen(),
                new Vector(-16.222000, 7.785000, 1.887000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-1.615000, 6.307000, 4.838000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(13.247000, 18.472000, -20.931000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-7.150000, 3.955000, -3.832000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-7.132000, 2.067000, -5.248000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(12.404000, 19.847000, -17.051000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-1.412000, 4.438000, -7.146000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-4.175000, 3.573000, -1.529000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-0.450000, 2.635000, -0.769000));
        addAtom(new Hydrogen(),
                new Vector(-16.096000, 0.338000, -11.012000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-1.931000, -0.574000, -3.191000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-15.711000, -0.147000, -7.366000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(12.499000, 16.680000, -18.989000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(12.363000, 18.480000, -17.361000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(13.106000, 17.173000, -21.236000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(12.035000, 20.247000, -15.798000));
        addAtom(new Hydrogen(),
                new Vector(-16.236000, 9.255000, -0.024000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(11.975000, 15.787000, -18.044000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-16.469000, 8.402000, -0.660000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(12.693000, 16.261000, -20.311000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(11.889000, 17.574000, -16.401000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(11.590000, 19.377000, -14.879000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-16.116000, 1.129000, -7.851000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-15.440000, 1.637000, -2.939000));
        addAtom(new Hydrogen(),
                new Vector(-16.298000, 10.680000, -2.006000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-16.569000, 9.801000, -2.584000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(11.559000, 14.515000, -18.458000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-16.107000, 4.242000, 3.651000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(11.680000, 16.231000, -16.742000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-16.210000, -1.208000, -8.146000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(12.316000, 14.999000, -20.686000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(11.475000, 18.044000, -15.148000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.803000, 13.708000, -17.590000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(11.729000, 14.133000, -19.804000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-15.877000, -2.482000, -7.648000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(-16.201000, 2.742000, 5.388000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.990000, 15.392000, -15.852000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-16.540000, 1.709000, 4.583000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-15.764000, 4.573000, -6.698000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(10.854000, 17.192000, -14.273000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.181000, 12.562000, -18.088000));
        addAtom(new Hydrogen(),
                new Vector(-16.061000, -6.512000, -2.269000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-1.943000, 2.633000, -0.764000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-2.663000, -0.078000, -4.308000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.524000, 14.140000, -16.280000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-1.574000, 6.622000, 3.538000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-4.909000, 2.606000, -0.785000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-1.486000, 7.947000, 3.386000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-16.016000, 1.926000, 3.302000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-4.909000, 3.228000, -4.827000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-15.936000, -1.049000, -9.508000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-4.170000, 1.408000, -0.592000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-2.674000, 1.417000, -0.570000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(11.156000, 12.975000, -20.247000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.587000, 15.889000, -14.605000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-16.347000, 3.184000, 2.772000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-4.898000, 0.261000, -1.022000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-4.163000, -0.488000, -1.987000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(9.256000, 11.856000, -17.294000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-4.889000, -0.616000, -3.212000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-1.426000, 8.793000, 2.366000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-4.155000, -0.102000, -4.327000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-1.625000, -0.142000, 3.145000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-4.893000, 0.868000, -5.077000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.384000, 12.196000, -19.431000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-4.166000, 2.087000, -5.269000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-16.284000, 5.797000, -7.153000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-4.180000, 3.971000, -3.852000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-1.474000, 6.136000, -5.550000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(9.638000, 13.412000, -15.458000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-4.916000, 4.076000, -2.632000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-2.679000, 3.599000, -1.517000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(9.797000, 15.107000, -13.813000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-2.667000, 2.099000, -5.255000));
        addAtom(new Fluorine(Atom.SP3),
                new Vector(-2.758000, 12.011000, -2.332000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-16.254000, 6.666000, -4.975000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-1.941000, 0.270000, -0.997000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(8.532000, 10.794000, -17.852000));
        addAtom(new Hydrogen(),
                new Vector(-18.966000, 0.751000, -5.081000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-2.666000, -0.475000, -1.976000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(-16.149000, 0.497000, 5.060000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-1.638000, 0.758000, 5.406000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-16.503000, -0.546000, 4.263000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(8.982000, 12.267000, -15.980000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.719000, 28.903000, -20.903000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(9.707000, 11.133000, -19.936000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-15.874000, 1.315000, -9.218000));
        addAtom(new Silicon(Atom.SP3),
                new Vector(4.950000, 14.274000, -2.470000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-1.560000, 21.368000, -14.735000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(-1.796000, 19.977000, -16.658000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(9.336000, 13.916000, -14.225000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(7.513000, 10.126000, -17.112000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-15.979000, -0.384000, 2.974000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-15.702000, -3.086000, -3.611000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(8.806000, 10.435000, -19.189000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(8.002000, 11.625000, -15.284000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-16.272000, 0.866000, 2.437000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(7.255000, 10.587000, -15.781000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(6.841000, 9.073000, -17.789000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(-16.117000, 9.119000, -5.964000));
        addAtom(new Hydrogen(),
                new Vector(0.049000, 5.404000, -24.963000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(8.124000, 9.420000, -19.749000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(6.285000, 10.108000, -14.950000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(5.865000, 8.303000, -17.274000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(7.188000, 8.768000, -19.069000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(5.354000, 9.121000, -15.019000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-15.335000, 0.148000, -1.044000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(5.197000, 8.250000, -16.112000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(4.515000, 8.919000, -13.892000));
        addAtom(new Sulfur(Atom.SP3),
                new Vector(4.137000, 7.095000, -15.967000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-15.946000, -1.805000, -4.125000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(-16.130000, -1.752000, 4.749000));
        addAtom(new Silicon(Atom.SP3),
                new Vector(3.618000, 7.456000, -14.177000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(1.894000, 7.304000, -13.805000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-16.483000, 8.100000, -6.782000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-16.529000, -2.776000, 3.956000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(3.902000, 6.160000, -13.040000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(1.933000, 7.460000, -12.317000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(1.755000, 5.890000, -14.226000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(3.258000, 6.816000, -11.865000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(2.513000, 0.279000, -0.983000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(1.780000, 1.429000, -0.578000));
        addAtom(new Hydrogen(),
                new Vector(-18.991000, 3.006000, -4.761000));
        addAtom(new Hydrogen(),
                new Vector(-18.987000, 0.186000, -1.171000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-15.631000, -1.625000, -5.494000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-15.997000, -2.711000, 2.661000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-16.279000, -1.457000, 2.113000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-15.879000, -0.940000, -1.905000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-16.368000, -4.934000, -6.638000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-16.381000, -3.741000, 1.783000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-16.102000, -3.254000, -2.256000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(2.036000, 19.277000, -22.046000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-15.879000, -3.642000, 0.471000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(5.137000, 20.402000, -17.201000));
        addAtom(new Sulfur(Atom.SP3),
                new Vector(-0.871000, 19.749000, -20.052000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(3.030000, 5.150000, -13.713000));
        addAtom(new Sulfur(Atom.SP3),
                new Vector(-0.449000, 19.953000, -23.256000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(7.830000, 20.260000, -20.015000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.082000, 25.290000, -22.016000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(8.603000, 22.086000, -23.457000));
        addAtom(new Sulfur(Atom.SP3),
                new Vector(0.897000, 17.808000, -21.891000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(9.281000, 20.942000, -22.600000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(6.076000, 24.860000, -24.862000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(1.978000, 27.770000, -21.257000));
        addAtom(new Hydrogen(),
                new Vector(-1.489000, 24.560000, -23.867000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.705000, 24.911000, -15.340000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(3.692000, 29.185000, -19.757000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(1.959000, 6.281000, -11.232000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(2.432000, 28.280000, -19.807000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(1.396000, 25.320000, -17.247000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(1.553000, 24.441000, -24.017000));
        addAtom(new Sulfur(Atom.SP3),
                new Vector(4.389000, 26.609000, -14.777000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(2.393000, 25.505000, -16.092000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(0.722000, 21.089000, -18.418000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(2.998000, 26.937000, -16.013000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(3.986000, 22.105000, -15.734000));
        addAtom(new Sulfur(Atom.SP3),
                new Vector(2.932000, 17.574000, -24.082000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(5.493000, 23.831000, -14.541000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(5.341000, 22.416000, -15.102000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-0.236000, 23.743000, -20.897000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(7.726000, 20.417000, -17.417000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(9.085000, 22.428000, -16.381000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(8.944000, 21.378000, -17.514000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(9.800000, 21.483000, -21.263000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(2.181000, 24.619000, -25.390000));
        addAtom(new Sulfur(Atom.SP3),
                new Vector(6.178000, 29.921000, -21.423000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(10.954000, 23.524000, -20.082000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(3.560000, 25.330000, -25.415000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(10.497000, 22.875000, -21.440000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(7.509000, 27.787000, -22.821000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(8.657000, 24.579000, -24.634000));
        addAtom(new Fluorine(Atom.SP3),
                new Vector(1.870000, 8.784000, -11.911000));
        addAtom(new Hydrogen(),
                new Vector(1.500000, 5.675000, -15.287000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(9.787000, 26.409000, -23.040000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(5.920000, 22.278000, -26.286000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(2.972000, 19.208000, -23.251000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(1.634000, 4.801000, -13.193000));
        addAtom(new Fluorine(Atom.SP3),
                new Vector(4.047000, 7.727000, -11.177000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(8.692000, 26.043000, -24.095000));
        addAtom(new Sulfur(Atom.SP3),
                new Vector(1.551000, 19.663000, -25.520000));
        addAtom(new Hydrogen(),
                new Vector(3.499000, 4.518000, -14.501000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(7.202000, 22.575000, -25.469000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(5.024000, 27.150000, -24.320000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(6.450000, 28.888000, -22.953000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(5.059000, 28.332000, -23.311000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(1.655000, 6.658000, -9.764000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(1.502000, 4.997000, -11.773000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(1.336000, 3.439000, -13.533000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(1.554000, 5.734000, -8.678000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(1.817000, 25.964000, -18.555000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(7.781000, 19.126000, -23.730000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(1.496000, 7.979000, -9.590000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(2.527000, 27.245000, -18.626000));
        addAtom(new Sulfur(Atom.SP3),
                new Vector(7.346000, 24.005000, -14.366000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(1.443000, 3.645000, -11.202000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(1.320000, 21.564000, -22.038000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(8.504000, 19.511000, -22.401000));
        addAtom(new Sulfur(Atom.SP3),
                new Vector(9.222000, 28.032000, -22.306000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(1.322000, 2.779000, -12.275000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(1.481000, 6.097000, -7.360000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(1.581000, 4.306000, -8.839000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-1.624000, -2.117000, 1.968000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(1.379000, 8.737000, -8.517000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(1.487000, 3.303000, -9.858000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(3.410000, 23.170000, -16.635000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(3.576000, 24.553000, -16.191000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(6.098000, 17.829000, -19.910000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(7.724000, 22.798000, -15.694000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(3.145000, 27.247000, -22.005000));
        addAtom(new Sulfur(Atom.SP3),
                new Vector(4.270000, 29.107000, -17.954000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(6.305000, 18.635000, -18.623000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.351000, 28.051000, -22.027000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(1.272000, 20.365000, -22.759000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(1.310000, 1.442000, -12.246000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(1.430000, 7.224000, -6.598000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(1.395000, 8.499000, -7.191000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(2.980000, 21.581000, -24.044000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(4.388000, 20.812000, -22.299000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(7.042000, 27.684000, -19.509000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(5.611000, 26.535000, -17.592000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(1.455000, 2.016000, -9.396000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(2.628000, 21.965000, -21.678000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(7.581000, 24.937000, -17.108000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(1.360000, 0.490000, -11.294000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(6.437000, 21.060000, -16.985000));
        addAtom(new Sulfur(Atom.SP3),
                new Vector(10.166000, 23.789000, -17.138000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(6.489000, 22.127000, -16.009000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(8.894000, 25.835000, -19.176000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(6.940000, 24.711000, -18.331000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(2.582000, 18.959000, -17.526000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(1.401000, 7.004000, -5.231000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(1.336000, 9.643000, -6.508000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(1.411000, 0.748000, -9.905000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(1.363000, -0.735000, -11.833000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(1.681000, 17.948000, -25.218000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(8.824000, 21.352000, -20.096000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(2.566000, 20.349000, -16.878000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(9.128000, 22.050000, -18.858000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(6.629000, 26.342000, -19.784000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(1.385000, 7.751000, -4.072000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-0.328000, 18.221000, -23.111000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(1.346000, 9.907000, -5.223000));
        addAtom(new Sulfur(Atom.SP3),
                new Vector(0.519000, 22.465000, -25.469000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(1.408000, -0.243000, -8.954000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(1.396000, -1.942000, -11.310000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(1.238000, -5.440000, 0.776000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(9.054000, 23.596000, -23.621000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(2.239000, 20.324000, -23.938000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(1.370000, 7.045000, -2.872000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(7.628000, 25.234000, -19.554000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(9.830000, 23.920000, -22.379000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-0.041000, 23.556000, -18.449000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(7.044000, 20.275000, -24.342000));
        addAtom(new Sulfur(Atom.SP3),
                new Vector(3.765000, 20.808000, -26.970000));
        addAtom(new Sulfur(Atom.SP3),
                new Vector(1.887000, 17.032000, -19.228000));
        addAtom(new Sulfur(Atom.SP3),
                new Vector(4.769000, 16.534000, -21.853000));
        addAtom(new Sulfur(Atom.SP3),
                new Vector(5.716000, 18.129000, -25.216000));
        addAtom(new Sulfur(Atom.SP3),
                new Vector(4.620000, 23.550000, -22.541000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(6.431000, 18.537000, -21.181000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(1.394000, 9.152000, -4.117000));
        addAtom(new Sulfur(Atom.SP3),
                new Vector(4.752000, 21.770000, -19.875000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(1.414000, -1.611000, -8.892000));
        addAtom(new Sulfur(Atom.SP3),
                new Vector(7.251000, 23.835000, -20.858000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.688000, 23.053000, -25.885000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(1.418000, -2.409000, -10.052000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(7.707000, 29.493000, -16.048000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(5.857000, 25.665000, -18.686000));
        addAtom(new Sulfur(Atom.SP3),
                new Vector(4.540000, 24.695000, -19.526000));
        addAtom(new Fluorine(Atom.SP3),
                new Vector(6.058000, 26.286000, -21.034000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(9.987000, 23.223000, -18.876000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(1.364000, 7.322000, -1.509000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(7.634000, 27.823000, -18.240000));
        addAtom(new Fluorine(Atom.SP3),
                new Vector(6.579000, 23.387000, -18.354000));
        addAtom(new Fluorine(Atom.SP3),
                new Vector(2.541000, 23.115000, -20.927000));
        addAtom(new Fluorine(Atom.SP3),
                new Vector(5.722000, 21.120000, -22.197000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(3.534000, 20.926000, -21.069000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(1.500000, 9.936000, -3.053000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(1.401000, -2.138000, -7.617000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(1.446000, -3.745000, -10.054000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(1.325000, 6.242000, -0.652000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(1.420000, 8.630000, -1.014000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(3.603000, 21.975000, -22.817000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(0.910000, 26.587000, -20.824000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(1.740000, 25.396000, -22.917000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(1.527000, 9.718000, -1.764000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(6.119000, 26.126000, -24.120000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(1.399000, -3.374000, -7.012000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(0.424000, 24.195000, -19.708000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(5.332000, 23.406000, -20.761000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-0.472000, 22.025000, -18.535000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(6.816000, 27.201000, -17.125000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(6.781000, 17.926000, -23.696000));
        addAtom(new Hydrogen(),
                new Vector(-1.497000, 25.231000, -21.587000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(5.969000, 19.914000, -25.271000));
        addAtom(new Hydrogen(),
                new Vector(-2.321000, 21.665000, -19.724000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(9.982000, 27.665000, -15.701000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(6.043000, 17.768000, -22.341000));
        addAtom(new Hydrogen(),
                new Vector(-0.949000, 24.138000, -18.168000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(4.815000, 16.990000, -20.040000));
        addAtom(new Hydrogen(),
                new Vector(0.575000, 18.166000, -17.504000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(7.997000, 26.236000, -16.890000));
        addAtom(new Hydrogen(),
                new Vector(1.864000, 20.258000, -16.026000));
        addAtom(new Hydrogen(),
                new Vector(2.722000, 18.228000, -16.695000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(3.588000, 17.664000, -19.392000));
        addAtom(new Hydrogen(),
                new Vector(4.957000, 16.040000, -19.481000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(1.297000, 18.540000, -18.261000));
        addAtom(new Hydrogen(),
                new Vector(6.481000, 17.892000, -17.820000));
        addAtom(new Hydrogen(),
                new Vector(6.848000, 17.067000, -19.885000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(5.566000, 20.803000, -26.464000));
        addAtom(new Hydrogen(),
                new Vector(7.335000, 16.987000, -23.875000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(3.425000, 22.506000, -26.343000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-12.457000, 7.137000, -10.817000));
        addAtom(new Sulfur(Atom.SP3),
                new Vector(8.075000, 29.575000, -17.805000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(8.769000, 26.798000, -18.058000));
        addAtom(new Hydrogen(),
                new Vector(8.576000, 18.869000, -24.467000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(2.065000, 23.295000, -26.200000));
        addAtom(new Hydrogen(),
                new Vector(6.137000, 20.418000, -27.337000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(0.419000, 23.552000, -24.007000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-0.852000, 23.933000, -23.207000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(1.447000, -4.643000, -9.096000));
        addAtom(new Hydrogen(),
                new Vector(6.133000, 22.654000, -27.315000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(1.170000, 25.532000, -19.744000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(7.393000, 26.547000, -23.564000));
        addAtom(new Hydrogen(),
                new Vector(1.788000, 23.566000, -27.241000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(1.308000, 5.987000, 0.709000));
        addAtom(new Sulfur(Atom.SP3),
                new Vector(6.420000, 28.395000, -15.795000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(1.427000, 8.976000, 0.278000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-0.956000, 22.497000, -21.025000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(1.372000, -3.361000, -5.630000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(1.417000, -4.569000, -7.759000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(1.272000, 4.664000, 1.069000));
        addAtom(new Hydrogen(),
                new Vector(3.639000, 25.785000, -26.429000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(1.320000, 7.001000, 1.677000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(1.389000, 8.303000, 1.402000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(1.349000, -4.270000, -4.590000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(1.404000, -5.798000, -7.237000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(1.955000, 21.436000, -17.730000));
        addAtom(new Hydrogen(),
                new Vector(1.488000, 25.333000, -25.893000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(1.251000, 3.887000, 2.200000));
        addAtom(new Hydrogen(),
                new Vector(0.627000, 2.931000, -26.165000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(1.306000, 6.800000, 3.005000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(0.591000, 19.748000, -18.969000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(1.322000, -3.727000, -3.320000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(1.349000, -5.662000, -4.809000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-1.218000, 21.589000, -19.834000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(1.374000, -6.252000, -6.008000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(1.251000, 4.417000, 3.494000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(1.228000, 2.544000, 1.973000));
        addAtom(new Hydrogen(),
                new Vector(1.594000, 28.940000, -19.486000));
        addAtom(new Hydrogen(),
                new Vector(0.465000, 25.865000, -16.970000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(2.204000, 22.852000, -17.424000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(1.276000, 5.728000, 3.767000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(1.294000, -4.167000, -2.011000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(1.013000, 23.805000, -17.382000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-0.558000, 24.721000, -21.907000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(3.600000, 26.522000, -24.416000));
        addAtom(new Hydrogen(),
                new Vector(0.451000, 23.528000, -16.493000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-1.667000, -6.297000, 0.587000));
        addAtom(new Hydrogen(),
                new Vector(2.270000, 27.593000, -15.492000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(1.319000, -6.593000, -3.849000));
        addAtom(new Hydrogen(),
                new Vector(4.098000, 19.999000, -15.428000));
        addAtom(new Hydrogen(),
                new Vector(3.308000, 22.071000, -14.905000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(1.246000, 3.679000, 4.620000));
        addAtom(new Sulfur(Atom.SP3),
                new Vector(9.029000, 26.258000, -15.362000));
        addAtom(new Hydrogen(),
                new Vector(5.069000, 23.835000, -13.513000));
        addAtom(new Hydrogen(),
                new Vector(5.463000, 21.715000, -14.240000));
        addAtom(new Hydrogen(),
                new Vector(7.963000, 19.715000, -16.584000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(1.220000, 1.364000, 2.661000));
        addAtom(new Hydrogen(),
                new Vector(8.433000, 18.863000, -18.615000));
        addAtom(new Sulfur(Atom.SP3),
                new Vector(-1.876000, 22.511000, -22.594000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(1.218000, -1.119000, 4.408000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(1.235000, -1.755000, 3.222000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(1.222000, -4.089000, 2.521000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(1.216000, -3.086000, 3.376000));
        addAtom(new Hydrogen(),
                new Vector(11.020000, 18.229000, -22.480000));
        addAtom(new Silicon(Atom.SP3),
                new Vector(9.690000, 18.005000, -21.908000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(9.754000, 17.685000, -20.186000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(9.098000, 16.431000, -22.402000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(9.172000, 16.415000, -20.019000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(8.815000, 15.748000, -21.211000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(8.656000, 15.959000, -18.768000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(8.003000, 14.580000, -21.169000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(7.759000, 14.874000, -18.755000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(8.806000, 16.677000, -17.615000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(7.463000, 14.170000, -19.939000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(7.634000, 13.896000, -22.296000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(7.031000, 14.594000, -17.585000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(1.267000, -3.181000, -1.055000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(8.114000, 16.399000, -16.496000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(6.516000, 13.131000, -19.915000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(6.775000, 12.861000, -22.256000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(6.065000, 13.583000, -17.577000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(7.204000, 15.385000, -16.445000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(5.825000, 12.832000, -18.738000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(6.186000, 12.453000, -21.093000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(5.285000, 13.372000, -16.433000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(6.430000, 15.162000, -15.327000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.830000, 11.845000, -18.741000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(5.234000, 11.454000, -21.070000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.282000, 12.396000, -16.442000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(5.471000, 14.176000, -15.296000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(1.285000, -5.530000, -1.664000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.067000, 11.619000, -17.590000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.554000, 11.128000, -19.917000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(3.461000, 12.228000, -15.323000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(4.651000, 13.991000, -14.206000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(3.050000, 10.659000, -17.604000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(3.566000, 10.165000, -19.897000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(2.428000, 11.277000, -15.335000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(3.652000, 13.041000, -14.202000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(2.234000, 10.474000, -16.475000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(2.823000, 9.913000, -18.763000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(1.583000, 11.160000, -14.219000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(2.810000, 12.881000, -13.138000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(1.216000, 9.508000, -16.509000));
        addAtom(new Hydrogen(),
                new Vector(10.450000, 12.664000, -4.272000));
        addAtom(new Hydrogen(),
                new Vector(12.984000, 12.614000, -4.252000));
        addAtom(new Hydrogen(),
                new Vector(12.998000, 12.116000, -6.480000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(1.828000, 8.974000, -18.741000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(0.528000, 10.206000, -14.249000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(1.813000, 11.977000, -13.147000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(0.375000, 9.355000, -15.371000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(1.059000, 8.774000, -17.654000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(-0.398000, 10.036000, -13.202000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(-0.628000, 8.377000, -15.275000));
        addAtom(new Hydrogen(),
                new Vector(10.464000, 12.169000, -6.510000));
        addAtom(new Hydrogen(),
                new Vector(10.427000, 11.208000, -8.565000));
        addAtom(new Silicon(Atom.SP3),
                new Vector(-1.405000, 8.715000, -13.746000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-1.550000, 7.304000, -12.596000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(-3.101000, 9.098000, -13.994000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-2.369000, 7.813000, -11.442000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-2.235000, 6.266000, -13.420000));
        addAtom(new Hydrogen(),
                new Vector(12.971000, 9.808000, -10.354000));
        addAtom(new Hydrogen(),
                new Vector(12.960000, 11.178000, -8.530000));
        addAtom(new Hydrogen(),
                new Vector(10.436000, 9.830000, -10.393000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-3.884000, 8.135000, -13.367000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-3.759000, 8.276000, -11.884000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-3.623000, 7.049000, -10.887000));
        addAtom(new Fluorine(Atom.SP3),
                new Vector(-1.734000, 8.724000, -10.612000));
        addAtom(new Hydrogen(),
                new Vector(-1.635000, 5.752000, -14.203000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-3.550000, 5.638000, -12.953000));
        addAtom(new Hydrogen(),
                new Vector(12.969000, 8.106000, -11.830000));
        addAtom(new Hydrogen(),
                new Vector(10.435000, 8.113000, -11.865000));
        addAtom(new Hydrogen(),
                new Vector(10.446000, 6.111000, -12.965000));
        addAtom(new Hydrogen(),
                new Vector(12.981000, 6.109000, -12.926000));
        addAtom(new Hydrogen(),
                new Vector(12.994000, 3.959000, -13.565000));
        addAtom(new Hydrogen(),
                new Vector(10.459000, 3.948000, -13.613000));
        addAtom(new Hydrogen(),
                new Vector(10.475000, 1.675000, -13.799000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-3.608000, 6.783000, -13.927000));
        addAtom(new Fluorine(Atom.SP3),
                new Vector(-4.059000, 9.547000, -11.421000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-3.874000, 5.754000, -11.546000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-4.019000, 7.293000, -9.401000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-3.737000, 4.279000, -13.388000));
        addAtom(new Hydrogen(),
                new Vector(-3.802000, 6.599000, -15.005000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-4.071000, 4.376000, -11.063000));
        addAtom(new Hydrogen(),
                new Vector(13.011000, 1.696000, -13.755000));
        addAtom(new Hydrogen(),
                new Vector(13.101000, -0.522000, -13.458000));
        addAtom(new Hydrogen(),
                new Vector(10.579000, -0.555000, -13.520000));
        addAtom(new Hydrogen(),
                new Vector(10.587000, -2.701000, -12.768000));
        addAtom(new Hydrogen(),
                new Vector(13.107000, -2.675000, -12.720000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(10.921000, 11.678000, -4.481000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(12.479000, 11.646000, -4.463000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(12.486000, 11.331000, -5.881000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-4.163000, 8.597000, -9.119000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-4.184000, 6.291000, -8.394000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-4.009000, 3.564000, -12.184000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-4.205000, 3.955000, -9.745000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-4.291000, 9.263000, -7.989000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-4.199000, 4.885000, -8.664000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-4.303000, 6.542000, -7.051000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(10.927000, 11.360000, -5.902000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(10.900000, 10.225000, -8.346000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(12.459000, 10.207000, -8.322000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(10.906000, 9.349000, -9.507000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(12.465000, 9.335000, -9.483000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(12.470000, 7.305000, -11.240000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(10.912000, 7.309000, -11.262000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(10.918000, 6.036000, -11.961000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(12.477000, 6.034000, -11.937000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(12.491000, 3.468000, -12.702000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-4.129000, 2.228000, -12.227000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-4.275000, 2.645000, -9.356000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-4.303000, 8.916000, -6.688000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-4.330000, 7.600000, -6.195000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-4.272000, 1.228000, -11.329000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-4.302000, 1.406000, -9.927000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-4.269000, 10.002000, -5.919000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-4.412000, 7.274000, -4.847000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-4.352000, 0.036000, -11.931000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-4.334000, 0.363000, -9.025000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-4.278000, 10.163000, -4.619000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-4.430000, 7.935000, -3.633000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(10.932000, 3.462000, -12.731000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(10.944000, 2.018000, -12.850000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(12.504000, 2.025000, -12.820000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(12.590000, -0.625000, -12.475000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(11.032000, -0.637000, -12.509000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(11.043000, -2.003000, -12.033000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(12.600000, -1.992000, -12.003000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(9.318000, 13.596000, 3.808000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(11.653000, 14.888000, 3.676000));
        addAtom(new Hydrogen(),
                new Vector(12.983000, 12.629000, -2.008000));
        addAtom(new Hydrogen(),
                new Vector(10.440000, 12.693000, -1.996000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-4.403000, -1.196000, -11.471000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-4.357000, -1.011000, -9.033000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-4.361000, 9.335000, -3.572000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-4.489000, 7.149000, -2.485000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-4.383000, -1.737000, -10.241000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-4.362000, -1.620000, -7.786000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-4.439000, 10.052000, -2.456000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-4.482000, 7.335000, -1.105000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-4.395000, -3.070000, -10.324000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-4.383000, -2.900000, -7.259000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-4.467000, 9.759000, -1.184000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-4.441000, 8.613000, -0.515000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-4.490000, 6.194000, -0.327000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(10.901000, 11.382000, -0.356000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(10.907000, 11.707000, -1.777000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(12.478000, 11.368000, -0.347000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(12.473000, 11.669000, -1.772000));
        addAtom(new Hydrogen(),
                new Vector(9.927000, 2.175000, 7.774000));
        addAtom(new Hydrogen(),
                new Vector(12.501000, 2.158000, 7.954000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(9.931000, 4.807000, 7.435000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(12.530000, 4.787000, 7.651000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(10.531000, 3.855000, 6.550000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(10.496000, 2.417000, 6.849000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(12.071000, 2.405000, 6.959000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(12.081000, 3.845000, 6.669000));
        addAtom(new Sulfur(Atom.SP3),
                new Vector(11.792000, 13.881000, 6.183000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-4.393000, -4.026000, -9.425000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-4.390000, -4.041000, -8.087000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-4.396000, -2.993000, -5.874000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-4.447000, 8.874000, 0.795000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-4.470000, 5.852000, 1.015000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-4.408000, -5.305000, -7.654000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-4.423000, -3.984000, -4.900000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-4.456000, 8.124000, 1.869000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-4.465000, 6.804000, 2.051000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-4.441000, 4.508000, 1.286000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-4.427000, -5.852000, -6.463000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-4.434000, -5.356000, -5.222000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-4.433000, -3.550000, -3.588000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-4.473000, 6.521000, 3.362000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-4.438000, 3.662000, 2.370000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-4.477000, -6.358000, -4.334000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-4.462000, -4.091000, -2.313000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-4.489000, 5.401000, 4.052000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(11.704000, 13.609000, 4.262000));
        addAtom(new Hydrogen(),
                new Vector(15.117000, 10.309000, 4.985000));
        addAtom(new Hydrogen(),
                new Vector(13.887000, 13.392000, 3.898000));
        addAtom(new Hydrogen(),
                new Vector(13.708000, 12.559000, 6.936000));
        addAtom(new Hydrogen(),
                new Vector(13.972000, 9.274000, 7.864000));
        addAtom(new Hydrogen(),
                new Vector(12.577000, 7.308000, 9.831000));
        addAtom(new Hydrogen(),
                new Vector(9.188000, 7.422000, 9.334000));
        addAtom(new Hydrogen(),
                new Vector(9.076000, 11.318000, 8.623000));
        addAtom(new Hydrogen(),
                new Vector(12.267000, 11.447000, 9.382000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(13.086000, 12.433000, 0.423000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(10.338000, 12.355000, 0.467000));
        addAtom(new Silicon(Atom.SP3),
                new Vector(10.000000, 7.678000, 8.137000));
        addAtom(new Silicon(Atom.SP3),
                new Vector(12.193000, 7.618000, 8.447000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(12.878000, 9.228000, 7.687000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-1.637000, -1.508000, 3.194000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-1.635000, -3.381000, 1.448000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-4.403000, 2.332000, 2.065000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-4.493000, 4.112000, 3.695000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-4.502000, -6.412000, -3.022000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-4.449000, -3.185000, -1.283000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-4.488000, -5.474000, -2.069000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-4.429000, 1.114000, 2.687000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-4.509000, 3.309000, 4.775000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-1.612000, -3.434000, 0.075000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-4.466000, -3.163000, 0.092000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-4.533000, -6.040000, -0.850000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-4.401000, 0.044000, 1.843000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-4.507000, 0.971000, 4.074000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-4.515000, 2.000000, 4.936000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-4.422000, -1.918000, 0.649000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-4.515000, -4.321000, 0.877000));
        addAtom(new Silicon(Atom.SP3),
                new Vector(12.073000, 11.009000, 7.993000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(12.664000, 12.361000, 6.730000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(9.670000, 11.849000, 6.049000));
        addAtom(new Silicon(Atom.SP3),
                new Vector(9.902000, 10.825000, 7.512000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(9.464000, 9.122000, 7.111000));
        addAtom(new Silicon(Atom.SP3),
                new Vector(12.818000, 12.004000, 2.056000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(12.930000, 12.917000, 3.728000));
        addAtom(new Silicon(Atom.SP3),
                new Vector(12.322000, 11.854000, 5.082000));
        addAtom(new Silicon(Atom.SP3),
                new Vector(10.670000, 11.974000, 2.063000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(10.445000, 12.728000, 3.835000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(10.415000, 11.537000, 4.869000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-4.545000, -5.565000, 0.379000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-4.443000, -1.318000, 1.877000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-4.526000, -0.216000, 4.711000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-4.547000, -4.329000, 2.224000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-4.516000, -2.037000, 3.072000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-4.533000, -1.470000, 4.293000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-4.544000, -3.379000, 3.141000));
        addAtom(new Hydrogen(),
                new Vector(3.871000, 13.594000, 0.458000));
        addAtom(new Hydrogen(),
                new Vector(0.269000, 12.390000, 1.968000));
        addAtom(new Hydrogen(),
                new Vector(-2.117000, 12.739000, 2.191000));
        addAtom(new Hydrogen(),
                new Vector(6.197000, 12.766000, 0.588000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(4.412000, 11.416000, 0.064000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(1.291000, -6.540000, -2.539000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(1.228000, 2.381000, 4.856000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(3.919000, 11.922000, -2.623000));
        addAtom(new Silicon(Atom.SP3),
                new Vector(12.554000, 8.882000, 5.936000));
        addAtom(new Silicon(Atom.SP3),
                new Vector(13.651000, 10.243000, 4.939000));
        addAtom(new Silicon(Atom.SP3),
                new Vector(10.378000, 8.936000, 5.642000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(10.155000, 10.155000, 4.410000));
        addAtom(new Hydrogen(),
                new Vector(12.547000, -0.169000, 7.753000));
        addAtom(new Hydrogen(),
                new Vector(10.023000, -0.155000, 7.604000));
        addAtom(new Hydrogen(),
                new Vector(10.049000, -2.364000, 6.962000));
        addAtom(new Hydrogen(),
                new Vector(12.574000, -2.388000, 7.104000));
        addAtom(new Hydrogen(),
                new Vector(12.646000, -4.384000, 5.997000));
        addAtom(new Hydrogen(),
                new Vector(10.117000, -4.357000, 5.886000));
        addAtom(new Hydrogen(),
                new Vector(10.170000, -6.093000, 4.400000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(3.745000, 13.118000, -1.729000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(6.209000, 12.270000, -1.592000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(5.433000, 11.526000, -2.644000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(4.149000, -6.439000, -0.659000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(4.181000, -3.711000, -1.679000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(4.255000, -6.085000, -5.408000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(4.174000, -6.613000, -1.960000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(4.234000, -3.545000, -3.982000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.205000, -4.365000, -2.886000));
        addAtom(new Hydrogen(),
                new Vector(12.699000, -6.115000, 4.485000));
        addAtom(new Hydrogen(),
                new Vector(10.205000, -7.456000, 2.594000));
        addAtom(new Hydrogen(),
                new Vector(12.738000, -7.469000, 2.663000));
        addAtom(new Hydrogen(),
                new Vector(10.267000, -8.423000, 0.524000));
        addAtom(new Hydrogen(),
                new Vector(12.800000, -8.413000, 0.579000));
        addAtom(new Hydrogen(),
                new Vector(10.309000, -8.916000, -1.682000));
        addAtom(new Hydrogen(),
                new Vector(12.844000, -8.897000, -1.620000));
        addAtom(new Hydrogen(),
                new Vector(12.906000, -8.913000, -3.898000));
        addAtom(new Hydrogen(),
                new Vector(10.372000, -8.943000, -3.964000));
        addAtom(new Hydrogen(),
                new Vector(12.956000, -8.467000, -6.096000));
        addAtom(new Hydrogen(),
                new Vector(10.422000, -8.491000, -6.172000));
        addAtom(new Hydrogen(),
                new Vector(13.010000, -7.565000, -8.182000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(4.317000, -5.046000, -7.344000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(4.336000, -4.198000, -8.348000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.271000, -4.894000, -6.014000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(4.258000, -2.466000, -6.011000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(4.105000, 6.316000, 4.883000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.257000, -3.657000, -5.346000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.196000, 7.547000, 2.782000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(4.252000, 8.850000, 2.462000));
        addAtom(new Hydrogen(),
                new Vector(10.476000, -7.585000, -8.261000));
        addAtom(new Hydrogen(),
                new Vector(13.073000, -6.271000, -10.012000));
        addAtom(new Hydrogen(),
                new Vector(10.537000, -6.280000, -10.090000));
        addAtom(new Hydrogen(),
                new Vector(13.105000, -4.603000, -11.562000));
        addAtom(new Hydrogen(),
                new Vector(10.571000, -4.611000, -11.624000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(11.009000, -5.358000, -9.684000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(11.034000, -4.295000, -10.663000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(12.593000, -4.290000, -10.625000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(4.145000, 7.381000, 4.111000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.311000, 9.561000, 1.334000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.303000, 9.072000, 0.031000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.324000, 10.256000, -0.811000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(4.284000, 7.370000, -1.787000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(4.400000, 10.469000, -2.250000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(4.222000, 6.692000, 0.489000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(12.568000, -5.352000, -9.641000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(10.900000, -7.487000, -6.175000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(10.936000, -6.910000, -7.504000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(12.494000, -6.897000, -7.457000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(12.459000, -7.472000, -6.128000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(10.801000, -8.007000, -2.096000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(10.838000, -8.022000, -3.546000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.197000, 6.489000, 1.843000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(4.264000, 9.903000, -4.546000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.308000, 9.362000, -3.320000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.201000, -5.767000, -2.995000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(4.226000, -6.448000, -4.146000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.260000, 7.741000, -0.388000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(12.396000, -8.006000, -3.503000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(12.359000, -7.994000, -2.054000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(12.307000, -7.415000, 0.571000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(12.275000, -6.812000, 1.894000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(10.749000, -7.421000, 0.529000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(10.717000, -6.809000, 1.848000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(12.235000, -5.199000, 4.058000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(12.205000, -4.099000, 5.016000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(10.677000, -5.188000, 3.998000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(4.337000, 8.263000, -7.604000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.296000, 8.202000, -6.273000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(4.160000, 5.171000, 2.211000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(4.435000, 4.343000, -10.296000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(4.261000, 9.432000, -5.767000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.411000, 6.014000, -8.517000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.289000, 7.961000, -3.110000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.330000, 3.125000, -9.775000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(4.218000, 1.588000, -7.918000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(10.648000, -4.084000, 4.947000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(12.138000, -1.725000, 6.324000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(12.118000, -0.322000, 6.738000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(10.582000, -1.711000, 6.236000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(10.564000, -0.309000, 6.645000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(10.480000, 6.087000, 7.081000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(12.051000, 6.076000, 7.229000));
        addAtom(new Silicon(Atom.SP3),
                new Vector(12.673000, 9.552000, 3.274000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(13.522000, 10.351000, 2.070000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.258000, 2.863000, -8.404000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(4.244000, 3.858000, -7.453000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.293000, 5.229000, -7.373000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(4.260000, 5.774000, -6.106000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.283000, 7.022000, -5.518000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(4.061000, 3.017000, 6.052000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(4.071000, 4.304000, 5.781000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(10.722000, 9.551000, 3.183000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(10.295000, 10.290000, 2.091000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(10.613000, 6.306000, 5.549000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(9.906000, 7.409000, 5.004000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(13.094000, 6.897000, -6.743000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(13.101000, -5.824000, -2.778000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(13.020000, -6.393000, -5.232000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(13.061000, 5.604000, -7.230000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.108000, 4.998000, 4.637000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.141000, 4.421000, 3.354000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(4.058000, -0.467000, 5.783000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(4.397000, 7.348000, -8.538000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(4.055000, 0.818000, 6.055000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.079000, 1.916000, 5.290000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(13.005000, 7.497000, -3.086000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(13.058000, 5.057000, -10.941000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(13.062000, 3.738000, -11.332000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(13.076000, 3.554000, -8.347000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(12.984000, -0.425000, 4.499000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(13.053000, 7.972000, -1.788000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(12.206000, 6.284000, 5.680000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(13.011000, 6.899000, 0.591000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(12.911000, 3.585000, 2.376000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(4.275000, 7.041000, -4.140000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(4.071000, -3.546000, 4.140000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(4.495000, 5.536000, -9.758000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(4.062000, -2.478000, 4.903000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.079000, -1.166000, 4.641000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(12.938000, 2.541000, 3.298000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(13.190000, 5.621000, -9.678000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(13.051000, 6.993000, -9.880000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(13.135000, 7.995000, 2.810000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(12.779000, 0.412000, 5.609000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(13.043000, 8.034000, -8.978000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(13.037000, 9.360000, -7.210000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(13.165000, 8.029000, -7.592000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(12.975000, 7.000000, -0.794000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(12.939000, 5.607000, 1.127000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(13.033000, -3.238000, 2.937000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(4.258000, 2.203000, -10.742000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(4.226000, 0.890000, -10.730000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(4.108000, -5.714000, 1.408000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(4.133000, -2.942000, 0.506000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.106000, -2.697000, 1.858000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(4.091000, -5.036000, 2.532000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(4.107000, -1.367000, 2.208000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.096000, -0.603000, 3.351000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(12.916000, -6.358000, -0.317000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(12.987000, -6.668000, -3.881000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(13.094000, 1.541000, -11.509000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(13.078000, 7.975000, -4.385000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(13.039000, 10.417000, -2.415000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(13.073000, 1.213000, -8.531000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(12.976000, -2.311000, 1.869000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(13.157000, 8.041000, 1.413000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(13.174000, -5.186000, -5.911000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(12.978000, -3.666000, -1.616000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(13.126000, 2.445000, -9.174000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(13.034000, -4.408000, -2.791000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.096000, -3.729000, 2.815000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.273000, -0.014000, -9.747000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(4.118000, 3.066000, 3.144000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.138000, -5.352000, 0.121000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.145000, -4.024000, -0.343000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(12.939000, -6.652000, -1.668000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(13.116000, 4.936000, -8.438000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(12.930000, -0.948000, 2.091000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(13.201000, 2.569000, -10.586000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(13.177000, 9.358000, -4.692000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(12.961000, 4.970000, 2.372000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(13.011000, -3.678000, -3.977000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(13.063000, -1.014000, -7.754000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(12.780000, 3.947000, 5.352000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(13.043000, -5.143000, 0.352000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(13.035000, 7.005000, -5.367000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(12.999000, -3.855000, -0.236000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(12.887000, -5.442000, 1.706000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.264000, 10.004000, -0.290000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.137000, 9.443000, 0.959000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.272000, -2.009000, -7.298000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(5.601000, 12.321000, -0.237000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(4.312000, -1.258000, -10.244000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(4.102000, 0.754000, 3.141000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.246000, 0.303000, -8.383000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(10.021000, 7.069000, -0.875000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.294000, 10.473000, -3.827000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.292000, 10.484000, -2.445000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.126000, 9.431000, -1.547000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.051000, 8.046000, -1.849000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(10.051000, 7.565000, -3.142000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.278000, 9.400000, -7.248000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.293000, 9.986000, -5.994000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.122000, 9.421000, -4.735000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.062000, 8.036000, -4.437000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(10.065000, 7.052000, -5.413000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(13.143000, 0.176000, -11.330000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.116000, -4.607000, 2.717000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.128000, -5.439000, 1.615000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.108000, 1.911000, 3.882000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(4.247000, -0.651000, -7.410000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.313000, -2.862000, -8.413000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(4.335000, -2.449000, -9.687000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(4.166000, 12.867000, -0.329000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(9.976000, -5.158000, 0.254000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.161000, -6.375000, -0.396000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.183000, -6.676000, -1.745000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.025000, -5.860000, -2.870000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.230000, -6.699000, -3.961000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.261000, -6.422000, -5.314000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(9.966000, -3.711000, -4.073000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(9.964000, -4.443000, -2.891000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(9.935000, -3.695000, -1.725000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(9.928000, -3.876000, -0.349000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(9.907000, -2.715000, 0.402000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.360000, -4.738000, -8.465000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.090000, -5.221000, -6.007000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.316000, -5.540000, -7.344000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-1.438000, -0.066000, -7.583000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-1.465000, -1.433000, -7.607000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-1.611000, -4.379000, -0.918000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-1.639000, -5.759000, -0.640000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-1.488000, -2.151000, -8.812000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.005000, -3.918000, -5.446000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.410000, -1.931000, -10.662000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.408000, -3.112000, -9.956000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.171000, -3.363000, -8.608000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.323000, 1.520000, -11.567000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.371000, 0.152000, -11.390000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.173000, -0.621000, -10.248000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.112000, 2.555000, -10.652000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.299000, 3.731000, -11.384000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.299000, 5.057000, -10.986000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-1.425000, 0.999000, -8.444000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-1.451000, 0.840000, -9.833000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(1.232000, 1.302000, 4.056000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(10.053000, 3.554000, -8.403000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.050000, 2.438000, -9.238000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(10.025000, 1.200000, -8.598000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.048000, -0.157000, -8.911000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(10.011000, -1.032000, -7.828000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(9.995000, -2.769000, -6.231000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.043000, -2.401000, -7.571000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-5.298000, 13.734000, -2.094000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-7.323000, 14.459000, -3.125000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.059000, -1.706000, 4.817000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.085000, -2.922000, 4.159000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(9.945000, -3.229000, 2.804000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-5.569000, 12.788000, -3.255000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-6.338000, 13.673000, -1.043000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-6.879000, 13.254000, -3.887000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-7.666000, 14.145000, -1.692000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-1.484000, -0.345000, -10.459000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(1.211000, 0.249000, 1.877000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-6.794000, 11.784000, -3.293000));
        addAtom(new Hydrogen(),
                new Vector(-4.762000, 12.692000, -4.012000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-7.532000, 12.726000, -1.124000));
        addAtom(new Hydrogen(),
                new Vector(-6.123000, 14.212000, -0.092000));
        addAtom(new Hydrogen(),
                new Vector(-6.721000, 13.443000, -4.971000));
        addAtom(new Hydrogen(),
                new Vector(-8.187000, 14.926000, -1.095000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(1.246000, -3.060000, 0.315000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-1.490000, -1.591000, -10.032000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-7.054000, 10.684000, -4.391000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-7.397000, 11.574000, -1.974000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-7.836000, 12.282000, 0.224000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-7.188000, 9.280000, -4.131000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-7.201000, 11.166000, -5.645000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-7.398000, 10.391000, -1.076000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-7.629000, 10.861000, 0.196000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-7.219000, 8.306000, -5.087000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-7.211000, 8.696000, -2.822000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-7.328000, 10.575000, -6.828000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-7.292000, 9.053000, -1.448000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-7.591000, 10.142000, 1.341000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-7.227000, 8.165000, -6.435000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-7.306000, 9.290000, -7.265000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-7.306000, 7.985000, -0.580000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-7.442000, 8.830000, 1.686000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-7.178000, 6.854000, -6.886000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-7.357000, 9.216000, -8.601000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-7.360000, 7.754000, 0.769000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-7.415000, 8.663000, 3.014000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-7.166000, 6.166000, -8.082000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-7.298000, 8.201000, -9.439000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-7.333000, 6.409000, 1.143000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-7.378000, 7.591000, 3.783000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-7.114000, 4.770000, -8.001000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-7.195000, 6.866000, -9.304000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-7.356000, 5.641000, 2.300000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-7.378000, 6.262000, 3.565000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-7.126000, 3.677000, -8.870000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-7.132000, 6.290000, -10.505000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-7.349000, 4.245000, 2.143000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-7.373000, 5.607000, 4.730000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-7.119000, 2.400000, -8.298000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-7.159000, 3.861000, -10.270000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-7.119000, 5.040000, -10.900000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-7.367000, 3.099000, 2.951000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-7.378000, 4.335000, 5.056000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-7.167000, 1.065000, -8.722000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-7.187000, 2.883000, -11.176000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-7.381000, 1.855000, 2.312000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-7.389000, 3.192000, 4.358000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-7.180000, 0.085000, -7.737000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-7.232000, 0.712000, -10.085000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-7.227000, 1.576000, -11.101000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-7.394000, 0.493000, 2.649000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-7.386000, 2.151000, 5.202000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-7.227000, -1.305000, -7.639000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-7.271000, -0.540000, -10.565000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-7.425000, -0.416000, 1.605000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-7.388000, 0.043000, 3.980000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-7.385000, 0.845000, 5.050000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-7.256000, -2.156000, -8.752000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-7.259000, -1.826000, -6.369000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-7.282000, -1.734000, -10.019000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-7.422000, -1.789000, 1.388000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-7.383000, -1.249000, 4.361000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-7.256000, -3.503000, -8.693000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-7.296000, -3.038000, -5.710000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-7.450000, -2.192000, 0.080000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-7.383000, -2.729000, 2.420000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-7.384000, -2.404000, 3.721000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-7.261000, -4.385000, -7.709000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-7.270000, -4.265000, -6.372000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-7.359000, -2.963000, -4.345000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-7.420000, -3.328000, -0.696000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-7.383000, -4.070000, 2.232000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-7.279000, -5.464000, -5.747000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-7.374000, -3.772000, -3.238000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-7.364000, -4.609000, -0.162000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-7.427000, -3.115000, -2.045000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-7.380000, -4.856000, 1.164000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-7.301000, -5.840000, -4.475000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-7.319000, -5.158000, -3.312000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-7.361000, -5.734000, -0.914000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-7.341000, -5.963000, -2.223000));
        addAtom(new Hydrogen(),
                new Vector(8.503000, -3.136000, -14.216000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(7.137000, 6.703000, -1.655000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(7.124000, 6.864000, -0.293000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(6.961000, 0.483000, 3.014000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(6.981000, 0.260000, 4.402000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(7.180000, 8.119000, 0.331000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(7.196000, 7.473000, -2.786000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(7.279000, 8.862000, -2.718000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(7.300000, 9.580000, -1.593000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(7.258000, 9.279000, -0.319000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(7.097000, -4.122000, -3.418000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(7.084000, -4.649000, -2.145000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(7.050000, -3.724000, -1.127000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(7.035000, -3.707000, 0.250000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(7.003000, -2.457000, 0.818000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(6.990000, -1.899000, 2.073000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(6.964000, -0.531000, 2.093000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(7.007000, -0.948000, 4.977000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(7.019000, -2.169000, 4.494000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(7.012000, -2.667000, 3.252000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(7.055000, -4.884000, 1.022000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(7.057000, -4.927000, 2.359000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(7.042000, -4.003000, 3.291000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(7.108000, -6.036000, -1.907000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(7.103000, -6.606000, -0.697000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(7.082000, -6.126000, 0.524000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(7.132000, -4.569000, -4.720000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(7.161000, -5.934000, -5.058000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(7.153000, -6.937000, -4.173000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(7.132000, -6.978000, -2.860000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(7.173000, 2.272000, -8.748000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(7.207000, 3.621000, -8.974000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(7.210000, 4.394000, -7.841000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(7.234000, 5.725000, -7.510000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(7.216000, 5.984000, -6.161000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(7.222000, 7.075000, -5.329000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(7.198000, 6.790000, -3.981000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(7.348000, 9.667000, -3.773000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(7.298000, 9.482000, -5.067000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(7.238000, 8.391000, -5.822000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(7.267000, 6.744000, -8.485000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(7.225000, 8.052000, -8.226000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(7.212000, 8.739000, -7.111000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(7.243000, 4.162000, -10.269000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(7.277000, 5.467000, -10.555000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(7.284000, 6.545000, -9.808000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(7.149000, 1.100000, -9.459000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(7.102000, 1.048000, -10.877000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(7.077000, 2.158000, -11.636000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(7.152000, 3.445000, -11.392000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(7.133000, -3.581000, -5.675000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(7.173000, -3.465000, -7.044000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(7.148000, -2.173000, -7.505000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(7.169000, -1.514000, -8.707000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(7.136000, -0.076000, -8.617000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(7.028000, -0.221000, -11.748000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(7.391000, -1.535000, -11.251000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(7.276000, -2.162000, -9.935000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(7.397000, -3.523000, -10.164000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(7.349000, -4.503000, -9.254000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(7.241000, -4.579000, -7.912000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(7.217000, -5.854000, -7.502000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(7.179000, -6.415000, -6.312000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(7.059000, 5.703000, 0.419000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(7.030000, 5.298000, 1.723000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(7.060000, 6.191000, 2.806000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(7.114000, 7.522000, 2.690000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(7.159000, 8.326000, 1.653000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(6.981000, 3.947000, 1.887000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(6.968000, 3.034000, 2.897000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(6.990000, 3.400000, 4.252000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(7.021000, 4.662000, 4.700000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(7.043000, 5.829000, 4.095000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(6.950000, 1.736000, 2.475000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(6.991000, 1.222000, 5.334000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(6.994000, 2.535000, 5.273000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(6.009000, -0.267000, -12.917000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(5.691000, -1.507000, -13.712000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(8.011000, -0.944000, -14.158000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(7.504000, 0.072000, -13.210000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(7.527000, -2.597000, -12.215000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(7.982000, -2.342000, -13.637000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(6.499000, -2.682000, -13.332000));
        addAtom(new Hydrogen(),
                new Vector(6.203000, -3.666000, -13.757000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(7.638000, -3.856000, -11.532000));
        addAtom(new Hydrogen(),
                new Vector(7.620000, 1.107000, -13.601000));
        addAtom(new Hydrogen(),
                new Vector(5.340000, 0.609000, -13.079000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-10.898000, 7.140000, -10.808000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(1.256000, -6.006000, -0.411000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(1.225000, 0.154000, 4.757000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(1.219000, -1.108000, 1.982000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(1.248000, -4.165000, 1.180000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.283000, 4.881000, -10.620000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.047000, 2.231000, -8.947000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-10.130000, -1.222000, -7.574000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.121000, -3.490000, -8.429000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.281000, -4.853000, -8.345000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(2.218000, 25.272000, -12.966000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-12.984000, -4.976000, -8.388000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-1.423000, 9.783000, 0.345000));
        addAtom(new Fluorine(Atom.SP3),
                new Vector(3.273000, 12.051000, -3.845000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(2.327000, 23.978000, -12.457000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.210000, -3.618000, -8.450000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-13.099000, -1.306000, -7.613000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(-10.183000, -7.625000, -8.828000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(-12.789000, -7.768000, -8.889000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.034000, 3.566000, -11.068000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-1.253000, 10.172000, 2.659000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-1.478000, 10.231000, -1.035000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-12.450000, 5.890000, -11.567000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.193000, 2.373000, -10.361000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-13.105000, 0.956000, -8.338000));
        addAtom(new Hydrogen(),
                new Vector(-12.942000, 7.963000, -11.384000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-10.891000, 5.892000, -11.562000));
        addAtom(new Hydrogen(),
                new Vector(-10.411000, 7.969000, -11.368000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.280000, 3.570000, -11.070000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.121000, 2.380000, -10.357000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-10.066000, 0.994000, -8.327000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.113000, -0.347000, -8.654000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.145000, -3.258000, -9.807000));
        addAtom(new Silicon(Atom.SP3),
                new Vector(-0.997000, 13.663000, -0.487000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-10.808000, -5.340000, -9.646000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-12.406000, -5.432000, -9.681000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.255000, -3.391000, -9.804000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.141000, -0.391000, -8.675000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-10.712000, -6.869000, -9.926000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-12.286000, -6.973000, -9.972000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-12.437000, 3.339000, -12.447000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-1.562000, 7.071000, -1.030000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(4.829000, 14.000000, -4.162000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(1.691000, 20.500000, -13.610000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(2.176000, 18.602000, -2.467000));
        addAtom(new Hydrogen(),
                new Vector(-12.934000, 6.002000, -12.563000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.108000, 1.374000, -11.321000));
        addAtom(new Hydrogen(),
                new Vector(-10.403000, 6.005000, -12.556000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-0.312000, 19.499000, -10.517000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-10.871000, 3.327000, -12.453000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(0.320000, 19.680000, -9.296000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.285000, 1.363000, -11.296000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.178000, -0.783000, -10.006000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(2.132000, 19.213000, -4.719000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(1.554000, 17.411000, -2.694000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.342000, -2.085000, -10.494000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-10.070000, -4.493000, -10.506000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.720000, 21.677000, -7.080000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(5.385000, 18.680000, -3.503000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(0.652000, 18.570000, -8.524000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-0.252000, 14.753000, -9.866000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(1.281000, 21.122000, -7.659000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(0.614000, 20.974000, -8.841000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(1.229000, 18.760000, -7.282000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(4.911000, 16.006000, -2.427000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(1.317000, 17.693000, -6.393000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(3.487000, 17.395000, -10.486000));
        addAtom(new Hydrogen(),
                new Vector(0.101000, 25.705000, -14.435000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(1.638000, 17.947000, -5.055000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(4.018000, 14.620000, -8.197000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(4.377000, 22.927000, -7.481000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-13.228000, -4.662000, -10.545000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.270000, -2.151000, -10.411000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.268000, -0.810000, -10.019000));
        addAtom(new Silicon(Atom.SP3),
                new Vector(-10.240000, -7.395000, -11.753000));
        addAtom(new Silicon(Atom.SP3),
                new Vector(-12.439000, -7.646000, -11.813000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-12.464000, 1.890000, -12.613000));
        addAtom(new Hydrogen(),
                new Vector(-12.920000, 3.875000, -13.294000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.324000, 0.015000, -11.202000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-10.889000, 1.870000, -12.595000));
        addAtom(new Hydrogen(),
                new Vector(-10.381000, 3.841000, -13.309000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.200000, -0.005000, -11.154000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-10.829000, -2.076000, -11.959000));
        addAtom(new Silicon(Atom.SP3),
                new Vector(-10.544000, -4.621000, -12.148000));
        addAtom(new Silicon(Atom.SP3),
                new Vector(-12.729000, -4.855000, -12.223000));
        addAtom(new Silicon(Atom.SP3),
                new Vector(-12.779000, -2.113000, -12.026000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-9.656000, -5.982000, -12.780000));
        addAtom(new Hydrogen(),
                new Vector(-9.455000, -8.630000, -11.877000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-13.087000, -6.402000, -13.100000));
        addAtom(new Hydrogen(),
                new Vector(-12.861000, -9.046000, -11.956000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(-13.053000, 1.505000, -13.879000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-13.576000, -0.698000, -12.430000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(-10.315000, 1.372000, -13.768000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-10.360000, -0.816000, -12.314000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-10.276000, -3.079000, -12.898000));
        addAtom(new Silicon(Atom.SP3),
                new Vector(-13.785000, -3.451000, -13.211000));
        addAtom(new Silicon(Atom.SP3),
                new Vector(-10.081000, -5.836000, -14.519000));
        addAtom(new Silicon(Atom.SP3),
                new Vector(-12.257000, -6.166000, -14.874000));
        addAtom(new Hydrogen(),
                new Vector(-14.184000, -6.527000, -13.209000));
        addAtom(new Silicon(Atom.SP3),
                new Vector(-12.821000, -0.188000, -13.981000));
        addAtom(new Silicon(Atom.SP3),
                new Vector(-10.671000, -0.264000, -13.916000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-10.533000, -3.103000, -14.344000));
        addAtom(new Silicon(Atom.SP3),
                new Vector(-12.425000, -3.129000, -14.761000));
        addAtom(new Hydrogen(),
                new Vector(-15.250000, -3.431000, -13.315000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(-9.803000, -4.138000, -15.008000));
        addAtom(new Hydrogen(),
                new Vector(-9.264000, -6.749000, -15.331000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-12.783000, -4.526000, -15.768000));
        addAtom(new Hydrogen(),
                new Vector(-12.481000, -7.339000, -15.730000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-1.536000, 16.586000, -14.109000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(2.673000, 18.952000, -12.114000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-12.939000, -1.486000, -15.379000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(1.336000, 17.007000, -4.050000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(0.714000, 15.486000, -5.829000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(0.807000, 15.768000, -4.498000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-1.150000, 20.433000, -12.566000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.648000, 15.432000, -6.066000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(3.933000, 18.465000, -9.686000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(0.107000, 14.943000, -3.728000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(0.338000, 17.276000, -8.964000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(0.521000, 16.172000, -8.129000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-1.566000, 7.231000, 0.414000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(3.753000, 19.774000, -10.115000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-1.030000, 18.021000, -12.291000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(3.108000, 20.018000, -11.325000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-10.471000, -1.778000, -15.136000));
        addAtom(new Hydrogen(),
                new Vector(-13.824000, -4.628000, -16.042000));
        addAtom(new Sulfur(Atom.SP3),
                new Vector(-11.852000, -3.577000, -17.026000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(2.815000, 21.330000, -11.702000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(2.078000, 21.571000, -12.857000));
        addAtom(new Hydrogen(),
                new Vector(-13.875000, -1.456000, -15.920000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-11.694000, -1.849000, -16.153000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-1.585000, 6.067000, 1.148000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-1.639000, -6.724000, -1.565000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(-9.282000, -1.634000, -15.881000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(-11.526000, -0.901000, -17.171000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-0.665000, 20.609000, -11.273000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(1.224000, -1.775000, 0.785000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(12.847000, -2.940000, 4.294000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(12.818000, -1.725000, 4.969000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(12.789000, 5.191000, 4.851000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(12.955000, 2.741000, 4.711000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(13.151000, 9.363000, -1.504000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(13.095000, 7.032000, 3.797000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(13.077000, -5.517000, -7.260000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(12.950000, -2.701000, 0.535000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(12.910000, 1.282000, 2.743000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(13.050000, 10.414000, -3.795000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(13.120000, -2.379000, -7.487000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(13.037000, -2.743000, -6.146000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(13.046000, 7.339000, 5.236000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(2.915000, 23.711000, -11.236000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(13.259000, 9.419000, 1.002000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(13.121000, -4.722000, -8.387000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(13.255000, -3.341000, -8.522000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-1.531000, 9.699000, -4.680000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(12.954000, -0.037000, 3.134000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-1.607000, 4.338000, 2.690000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(3.188000, 22.394000, -10.875000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(13.082000, 9.964000, -0.256000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(13.132000, -0.141000, -8.837000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(13.167000, -3.100000, -9.893000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(3.769000, 22.141000, -9.642000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(12.880000, -4.619000, 2.823000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(13.172000, -1.916000, -10.606000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-1.290000, 19.131000, -13.094000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(12.753000, 1.792000, 5.714000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-1.563000, 9.989000, -3.400000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(13.273000, -0.597000, -10.173000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-1.539000, 9.281000, -2.259000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(13.038000, 5.675000, 3.585000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(13.054000, 9.936000, -5.956000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(0.066000, 12.297000, -0.259000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(13.081000, -3.886000, -5.352000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-1.541000, 7.858000, -2.256000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-1.399000, 8.038000, -7.748000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(10.069000, 5.626000, -7.276000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.063000, 6.931000, -6.791000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.022000, 6.961000, 0.499000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.085000, 8.109000, 1.337000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.102000, 8.066000, -7.639000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-1.564000, -4.351000, -3.491000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-1.484000, 8.556000, -5.366000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-1.460000, 8.804000, -6.682000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.067000, 4.945000, -8.487000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.118000, 5.630000, -9.728000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.077000, 20.843000, -9.265000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-1.212000, 5.262000, -9.886000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-1.214000, 6.394000, -9.212000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-1.336000, 6.713000, -7.916000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.292000, 7.005000, -9.919000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-1.258000, 10.786000, 1.374000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-0.245000, 14.936000, -2.444000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-1.322000, 3.980000, -9.517000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-1.363000, 3.162000, -10.580000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.283000, 8.057000, -9.020000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-1.421000, 1.854000, -10.712000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-1.406000, 2.231000, -7.845000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-1.379000, 3.556000, -8.193000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(9.886000, -0.944000, 1.924000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(9.878000, -0.024000, 2.956000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-1.413000, 5.781000, -6.884000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(9.884000, 1.300000, 2.555000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(9.888000, 2.566000, 3.109000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-1.497000, 7.282000, -4.785000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-1.529000, 7.102000, -3.416000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(9.927000, 3.626000, 2.199000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(9.955000, 5.021000, 2.208000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(9.983000, 5.661000, 0.984000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.214000, 8.162000, 2.726000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.001000, 7.135000, 3.615000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-1.631000, 3.890000, 5.093000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(9.955000, 5.751000, 3.399000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-2.349000, 12.648000, -0.022000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-1.642000, 3.073000, 6.154000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(9.889000, 2.760000, 4.515000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-1.614000, 3.465000, 3.750000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.030000, 3.970000, 5.154000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-1.648000, -1.669000, 5.622000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-1.643000, -0.422000, 6.040000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.090000, 5.232000, 4.663000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(9.906000, -0.411000, 4.323000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-1.673000, -4.524000, 3.599000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.026000, 0.426000, 5.439000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-1.668000, -3.562000, 4.495000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-1.650000, -2.227000, 4.404000));
        addAtom(new Fluorine(Atom.SP3),
                new Vector(-0.164000, 11.792000, -2.584000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(9.998000, 1.805000, 5.534000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-1.660000, -4.531000, 2.259000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(6.466000, 13.566000, -1.995000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-1.675000, -5.787000, 1.797000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.754000, 19.308000, -7.545000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(9.900000, -2.311000, 1.726000));
        addAtom(new Sulfur(Atom.SP3),
                new Vector(-0.202000, 15.314000, 0.073000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-1.619000, 2.143000, 3.399000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.427000, 18.233000, -8.399000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-0.307000, 11.935000, 1.133000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-1.628000, 0.917000, 4.009000));
        addAtom(new Hydrogen(),
                new Vector(8.029000, 22.295000, -26.164000));
        addAtom(new Hydrogen(),
                new Vector(-3.100000, 22.020000, -17.616000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(-1.542000, 22.428000, -15.631000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(3.936000, 23.180000, -8.742000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(5.259000, 20.167000, -5.327000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.232000, 3.044000, 5.592000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.302000, 4.272000, 2.690000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-13.250000, 2.880000, 2.602000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.243000, 4.366000, 5.200000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.378000, 4.942000, 3.938000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.258000, 6.313000, 4.153000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.270000, 7.370000, 3.264000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.395000, 7.394000, 1.876000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.286000, 1.761000, 3.434000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-10.220000, 2.889000, 2.670000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.219000, 4.281000, 2.749000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.293000, 7.395000, 1.921000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.491000, 8.726000, 1.554000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.291000, 4.959000, 3.996000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.491000, 6.326000, 4.193000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.500000, 7.374000, 3.298000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.228000, 1.775000, 3.511000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.278000, 1.892000, 4.925000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.468000, 3.063000, 5.656000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.480000, 4.385000, 5.254000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.230000, -0.819000, 3.200000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-10.236000, 0.536000, 2.880000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.455000, 0.855000, 5.846000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.443000, -0.517000, 5.681000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.258000, -1.290000, 4.539000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.430000, -2.614000, 4.956000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.425000, -3.799000, 4.243000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.255000, 8.737000, 1.520000));
        addAtom(new Nitrogen(Atom.SP2),
                new Vector(-13.240000, 0.522000, 2.799000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.195000, -2.619000, 4.886000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.274000, -0.834000, 3.117000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.359000, 1.874000, 4.847000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.210000, -0.527000, 5.606000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.198000, -3.806000, 4.179000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.219000, 0.842000, 5.775000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-13.337000, -1.299000, 4.455000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-11.032000, -6.050000, 3.934000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-11.051000, -4.994000, 4.933000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-12.591000, -6.057000, 3.905000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-12.611000, -4.997000, 4.900000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-12.623000, -2.694000, 6.284000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-12.636000, -1.323000, 6.757000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-11.077000, -1.319000, 6.798000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-11.064000, -2.691000, 6.323000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-12.652000, 1.335000, 7.086000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-12.659000, 2.777000, 6.966000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-11.100000, 2.788000, 7.002000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-11.093000, 1.345000, 7.125000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-12.673000, 5.340000, 6.203000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-12.674000, 6.613000, 5.516000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-11.114000, 6.622000, 5.538000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-11.113000, 5.352000, 6.230000));
        addAtom(new Hydrogen(),
                new Vector(-10.640000, 7.424000, 6.147000));
        addAtom(new Hydrogen(),
                new Vector(-13.175000, 7.404000, 6.116000));
        addAtom(new Hydrogen(),
                new Vector(-10.644000, 5.431000, 7.236000));
        addAtom(new Hydrogen(),
                new Vector(-13.180000, 5.403000, 7.191000));
        addAtom(new Hydrogen(),
                new Vector(-10.637000, 3.281000, 7.886000));
        addAtom(new Hydrogen(),
                new Vector(-13.171000, 3.258000, 7.829000));
        addAtom(new Hydrogen(),
                new Vector(-10.628000, 1.012000, 8.079000));
        addAtom(new Hydrogen(),
                new Vector(-13.161000, 0.995000, 8.015000));
        addAtom(new Hydrogen(),
                new Vector(-10.618000, -1.226000, 7.807000));
        addAtom(new Hydrogen(),
                new Vector(-13.151000, -1.231000, 7.739000));
        addAtom(new Hydrogen(),
                new Vector(-13.127000, -3.383000, 6.997000));
        addAtom(new Hydrogen(),
                new Vector(-10.594000, -3.382000, 7.057000));
        addAtom(new Hydrogen(),
                new Vector(-13.117000, -5.316000, 5.838000));
        addAtom(new Hydrogen(),
                new Vector(-10.586000, -5.320000, 5.890000));
        addAtom(new Hydrogen(),
                new Vector(-13.079000, -6.986000, 4.277000));
        addAtom(new Hydrogen(),
                new Vector(-10.548000, -6.977000, 4.315000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-12.681000, 8.658000, 3.789000));
        helper();
    }
    
    private void helper() {
        addAtom(new Carbon(Atom.SP3),
                new Vector(-11.121000, 8.658000, 3.806000));
        addAtom(new Silicon(Atom.SP3),
                new Vector(8.970000, 28.944000, -14.879000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(6.300000, 30.304000, -8.723000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(7.418000, 31.083000, -8.167000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(7.082000, 31.665000, -6.878000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(7.146000, 28.209000, -7.543000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(7.286000, 27.432000, -8.941000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(5.951000, 29.265000, -7.741000));
        addAtom(new Silicon(Atom.SP3),
                new Vector(7.812000, 28.634000, -10.321000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(8.431000, 28.992000, -7.062000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(7.988000, 29.728000, -5.713000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(8.706000, 30.112000, -8.078000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(5.659000, 29.935000, -6.478000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(6.749000, 30.680000, -5.919000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(9.046000, 29.638000, -9.481000));
        addAtom(new Silicon(Atom.SP3),
                new Vector(10.348000, 28.165000, -9.634000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(7.913000, 26.167000, -6.054000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(8.072000, 25.212000, -7.292000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(6.790000, 27.198000, -6.367000));
        addAtom(new Silicon(Atom.SP3),
                new Vector(8.531000, 26.055000, -8.843000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(9.252000, 26.976000, -5.648000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(9.712000, 28.022000, -6.798000));
        addAtom(new Silicon(Atom.SP3),
                new Vector(10.217000, 26.845000, -8.098000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(11.188000, 25.492000, -7.551000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(9.158000, 24.158000, -6.900000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(10.305000, 25.856000, -5.283000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(10.552000, 24.815000, -6.456000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(11.454000, 23.747000, -6.001000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(4.374000, 29.323000, -3.412000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(1.169000, 28.493000, -7.718000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-0.012000, 27.768000, -8.149000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(2.415000, 27.675000, -7.892000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(0.967000, 28.841000, -6.279000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(3.184000, 31.124000, -4.320000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.479000, 29.737000, -5.676000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(4.392000, 30.356000, -4.390000));
        addAtom(new Hydrogen(),
                new Vector(-0.925000, 28.395000, -8.025000));
        addAtom(new Hydrogen(),
                new Vector(0.058000, 29.480000, -6.194000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(6.679000, 24.677000, -7.712000));
        addAtom(new Hydrogen(),
                new Vector(9.326000, 23.453000, -7.745000));
        addAtom(new Hydrogen(),
                new Vector(11.267000, 26.335000, -4.997000));
        addAtom(new Hydrogen(),
                new Vector(10.775000, 28.746000, -12.836000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(9.750000, 30.435000, -14.297000));
        addAtom(new Hydrogen(),
                new Vector(7.282000, 30.290000, -13.269000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(8.285000, 28.156000, -13.321000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(10.150000, 29.402000, -12.191000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(8.594000, 28.918000, -12.115000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(7.998000, 30.272000, -12.417000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(9.503000, 30.580000, -12.887000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(9.385000, 31.166000, -10.038000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(11.054000, 30.011000, -11.085000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(10.031000, 31.727000, -12.319000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(9.991000, 30.912000, -7.809000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(11.069000, 28.923000, -6.792000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(8.882000, 27.830000, -4.399000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(7.653000, 28.663000, -4.693000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(11.240000, 29.983000, -8.060000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(11.451000, 29.386000, -9.670000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(7.650000, 32.277000, -9.126000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(8.844000, 33.020000, -8.584000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(6.478000, 29.768000, -10.133000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(7.175000, 30.875000, -11.141000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(8.114000, 31.798000, -10.427000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(9.927000, 31.986000, -8.838000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(10.505000, 31.318000, -11.045000));
        addAtom(new Hydrogen(),
                new Vector(12.460000, 28.933000, -9.750000));
        addAtom(new Hydrogen(),
                new Vector(11.339000, 32.014000, -10.812000));
        addAtom(new Hydrogen(),
                new Vector(6.347000, 31.497000, -11.542000));
        addAtom(new Hydrogen(),
                new Vector(6.757000, 32.934000, -9.223000));
        addAtom(new Hydrogen(),
                new Vector(12.145000, 30.590000, -7.844000));
        addAtom(new Hydrogen(),
                new Vector(10.907000, 32.513000, -8.874000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(5.275000, 28.994000, -10.502000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(5.902000, 26.807000, -9.216000));
        addAtom(new Hydrogen(),
                new Vector(10.458000, 27.310000, -10.832000));
        addAtom(new Hydrogen(),
                new Vector(11.992000, 28.304000, -6.710000));
        addAtom(new Hydrogen(),
                new Vector(8.552000, 27.264000, -3.515000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(3.367000, 28.860000, -5.992000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(3.528000, 28.410000, -7.364000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.712000, 28.658000, -8.207000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(4.826000, 27.999000, -9.473000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(2.026000, 30.295000, -4.582000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(2.136000, 29.670000, -5.908000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(3.253000, 28.414000, -3.573000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(3.283000, 27.664000, -4.974000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(1.911000, 29.191000, -3.540000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(5.668000, 25.849000, -7.944000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(5.579000, 26.539000, -6.714000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(6.555000, 27.865000, -5.126000));
        addAtom(new Hydrogen(),
                new Vector(10.029000, 31.377000, -6.801000));
        addAtom(new Hydrogen(),
                new Vector(11.076000, 29.505000, -5.847000));
        addAtom(new Hydrogen(),
                new Vector(8.817000, 30.340000, -5.300000));
        addAtom(new Hydrogen(),
                new Vector(9.739000, 28.463000, -4.083000));
        addAtom(new Hydrogen(),
                new Vector(7.366000, 29.151000, -3.737000));
        addAtom(new Hydrogen(),
                new Vector(-0.237000, 28.732000, -3.679000));
        addAtom(new Hydrogen(),
                new Vector(1.120000, 30.937000, -4.545000));
        addAtom(new Hydrogen(),
                new Vector(1.806000, 29.719000, -2.563000));
        addAtom(new Hydrogen(),
                new Vector(9.033000, 33.930000, -9.197000));
        addAtom(new Hydrogen(),
                new Vector(8.762000, 33.319000, -7.516000));
        addAtom(new Hydrogen(),
                new Vector(0.073000, 27.532000, -9.233000));
        addAtom(new Hydrogen(),
                new Vector(4.196000, 27.056000, -4.983000));
        addAtom(new Sulfur(Atom.SP3),
                new Vector(5.967000, 31.391000, -4.350000));
        addAtom(new Hydrogen(),
                new Vector(6.719000, 23.989000, -8.587000));
        addAtom(new Hydrogen(),
                new Vector(5.937000, 26.181000, -10.134000));
        addAtom(new Hydrogen(),
                new Vector(8.656000, 25.190000, -10.027000));
        addAtom(new Sulfur(Atom.SP3),
                new Vector(3.013000, 27.464000, -9.681000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-2.910000, 21.673000, -2.181000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-3.862000, 21.908000, -3.444000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-3.538000, 20.906000, -4.555000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(-5.178000, 21.474000, -3.068000));
        addAtom(new Hydrogen(),
                new Vector(-3.188000, 22.362000, -1.352000));
        addAtom(new Hydrogen(),
                new Vector(-4.236000, 21.021000, -5.416000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(11.498000, 20.500000, -0.446000));
        addAtom(new Hydrogen(),
                new Vector(12.466000, 20.975000, -0.163000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(8.397000, 24.375000, -4.503000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(8.621000, 23.389000, -5.691000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(7.465000, 25.384000, -4.915000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(9.755000, 25.046000, -4.110000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(8.781000, 22.617000, -2.909000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(9.012000, 21.604000, -4.074000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(7.873000, 23.646000, -3.363000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(9.610000, 22.329000, -5.272000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(10.138000, 23.282000, -2.516000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(10.738000, 23.989000, -3.709000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(10.952000, 22.992000, -4.867000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(11.868000, 21.944000, -4.413000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(2.256000, 26.402000, -7.003000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(1.113000, 25.651000, -7.510000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(2.029000, 26.708000, -5.430000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-0.138000, 26.481000, -7.346000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(0.752000, 27.541000, -5.315000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-0.443000, 26.664000, -5.882000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(1.978000, 24.101000, -5.585000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(1.708000, 25.305000, -4.617000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(1.055000, 24.309000, -6.866000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(0.398000, 22.545000, -4.640000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(0.020000, 23.583000, -3.580000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(1.763000, 22.796000, -4.992000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(0.201000, 24.993000, -4.192000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-0.506000, 22.709000, -5.872000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-0.367000, 24.081000, -6.422000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-0.730000, 25.205000, -5.354000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(-2.126000, 24.945000, -4.910000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-1.150000, 20.909000, -3.771000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-1.510000, 21.914000, -2.629000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(0.217000, 21.197000, -4.135000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-1.413000, 23.356000, -3.156000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-2.092000, 21.106000, -4.984000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-1.957000, 22.528000, -5.491000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-2.344000, 23.567000, -4.384000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(-3.726000, 23.284000, -3.954000));
        addAtom(new Hydrogen(),
                new Vector(3.046000, 24.131000, -5.856000));
        addAtom(new Hydrogen(),
                new Vector(7.681000, 22.860000, -5.945000));
        addAtom(new Hydrogen(),
                new Vector(9.664000, 25.661000, -3.201000));
        addAtom(new Hydrogen(),
                new Vector(8.050000, 21.121000, -4.359000));
        addAtom(new Hydrogen(),
                new Vector(9.774000, 21.612000, -6.109000));
        addAtom(new Hydrogen(),
                new Vector(9.979000, 24.004000, -1.681000));
        addAtom(new Hydrogen(),
                new Vector(11.709000, 24.461000, -3.429000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(2.548000, 25.294000, -3.335000));
        addAtom(new Hydrogen(),
                new Vector(0.637000, 23.445000, -2.672000));
        addAtom(new Hydrogen(),
                new Vector(-0.271000, 25.615000, -3.494000));
        addAtom(new Hydrogen(),
                new Vector(-1.040000, 24.076000, -7.306000));
        addAtom(new Hydrogen(),
                new Vector(-1.684000, 24.074000, -2.348000));
        addAtom(new Hydrogen(),
                new Vector(-2.612000, 22.661000, -6.383000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(0.716000, 28.169000, -3.775000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(10.515000, 21.550000, -0.889000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(11.120000, 22.236000, -2.088000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(9.994000, 20.547000, -3.634000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(9.392000, 19.854000, -2.430000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(8.248000, 21.910000, -1.758000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(9.158000, 20.884000, -1.284000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(11.347000, 21.220000, -3.249000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(12.251000, 20.183000, -2.775000));
        addAtom(new Hydrogen(),
                new Vector(12.087000, 22.714000, -1.804000));
        addAtom(new Hydrogen(),
                new Vector(10.355000, 22.285000, -0.066000));
        addAtom(new Hydrogen(),
                new Vector(10.151000, 19.807000, -4.452000));
        addAtom(new Hydrogen(),
                new Vector(-1.838000, 20.379000, -5.790000));
        addAtom(new Hydrogen(),
                new Vector(-0.817000, 21.775000, -1.766000));
        addAtom(new Hydrogen(),
                new Vector(6.278000, 24.120000, -6.855000));
        addAtom(new Hydrogen(),
                new Vector(-1.009000, 26.024000, -7.859000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(0.877000, 27.292000, -2.457000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(3.363000, 27.467000, -2.373000));
        addAtom(new Hydrogen(),
                new Vector(3.180000, 25.822000, -7.134000));
        addAtom(new Hydrogen(),
                new Vector(1.339000, 23.569000, -7.633000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(2.219000, 26.469000, -2.342000));
        addAtom(new Hydrogen(),
                new Vector(3.339000, 28.070000, -1.437000));
        addAtom(new Hydrogen(),
                new Vector(4.353000, 26.959000, -2.370000));
        addAtom(new Hydrogen(),
                new Vector(0.917000, 28.005000, -1.601000));
        addAtom(new Hydrogen(),
                new Vector(-0.030000, 26.825000, -2.030000));
        addAtom(new Hydrogen(),
                new Vector(2.494000, 24.333000, -2.797000));
        addAtom(new Hydrogen(),
                new Vector(3.618000, 25.293000, -3.634000));
        addAtom(new Hydrogen(),
                new Vector(2.222000, 26.020000, -1.323000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(-1.312000, 19.528000, -3.362000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-2.975000, 20.182000, -1.682000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-4.412000, 19.827000, -1.422000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-2.652000, 19.248000, -2.879000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-4.954000, 20.064000, -2.827000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-3.820000, 19.625000, -3.802000));
        addAtom(new Hydrogen(),
                new Vector(-2.324000, 20.000000, -0.797000));
        addAtom(new Hydrogen(),
                new Vector(-4.901000, 20.460000, -0.650000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(11.720000, 19.482000, -1.608000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(10.372000, 18.797000, -1.984000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(12.622000, 18.465000, -1.150000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(8.622000, 20.191000, -0.129000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(10.900000, 19.805000, 0.760000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(11.886000, 18.730000, 1.216000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(9.533000, 19.167000, 0.348000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(12.111000, 17.767000, 0.013000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(9.780000, 18.095000, -0.771000));
        addAtom(new Hydrogen(),
                new Vector(10.748000, 20.543000, 1.583000));
        addAtom(new Hydrogen(),
                new Vector(12.856000, 19.190000, 1.507000));
        addAtom(new Hydrogen(),
                new Vector(8.820000, 17.605000, -1.055000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-4.483000, 18.388000, -4.426000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(-5.861000, 18.662000, -4.424000));
        addAtom(new Hydrogen(),
                new Vector(-4.084000, 18.103000, -5.422000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(9.937000, 17.347000, 2.130000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(9.023000, 18.418000, 1.586000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(10.220000, 16.420000, 0.983000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(11.282000, 18.010000, 2.448000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-4.307000, 17.327000, -3.330000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-5.375000, 17.752000, -2.311000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(10.782000, 17.028000, -0.290000));
        addAtom(new Hydrogen(),
                new Vector(10.946000, 16.251000, -1.071000));
        addAtom(new Hydrogen(),
                new Vector(11.147000, 18.741000, 3.276000));
        addAtom(new Hydrogen(),
                new Vector(12.018000, 17.261000, 2.808000));
        addAtom(new Hydrogen(),
                new Vector(7.957000, 18.346000, 1.763000));
        addAtom(new Hydrogen(),
                new Vector(7.957000, 18.346000, 1.763000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-6.010000, 18.970000, -3.065000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-4.567000, 18.296000, -1.142000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-2.974000, 17.707000, -2.576000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(-3.314000, 17.629000, -1.208000));
        addAtom(new Hydrogen(),
                new Vector(-7.046000, 19.235000, -2.766000));
        addAtom(new Hydrogen(),
                new Vector(-2.131000, 17.034000, -2.832000));
        addAtom(new Hydrogen(),
                new Vector(9.963000, 15.382000, 0.789000));
        addAtom(new Silicon(Atom.SP3),
                new Vector(-5.776000, 15.314000, -2.797000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(-4.522000, 15.984000, -3.816000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(-6.215000, 16.697000, -1.863000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(9.442000, 16.650000, 3.272000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(10.112000, 15.047000, 1.311000));
        addAtom(new Hydrogen(),
                new Vector(-5.059000, 18.116000, -0.161000));
        addAtom(new Silicon(Atom.SP3),
                new Vector(10.054000, 15.024000, 3.125000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-9.097000, 0.794000, -19.040000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-7.923000, 1.127000, -19.905000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-9.088000, 1.736000, -17.860000));
        addAtom(new Hydrogen(),
                new Vector(-9.417000, 1.677000, -16.828000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-10.369000, 1.163000, -19.816000));
        addAtom(new Silicon(Atom.SP3),
                new Vector(6.570000, -1.015000, -15.155000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(5.827000, 0.412000, -15.699000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(6.878000, -1.928000, -16.570000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(4.775000, 0.619000, -21.573000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(6.166000, 1.396000, -21.395000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(6.134000, 2.277000, -20.153000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(7.157000, 0.432000, -21.017000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(3.412000, 1.809000, -19.273000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(4.414000, -0.202000, -20.283000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(5.588000, -1.085000, -19.908000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(4.408000, 0.787000, -19.095000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(6.641000, 0.001000, -19.740000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(5.886000, 1.225000, -19.149000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(5.745000, 0.214000, -17.080000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(6.453000, -1.054000, -17.602000));
        addAtom(new Hydrogen(),
                new Vector(4.814000, -0.057000, -22.457000));
        addAtom(new Hydrogen(),
                new Vector(7.120000, 2.771000, -19.984000));
        addAtom(new Hydrogen(),
                new Vector(3.463000, -0.770000, -20.387000));
        addAtom(new Hydrogen(),
                new Vector(5.851000, -1.839000, -20.682000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-9.120000, 4.356000, -21.508000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-9.039000, 5.253000, -20.232000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-7.771000, 4.892000, -19.400000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(-10.196000, 4.997000, -19.427000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(-6.661000, 2.840000, -21.139000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-9.138000, 2.894000, -21.120000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-10.369000, 2.653000, -20.243000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-7.826000, 2.577000, -20.328000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-10.267000, 3.612000, -19.021000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-7.789000, 3.436000, -19.016000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-9.040000, 3.206000, -18.166000));
        addAtom(new Hydrogen(),
                new Vector(-10.036000, 4.602000, -22.094000));
        addAtom(new Hydrogen(),
                new Vector(-9.201000, 2.261000, -22.036000));
        addAtom(new Hydrogen(),
                new Vector(-11.300000, 2.871000, -20.810000));
        addAtom(new Hydrogen(),
                new Vector(-6.879000, 3.195000, -18.417000));
        addAtom(new Hydrogen(),
                new Vector(-8.998000, 3.818000, -17.236000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(-9.125000, -0.569000, -18.669000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(-9.605000, 1.151000, -16.685000));
        addAtom(new Hydrogen(),
                new Vector(-10.456000, 0.518000, -20.719000));
        addAtom(new Hydrogen(),
                new Vector(-11.277000, 0.972000, -19.202000));
        addAtom(new Hydrogen(),
                new Vector(-7.498000, 0.360000, -20.540000));
        addAtom(new Hydrogen(),
                new Vector(-7.498000, 0.360000, -20.540000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(7.515000, -0.401000, -18.542000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(5.393000, -1.709000, -18.482000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(4.328000, 0.081000, -17.698000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(6.501000, 1.313000, -17.789000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(4.153000, -1.304000, -17.926000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(7.814000, 0.822000, -17.929000));
        addAtom(new Hydrogen(),
                new Vector(8.402000, -1.025000, -18.780000));
        addAtom(new Hydrogen(),
                new Vector(6.442000, 2.317000, -17.315000));
        addAtom(new Hydrogen(),
                new Vector(5.480000, -2.817000, -18.504000));
        addAtom(new Hydrogen(),
                new Vector(3.531000, 0.496000, -17.045000));
        addAtom(new Silicon(Atom.SP3),
                new Vector(0.057000, 17.470000, -24.703000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(0.250000, 11.985000, -28.229000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-0.871000, 12.167000, -29.174000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(-0.945000, 11.074000, -30.126000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-1.265000, 10.691000, -26.625000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-1.009000, 11.739000, -25.452000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(0.061000, 10.709000, -27.530000));
        addAtom(new Silicon(Atom.SP3),
                new Vector(-0.837000, 13.411000, -26.201000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-2.504000, 10.987000, -27.573000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-2.468000, 9.834000, -28.674000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-2.234000, 12.308000, -28.323000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-0.023000, 9.686000, -28.558000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-1.111000, 9.820000, -29.483000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-2.113000, 13.510000, -27.421000));
        addAtom(new Silicon(Atom.SP3),
                new Vector(-3.496000, 13.713000, -26.020000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-2.806000, 9.144000, -25.155000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-2.634000, 10.041000, -23.868000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-1.504000, 9.254000, -26.001000));
        addAtom(new Silicon(Atom.SP3),
                new Vector(-2.381000, 11.799000, -24.227000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-4.059000, 9.527000, -26.113000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-3.917000, 10.989000, -26.782000));
        addAtom(new Silicon(Atom.SP3),
                new Vector(-4.069000, 12.004000, -25.287000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(-5.369000, 11.607000, -24.225000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-4.118000, 7.535000, -23.928000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-4.035000, 8.429000, -22.651000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(-2.946000, 7.763000, -24.728000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-3.950000, 9.891000, -23.048000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-5.397000, 7.901000, -24.754000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-5.335000, 9.349000, -25.208000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-5.288000, 10.228000, -23.880000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(-6.452000, 9.947000, -23.051000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-5.364000, 5.883000, -22.719000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-5.295000, 6.767000, -21.432000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(-4.195000, 6.145000, -23.529000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-5.268000, 8.226000, -21.814000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-6.642000, 6.246000, -23.542000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-6.619000, 7.703000, -23.914000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-6.538000, 8.574000, -22.639000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(-7.716000, 8.319000, -21.824000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(2.767000, 8.042000, -24.939000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(3.865000, 7.880000, -24.000000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(2.436000, 6.644000, -25.667000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(0.013000, 6.389000, -28.893000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(4.379000, 8.741000, -26.651000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(5.496000, 8.479000, -25.767000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(3.161000, 9.172000, -25.889000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(5.088000, 7.420000, -24.758000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(4.098000, 7.468000, -27.394000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(1.726000, 7.166000, -30.282000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(3.703000, 6.226000, -26.413000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(0.815000, 8.533000, -28.634000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(0.517000, 7.516000, -29.591000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(4.841000, 6.052000, -25.334000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(2.059000, 6.212000, -23.102000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(2.148000, 5.511000, -24.523000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(3.435000, 6.996000, -22.882000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(2.862000, 4.373000, -21.802000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(2.970000, 3.530000, -23.084000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(1.806000, 5.311000, -22.001000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(3.295000, 4.464000, -24.256000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(4.193000, 5.110000, -21.558000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(4.513000, 5.968000, -22.715000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(4.626000, 5.145000, -24.079000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(5.670000, 4.121000, -23.902000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(3.654000, 2.574000, -20.457000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(3.707000, 1.658000, -21.729000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(2.601000, 3.540000, -20.655000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(4.065000, 2.508000, -22.944000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(5.019000, 3.287000, -20.249000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(5.331000, 4.128000, -21.450000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(5.424000, 3.243000, -22.744000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(6.462000, 2.226000, -22.559000));
        addAtom(new Hydrogen(),
                new Vector(1.203000, 6.918000, -23.097000));
        addAtom(new Hydrogen(),
                new Vector(6.389000, 8.148000, -26.344000));
        addAtom(new Hydrogen(),
                new Vector(5.010000, 7.179000, -27.966000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-1.269000, 9.726000, -23.154000));
        addAtom(new Hydrogen(),
                new Vector(-3.161000, 8.140000, -22.031000));
        addAtom(new Hydrogen(),
                new Vector(-3.904000, 10.526000, -22.133000));
        addAtom(new Hydrogen(),
                new Vector(-5.547000, 7.215000, -25.605000));
        addAtom(new Hydrogen(),
                new Vector(-6.243000, 9.605000, -25.799000));
        addAtom(new Hydrogen(),
                new Vector(-4.390000, 6.506000, -20.835000));
        addAtom(new Hydrogen(),
                new Vector(-5.216000, 8.862000, -20.900000));
        addAtom(new Hydrogen(),
                new Vector(-6.699000, 5.613000, -24.460000));
        addAtom(new Hydrogen(),
                new Vector(-7.531000, 7.967000, -24.500000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(0.912000, 4.707000, -24.949000));
        addAtom(new Hydrogen(),
                new Vector(2.039000, 2.957000, -23.245000));
        addAtom(new Hydrogen(),
                new Vector(3.562000, 3.805000, -25.015000));
        addAtom(new Hydrogen(),
                new Vector(5.460000, 6.468000, -22.415000));
        addAtom(new Hydrogen(),
                new Vector(4.109000, 1.867000, -23.854000));
        addAtom(new Hydrogen(),
                new Vector(6.294000, 4.664000, -21.284000));
        addAtom(new Hydrogen(),
                new Vector(-2.539000, 16.675000, -25.324000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(-0.808000, 18.009000, -26.189000));
        addAtom(new Hydrogen(),
                new Vector(1.054000, 16.113000, -26.671000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(-0.187000, 15.688000, -24.597000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-2.119000, 16.124000, -26.198000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-0.810000, 15.223000, -25.805000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(0.056000, 15.725000, -26.947000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-1.081000, 16.848000, -26.989000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-1.973000, 14.613000, -28.652000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-3.279000, 15.801000, -27.196000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(-1.607000, 17.036000, -28.264000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-3.395000, 12.835000, -29.190000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(3.286000, 4.990000, -27.448000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-5.041000, 11.761000, -27.676000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-4.038000, 8.502000, -27.288000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-2.674000, 8.513000, -27.953000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-4.590000, 13.256000, -28.256000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-4.288000, 14.561000, -27.156000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-0.566000, 13.456000, -29.988000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-1.754000, 13.698000, -30.883000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(0.504000, 13.121000, -27.272000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(0.415000, 14.565000, -27.988000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(-0.575000, 14.623000, -29.104000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-2.800000, 14.046000, -29.836000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-2.577000, 15.995000, -28.413000));
        addAtom(new Hydrogen(),
                new Vector(-5.254000, 14.897000, -26.728000));
        addAtom(new Hydrogen(),
                new Vector(-3.301000, 16.363000, -29.171000));
        addAtom(new Hydrogen(),
                new Vector(1.415000, 14.777000, -28.424000));
        addAtom(new Hydrogen(),
                new Vector(0.383000, 13.386000, -30.564000));
        addAtom(new Hydrogen(),
                new Vector(-5.414000, 13.603000, -28.916000));
        addAtom(new Hydrogen(),
                new Vector(-3.601000, 14.655000, -30.314000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-7.889000, 4.577000, -22.346000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-7.871000, 6.036000, -22.713000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-6.528000, 6.557000, -20.601000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-6.544000, 5.103000, -20.237000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(-5.434000, 4.492000, -22.333000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-6.605000, 4.225000, -21.526000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(-7.800000, 6.921000, -21.429000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(-8.972000, 6.651000, -20.622000));
        addAtom(new Hydrogen(),
                new Vector(-8.782000, 6.290000, -23.305000));
        addAtom(new Hydrogen(),
                new Vector(-7.941000, 3.948000, -23.267000));
        addAtom(new Hydrogen(),
                new Vector(-6.478000, 7.177000, -19.675000));
        addAtom(new Hydrogen(),
                new Vector(4.996000, 3.912000, -19.325000));
        addAtom(new Hydrogen(),
                new Vector(2.724000, 1.156000, -21.881000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(1.624000, 12.798000, -26.377000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(0.272000, 11.315000, -24.714000));
        addAtom(new Hydrogen(),
                new Vector(-3.348000, 14.517000, -24.790000));
        addAtom(new Silicon(Atom.SP3),
                new Vector(-9.859000, -0.597000, -17.114000));
        addAtom(new Hydrogen(),
                new Vector(-6.015000, 11.858000, -27.143000));
        addAtom(new Hydrogen(),
                new Vector(-4.139000, 7.446000, -26.993000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(1.806000, 8.161000, -27.647000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(2.089000, 9.315000, -26.816000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(1.272000, 10.499000, -26.754000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(1.525000, 11.465000, -25.729000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(2.750000, 6.733000, -29.346000));
        addAtom(new Nitrogen(Atom.SP3),
                new Vector(3.037000, 7.799000, -28.372000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(0.943000, 5.872000, -27.914000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(1.303000, 6.947000, -26.802000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(2.291000, 5.496000, -28.579000));
        addAtom(new Carbon(Atom.SP2),
                new Vector(-0.088000, 9.849000, -24.171000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(-0.364000, 8.922000, -25.208000));
        addAtom(new Oxygen(Atom.SP3),
                new Vector(-1.627000, 8.255000, -27.017000));
        addAtom(new Hydrogen(),
                new Vector(-1.243000, 8.680000, -22.792000));
        addAtom(new Hydrogen(),
                new Vector(-3.722000, 12.112000, -29.969000));
        addAtom(new Hydrogen(),
                new Vector(-5.289000, 11.108000, -28.539000));
        addAtom(new Hydrogen(),
                new Vector(-3.292000, 9.965000, -29.406000));
        addAtom(new Hydrogen(),
                new Vector(-4.848000, 8.721000, -28.018000));
        addAtom(new Hydrogen(),
                new Vector(-2.672000, 7.693000, -28.703000));
        addAtom(new Hydrogen(),
                new Vector(5.997000, 7.407000, -24.123000));
        addAtom(new Hydrogen(),
                new Vector(4.221000, 4.652000, -27.942000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(2.493000, 3.685000, -26.991000));
        addAtom(new Hydrogen(),
                new Vector(3.673000, 6.495000, -29.919000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(0.232000, 4.633000, -27.361000));
        addAtom(new Hydrogen(),
                new Vector(2.125000, 4.712000, -29.354000));
        addAtom(new Hydrogen(),
                new Vector(-1.561000, 14.576000, -31.538000));
        addAtom(new Hydrogen(),
                new Vector(-2.033000, 12.828000, -31.518000));
        addAtom(new Hydrogen(),
                new Vector(5.781000, 9.418000, -25.241000));
        addAtom(new Hydrogen(),
                new Vector(1.893000, 8.412000, -24.393000));
        addAtom(new Hydrogen(),
                new Vector(0.367000, 7.152000, -26.296000));
        addAtom(new Hydrogen(),
                new Vector(3.352000, 7.614000, -21.959000));
        addAtom(new Sulfur(Atom.SP3),
                new Vector(-0.808000, 8.351000, -30.637000));
        addAtom(new Hydrogen(),
                new Vector(-1.090000, 10.369000, -22.262000));
        addAtom(new Hydrogen(),
                new Vector(0.463000, 11.982000, -23.845000));
        addAtom(new Hydrogen(),
                new Vector(-2.201000, 12.679000, -23.063000));
        addAtom(new Carbon(Atom.SP3),
                new Vector(1.080000, 3.936000, -26.320000));
        addAtom(new Hydrogen(),
                new Vector(0.031000, 3.928000, -28.199000));
        addAtom(new Hydrogen(),
                new Vector(-0.770000, 4.907000, -26.960000));
        addAtom(new Hydrogen(),
                new Vector(2.267000, 3.105000, -27.915000));
        addAtom(new Hydrogen(),
                new Vector(3.087000, 2.836000, -26.598000));
        addAtom(new Hydrogen(),
                new Vector(0.558000, 4.009000, -24.173000));
        centerAtoms();
        addBond(0, 942);
        addBond(1, 943);
        addBond(2, 944);
        addBond(3, 922);
        addBond(4, 509);
        addBond(5, 180);
        addBond(5, 521);
        addBond(6, 181);
        addBond(6, 560);
        addBond(6, 521);
        addBond(7, 949);
        addBond(8, 2051);
        addBond(8, 1867);
        addBond(9, 2064);
        addBond(9, 2121);
        addBond(9, 17);
        addBond(9, 27);
        addBond(10, 951);
        addBond(11, 276);
        addBond(12, 954);
        addBond(13, 923);
        addBond(13, 1044);
        addBond(13, 948);
        addBond(14, 959);
        addBond(15, 914);
        addBond(15, 936);
        addBond(15, 1141);
        addBond(15, 1017);
        addBond(16, 2079);
        addBond(16, 2120);
        addBond(16, 28);
        addBond(17, 165);
        addBond(18, 1136);
        addBond(19, 963);
        addBond(20, 1094);
        addBond(20, 1076);
        addBond(21, 2120);
        addBond(22, 964);
        addBond(23, 965);
        addBond(24, 2121);
        addBond(25, 177);
        addBond(25, 76);
        addBond(28, 2053);
        addBond(28, 30);
        addBond(29, 2059);
        addBond(29, 78);
        addBond(30, 251);
        addBond(30, 33);
        addBond(30, 49);
        addBond(31, 148);
        addBond(32, 34);
        addBond(32, 369);
        addBond(33, 246);
        addBond(33, 36);
        addBond(34, 2062);
        addBond(34, 37);
        addBond(35, 38);
        addBond(35, 887);
        addBond(36, 79);
        addBond(36, 2063);
        addBond(37, 247);
        addBond(37, 39);
        addBond(38, 41);
        addBond(38, 288);
        addBond(39, 81);
        addBond(39, 2064);
        addBond(39, 82);
        addBond(40, 262);
        addBond(40, 44);
        addBond(41, 504);
        addBond(42, 83);
        addBond(42, 2072);
        addBond(43, 45);
        addBond(43, 323);
        addBond(44, 253);
        addBond(44, 46);
        addBond(45, 48);
        addBond(45, 776);
        addBond(46, 83);
        addBond(46, 2078);
        addBond(46, 69);
        addBond(47, 259);
        addBond(47, 49);
        addBond(48, 354);
        addBond(49, 162);
        addBond(49, 1010);
        addBond(49, 1084);
        addBond(50, 526);
        addBond(50, 530);
        addBond(50, 183);
        addBond(51, 2050);
        addBond(51, 605);
        addBond(52, 2079);
        addBond(52, 84);
        addBond(52, 85);
        addBond(53, 56);
        addBond(54, 56);
        addBond(54, 59);
        addBond(55, 105);
        addBond(55, 480);
        addBond(56, 912);
        addBond(56, 1056);
        addBond(57, 59);
        addBond(57, 64);
        addBond(58, 103);
        addBond(58, 677);
        addBond(59, 67);
        addBond(59, 68);
        addBond(59, 254);
        addBond(60, 764);
        addBond(60, 771);
        addBond(60, 775);
        addBond(61, 86);
        addBond(61, 2082);
        addBond(62, 64);
        addBond(62, 95);
        addBond(63, 100);
        addBond(63, 909);
        addBond(64, 754);
        addBond(64, 764);
        addBond(64, 785);
        addBond(65, 71);
        addBond(65, 86);
        addBond(65, 2085);
        addBond(66, 202);
        addBond(66, 759);
        addBond(67, 754);
        addBond(67, 784);
        addBond(68, 87);
        addBond(68, 2088);
        addBond(69, 526);
        addBond(69, 310);
        addBond(70, 88);
        addBond(70, 2090);
        addBond(71, 1868);
        addBond(71, 2051);
        addBond(72, 637);
        addBond(72, 93);
        addBond(72, 1879);
        addBond(73, 1925);
        addBond(73, 1879);
        addBond(74, 530);
        addBond(74, 80);
        addBond(74, 371);
        addBond(74, 554);
        addBond(75, 1824);
        addBond(75, 1938);
        addBond(76, 552);
        addBond(76, 559);
        addBond(76, 567);
        addBond(77, 97);
        addBond(78, 98);
        addBond(79, 560);
        addBond(79, 576);
        addBond(79, 581);
        addBond(80, 98);
        addBond(80, 101);
        addBond(81, 85);
        addBond(81, 106);
        addBond(81, 116);
        addBond(82, 118);
        addBond(83, 97);
        addBond(83, 123);
        addBond(84, 130);
        addBond(84, 133);
        addBond(85, 136);
        addBond(86, 138);
        addBond(86, 146);
        addBond(87, 166);
        addBond(87, 174);
        addBond(88, 1919);
        addBond(88, 1876);
        addBond(89, 1853);
        addBond(89, 1919);
        addBond(90, 590);
        addBond(90, 583);
        addBond(90, 594);
        addBond(91, 567);
        addBond(91, 608);
        addBond(91, 598);
        addBond(92, 1876);
        addBond(93, 869);
        addBond(93, 1924);
        addBond(93, 579);
        addBond(94, 96);
        addBond(94, 109);
        addBond(94, 377);
        addBond(95, 99);
        addBond(95, 111);
        addBond(96, 175);
        addBond(97, 182);
        addBond(98, 512);
        addBond(98, 100);
        addBond(98, 125);
        addBond(99, 102);
        addBond(100, 184);
        addBond(100, 106);
        addBond(101, 103);
        addBond(101, 122);
        addBond(101, 314);
        addBond(102, 104);
        addBond(103, 105);
        addBond(103, 119);
        addBond(103, 810);
        addBond(104, 107);
        addBond(105, 130);
        addBond(105, 198);
        addBond(106, 108);
        addBond(106, 114);
        addBond(106, 185);
        addBond(109, 111);
        addBond(110, 129);
        addBond(110, 562);
        addBond(111, 113);
        addBond(112, 114);
        addBond(112, 137);
        addBond(112, 197);
        addBond(113, 117);
        addBond(114, 629);
        addBond(114, 612);
        addBond(114, 601);
        addBond(116, 119);
        addBond(116, 140);
        addBond(116, 803);
        addBond(117, 226);
        addBond(118, 120);
        addBond(119, 122);
        addBond(119, 145);
        addBond(119, 320);
        addBond(120, 2040);
        addBond(120, 1995);
        addBond(120, 1867);
        addBond(121, 124);
        addBond(122, 235);
        addBond(122, 130);
        addBond(123, 125);
        addBond(123, 148);
        addBond(123, 891);
        addBond(124, 128);
        addBond(125, 1930);
        addBond(125, 1822);
        addBond(125, 841);
        addBond(126, 956);
        addBond(126, 998);
        addBond(127, 129);
        addBond(127, 150);
        addBond(127, 911);
        addBond(128, 132);
        addBond(129, 237);
        addBond(130, 132);
        addBond(131, 153);
        addBond(131, 773);
        addBond(133, 135);
        addBond(134, 137);
        addBond(134, 216);
        addBond(134, 452);
        addBond(135, 238);
        addBond(136, 139);
        addBond(137, 226);
        addBond(137, 242);
        addBond(138, 140);
        addBond(138, 234);
        addBond(138, 497);
        addBond(139, 141);
        addBond(140, 145);
        addBond(140, 252);
        addBond(140, 494);
        addBond(141, 632);
        addBond(142, 144);
        addBond(142, 763);
        addBond(142, 771);
        addBond(143, 201);
        addBond(143, 268);
        addBond(144, 859);
        addBond(144, 147);
        addBond(145, 279);
        addBond(145, 174);
        addBond(145, 294);
        addBond(146, 148);
        addBond(146, 274);
        addBond(146, 291);
        addBond(147, 152);
        addBond(148, 712);
        addBond(148, 1918);
        addBond(149, 152);
        addBond(149, 154);
        addBond(150, 590);
        addBond(150, 668);
        addBond(150, 607);
        addBond(151, 282);
        addBond(151, 908);
        addBond(152, 154);
        addBond(152, 155);
        addBond(153, 510);
        addBond(153, 287);
        addBond(154, 156);
        addBond(154, 290);
        addBond(154, 910);
        addBond(156, 1063);
        addBond(157, 159);
        addBond(157, 200);
        addBond(158, 161);
        addBond(158, 506);
        addBond(158, 895);
        addBond(159, 918);
        addBond(159, 941);
        addBond(159, 1149);
        addBond(159, 991);
        addBond(160, 163);
        addBond(160, 228);
        addBond(161, 914);
        addBond(161, 991);
        addBond(162, 164);
        addBond(162, 495);
        addBond(162, 856);
        addBond(163, 167);
        addBond(163, 245);
        addBond(164, 1063);
        addBond(164, 1064);
        addBond(164, 1135);
        addBond(165, 308);
        addBond(165, 238);
        addBond(166, 169);
        addBond(166, 273);
        addBond(166, 484);
        addBond(167, 273);
        addBond(167, 546);
        addBond(167, 674);
        addBond(168, 755);
        addBond(168, 171);
        addBond(168, 271);
        addBond(169, 377);
        addBond(169, 909);
        addBond(170, 186);
        addBond(170, 230);
        addBond(170, 469);
        addBond(171, 1070);
        addBond(171, 870);
        addBond(171, 2049);
        addBond(171, 2048);
        addBond(172, 1863);
        addBond(172, 1854);
        addBond(173, 309);
        addBond(173, 313);
        addBond(174, 315);
        addBond(175, 178);
        addBond(175, 647);
        addBond(176, 933);
        addBond(176, 1820);
        addBond(176, 1877);
        addBond(177, 679);
        addBond(177, 1870);
        addBond(178, 687);
        addBond(179, 615);
        addBond(179, 620);
        addBond(180, 623);
        addBond(180, 576);
        addBond(181, 335);
        addBond(182, 626);
        addBond(182, 371);
        addBond(183, 343);
        addBond(183, 356);
        addBond(184, 790);
        addBond(184, 831);
        addBond(184, 867);
        addBond(185, 265);
        addBond(185, 189);
        addBond(185, 277);
        addBond(186, 190);
        addBond(186, 200);
        addBond(186, 278);
        addBond(186, 283);
        addBond(187, 361);
        addBond(187, 384);
        addBond(187, 386);
        addBond(188, 191);
        addBond(188, 267);
        addBond(188, 447);
        addBond(189, 452);
        addBond(189, 847);
        addBond(190, 193);
        addBond(190, 280);
        addBond(191, 510);
        addBond(191, 908);
        addBond(191, 911);
        addBond(192, 196);
        addBond(192, 543);
        addBond(192, 877);
        addBond(193, 260);
        addBond(193, 220);
        addBond(193, 280);
        addBond(193, 887);
        addBond(194, 196);
        addBond(194, 297);
        addBond(194, 311);
        addBond(194, 863);
        addBond(195, 286);
        addBond(196, 275);
        addBond(196, 281);
        addBond(196, 867);
        addBond(198, 200);
        addBond(199, 216);
        addBond(200, 202);
        addBond(200, 769);
        addBond(201, 248);
        addBond(202, 204);
        addBond(202, 214);
        addBond(202, 218);
        addBond(203, 205);
        addBond(203, 631);
        addBond(204, 206);
        addBond(204, 221);
        addBond(205, 207);
        addBond(205, 634);
        addBond(206, 208);
        addBond(206, 223);
        addBond(207, 209);
        addBond(207, 660);
        addBond(208, 210);
        addBond(208, 225);
        addBond(209, 211);
        addBond(209, 709);
        addBond(210, 212);
        addBond(210, 229);
        addBond(211, 213);
        addBond(211, 704);
        addBond(212, 214);
        addBond(212, 233);
        addBond(213, 652);
        addBond(214, 927);
        addBond(215, 228);
        addBond(216, 218);
        addBond(216, 233);
        addBond(216, 295);
        addBond(217, 219);
        addBond(218, 221);
        addBond(218, 299);
        addBond(219, 267);
        addBond(219, 877);
        addBond(220, 222);
        addBond(221, 223);
        addBond(221, 386);
        addBond(222, 224);
        addBond(223, 225);
        addBond(223, 384);
        addBond(224, 227);
        addBond(225, 393);
        addBond(226, 229);
        addBond(226, 379);
        addBond(227, 234);
        addBond(227, 847);
        addBond(228, 232);
        addBond(229, 300);
        addBond(229, 354);
        addBond(229, 369);
        addBond(230, 918);
        addBond(230, 1039);
        addBond(230, 977);
        addBond(231, 233);
        addBond(231, 269);
        addBond(233, 245);
        addBond(234, 396);
        addBond(234, 399);
        addBond(235, 377);
        addBond(237, 403);
        addBond(238, 240);
        addBond(238, 306);
        addBond(238, 748);
        addBond(239, 241);
        addBond(239, 332);
        addBond(240, 249);
        addBond(240, 750);
        addBond(241, 405);
        addBond(241, 279);
        addBond(242, 244);
        addBond(242, 249);
        addBond(242, 791);
        addBond(243, 255);
        addBond(243, 348);
        addBond(244, 252);
        addBond(244, 385);
        addBond(245, 248);
        addBond(245, 268);
        addBond(246, 266);
        addBond(246, 268);
        addBond(247, 251);
        addBond(248, 336);
        addBond(249, 480);
        addBond(249, 677);
        addBond(250, 254);
        addBond(251, 903);
        addBond(251, 271);
        addBond(252, 256);
        addBond(252, 263);
        addBond(253, 259);
        addBond(254, 258);
        addBond(254, 857);
        addBond(255, 259);
        addBond(255, 754);
        addBond(256, 267);
        addBond(256, 316);
        addBond(256, 836);
        addBond(257, 789);
        addBond(257, 902);
        addBond(259, 510);
        addBond(259, 907);
        addBond(260, 274);
        addBond(261, 263);
        addBond(261, 266);
        addBond(262, 764);
        addBond(263, 453);
        addBond(265, 771);
        addBond(266, 369);
        addBond(268, 296);
        addBond(268, 374);
        addBond(269, 924);
        addBond(270, 274);
        addBond(270, 358);
        addBond(271, 480);
        addBond(272, 354);
        addBond(272, 444);
        addBond(273, 277);
        addBond(275, 923);
        addBond(275, 951);
        addBond(275, 962);
        addBond(276, 282);
        addBond(276, 449);
        addBond(278, 309);
        addBond(278, 408);
        addBond(279, 282);
        addBond(279, 287);
        addBond(280, 452);
        addBond(280, 497);
        addBond(281, 904);
        addBond(282, 895);
        addBond(283, 847);
        addBond(283, 856);
        addBond(283, 895);
        addBond(284, 920);
        addBond(284, 1033);
        addBond(284, 962);
        addBond(285, 287);
        addBond(285, 290);
        addBond(285, 907);
        addBond(287, 291);
        addBond(287, 891);
        addBond(287, 908);
        addBond(288, 919);
        addBond(288, 947);
        addBond(289, 293);
        addBond(290, 323);
        addBond(290, 804);
        addBond(291, 1929);
        addBond(291, 1870);
        addBond(292, 297);
        addBond(292, 569);
        addBond(292, 896);
        addBond(294, 296);
        addBond(294, 301);
        addBond(295, 373);
        addBond(297, 316);
        addBond(297, 681);
        addBond(297, 774);
        addBond(298, 301);
        addBond(298, 387);
        addBond(299, 316);
        addBond(299, 674);
        addBond(300, 366);
        addBond(301, 473);
        addBond(302, 476);
        addBond(303, 306);
        addBond(303, 768);
        addBond(303, 780);
        addBond(304, 307);
        addBond(304, 535);
        addBond(305, 376);
        addBond(306, 311);
        addBond(306, 543);
        addBond(306, 818);
        addBond(307, 410);
        addBond(307, 309);
        addBond(308, 415);
        addBond(309, 635);
        addBond(309, 640);
        addBond(311, 345);
        addBond(311, 1863);
        addBond(313, 342);
        addBond(313, 815);
        addBond(313, 905);
        addBond(314, 396);
        addBond(314, 416);
        addBond(315, 454);
        addBond(316, 318);
        addBond(317, 319);
        addBond(317, 331);
        addBond(317, 806);
        addBond(318, 499);
        addBond(319, 323);
        addBond(319, 792);
        addBond(319, 905);
        addBond(320, 322);
        addBond(321, 331);
        addBond(321, 352);
        addBond(321, 799);
        addBond(322, 494);
        addBond(323, 325);
        addBond(323, 330);
        addBond(323, 780);
        addBond(324, 341);
        addBond(324, 902);
        addBond(325, 336);
        addBond(325, 344);
        addBond(325, 348);
        addBond(326, 332);
        addBond(326, 349);
        addBond(326, 376);
        addBond(327, 332);
        addBond(327, 336);
        addBond(327, 351);
        addBond(328, 349);
        addBond(328, 351);
        addBond(328, 368);
        addBond(329, 334);
        addBond(329, 376);
        addBond(330, 490);
        addBond(332, 334);
        addBond(332, 349);
        addBond(332, 378);
        addBond(333, 339);
        addBond(334, 420);
        addBond(334, 343);
        addBond(336, 338);
        addBond(337, 352);
        addBond(337, 372);
        addBond(337, 774);
        addBond(338, 341);
        addBond(338, 355);
        addBond(339, 344);
        addBond(339, 363);
        addBond(339, 370);
        addBond(340, 353);
        addBond(341, 512);
        addBond(341, 909);
        addBond(342, 422);
        addBond(343, 346);
        addBond(344, 1873);
        addBond(344, 1871);
        addBond(345, 351);
        addBond(345, 365);
        addBond(346, 935);
        addBond(346, 973);
        addBond(346, 990);
        addBond(347, 901);
        addBond(349, 355);
        addBond(349, 374);
        addBond(349, 378);
        addBond(351, 477);
        addBond(352, 359);
        addBond(352, 370);
        addBond(353, 358);
        addBond(354, 357);
        addBond(355, 399);
        addBond(355, 425);
        addBond(355, 428);
        addBond(356, 359);
        addBond(356, 381);
        addBond(357, 776);
        addBond(357, 804);
        addBond(358, 361);
        addBond(359, 362);
        addBond(360, 363);
        addBond(361, 372);
        addBond(361, 383);
        addBond(361, 681);
        addBond(362, 382);
        addBond(363, 710);
        addBond(363, 1872);
        addBond(364, 366);
        addBond(364, 382);
        addBond(365, 368);
        addBond(366, 496);
        addBond(367, 373);
        addBond(368, 449);
        addBond(369, 901);
        addBond(370, 576);
        addBond(370, 642);
        addBond(371, 454);
        addBond(372, 378);
        addBond(373, 379);
        addBond(374, 500);
        addBond(376, 603);
        addBond(378, 381);
        addBond(379, 896);
        addBond(380, 384);
        addBond(381, 387);
        addBond(382, 442);
        addBond(382, 535);
        addBond(384, 444);
        addBond(384, 776);
        addBond(384, 819);
        addBond(385, 387);
        addBond(387, 390);
        addBond(388, 390);
        addBond(388, 392);
        addBond(389, 407);
        addBond(389, 728);
        addBond(390, 392);
        addBond(390, 395);
        addBond(391, 404);
        addBond(391, 689);
        addBond(392, 430);
        addBond(393, 395);
        addBond(393, 397);
        addBond(394, 401);
        addBond(394, 717);
        addBond(395, 436);
        addBond(396, 398);
        addBond(396, 412);
        addBond(396, 669);
        addBond(397, 400);
        addBond(397, 414);
        addBond(398, 440);
        addBond(398, 445);
        addBond(399, 401);
        addBond(399, 429);
        addBond(399, 667);
        addBond(400, 402);
        addBond(401, 404);
        addBond(401, 426);
        addBond(401, 714);
        addBond(402, 450);
        addBond(403, 406);
        addBond(404, 457);
        addBond(404, 461);
        addBond(405, 407);
        addBond(405, 423);
        addBond(405, 685);
        addBond(406, 409);
        addBond(408, 411);
        addBond(408, 419);
        addBond(408, 731);
        addBond(409, 505);
        addBond(409, 509);
        addBond(412, 414);
        addBond(413, 432);
        addBond(413, 644);
        addBond(415, 521);
        addBond(416, 418);
        addBond(417, 419);
        addBond(417, 439);
        addBond(417, 735);
        addBond(418, 421);
        addBond(419, 526);
        addBond(420, 423);
        addBond(420, 443);
        addBond(420, 683);
        addBond(421, 530);
        addBond(421, 425);
        addBond(422, 424);
        addBond(423, 426);
        addBond(423, 448);
        addBond(423, 711);
        addBond(424, 440);
        addBond(424, 548);
        addBond(425, 427);
        addBond(426, 429);
        addBond(426, 453);
        addBond(426, 663);
        addBond(428, 431);
        addBond(429, 552);
        addBond(429, 457);
        addBond(430, 432);
        addBond(430, 455);
        addBond(430, 639);
        addBond(431, 435);
        addBond(432, 2462);
        addBond(432, 2560);
        addBond(433, 435);
        addBond(434, 459);
        addBond(434, 622);
        addBond(435, 560);
        addBond(435, 440);
        addBond(436, 438);
        addBond(437, 439);
        addBond(437, 488);
        addBond(437, 739);
        addBond(438, 441);
        addBond(439, 577);
        addBond(440, 443);
        addBond(440, 491);
        addBond(440, 680);
        addBond(441, 447);
        addBond(441, 543);
        addBond(441, 836);
        addBond(442, 446);
        addBond(443, 856);
        addBond(445, 448);
        addBond(445, 496);
        addBond(445, 707);
        addBond(446, 454);
        addBond(447, 451);
        addBond(447, 772);
        addBond(448, 804);
        addBond(448, 887);
        addBond(449, 583);
        addBond(449, 505);
        addBond(450, 453);
        addBond(450, 500);
        addBond(450, 659);
        addBond(451, 538);
        addBond(452, 456);
        addBond(453, 469);
        addBond(454, 456);
        addBond(454, 460);
        addBond(455, 504);
        addBond(455, 636);
        addBond(456, 608);
        addBond(457, 546);
        addBond(457, 799);
        addBond(457, 806);
        addBond(458, 460);
        addBond(458, 462);
        addBond(459, 508);
        addBond(459, 602);
        addBond(460, 632);
        addBond(460, 509);
        addBond(460, 665);
        addBond(461, 463);
        addBond(461, 511);
        addBond(461, 599);
        addBond(463, 465);
        addBond(463, 486);
        addBond(464, 466);
        addBond(464, 553);
        addBond(464, 673);
        addBond(465, 468);
        addBond(465, 489);
        addBond(466, 910);
        addBond(467, 470);
        addBond(467, 549);
        addBond(467, 697);
        addBond(468, 477);
        addBond(469, 472);
        addBond(469, 493);
        addBond(470, 773);
        addBond(471, 473);
        addBond(471, 545);
        addBond(471, 651);
        addBond(472, 475);
        addBond(472, 498);
        addBond(473, 562);
        addBond(473, 773);
        addBond(473, 911);
        addBond(474, 476);
        addBond(474, 542);
        addBond(474, 628);
        addBond(475, 478);
        addBond(475, 501);
        addBond(476, 484);
        addBond(476, 674);
        addBond(477, 479);
        addBond(477, 539);
        addBond(477, 610);
        addBond(478, 481);
        addBond(478, 503);
        addBond(479, 831);
        addBond(480, 483);
        addBond(480, 558);
        addBond(480, 591);
        addBond(481, 483);
        addBond(481, 514);
        addBond(481, 518);
        addBond(481, 588);
        addBond(482, 507);
        addBond(483, 490);
        addBond(484, 486);
        addBond(485, 488);
        addBond(485, 742);
        addBond(486, 492);
        addBond(486, 806);
        addBond(487, 489);
        addBond(488, 491);
        addBond(488, 676);
        addBond(489, 495);
        addBond(489, 546);
        addBond(490, 493);
        addBond(491, 499);
        addBond(491, 592);
        addBond(491, 880);
        addBond(492, 496);
        addBond(492, 702);
        addBond(493, 740);
        addBond(493, 776);
        addBond(494, 499);
        addBond(495, 498);
        addBond(496, 740);
        addBond(496, 819);
        addBond(497, 500);
        addBond(497, 655);
        addBond(498, 506);
        addBond(499, 501);
        addBond(500, 504);
        addBond(500, 633);
        addBond(501, 1136);
        addBond(501, 989);
        addBond(501, 1064);
        addBond(502, 504);
        addBond(502, 508);
        addBond(502, 606);
        addBond(504, 668);
        addBond(506, 508);
        addBond(506, 511);
        addBond(506, 597);
        addBond(508, 687);
        addBond(509, 913);
        addBond(510, 513);
        addBond(511, 603);
        addBond(511, 874);
        addBond(512, 514);
        addBond(512, 561);
        addBond(512, 595);
        addBond(514, 677);
        addBond(514, 909);
        addBond(515, 517);
        addBond(515, 556);
        addBond(516, 518);
        addBond(516, 558);
        addBond(516, 582);
        addBond(518, 520);
        addBond(519, 522);
        addBond(519, 525);
        addBond(519, 575);
        addBond(521, 550);
        addBond(522, 524);
        addBond(523, 525);
        addBond(523, 529);
        addBond(523, 572);
        addBond(524, 547);
        addBond(526, 528);
        addBond(527, 529);
        addBond(527, 534);
        addBond(527, 568);
        addBond(528, 544);
        addBond(530, 532);
        addBond(531, 534);
        addBond(531, 536);
        addBond(531, 565);
        addBond(532, 535);
        addBond(533, 540);
        addBond(534, 656);
        addBond(535, 537);
        addBond(535, 556);
        addBond(536, 539);
        addBond(536, 558);
        addBond(536, 585);
        addBond(538, 540);
        addBond(539, 542);
        addBond(539, 614);
        addBond(540, 674);
        addBond(540, 774);
        addBond(540, 799);
        addBond(541, 544);
        addBond(543, 545);
        addBond(543, 625);
        addBond(544, 547);
        addBond(545, 592);
        addBond(546, 549);
        addBond(546, 649);
        addBond(548, 550);
        addBond(549, 553);
        addBond(549, 694);
        addBond(550, 579);
        addBond(550, 710);
        addBond(554, 556);
        addBond(555, 564);
        addBond(556, 1381);
        addBond(556, 1434);
        addBond(558, 645);
        addBond(561, 603);
        addBond(561, 822);
        addBond(562, 564);
        addBond(563, 578);
        addBond(563, 580);
        addBond(564, 566);
        addBond(564, 578);
        addBond(564, 616);
        addBond(566, 648);
        addBond(567, 570);
        addBond(567, 616);
        addBond(567, 624);
        addBond(570, 572);
        addBond(571, 624);
        addBond(571, 646);
        addBond(572, 1831);
        addBond(572, 698);
        addBond(572, 2022);
        addBond(572, 855);
        addBond(573, 575);
        addBond(574, 646);
        addBond(574, 692);
        addBond(575, 654);
        addBond(577, 585);
        addBond(579, 582);
        addBond(581, 584);
        addBond(581, 587);
        addBond(583, 585);
        addBond(583, 591);
        addBond(584, 611);
        addBond(585, 1398);
        addBond(586, 588);
        addBond(587, 589);
        addBond(587, 593);
        addBond(588, 591);
        addBond(588, 597);
        addBond(589, 658);
        addBond(590, 609);
        addBond(591, 856);
        addBond(592, 595);
        addBond(593, 661);
        addBond(594, 596);
        addBond(594, 618);
        addBond(595, 597);
        addBond(595, 599);
        addBond(596, 604);
        addBond(597, 607);
        addBond(597, 664);
        addBond(597, 671);
        addBond(598, 600);
        addBond(598, 619);
        addBond(599, 602);
        addBond(599, 622);
        addBond(600, 2040);
        addBond(600, 2051);
        addBond(601, 604);
        addBond(601, 638);
        addBond(603, 606);
        addBond(604, 1960);
        addBond(605, 609);
        addBond(605, 634);
        addBond(606, 686);
        addBond(606, 690);
        addBond(607, 632);
        addBond(608, 610);
        addBond(609, 611);
        addBond(609, 631);
        addBond(610, 614);
        addBond(611, 613);
        addBond(611, 1868);
        addBond(612, 617);
        addBond(612, 1874);
        addBond(613, 616);
        addBond(613, 627);
        addBond(614, 693);
        addBond(614, 623);
        addBond(616, 1925);
        addBond(616, 1852);
        addBond(619, 703);
        addBond(620, 622);
        addBond(621, 641);
        addBond(622, 1092);
        addBond(623, 625);
        addBond(624, 627);
        addBond(624, 650);
        addBond(625, 635);
        addBond(625, 1810);
        addBond(626, 628);
        addBond(627, 631);
        addBond(627, 652);
        addBond(628, 637);
        addBond(628, 1925);
        addBond(629, 656);
        addBond(630, 633);
        addBond(631, 687);
        addBond(632, 634);
        addBond(632, 657);
        addBond(633, 636);
        addBond(634, 1815);
        addBond(635, 638);
        addBond(635, 660);
        addBond(636, 2044);
        addBond(637, 639);
        addBond(638, 641);
        addBond(638, 662);
        addBond(639, 1816);
        addBond(640, 644);
        addBond(642, 644);
        addBond(643, 666);
        addBond(644, 1817);
        addBond(644, 1818);
        addBond(645, 649);
        addBond(646, 1932);
        addBond(646, 1918);
        addBond(647, 1819);
        addBond(647, 664);
        addBond(648, 650);
        addBond(648, 696);
        addBond(649, 651);
        addBond(650, 652);
        addBond(650, 699);
        addBond(651, 655);
        addBond(652, 1875);
        addBond(652, 1929);
        addBond(652, 1922);
        addBond(654, 657);
        addBond(654, 704);
        addBond(655, 808);
        addBond(655, 816);
        addBond(656, 659);
        addBond(657, 1821);
        addBond(657, 686);
        addBond(658, 660);
        addBond(658, 709);
        addBond(659, 663);
        addBond(660, 1825);
        addBond(660, 1826);
        addBond(661, 663);
        addBond(661, 667);
        addBond(662, 715);
        addBond(663, 686);
        addBond(663, 1827);
        addBond(665, 667);
        addBond(665, 669);
        addBond(666, 719);
        addBond(667, 687);
        addBond(668, 670);
        addBond(668, 722);
        addBond(671, 673);
        addBond(671, 694);
        addBond(672, 675);
        addBond(672, 743);
        addBond(674, 676);
        addBond(674, 697);
        addBond(675, 678);
        addBond(675, 741);
        addBond(676, 815);
        addBond(677, 680);
        addBond(677, 702);
        addBond(678, 695);
        addBond(678, 1928);
        addBond(679, 682);
        addBond(679, 737);
        addBond(680, 770);
        addBond(680, 808);
        addBond(681, 683);
        addBond(681, 707);
        addBond(682, 684);
        addBond(682, 733);
        addBond(683, 685);
        addBond(683, 711);
        addBond(684, 688);
        addBond(684, 729);
        addBond(685, 1828);
        addBond(687, 689);
        addBond(687, 714);
        addBond(688, 691);
        addBond(688, 745);
        addBond(690, 717);
        addBond(691, 694);
        addBond(692, 1829);
        addBond(692, 1832);
        addBond(693, 696);
        addBond(694, 1858);
        addBond(694, 1932);
        addBond(695, 697);
        addBond(696, 699);
        addBond(697, 1831);
        addBond(697, 1981);
        addBond(697, 2035);
        addBond(698, 702);
        addBond(699, 730);
        addBond(699, 1942);
        addBond(700, 1606);
        addBond(700, 1990);
        addBond(701, 704);
        addBond(702, 1833);
        addBond(702, 1834);
        addBond(703, 707);
        addBond(704, 721);
        addBond(704, 1864);
        addBond(705, 869);
        addBond(705, 870);
        addBond(705, 712);
        addBond(706, 709);
        addBond(707, 718);
        addBond(707, 749);
        addBond(708, 711);
        addBond(709, 1945);
        addBond(710, 715);
        addBond(711, 1974);
        addBond(712, 1379);
        addBond(712, 2022);
        addBond(712, 2000);
        addBond(712, 2045);
        addBond(713, 715);
        addBond(713, 719);
        addBond(715, 1966);
        addBond(715, 1941);
        addBond(715, 826);
        addBond(716, 719);
        addBond(716, 722);
        addBond(717, 751);
        addBond(717, 752);
        addBond(719, 730);
        addBond(719, 732);
        addBond(720, 2042);
        addBond(720, 2001);
        addBond(722, 742);
        addBond(723, 739);
        addBond(724, 735);
        addBond(725, 731);
        addBond(726, 728);
        addBond(727, 729);
        addBond(727, 745);
        addBond(728, 731);
        addBond(729, 1990);
        addBond(730, 733);
        addBond(731, 760);
        addBond(732, 735);
        addBond(733, 1843);
        addBond(733, 2001);
        addBond(734, 737);
        addBond(735, 862);
        addBond(735, 2023);
        addBond(736, 739);
        addBond(737, 762);
        addBond(737, 1990);
        addBond(738, 741);
        addBond(739, 803);
        addBond(740, 742);
        addBond(741, 743);
        addBond(743, 1608);
        addBond(743, 746);
        addBond(745, 760);
        addBond(746, 784);
        addBond(746, 785);
        addBond(746, 830);
        addBond(747, 761);
        addBond(747, 854);
        addBond(748, 947);
        addBond(748, 756);
        addBond(748, 757);
        addBond(749, 824);
        addBond(749, 854);
        addBond(750, 779);
        addBond(750, 783);
        addBond(751, 756);
        addBond(751, 786);
        addBond(752, 759);
        addBond(752, 784);
        addBond(752, 851);
        addBond(757, 759);
        addBond(757, 769);
        addBond(757, 827);
        addBond(759, 762);
        addBond(760, 768);
        addBond(760, 848);
        addBond(761, 767);
        addBond(762, 765);
        addBond(762, 766);
        addBond(764, 769);
        addBond(764, 837);
        addBond(765, 775);
        addBond(765, 840);
        addBond(766, 1605);
        addBond(767, 852);
        addBond(772, 913);
        addBond(773, 781);
        addBond(774, 778);
        addBond(776, 2020);
        addBond(776, 782);
        addBond(777, 785);
        addBond(777, 844);
        addBond(778, 793);
        addBond(778, 794);
        addBond(779, 789);
        addBond(781, 826);
        addBond(782, 795);
        addBond(785, 794);
        addBond(785, 796);
        addBond(786, 2010);
        addBond(786, 2007);
        addBond(787, 827);
        addBond(787, 851);
        addBond(787, 852);
        addBond(788, 823);
        addBond(790, 824);
        addBond(790, 860);
        addBond(791, 803);
        addBond(791, 810);
        addBond(792, 798);
        addBond(792, 800);
        addBond(793, 801);
        addBond(794, 800);
        addBond(795, 802);
        addBond(796, 799);
        addBond(797, 807);
        addBond(797, 809);
        addBond(799, 811);
        addBond(800, 809);
        addBond(800, 812);
        addBond(801, 812);
        addBond(802, 867);
        addBond(804, 806);
        addBond(806, 813);
        addBond(806, 814);
        addBond(807, 836);
        addBond(808, 817);
        addBond(809, 815);
        addBond(809, 831);
        addBond(810, 814);
        addBond(811, 820);
        addBond(812, 821);
        addBond(812, 825);
        addBond(813, 834);
        addBond(815, 818);
        addBond(816, 825);
        addBond(816, 835);
        addBond(817, 829);
        addBond(817, 861);
        addBond(818, 847);
        addBond(819, 835);
        addBond(820, 839);
        addBond(820, 845);
        addBond(822, 833);
        addBond(822, 852);
        addBond(823, 842);
        addBond(824, 850);
        addBond(825, 828);
        addBond(826, 832);
        addBond(827, 841);
        addBond(828, 836);
        addBond(828, 877);
        addBond(829, 846);
        addBond(829, 848);
        addBond(831, 833);
        addBond(831, 837);
        addBond(832, 857);
        addBond(833, 845);
        addBond(834, 853);
        addBond(836, 838);
        addBond(837, 840);
        addBond(837, 860);
        addBond(838, 858);
        addBond(838, 864);
        addBond(839, 842);
        addBond(840, 1830);
        addBond(841, 844);
        addBond(842, 2046);
        addBond(842, 1342);
        addBond(843, 846);
        addBond(844, 866);
        addBond(845, 854);
        addBond(847, 851);
        addBond(848, 2013);
        addBond(848, 2010);
        addBond(849, 864);
        addBond(849, 871);
        addBond(852, 871);
        addBond(856, 860);
        addBond(857, 872);
        addBond(857, 875);
        addBond(860, 863);
        addBond(861, 2046);
        addBond(861, 2028);
        addBond(862, 873);
        addBond(862, 892);
        addBond(863, 876);
        addBond(864, 992);
        addBond(864, 946);
        addBond(864, 927);
        addBond(865, 875);
        addBond(867, 1396);
        addBond(867, 2038);
        addBond(867, 1874);
        addBond(867, 1852);
        addBond(868, 2049);
        addBond(871, 878);
        addBond(871, 879);
        addBond(872, 877);
        addBond(872, 907);
        addBond(873, 891);
        addBond(873, 911);
        addBond(874, 882);
        addBond(875, 878);
        addBond(877, 883);
        addBond(878, 884);
        addBond(878, 885);
        addBond(879, 895);
        addBond(880, 2501);
        addBond(881, 885);
        addBond(882, 886);
        addBond(883, 888);
        addBond(885, 888);
        addBond(885, 889);
        addBond(886, 908);
        addBond(887, 890);
        addBond(888, 893);
        addBond(889, 893);
        addBond(890, 905);
        addBond(891, 896);
        addBond(892, 894);
        addBond(892, 897);
        addBond(893, 898);
        addBond(893, 899);
        addBond(895, 906);
        addBond(896, 900);
        addBond(896, 916);
        addBond(897, 928);
        addBond(897, 900);
        addBond(897, 952);
        addBond(898, 953);
        addBond(898, 957);
        addBond(898, 916);
        addBond(899, 928);
        addBond(899, 958);
        addBond(900, 902);
        addBond(905, 907);
        addBond(905, 910);
        addBond(909, 913);
        addBond(911, 921);
        addBond(911, 993);
        addBond(911, 956);
        addBond(913, 1005);
        addBond(914, 1122);
        addBond(914, 1125);
        addBond(915, 961);
        addBond(915, 957);
        addBond(916, 1021);
        addBond(916, 993);
        addBond(917, 1016);
        addBond(918, 1031);
        addBond(918, 954);
        addBond(919, 922);
        addBond(919, 1027);
        addBond(920, 1021);
        addBond(921, 944);
        addBond(921, 977);
        addBond(922, 1066);
        addBond(923, 929);
        addBond(923, 1063);
        addBond(923, 989);
        addBond(924, 1099);
        addBond(925, 938);
        addBond(925, 932);
        addBond(925, 986);
        addBond(926, 929);
        addBond(926, 990);
        addBond(927, 966);
        addBond(927, 967);
        addBond(928, 973);
        addBond(928, 1129);
        addBond(929, 933);
        addBond(929, 1134);
        addBond(929, 970);
        addBond(929, 1130);
        addBond(930, 1064);
        addBond(930, 945);
        addBond(930, 1098);
        addBond(931, 935);
        addBond(932, 935);
        addBond(932, 986);
        addBond(933, 1117);
        addBond(933, 1070);
        addBond(933, 1122);
        addBond(934, 1139);
        addBond(935, 939);
        addBond(935, 985);
        addBond(935, 1142);
        addBond(936, 1015);
        addBond(936, 956);
        addBond(937, 939);
        addBond(937, 974);
        addBond(937, 1145);
        addBond(938, 1007);
        addBond(938, 1146);
        addBond(939, 1068);
        addBond(939, 1135);
        addBond(939, 1108);
        addBond(940, 943);
        addBond(940, 1005);
        addBond(940, 1147);
        addBond(941, 943);
        addBond(941, 988);
        addBond(941, 1006);
        addBond(942, 1018);
        addBond(943, 949);
        addBond(943, 1016);
        addBond(944, 948);
        addBond(944, 1096);
        addBond(944, 1118);
        addBond(945, 964);
        addBond(946, 949);
        addBond(946, 1050);
        addBond(947, 1136);
        addBond(947, 1112);
        addBond(948, 1031);
        addBond(949, 1103);
        addBond(949, 978);
        addBond(949, 964);
        addBond(950, 959);
        addBond(950, 1027);
        addBond(953, 959);
        addBond(953, 978);
        addBond(954, 1044);
        addBond(954, 962);
        addBond(954, 1089);
        addBond(954, 1101);
        addBond(955, 1028);
        addBond(956, 967);
        addBond(956, 968);
        addBond(958, 1103);
        addBond(959, 1015);
        addBond(959, 1028);
        addBond(961, 2047);
        addBond(962, 965);
        addBond(962, 1136);
        addBond(962, 1066);
        addBond(963, 965);
        addBond(964, 992);
        addBond(965, 969);
        addBond(965, 972);
        addBond(966, 975);
        addBond(967, 979);
        addBond(968, 980);
        addBond(968, 981);
        addBond(969, 973);
        addBond(969, 1102);
        addBond(970, 1033);
        addBond(970, 977);
        addBond(970, 1072);
        addBond(970, 1095);
        addBond(971, 983);
        addBond(973, 988);
        addBond(974, 984);
        addBond(974, 979);
        addBond(975, 993);
        addBond(975, 1002);
        addBond(976, 1156);
        addBond(978, 994);
        addBond(979, 995);
        addBond(980, 984);
        addBond(981, 1342);
        addBond(981, 1343);
        addBond(982, 996);
        addBond(983, 1001);
        addBond(984, 986);
        addBond(984, 1131);
        addBond(986, 1039);
        addBond(986, 991);
        addBond(986, 1079);
        addBond(986, 1088);
        addBond(987, 1007);
        addBond(988, 992);
        addBond(990, 1087);
        addBond(992, 1028);
        addBond(993, 1004);
        addBond(994, 1011);
        addBond(994, 996);
        addBond(995, 1012);
        addBond(996, 1028);
        addBond(996, 1062);
        addBond(997, 1056);
        addBond(997, 1062);
        addBond(997, 1055);
        addBond(998, 1052);
        addBond(998, 1019);
        addBond(999, 1071);
        addBond(999, 1047);
        addBond(1000, 1013);
        addBond(1001, 1056);
        addBond(1001, 1062);
        addBond(1001, 1054);
        addBond(1002, 1081);
        addBond(1002, 1009);
        addBond(1003, 1013);
        addBond(1003, 1014);
        addBond(1004, 1007);
        addBond(1005, 1050);
        addBond(1007, 1094);
        addBond(1007, 1030);
        addBond(1008, 1030);
        addBond(1008, 1047);
        addBond(1008, 1053);
        addBond(1009, 1017);
        addBond(1009, 1086);
        addBond(1009, 1083);
        addBond(1010, 1020);
        addBond(1011, 1022);
        addBond(1012, 1024);
        addBond(1013, 1025);
        addBond(1014, 2417);
        addBond(1015, 1018);
        addBond(1016, 1117);
        addBond(1016, 1082);
        addBond(1017, 1050);
        addBond(1018, 1030);
        addBond(1018, 1047);
        addBond(1018, 1049);
        addBond(1019, 1029);
        addBond(1019, 1040);
        addBond(1020, 2417);
        addBond(1021, 1040);
        addBond(1022, 1096);
        addBond(1022, 1098);
        addBond(1023, 1042);
        addBond(1024, 1045);
        addBond(1025, 1814);
        addBond(1025, 1811);
        addBond(1026, 1031);
        addBond(1028, 1051);
        addBond(1029, 1043);
        addBond(1031, 1134);
        addBond(1031, 1070);
        addBond(1031, 1068);
        addBond(1031, 1078);
        addBond(1032, 1074);
        addBond(1033, 1091);
        addBond(1033, 1089);
        addBond(1034, 1084);
        addBond(1034, 1086);
        addBond(1035, 1077);
        addBond(1035, 1079);
        addBond(1036, 1074);
        addBond(1036, 1072);
        addBond(1037, 1062);
        addBond(1037, 1069);
        addBond(1038, 1077);
        addBond(1039, 1057);
        addBond(1040, 1056);
        addBond(1040, 1069);
        addBond(1041, 1058);
        addBond(1041, 1045);
        addBond(1042, 1069);
        addBond(1043, 1091);
        addBond(1044, 1059);
        addBond(1045, 1106);
        addBond(1045, 1093);
        addBond(1045, 2122);
        addBond(1046, 1048);
        addBond(1047, 1069);
        addBond(1050, 1060);
        addBond(1050, 1061);
        addBond(1051, 1094);
        addBond(1051, 1071);
        addBond(1051, 1093);
        addBond(1056, 1065);
        addBond(1057, 1067);
        addBond(1058, 1100);
        addBond(1059, 1105);
        addBond(1060, 1107);
        addBond(1060, 1065);
        addBond(1062, 1102);
        addBond(1065, 1103);
        addBond(1066, 1109);
        addBond(1066, 1110);
        addBond(1067, 1102);
        addBond(1069, 1125);
        addBond(1070, 1081);
        addBond(1070, 1106);
        addBond(1071, 1077);
        addBond(1071, 1090);
        addBond(1072, 1135);
        addBond(1073, 1089);
        addBond(1074, 1125);
        addBond(1075, 1144);
        addBond(1075, 2122);
        addBond(1078, 1084);
        addBond(1078, 1085);
        addBond(1079, 1086);
        addBond(1080, 1094);
        addBond(1080, 1144);
        addBond(1085, 1122);
        addBond(1088, 1097);
        addBond(1090, 1096);
        addBond(1091, 1810);
        addBond(1091, 1832);
        addBond(1091, 1835);
        addBond(1095, 1104);
        addBond(1097, 1099);
        addBond(1098, 1135);
        addBond(1098, 1150);
        addBond(1099, 1110);
        addBond(1104, 1111);
        addBond(1104, 1113);
        addBond(1106, 1114);
        addBond(1107, 1125);
        addBond(1107, 1150);
        addBond(1108, 1115);
        addBond(1109, 1116);
        addBond(1110, 1119);
        addBond(1112, 1121);
        addBond(1112, 1114);
        addBond(1114, 1123);
        addBond(1114, 1124);
        addBond(1115, 1126);
        addBond(1116, 1131);
        addBond(1118, 1127);
        addBond(1118, 1128);
        addBond(1119, 2591);
        addBond(1120, 1132);
        addBond(1122, 1133);
        addBond(1123, 1140);
        addBond(1123, 1126);
        addBond(1126, 1132);
        addBond(1126, 1143);
        addBond(1127, 1148);
        addBond(1130, 1134);
        addBond(1132, 1168);
        addBond(1132, 1182);
        addBond(1133, 1137);
        addBond(1137, 1607);
        addBond(1137, 2039);
        addBond(1139, 1382);
        addBond(1142, 1383);
        addBond(1147, 1621);
        addBond(1147, 1639);
        addBond(1150, 1152);
        addBond(1150, 1812);
        addBond(1151, 1813);
        addBond(1151, 1154);
        addBond(1152, 1814);
        addBond(1152, 1154);
        addBond(1154, 1156);
        addBond(1155, 1157);
        addBond(1155, 1158);
        addBond(1156, 1159);
        addBond(1157, 1160);
        addBond(1158, 1160);
        addBond(1158, 1161);
        addBond(1159, 1162);
        addBond(1160, 1163);
        addBond(1160, 1164);
        addBond(1161, 1165);
        addBond(1161, 1166);
        addBond(1162, 1165);
        addBond(1162, 1167);
        addBond(1163, 1169);
        addBond(1164, 1170);
        addBond(1165, 1171);
        addBond(1166, 1172);
        addBond(1166, 1173);
        addBond(1167, 1646);
        addBond(1168, 1173);
        addBond(1169, 1174);
        addBond(1169, 1175);
        addBond(1170, 1175);
        addBond(1171, 1174);
        addBond(1171, 1176);
        addBond(1172, 1177);
        addBond(1173, 1178);
        addBond(1174, 1179);
        addBond(1175, 1180);
        addBond(1175, 1181);
        addBond(1176, 1181);
        addBond(1177, 1183);
        addBond(1177, 1184);
        addBond(1178, 1184);
        addBond(1179, 1183);
        addBond(1179, 1185);
        addBond(1180, 1186);
        addBond(1181, 1811);
        addBond(1181, 1382);
        addBond(1182, 1187);
        addBond(1183, 1188);
        addBond(1184, 1189);
        addBond(1184, 1190);
        addBond(1185, 1190);
        addBond(1186, 1191);
        addBond(1186, 1192);
        addBond(1187, 1192);
        addBond(1188, 1193);
        addBond(1188, 1191);
        addBond(1189, 1194);
        addBond(1190, 1195);
        addBond(1191, 1199);
        addBond(1192, 1200);
        addBond(1192, 1201);
        addBond(1193, 1201);
        addBond(1194, 1202);
        addBond(1194, 1203);
        addBond(1195, 1241);
        addBond(1196, 1242);
        addBond(1197, 1243);
        addBond(1198, 1203);
        addBond(1199, 1202);
        addBond(1199, 1204);
        addBond(1201, 1205);
        addBond(1203, 1208);
        addBond(1204, 1208);
        addBond(1205, 1251);
        addBond(1206, 1252);
        addBond(1207, 1209);
        addBond(1207, 1210);
        addBond(1208, 1211);
        addBond(1208, 1212);
        addBond(1209, 1216);
        addBond(1210, 1217);
        addBond(1210, 1218);
        addBond(1210, 1219);
        addBond(1211, 1220);
        addBond(1211, 1221);
        addBond(1211, 1229);
        addBond(1212, 1255);
        addBond(1213, 1253);
        addBond(1214, 1254);
        addBond(1215, 1217);
        addBond(1215, 1229);
        addBond(1216, 1218);
        addBond(1216, 1230);
        addBond(1217, 1231);
        addBond(1217, 1232);
        addBond(1220, 1231);
        addBond(1220, 1229);
        addBond(1220, 1233);
        addBond(1221, 1256);
        addBond(1222, 1257);
        addBond(1223, 1258);
        addBond(1224, 1259);
        addBond(1225, 1260);
        addBond(1226, 1273);
        addBond(1227, 1274);
        addBond(1228, 1234);
        addBond(1230, 1235);
        addBond(1231, 1244);
        addBond(1231, 1245);
        addBond(1232, 1246);
        addBond(1234, 1246);
        addBond(1234, 1247);
        addBond(1235, 1275);
        addBond(1236, 1276);
        addBond(1237, 1277);
        addBond(1238, 1278);
        addBond(1239, 1279);
        addBond(1240, 1572);
        addBond(1240, 1251);
        addBond(1240, 1242);
        addBond(1241, 1956);
        addBond(1241, 1243);
        addBond(1242, 1980);
        addBond(1242, 1251);
        addBond(1243, 1248);
        addBond(1244, 1249);
        addBond(1244, 1250);
        addBond(1245, 1261);
        addBond(1246, 1249);
        addBond(1246, 1262);
        addBond(1247, 1263);
        addBond(1249, 1264);
        addBond(1250, 1578);
        addBond(1251, 1577);
        addBond(1251, 1254);
        addBond(1251, 1253);
        addBond(1252, 1521);
        addBond(1252, 1255);
        addBond(1253, 2004);
        addBond(1253, 1255);
        addBond(1254, 1520);
        addBond(1255, 1517);
        addBond(1255, 1259);
        addBond(1255, 1257);
        addBond(1256, 1999);
        addBond(1256, 1258);
        addBond(1257, 1618);
        addBond(1257, 1259);
        addBond(1258, 1502);
        addBond(1259, 1503);
        addBond(1259, 1275);
        addBond(1259, 1273);
        addBond(1260, 1265);
        addBond(1261, 1266);
        addBond(1262, 1267);
        addBond(1262, 1264);
        addBond(1263, 1268);
        addBond(1264, 1269);
        addBond(1264, 1266);
        addBond(1265, 1270);
        addBond(1266, 1271);
        addBond(1267, 1272);
        addBond(1268, 1284);
        addBond(1269, 1285);
        addBond(1270, 1286);
        addBond(1271, 1286);
        addBond(1271, 1287);
        addBond(1272, 1617);
        addBond(1272, 1274);
        addBond(1273, 1613);
        addBond(1273, 1275);
        addBond(1274, 1536);
        addBond(1275, 1582);
        addBond(1275, 1279);
        addBond(1275, 1277);
        addBond(1276, 1614);
        addBond(1276, 1278);
        addBond(1277, 1610);
        addBond(1277, 1279);
        addBond(1278, 1973);
        addBond(1279, 1368);
        addBond(1279, 2360);
        addBond(1280, 1328);
        addBond(1280, 2360);
        addBond(1281, 1300);
        addBond(1282, 1298);
        addBond(1283, 1288);
        addBond(1284, 1288);
        addBond(1284, 1289);
        addBond(1285, 1290);
        addBond(1286, 1291);
        addBond(1287, 1292);
        addBond(1288, 1293);
        addBond(1289, 1294);
        addBond(1290, 1295);
        addBond(1290, 1296);
        addBond(1291, 1310);
        addBond(1292, 1311);
        addBond(1292, 1312);
        addBond(1293, 1295);
        addBond(1294, 1313);
        addBond(1295, 1314);
        addBond(1296, 1564);
        addBond(1296, 1338);
        addBond(1296, 1299);
        addBond(1296, 1298);
        addBond(1297, 1573);
        addBond(1297, 1300);
        addBond(1298, 1968);
        addBond(1298, 1337);
        addBond(1298, 1300);
        addBond(1299, 1538);
        addBond(1300, 1306);
        addBond(1301, 1307);
        addBond(1302, 1476);
        addBond(1302, 1305);
        addBond(1303, 1477);
        addBond(1303, 1308);
        addBond(1304, 2026);
        addBond(1304, 1308);
        addBond(1304, 1306);
        addBond(1305, 2036);
        addBond(1305, 1307);
        addBond(1306, 1975);
        addBond(1306, 1308);
        addBond(1307, 1559);
        addBond(1308, 1360);
        addBond(1308, 1328);
        addBond(1309, 1311);
        addBond(1310, 1315);
        addBond(1311, 1316);
        addBond(1312, 1317);
        addBond(1313, 1318);
        addBond(1313, 1319);
        addBond(1314, 1320);
        addBond(1315, 1321);
        addBond(1315, 1322);
        addBond(1316, 1318);
        addBond(1317, 1323);
        addBond(1318, 1324);
        addBond(1319, 1321);
        addBond(1320, 1325);
        addBond(1321, 1326);
        addBond(1322, 1327);
        addBond(1323, 1344);
        addBond(1323, 1345);
        addBond(1324, 1346);
        addBond(1325, 1347);
        addBond(1325, 1348);
        addBond(1326, 1345);
        addBond(1327, 1368);
        addBond(1327, 1365);
        addBond(1328, 1386);
        addBond(1329, 1365);
        addBond(1330, 1360);
        addBond(1331, 1341);
        addBond(1332, 1340);
        addBond(1333, 1339);
        addBond(1334, 1362);
        addBond(1335, 1359);
        addBond(1336, 1364);
        addBond(1337, 1367);
        addBond(1338, 1476);
        addBond(1338, 1363);
        addBond(1338, 1340);
        addBond(1339, 1477);
        addBond(1339, 1341);
        addBond(1340, 1385);
        addBond(1340, 1359);
        addBond(1341, 2034);
        addBond(1342, 1351);
        addBond(1342, 2037);
        addBond(1343, 1349);
        addBond(1344, 1350);
        addBond(1345, 1348);
        addBond(1346, 1352);
        addBond(1347, 1353);
        addBond(1348, 1354);
        addBond(1348, 1355);
        addBond(1349, 1356);
        addBond(1350, 1606);
        addBond(1351, 1357);
        addBond(1351, 1358);
        addBond(1352, 1370);
        addBond(1353, 1371);
        addBond(1354, 1372);
        addBond(1354, 1356);
        addBond(1356, 1371);
        addBond(1357, 1373);
        addBond(1357, 1370);
        addBond(1358, 1362);
        addBond(1358, 1360);
        addBond(1359, 1366);
        addBond(1360, 1369);
        addBond(1360, 1362);
        addBond(1361, 1363);
        addBond(1362, 1387);
        addBond(1363, 1479);
        addBond(1363, 1367);
        addBond(1363, 1365);
        addBond(1364, 1366);
        addBond(1365, 1386);
        addBond(1365, 1369);
        addBond(1366, 1488);
        addBond(1366, 1368);
        addBond(1367, 1369);
        addBond(1368, 1388);
        addBond(1370, 1374);
        addBond(1371, 1375);
        addBond(1372, 1376);
        addBond(1373, 1376);
        addBond(1373, 1375);
        addBond(1376, 1589);
        addBond(1377, 2045);
        addBond(1379, 1567);
        addBond(1380, 1436);
        addBond(1380, 1567);
        addBond(1380, 1589);
        addBond(1382, 1621);
        addBond(1383, 1396);
        addBond(1383, 1398);
        addBond(1383, 1438);
        addBond(1383, 1823);
        addBond(1384, 1959);
        addBond(1384, 1387);
        addBond(1384, 1386);
        addBond(1385, 1478);
        addBond(1386, 1490);
        addBond(1386, 1388);
        addBond(1387, 1487);
        addBond(1388, 1473);
        addBond(1389, 1475);
        addBond(1390, 1474);
        addBond(1391, 1472);
        addBond(1392, 1460);
        addBond(1393, 1471);
        addBond(1394, 1461);
        addBond(1395, 1589);
        addBond(1396, 1398);
        addBond(1396, 1567);
        addBond(1396, 2038);
        addBond(1397, 1438);
        addBond(1398, 1402);
        addBond(1398, 1549);
        addBond(1399, 1404);
        addBond(1399, 1550);
        addBond(1400, 1419);
        addBond(1400, 1451);
        addBond(1401, 1450);
        addBond(1402, 1404);
        addBond(1402, 1422);
        addBond(1403, 1450);
        addBond(1404, 1459);
        addBond(1405, 1458);
        addBond(1406, 1456);
        addBond(1407, 1457);
        addBond(1408, 1455);
        addBond(1409, 1445);
        addBond(1410, 1454);
        addBond(1411, 1453);
        addBond(1412, 1446);
        addBond(1413, 1444);
        addBond(1414, 1441);
        addBond(1415, 1443);
        addBond(1416, 1418);
        addBond(1416, 1419);
        addBond(1417, 1587);
        addBond(1418, 1422);
        addBond(1419, 1422);
        addBond(1419, 1566);
        addBond(1420, 1433);
        addBond(1420, 1495);
        addBond(1422, 1424);
        addBond(1422, 1433);
        addBond(1422, 1447);
        addBond(1423, 1434);
        addBond(1424, 1442);
        addBond(1425, 1440);
        addBond(1426, 1430);
        addBond(1427, 1432);
        addBond(1428, 1431);
        addBond(1429, 1601);
        addBond(1429, 1440);
        addBond(1429, 1431);
        addBond(1430, 1611);
        addBond(1430, 1432);
        addBond(1431, 1970);
        addBond(1431, 1440);
        addBond(1433, 1435);
        addBond(1434, 1436);
        addBond(1434, 1452);
        addBond(1435, 1438);
        addBond(1436, 1452);
        addBond(1436, 1468);
        addBond(1437, 1449);
        addBond(1438, 1447);
        addBond(1438, 1452);
        addBond(1439, 1962);
        addBond(1440, 1595);
        addBond(1440, 1444);
        addBond(1440, 1442);
        addBond(1441, 1603);
        addBond(1441, 1443);
        addBond(1442, 1953);
        addBond(1442, 1444);
        addBond(1443, 1493);
        addBond(1444, 1592);
        addBond(1444, 1454);
        addBond(1444, 1446);
        addBond(1445, 1594);
        addBond(1445, 1453);
        addBond(1446, 1464);
        addBond(1447, 1449);
        addBond(1447, 1466);
        addBond(1448, 1468);
        addBond(1449, 1451);
        addBond(1452, 1535);
        addBond(1452, 1454);
        addBond(1453, 1551);
        addBond(1454, 1534);
        addBond(1454, 1457);
        addBond(1454, 1456);
        addBond(1455, 1563);
        addBond(1455, 1458);
        addBond(1456, 1591);
        addBond(1456, 1458);
        addBond(1457, 1584);
        addBond(1458, 1972);
        addBond(1458, 1461);
        addBond(1458, 1460);
        addBond(1459, 1947);
        addBond(1459, 1471);
        addBond(1460, 1583);
        addBond(1460, 1471);
        addBond(1461, 1463);
        addBond(1461, 1498);
        addBond(1462, 1466);
        addBond(1462, 1484);
        addBond(1463, 1496);
        addBond(1464, 1469);
        addBond(1464, 1512);
        addBond(1466, 1482);
        addBond(1466, 1498);
        addBond(1466, 1512);
        addBond(1467, 1510);
        addBond(1468, 1480);
        addBond(1468, 1526);
        addBond(1469, 1480);
        addBond(1469, 1570);
        addBond(1470, 1632);
        addBond(1471, 1948);
        addBond(1471, 1474);
        addBond(1471, 1473);
        addBond(1472, 1519);
        addBond(1472, 1475);
        addBond(1473, 1631);
        addBond(1473, 1475);
        addBond(1474, 2032);
        addBond(1475, 1489);
        addBond(1475, 1477);
        addBond(1476, 1507);
        addBond(1477, 1518);
        addBond(1477, 1487);
        addBond(1477, 1479);
        addBond(1478, 1961);
        addBond(1479, 1481);
        addBond(1480, 1482);
        addBond(1481, 1483);
        addBond(1482, 1484);
        addBond(1483, 1510);
        addBond(1484, 1486);
        addBond(1484, 1500);
        addBond(1485, 1495);
        addBond(1486, 2018);
        addBond(1486, 1488);
        addBond(1487, 1565);
        addBond(1488, 2029);
        addBond(1488, 1507);
        addBond(1488, 1490);
        addBond(1489, 2019);
        addBond(1490, 1561);
        addBond(1490, 1522);
        addBond(1490, 1494);
        addBond(1491, 1551);
        addBond(1491, 1545);
        addBond(1491, 1535);
        addBond(1492, 1542);
        addBond(1492, 1535);
        addBond(1493, 1552);
        addBond(1494, 1496);
        addBond(1495, 1548);
        addBond(1496, 1499);
        addBond(1496, 1514);
        addBond(1498, 1500);
        addBond(1499, 1585);
        addBond(1500, 1537);
        addBond(1500, 1506);
        addBond(1501, 1516);
        addBond(1501, 1503);
        addBond(1502, 1554);
        addBond(1503, 1552);
        addBond(1503, 1544);
        addBond(1504, 1948);
        addBond(1504, 1965);
        addBond(1504, 1519);
        addBond(1505, 1951);
        addBond(1505, 1523);
        addBond(1506, 1949);
        addBond(1506, 1959);
        addBond(1507, 1541);
        addBond(1507, 1524);
        addBond(1507, 1523);
        addBond(1508, 1556);
        addBond(1508, 1515);
        addBond(1510, 1513);
        addBond(1510, 1546);
        addBond(1512, 1514);
        addBond(1513, 1533);
        addBond(1514, 1950);
        addBond(1514, 1955);
        addBond(1515, 1552);
        addBond(1515, 1517);
        addBond(1516, 1520);
        addBond(1517, 1952);
        addBond(1517, 1541);
        addBond(1518, 1975);
        addBond(1519, 1522);
        addBond(1520, 1980);
        addBond(1520, 1522);
        addBond(1523, 1556);
        addBond(1524, 1947);
        addBond(1524, 1972);
        addBond(1524, 1540);
        addBond(1525, 1527);
        addBond(1526, 1547);
        addBond(1527, 1531);
        addBond(1527, 1549);
        addBond(1528, 1530);
        addBond(1528, 1550);
        addBond(1529, 1532);
        addBond(1529, 1546);
        addBond(1530, 1546);
        addBond(1531, 1533);
        addBond(1532, 1569);
        addBond(1533, 1560);
        addBond(1533, 1551);
        addBond(1535, 1582);
        addBond(1535, 1554);
        addBond(1536, 1561);
        addBond(1536, 1555);
        addBond(1537, 1951);
        addBond(1537, 1956);
        addBond(1538, 1969);
        addBond(1538, 1544);
        addBond(1539, 1954);
        addBond(1539, 1553);
        addBond(1540, 1961);
        addBond(1541, 1953);
        addBond(1541, 1982);
        addBond(1542, 1562);
        addBond(1542, 1545);
        addBond(1543, 1554);
        addBond(1544, 1557);
        addBond(1546, 1568);
        addBond(1546, 1570);
        addBond(1547, 1585);
        addBond(1548, 1550);
        addBond(1552, 1965);
        addBond(1554, 1956);
        addBond(1554, 1980);
        addBond(1555, 1979);
        addBond(1556, 1982);
        addBond(1557, 1957);
        addBond(1557, 1969);
        addBond(1558, 1949);
        addBond(1558, 1950);
        addBond(1559, 1563);
        addBond(1559, 1562);
        addBond(1561, 1954);
        addBond(1562, 1972);
        addBond(1563, 1574);
        addBond(1563, 1565);
        addBond(1564, 1988);
        addBond(1565, 1586);
        addBond(1565, 1587);
        addBond(1566, 1589);
        addBond(1567, 1588);
        addBond(1568, 1585);
        addBond(1569, 1586);
        addBond(1570, 1987);
        addBond(1570, 1575);
        addBond(1571, 1579);
        addBond(1571, 1573);
        addBond(1572, 1574);
        addBond(1573, 1575);
        addBond(1574, 1576);
        addBond(1575, 1580);
        addBond(1576, 1989);
        addBond(1576, 1578);
        addBond(1577, 1579);
        addBond(1578, 1580);
        addBond(1579, 1581);
        addBond(1580, 1986);
        addBond(1581, 1977);
        addBond(1582, 1633);
        addBond(1582, 1584);
        addBond(1583, 1590);
        addBond(1586, 1588);
        addBond(1589, 1599);
        addBond(1589, 1591);
        addBond(1590, 1592);
        addBond(1591, 1593);
        addBond(1592, 1597);
        addBond(1592, 1594);
        addBond(1593, 1595);
        addBond(1594, 1602);
        addBond(1595, 1609);
        addBond(1595, 1597);
        addBond(1596, 1598);
        addBond(1597, 1599);
        addBond(1598, 1600);
        addBond(1599, 2041);
        addBond(1600, 1612);
        addBond(1600, 1603);
        addBond(1601, 1609);
        addBond(1601, 1603);
        addBond(1603, 1605);
        addBond(1603, 1619);
        addBond(1604, 1608);
        addBond(1605, 1607);
        addBond(1606, 1942);
        addBond(1607, 1647);
        addBond(1608, 1627);
        addBond(1609, 1615);
        addBond(1609, 1611);
        addBond(1610, 1612);
        addBond(1611, 1628);
        addBond(1612, 1616);
        addBond(1612, 1614);
        addBond(1613, 1615);
        addBond(1614, 1625);
        addBond(1615, 1623);
        addBond(1615, 1617);
        addBond(1616, 1618);
        addBond(1617, 1994);
        addBond(1618, 1620);
        addBond(1618, 2006);
        addBond(1619, 1638);
        addBond(1619, 2005);
        addBond(1620, 1812);
        addBond(1621, 1993);
        addBond(1621, 1623);
        addBond(1622, 1624);
        addBond(1623, 1625);
        addBond(1624, 1626);
        addBond(1625, 1628);
        addBond(1626, 1628);
        addBond(1628, 1634);
        addBond(1628, 1635);
        addBond(1628, 2354);
        addBond(1629, 1636);
        addBond(1629, 1637);
        addBond(1629, 2354);
        addBond(1630, 2030);
        addBond(1630, 1632);
        addBond(1631, 1633);
        addBond(1632, 2041);
        addBond(1633, 1640);
        addBond(1633, 1636);
        addBond(1633, 1641);
        addBond(1634, 1642);
        addBond(1634, 1637);
        addBond(1634, 1643);
        addBond(1635, 1640);
        addBond(1635, 1644);
        addBond(1636, 1645);
        addBond(1636, 1642);
        addBond(1637, 1647);
        addBond(1638, 1813);
        addBond(1639, 1648);
        addBond(1639, 1649);
        addBond(1641, 1649);
        addBond(1641, 1650);
        addBond(1645, 1814);
        addBond(1645, 1946);
        addBond(1647, 1651);
        addBond(1647, 1652);
        addBond(1648, 1653);
        addBond(1649, 1654);
        addBond(1650, 1655);
        addBond(1650, 1656);
        addBond(1651, 1657);
        addBond(1652, 1658);
        addBond(1652, 1654);
        addBond(1653, 1659);
        addBond(1654, 1660);
        addBond(1655, 1658);
        addBond(1656, 1661);
        addBond(1657, 1662);
        addBond(1658, 1663);
        addBond(1659, 1664);
        addBond(1659, 1661);
        addBond(1660, 1665);
        addBond(1661, 1666);
        addBond(1662, 1666);
        addBond(1662, 1667);
        addBond(1663, 1668);
        addBond(1664, 1669);
        addBond(1665, 1670);
        addBond(1666, 1671);
        addBond(1667, 1672);
        addBond(1667, 1673);
        addBond(1668, 1673);
        addBond(1669, 1674);
        addBond(1670, 1675);
        addBond(1671, 1676);
        addBond(1672, 1677);
        addBond(1673, 1678);
        addBond(1673, 1675);
        addBond(1674, 1679);
        addBond(1675, 1680);
        addBond(1675, 1681);
        addBond(1676, 1682);
        addBond(1677, 1683);
        addBond(1678, 1684);
        addBond(1679, 1685);
        addBond(1680, 1686);
        addBond(1680, 1682);
        addBond(1682, 1687);
        addBond(1682, 1688);
        addBond(1683, 1688);
        addBond(1684, 1689);
        addBond(1684, 1690);
        addBond(1685, 1691);
        addBond(1686, 1692);
        addBond(1687, 1693);
        addBond(1688, 1694);
        addBond(1689, 1695);
        addBond(1689, 1691);
        addBond(1691, 1696);
        addBond(1691, 1697);
        addBond(1692, 1698);
        addBond(1693, 1699);
        addBond(1693, 1700);
        addBond(1694, 1701);
        addBond(1695, 1702);
        addBond(1696, 1703);
        addBond(1696, 1698);
        addBond(1698, 1701);
        addBond(1698, 1704);
        addBond(1699, 1705);
        addBond(1701, 1706);
        addBond(1701, 1707);
        addBond(1702, 1708);
        addBond(1703, 1709);
        addBond(1704, 1710);
        addBond(1704, 1711);
        addBond(1705, 1712);
        addBond(1706, 1713);
        addBond(1706, 1708);
        addBond(1708, 1710);
        addBond(1709, 1714);
        addBond(1710, 1715);
        addBond(1711, 1716);
        addBond(1711, 1717);
        addBond(1712, 1718);
        addBond(1713, 1719);
        addBond(1714, 1720);
        addBond(1714, 1717);
        addBond(1715, 1718);
        addBond(1715, 1721);
        addBond(1718, 1720);
        addBond(1719, 1722);
        addBond(1720, 1722);
        addBond(1722, 1804);
        addBond(1723, 1725);
        addBond(1723, 1729);
        addBond(1724, 1728);
        addBond(1724, 1786);
        addBond(1725, 1727);
        addBond(1725, 1739);
        addBond(1725, 1796);
        addBond(1726, 1740);
        addBond(1726, 1797);
        addBond(1727, 1732);
        addBond(1727, 1790);
        addBond(1728, 1730);
        addBond(1728, 1759);
        addBond(1729, 1731);
        addBond(1729, 1760);
        addBond(1730, 1732);
        addBond(1732, 1734);
        addBond(1732, 1749);
        addBond(1733, 1735);
        addBond(1733, 1746);
        addBond(1734, 1736);
        addBond(1735, 1737);
        addBond(1735, 1743);
        addBond(1736, 1738);
        addBond(1737, 1739);
        addBond(1737, 1742);
        addBond(1739, 1741);
        addBond(1740, 1742);
        addBond(1741, 1745);
        addBond(1742, 1744);
        addBond(1742, 1748);
        addBond(1743, 1745);
        addBond(1745, 1747);
        addBond(1745, 1752);
        addBond(1746, 1748);
        addBond(1748, 1750);
        addBond(1748, 1773);
        addBond(1749, 1751);
        addBond(1749, 1785);
        addBond(1750, 1752);
        addBond(1752, 1754);
        addBond(1752, 1769);
        addBond(1753, 1755);
        addBond(1753, 1766);
        addBond(1754, 1756);
        addBond(1755, 1757);
        addBond(1755, 1763);
        addBond(1756, 1758);
        addBond(1757, 1759);
        addBond(1757, 1762);
        addBond(1759, 1761);
        addBond(1760, 1762);
        addBond(1761, 1765);
        addBond(1762, 1764);
        addBond(1762, 1768);
        addBond(1763, 1765);
        addBond(1765, 1767);
        addBond(1765, 1772);
        addBond(1766, 1768);
        addBond(1768, 1770);
        addBond(1768, 1777);
        addBond(1769, 1771);
        addBond(1769, 1778);
        addBond(1770, 1772);
        addBond(1772, 1774);
        addBond(1773, 1775);
        addBond(1773, 1783);
        addBond(1774, 1776);
        addBond(1775, 1777);
        addBond(1775, 1780);
        addBond(1777, 1779);
        addBond(1777, 1799);
        addBond(1777, 1802);
        addBond(1778, 1780);
        addBond(1778, 1803);
        addBond(1779, 1781);
        addBond(1780, 1782);
        addBond(1780, 1807);
        addBond(1781, 1783);
        addBond(1782, 1784);
        addBond(1783, 1785);
        addBond(1785, 1787);
        addBond(1786, 1788);
        addBond(1786, 1791);
        addBond(1787, 1789);
        addBond(1787, 1795);
        addBond(1788, 1790);
        addBond(1790, 1792);
        addBond(1791, 1793);
        addBond(1791, 1796);
        addBond(1792, 1794);
        addBond(1792, 1798);
        addBond(1793, 1795);
        addBond(1796, 1798);
        addBond(1798, 1800);
        addBond(1798, 1802);
        addBond(1798, 1809);
        addBond(1799, 1805);
        addBond(1799, 2366);
        addBond(1800, 1802);
        addBond(1800, 1804);
        addBond(1800, 2366);
        addBond(1801, 1808);
        addBond(1802, 1804);
        addBond(1802, 1805);
        addBond(1802, 1807);
        addBond(1803, 1805);
        addBond(1804, 1806);
        addBond(1809, 1836);
        addBond(1809, 1837);
        addBond(1812, 1946);
        addBond(1814, 1838);
        addBond(1814, 1836);
        addBond(1815, 1839);
        addBond(1815, 1840);
        addBond(1816, 1841);
        addBond(1817, 1842);
        addBond(1817, 1819);
        addBond(1818, 1844);
        addBond(1819, 1824);
        addBond(1820, 1825);
        addBond(1820, 1845);
        addBond(1821, 1831);
        addBond(1821, 2000);
        addBond(1823, 1960);
        addBond(1824, 1846);
        addBond(1825, 1847);
        addBond(1826, 1848);
        addBond(1827, 1849);
        addBond(1828, 1833);
        addBond(1828, 1850);
        addBond(1829, 2000);
        addBond(1830, 1978);
        addBond(1831, 1836);
        addBond(1831, 1855);
        addBond(1832, 1856);
        addBond(1833, 1847);
        addBond(1835, 1857);
        addBond(1837, 1839);
        addBond(1837, 1859);
        addBond(1838, 1861);
        addBond(1839, 1841);
        addBond(1840, 1862);
        addBond(1841, 1865);
        addBond(1841, 1866);
        addBond(1842, 1981);
        addBond(1842, 2022);
        addBond(1842, 2042);
        addBond(1843, 1845);
        addBond(1843, 1866);
        addBond(1843, 1848);
        addBond(1844, 1881);
        addBond(1844, 1849);
        addBond(1845, 1881);
        addBond(1845, 1882);
        addBond(1846, 1883);
        addBond(1847, 1849);
        addBond(1847, 1884);
        addBond(1848, 1885);
        addBond(1849, 1886);
        addBond(1849, 1859);
        addBond(1849, 1887);
        addBond(1850, 1983);
        addBond(1850, 1930);
        addBond(1852, 1938);
        addBond(1853, 1864);
        addBond(1855, 1888);
        addBond(1855, 1886);
        addBond(1857, 1860);
        addBond(1857, 1945);
        addBond(1858, 1889);
        addBond(1858, 1890);
        addBond(1859, 1869);
        addBond(1859, 1872);
        addBond(1860, 1891);
        addBond(1860, 1889);
        addBond(1861, 1865);
        addBond(1861, 1891);
        addBond(1862, 1878);
        addBond(1863, 1921);
        addBond(1864, 1892);
        addBond(1865, 1893);
        addBond(1866, 1880);
        addBond(1868, 1873);
        addBond(1868, 1928);
        addBond(1870, 1872);
        addBond(1872, 1875);
        addBond(1874, 1878);
        addBond(1875, 1926);
        addBond(1877, 1921);
        addBond(1879, 2050);
        addBond(1880, 1894);
        addBond(1881, 1883);
        addBond(1881, 1895);
        addBond(1882, 1888);
        addBond(1883, 1896);
        addBond(1883, 1885);
        addBond(1883, 1897);
        addBond(1884, 1898);
        addBond(1884, 1899);
        addBond(1885, 1900);
        addBond(1885, 1889);
        addBond(1887, 1901);
        addBond(1888, 1902);
        addBond(1890, 1903);
        addBond(1891, 1903);
        addBond(1891, 1895);
        addBond(1891, 1904);
        addBond(1892, 1904);
        addBond(1892, 1894);
        addBond(1892, 1896);
        addBond(1893, 1905);
        addBond(1893, 1898);
        addBond(1894, 1901);
        addBond(1894, 1905);
        addBond(1895, 1906);
        addBond(1897, 1907);
        addBond(1897, 1908);
        addBond(1899, 1909);
        addBond(1900, 1909);
        addBond(1901, 1910);
        addBond(1902, 1910);
        addBond(1903, 1911);
        addBond(1904, 1912);
        addBond(1904, 1913);
        addBond(1905, 1914);
        addBond(1905, 1907);
        addBond(1905, 1915);
        addBond(1906, 1916);
        addBond(1906, 1917);
        addBond(1908, 1910);
        addBond(1908, 1920);
        addBond(1909, 1934);
        addBond(1910, 1934);
        addBond(1910, 1912);
        addBond(1910, 1914);
        addBond(1911, 1920);
        addBond(1911, 1916);
        addBond(1915, 1935);
        addBond(1915, 1936);
        addBond(1918, 1933);
        addBond(1919, 1939);
        addBond(1919, 1940);
        addBond(1920, 1923);
        addBond(1921, 1923);
        addBond(1922, 1927);
        addBond(1923, 1945);
        addBond(1923, 1974);
        addBond(1925, 2044);
        addBond(1925, 1931);
        addBond(1926, 2001);
        addBond(1927, 1929);
        addBond(1929, 1941);
        addBond(1930, 1995);
        addBond(1930, 1933);
        addBond(1931, 1974);
        addBond(1932, 1937);
        addBond(1933, 1940);
        addBond(1933, 1943);
        addBond(1935, 1940);
        addBond(1936, 1967);
        addBond(1936, 1938);
        addBond(1939, 1944);
        addBond(1942, 2554);
        addBond(1943, 2554);
        addBond(1946, 1948);
        addBond(1948, 1979);
        addBond(1949, 1975);
        addBond(1950, 1968);
        addBond(1951, 1959);
        addBond(1951, 1979);
        addBond(1952, 1962);
        addBond(1954, 1965);
        addBond(1956, 1958);
        addBond(1956, 1963);
        addBond(1957, 1982);
        addBond(1959, 1967);
        addBond(1960, 1968);
        addBond(1961, 1963);
        addBond(1962, 1970);
        addBond(1963, 1991);
        addBond(1963, 1976);
        addBond(1965, 2025);
        addBond(1966, 1971);
        addBond(1968, 1977);
        addBond(1969, 1973);
        addBond(1970, 1995);
        addBond(1970, 2050);
        addBond(1972, 1977);
        addBond(1975, 1978);
        addBond(1977, 1983);
        addBond(1980, 2045);
        addBond(1982, 2014);
        addBond(1983, 1998);
        addBond(1983, 1992);
        addBond(1984, 1986);
        addBond(1984, 1993);
        addBond(1985, 1989);
        addBond(1986, 1988);
        addBond(1986, 2017);
        addBond(1987, 2018);
        addBond(1988, 2004);
        addBond(1990, 2013);
        addBond(1990, 1992);
        addBond(1992, 1994);
        addBond(1993, 1999);
        addBond(1995, 2002);
        addBond(1995, 1997);
        addBond(1996, 1998);
        addBond(1997, 2010);
        addBond(1998, 2004);
        addBond(1999, 2045);
        addBond(2001, 2007);
        addBond(2001, 2003);
        addBond(2002, 2005);
        addBond(2005, 2007);
        addBond(2007, 2009);
        addBond(2007, 2041);
        addBond(2008, 2011);
        addBond(2008, 2030);
        addBond(2010, 2012);
        addBond(2011, 2015);
        addBond(2011, 2024);
        addBond(2012, 2014);
        addBond(2014, 2016);
        addBond(2015, 2017);
        addBond(2015, 2021);
        addBond(2017, 2019);
        addBond(2018, 2021);
        addBond(2019, 2025);
        addBond(2019, 2023);
        addBond(2020, 2029);
        addBond(2023, 2026);
        addBond(2023, 2036);
        addBond(2024, 2043);
        addBond(2025, 2029);
        addBond(2026, 2034);
        addBond(2026, 2028);
        addBond(2029, 2032);
        addBond(2030, 2037);
        addBond(2030, 2033);
        addBond(2031, 2036);
        addBond(2032, 2034);
        addBond(2036, 2039);
        addBond(2039, 2044);
        addBond(2042, 2046);
        addBond(2051, 2055);
        addBond(2051, 2083);
        addBond(2051, 2097);
        addBond(2052, 2054);
        addBond(2052, 2056);
        addBond(2053, 2060);
        addBond(2054, 2056);
        addBond(2054, 2100);
        addBond(2055, 2057);
        addBond(2056, 2058);
        addBond(2056, 2101);
        addBond(2057, 2059);
        addBond(2057, 2120);
        addBond(2058, 2079);
        addBond(2059, 2080);
        addBond(2059, 2083);
        addBond(2060, 2062);
        addBond(2060, 2068);
        addBond(2061, 2065);
        addBond(2062, 2064);
        addBond(2062, 2067);
        addBond(2064, 2066);
        addBond(2064, 2071);
        addBond(2065, 2067);
        addBond(2065, 2102);
        addBond(2066, 2121);
        addBond(2067, 2069);
        addBond(2067, 2073);
        addBond(2068, 2070);
        addBond(2068, 2074);
        addBond(2069, 2071);
        addBond(2069, 2098);
        addBond(2070, 2103);
        addBond(2071, 2073);
        addBond(2071, 2076);
        addBond(2073, 2075);
        addBond(2073, 2099);
        addBond(2074, 2076);
        addBond(2074, 2094);
        addBond(2075, 2077);
        addBond(2076, 2078);
        addBond(2076, 2095);
        addBond(2077, 2089);
        addBond(2079, 2082);
        addBond(2080, 2085);
        addBond(2080, 2087);
        addBond(2080, 2092);
        addBond(2081, 2087);
        addBond(2082, 2086);
        addBond(2083, 2086);
        addBond(2083, 2087);
        addBond(2083, 2093);
        addBond(2084, 2091);
        addBond(2085, 2096);
        addBond(2087, 2089);
        addBond(2087, 2090);
        addBond(2087, 2119);
        addBond(2088, 2091);
        addBond(2088, 2117);
        addBond(2089, 2091);
        addBond(2089, 2118);
        addBond(2090, 2116);
        addBond(2091, 2093);
        addBond(2091, 2095);
        addBond(2091, 2114);
        addBond(2092, 2094);
        addBond(2092, 2113);
        addBond(2093, 2095);
        addBond(2093, 2112);
        addBond(2094, 2115);
        addBond(2095, 2097);
        addBond(2095, 2099);
        addBond(2095, 2111);
        addBond(2096, 2098);
        addBond(2096, 2109);
        addBond(2097, 2099);
        addBond(2097, 2108);
        addBond(2098, 2110);
        addBond(2099, 2101);
        addBond(2099, 2103);
        addBond(2099, 2107);
        addBond(2100, 2102);
        addBond(2100, 2105);
        addBond(2101, 2103);
        addBond(2101, 2104);
        addBond(2102, 2106);
        addBond(2119, 2121);
        addBond(2121, 2163);
        addBond(2121, 2165);
        addBond(2122, 2124);
        addBond(2122, 2128);
        addBond(2122, 2181);
        addBond(2123, 2125);
        addBond(2123, 2132);
        addBond(2123, 2179);
        addBond(2124, 2134);
        addBond(2125, 2127);
        addBond(2125, 2128);
        addBond(2125, 2130);
        addBond(2125, 2139);
        addBond(2126, 2129);
        addBond(2126, 2140);
        addBond(2126, 2193);
        addBond(2127, 2133);
        addBond(2127, 2199);
        addBond(2128, 2135);
        addBond(2128, 2167);
        addBond(2128, 2181);
        addBond(2129, 2131);
        addBond(2129, 2132);
        addBond(2129, 2142);
        addBond(2130, 2134);
        addBond(2130, 2176);
        addBond(2130, 2211);
        addBond(2131, 2135);
        addBond(2131, 2173);
        addBond(2132, 2134);
        addBond(2132, 2155);
        addBond(2133, 2221);
        addBond(2134, 2136);
        addBond(2134, 2170);
        addBond(2135, 2143);
        addBond(2135, 2178);
        addBond(2135, 2194);
        addBond(2136, 2138);
        addBond(2136, 2139);
        addBond(2136, 2141);
        addBond(2136, 2236);
        addBond(2137, 2140);
        addBond(2137, 2145);
        addBond(2137, 2159);
        addBond(2138, 2207);
        addBond(2138, 2208);
        addBond(2139, 2143);
        addBond(2139, 2224);
        addBond(2140, 2142);
        addBond(2140, 2146);
        addBond(2140, 2175);
        addBond(2141, 2143);
        addBond(2141, 2174);
        addBond(2142, 2144);
        addBond(2143, 2147);
        addBond(2144, 2235);
        addBond(2144, 2147);
        addBond(2144, 2160);
        addBond(2145, 2237);
        addBond(2145, 2147);
        addBond(2145, 2161);
        addBond(2146, 2148);
        addBond(2147, 2244);
        addBond(2148, 2156);
        addBond(2148, 2203);
        addBond(2149, 2151);
        addBond(2149, 2152);
        addBond(2149, 2153);
        addBond(2150, 2249);
        addBond(2150, 2157);
        addBond(2150, 2219);
        addBond(2151, 2246);
        addBond(2151, 2198);
        addBond(2151, 2225);
        addBond(2152, 2250);
        addBond(2152, 2158);
        addBond(2152, 2202);
        addBond(2153, 2156);
        addBond(2153, 2201);
        addBond(2154, 2156);
        addBond(2154, 2197);
        addBond(2155, 2221);
        addBond(2158, 2206);
        addBond(2158, 2298);
        addBond(2158, 2222);
        addBond(2161, 2166);
        addBond(2162, 2169);
        addBond(2163, 2168);
        addBond(2164, 2167);
        addBond(2165, 2167);
        addBond(2165, 2169);
        addBond(2165, 2171);
        addBond(2166, 2168);
        addBond(2167, 2169);
        addBond(2167, 2182);
        addBond(2168, 2172);
        addBond(2169, 2183);
        addBond(2169, 2184);
        addBond(2169, 2185);
        addBond(2170, 2178);
        addBond(2170, 2185);
        addBond(2171, 2185);
        addBond(2172, 2177);
        addBond(2172, 2184);
        addBond(2172, 2209);
        addBond(2173, 2177);
        addBond(2173, 2195);
        addBond(2173, 2210);
        addBond(2174, 2176);
        addBond(2174, 2196);
        addBond(2174, 2212);
        addBond(2175, 2208);
        addBond(2175, 2213);
        addBond(2176, 2178);
        addBond(2176, 2190);
        addBond(2177, 2186);
        addBond(2178, 2180);
        addBond(2178, 2183);
        addBond(2178, 2189);
        addBond(2179, 2184);
        addBond(2179, 2217);
        addBond(2179, 2218);
        addBond(2180, 2182);
        addBond(2180, 2192);
        addBond(2181, 2183);
        addBond(2181, 2188);
        addBond(2183, 2191);
        addBond(2184, 2187);
        addBond(2191, 2200);
        addBond(2192, 2200);
        addBond(2192, 2206);
        addBond(2192, 2223);
        addBond(2196, 2198);
        addBond(2196, 2202);
        addBond(2196, 2204);
        addBond(2197, 2199);
        addBond(2198, 2200);
        addBond(2199, 2225);
        addBond(2200, 2202);
        addBond(2200, 2205);
        addBond(2200, 2215);
        addBond(2202, 2204);
        addBond(2202, 2205);
        addBond(2202, 2301);
        addBond(2203, 2248);
        addBond(2203, 2220);
        addBond(2204, 2284);
        addBond(2204, 2216);
        addBond(2205, 2207);
        addBond(2213, 2284);
        addBond(2225, 2227);
        addBond(2225, 2313);
        addBond(2225, 2230);
        addBond(2225, 2264);
        addBond(2226, 2228);
        addBond(2226, 2229);
        addBond(2226, 2270);
        addBond(2227, 2317);
        addBond(2227, 2231);
        addBond(2227, 2267);
        addBond(2228, 2316);
        addBond(2231, 2320);
        addBond(2231, 2324);
        addBond(2231, 2233);
        addBond(2231, 2285);
        addBond(2233, 2235);
        addBond(2233, 2236);
        addBond(2233, 2237);
        addBond(2233, 2240);
        addBond(2234, 2241);
        addBond(2234, 2272);
        addBond(2236, 2243);
        addBond(2236, 2273);
        addBond(2237, 2239);
        addBond(2237, 2240);
        addBond(2237, 2242);
        addBond(2237, 2289);
        addBond(2238, 2241);
        addBond(2238, 2274);
        addBond(2238, 2287);
        addBond(2240, 2244);
        addBond(2240, 2275);
        addBond(2241, 2243);
        addBond(2241, 2276);
        addBond(2241, 2286);
        addBond(2242, 2244);
        addBond(2242, 2277);
        addBond(2243, 2245);
        addBond(2244, 2291);
        addBond(2245, 2247);
        addBond(2245, 2248);
        addBond(2245, 2302);
        addBond(2246, 2249);
        addBond(2246, 2254);
        addBond(2247, 2250);
        addBond(2247, 2253);
        addBond(2248, 2251);
        addBond(2248, 2299);
        addBond(2249, 2251);
        addBond(2249, 2284);
        addBond(2250, 2261);
        addBond(2251, 2253);
        addBond(2251, 2254);
        addBond(2251, 2257);
        addBond(2251, 2271);
        addBond(2252, 2258);
        addBond(2252, 2278);
        addBond(2253, 2260);
        addBond(2253, 2303);
        addBond(2254, 2256);
        addBond(2254, 2257);
        addBond(2254, 2259);
        addBond(2254, 2265);
        addBond(2255, 2258);
        addBond(2255, 2266);
        addBond(2255, 2279);
        addBond(2257, 2261);
        addBond(2257, 2280);
        addBond(2258, 2260);
        addBond(2258, 2268);
        addBond(2259, 2261);
        addBond(2259, 2281);
        addBond(2260, 2262);
        addBond(2261, 2269);
        addBond(2262, 2312);
        addBond(2262, 2264);
        addBond(2262, 2265);
        addBond(2262, 2267);
        addBond(2263, 2266);
        addBond(2263, 2297);
        addBond(2265, 2269);
        addBond(2265, 2282);
        addBond(2266, 2268);
        addBond(2266, 2296);
        addBond(2267, 2269);
        addBond(2267, 2283);
        addBond(2268, 2270);
        addBond(2277, 2304);
        addBond(2277, 2309);
        addBond(2277, 2310);
        addBond(2283, 2300);
        addBond(2284, 2286);
        addBond(2284, 2290);
        addBond(2284, 2294);
        addBond(2285, 2291);
        addBond(2285, 2293);
        addBond(2286, 2288);
        addBond(2286, 2291);
        addBond(2286, 2295);
        addBond(2287, 2321);
        addBond(2287, 2290);
        addBond(2288, 2290);
        addBond(2289, 2323);
        addBond(2290, 2292);
        addBond(2291, 2320);
        addBond(2299, 2304);
        addBond(2299, 2307);
        addBond(2299, 2308);
        addBond(2300, 2304);
        addBond(2300, 2305);
        addBond(2300, 2306);
        addBond(2303, 2311);
        addBond(2311, 2315);
        addBond(2312, 2314);
        addBond(2312, 2315);
        addBond(2312, 2318);
        addBond(2313, 2316);
        addBond(2313, 2319);
        addBond(2313, 2348);
        addBond(2314, 2317);
        addBond(2314, 2349);
        addBond(2315, 2317);
        addBond(2315, 2347);
        addBond(2316, 2332);
        addBond(2319, 2321);
        addBond(2319, 2322);
        addBond(2320, 2328);
        addBond(2321, 2327);
        addBond(2322, 2326);
        addBond(2323, 2325);
        addBond(2323, 2326);
        addBond(2323, 2329);
        addBond(2324, 2338);
        addBond(2324, 2327);
        addBond(2324, 2330);
        addBond(2325, 2336);
        addBond(2325, 2328);
        addBond(2326, 2341);
        addBond(2327, 2341);
        addBond(2327, 2331);
        addBond(2331, 2339);
        addBond(2331, 2333);
        addBond(2331, 2334);
        addBond(2332, 2347);
        addBond(2334, 2336);
        addBond(2334, 2337);
        addBond(2334, 2338);
        addBond(2334, 2357);
        addBond(2335, 2345);
        addBond(2335, 2346);
        addBond(2336, 2353);
        addBond(2336, 2341);
        addBond(2336, 2358);
        addBond(2337, 2343);
        addBond(2337, 2344);
        addBond(2338, 2355);
        addBond(2338, 2340);
        addBond(2338, 2349);
        addBond(2339, 2356);
        addBond(2339, 2347);
        addBond(2339, 2348);
        addBond(2340, 2342);
        addBond(2346, 2351);
        addBond(2347, 2350);
        addBond(2347, 2359);
        addBond(2348, 2350);
        addBond(2348, 2352);
        addBond(2353, 2355);
        addBond(2353, 2356);
        addBond(2356, 2360);
        addBond(2357, 2360);
        addBond(2360, 2362);
        addBond(2360, 2363);
        addBond(2360, 2365);
        addBond(2360, 2401);
        addBond(2361, 2392);
        addBond(2361, 2405);
        addBond(2361, 2406);
        addBond(2362, 2364);
        addBond(2362, 2395);
        addBond(2362, 2402);
        addBond(2364, 2391);
        addBond(2364, 2403);
        addBond(2364, 2404);
        addBond(2365, 2367);
        addBond(2365, 2368);
        addBond(2366, 2379);
        addBond(2367, 2380);
        addBond(2368, 2370);
        addBond(2368, 2374);
        addBond(2368, 2381);
        addBond(2368, 2482);
        addBond(2369, 2371);
        addBond(2369, 2372);
        addBond(2369, 2488);
        addBond(2370, 2378);
        addBond(2370, 2382);
        addBond(2370, 2485);
        addBond(2371, 2377);
        addBond(2372, 2376);
        addBond(2372, 2481);
        addBond(2373, 2375);
        addBond(2373, 2376);
        addBond(2373, 2383);
        addBond(2374, 2377);
        addBond(2374, 2384);
        addBond(2374, 2408);
        addBond(2375, 2378);
        addBond(2375, 2409);
        addBond(2376, 2378);
        addBond(2376, 2407);
        addBond(2377, 2410);
        addBond(2378, 2380);
        addBond(2378, 2409);
        addBond(2378, 2410);
        addBond(2379, 2407);
        addBond(2379, 2408);
        addBond(2384, 2386);
        addBond(2384, 2390);
        addBond(2384, 2396);
        addBond(2384, 2538);
        addBond(2385, 2387);
        addBond(2385, 2388);
        addBond(2385, 2545);
        addBond(2386, 2394);
        addBond(2386, 2541);
        addBond(2387, 2393);
        addBond(2388, 2392);
        addBond(2388, 2543);
        addBond(2389, 2391);
        addBond(2389, 2392);
        addBond(2389, 2397);
        addBond(2390, 2393);
        addBond(2390, 2398);
        addBond(2391, 2394);
        addBond(2392, 2395);
        addBond(2393, 2395);
        addBond(2393, 2399);
        addBond(2394, 2400);
        addBond(2400, 2554);
        addBond(2401, 2554);
        addBond(2406, 2412);
        addBond(2406, 2413);
        addBond(2407, 2411);
        addBond(2407, 2415);
        addBond(2408, 2411);
        addBond(2408, 2416);
        addBond(2409, 2412);
        addBond(2409, 2414);
        addBond(2416, 2508);
        addBond(2416, 2510);
        addBond(2417, 2419);
        addBond(2417, 2423);
        addBond(2417, 2527);
        addBond(2418, 2420);
        addBond(2418, 2427);
        addBond(2418, 2525);
        addBond(2419, 2429);
        addBond(2420, 2422);
        addBond(2420, 2423);
        addBond(2420, 2425);
        addBond(2420, 2434);
        addBond(2421, 2424);
        addBond(2421, 2435);
        addBond(2421, 2552);
        addBond(2422, 2428);
        addBond(2422, 2559);
        addBond(2423, 2430);
        addBond(2423, 2512);
        addBond(2423, 2527);
        addBond(2424, 2426);
        addBond(2424, 2427);
        addBond(2424, 2437);
        addBond(2425, 2429);
        addBond(2425, 2522);
        addBond(2425, 2572);
        addBond(2426, 2430);
        addBond(2426, 2518);
        addBond(2427, 2429);
        addBond(2427, 2467);
        addBond(2428, 2587);
        addBond(2429, 2431);
        addBond(2429, 2515);
        addBond(2430, 2438);
        addBond(2430, 2524);
        addBond(2430, 2553);
        addBond(2431, 2433);
        addBond(2431, 2434);
        addBond(2431, 2436);
        addBond(2431, 2442);
        addBond(2432, 2435);
        addBond(2432, 2443);
        addBond(2432, 2492);
        addBond(2433, 2567);
        addBond(2433, 2568);
        addBond(2434, 2438);
        addBond(2434, 2590);
        addBond(2435, 2437);
        addBond(2435, 2445);
        addBond(2435, 2521);
        addBond(2436, 2438);
        addBond(2436, 2520);
        addBond(2437, 2439);
        addBond(2438, 2446);
        addBond(2439, 2441);
        addBond(2439, 2442);
        addBond(2439, 2444);
        addBond(2439, 2450);
        addBond(2440, 2443);
        addBond(2440, 2451);
        addBond(2440, 2493);
        addBond(2442, 2446);
        addBond(2442, 2494);
        addBond(2443, 2445);
        addBond(2443, 2453);
        addBond(2443, 2495);
        addBond(2444, 2446);
        addBond(2444, 2496);
        addBond(2445, 2447);
        addBond(2446, 2454);
        addBond(2447, 2449);
        addBond(2447, 2450);
        addBond(2447, 2452);
        addBond(2447, 2542);
        addBond(2448, 2451);
        addBond(2448, 2497);
        addBond(2448, 2540);
        addBond(2450, 2454);
        addBond(2450, 2498);
        addBond(2451, 2453);
        addBond(2451, 2499);
        addBond(2451, 2539);
        addBond(2452, 2454);
        addBond(2452, 2500);
        addBond(2453, 2455);
        addBond(2454, 2544);
        addBond(2455, 2457);
        addBond(2455, 2458);
        addBond(2455, 2462);
        addBond(2455, 2584);
        addBond(2456, 2463);
        addBond(2456, 2472);
        addBond(2457, 2466);
        addBond(2457, 2471);
        addBond(2457, 2564);
        addBond(2458, 2468);
        addBond(2458, 2563);
        addBond(2459, 2461);
        addBond(2459, 2462);
        addBond(2459, 2464);
        addBond(2460, 2463);
        addBond(2460, 2490);
        addBond(2460, 2583);
        addBond(2461, 2558);
        addBond(2462, 2469);
        addBond(2462, 2575);
        addBond(2463, 2466);
        addBond(2463, 2491);
        addBond(2463, 2562);
        addBond(2464, 2468);
        addBond(2464, 2561);
        addBond(2465, 2469);
        addBond(2465, 2519);
        addBond(2466, 2468);
        addBond(2466, 2557);
        addBond(2467, 2587);
        addBond(2468, 2479);
        addBond(2469, 2471);
        addBond(2469, 2472);
        addBond(2469, 2475);
        addBond(2469, 2489);
        addBond(2470, 2476);
        addBond(2470, 2501);
        addBond(2471, 2478);
        addBond(2471, 2586);
        addBond(2472, 2474);
        addBond(2472, 2475);
        addBond(2472, 2477);
        addBond(2472, 2483);
        addBond(2473, 2476);
        addBond(2473, 2484);
        addBond(2473, 2502);
        addBond(2475, 2479);
        addBond(2475, 2503);
        addBond(2476, 2478);
        addBond(2476, 2486);
        addBond(2477, 2479);
        addBond(2477, 2504);
        addBond(2478, 2480);
        addBond(2479, 2487);
        addBond(2480, 2482);
        addBond(2480, 2483);
        addBond(2480, 2485);
        addBond(2481, 2484);
        addBond(2481, 2550);
        addBond(2483, 2487);
        addBond(2483, 2505);
        addBond(2484, 2486);
        addBond(2484, 2549);
        addBond(2485, 2487);
        addBond(2485, 2506);
        addBond(2486, 2488);
        addBond(2491, 2566);
        addBond(2491, 2569);
        addBond(2491, 2588);
        addBond(2500, 2591);
        addBond(2500, 2596);
        addBond(2506, 2511);
        addBond(2507, 2514);
        addBond(2508, 2513);
        addBond(2509, 2512);
        addBond(2510, 2512);
        addBond(2510, 2514);
        addBond(2510, 2516);
        addBond(2511, 2513);
        addBond(2512, 2514);
        addBond(2512, 2528);
        addBond(2513, 2517);
        addBond(2514, 2529);
        addBond(2514, 2530);
        addBond(2514, 2531);
        addBond(2515, 2524);
        addBond(2515, 2531);
        addBond(2516, 2531);
        addBond(2517, 2523);
        addBond(2517, 2530);
        addBond(2517, 2570);
        addBond(2518, 2565);
        addBond(2518, 2576);
        addBond(2518, 2577);
        addBond(2519, 2523);
        addBond(2519, 2555);
        addBond(2519, 2571);
        addBond(2520, 2522);
        addBond(2520, 2556);
        addBond(2520, 2573);
        addBond(2521, 2568);
        addBond(2521, 2574);
        addBond(2522, 2524);
        addBond(2522, 2536);
        addBond(2523, 2532);
        addBond(2524, 2526);
        addBond(2524, 2529);
        addBond(2524, 2535);
        addBond(2525, 2530);
        addBond(2525, 2581);
        addBond(2525, 2582);
        addBond(2526, 2528);
        addBond(2526, 2551);
        addBond(2527, 2529);
        addBond(2527, 2534);
        addBond(2529, 2537);
        addBond(2530, 2533);
        addBond(2537, 2539);
        addBond(2537, 2543);
        addBond(2537, 2547);
        addBond(2538, 2544);
        addBond(2538, 2546);
        addBond(2539, 2541);
        addBond(2539, 2544);
        addBond(2539, 2548);
        addBond(2540, 2543);
        addBond(2541, 2543);
        addBond(2543, 2545);
        addBond(2550, 2560);
        addBond(2551, 2560);
        addBond(2551, 2566);
        addBond(2551, 2589);
        addBond(2556, 2558);
        addBond(2556, 2562);
        addBond(2556, 2564);
        addBond(2557, 2559);
        addBond(2558, 2560);
        addBond(2560, 2562);
        addBond(2560, 2565);
        addBond(2560, 2578);
        addBond(2562, 2564);
        addBond(2562, 2565);
        addBond(2562, 2579);
        addBond(2563, 2585);
        addBond(2564, 2580);
        addBond(2565, 2567);
        addBond(2576, 2591);
        addBond(2576, 2594);
        addBond(2576, 2595);
        addBond(2578, 2591);
        addBond(2578, 2592);
        addBond(2578, 2593);
    }
}

