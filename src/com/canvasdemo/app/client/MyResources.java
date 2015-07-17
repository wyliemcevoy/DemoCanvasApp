package com.canvasdemo.app.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface MyResources extends ClientBundle
{
	public static final MyResources INSTANCE = GWT.create(MyResources.class);

	@Source("images/Facebook.png")
	ImageResource facebookImg();

	@Source("images/GitHub.png")
	ImageResource githubImg();

	@Source("images/Google+.png")
	ImageResource googleImg();

	@Source("images/HackerRank.png")
	ImageResource hackerrankImg();

	@Source("images/LinkedIn.png")
	ImageResource linkedinImg();

	@Source("images/Twiter.png")
	ImageResource twiterImg();

	@Source("images/YouTube.png")
	ImageResource youtubeImg();

	@Source("images/StackOverflow.png")
	ImageResource stackOverflowImg();
}