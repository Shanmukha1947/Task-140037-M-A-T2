import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Rect;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.objdetect.CascadeClassifier;

public class FacialRecognitionSecurity {
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        // Load pre-trained face detection model
        String faceDetectionModelPath = "haarcascade_frontalface_default.xml";
        CascadeClassifier faceDetector = new CascadeClassifier(faceDetectionModelPath);

        // Test image path
        String testImagePath = "unknown_face.jpg";
        Mat testImage = Imgcodecs.imread(testImagePath);

        if (testImage.empty()) {
            System.out.println("Error: Cannot load image " + testImagePath);
            return;
        }

        // Detect faces in the test image
        MatOfRect faces = new MatOfRect();
        faceDetector.detectMultiScale(testImage, faces);

        // Draw rectangles around detected faces
        for (Rect face : faces.toArray()) {
            System.out.println("Face detected at: " + face.toString());
            // You can add logic here to draw a rectangle or perform further actions
        }

        System.out.println("Face detection completed.");
    }
}
