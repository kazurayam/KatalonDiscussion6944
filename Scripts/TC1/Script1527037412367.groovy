import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

System.setProperty('webdriver.chrome.driver', "C:/Katalon_Studio_Windows_64-5.4.1/configuration/resources/drivers/chromedriver_win32/chromedriver.exe")
System.setProperty('webdriver.chrome.logfile', 'C:/temp/chromedriver_TC1.log')

//def chromeBinaryPath = 'C:/Program Files (x86)/Google/Chrome/Application/chrome.exe'  // ver: latest( 66.0.3359.181)
def chromeBinaryPath = 'C:/Users/qcq0264/AppData/Local/Google/Chrome/_Application_/new_chrome.exe'  // ver: 65.0.3325.146

// see http://chromedriver.chromium.org/capabilities 
ChromeOptions options = new ChromeOptions()
options.setBinary(new File(chromeBinaryPath))

// open Chrome browser specifying the location of chrome binary
WebDriver driver = new ChromeDriver(options)

// let Katalon Studio use the Chrome browser activated by this script
DriverFactory.changeWebDriver(driver)
WebUI.comment(">>> opened Chrome browser at ${chromeBinaryPath}")

// execute some steps
WebUI.navigateToUrl('http://demoaut.katalon.com')
WebUI.verifyElementPresent(findTestObject('Page_CURA Healthcare Service/a_Make Appointment'), 20)

// close the browser
WebUI.closeBrowser()
