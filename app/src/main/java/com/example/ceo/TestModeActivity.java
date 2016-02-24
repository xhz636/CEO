package com.example.ceo;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.CameraBridgeViewBase;
import org.opencv.android.CameraBridgeViewBase.CvCameraViewFrame;
import org.opencv.android.CameraBridgeViewBase.CvCameraViewListener2;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.android.OpenCVLoader;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

import java.util.List;

public class TestModeActivity extends Activity implements CvCameraViewListener2, OnTouchListener{

    private Mat mRgba;
    private Mat mSpectrum;
    private Scalar mBlobColorRgba;
    private Scalar mBlobColorHsv;
    private Size SPECTRUM_SIZE;
    private Scalar CONTOUR_COLOR;
    private ColorBlobDetector mDetector;
    private CameraBridgeViewBase mOpenCvCameraView;

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    private Button Find_Black;
    private Button Find_White;
    private Button Find_Red;
    private Button Find_Blue;
    private Button Find_Yellow;
    private Button Find_Green;

    private int Get_Flag = Get_Done;
    private static final int Get_Black = 1;
    private static final int Get_White = 2;
    private static final int Get_Red = 3;
    private static final int Get_Blue = 4;
    private static final int Get_Yellow = 5;
    private static final int Get_Green = 6;
    private static final int Get_Done = 7;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_mode);
        mOpenCvCameraView = (CameraBridgeViewBase) findViewById(R.id.camera_view);
        mOpenCvCameraView.setVisibility(SurfaceView.VISIBLE);
        mOpenCvCameraView.setCvCameraViewListener(this);
        CreateButton();
    }

    void CreateButton() {
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        Find_Black = (Button) findViewById(R.id.find_black);
        Find_Black.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer Color_R, Color_G, Color_B;
                Color_R = pref.getInt("Black_R", 0);
                Color_G = pref.getInt("Black_G", 0);
                Color_B = pref.getInt("Black_B", 0);
                ColorTest(Color_R, Color_G, Color_B);
            }
        });
        Find_White = (Button) findViewById(R.id.find_white);
        Find_White.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer Color_R, Color_G, Color_B;
                Color_R = pref.getInt("White_R", 0);
                Color_G = pref.getInt("White_G", 0);
                Color_B = pref.getInt("White_B", 0);
                ColorTest(Color_R, Color_G, Color_B);
            }
        });
        Find_Red = (Button) findViewById(R.id.find_red);
        Find_Red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer Color_R, Color_G, Color_B;
                Color_R = pref.getInt("Red_R", 0);
                Color_G = pref.getInt("Red_G", 0);
                Color_B = pref.getInt("Red_B", 0);
                ColorTest(Color_R, Color_G, Color_B);
            }
        });
        Find_Blue = (Button) findViewById(R.id.find_blue);
        Find_Blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer Color_R, Color_G, Color_B;
                Color_R = pref.getInt("Blue_R", 0);
                Color_G = pref.getInt("Blue_G", 0);
                Color_B = pref.getInt("Blue_B", 0);
                ColorTest(Color_R, Color_G, Color_B);
            }
        });
        Find_Yellow = (Button) findViewById(R.id.find_yellow);
        Find_Yellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer Color_R, Color_G, Color_B;
                Color_R = pref.getInt("Yellow_R", 0);
                Color_G = pref.getInt("Yellow_G", 0);
                Color_B = pref.getInt("Yellow_B", 0);
                ColorTest(Color_R, Color_G, Color_B);
            }
        });
        Find_Green = (Button) findViewById(R.id.find_green);
        Find_Green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer Color_R, Color_G, Color_B;
                Color_R = pref.getInt("Green_R", 0);
                Color_G = pref.getInt("Green_G", 0);
                Color_B = pref.getInt("Green_B", 0);
                ColorTest(Color_R, Color_G, Color_B);
            }
        });
    }

    @Override
    public void onPause()
    {
        super.onPause();
        if (mOpenCvCameraView != null)
            mOpenCvCameraView.disableView();
    }

    @Override
    public void onResume()
    {
        super.onResume();
        if (!OpenCVLoader.initDebug()) {
            OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_3_0_0, this, mLoaderCallback);
        } else {
            mLoaderCallback.onManagerConnected(LoaderCallbackInterface.SUCCESS);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mOpenCvCameraView != null)
            mOpenCvCameraView.disableView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.test_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.get_balck :
                Get_Flag = Get_Black;
                break;
            case R.id.get_white :
                Get_Flag = Get_White;
                break;
            case R.id.get_red :
                Get_Flag = Get_Red;
                break;
            case R.id.get_blue :
                Get_Flag = Get_Blue;
                break;
            case R.id.get_yellow :
                Get_Flag = Get_Yellow;
                break;
            case R.id.get_green :
                Get_Flag = Get_Green;
                break;
            case R.id.get_done :
                Get_Flag = Get_Done;
                break;
        }
        return true;
    }

    private BaseLoaderCallback mLoaderCallback = new BaseLoaderCallback(this) {
        @Override
        public void onManagerConnected(int status) {
            switch (status) {
                case LoaderCallbackInterface.SUCCESS :
                    mOpenCvCameraView.enableView();
                    mOpenCvCameraView.setOnTouchListener(TestModeActivity.this);
                    break;
                default :
                    super.onManagerConnected(status);
                    break;
            }
        }
    };

    private void ColorTest(int R, int G, int B) {
        mBlobColorRgba.val[0] = R;
        mBlobColorRgba.val[1] = G;
        mBlobColorRgba.val[2] = B;
        mBlobColorHsv = converScalarRgba2Hsv(mBlobColorRgba);
        mDetector.setHsvColor(mBlobColorHsv);
        Imgproc.resize(mDetector.getSpectrum(), mSpectrum, SPECTRUM_SIZE);
    }

    public void onCameraViewStarted(int width, int height) {
        mRgba = new Mat(height, width, CvType.CV_8UC4);
        mSpectrum = new Mat();
        mBlobColorRgba = new Scalar(255);
        mBlobColorHsv = new Scalar(255);
        SPECTRUM_SIZE = new Size(200, 64);
        CONTOUR_COLOR = new Scalar(255, 0, 0, 255);
        mDetector = new ColorBlobDetector();
    }

    public void onCameraViewStopped() {
        mRgba.release();
    }

    public Mat onCameraFrame(CvCameraViewFrame inputFrame) {
        mRgba = inputFrame.rgba();
        mDetector.process(mRgba);
        List<MatOfPoint> contours = mDetector.getContours();
        Imgproc.drawContours(mRgba, contours, -1, CONTOUR_COLOR);
        return mRgba;
    }

    private Scalar converScalarRgba2Hsv(Scalar rgbaColor) {
        Mat pointMatRgba = new Mat(1, 1, CvType.CV_8UC4, rgbaColor);
        Mat pointMatHsv = new Mat();
        Imgproc.cvtColor(pointMatRgba, pointMatHsv, Imgproc.COLOR_RGB2HSV_FULL);
        return new Scalar(pointMatHsv.get(0, 0));
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(Get_Flag == Get_Done)
            return false;
        int cols = mRgba.cols();
        int rows = mRgba.rows();
        int xOffset = (mOpenCvCameraView.getWidth() - cols) / 2;
        int yOffset = (mOpenCvCameraView.getHeight() - rows) / 2;
        int x = (int)event.getX() - xOffset;
        int y = (int)event.getY() - yOffset;
        if ((x < 0) || (y < 0) || (x > cols) || (y > rows))
            return false;
        Rect touchedRect = new Rect();
        touchedRect.x = (x>4) ? x-4 : 0;
        touchedRect.y = (y>4) ? y-4 : 0;
        touchedRect.width = (x+4 < cols) ? x + 4 - touchedRect.x : cols - touchedRect.x;
        touchedRect.height = (y+4 < rows) ? y + 4 - touchedRect.y : rows - touchedRect.y;
        Mat touchedRegionRgba = mRgba.submat(touchedRect);
        Mat touchedRegionHsv = new Mat();
        Imgproc.cvtColor(touchedRegionRgba, touchedRegionHsv, Imgproc.COLOR_RGB2HSV_FULL);
        mBlobColorHsv = Core.sumElems(touchedRegionHsv);
        int pointCount = touchedRect.width*touchedRect.height;
        for (int i = 0; i < mBlobColorHsv.val.length; i++)
            mBlobColorHsv.val[i] /= pointCount;
        mBlobColorRgba = converScalarHsv2Rgba(mBlobColorHsv);
        mDetector.setHsvColor(mBlobColorHsv);
        Imgproc.resize(mDetector.getSpectrum(), mSpectrum, SPECTRUM_SIZE);
        touchedRegionRgba.release();
        touchedRegionHsv.release();
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        editor = pref.edit();
        switch (Get_Flag) {
            case Get_Black :
                editor.putInt("Black_R", (int)mBlobColorRgba.val[0]);
                editor.putInt("Black_G", (int)mBlobColorRgba.val[1]);
                editor.putInt("Black_B", (int)mBlobColorRgba.val[2]);
                editor.commit();
                break;
            case Get_White :
                editor.putInt("White_R", (int)mBlobColorRgba.val[0]);
                editor.putInt("White_G", (int)mBlobColorRgba.val[1]);
                editor.putInt("White_B", (int)mBlobColorRgba.val[2]);
                editor.commit();
                break;
            case Get_Red :
                editor.putInt("Red_R", (int)mBlobColorRgba.val[0]);
                editor.putInt("Red_G", (int)mBlobColorRgba.val[1]);
                editor.putInt("Red_B", (int)mBlobColorRgba.val[2]);
                editor.commit();
                break;
            case Get_Blue :
                editor.putInt("Blue_R", (int)mBlobColorRgba.val[0]);
                editor.putInt("Blue_G", (int)mBlobColorRgba.val[1]);
                editor.putInt("Blue_B", (int)mBlobColorRgba.val[2]);
                editor.commit();
                break;
            case Get_Yellow :
                editor.putInt("Yellow_R", (int)mBlobColorRgba.val[0]);
                editor.putInt("Yellow_G", (int)mBlobColorRgba.val[1]);
                editor.putInt("Yellow_B", (int)mBlobColorRgba.val[2]);
                editor.commit();
                break;
            case Get_Green :
                editor.putInt("Green_R", (int)mBlobColorRgba.val[0]);
                editor.putInt("Green_G", (int)mBlobColorRgba.val[1]);
                editor.putInt("Green_B", (int)mBlobColorRgba.val[2]);
                editor.commit();
                break;
            case Get_Done :
                break;
        }
        return false;
    }

    private Scalar converScalarHsv2Rgba(Scalar hsvColor) {
        Mat pointMatRgba = new Mat();
        Mat pointMatHsv = new Mat(1, 1, CvType.CV_8UC3, hsvColor);
        Imgproc.cvtColor(pointMatHsv, pointMatRgba, Imgproc.COLOR_HSV2RGB_FULL, 4);
        return new Scalar(pointMatRgba.get(0, 0));
    }
}
