package com.canvasdemo.app.client;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.canvas.dom.client.CssColor;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class DemoCanvasApp implements EntryPoint
{
	private Canvas canvas;
	private Context2d context;
	private static final int canvasHeight = 300;
	private static final int canvasWidth = 300;
	private static final String divTagId = "canvasExample";
	private Image facebookImg, gitHubImg, googleImg, hackerRankImg, linkedInImg, twitterImg, youtubeImg, stackOverflowImg;
	private ClickHandler clickHandler;

	public void onModuleLoad()
	{

		canvas = Canvas.createIfSupported();
		RootPanel.get().setStyleName("body");
		if (canvas == null)
		{
			RootPanel.get().add(new Label("Sorry, your browser doesn't support the HTML5 Canvas element"));
			return;
		}

		canvas.setStyleName("mainCanvas");
		canvas.setWidth(canvasWidth + "px");
		canvas.setCoordinateSpaceWidth(canvasWidth);

		canvas.setHeight(canvasHeight + "px");
		canvas.setCoordinateSpaceHeight(canvasHeight);

		RootPanel.get(divTagId).add(canvas);
		context = canvas.getContext2d();

		final Timer timer = new Timer() {
			@Override
			public void run()
			{
				drawSomethingNew();
			}
		};
		timer.scheduleRepeating(1500);

		initializeSocialMediaLinks();

	}

	public void drawSomethingNew()
	{

		// Get random coordinates and sizing
		int rndX = Random.nextInt(canvasWidth);
		int rndY = Random.nextInt(canvasHeight);
		int rndWidth = Random.nextInt(canvasWidth);
		int rndHeight = Random.nextInt(canvasHeight);

		// Get a random color and alpha transparency
		int rndRedColor = Random.nextInt(255);
		int rndGreenColor = Random.nextInt(255);
		int rndBlueColor = Random.nextInt(255);
		double rndAlpha = Random.nextDouble();

		CssColor randomColor = CssColor.make("rgba(" + rndRedColor + ", " + rndGreenColor + "," + rndBlueColor + ", " + rndAlpha + ")");

		context.setFillStyle(randomColor);
		context.fillRect(rndX, rndY, rndWidth, rndHeight);
		context.fill();
	}

	private void initializeSocialMediaLinks()
	{
		clickHandler = new ClickHandler() {

			@Override
			public void onClick(ClickEvent event)
			{
				Widget sender = (Widget) event.getSource();

				if (sender == facebookImg)
				{
					Window.Location.assign("https://www.facebook.com/wylie.mcevoy");
				} else if (sender == gitHubImg)
				{
					Window.Location.assign("https://github.com/wyliemcevoy");
				} else if (sender == googleImg)
				{
					Window.Location.assign("https://plus.google.com/117493224543245287095/posts");
				} else if (sender == hackerRankImg)
				{
					Window.Location.assign("https://www.hackerrank.com/wylie_mcevoy");
				} else if (sender == linkedInImg)
				{
					Window.Location.assign("https://www.linkedin.com/pub/wylie-mcevoy/6a/528/424");
				} else if (sender == twitterImg)
				{
					Window.Location.assign("https://twitter.com/wyliemcevoy");
				} else if (sender == youtubeImg)
				{
					Window.Location.assign("https://plus.google.com/117493224543245287095/videos");
				} else if (sender == stackOverflowImg)
				{
					Window.Location.assign("http://stackoverflow.com/users/5128812/wylie-mcevoy?tab=profile");
				}
			}
		};

		this.gitHubImg = buildImage(MyResources.INSTANCE.githubImg());
		this.linkedInImg = buildImage(MyResources.INSTANCE.linkedinImg());
		this.stackOverflowImg = buildImage(MyResources.INSTANCE.stackOverflowImg());
		this.hackerRankImg = buildImage(MyResources.INSTANCE.hackerrankImg());
		this.twitterImg = buildImage(MyResources.INSTANCE.twiterImg());
		this.facebookImg = buildImage(MyResources.INSTANCE.facebookImg());
		this.googleImg = buildImage(MyResources.INSTANCE.googleImg());
		this.youtubeImg = buildImage(MyResources.INSTANCE.youtubeImg());

	}

	private Image buildImage(ImageResource imgResource)
	{
		Image image = new Image(imgResource);
		image.addClickHandler(clickHandler);
		image.setStyleName("imageLink");
		RootPanel.get().add(image);
		return image;
	}
}
