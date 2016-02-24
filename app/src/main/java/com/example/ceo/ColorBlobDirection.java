package com.example.ceo;

import org.opencv.core.Core;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Scalar;

import java.util.Iterator;
import java.util.List;

public class ColorBlobDirection {

    public void findCenter(List<MatOfPoint> mContours) {
        Iterator<MatOfPoint> each = mContours.iterator();
        while (each.hasNext()) {
            MatOfPoint contour = each.next();
            Core.multiply(contour, new Scalar(4, 4), contour);
            mContours.add(contour);
        }
    }
}
