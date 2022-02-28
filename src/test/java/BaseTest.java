import com.thoughtworks.gauge.Logger;
import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Random;

public class BaseTest extends BasePage {
    @Step("<wait> saniye kadar bekle")
    public void waitSecond(int wait) throws InterruptedException {
        Thread.sleep(1000 * wait);
    }

    @Step("<id> li uygulama kontrolü")
    public void homeControl(String id) {
        String checkText = appiumDriver.findElement(By.id(id)).getText();
        Assert.assertEquals("ALIŞVERİŞE BAŞLA", checkText);
    }

    @Step("<id> li uygulama giriş sayfası kontrolü")
    public void loginControl(String id) {
        String checkText = appiumDriver.findElement(By.id(id)).getText();
        Logger.info("Anasayfa açıldı");
    }


    @Step("<asagıya kaydır> aşağı kaydırma çalıştırıldı")
    public void swipe(String swipe) {
        TouchAction ts = new TouchAction(appiumDriver);
        ts.press(PointOption.point(530, 1900)).moveTo(PointOption.point(530, 400)).release().perform();
        Logger.info("Aşağıya kaydırıldı");

    }

    @Step("<Rastgele bir ürün seç> rastgele ürün secildi")
    public void selectRandom(String random) {
        Random rdn = new Random();
        List<MobileElement> pd = appiumDriver.findElements(By.xpath(random));
        System.out.println("pd" + pd);
        MobileElement element = pd.get(rdn.nextInt(pd.size()));
        System.out.println("element" + element);
        element.click();

    }
    @Step("id <id> li elemente tıkla")
    public void clickByid(String id) {
        appiumDriver.findElement(By.id(id)).click();
        System.out.println(id + "elementine tıklandı");

    }
    @Step("xpath <xpath> li elemente tıkla")
    public void clickXpath(String xpath){
        appiumDriver.findElement(By.xpath(xpath)).click();

    }
    @Step("<id> İd'li elemente <text> değerini yaz")
    public void yaz(String id,String text){
        appiumDriver.findElement(By.id(id)).sendKeys(text);
        System.out.println(id + "elementini bul ve " + text + " değerini yaz"  );
        Logger.info("Kullanıcı adı ve şifre yazıldı.");
    }

}
