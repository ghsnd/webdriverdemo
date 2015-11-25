/**
 Copyright 2015 Ghent University - iMinds

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */

package be.ugent.mmlab.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Demo {
	public void demoTime() throws InterruptedException {
		// initialize web browser.
		WebDriver driver = new FirefoxDriver();

		// go to the Belgian railways website
		driver.get("http://www.belgianrail.be");

		// select "English"
		// HTML:
		// <a
		//   id="ctl00_bodyPlaceholder_languagesList_ctl02_languageNameLink"
		//   href="javascript:__doPostBack('ctl00$bodyPlaceholder$languagesList$ctl02$languageNameLink','')"
		// > English </a>
		WebElement english = driver.findElement(By.id("ctl00_bodyPlaceholder_languagesList_ctl02_languageNameLink"));
		english.click();

		// fill out departure
		WebElement from = driver.findElement(By.id("departureStationInput"));
		from.sendKeys("Gent-Dampoort");

		// pause for a second to make it not too fast
		Thread.sleep(1000);
		// click in the field to get the auto-completion away
		from.click();

		// fill out arrival
		WebElement to = driver.findElement(By.id("arrivalStationInput"));
		to.sendKeys("Brussel-Noord");

		Thread.sleep(1000);
		to.click();

		// click timetable button
		WebElement timetableButton = driver.findElement(By.id("ctl00_ctl00_bodyPlaceholder_bodyPlaceholder_mobilityTimeTableSearch_HomeTabTimeTable1_submitButton"));
		timetableButton.click();

		// get departure info
		// HTML:
		// <td headers="hafasOVTimeOUTWARD" class="time">
		//	 <div>
		//     <div class="planed overviewDep">
		//		10:00 dep <span class="bold prognosis">+12 min.</span>
		//     </div>
		//     <div class="planed">
		//		11:20 arr <span class="bold green">+0 min.</span>
		//     </div>
		//   </div>
		// </td>
		List<WebElement> timeCells = driver.findElements(By.className("time"));
		for (WebElement timeCell : timeCells) {
			List<WebElement> times = timeCell.findElements(By.className("planed"));
			System.out.println("----------------------------------------------");
			System.out.println("departure time: " + times.get(0).getText());
			System.out.println("arrival time:   " + times.get(1).getText());
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Demo demo = new Demo();
		demo.demoTime();
	}
}
