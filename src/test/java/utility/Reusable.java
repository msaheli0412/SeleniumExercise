package utility;

import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Reusable {

	public WebDriver driver;

	public Reusable(WebDriver driver) {
		this.driver = driver;
	}

	public void getScreenshot(String filename) throws Exception {
		Screenshot s=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(2000)).takeScreenshot(driver);
        ImageIO.write(s.getImage(),"PNG",new File(".//IBM_screenshot//" + filename + ".png"));
        
	}

}
