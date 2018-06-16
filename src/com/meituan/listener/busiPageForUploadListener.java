package com.meituan.listener;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.meituan.utils.FileUploadAppProperties;

/**
 * Application Lifecycle Listener implementation class busiPageForUploadListener
 *
 */
@WebListener
public class busiPageForUploadListener implements ServletContextListener
{

	/**
	 * Default constructor.
	 */
	public busiPageForUploadListener()
	{
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce)
	{
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce)
	{
		InputStream in = getClass().getClassLoader().getResourceAsStream("/upload.properties");

		Properties properties = new Properties();
		try
		{
			properties.load(in);

			for (Map.Entry<Object, Object> prop : properties.entrySet())
			{
				String propertyName = (String) prop.getKey();
				String propertyValue = (String) prop.getValue();
				FileUploadAppProperties.getInstance().addProperty(propertyName, propertyValue);
			}

		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

}
