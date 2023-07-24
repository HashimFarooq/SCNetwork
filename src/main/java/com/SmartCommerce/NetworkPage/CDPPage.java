package com.SmartCommerce.NetworkPage;

import java.time.Duration;
import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v113.network.Network;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CDPPage {

	private ChromeDriver cdriver;

	public CDPPage(ChromeDriver cdriver) {

		this.cdriver = cdriver;
	}

	public void CaptureRequest() {

		DevTools devTool = cdriver.getDevTools();

		devTool.createSession();

		devTool.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

		devTool.addListener(Network.requestWillBeSent(), requestSent -> {

			System.out.println("Request URL => " + requestSent.getRequest().getUrl());

			System.out.println("Request Method => " + requestSent.getRequest().getMethod());

			System.out.println("Request Headers => " + requestSent.getRequest().getHeaders().toString());

			System.out.println("------------------------------------------------------");

		});

		cdriver.get("http://google.com");

	}

	public void CaptureResponse() {

		DevTools devTool = cdriver.getDevTools();

		devTool.createSession();

		devTool.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

		devTool.addListener(Network.responseReceived(), responseReceieved -> {

			System.out.println("Response Url => " + responseReceieved.getResponse().getUrl());

			System.out.println("Response Status => " + responseReceieved.getResponse().getStatus());

			System.out.println("Response Headers => " + responseReceieved.getResponse().getHeaders().toString());

			System.out.println("Response MIME Type => " + responseReceieved.getResponse().getMimeType().toString());

			System.out.println("------------------------------------------------------");

		});

		cdriver.get("http://google.com");

	}

}
