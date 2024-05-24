package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager {
    private static ExtentReports extent;
    private static ExtentTest test;

    // Specify the directory where you want to store the reports
    private static final String REPORT_DIRECTORY = "src/test/resources/reporting/";

    public static ExtentReports getExtentReports() {
        if (extent == null) {
            // Generate timestamp
            String timestamp = new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date());

            // Append timestamp to file name and include the directory path
            String reportFileName = REPORT_DIRECTORY + "extentReport_" + timestamp + ".html";

            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportFileName);
            sparkReporter.config().setTheme(Theme.DARK);
            sparkReporter.config().setDocumentTitle("Automation Report");
            sparkReporter.config().setReportName("Extent Reports");
            sparkReporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            extent.setSystemInfo("Tester", "Arun Wakekar");
            extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("Java Version", System.getProperty("java.version"));
            extent.setSystemInfo("Host Name", System.getenv("COMPUTERNAME"));
            extent.setSystemInfo("User Name", System.getProperty("user.name"));
        }
        return extent;
    }

    public static ExtentTest getTest() {
        return test;
    }

    public static void setTest(ExtentTest test) {
        ExtentManager.test = test;
    }
}
