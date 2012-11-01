package com.dominantcolors;

import android.app.Application;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class DominantColorsApp extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
		.threadPoolSize(3)
		.threadPriority(Thread.NORM_PRIORITY - 2)
		.memoryCacheSize(2 * 1024 * 1024) // 2 Mb
		.denyCacheImageMultipleSizesInMemory()
		.discCacheFileNameGenerator(new Md5FileNameGenerator())
		.enableLogging() // Not necessary in common
		.build();
		// Initialize ImageLoader with configuration.
		ImageLoader.getInstance().init(config);
	}

}