package org.usfirst.frc.team3418.robot;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;

public class Vision {

	static Vision mInstance = new Vision();

    public static Vision getInstance() {
        return mInstance;
    }
    
	UsbCamera camera;
	CvSink cvSink;
	CvSource outputStream;
	Mat source;
	Mat output;
	
	public Vision(){
        camera = CameraServer.getInstance().startAutomaticCapture("camera 0", 0);
        camera.setResolution(640, 480);
        camera.setFPS(30);
        
        source = new Mat();
        output = new Mat();
		
		new Thread(() -> {
            cvSink = CameraServer.getInstance().getVideo();
            outputStream = CameraServer.getInstance().putVideo("Blur", 640, 480);

            while(!Thread.interrupted()) {
                cvSink.grabFrame(source);
                Imgproc.cvtColor(source, output, Imgproc.COLOR_BGR2GRAY);
                outputStream.putFrame(output);
            }
        }).start();
	}
}